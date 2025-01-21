package ATA2;

import ATA2.adapters.IClientController;
import ATA2.adapters.IClientRepository;
import ATA2.domain.model.ClientImpl;
import ATA2.domain.model.PhoneEntryImpl;
import ATA2.services.MockRESTService;
import ATA2.services.MockRepository;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        IClientRepository outService = InitDatabase();
        IClientController inService = new MockRESTService(outService);

        // Inserção normal
        inService.addPhoneEntry("CLI002", "PN01", PhoneEntryImpl.EntryType.Comercial, "3388-3388");
        outService.printDatabase();

        // Inserção com client que não existe
        //inService.addPhoneEntry("CLI010", "PN01", PhoneEntryImpl.EntryType.Comercial, "3388-3388");

        // Remoção normal
        inService.removePhoneEntry("CLI001", "PN01");
        outService.printDatabase();
    }

    public static IClientRepository InitDatabase()
    {
        ClientImpl cli0 = new ClientImpl("CLI000", "Marcos");
        cli0.addPhoneEntry("PN00", PhoneEntryImpl.EntryType.Celular, "99999-1234");

        ClientImpl cli1 = new ClientImpl("CLI001", "Vitor");
        cli1.addPhoneEntry("PN00", PhoneEntryImpl.EntryType.Celular, "91234-5678");
        cli1.addPhoneEntry("PN01", PhoneEntryImpl.EntryType.Residencial, "4002-8922");

        ClientImpl cli2 = new ClientImpl("CLI002", "Lucas");
        ClientImpl cli3 = new ClientImpl("CLI003", "Mates");
        ClientImpl cli4 = new ClientImpl("CLI004", "Ana");

        List<ClientImpl> tempData = new ArrayList<>();
        tempData.add(cli0); tempData.add(cli1); tempData.add(cli2);
        tempData.add(cli3); tempData.add(cli4);

        return new MockRepository(tempData);
    }
}
