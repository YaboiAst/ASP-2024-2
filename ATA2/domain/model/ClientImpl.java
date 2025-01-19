package ATA2.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ClientImpl {
    public String id;
    public String name;
    public List<PhoneEntryImpl> entryList;

    public ClientImpl(String id, String name) {
        this.id = id;
        this.name = name;
        this.entryList = new ArrayList<>();
    }

    public void addPhoneEntry(String id, PhoneEntryImpl.EntryType type, String number) {
        this.entryList.add(new PhoneEntryImpl(id, type, number));
    }
    public void addPhoneEntry(PhoneEntryImpl entry) {
        this.entryList.add(entry);
    }

    public void removePhoneEntry(String phoneId)
    {
        for(PhoneEntryImpl entry : entryList)
        {
            if (entry.id.equals(phoneId))
            {
                entryList.remove(entry);
                return;
            }
        }
    }
    public void removePhoneEntry(PhoneEntryImpl entry) {
        this.entryList.remove(entry);
    }
}
