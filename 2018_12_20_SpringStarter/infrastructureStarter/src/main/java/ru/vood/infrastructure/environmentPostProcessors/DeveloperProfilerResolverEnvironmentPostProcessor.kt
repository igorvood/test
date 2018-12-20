package ru.vood.infrastructure.environmentPostProcessors

import org.springframework.boot.SpringApplication
import org.springframework.boot.env.EnvironmentPostProcessor
import org.springframework.core.env.ConfigurableEnvironment

class DeveloperProfilerResolverEnvironmentPostProcessor : EnvironmentPostProcessor {

    override fun postProcessEnvironment(environment: ConfigurableEnvironment?, application: SpringApplication?) {
        if (environment != null && environment.activeProfiles.isEmpty()) {
            val get = System.getenv()["OS"]
            if (get != null && get.contains("Windows")) environment.addActiveProfile("DEV")
        }
    }
}