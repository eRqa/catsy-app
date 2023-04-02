package ru.ivlasov.fraud.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ivlasov.fraud.domain.model.FraudCheckHistory;
import ru.ivlasov.fraud.persistence.FraudCheckHistoryRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(int customerId) {
        FraudCheckHistory fraudCheckHistory = new FraudCheckHistory();
        fraudCheckHistory.setCustomerId(customerId);
        fraudCheckHistory.setCreatedAt(LocalDateTime.now());
        fraudCheckHistory.setFraudster(false);
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }

}
