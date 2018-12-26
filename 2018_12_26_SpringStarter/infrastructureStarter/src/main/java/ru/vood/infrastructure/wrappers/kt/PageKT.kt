package ru.vood.infrastructure.wrappers.kt

class PageKT {

    var totalRecords: Int = 0

    constructor()


    constructor(totalRecords: Int) {
        this.totalRecords = totalRecords
    }

    companion object {

        var NULL_PAGE = PageKT()
    }

}
