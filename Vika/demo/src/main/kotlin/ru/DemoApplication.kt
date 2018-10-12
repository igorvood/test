package ru

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("ru.*")
class DemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java)
}
