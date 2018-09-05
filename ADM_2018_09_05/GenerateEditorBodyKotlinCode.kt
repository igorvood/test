package ru.vood.admplugin.infrastructure.generateCode.impl.intf.addMetod.generateServiceBody

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.vood.admplugin.infrastructure.generateCode.impl.GenCodeCommonFunctionKT
import ru.vood.admplugin.infrastructure.generateCode.impl.TypeOfGenClass
import ru.vood.admplugin.infrastructure.generateCode.impl.intf.addingImport.AddAnnotationClass
import ru.vood.admplugin.infrastructure.generateCode.impl.intf.addingImport.AddAnyClassService
import ru.vood.admplugin.infrastructure.spring.entity.VBdColumnsEntity
import ru.vood.admplugin.infrastructure.spring.entity.VBdObjectEntity
import ru.vood.admplugin.infrastructure.spring.entity.VBdTableEntity
import ru.vood.admplugin.infrastructure.spring.intf.VBdColumnsEntityService
import ru.vood.admplugin.infrastructure.spring.referenceBook.ObjectTypes

@Component
class GenerateEditorBodyKotlinCode(@Autowired
                                   val columnsEntityService: VBdColumnsEntityService,

                                   @Autowired
                                   val genCodeCommonFunction: GenCodeCommonFunctionKT,

                                   @Autowired
                                   val addAnyClassService: AddAnyClassService,

                                   @Autowired
                                   val addAnnotationClass: AddAnnotationClass

) : GenerateServiceBodyService {

    override fun genCode(entity: VBdObjectEntity, typeOfGenClass: TypeOfGenClass): StringBuilder {
        val retVal = StringBuilder()
        val columnsEntities = columnsEntityService.findByParent(entity as VBdTableEntity?)
        val listReference = columnsEntities.asSequence()
                .filter { e -> e.typeColomn == ObjectTypes.getREFERENCE() }
                .toList()

        val fields = StringBuilder()

        retVal.append(fields.append(generateServiceFields(listReference)))

        retVal.append(fields.append(generateServiceConstructor(listReference)))

        return retVal
    }

    private fun generateServiceConstructor(listReference: List<VBdColumnsEntity>): StringBuilder {
        val retVal = StringBuilder()
        retVal.append(addAnnotationClass.getCode(Autowired::class.java))
        продолжить тут
        return retVal
    }

    private fun generateServiceFields(listReference: List<VBdColumnsEntity>): StringBuilder {
        val retVal = StringBuilder()
        listReference.asSequence()
                .forEach {
                    val vBdTableEntity = (it.typeValue as VBdTableEntity).toType
                    addAnyClassService.getCode(vBdTableEntity, TypeOfGenClass.SERVICE_CLASS)
                    retVal.append("private val ")
                            .append(genCodeCommonFunction.getParametrName(vBdTableEntity, TypeOfGenClass.SERVICE_CLASS))
                            .append(": ")
                            .append(genCodeCommonFunction.getClassName(vBdTableEntity, TypeOfGenClass.SERVICE_CLASS))
                            .append("\n")
                }
        return retVal
    }
}