package ru.vood.amdWeb.util;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Setter;
import com.vaadin.flow.data.converter.*;
import com.vaadin.flow.function.ValueProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vood.amdWeb.util.annotation.ViewColumn;

import javax.persistence.Id;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FieldForEditor<T> {
    //public final static Component TEXT_FIELD = new com.vaadin.flow.component.textfield.TextField();

    private Class<T> type;

    public FieldForEditor(Class<T> type) {
        this.type = type;
    }

    public Map<String, FieldPropertyEditor> getFields() {

        //final Map<String, FieldForView.FieldPropertyView> fieldsForView = new FieldForView<>(type).getFields();
        final Map<String, FieldPropertyEditor> fieldsForView = Arrays.stream(this.type.getDeclaredFields())
                .filter(field -> field.getAnnotation(Id.class) == null)
                .collect(Collectors.toMap(f -> f.getName(), f -> getFieldProperty(f)));
        HashMap<String, FieldPropertyEditor> mapFields = new HashMap<>();
        final Map<String, FieldPropertyEditor> currentTypeFields = fieldsForView.entrySet().stream()
                .collect(Collectors.toMap(f -> f.getKey(), f1 -> getFieldProperty(f1.getValue().getField())));
        mapFields.putAll(currentTypeFields);
        if (type.getSuperclass() != Object.class)
            mapFields.putAll(new FieldForEditor<>(type.getSuperclass()).getFields());
        return mapFields;
    }

    private FieldPropertyEditor getFieldProperty(Field field) {
        Object nullRepresentation = "";
        //Converter<Object, T> converter = null;
        Converter converter = null;
        Component component;
        ValueProvider<T, Object> valueProvider = null;
        Setter<T, Object> setter = null;
        final Annotation viewColumnAnnotation = field.getAnnotations()[0];
        String displayName;
        if (viewColumnAnnotation instanceof ViewColumn) {
            ViewColumn viewColumn = (ViewColumn) viewColumnAnnotation;
            displayName = viewColumn.displayName();
        } else {
            displayName = field.getName();
        }
        final Class<?> type = field.getType();
        //---------------------- строки--------------------------------------------------------
        if (type == String.class) {
            component = new com.vaadin.flow.component.textfield.TextField();
            ((TextField) component).setLabel(displayName);
            //---------------------- Числа--------------------------------------------------------
        } else if (type == BigDecimal.class) {
            converter = new StringToBigDecimalConverter(BigDecimal.valueOf(0), "bigDecimals only");
            component = new com.vaadin.flow.component.textfield.TextField();
            ((TextField) component).setLabel(displayName);
        } else if (type == BigInteger.class) {
            converter = new StringToBigIntegerConverter(BigInteger.valueOf(0), "integers only");
            component = new com.vaadin.flow.component.textfield.TextField();
            ((TextField) component).setLabel(displayName);
        } else if (type == Double.class || type == double.class) {
            converter = new StringToDoubleConverter(Double.NaN, "doubles only");
            component = new com.vaadin.flow.component.textfield.TextField();
            ((TextField) component).setLabel(displayName);
        } else if (type == Float.class || type == float.class) {
            converter = new StringToFloatConverter(Float.NaN, "floates only");
            component = new com.vaadin.flow.component.textfield.TextField();
            ((TextField) component).setLabel(displayName);
        } else if (type == Integer.class || type == int.class) {
            converter = new StringToIntegerConverter(Integer.valueOf(0), "integers only");
            component = new com.vaadin.flow.component.textfield.TextField();
            ((TextField) component).setLabel(displayName);
        } else if (type == Long.class || type == long.class) {
            converter = new StringToLongConverter((long) 0, "integers only");
            component = new com.vaadin.flow.component.textfield.TextField();
            ((TextField) component).setLabel(displayName);
            //---------------------- Логика --------------------------------------------------------
        } else if (type == Boolean.class || type == boolean.class) {
            component = new Checkbox(displayName);
            nullRepresentation = false;
            //---------------------- Дата --------------------------------------------------------
        } else if (type == Date.class) {
            component = new DatePicker(displayName);
            nullRepresentation = LocalDate.MIN;
            converter = new LocalDateToDateConverter();
            //---------------------- Ссылка на таблицу --------------------------------------------------------
            // пока тут ен буду писать ни каких условий, если понадобится добавлю
        } else {
            component = new ComboBox<>(displayName);
            nullRepresentation = new FieldForEditor(type).getInstanceT();
        }
/*
            return FieldPropertyView.builder()
                    .displayName(viewColumn.displayName())
                    .fieldName(field.getName())
                    .mappedField(component)
                    .nullRepresentation(nullRepresentation)
                    .converter(converter)
                    .valueProvider(valueProvider)
                    .setter(setter)
                    .build();
*/
        return new FieldPropertyEditor(displayName
                , field.getName()
                , field
                , component
                , nullRepresentation
                , converter
                , valueProvider
                , setter
                , null);


        //return new FieldPropertyEditor();
    }

    public T getInstanceT() {
        try {
            return type.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class FieldPropertyEditor {
        private String displayName;
        private String fieldName;
        private Field field;
        private Component mappedField;
        private Object nullRepresentation;
        private Converter converter;
        private ValueProvider valueProvider;
        private Setter setter;

        private List dataFromRepo;
    }
}
