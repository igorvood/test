package hello;

import com.vaadin.flow.component.Component;

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
        private Component mappedField;


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

        public Component getMappedField() {
            return mappedField;
        }

        public void setMappedField(Component mappedField) {
            this.mappedField = mappedField;
        }
    }
}

/*
* // List of planets
List<Planet> planets = new ArrayList<>();
planets.add(new Planet(1, "Mercury"));
planets.add(new Planet(2, "Venus"));
planets.add(new Planet(3, "Earth"));

ComboBox<Planet> select =
    new ComboBox<>("Select or Add a Planet");
select.setItems(planets);

// Use the name property for item captions
select.setItemCaptionGenerator(Planet::getName);

// Allow adding new items and add
// handling for new items
select.setNewItemProvider(inputString -> {

    Planet newPlanet = new Planet(planets.size(), inputString);
    planets.add(newPlanet);

    // Update combobox content
    select.setItems(planets);

    return Optional.of(newPlanet);
});
* */
