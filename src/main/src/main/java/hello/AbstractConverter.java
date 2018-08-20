package hello;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

public class AbstractConverter<T> implements Converter<String, T> {
    @Override
    public Result<T> convertToModel(String value, ValueContext context) {
        return null;
    }

    @Override
    public String convertToPresentation(T value, ValueContext context) {
        return null;
    }
}
