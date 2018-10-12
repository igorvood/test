package ru.vood.admplugin.infrastructure.except;

public class NoDataFoundException extends CoreExeption {

    public NoDataFoundException() {
        super("Данные не найдены");
    }
}
