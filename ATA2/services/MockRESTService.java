package ATA2.services;

import ATA2.adapters.IClientController;
import ATA2.adapters.IClientRepository;
import ATA2.domain.dto.AddPhoneEntryDTO;
import ATA2.domain.dto.RemovePhoneEntryDTO;
import ATA2.domain.model.PhoneEntryImpl;
import ATA2.ports.AddPhonePort;
import ATA2.ports.RemovePhonePort;

public class MockRESTService implements IClientController {

    IClientRepository repo;
    public MockRESTService(IClientRepository repo) {
        this.repo = repo;
    }

    @Override
    public void addPhoneEntry(String clientId, String phoneId, PhoneEntryImpl.EntryType phoneType, String phoneNumber) {
        AddPhonePort addService = new AddPhonePort(repo);
        addService.execute(new AddPhoneEntryDTO(clientId, phoneId, phoneType, phoneNumber));

        System.out.println("Client " + clientId + " new phone entry added successfully\n" +
                "Entry Info:\n" +
                " - ID: " + phoneId + "\n" +
                " - Type: " + phoneType.toString() + "\n" +
                " - Number: " + phoneNumber);
    }

    @Override
    public void removePhoneEntry(String clientId, String phoneId) {
        RemovePhonePort removeService = new RemovePhonePort(repo);
        removeService.execute(new RemovePhoneEntryDTO(clientId, phoneId));

        System.out.println("Phone " + phoneId + ", belonging to " + clientId + " removed successfully");
    }
}
