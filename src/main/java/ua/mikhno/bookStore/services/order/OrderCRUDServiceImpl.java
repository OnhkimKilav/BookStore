package ua.mikhno.bookStore.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mikhno.bookStore.dao.order.OrderCRUDDaoImpl;
import ua.mikhno.bookStore.exception.IsEmptyBooksList;
import ua.mikhno.bookStore.models.Order;
import ua.mikhno.bookStore.services.ICRUDService;

import java.util.List;

@Service
public class OrderCRUDServiceImpl implements ICRUDService<Order> {

    private OrderCRUDDaoImpl orderCRUDDao;

    @Autowired
    public OrderCRUDServiceImpl(OrderCRUDDaoImpl orderCRUDDao) {
        this.orderCRUDDao = orderCRUDDao;
    }

    @Override
    public void create(Order order) throws Exception {
        orderCRUDDao.save(order);
    }

    @Override
    public List<Order> read() throws IsEmptyBooksList {
        return orderCRUDDao.findAll();
    }

    @Override
    public Order read(long id) {
        return orderCRUDDao.findById(id);
    }

    @Override
    public void update(Order order) {
        orderCRUDDao.update(order);
    }

    @Override
    public void delete(long id) {
        orderCRUDDao.delete(id);
    }
}
