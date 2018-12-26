package ru.vood.infrastructure.contextInitializer

import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import ru.vood.infrastructure.annotation.Tune
import ru.vood.infrastructure.annotation.TuneCode
import ru.vood.infrastructure.annotation.TuneDescription
import ru.vood.infrastructure.annotation.TuneId
import ru.vood.infrastructure.data.TuneData

class TuneApplicationContextInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    private val log = LoggerFactory.getLogger(TuneApplicationContextInitializer::class.java)

    var mapTune = HashMap<Class<*>, TuneData>()

    override fun initialize(applicationContext: ConfigurableApplicationContext) {
        log.debug("Поиск классов-настроек.")
        val reflections = Reflections("ru", SubTypesScanner(false))
        val allTypes = reflections.allTypes
        val listClass = allTypes.map { s -> Class.forName(s) }
        val classAnnotatedByTune = getClassAnnotatedBy(listClass, Tune::class.java)
        val listOf = listOf(TuneId::class.java, TuneCode::class.java, TuneDescription::class.java)

        for (cl in classAnnotatedByTune) {
            val declaredFields = cl.declaredFields
            val tuneData = TuneData()
            tuneData.cl = cl

            for (f in declaredFields) {
                val checkedAnnotation = f.annotations.filter { annotation -> listOf.contains(annotation.javaClass) }
                for (ca in checkedAnnotation) {
                    if (tuneData.id == null && ca is TuneId)
                        tuneData.id = f
                    if (tuneData.code == null && ca is TuneId)
                        tuneData.code = f
                    if (tuneData.description == null && ca is TuneDescription)
                        tuneData.description = f
                }
            }
            if (tuneData.cl != null && tuneData.id != null && tuneData.code != null && tuneData.description != null)
                mapTune.put(tuneData.cl!!, tuneData)
            else
                log.warn("- Класс ${tuneData.cl.toString()} не полностью аннтирован.")
        }

        if (log.isDebugEnabled)
            mapTune.forEach { t -> log.debug(("+ Успешно аннторированный класс ${t.key} ")) }

        val clazz = classAnnotatedByTune[0]

        println(clazz)
        val annotations = listClass[0].annotations

        val contains = annotations.map { a -> a::class.java }

        //annotations.
        //allTypes.forEach { s -> println(s) }
        println(contains)
        println(Tune::class.java)
        println("===============================")


        val forName = Class.forName(allTypes.first())
        println(forName)

    }

    inline fun getClassAnnotatedBy(listClass: List<Class<*>>, element: Class<*>) =
            listClass
                    .filter { cl ->
                        cl.annotations
                                .map { ann -> ann.annotationClass.java }
                                .contains(element)
                    }


}