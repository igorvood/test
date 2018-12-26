package ru.vood.infrastructureTest.test;

import ru.vood.infrastructure.wrappers.kt.WrappedObject;

import static ru.vood.infrastructure.wrappers.kt.BeginnerOfChainFunctionInterfaceKTKt.first;
import static ru.vood.infrastructure.wrappers.kt.WrapperForServiceKTKt.wrapObject;

public class Test /*implements WrapperForServiceKT*/ {

    public void ds() {

        WrappedObject<Long> longWrappedObject = wrapObject(first(this::s).andThen(this::l), 1, 2, 3);

    }

    public String s(Integer i1, Integer i2, Integer i3) {
        return "zxcv";
    }

    public Long l(String s) {
        return 123L;
    }


}
