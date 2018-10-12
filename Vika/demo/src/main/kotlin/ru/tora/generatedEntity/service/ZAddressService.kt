package ru.tora.generatedEntity.service;

import java.lang.Iterable;
import java.lang.Object;
import java.math.BigDecimal;
import kotlin.Unit;
import ru.tora.generatedEntity.entity.ZAddressEntity;
import ru.vood.amdWeb.util.abstraction.RepositoryForView;


/* Интерфейс для таблицы БД - Адреса */
interface ZAddressService : RepositoryForView<ZAddressEntity, BigDecimal>{
 fun saveAll (entity : MutableIterable<ZAddressEntity>) : MutableIterable<ZAddressEntity>

 fun deleteById (entity : BigDecimal) : Unit

 fun deleteAll (entity : MutableIterable<ZAddressEntity>) : Unit

}
