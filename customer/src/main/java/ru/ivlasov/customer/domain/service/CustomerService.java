package ru.ivlasov.customer.domain.service;

import org.springframework.stereotype.Service;
import ru.ivlasov.customer.domain.model.Customer;
import ru.ivlasov.customer.view.request.CustomerRegistrationRequest;

@Service
public record CustomerService() {
    public void register(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = new Customer();
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setEmail(customer.getEmail());
        //todo check valid email in view layer
        //todo check email is not taken
        //todo persist customer
    }
}
