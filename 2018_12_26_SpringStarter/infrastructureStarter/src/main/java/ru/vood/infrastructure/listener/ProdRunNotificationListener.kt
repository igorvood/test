package ru.vood.infrastructure.listener

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import ru.vood.infrastructure.properties.NotificationProperties

class ProdRunNotificationListener : ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    lateinit var notificationProperties: NotificationProperties

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        notificationProperties.mails.forEach(::println)
    }
}