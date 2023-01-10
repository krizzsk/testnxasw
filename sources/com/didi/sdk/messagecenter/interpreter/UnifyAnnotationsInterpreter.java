package com.didi.sdk.messagecenter.interpreter;

import com.didi.sdk.messagecenter.C13289M;
import com.didi.sdk.messagecenter.annotations.UnifySubscriber;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class UnifyAnnotationsInterpreter extends AnnotationsInterpreter {

    /* renamed from: a */
    private static final Class f39541a = C13289M.UnifyMsg.class;

    /* renamed from: b */
    private static final Map<Class, Integer> f39542b = new LinkedHashMap();

    public Set<String> explainTopic(Class<?> cls) {
        return super.explainTopic(f39541a);
    }

    public String explainType(Class<?> cls) {
        return super.explainType(f39541a);
    }

    public int explainUnifyId(Class<?> cls) {
        UnifySubscriber unifySubscriber;
        if (f39542b.containsKey(cls)) {
            return f39542b.get(cls).intValue();
        }
        if (!cls.isAnnotationPresent(UnifySubscriber.class) || (unifySubscriber = (UnifySubscriber) cls.getAnnotation(UnifySubscriber.class)) == null) {
            return 0;
        }
        int id = unifySubscriber.mo99277id();
        f39542b.put(cls, Integer.valueOf(id));
        return id;
    }
}
