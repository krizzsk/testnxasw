package kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(AnnotationRetention.RUNTIME)
@Documented
@java.lang.annotation.Target({ElementType.TYPE})
@Metadata(mo148867d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo148868d2 = {"Lkotlin/jvm/JvmInline;", "", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* compiled from: JvmPlatformAnnotations.kt */
public @interface JvmInline {
}