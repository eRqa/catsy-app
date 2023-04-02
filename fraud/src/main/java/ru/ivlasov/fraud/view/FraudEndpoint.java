package ru.ivlasov.fraud.view;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ivlasov.fraud.domain.model.FraudCheckResponse;
import ru.ivlasov.fraud.domain.service.FraudCheckService;

@RestController
@RequestMapping("api/v1/fraud")
@RequiredArgsConstructor
public class FraudEndpoint {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") int customerId) {
        boolean isFraudulent = fraudCheckService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulent);
    }
}
