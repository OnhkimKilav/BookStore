/*
package ua.mikhno.bookStore.dao.client;

import ua.mikhno.bookStore.models.Client;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public class ClientCRUDDaoImplTest {

    private ClientCRUDDaoImpl crud = new ClientCRUDDaoImpl();

    @Test
    @Transactional
    @Rollback()
    public void save() throws Exception {
        Client client = new Client(
                "Oleg",
                23,
                "+3(8045)699-76-54",
                "oleg@gmail.com",
                null);

        crud.save(client);
        ArrayList<Client> clientDB = crud.findAll();
        Assert.assertEquals(1, clientDB.size());
        Assert.assertEquals(client.getEmail(), clientDB.get(0).getEmail());
    }

    @Test
    @Transactional
    @Rollback
    public void findAll() {
        ArrayList<Client> clients = crud.findAll();
        Assert.assertEquals(1, clients.size());
    }

    @Test
    @Transactional
    @Rollback
    public void findById() {
        Client client = crud.findById(30000001);
        Assert.assertEquals(30000001, client.getId());
    }

    @Test
    @Transactional
    @Rollback
    public void update() {
        Client client = crud.findById(1);
        client.setAge(40);

        crud.update(client);

        ArrayList<Client> clientsDB = crud.findAll();

        Assert.assertEquals(client.getAge(), clientsDB.get(0).getAge());
    }

    @Test
    @Transactional
    @Rollback
    public void delete() {
        crud.delete(1);
        Assert.assertEquals(new ArrayList<>(),crud.findAll());
    }
}*/
