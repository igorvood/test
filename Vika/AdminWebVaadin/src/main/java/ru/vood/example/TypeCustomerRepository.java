package ru.vood.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface TypeCustomerRepository extends JpaRepository<TypeCustomer, BigDecimal> {
}
