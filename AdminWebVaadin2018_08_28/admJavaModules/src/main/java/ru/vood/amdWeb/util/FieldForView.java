package ru.vood.amdWeb.util;

import com.vaadin.flow.function.ValueProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vood.amdWeb.util.annotation.ViewColumn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FieldForView<T> {
    private Class<T> type;

    public FieldForView(Class<T> type) {
        this.type = type;
    }

    public Map<String, FieldPropertyView> getFields() {
        HashMap<String, FieldPropertyView> mapFields = new HashMap<>();
        final Map<String, FieldPropertyView> currentTypeFields = Arrays.stream(this.type.getDeclaredFields())
                .filter(field -> field.getAnnotation(ViewColumn.class) != null)
                .collect(Collectors.toMap(f -> f.getName(), f -> getFieldProperty(f)));
        mapFields.putAll(currentTypeFields);
        if (type.getSuperclass() != Object.class)
            mapFields.putAll(new FieldForView<>(type.getSuperclass()).getFields());
        return mapFields;
    }

    private FieldPropertyView getFieldProperty(Field field) {
        ValueProvider<T, Object> valueProvider = null;
        final Annotation viewColumnAnnotation = field.getAnnotations()[0];
        if (viewColumnAnnotation instanceof ViewColumn) {
            ViewColumn viewColumn = (ViewColumn) viewColumnAnnotation;
            return new FieldPropertyView(viewColumn.displayName()
                    , field.getName()
                    , field
                    , valueProvider
            );
        }
        return new FieldPropertyView();
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
    public static class FieldPropertyView {
        private String displayName;
        private String fieldName;
        private Field field;
        private ValueProvider valueProvider;
    }
}
