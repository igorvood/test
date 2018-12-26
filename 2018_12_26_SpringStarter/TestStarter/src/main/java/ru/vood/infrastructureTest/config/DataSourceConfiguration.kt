package ru.vood.infrastructureTest.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.context.annotation.PropertySource

/*
@Configuration
@PropertySource("classpath:db.properties")
*/
open class DataSourceConfiguration {

    /*@Value("\${spring.datasource.driver-class}")
    lateinit var driverClassName: String

    private fun createDataSource(usernameDev: String, urlDev: String, driverClassName: String, passwordDev: String): HikariDataSource {
        println("============================== $urlDev ======================================")
        val hikariConfig = HikariConfig()
        hikariConfig.username = usernameDev
        hikariConfig.jdbcUrl = urlDev
        hikariConfig.driverClassName = driverClassName
        hikariConfig.password = passwordDev
        return HikariDataSource(hikariConfig)
    }

    //================================= DEV 144 ===========================================
    @Value("\${DEV144.spring.datasource.url}")
    lateinit var urlDev144: String

    @Value("\${DEV144.spring.datasource.username}")
    lateinit var usernameDev144: String

    @Value("\${DEV144.spring.datasource.password}")
    lateinit var passwordDev144: String

    @Bean("dataSource")
    @Profile("DEV144")
    open fun dataSourceDev144() = createDataSource(usernameDev144, urlDev144, driverClassName, passwordDev144)

    //================================= DEV 216 ===========================================
    @Value("\${DEV216.spring.datasource.url}")
    lateinit var urlDev216: String

    @Value("\${DEV216.spring.datasource.username}")
    lateinit var usernameDev216: String

    @Value("\${DEV216.spring.datasource.password}")
    lateinit var passwordDev216: String

    @Bean("dataSource")
    @Profile("DEV216")
    open fun dataSourceDev216() = createDataSource(usernameDev216, urlDev216, driverClassName, passwordDev216)

    //================================= PROD ===========================================
    @Value("\${PROD.spring.datasource.url}")
    lateinit var urlDevPROD: String

    @Value("\${PROD.spring.datasource.username}")
    lateinit var usernameDevPROD: String

    @Value("\${PROD.spring.datasource.password}")
    lateinit var passwordDevPROD: String

    @Bean("dataSource")
    @Profile("PROD")
    open fun dataSourceDevPROD() = createDataSource(usernameDevPROD, urlDevPROD, driverClassName, passwordDevPROD)
*/
}