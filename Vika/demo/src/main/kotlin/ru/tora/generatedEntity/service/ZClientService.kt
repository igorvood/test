package ru.tora.generatedEntity.service;

import java.lang.Iterable;
import java.lang.Object;
import java.math.BigDecimal;
import kotlin.Unit;
import ru.tora.generatedEntity.entity.ZClientEntity;
import ru.vood.amdWeb.util.abstraction.RepositoryForView;


/* Интерфейс для таблицы БД - Клиенты */
interface ZClientService : RepositoryForView<ZClientEntity, BigDecimal>{
 fun saveAll (entity : MutableIterable<ZClientEntity>) : MutableIterable<ZClientEntity>

 fun deleteById (entity : BigDecimal) : Unit

 fun deleteAll (entity : MutableIterable<ZClientEntity>) : Unit

}
