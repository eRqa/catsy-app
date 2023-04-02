package ru.ivlasov.customer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivlasov.customer.domain.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
