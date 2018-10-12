package ru.vood.admplugin.infrastructure.except;

public class TooManyRowsException extends CoreExeption {

    public TooManyRowsException() {
        super("Найдено несколько запесей, ожидалась одна");
    }
}
