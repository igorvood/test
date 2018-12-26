package ru.vood.infrastructureTest.test

import io.vavr.Function3
import ru.vood.infrastructure.wrappers.WrapperForService

class Test1 : WrapperForService {

    fun q() {
        listOf<String>("1")
        val h = HashMap<Long, String>()
        val put = h.put(1L, "2")
        //val kFunction1 = this::class.java::s
//        z,x,c-> this.s(z,x,c )
        wrapObject(object : Function3<Int, Int, Int, String> {
            override fun apply(t1: Int?, t2: Int?, t3: Int?): String {
                return s(t1, t2, t3)
            }
        }, 1, 2, 3)


        val kFunction3 = this::s
        val wrapObject = wrapObject(first(this::s)
                .andThen(this::l), 1, 2, 3)

/*
        val function3: Any = io.vavr.Function3{ }
        wrapObject(function3, 1,2,3)
*/
    }

    fun s(i: Int?, w: Int?, e: Int?) = "Qwer"
    fun l(s: String): Long {
        return 4
    }
}

