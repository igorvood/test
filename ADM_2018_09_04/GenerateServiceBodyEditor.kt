package ru.vood.admplugin.infrastructure.generateCode.impl.intf.addMetod.generateServiceBody

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.vood.admplugin.infrastructure.generateCode.impl.TypeOfGenClass
import ru.vood.admplugin.infrastructure.spring.entity.VBdObjectEntity
import ru.vood.admplugin.infrastructure.spring.entity.VBdTableEntity
import ru.vood.admplugin.infrastructure.spring.intf.VBdColumnsEntityService
import ru.vood.admplugin.infrastructure.spring.referenceBook.ObjectTypes

@Component
class GenerateServiceBodyEditor(@Autowired
                                val columnsEntityService: VBdColumnsEntityService
) : GenerateServiceBodyService {

    override fun genCode(entity: VBdObjectEntity, typeOfGenClass: TypeOfGenClass): StringBuilder {
        val retVal = StringBuilder()
        val columnsEntities = columnsEntityService.findByParent(entity as VBdTableEntity?)
        val listReference = columnsEntities.asSequence()
                .filter { e -> e.typeColomn == ObjectTypes.getREFERENCE() }
                .toList()
        return retVal
    }
}