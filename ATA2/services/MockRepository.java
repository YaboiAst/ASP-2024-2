package ATA2.services;

import ATA2.adapters.IClientRepository;
import ATA2.domain.model.ClientImpl;
import ATA2.domain.model.PhoneEntryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockRepository implements IClientRepository {
    List<ClientImpl> memoryDb;

    public MockRepository() {
        memoryDb = new ArrayList<>();
    }
    public MockRepository(List<ClientImpl> memoryDb) {
        this.memoryDb = memoryDb;
    }

    @Override
    public Optional<ClientImpl> findById(String id) {
        return memoryDb.stream().filter(c -> c.id.equals(id)).findFirst();
    }

    @Override
    public void save(ClientImpl client) {
        Optional<ClientImpl> preQuery = findById(client.id);
        if (preQuery.isPresent())
        {
            int idx = memoryDb.indexOf(preQuery.get());
            memoryDb.set(idx, client);
        }
        else
        {
            memoryDb.add(client);
        }
    }

    @Override
    public void printDatabase()
    {
        StringBuilder out = new StringBuilder();
        for (ClientImpl cli : memoryDb)
        {
            out.append("Client: ").append(cli.id).append("\n");
            for (PhoneEntryImpl entry : cli.entryList)
            {
                out.append(" - Phone: ").append(entry.id).append(" || Nº: ").append(entry.number).append(" || Type: ").append(entry.type.toString()).append("\n");
            }
        }

        System.out.println("\n\n" + out);
    }
}
