package ru.vood.amdWeb.util;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.data.binder.Setter;
import com.vaadin.flow.data.converter.*;
import com.vaadin.flow.function.ValueProvider;
import ru.vood.amdWeb.util.annotation.ViewColumn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FieldForView<T> {
    public final static Component TEXT_FIELD = new com.vaadin.flow.component.textfield.TextField();

    private Class<T> type;

    public FieldForView(Class<T> type) {
        this.type = type;
    }

    public Map<String, FieldProperty> getFields() {
        HashMap<String, FieldProperty> mapFields = new HashMap<>();
        final Map<String, FieldProperty> currentTypeFields = Arrays.stream(this.type.getDeclaredFields())
                .filter(field -> field.getAnnotation(ViewColumn.class) != null)
                .collect(Collectors.toMap(f -> f.getName(), f -> getFieldProperty(f)));
        mapFields.putAll(currentTypeFields);
        if (type.getSuperclass() != Object.class)
            mapFields.putAll(new FieldForView<>(type.getSuperclass()).getFields());
        return mapFields;
    }

    private FieldProperty getFieldProperty(Field field) {
        Object nullRepresentation = null;
        //Converter<Object, T> converter = null;
        Converter converter = null;
        Component component = TEXT_FIELD;
        ValueProvider<T, Object> valueProvider = null;
        Setter<T, Object> setter = null;
        final Annotation viewColumnAnnotation = field.getAnnotations()[0];
        if (viewColumnAnnotation instanceof ViewColumn) {
            ViewColumn viewColumn = (ViewColumn) viewColumnAnnotation;
            final Class<?> type = field.getType();
            if (type == String.class) {
            } else if (type == BigDecimal.class) {
                converter = new StringToBigDecimalConverter(BigDecimal.valueOf(0), "bigDecimals only");
            } else if (type == BigInteger.class) {
                converter = new StringToBigIntegerConverter(BigInteger.valueOf(0), "integers only");
            } else if (type == Double.class) {
                converter = new StringToDoubleConverter(Double.NaN, "doubles only");
            } else if (type == Float.class) {
                converter = new StringToFloatConverter(Float.NaN, "floates only");
            } else if (type == Integer.class) {
                converter = new StringToIntegerConverter(Integer.valueOf(0), "integers only");
            } else if (type == Long.class) {
                converter = new StringToLongConverter((long) 0, "integers only");
            }
/*
            return FieldProperty.builder()
                    .displayName(viewColumn.displayName())
                    .fieldName(field.getName())
                    .mappedField(component)
                    .nullRepresentation(nullRepresentation)
                    .converter(converter)
                    .valueProvider(valueProvider)
                    .setter(setter)
                    .build();
*/
            return new FieldProperty(viewColumn.displayName()
                    , field.getName()
                    , component
                    , nullRepresentation
                    , converter
                    , valueProvider
                    , setter);

        }
        return new FieldProperty();
    }

    public T getInstanceT() {
        try {
            return type.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
    */
    //@Builder
    public static class FieldProperty {
        private String displayName;
        private String fieldName;
        private Component mappedField;
        private Object nullRepresentation;
        private Converter converter;
        private ValueProvider valueProvider;
        private Setter setter;

        public FieldProperty() {
        }

        public FieldProperty(String displayName, String fieldName, Component mappedField, Object nullRepresentation, Converter converter, ValueProvider valueProvider, Setter setter) {
            this.displayName = displayName;
            this.fieldName = fieldName;
            this.mappedField = mappedField;
            this.nullRepresentation = nullRepresentation;
            this.converter = converter;
            this.valueProvider = valueProvider;
            this.setter = setter;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public Component getMappedField() {
            return mappedField;
        }

        public void setMappedField(Component mappedField) {
            this.mappedField = mappedField;
        }

        public Object getNullRepresentation() {
            return nullRepresentation;
        }

        public void setNullRepresentation(Object nullRepresentation) {
            this.nullRepresentation = nullRepresentation;
        }

        public Converter getConverter() {
            return converter;
        }

        public void setConverter(Converter converter) {
            this.converter = converter;
        }

        public ValueProvider getValueProvider() {
            return valueProvider;
        }

        public void setValueProvider(ValueProvider valueProvider) {
            this.valueProvider = valueProvider;
        }

        public Setter getSetter() {
            return setter;
        }

        public void setSetter(Setter setter) {
            this.setter = setter;
        }
    }
}
