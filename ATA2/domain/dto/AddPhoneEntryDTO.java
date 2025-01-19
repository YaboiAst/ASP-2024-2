package ATA2.domain.dto;

import ATA2.domain.model.PhoneEntryImpl;

public class AddPhoneEntryDTO {
    public String clientId;
    public String phoneId;
    public PhoneEntryImpl.EntryType phoneType;
    public String phoneNumber;

    public AddPhoneEntryDTO(String clientId, String phoneId, PhoneEntryImpl.EntryType phoneType, String phoneNumber) {
        this.clientId = clientId;
        this.phoneId = phoneId;
        this.phoneType = phoneType;
        this.phoneNumber = phoneNumber;
    }
}