package ru.vood.infrastructureTest.entity;

import ru.vood.infrastructure.annotation.Tune;
import ru.vood.infrastructure.annotation.TuneCode;
import ru.vood.infrastructure.annotation.TuneDescription;
import ru.vood.infrastructure.annotation.TuneId;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Tune
public class TuneData {

    @TuneId
            @Id
    String id;

    @TuneCode
    String code;

    @TuneDescription
    String desc;
}
