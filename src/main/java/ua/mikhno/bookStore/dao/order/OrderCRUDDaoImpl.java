package ua.mikhno.bookStore.dao.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mikhno.bookStore.dao.ICRUDDAO;
import ua.mikhno.bookStore.models.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderCRUDDaoImpl implements ICRUDDAO<Order> {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public List<Order> findAll() {
        return entityManager.createQuery("SELECT a FROM Order a", Order.class).getResultList();
    }

    @Override
    public Order findById(long id) {
        Order order = entityManager.find(Order.class, id);
        return order;
    }

    @Override
    public void update(Order order) {
        entityManager.merge(order);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(Order.class, id));
    }
}
