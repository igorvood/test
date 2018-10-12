package ru.tora.generatedEntity.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import ru.vood.amdWeb.util.EntityInterface;


@Entity
@Table(name="Z_ADDRESS", schema="VOOD")
@Inheritance(strategy=InheritanceType.JOINED)
/* Сущность для таблицы БД - Адреса */
open class ZAddressEntity: EntityInterface {
/*Уникальный Идентификатор*/
@Id
@GenericGenerator(name="seqId", strategy="ru.vood.admplugin.infrastructure.entity.GeneratorId")
@GeneratedValue(generator="seqId")
private lateinit var id :  BigDecimal

/*Наименование поля - Город*/
@Column(name ="CITY", nullable =true)
private lateinit var city :  String 

/*Наименование поля - Улица*/
@Column(name ="STREET", nullable =true)
private lateinit var street :  String 

/*Наименование поля - Идентификатор коллекции*/
@Column(name ="COLLECTIONID", nullable =false)
private lateinit var collectionid :  BigDecimal 

/*Наименование поля - Тип адреса*/
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ADRESES_TYPE", referencedColumnName="ID")
private lateinit var adresesType :  ZTypeAdressEntity 


override fun getId() = id
}
