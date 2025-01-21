package ATA2.adapters;

import ATA2.domain.model.ClientImpl;

import java.util.Optional;

public interface IClientRepository {
    Optional<ClientImpl> findById(String id);
    void save(ClientImpl client);
    void printDatabase();
}
