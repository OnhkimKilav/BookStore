package ua.mikhno.bookStore.controllers.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.mikhno.bookStore.controllers.ICRUDController;
import ua.mikhno.bookStore.exception.IsEmptyBooksList;
import ua.mikhno.bookStore.models.Order;
import ua.mikhno.bookStore.services.client.ClientCRUDServiceImpl;
import ua.mikhno.bookStore.services.order.OrderCRUDServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderCRUDControllerImpl implements ICRUDController<Order> {

    private OrderCRUDServiceImpl orderCRUDService;
    private ClientCRUDServiceImpl clientCRUDService;

    @Autowired
    public OrderCRUDControllerImpl(OrderCRUDServiceImpl orderCRUDService, ClientCRUDServiceImpl clientCRUDService) {
        this.orderCRUDService = orderCRUDService;
        this.clientCRUDService = clientCRUDService;
    }

    @Override
    @PostMapping()
    public String create(@ModelAttribute("order") Order order,
                         Model model) throws Exception {
        orderCRUDService.create(order);
        return "redirect:/orders";
    }

    @GetMapping("/create")
    private String callFormCreateBook(@ModelAttribute("order") Order order, Model model) {
        try {
            model.addAttribute("clientsOrder", clientCRUDService.read());
        } catch (IsEmptyBooksList isEmptyBooksList) {
            isEmptyBooksList.printStackTrace();
        }
        model.addAttribute("orders", Order.class);
        return "order/create";
    }

    @Override
    @GetMapping()
    public String read(Model model) throws IsEmptyBooksList {
        model.addAttribute("orders", orderCRUDService.read());
        return "order/read";
    }

    @Override
    @GetMapping("/{id}")
    public String read(@PathVariable long id, Model model) {
        model.addAttribute(orderCRUDService.read(id));
        return "order/order";
    }

    @Override
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid Order order, BindingResult result, Model model) throws IsEmptyBooksList {
        if (result.hasErrors()) {
            order.setId(id);
            return "order/update";
        }

        orderCRUDService.update(order);
        model.addAttribute("order", orderCRUDService.read());
        return "redirect:/orders/{id}";
    }

    @Override
    @PostMapping("/{id}")
    public String delete(@PathVariable long id) {
        orderCRUDService.delete(id);
        return "redirect:/orders";
    }


    @GetMapping("/edit/{id}")
    private String showUpdateForm(@PathVariable("id") long id, Model model) {
        Order order = orderCRUDService.read(id);
        model.addAttribute("order", order);
        return "order/update";
    }
}
