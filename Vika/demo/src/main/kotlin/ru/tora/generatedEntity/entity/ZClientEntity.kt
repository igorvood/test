package ru.tora.generatedEntity.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import ru.vood.amdWeb.util.EntityInterface;


@Entity
@Table(name="Z_CLIENT", schema="VOOD")
@Inheritance(strategy=InheritanceType.JOINED)
/* Сущность для таблицы БД - Клиенты */
open class ZClientEntity: EntityInterface {
/*Уникальный Идентификатор*/
@Id
@GenericGenerator(name="seqId", strategy="ru.vood.admplugin.infrastructure.entity.GeneratorId")
@GeneratedValue(generator="seqId")
private lateinit var id :  BigDecimal

/*Наименование поля - ФИО*/
@Column(name ="NAME", nullable =true)
private lateinit var name :  String 

/*Наименование поля - Дата рождения*/
@Column(name ="DATE_BIRTH", nullable =true)
@Temporal(TemporalType.DATE)
private lateinit var dateBirth :  Date 

/*Наименование поля - Адреса*/
@Column(name ="ADRESESS", nullable =true)
private lateinit var adresess :  BigDecimal 


override fun getId() = id
}
