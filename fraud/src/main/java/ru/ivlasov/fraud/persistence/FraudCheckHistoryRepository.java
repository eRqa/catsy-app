package ru.ivlasov.fraud.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivlasov.fraud.domain.model.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
