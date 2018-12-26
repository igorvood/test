package ru.vood.infrastructure.contextInitializer

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import ru.vood.infrastructure.consts.Profile

class ProfileSentinelApplicationInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        val activeProfiles = applicationContext.environment.activeProfiles
        val reduce = Profile.values().map { profile -> profile.name }.reduce({ s1, s2 -> "$s1, $s2" })
        if (activeProfiles.isEmpty()) {
            throw IllegalStateException("Не возможен запуск без профиля, необходимо указать его в свойстве spring.profiles.active\n" +
                    "Возможные значения $reduce")
        } else {
            var contains = false
            for (ap in activeProfiles) {
                contains = contains || Profile.values().map { pr -> pr.name }.contains(ap)
                if (contains) break
            }
            if (!contains)
                throw IllegalStateException("В качестве профиля указано не допустимое значение, необходимо указать его в свойстве spring.profiles.active\n" +
                        "Возможные значения $reduce")
        }
    }
}