package hello;

import org.springframework.data.jpa.repository.JpaRepository;

interface TypeCustomerRepository extends JpaRepository<TypeCustomer, Long> {
}
