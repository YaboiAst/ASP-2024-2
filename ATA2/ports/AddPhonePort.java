package ATA2.ports;

import ATA2.adapters.IClientRepository;
import ATA2.domain.model.ClientImpl;
import ATA2.domain.model.PhoneEntryImpl;
import ATA2.domain.dto.AddPhoneEntryDTO;

public class AddPhonePort {
    private IClientRepository repository;

    public AddPhonePort(IClientRepository repository) {
        this.repository = repository;
    }

    public void execute(AddPhoneEntryDTO dto)
    {
        ClientImpl client = repository.findById(dto.clientId);
        if (client == null)
            throw new Error("Client not found");

        PhoneEntryImpl newEntry= new PhoneEntryImpl(dto.phoneId, dto.phoneType, dto.phoneNumber);
        client.addPhoneEntry(newEntry);

        repository.save(client);
    }
}
