package ATA2.adapters;

import ATA2.domain.model.ClientImpl;

public interface IClientRepository {
    ClientImpl findById(String id);
    void save(ClientImpl client);
}
