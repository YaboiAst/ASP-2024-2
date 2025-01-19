package ATA2.domain.dto;

public class RemovePhoneEntryDTO {
    public String clientId;
    public String phoneId;

    public RemovePhoneEntryDTO(String clientId, String phoneId) {
        this.clientId = clientId;
        this.phoneId = phoneId;
    }
}
