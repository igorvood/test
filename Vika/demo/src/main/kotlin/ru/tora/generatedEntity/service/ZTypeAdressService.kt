package ru.tora.generatedEntity.service;

import java.lang.Iterable;
import java.lang.Object;
import java.math.BigDecimal;
import kotlin.Unit;
import ru.tora.generatedEntity.entity.ZTypeAdressEntity;
import ru.vood.amdWeb.util.abstraction.RepositoryForView;


/* Интерфейс для таблицы БД - Типы адресов */
interface ZTypeAdressService : RepositoryForView<ZTypeAdressEntity, BigDecimal>{
 fun saveAll (entity : MutableIterable<ZTypeAdressEntity>) : MutableIterable<ZTypeAdressEntity>

 fun deleteById (entity : BigDecimal) : Unit

 fun deleteAll (entity : MutableIterable<ZTypeAdressEntity>) : Unit

}
