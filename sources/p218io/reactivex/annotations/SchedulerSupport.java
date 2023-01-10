package p218io.reactivex.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: io.reactivex.annotations.SchedulerSupport */
public @interface SchedulerSupport {
    public static final String COMPUTATION = "io.reactivex:computation";
    public static final String CUSTOM = "custom";

    /* renamed from: IO */
    public static final String f60799IO = "io.reactivex:io";
    public static final String NEW_THREAD = "io.reactivex:new-thread";
    public static final String NONE = "none";
    public static final String SINGLE = "io.reactivex:single";
    public static final String TRAMPOLINE = "io.reactivex:trampoline";

    String value();
}
