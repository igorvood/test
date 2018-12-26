package ru.vood.infrastructureTest

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
open class ApplicationBoot {
}

fun main(args: Array<String>) {
    SpringApplication.run(ApplicationBoot::class.java, *args)
}