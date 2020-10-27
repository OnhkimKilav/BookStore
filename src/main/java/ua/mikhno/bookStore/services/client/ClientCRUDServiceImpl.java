package ua.mikhno.bookStore.services.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mikhno.bookStore.dao.client.ClientCRUDDaoImpl;
import ua.mikhno.bookStore.exception.IsEmptyBooksList;
import ua.mikhno.bookStore.models.Client;
import ua.mikhno.bookStore.services.ICRUDService;

import java.util.List;

@Service
public class ClientCRUDServiceImpl implements ICRUDService<Client> {

    private ClientCRUDDaoImpl clientCRUDDao;

    @Autowired
    public ClientCRUDServiceImpl(ClientCRUDDaoImpl clientCRUDDao) {
        this.clientCRUDDao = clientCRUDDao;
    }

    @Override
    public void create(Client client) throws Exception {
        clientCRUDDao.save(client);
    }

    @Override
    public List<Client> read() throws IsEmptyBooksList {
        return clientCRUDDao.findAll();
    }

    @Override
    public Client read(long id) {
        return clientCRUDDao.findById(id);
    }

    @Override
    public void update(Client client) {
        clientCRUDDao.update(client);
    }

    @Override
    public void delete(long id) {
        clientCRUDDao.delete(id);
    }
}
