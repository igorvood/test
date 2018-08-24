package ru.vood.test;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

interface TypeCustomerRepository extends JpaRepository<TypeCustomer, BigDecimal> {
}
