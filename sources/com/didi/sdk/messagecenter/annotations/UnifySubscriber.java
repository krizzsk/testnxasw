package com.didi.sdk.messagecenter.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UnifySubscriber {
    /* renamed from: id */
    int mo99277id() default 0;
}
