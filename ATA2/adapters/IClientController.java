package ATA2.adapters;

import ATA2.domain.model.PhoneEntryImpl;

public interface IClientController {
    void addPhoneEntry(String clientId, String phoneId, PhoneEntryImpl.EntryType phoneType, String phoneNumber);
    void removePhoneEntry(String clientId, String phoneId);
}
