package ru.vood.infrastructure.wrappers;

import io.vavr.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface WrapperForController extends BeginnerOfChainFunctionInterface {

    default <R> WrappedObject<R> wrapObject(Supplier<WrapperForService.WrappedObject<R>> longListFunction) {
        try {
            return getOk(longListFunction.get());
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, R> WrappedObject<R> wrapObject(Function<T1, WrapperForService.WrappedObject<R>> longListFunction, T1 t1) {
        try {
            return getOk(longListFunction.apply(t1));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, R> WrappedObject<R> wrapObject(BiFunction<T1, T2, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2) {
        try {
            return getOk(longListFunction.apply(t1, t2));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, R> WrappedObject<R> wrapObject(Function3<T1, T2, T3, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3) {
        try {
            return getOk(longListFunction.apply(t1, t2, t3));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, R> WrappedObject<R> wrapObject(Function4<T1, T2, T3, T4, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4) {
        try {
            return getOk(longListFunction.apply(t1, t2, t3, t4));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, T5, R> WrappedObject<R> wrapObject(Function5<T1, T2, T3, T4, T5, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        try {
            return getOk(longListFunction.apply(t1, t2, t3, t4, t5));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, T5, T6, R> WrappedObject<R> wrapObject(Function6<T1, T2, T3, T4, T5, T6, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        try {
            return getOk(longListFunction.apply(t1, t2, t3, t4, t5, t6));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, T5, T6, T7, R> WrappedObject<R> wrapObject(Function7<T1, T2, T3, T4, T5, T6, T7, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        try {
            return getOk(longListFunction.apply(t1, t2, t3, t4, t5, t6, t7));
        } catch (Exception e) {
            return getError(e);
        }
    }


    default <T1, T2, T3, T4, T5, T6, T7, T8, R> WrappedObject<R> wrapObject(Function8<T1, T2, T3, T4, T5, T6, T7, T8, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        try {
            return getOk(longListFunction.apply(t1, t2, t3, t4, t5, t6, t7, t8));
        } catch (Exception e) {
            return getError(e);
        }
    }

    ///////////////////////

    default <T1, R> WrappedObject<R> validateAndWrapObject(Function<T1, ErrorMessage> validationFunction, Function<T1, WrapperForService.WrappedObject<R>> longListFunction, T1 t1) {
        try {
            final ErrorMessage errorMessage = validationFunction.apply(t1);
            if (isNotValid(errorMessage))
                return validError(errorMessage);
            return getOk(longListFunction.apply(t1));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, R> WrappedObject<R> validateAndWrapObject(BiFunction<T1, T2, ErrorMessage> validationFunction, BiFunction<T1, T2, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2) {
        try {
            final ErrorMessage errorMessage = validationFunction.apply(t1, t2);
            if (isNotValid(errorMessage))
                return validError(errorMessage);
            return getOk(longListFunction.apply(t1, t2));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, R> WrappedObject<R> validateAndWrapObject(Function3<T1, T2, T3, ErrorMessage> validationFunction, Function3<T1, T2, T3, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3) {
        try {
            final ErrorMessage errorMessage = validationFunction.apply(t1, t2, t3);
            if (isNotValid(errorMessage))
                return validError(errorMessage);
            return getOk(longListFunction.apply(t1, t2, t3));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, R> WrappedObject<R> validateAndWrapObject(Function4<T1, T2, T3, T4, ErrorMessage> validationFunction, Function4<T1, T2, T3, T4, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4) {
        try {
            final ErrorMessage errorMessage = validationFunction.apply(t1, t2, t3, t4);
            if (isNotValid(errorMessage))
                return validError(errorMessage);
            return getOk(longListFunction.apply(t1, t2, t3, t4));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, T5, R> WrappedObject<R> validateAndWrapObject(Function5<T1, T2, T3, T4, T5, ErrorMessage> validationFunction, Function5<T1, T2, T3, T4, T5, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        try {
            final ErrorMessage errorMessage = validationFunction.apply(t1, t2, t3, t4, t5);
            if (isNotValid(errorMessage))
                return validError(errorMessage);
            return getOk(longListFunction.apply(t1, t2, t3, t4, t5));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, T5, T6, R> WrappedObject<R> validateAndWrapObject(Function6<T1, T2, T3, T4, T5, T6, ErrorMessage> validationFunction, Function6<T1, T2, T3, T4, T5, T6, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        try {
            final ErrorMessage errorMessage = validationFunction.apply(t1, t2, t3, t4, t5, t6);
            if (isNotValid(errorMessage))
                return validError(errorMessage);
            return getOk(longListFunction.apply(t1, t2, t3, t4, t5, t6));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, T5, T6, T7, R> WrappedObject<R> validateAndWrapObject(Function7<T1, T2, T3, T4, T5, T6, T7, ErrorMessage> validationFunction, Function7<T1, T2, T3, T4, T5, T6, T7, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        try {
            final ErrorMessage errorMessage = validationFunction.apply(t1, t2, t3, t4, t5, t6, t7);
            if (isNotValid(errorMessage))
                return validError(errorMessage);
            return getOk(longListFunction.apply(t1, t2, t3, t4, t5, t6, t7));
        } catch (Exception e) {
            return getError(e);
        }
    }

    default <T1, T2, T3, T4, T5, T6, T7, T8, R> WrappedObject<R> validateAndWrapObject(Function8<T1, T2, T3, T4, T5, T6, T7, T8, ErrorMessage> validationFunction, Function8<T1, T2, T3, T4, T5, T6, T7, T8, WrapperForService.WrappedObject<R>> longListFunction, T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8) {
        try {
            final ErrorMessage errorMessage = validationFunction.apply(t1, t2, t3, t4, t5, t6, t7, t8);
            if (isNotValid(errorMessage))
                return validError(errorMessage);
            return getOk(longListFunction.apply(t1, t2, t3, t4, t5, t6, t7, t8));
        } catch (Exception e) {
            return getError(e);
        }
    }

    ///////////////////////

    default boolean isNotValid(ErrorMessage errorMessage) {
        return errorMessage != null && errorMessage.getErrorMessages() != null && errorMessage.getErrorMessages().size() > 0;
    }

    default <R> WrappedObject<R> validError(ErrorMessage errorMessage) {
        return new WrappedObject<R>(CommonStatus.ERROR, null, errorMessage, null);
    }


    default <T> WrappedObject<T> getError(Exception e) {
        final ErrorMessage errorMessage = new ErrorMessage(Collections.singletonList(e.getMessage()));
        return new WrappedObject<>(CommonStatus.ERROR, null, errorMessage, null);
    }

    default <R> WrappedObject<R> getOk(WrapperForService.WrappedObject<R> objectFromService) {
        return new WrappedObject<R>(CommonStatus.OK,
                new RestContext(new Date(),
                        checkPage(objectFromService.getPage(),
                                objectFromService.getObjectList())),
                null,
                objectFromService.getObjectList());
    }

    default Page checkPage(Page page, List rs) {
        return page == Page.NULL_PAGE ? new Page(rs.size()) : page;
    }


    public static class WrappedObject<OBJ> {
        private CommonStatus status;
        private RestContext context;
        private ErrorMessage errorMessages;
        private List<OBJ> objectList;

        public WrappedObject() {
        }

        public WrappedObject(CommonStatus status, RestContext context, ErrorMessage errorMessages, List<OBJ> objectList) {
            this.status = status;
            this.context = context;
            this.errorMessages = errorMessages;
            this.objectList = objectList;
        }

        public CommonStatus getStatus() {
            return status;
        }

        public void setStatus(CommonStatus status) {
            this.status = status;
        }

        public RestContext getContext() {
            return context;
        }

        public void setContext(RestContext context) {
            this.context = context;
        }

        public ErrorMessage getErrorMessages() {
            return errorMessages;
        }

        public void setErrorMessages(ErrorMessage errorMessages) {
            this.errorMessages = errorMessages;
        }

        public List<OBJ> getObjectList() {
            return objectList;
        }

        public void setObjectList(List<OBJ> objectList) {
            this.objectList = objectList;
        }
    }

}
