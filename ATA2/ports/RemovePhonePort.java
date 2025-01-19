package ATA2.ports;

import ATA2.adapters.IClientRepository;
import ATA2.domain.model.ClientImpl;
import ATA2.domain.dto.RemovePhoneEntryDTO;

public class RemovePhonePort {
    private IClientRepository repository;

    public RemovePhonePort(IClientRepository repository) {
        this.repository = repository;
    }

    public void execute(RemovePhoneEntryDTO dto)
    {
        ClientImpl client = repository.findById(dto.clientId);
        if (client == null)
            throw new Error("Client not found");

        client.removePhoneEntry(dto.phoneId);

        repository.save(client);
    }
}
