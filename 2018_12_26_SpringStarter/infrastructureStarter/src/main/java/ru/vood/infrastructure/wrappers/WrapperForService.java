package ru.vood.infrastructure.wrappers;

import io.vavr.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static ru.vood.infrastructure.wrappers.Page.NULL_PAGE;

public interface WrapperForService extends BeginnerOfChainFunctionInterface {

    default <R> WrappedObject<R> wrapList(Supplier<List<R>> longListFunction) {
        return wrapList(NULL_PAGE, o -> longListFunction.get(), null);
    }

    default <T1, R> WrappedObject<R> wrapList(Function<T1, List<R>> longListFunction, T1 t1) {
        return wrapList(NULL_PAGE, longListFunction, t1);
    }

    default <T1, T2, R> WrappedObject<R> wrapList(BiFunction<T1, T2, List<R>> longListFunction, T1 t1, T2 t2) {
        return wrapList(NULL_PAGE, longListFunction, t1, t2);
    }

    default <T1, T2, T3, R> WrappedObject<R> wrapList(Function3<T1, T2, T3, List<R>> longListFunction, T1 t1, T2 t2, T3 t3) {
        return wrapList(NULL_PAGE, longListFunction, t1, t2, t3);
    }

    default <T1, T2, T3, T4, R> WrappedObject<R> wrapList(Function4<T1, T2, T3, T4, List<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4) {
        return wrapList(NULL_PAGE, longListFunction, t1, t2, t3, t4);
    }

    default <T1, T2, T3, T4, T5, R> WrappedObject<R> wrapList(Function5<T1, T2, T3, T4, T5, List<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        return wrapList(NULL_PAGE, longListFunction, t1, t2, t3, t4, t5);
    }

    default <T1, T2, T3, T4, T5, T6, R> WrappedObject<R> wrapList(Function6<T1, T2, T3, T4, T5, T6, List<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        return wrapList(NULL_PAGE, longListFunction, t1, t2, t3, t4, t5, t6);
    }

    default <T1, T2, T3, T4, T5, T6, T7, R> WrappedObject<R> wrapList(Function7<T1, T2, T3, T4, T5, T6, T7, List<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        return wrapList(NULL_PAGE, longListFunction, t1, t2, t3, t4, t5, t6, t7);
    }

    default <T1, T2, T3, T4, T5, T6, T7, T8, R> WrappedObject<R> wrapList(Function8<T1, T2, T3, T4, T5, T6, T7, T8, List<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        return wrapList(NULL_PAGE, longListFunction, t1, t2, t3, t4, t5, t6, t7, t8);
    }

    default <R> WrappedObject<R> wrapList(Page page, Supplier<List<R>> longListFunction) {
        return wrapList(page, o -> longListFunction.get(), null);
    }

