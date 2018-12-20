package ru.vood.infrastructure.contextInitializer

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import java.lang.IllegalStateException

class ProfileSentinelApplicationInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
     if (applicationContext.environment.activeProfiles.isEmpty())
         throw IllegalStateException("Не возможен запуск без профиля, необходимо указать его в свойстве spring.profiles.active")
    }
}