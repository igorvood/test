package ru

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("ru.*")
class DemoApplication {

/*
    private  log = LoggerFactory.getLogger(DemoApplication::class.);
    @Autowired
    private applicationContext:ApplicationContext
*/

}

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java)
//    runApplication<DemoApplication>(*args)
}
