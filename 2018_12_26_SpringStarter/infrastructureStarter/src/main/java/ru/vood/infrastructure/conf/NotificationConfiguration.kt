package ru.vood.infrastructure.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Profile
import ru.vood.infrastructure.listener.ProdRunNotificationListener
import ru.vood.infrastructure.properties.NotificationProperties

class NotificationConfiguration {
    @Bean
    @Profile("PROD")
    fun prodRunNotificationListener() = ProdRunNotificationListener()

    @Bean
    @Profile("PROD")
    fun notificationProperties() = NotificationProperties()

}