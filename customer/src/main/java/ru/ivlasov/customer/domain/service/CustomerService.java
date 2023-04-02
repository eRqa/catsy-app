package ru.ivlasov.customer.domain.service;

import org.springframework.stereotype.Service;
import ru.ivlasov.customer.domain.model.Customer;
import ru.ivlasov.customer.persistence.CustomerRepository;
import ru.ivlasov.customer.view.request.CustomerRegistrationRequest;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void register(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = new Customer();
        customer.setFirstName(customerRegistrationRequest.firstName());
        customer.setLastName(customerRegistrationRequest.lastName());
        customer.setEmail(customerRegistrationRequest.email());
        customerRepository.save(customer);
        //todo check valid email in view layer
        //todo check email is not taken
    }
}
