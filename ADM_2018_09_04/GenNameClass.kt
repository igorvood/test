package ru.vood.admplugin.infrastructure.generateCode.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component
import ru.vood.admplugin.infrastructure.generateCode.impl.intf.GenNameClassService
import ru.vood.admplugin.infrastructure.generateCode.impl.intf.addingImport.AddAnyClassService
import ru.vood.admplugin.infrastructure.generateCode.impl.intf.addingImport.AddJavaClassToImport
import ru.vood.admplugin.infrastructure.spring.entity.VBdTableEntity
import java.math.BigDecimal

@Component
class GenNameClass(@Autowired
                   val genCodeCommonFunction: GenCodeCommonFunctionKT,
                   val addAnyClassService: AddAnyClassService,
                   val addJavaClassToImport: AddJavaClassToImport
) : GenNameClassService {

    override fun genCode(entity: VBdTableEntity, typeOfGenClass: TypeOfGenClass): StringBuilder {
        var extend = StringBuilder()
        var predicate: String
        when (typeOfGenClass) {
            TypeOfGenClass.ENTITY_CLASS -> predicate = "open class "
            TypeOfGenClass.IMPL_CLASS -> predicate = "open class "
            TypeOfGenClass.SERVICE_CLASS -> predicate = "interface "
            TypeOfGenClass.REPOSITORY_CLASS -> predicate = "interface "
            TypeOfGenClass.EDITOR_CLASS -> predicate = "class "
            TypeOfGenClass.GRID_CLASS -> predicate = "class "
        }

        //Формирование класса родителя для сущности
        if (!genCodeCommonFunction.isRootEntity(entity) && typeOfGenClass == TypeOfGenClass.ENTITY_CLASS)
            extend.append(genCodeCommonFunction.getExtendsClassName(entity, typeOfGenClass))


        //Формирование класса родителя для имплементации сервиса
        if (typeOfGenClass == TypeOfGenClass.IMPL_CLASS) {
            extend.append(" : ")
                    .append(addAnyClassService.getFullNameClass(entity, TypeOfGenClass.SERVICE_CLASS))
        }


        //Формирование класса родителя для класса репозитория
        if (typeOfGenClass == TypeOfGenClass.REPOSITORY_CLASS) {
            addJavaClassToImport.getCode(JpaRepository::class.java)
            addJavaClassToImport.getCode(BigDecimal::class.java)
            addAnyClassService.getCode(entity, TypeOfGenClass.ENTITY_CLASS)
            extend.append(" : ")
                    .append("CrudRepository<${genCodeCommonFunction.getClassName(entity, TypeOfGenClass.ENTITY_CLASS)}, BigDecimal>")
        }

        //Формирование класса родителя для класса редактора
        if (typeOfGenClass == TypeOfGenClass.EDITOR_CLASS) {
            extend.append(" : ")
                    .append("AbstractEditorKT<")
                    .append(genCodeCommonFunction.getClassName(entity, TypeOfGenClass.ENTITY_CLASS))
                    .append(", ")
                    .append(genCodeCommonFunction.getClassName(entity, TypeOfGenClass.SERVICE_CLASS))
                    .append(">")
        }

        //Формирование класса родителя для класса таблицы
        if (typeOfGenClass == TypeOfGenClass.GRID_CLASS) {
            extend.append(" : ")
                    .append("AbstractGridKT<")
                    .append(genCodeCommonFunction.getClassName(entity, TypeOfGenClass.ENTITY_CLASS))
                    .append(", ")
                    .append(genCodeCommonFunction.getClassName(entity, TypeOfGenClass.SERVICE_CLASS))
                    .append(", ")
                    .append(genCodeCommonFunction.getClassName(entity, TypeOfGenClass.EDITOR_CLASS))
                    .append(">")
        }

        val clazz = "/* ${typeOfGenClass.comment} для таблицы БД - ${entity.name} */\n" +
                predicate + genCodeCommonFunction.getClassName(entity, typeOfGenClass) + extend

        return StringBuilder(clazz)
    }
}