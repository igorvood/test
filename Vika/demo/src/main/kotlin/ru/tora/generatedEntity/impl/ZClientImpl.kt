package ru.tora.generatedEntity.impl;

import java.lang.Iterable;
import java.lang.Object;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import kotlin.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.tora.generatedEntity.entity.ZClientEntity;
import ru.tora.generatedEntity.service.ZClientService;


@Service
@Repository
@Transactional
/* Репозиторий для таблицы БД - Клиенты */
open class ZClientImpl : ru.tora.generatedEntity.service.ZClientService{
@Autowired
lateinit var zClientServiceVal : ZClientService

 override  fun save (entity : ZClientEntity) : ZClientEntity{return zClientServiceVal.save(entity)}

 override  fun saveAll (entity : MutableIterable<ZClientEntity>) : MutableIterable<ZClientEntity>{return zClientServiceVal.saveAll(entity)}

 override  fun delete (entity : ZClientEntity) : Unit{return zClientServiceVal.delete(entity)}

 override  fun deleteById (entity : BigDecimal) : Unit{return zClientServiceVal.deleteById(entity)}

 override  fun deleteAll (entity : MutableIterable<ZClientEntity>) : Unit{return zClientServiceVal.deleteAll(entity)}

 override  fun findById (entity : BigDecimal) : Optional<ZClientEntity>{return zClientServiceVal.findById(entity)}

 override  fun findAll () : kotlin.collections.List<ZClientEntity>{return zClientServiceVal.findAll()}

}
