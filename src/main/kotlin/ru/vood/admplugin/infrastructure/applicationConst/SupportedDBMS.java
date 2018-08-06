package ru.vood.admplugin.infrastructure.applicationConst;

public enum SupportedDBMS {
    ORACLE("ORACLE"), MYSQL("MYSQL");

    private String type;

    private SupportedDBMS(String name) {
        this.type = name;
    }

    public String getType() {
        return type;
    }

}
