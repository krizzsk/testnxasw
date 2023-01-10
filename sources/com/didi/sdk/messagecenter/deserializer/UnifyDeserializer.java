package com.didi.sdk.messagecenter.deserializer;

import android.text.TextUtils;
import com.didi.sdk.messagecenter.C13289M;
import com.didi.sdk.messagecenter.model.UnifyMessage;
import com.didi.sdk.messagecenter.p153pb.UnifyReq;
import com.didi.sdk.messagecenter.util.MLog;
import com.google.gson.Gson;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public class UnifyDeserializer<T extends UnifyMessage> implements Deserializer<T> {

    /* renamed from: a */
    private Map<Class, Class> f39538a = new LinkedHashMap();

    public T deserialize(byte[] bArr, Class<T> cls) {
        Class a;
        C13289M.UnifyMsg unifyMsg;
        if (!(bArr == null || (a = m29763a(cls)) == null || (unifyMsg = (C13289M.UnifyMsg) new TencentDeserializer().deserialize(bArr, C13289M.UnifyMsg.class)) == null || unifyMsg.msg == null)) {
            try {
                T t = (UnifyMessage) cls.newInstance();
                t.body = ((UnifyReq) unifyMsg.msg).msg_body;
                t.f39543id = ((UnifyReq) unifyMsg.msg).f39594id.intValue();
                t.businessId = ((UnifyReq) unifyMsg.msg).business_id.intValue();
                t.level = ((UnifyReq) unifyMsg.msg).level;
                t.media = ((UnifyReq) unifyMsg.msg).media;
                t.expireTime = ((UnifyReq) unifyMsg.msg).expire_time.intValue();
                t.msgId = ((UnifyReq) unifyMsg.msg).msg_id;
                t.msgType = ((UnifyReq) unifyMsg.msg).msg_type;
                if (!TextUtils.isEmpty(((UnifyReq) unifyMsg.msg).msg_body)) {
                    t.msg = (Serializable) new Gson().fromJson(((UnifyReq) unifyMsg.msg).msg_body, a);
                }
                return t;
            } catch (Exception e) {
                e.printStackTrace();
                MLog.m29815e("UnifyDeserializer catch exception: " + e.getMessage());
            }
        }
        return null;
    }

    /* renamed from: a */
    private Class m29763a(Class<? extends UnifyMessage> cls) {
        Type[] actualTypeArguments;
        if (this.f39538a.containsKey(cls)) {
            return this.f39538a.get(cls);
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) == null || actualTypeArguments.length <= 0) {
            return null;
        }
        Class cls2 = (Class) actualTypeArguments[0];
        if (!Serializable.class.isAssignableFrom(cls2)) {
            return null;
        }
        this.f39538a.put(cls, cls2);
        return cls2;
    }
}
