package ua.mikhno.bookStore.dao.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mikhno.bookStore.dao.ICRUDDAO;
import ua.mikhno.bookStore.models.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ClientCRUDDaoImpl implements ICRUDDAO<Client> {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * The method saves client to DB
     * @param client
     * @throws Exception
     */
    @Override
    public void save(Client client){
        entityManager.persist(client);
    }

    /**
     * The method finds all clients in
     * the DB and returns them
     * @return collection with clients
     */
    @Override
    public List<Client> findAll() {
        return entityManager.createQuery("SELECT a FROM Client a", Client.class).getResultList();
    }

    /**
     * The method finds client to DB by id
     * and returns it
     * @param id client
     * @return client
     */
    @Override
    public Client findById(long id) {
        Client client = entityManager.find(Client.class, id);
        return client;
    }

    /**
     * The method updates client
     * @param client to update
     */
    @Override
    public void update(Client client) {
        entityManager.merge(client);

    }

    /**
     * The method deletes client from DB by id
     * @param id client
     */
    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(Client.class, id));
    }
}
