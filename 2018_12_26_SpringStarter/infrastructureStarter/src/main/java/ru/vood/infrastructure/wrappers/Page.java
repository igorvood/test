package ru.vood.infrastructure.wrappers;

public class Page {

    public static final Page NULL_PAGE = new Page();

    private int totalRecords;

    public Page() {
    }


    public Page(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

}
