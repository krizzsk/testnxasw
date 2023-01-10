package com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket;

import android.util.Log;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.util.LogUtil;
import didihttp.Headers;
import didihttp.Response;
import didihttp.WebSocket;
import didihttp.WebSocketListener;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.json.JSONObject;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0002J$\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u000f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J&\u0010\u0015\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0016\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0016\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\u001b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001e\u0010\u001d\u001a\u00020\b2\b\b\u0001\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo148868d2 = {"Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/DMWebSocketListener;", "Ldidihttp/WebSocketListener;", "mDmMina", "Lcom/didi/dimina/container/DMMina;", "taskId", "", "(Lcom/didi/dimina/container/DMMina;Ljava/lang/String;)V", "onCloseState", "", "code", "", "reason", "onClosed", "webSocket", "Ldidihttp/WebSocket;", "onClosing", "onErrorState", "t", "", "response", "Ldidihttp/Response;", "onFailure", "onMessage", "text", "bytes", "Lokio/ByteString;", "onMessageState", "onOpen", "onOpenState", "onSocketStateChange", "state", "data", "Lorg/json/JSONObject;", "Companion", "2party-impl_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: DMWebSocketListener.kt */
public final class DMWebSocketListener extends WebSocketListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_CODE = "code";
    public static final String KEY_DATA = "data";
    public static final String KEY_ERR_MSG = "errMsg";
    public static final String KEY_HEADER = "header";
    public static final String KEY_REASON = "reason";
    public static final String KEY_STATE = "state";
    public static final String KEY_TASK_ID = "taskId";
    public static final String TAG = "DMWebSocketListener";

    /* renamed from: a */
    private final DMMina f19165a;

    /* renamed from: b */
    private final String f19166b;

    public DMWebSocketListener(DMMina dMMina, String str) {
        Intrinsics.checkParameterIsNotNull(dMMina, "mDmMina");
        Intrinsics.checkParameterIsNotNull(str, KEY_TASK_ID);
        this.f19165a = dMMina;
        this.f19166b = str;
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lcom/didi/dimina/container/secondparty/jsmodule/jsbridge/websocket/DMWebSocketListener$Companion;", "", "()V", "KEY_CODE", "", "KEY_DATA", "KEY_ERR_MSG", "KEY_HEADER", "KEY_REASON", "KEY_STATE", "KEY_TASK_ID", "TAG", "2party-impl_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: DMWebSocketListener.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onOpen(WebSocket webSocket, Response response) {
        LogUtil.iRelease(TAG, "onOpen: taskId " + this.f19166b);
        m16279a(response);
        SocketTaskManager.INSTANCE.addWebSocket(this.f19166b, webSocket);
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        StringBuilder sb = new StringBuilder();
        sb.append("onMessage: taskId ");
        sb.append(this.f19166b);
        sb.append(" bytesSize:");
        sb.append(byteString != null ? Integer.valueOf(byteString.size()) : null);
        sb.append(' ');
        LogUtil.iRelease(TAG, sb.toString());
    }

    public void onMessage(WebSocket webSocket, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("onMessage: taskId ");
        sb.append(this.f19166b);
        sb.append(" webSocket ");
        sb.append(webSocket);
        sb.append(" text:");
        sb.append(str != null ? Integer.valueOf(str.length()) : null);
        sb.append(" text is:");
        sb.append(str);
        LogUtil.iRelease(TAG, sb.toString());
        m16280a(str);
    }

    public void onClosed(WebSocket webSocket, int i, String str) {
        m16277a(i, str);
        SocketTaskManager.INSTANCE.removeWebsocket(this.f19166b);
    }

    public void onClosing(WebSocket webSocket, int i, String str) {
        LogUtil.iRelease(TAG, "onClosing: taskId " + this.f19166b + " code " + i + " reason " + str + ' ');
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        String stackTraceString = Log.getStackTraceString(th);
        Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(t)");
        if (th instanceof EOFException) {
            m16277a(WebSocketCodes.CLOSE_NORMAL.getCode(), "normal close");
            return;
        }
        m16282a(th, response);
        LogUtil.eRelease(TAG, "onFailure: taskId " + this.f19166b + "  errmsg " + stackTraceString);
        StringBuilder sb = new StringBuilder();
        sb.append("onFailure: response ");
        sb.append(response);
        LogUtil.eRelease(TAG, sb.toString());
        LogUtil.eRelease(TAG, "onFailure: webSocket " + webSocket);
    }

    /* renamed from: a */
    private final void m16280a(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", str);
        m16281a("message", jSONObject);
    }

    /* renamed from: a */
    private final void m16279a(Response response) {
        Headers headers = response != null ? response.headers() : null;
        if (headers == null) {
            m16278a(this, "open", (JSONObject) null, 2, (Object) null);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", headers);
        m16281a("open", jSONObject);
    }

    /* renamed from: a */
    private final void m16277a(int i, String str) {
        LogUtil.iRelease(TAG, "onClosed: taskId " + this.f19166b + " code " + i + " reason " + str + ' ');
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", i);
        jSONObject.put("reason", str);
        m16281a("close", jSONObject);
    }

    /* renamed from: a */
    private final void m16282a(Throwable th, Response response) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_ERR_MSG, th != null ? Log.getStackTraceString(th) : null);
        m16281a("error", jSONObject);
    }

    /* renamed from: a */
    static /* synthetic */ void m16278a(DMWebSocketListener dMWebSocketListener, String str, JSONObject jSONObject, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        dMWebSocketListener.m16281a(str, jSONObject);
    }

    /* renamed from: a */
    private final void m16281a(@SocketState String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(KEY_TASK_ID, this.f19166b);
        jSONObject2.put("state", str);
        jSONObject2.put("data", jSONObject);
        LogUtil.iRelease(TAG, "send message to service>> " + jSONObject2);
        this.f19165a.getMessageTransfer().sendMessageToServiceFromNative(InternalJSMethod.ON_SOCKET_STATE_CHANGE, new MessageWrapperBuilder().data(jSONObject2).build());
    }
}
