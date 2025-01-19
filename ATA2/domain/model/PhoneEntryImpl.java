package ATA2.domain.model;

public class PhoneEntryImpl {
    public enum EntryType {
        Residencial,
        Comercial,
        Celular
    }

    public String id;
    public EntryType type;
    public String number;

    public PhoneEntryImpl(String id, EntryType type, String number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }
}
