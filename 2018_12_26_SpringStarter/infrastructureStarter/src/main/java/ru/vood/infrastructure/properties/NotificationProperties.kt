package ru.vood.infrastructure.properties

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "qqq")
data class NotificationProperties(var mails: ArrayList<String>) {
    //class NotificationProperties/*(var mails: ArrayList<String>) */{
    constructor() : this(ArrayList<String>())

//    lateinit var mails1: ArrayList<String>


}