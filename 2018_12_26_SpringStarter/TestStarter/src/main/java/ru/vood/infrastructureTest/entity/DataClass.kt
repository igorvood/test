package ru.vood.infrastructureTest.entity

import ru.vood.infrastructure.annotation.*
import javax.persistence.Entity
import javax.persistence.Id

@Tune
@Entity
class DataClass {
    @TuneId
    @Id
    lateinit var id: Integer

    @TuneCode
    lateinit var code: String

    @TuneDescription
    lateinit var description: String

}