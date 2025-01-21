package ATA2.ports;

import ATA2.adapters.IClientRepository;
import ATA2.domain.model.ClientImpl;
import ATA2.domain.dto.RemovePhoneEntryDTO;

import java.util.Optional;

public class RemovePhonePort {
    private IClientRepository repository;

    public RemovePhonePort(IClientRepository repository) {
        this.repository = repository;
    }

    public void execute(RemovePhoneEntryDTO dto)
    {
        Optional<ClientImpl> clientQuery = repository.findById(dto.clientId);
        if (clientQuery.isEmpty())
            throw new Error("Client not found");

        ClientImpl client = clientQuery.get();
        client.removePhoneEntry(dto.phoneId);

        repository.save(client);
    }
}
