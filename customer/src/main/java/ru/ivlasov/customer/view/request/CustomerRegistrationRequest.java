package ru.ivlasov.customer.view.request;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
