package hello;

import org.springframework.data.jpa.repository.JpaRepository;

interface CustomerSecondRepository extends JpaRepository<CustomerSecond, Long> {

}
