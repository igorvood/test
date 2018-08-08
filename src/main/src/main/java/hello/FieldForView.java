package hello;

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

    public Map<String, FieldProperty> getListFields() {
        final Map<String, FieldProperty> collect = new HashMap<>();
//        try {
        collect.putAll(Arrays.stream(type.getDeclaredFields())
                .filter(field -> (field.getAnnotation(ViewColumn.class) != null))
                .collect(Collectors.toMap(Field::getName, o -> getFieldProperty(o))));
/*
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        if (!type.getSuperclass().equals(Object.class)) {
            final Map listFields = new FieldForView(type.getSuperclass()).getListFields();
            collect.putAll(listFields);
        }
        return collect;
    }

    public T getInstanceT() {
        try {
            return type.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private FieldProperty getFieldProperty(Field field) {
        FieldProperty retFieldProperty = new FieldProperty();
        final Annotation ann = Arrays.stream(field.getAnnotations())
                .filter(annotation -> annotation.annotationType().equals(ViewColumn.class))
                .findFirst().orElse(null);
        if (ann != null && ann instanceof ViewColumn) {
            final ViewColumn currentAnnotation = (ViewColumn) ann;
            retFieldProperty.setDisplayName(currentAnnotation.displayName());
            retFieldProperty.setFieldName(field.getName());
        }
        return retFieldProperty;
    }

    public static class FieldProperty {
        private String displayName;
        private String fieldName;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }
}
