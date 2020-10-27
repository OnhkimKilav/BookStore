/*
package ua.mikhno.bookStore.dao.order;

import com.dao.client.ClientCRUDDaoImpl;
import com.model.Client;
import com.model.Order;
import com.model.Status;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;


public class OrderCRUDDaoImplTest {
    private OrderCRUDDaoImpl orderCRUDDao = new OrderCRUDDaoImpl();
    private ClientCRUDDaoImpl clientCRUDDao = new ClientCRUDDaoImpl();

    @Test
    @Transactional
    @Rollback
    public void save() throws Exception {
        Client client = clientCRUDDao.findById(30000001);
        Order order = new Order(
                new Date(),
                Status.NEW,
                "ул. Артема 20",
                1,
                350,
                client);

        orderCRUDDao.save(order);
        ArrayList<Order> ordersDB = orderCRUDDao.findAll();
        Assert.assertEquals(1, ordersDB.size());
        Assert.assertEquals(order.getDeliveryAddress(), ordersDB.get(0).getDeliveryAddress());

    }

    @Test
    @Transactional
    @Rollback
    public void findAll() {
        ArrayList<Order> orders = orderCRUDDao.findAll();
        Assert.assertEquals(0, orders.size());
    }

    @Test
    @Transactional
    @Rollback
    public void findById() {
        Order order = orderCRUDDao.findById(410000001);
        Assert.assertEquals(410000001, order.getId());
    }

    @Test
    @Transactional
    @Rollback
    public void update() {
        Order orderOld = orderCRUDDao.findById(200000001);
        orderOld.setDeliveryAddress("бул. Пушкина 6а");
        orderCRUDDao.update(orderOld);
        Order orderNew = orderCRUDDao.findById(200000001);
        Assert.assertEquals(orderOld.getDeliveryAddress(), orderNew.getDeliveryAddress());
    }

    @Test
    public void delete() {
        orderCRUDDao.delete(200000001);
        ArrayList<Order> orders = orderCRUDDao.findAll();
        Assert.assertEquals(new ArrayList<>(), orders);
    }
}*/
