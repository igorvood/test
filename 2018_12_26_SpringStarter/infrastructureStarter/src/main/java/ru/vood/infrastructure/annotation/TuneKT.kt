package ru.vood.infrastructure.annotation

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
annotation class TuneKT(val name: String = "")
