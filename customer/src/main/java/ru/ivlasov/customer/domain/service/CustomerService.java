package ru.ivlasov.customer.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.ivlasov.customer.domain.model.Customer;
import ru.ivlasov.customer.domain.model.FraudCheckResponse;
import ru.ivlasov.customer.persistence.CustomerRepository;
import ru.ivlasov.customer.view.request.CustomerRegistrationRequest;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {

    public void register(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = new Customer();
        customer.setFirstName(customerRegistrationRequest.firstName());
        customer.setLastName(customerRegistrationRequest.lastName());
        customer.setEmail(customerRegistrationRequest.email());
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse response = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if (response.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        //todo check valid email in view layer
        //todo check email is not taken
        //todo check if fraudster
        //todo send notification
    }
}
