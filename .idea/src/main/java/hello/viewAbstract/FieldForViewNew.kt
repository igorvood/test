package hello.viewAbstract

import com.vaadin.flow.component.Component
import hello.ViewColumn
import java.lang.reflect.Field
import java.util.*

class FieldForViewNew<T>(val type: Class<T>) {

    fun getFields(): Map<String, FieldProperty> {
        val mapFields = HashMap<String, FieldProperty>()
        val currentTypeFields: Map<String, FieldProperty> = this.type.getDeclaredFields()
                .asSequence()
                .filter { field -> field.getAnnotation(ViewColumn::class.java) != null }
                .associate { it.name to getFieldProperty(it) }
        mapFields.putAll(currentTypeFields)
        if (type.superclass != Any::class.java) mapFields.putAll(FieldForViewNew(type.superclass).getFields())
        return mapFields
    }

    private fun getFieldProperty(field: Field): FieldProperty {
        var viewColumnAnnotation: Annotation
        viewColumnAnnotation = field.getAnnotations().get(0)
        if (viewColumnAnnotation is ViewColumn) {
            return FieldProperty(viewColumnAnnotation.displayName, field.name)
        }
        return FieldProperty()
    }

    fun getInstanceT() = type.getConstructor().newInstance()

    class FieldProperty(val displayName: String, val fieldName: String, val mappedField: Component = com.vaadin.flow.component.textfield.TextField()) {
        constructor() : this("", "", com.vaadin.flow.component.textfield.TextField())
    }
}

