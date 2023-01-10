package com.didichuxing.foundation.rpc.annotation;

import com.didichuxing.foundation.rpc.RpcInterceptor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Interception {
    Class<? extends RpcInterceptor>[] value();
}
