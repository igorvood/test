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
import ru.tora.generatedEntity.entity.ZTypeAdressEntity;
import ru.tora.generatedEntity.service.ZTypeAdressService;


@Service
@Repository
@Transactional
/* Репозиторий для таблицы БД - Типы адресов */
open class ZTypeAdressImpl : ru.tora.generatedEntity.service.ZTypeAdressService{
@Autowired
lateinit var zTypeAdressServiceVal : ZTypeAdressService

 override  fun save (entity : ZTypeAdressEntity) : ZTypeAdressEntity{return zTypeAdressServiceVal.save(entity)}

 override  fun saveAll (entity : MutableIterable<ZTypeAdressEntity>) : MutableIterable<ZTypeAdressEntity>{return zTypeAdressServiceVal.saveAll(entity)}

 override  fun delete (entity : ZTypeAdressEntity) : Unit{return zTypeAdressServiceVal.delete(entity)}

 override  fun deleteById (entity : BigDecimal) : Unit{return zTypeAdressServiceVal.deleteById(entity)}

 override  fun deleteAll (entity : MutableIterable<ZTypeAdressEntity>) : Unit{return zTypeAdressServiceVal.deleteAll(entity)}

 override  fun findById (entity : BigDecimal) : Optional<ZTypeAdressEntity>{return zTypeAdressServiceVal.findById(entity)}

 override  fun findAll () : kotlin.collections.List<ZTypeAdressEntity>{return zTypeAdressServiceVal.findAll()}

}
