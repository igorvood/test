package ru.vood.infrastructure.wrappers;

import java.util.Date;

public class RestContext {
    private Date date;
    private Page page;

    public RestContext() {
    }

    public RestContext(Date date, Page page) {
        this.date = date;
        this.page = page;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
