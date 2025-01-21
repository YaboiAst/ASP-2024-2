package ATA2.ports;

import ATA2.adapters.IClientRepository;
import ATA2.domain.model.ClientImpl;
import ATA2.domain.model.PhoneEntryImpl;
import ATA2.domain.dto.AddPhoneEntryDTO;

import java.util.Optional;

public class AddPhonePort {
    private IClientRepository repository;

    public AddPhonePort(IClientRepository repository) {
        this.repository = repository;
    }

    public void execute(AddPhoneEntryDTO dto)
    {
        Optional<ClientImpl> clientQuery = repository.findById(dto.clientId);
        if (clientQuery.isEmpty())
            throw new Error("Client not found");
        ClientImpl client = clientQuery.get();

        PhoneEntryImpl newEntry= new PhoneEntryImpl(dto.phoneId, dto.phoneType, dto.phoneNumber);
        client.addPhoneEntry(newEntry);

        repository.save(client);
    }
}
