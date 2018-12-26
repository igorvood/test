package ru.vood.infrastructure.wrappers.kt

import io.vavr.*

import java.util.function.BiFunction
import java.util.function.Function
import java.util.function.Supplier

//interface BeginnerOfChainFunctionInterfaceKT {
fun <T1, R> first(function: Supplier<R>) = Function<T1, R> {
    function.get()
}

fun <T1, R> first(function: Function<T1, R>) = function

fun <T1, T2, R> first(function: BiFunction<T1, T2, R>) = function

fun <T1, T2, T3, R> first(function: Function3<T1, T2, T3, R>) = function
fun <T1, T2, T3, T4, R> first(function: Function4<T1, T2, T3, T4, R>) = function

fun <T1, T2, T3, T4, T5, R> first(function: Function5<T1, T2, T3, T4, T5, R>) = function

fun <T1, T2, T3, T4, T5, T6, R> first(function: Function6<T1, T2, T3, T4, T5, T6, R>) = function

fun <T1, T2, T3, T4, T5, T6, T7, R> first(function: Function7<T1, T2, T3, T4, T5, T6, T7, R>) = function

fun <T1, T2, T3, T4, T5, T6, T7, T8, R> first(function: Function8<T1, T2, T3, T4, T5, T6, T7, T8, R>) = function

//}
