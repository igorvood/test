package ru.vood.infrastructure.properties

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "prod")
class NotificationProperties {

    lateinit var mails: ArrayList<String>
}