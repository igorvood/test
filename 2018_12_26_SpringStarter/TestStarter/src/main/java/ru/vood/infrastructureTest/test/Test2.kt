package ru.vood.infrastructureTest.test


import ru.vood.infrastructure.wrappers.kt.first
import ru.vood.infrastructure.wrappers.kt.wrapObject

class Test2 /*: WrapperForServiceKT*/ {

/*
    fun q() {
        val wrapObject = wrapObject(first(this::s).andThen(this::l), 1, 23, 4)

    }
*/

    fun s(i: Int, w: Int, e: Int) = (i + w + e).toString()
    fun l(s: String): Long {
        return 4
    }

}