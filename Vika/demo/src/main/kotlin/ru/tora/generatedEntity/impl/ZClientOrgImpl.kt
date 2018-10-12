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
import ru.tora.generatedEntity.entity.ZClientOrgEntity;
import ru.tora.generatedEntity.service.ZClientOrgService;


@Service
@Repository
@Transactional
/* Репозиторий для таблицы БД - Юридические лица */
open class ZClientOrgImpl : ru.tora.generatedEntity.service.ZClientOrgService{
@Autowired
lateinit var zClientOrgServiceVal : ZClientOrgService

 override  fun save (entity : ZClientOrgEntity) : ZClientOrgEntity{return zClientOrgServiceVal.save(entity)}

 override  fun saveAll (entity : MutableIterable<ZClientOrgEntity>) : MutableIterable<ZClientOrgEntity>{return zClientOrgServiceVal.saveAll(entity)}

 override  fun delete (entity : ZClientOrgEntity) : Unit{return zClientOrgServiceVal.delete(entity)}

 override  fun deleteById (entity : BigDecimal) : Unit{return zClientOrgServiceVal.deleteById(entity)}

 override  fun deleteAll (entity : MutableIterable<ZClientOrgEntity>) : Unit{return zClientOrgServiceVal.deleteAll(entity)}

 override  fun findById (entity : BigDecimal) : Optional<ZClientOrgEntity>{return zClientOrgServiceVal.findById(entity)}

 override  fun findAll () : kotlin.collections.List<ZClientOrgEntity>{return zClientOrgServiceVal.findAll()}

}
