package com.didi.sdk.messagecenter;

import android.text.TextUtils;
import com.didi.sdk.messagecenter.interfaces.IHandler;
import com.didi.sdk.messagecenter.interfaces.IStore;
import com.didi.sdk.messagecenter.interfaces.ISubscribe;
import com.didi.sdk.messagecenter.interpreter.IInterpreter;
import com.didi.sdk.messagecenter.interpreter.InterpreterFactory;
import com.didi.sdk.messagecenter.model.PushMessage;
import com.didi.sdk.messagecenter.subscribe.Subscription;
import com.didi.sdk.push.manager.DPushType;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.sdk.messagecenter.d */
/* compiled from: SubscribeWrapper */
class C13297d implements ISubscribe.ISubscribeWrapper {

    /* renamed from: a */
    private Object f39534a;

    /* renamed from: b */
    private Set<Class<? extends PushMessage>> f39535b = new HashSet();

    /* renamed from: c */
    private IStore f39536c;

    public C13297d(Object obj, IStore iStore) {
        this.f39534a = obj;
        this.f39536c = iStore;
    }

    public ISubscribe.ISubscribeWrapper subscribe(Class<? extends PushMessage> cls) {
        this.f39535b.add(cls);
        return this;
    }

    public void handler(IHandler iHandler) {
        m29760a(iHandler);
    }

    /* renamed from: a */
    private void m29760a(IHandler iHandler) {
        if (!this.f39535b.isEmpty() && iHandler != null) {
            IInterpreter iInterpreter = null;
            for (Class next : this.f39535b) {
                if (iInterpreter == null) {
                    iInterpreter = InterpreterFactory.getInterpreter(next);
                }
                Set<String> explainTopic = iInterpreter.explainTopic(next);
                String explainType = iInterpreter.explainType(next);
                int explainUnifyId = iInterpreter.explainUnifyId(next);
                if (m29761a(explainTopic, explainType, explainUnifyId)) {
                    for (String next2 : explainTopic) {
                        if (!TextUtils.isEmpty(next2)) {
                            this.f39536c.add(this.f39534a, new Subscription(this.f39534a, next2, explainUnifyId, explainType, iHandler, next));
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m29761a(Set<String> set, String str, int i) {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(str);
        boolean z3 = set != null && !set.isEmpty();
        if (i <= 0) {
            z = false;
        }
        if (!z2) {
            return false;
        }
        if (!z && !TextUtils.equals(str, DPushType.TENCENT_PUSH.getName())) {
            return false;
        }
        return z3;
    }
}
