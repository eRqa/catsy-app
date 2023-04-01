package ru.ivlasov.customer.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
