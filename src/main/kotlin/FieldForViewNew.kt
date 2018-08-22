package hello.viewAbstract

import com.vaadin.flow.component.Component
import com.vaadin.flow.data.binder.Setter
import com.vaadin.flow.data.converter.*
import com.vaadin.flow.function.ValueProvider
import hello.ViewColumn
import java.lang.reflect.Field
import java.math.BigDecimal
import java.math.BigInteger
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
        var nullRepresentation: Any? = ""
        //var converter: Converter<Any, T>? = null
        var converter: Any? = null


        var valueProvider: ValueProvider<T, Any>? = null
        var setter: Setter<T, Any>? = null


        var viewColumnAnnotation: Annotation
        viewColumnAnnotation = field.getAnnotations().get(0)
        if (viewColumnAnnotation is ViewColumn) {
            when (field.type) {
                String::class.java -> null
                BigDecimal::class.java -> converter = StringToBigDecimalConverter(BigDecimal.valueOf(0), "bigDecimals only")
                BigInteger::class.java -> converter = StringToBigIntegerConverter(BigInteger.valueOf(0), "integers only")
                Double::class.java -> converter = StringToDoubleConverter(Double.NaN, "doubles only")
                Float::class.java -> converter = StringToFloatConverter(Float.NaN, "floates only")
                Integer::class.java -> converter = StringToIntegerConverter(Integer.valueOf(0), "integers only")
                Long::class.java -> converter = StringToLongConverter(0, "integers only")


            }

            return FieldProperty(viewColumnAnnotation.displayName, field.name)
        }
        return FieldProperty()
    }

    fun getInstanceT() = type.getConstructor().newInstance()

    class FieldProperty(val displayName: String
                        , val fieldName: String
                        , val mappedField: Component = com.vaadin.flow.component.textfield.TextField()
                        , var nullRepresentation: Any? = null
                        , var converter: Converter<Any, Any>? = null
                        , var valueProvider: ValueProvider<Any, Any>? = null
                        , var setter: Setter<Any, Any>? = null

    ) {
        constructor() : this("", "", com.vaadin.flow.component.textfield.TextField())
    }
}