    default <T1, R> WrappedObject<R> wrapList(Page page, Function<T1, List<R>> longListFunction, T1 t1) {
        try {
            return getOk(page, longListFunction.apply(t1));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, R> WrappedObject<R> wrapList(Page page, BiFunction<T1, T2, List<R>> longListFunction, T1 t1, T2 t2) {
        try {
            return getOk(page, longListFunction.apply(t1, t2));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, R> WrappedObject<R> wrapList(Page page, Function3<T1, T2, T3, List<R>> longListFunction, T1 t1, T2 t2, T3 t3) {
        try {
            return getOk(page, longListFunction.apply(t1, t2, t3));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, R> WrappedObject<R> wrapList(Page page, Function4<T1, T2, T3, T4, List<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4) {
        try {
            return getOk(page, longListFunction.apply(t1, t2, t3, t4));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, T5, R> WrappedObject<R> wrapList(Page page, Function5<T1, T2, T3, T4, T5, List<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        try {
            return getOk(page, longListFunction.apply(t1, t2, t3, t4, t5));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, T5, T6, R> WrappedObject<R> wrapList(Page page, Function6<T1, T2, T3, T4, T5, T6, List<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        try {
            return getOk(page, longListFunction.apply(t1, t2, t3, t4, t5, t6));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, T5, T6, T7, R> WrappedObject<R> wrapList(Page page, Function7<T1, T2, T3, T4, T5, T6, T7, List<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        try {
            return getOk(page, longListFunction.apply(t1, t2, t3, t4, t5, t6, t7));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, T5, T6, T7, T8, R> WrappedObject<R> wrapList(Page page, Function8<T1, T2, T3, T4, T5, T6, T7, T8, List<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        try {
            return getOk(page, longListFunction.apply(t1, t2, t3, t4, t5, t6, t7, t8));
        } catch (Exception e) {
            return getError(e);
        }
    }

    //------------------------------------------------------
    default <R> WrappedObject<R> wrapObject(Supplier<R> longListFunction) {
        return wrapObject(NULL_PAGE, longListFunction);

    }

    default <T1, R> WrappedObject<R> wrapObject(Function<T1, R> longListFunction, T1 t1) {
        return wrapObject(NULL_PAGE, longListFunction, t1);
    }

    default <T1, T2, R> WrappedObject<R> wrapObject(BiFunction<T1, T2, R> longListFunction, T1 t1, T2 t2) {
        return wrapObject(NULL_PAGE, longListFunction, t1, t2);
    }

    default <T1, T2, T3, R> WrappedObject<R> wrapObject(Function3<T1, T2, T3, R> longListFunction, T1 t1, T2 t2, T3 t3) {
        return wrapObject(NULL_PAGE, longListFunction, t1, t2, t3);
    }

    default <T1, T2, T3, T4, R> WrappedObject<R> wrapObject(Function4<T1, T2, T3, T4, R> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4) {
        return wrapObject(NULL_PAGE, longListFunction, t1, t2, t3, t4);
    }

    default <T1, T2, T3, T4, T5, R> WrappedObject<R> wrapObject(Function5<T1, T2, T3, T4, T5, R> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        return wrapObject(NULL_PAGE, longListFunction, t1, t2, t3, t4, t5);
    }

    default <T1, T2, T3, T4, T5, T6, R> WrappedObject<R> wrapObject(Function6<T1, T2, T3, T4, T5, T6, R> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        return wrapObject(NULL_PAGE, longListFunction, t1, t2, t3, t4, t5, t6);
    }

    default <T1, T2, T3, T4, T5, T6, T7, R> WrappedObject<R> wrapObject(Function7<T1, T2, T3, T4, T5, T6, T7, R> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        return wrapObject(NULL_PAGE, longListFunction, t1, t2, t3, t4, t5, t6, t7);
    }

    default <T1, T2, T3, T4, T5, T6, T7, T8, R> WrappedObject<R> wrapObject(Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        return wrapObject(NULL_PAGE, longListFunction, t1, t2, t3, t4, t5, t6, t7, t8);
    }

    default <R> WrappedObject<R> wrapObject(Page page, Supplier<R> longListFunction) {
        return wrapList(page, first(q -> longListFunction.get()).andThen(aroundObjectByList()), null);
    }

    default <T1, R> WrappedObject<R> wrapObject(Page page, Function<T1, R> longListFunction, T1 t1) {
        return wrapList(page, longListFunction.andThen(aroundObjectByList()), t1);
    }

    default <T1, T2, R> WrappedObject<R> wrapObject(Page page, BiFunction<T1, T2, R> longListFunction, T1 t1, T2 t2) {
        return wrapList(page, longListFunction.andThen(aroundObjectByList()), t1, t2);
    }

    default <T1, T2, T3, R> WrappedObject<R> wrapObject(Page page, Function3<T1, T2, T3, R> longListFunction, T1 t1, T2 t2, T3 t3) {
        return wrapList(page, longListFunction.andThen(aroundObjectByList()), t1, t2, t3);
    }

    default <T1, T2, T3, T4, R> WrappedObject<R> wrapObject(Page page, Function4<T1, T2, T3, T4, R> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4) {
        return wrapList(page, longListFunction.andThen(aroundObjectByList()), t1, t2, t3, t4);
    }

    default <T1, T2, T3, T4, T5, R> WrappedObject<R> wrapObject(Page page, Function5<T1, T2, T3, T4, T5, R> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        return wrapList(page, longListFunction.andThen(aroundObjectByList()), t1, t2, t3, t4, t5);
    }

    default <T1, T2, T3, T4, T5, T6, R> WrappedObject<R> wrapObject(Page page, Function6<T1, T2, T3, T4, T5, T6, R> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        return wrapList(page, longListFunction.andThen(aroundObjectByList()), t1, t2, t3, t4, t5, t6);
    }

    default <T1, T2, T3, T4, T5, T6, T7, R> WrappedObject<R> wrapObject(Page page, Function7<T1, T2, T3, T4, T5, T6, T7, R> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        return wrapList(page, longListFunction.andThen(aroundObjectByList()), t1, t2, t3, t4, t5, t6, t7);
    }

    default <T1, T2, T3, T4, T5, T6, T7, T8, R> WrappedObject<R> wrapObject(Page page, Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        return wrapList(page, longListFunction.andThen(aroundObjectByList()), t1, t2, t3, t4, t5, t6, t7, t8);
    }

    default <R> Function<R, List<R>> aroundObjectByList() {
        return r -> {
            if (r instanceof List)
                throw new RuntimeException("Класс " + r.getClass() + " уже является списком,  для работы с ни необходимо использовать медоты WrapperForService.wrapList");
            List<R> rList = new ArrayList<>();
            rList.add(r);
            return rList;
        };
    }

    default <R> WrappedObject<R> getError(Exception e) {
        throw new RuntimeException(e.getMessage(), e);
    }

    default <R> WrappedObject<R> getOk(Page page, List<R> apply) {
        return new WrappedObject<>(page, apply);
    }

    default <R> WrappedObject<R> getOk(List<R> apply) {
        return new WrappedObject<>(NULL_PAGE, apply);
    }

    default <R> WrappedObject<R> getOk(R apply) {
        return new WrappedObject<>(NULL_PAGE, Collections.singletonList(apply));
    }

    default <R> WrappedObject<R> getOk(Page page, R apply) {
        return new WrappedObject<>(page, Collections.singletonList(apply));
    }


    public static class WrappedObject<OBJ> {
        private final Page page;
        private final List<OBJ> objectList;

        WrappedObject(Page page, List<OBJ> objectList) {
            this.page = page;
            this.objectList = objectList;
        }

        public Page getPage() {
            return page;
        }

        public List<OBJ> getObjectList() {
            return objectList;
        }
    }

}
