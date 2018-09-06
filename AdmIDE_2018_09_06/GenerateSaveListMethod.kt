package ru.vood.admplugin.infrastructure.generateCode.impl.intf.addMetod.concreteMethod

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.vood.admplugin.infrastructure.generateCode.impl.TypeOfGenClass
import ru.vood.admplugin.infrastructure.generateCode.impl.intf.addMetod.WrappedType
import ru.vood.admplugin.infrastructure.generateCode.impl.intf.addMetod.WrapperClass
import ru.vood.admplugin.infrastructure.spring.entity.VBdObjectEntity

@Component
class GenerateSaveListMethod : GenerateSpecificMethodService {
    @Autowired
    lateinit var generateSimpleMethodService: GenerateSimpleMethodService

    override fun genCode(bdClass: VBdObjectEntity, typeOfGenClass: TypeOfGenClass): StringBuilder {
        val wrappedType = WrappedType(bdClass, WrapperClass.MUTABLEITERABLE_WRAPPER)
        return generateSimpleMethodService.genCode(bdClass, typeOfGenClass, "saveAll", wrappedType, wrappedType)
    }
}