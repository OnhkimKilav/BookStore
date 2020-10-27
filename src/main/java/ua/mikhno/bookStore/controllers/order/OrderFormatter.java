package ua.mikhno.bookStore.controllers.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;
import ua.mikhno.bookStore.controllers.client.ClientCRUDControllerImpl;
import ua.mikhno.bookStore.models.Client;
import ua.mikhno.bookStore.models.Order;
import ua.mikhno.bookStore.services.client.ClientCRUDServiceImpl;

import java.text.ParseException;
import java.util.Locale;

@Controller
public class OrderFormatter implements Formatter<Client> {
    private ClientCRUDServiceImpl clientCRUDService;

    @Autowired
    public OrderFormatter(ClientCRUDServiceImpl clientCRUDService) {
        this.clientCRUDService = clientCRUDService;
    }

    public OrderFormatter() {
    }

    @Override
    public Client parse(String s, Locale locale) throws ParseException {
        if (s != null) {
            Client client = new Client();
            final long clientId = Long.parseLong(s);
            client = clientCRUDService.read(clientId);
            return client;
        }
        return null;
    }

    @Override
    public String print(Client client, Locale locale) {
        return (client != null ? client.getName() : "");
    }
}
