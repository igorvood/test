package ru.tora.generatedEntity.entity;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import ru.tora.generatedEntity.entity.ZAddressEntity;
import ru.vood.amdWeb.util.EntityInterface;


@Entity
@Table(name="Z_TYPE_ADRESS", schema="VOOD")
@Inheritance(strategy=InheritanceType.JOINED)
/* Сущность для таблицы БД - Типы адресов */
open class ZTypeAdressEntity: EntityInterface {
/*Уникальный Идентификатор*/
@Id
@GenericGenerator(name="seqId", strategy="ru.vood.admplugin.infrastructure.entity.GeneratorId")
@GeneratedValue(generator="seqId")
private lateinit var id :  BigDecimal

/*Список объектов найденных по обратной ссылке на текущую сущность
 Класс address, поле - ADRESES_TYPE
 Адреса - Тип адреса */
@OneToMany(targetEntity=ZAddressEntity::class    )
@LazyCollection(LazyCollectionOption.TRUE)
@JoinColumn(name="ADRESES_TYPE")
lateinit var addressList : List<ZAddressEntity>


override fun getId() = id
}
