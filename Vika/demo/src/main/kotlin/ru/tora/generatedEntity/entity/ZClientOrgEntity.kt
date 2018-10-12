package ru.tora.generatedEntity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Z_CLIENT_ORG", schema="VOOD")
/* Сущность для таблицы БД - Юридические лица */
open class ZClientOrgEntity : ru.tora.generatedEntity.entity.ZClientEntity(){
/*Наименование поля - КПП*/
@Column(name ="KPP", nullable =true)
private lateinit var kpp :  String 

}
