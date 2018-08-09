package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }



    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public CommandLineRunner loadData(CustomerRepository repository) {
        return (args) -> {
            System.out.println(applicationContext);

            TypeCustomerRepository bean = applicationContext.getBean(TypeCustomerRepository.class);
            final TypeCustomer type_1 = bean.save(new TypeCustomer("type_1"));
            final TypeCustomer type_2 = bean.save(new TypeCustomer("type_2"));


            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer",type_1));
            repository.save(new Customer("Chloe", "O'Brian", type_2));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));
/*
            for (int i=0; i<100; i++){
                repository.save(new Customer("Jack_"+i, "Bauer_"+i));
            }
*/



            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
/*
            Customer customer = repository.findById(1L).get();
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");
*/

            // fetch customers by last name
            log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
            log.info("--------------------------------------------");
            for (Customer bauer : repository
                    .findByLastNameStartsWithIgnoreCase("Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
    }

}