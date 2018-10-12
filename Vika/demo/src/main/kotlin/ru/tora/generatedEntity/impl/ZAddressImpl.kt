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
import ru.tora.generatedEntity.entity.ZAddressEntity;
import ru.tora.generatedEntity.service.ZAddressService;


@Service
@Repository
@Transactional
/* Репозиторий для таблицы БД - Адреса */
open class ZAddressImpl : ru.tora.generatedEntity.service.ZAddressService{
@Autowired
lateinit var zAddressServiceVal : ZAddressService

 override  fun save (entity : ZAddressEntity) : ZAddressEntity{return zAddressServiceVal.save(entity)}

 override  fun saveAll (entity : MutableIterable<ZAddressEntity>) : MutableIterable<ZAddressEntity>{return zAddressServiceVal.saveAll(entity)}

 override  fun delete (entity : ZAddressEntity) : Unit{return zAddressServiceVal.delete(entity)}

 override  fun deleteById (entity : BigDecimal) : Unit{return zAddressServiceVal.deleteById(entity)}

 override  fun deleteAll (entity : MutableIterable<ZAddressEntity>) : Unit{return zAddressServiceVal.deleteAll(entity)}

 override  fun findById (entity : BigDecimal) : Optional<ZAddressEntity>{return zAddressServiceVal.findById(entity)}

 override  fun findAll () : kotlin.collections.List<ZAddressEntity>{return zAddressServiceVal.findAll()}

}
