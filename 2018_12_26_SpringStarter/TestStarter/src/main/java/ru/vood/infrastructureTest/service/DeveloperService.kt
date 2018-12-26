package ru.vood.infrastructureTest.service

import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
@Profile("DEV")
class DeveloperService {
    @Scheduled(cron = "1/1 * * * * ?")
    fun doWork() {
        val date = LocalDateTime.now()
        println(date.toString() + " Developer Profile")
    }
}