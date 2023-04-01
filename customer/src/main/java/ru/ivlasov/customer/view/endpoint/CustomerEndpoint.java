package ru.ivlasov.customer.view.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ivlasov.customer.domain.service.CustomerService;
import ru.ivlasov.customer.view.request.CustomerRegistrationRequest;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerEndpoint(CustomerService customerService) {

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registration {}", customerRegistrationRequest);
        customerService.register(customerRegistrationRequest);
    }
}
