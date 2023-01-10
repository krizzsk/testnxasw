package com.didi.dimina.container.jsengine.method;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.jsengine.JSArray;
import com.didi.dimina.container.jsengine.JSEngineWrapper;
import com.didi.dimina.container.util.LogUtil;
import java.util.HashMap;
import java.util.Map;

public class JSWindowApi implements Handler.Callback {

    /* renamed from: a */
    private final Handler f18725a;

    /* renamed from: b */
    private final Map<String, MessageArg> f18726b = new HashMap();

    public JSWindowApi(DMMina dMMina) {
        JSEngineWrapper jSEngine = dMMina.getJSEngine();
        this.f18725a = new Handler(jSEngine.getLooper() == null ? Looper.getMainLooper() : jSEngine.getLooper(), this);
    }

    public void setTimeout(JSArray jSArray, CallbackFunction callbackFunction) {
        String b = m15905b(jSArray);
        long a = m15902a(jSArray);
        if (b == null || TextUtils.isEmpty(b) || a < 0) {
            LogUtil.m16839e("clearTimeout:funcId or timeout is invalid");
            return;
        }
        MessageArg create = MessageArg.create(b, a, callbackFunction);
        this.f18726b.put(b, create);
        m15903a(0, create);
    }

    public void setInterval(JSArray jSArray, CallbackFunction callbackFunction) {
        String b = m15905b(jSArray);
        long a = m15902a(jSArray);
        if (b == null || TextUtils.isEmpty(b) || a < 0) {
            LogUtil.m16839e("clearTimeout:funcId or interval is invalid");
            return;
        }
        MessageArg create = MessageArg.create(b, a, callbackFunction);
        this.f18726b.put(b, create);
        m15903a(1, create);
    }

    public void clearTimeout(JSArray jSArray) {
        String b = m15905b(jSArray);
        if (TextUtils.isEmpty(b)) {
            LogUtil.m16839e("clearTimeout:funcId is invalid");
            return;
        }
        m15904a(0, (Object) this.f18726b.get(b));
        this.f18726b.remove(b);
    }

    public void clearInterval(JSArray jSArray) {
        String b = m15905b(jSArray);
        if (TextUtils.isEmpty(b)) {
            LogUtil.m16839e("clearInterval: funcId is invalid");
            return;
        }
        m15904a(1, (Object) this.f18726b.get(b));
        this.f18726b.remove(b);
    }

    public void release() {
        LogUtil.m16841i("Timer removeAllMessages: ");
        this.f18725a.removeCallbacksAndMessages((Object) null);
        this.f18726b.clear();
    }

    public boolean handleMessage(Message message) {
        if (message == null) {
            return false;
        }
        int i = message.what;
        Object obj = message.obj;
        if (!(obj instanceof MessageArg)) {
            return false;
        }
        MessageArg messageArg = (MessageArg) obj;
        if (i == 0) {
            messageArg.callback.onCallBack(messageArg.funcId);
            this.f18726b.remove(messageArg.funcId);
        } else if (i != 1) {
            return false;
        } else {
            messageArg.callback.onCallBack(messageArg.funcId);
            m15903a(message.what, messageArg);
        }
        return true;
    }

    /* renamed from: a */
    private void m15904a(int i, Object obj) {
        if (obj != null) {
            this.f18725a.removeMessages(i, obj);
        }
    }

    /* renamed from: a */
    private void m15903a(int i, MessageArg messageArg) {
        if (messageArg.delayMills < 0 || TextUtils.isEmpty(messageArg.funcId)) {
            LogUtil.m16839e("postMessage:delayMills or funcId is invalid");
            return;
        }
        this.f18725a.sendMessageDelayed(this.f18725a.obtainMessage(i, messageArg), messageArg.delayMills);
    }

    /* renamed from: a */
    private long m15902a(JSArray jSArray) {
        try {
            if (jSArray.length() < 2) {
                return -1;
            }
            return ((Number) jSArray.get(1)).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: b */
    private String m15905b(JSArray jSArray) {
        try {
            if (jSArray.length() < 1) {
                return null;
            }
            return String.valueOf(jSArray.getInteger(0));
        } catch (Exception unused) {
            return null;
        }
    }

    public Map<String, MessageArg> getMessageArgs() {
        return this.f18726b;
    }

    private static class MessageArg {
        CallbackFunction callback;
        long delayMills;
        String funcId;

        private MessageArg() {
        }

        public static MessageArg create(String str, long j, CallbackFunction callbackFunction) {
            MessageArg messageArg = new MessageArg();
            messageArg.funcId = str;
            messageArg.callback = callbackFunction;
            messageArg.delayMills = j;
            return messageArg;
        }
    }
}
