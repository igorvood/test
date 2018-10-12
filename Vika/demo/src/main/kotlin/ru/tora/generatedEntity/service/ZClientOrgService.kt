package ru.tora.generatedEntity.service;

import java.lang.Iterable;
import java.lang.Object;
import java.math.BigDecimal;
import kotlin.Unit;
import ru.tora.generatedEntity.entity.ZClientOrgEntity;
import ru.vood.amdWeb.util.abstraction.RepositoryForView;


/* Интерфейс для таблицы БД - Юридические лица */
interface ZClientOrgService : RepositoryForView<ZClientOrgEntity, BigDecimal>{
 fun saveAll (entity : MutableIterable<ZClientOrgEntity>) : MutableIterable<ZClientOrgEntity>

 fun deleteById (entity : BigDecimal) : Unit

 fun deleteAll (entity : MutableIterable<ZClientOrgEntity>) : Unit

}
