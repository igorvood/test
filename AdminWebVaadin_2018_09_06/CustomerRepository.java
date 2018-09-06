package ru.vood.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, BigDecimal> {

    List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);

    @Override
    Customer getOne(BigDecimal bigDecimal);

    @Override
    Optional<Customer> findById(BigDecimal bigDecimal);
}