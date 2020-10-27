package ua.mikhno.bookStore.controllers.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.mikhno.bookStore.controllers.ICRUDController;
import ua.mikhno.bookStore.exception.IsEmptyBooksList;
import ua.mikhno.bookStore.models.Client;
import ua.mikhno.bookStore.models.Order;
import ua.mikhno.bookStore.services.client.ClientCRUDServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
public class ClientCRUDControllerImpl implements ICRUDController<Client> {

    private ClientCRUDServiceImpl clientCRUDService;

    @Autowired
    public ClientCRUDControllerImpl(ClientCRUDServiceImpl clientCRUDService) {
        this.clientCRUDService = clientCRUDService;
    }

    @Override
    @PostMapping()
    public String create(@ModelAttribute("client") Client client, Model model) throws Exception {
        clientCRUDService.create(client);
        return "redirect:/clients";
    }

    @Override
    @GetMapping()
    public String read(Model model) throws IsEmptyBooksList {
        model.addAttribute("clients", clientCRUDService.read());
        return "client/read";
    }

    @Override
    @GetMapping("/{id}")
    public String read(@PathVariable long id, Model model) {
        model.addAttribute(clientCRUDService.read(id));
        return "client/client";
    }

    @Override
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid Client client, BindingResult result, Model model) throws IsEmptyBooksList {
        if (result.hasErrors()) {
            client.setId(id);
            return "client/update";
        }

        clientCRUDService.update(client);
        model.addAttribute("client", clientCRUDService.read());
        return "redirect:/clients/{id}";
    }

    @Override
    @PostMapping("/{id}")
    public String delete(@PathVariable long id) {
        clientCRUDService.delete(id);
        return "redirect:/clients";
    }

    @GetMapping("/create")
    private String callFormCreateClient(@ModelAttribute("client") Client client) {
        return "client/create";
    }

    @GetMapping("/edit/{id}")
    private String showUpdateForm(@PathVariable("id") long id, Model model) {
        Client client = clientCRUDService.read(id);
        model.addAttribute("client", client);
        return "client/update";
    }
}
