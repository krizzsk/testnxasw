package p218io.socket.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p218io.socket.client.C19376On;
import p218io.socket.client.Manager;
import p218io.socket.emitter.Emitter;
import p218io.socket.parser.Packet;
import p218io.socket.thread.EventThread;

/* renamed from: io.socket.client.Socket */
public class Socket extends Emitter {
    public static final String EVENT_CONNECT = "connect";
    public static final String EVENT_CONNECTING = "connecting";
    public static final String EVENT_CONNECT_ERROR = "connect_error";
    public static final String EVENT_CONNECT_TIMEOUT = "connect_timeout";
    public static final String EVENT_DISCONNECT = "disconnect";
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_MESSAGE = "message";
    public static final String EVENT_PING = "ping";
    public static final String EVENT_PONG = "pong";
    public static final String EVENT_RECONNECT = "reconnect";
    public static final String EVENT_RECONNECTING = "reconnecting";
    public static final String EVENT_RECONNECT_ATTEMPT = "reconnect_attempt";
    public static final String EVENT_RECONNECT_ERROR = "reconnect_error";
    public static final String EVENT_RECONNECT_FAILED = "reconnect_failed";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Logger f55254b = Logger.getLogger(Socket.class.getName());
    protected static Map<String, Integer> events = new HashMap<String, Integer>() {
        {
            put("connect", 1);
            put("connect_error", 1);
            put("connect_timeout", 1);
            put(Socket.EVENT_CONNECTING, 1);
            put(Socket.EVENT_DISCONNECT, 1);
            put("error", 1);
            put("reconnect", 1);
            put("reconnect_attempt", 1);
            put("reconnect_failed", 1);
            put("reconnect_error", 1);
            put("reconnecting", 1);
            put("ping", 1);
            put("pong", 1);
        }
    };

    /* renamed from: a */
    String f55255a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile boolean f55256c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f55257d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f55258e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Manager f55259f;

    /* renamed from: g */
    private String f55260g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Map<Integer, Ack> f55261h = new HashMap();

    /* renamed from: i */
    private Queue<C19376On.Handle> f55262i;

    /* renamed from: j */
    private final Queue<List<Object>> f55263j = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Queue<Packet<JSONArray>> f55264k = new LinkedList();

    /* renamed from: g */
    static /* synthetic */ int m41043g(Socket socket) {
        int i = socket.f55257d;
        socket.f55257d = i + 1;
        return i;
    }

    public Socket(Manager manager, String str, Manager.Options options) {
        this.f55259f = manager;
        this.f55258e = str;
        if (options != null) {
            this.f55260g = options.query;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41029b() {
        if (this.f55262i == null) {
            final Manager manager = this.f55259f;
            this.f55262i = new LinkedList<C19376On.Handle>() {
                {
                    add(C19376On.m41019on(manager, "open", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            Socket.this.m41034c();
                        }
                    }));
                    add(C19376On.m41019on(manager, "packet", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            Socket.this.m41031b((Packet<?>) objArr[0]);
                        }
                    }));
                    add(C19376On.m41019on(manager, "close", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            Socket.this.m41027a(objArr.length > 0 ? objArr[0] : null);
                        }
                    }));
                }
            };
        }
    }

    public Socket open() {
        EventThread.exec(new Runnable() {
            public void run() {
                if (!Socket.this.f55256c && !Socket.this.f55259f.isReconnecting()) {
                    Socket.this.m41029b();
                    Socket.this.f55259f.open();
                    if (Manager.ReadyState.OPEN == Socket.this.f55259f.f55233c) {
                        Socket.this.m41034c();
                    }
                    Socket.this.emit(Socket.EVENT_CONNECTING, new Object[0]);
                }
            }
        });
        return this;
    }

    public Socket connect() {
        return open();
    }

    public Socket send(final Object... objArr) {
        EventThread.exec(new Runnable() {
            public void run() {
                Socket.this.emit("message", objArr);
            }
        });
        return this;
    }

    public Emitter emit(final String str, final Object... objArr) {
        EventThread.exec(new Runnable() {
            public void run() {
                Ack ack;
                Object[] objArr;
                if (Socket.events.containsKey(str)) {
                    Emitter unused = Socket.super.emit(str, objArr);
                    return;
                }
                Object[] objArr2 = objArr;
                int length = objArr2.length - 1;
                if (objArr2.length <= 0 || !(objArr2[length] instanceof Ack)) {
                    objArr = objArr;
                    ack = null;
                } else {
                    objArr = new Object[length];
                    for (int i = 0; i < length; i++) {
                        objArr[i] = objArr[i];
                    }
                    ack = (Ack) objArr[length];
                }
                Socket.this.emit(str, objArr, ack);
            }
        });
        return this;
    }

    public Emitter emit(final String str, final Object[] objArr, final Ack ack) {
        EventThread.exec(new Runnable() {
            public void run() {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                Object[] objArr = objArr;
                if (objArr != null) {
                    for (Object put : objArr) {
                        jSONArray.put(put);
                    }
                }
                Packet packet = new Packet(2, jSONArray);
                if (ack != null) {
                    Socket.f55254b.fine(String.format("emitting packet with ack id %d", new Object[]{Integer.valueOf(Socket.this.f55257d)}));
                    Socket.this.f55261h.put(Integer.valueOf(Socket.this.f55257d), ack);
                    packet.f55286id = Socket.m41043g(Socket.this);
                }
                if (Socket.this.f55256c) {
                    Socket.this.m41026a(packet);
                } else {
                    Socket.this.f55264k.add(packet);
                }
            }
        });
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41026a(Packet packet) {
        packet.nsp = this.f55258e;
        this.f55259f.mo148438a(packet);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m41034c() {
        f55254b.fine("transport is open - connecting");
        if (!"/".equals(this.f55258e)) {
            String str = this.f55260g;
            if (str == null || str.isEmpty()) {
                m41026a(new Packet(0));
                return;
            }
            Packet packet = new Packet(0);
            packet.query = this.f55260g;
            m41026a(packet);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m41027a(String str) {
        if (f55254b.isLoggable(Level.FINE)) {
            f55254b.fine(String.format("close (%s)", new Object[]{str}));
        }
        this.f55256c = false;
        this.f55255a = null;
        emit(EVENT_DISCONNECT, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m41031b(Packet<?> packet) {
        if (this.f55258e.equals(packet.nsp)) {
            switch (packet.type) {
                case 0:
                    m41036d();
                    return;
                case 1:
                    m41042f();
                    return;
                case 2:
                    m41035c((Packet<JSONArray>) packet);
                    return;
                case 3:
                    m41038d((Packet<JSONArray>) packet);
                    return;
                case 4:
                    emit("error", packet.data);
                    return;
                case 5:
                    m41035c((Packet<JSONArray>) packet);
                    return;
                case 6:
                    m41038d((Packet<JSONArray>) packet);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: c */
    private void m41035c(Packet<JSONArray> packet) {
        ArrayList arrayList = new ArrayList(Arrays.asList(m41028a((JSONArray) packet.data)));
        if (f55254b.isLoggable(Level.FINE)) {
            f55254b.fine(String.format("emitting event %s", new Object[]{arrayList}));
        }
        if (packet.f55286id >= 0) {
            f55254b.fine("attaching ack callback to event");
            arrayList.add(m41020a(packet.f55286id));
        }
        if (!this.f55256c) {
            this.f55263j.add(arrayList);
        } else if (!arrayList.isEmpty()) {
            super.emit(arrayList.remove(0).toString(), arrayList.toArray());
        }
    }

    /* renamed from: a */
    private Ack m41020a(final int i) {
        final boolean[] zArr = {false};
        return new Ack() {
            public void call(final Object... objArr) {
                EventThread.exec(new Runnable() {
                    public void run() {
                        if (!zArr[0]) {
                            zArr[0] = true;
                            if (Socket.f55254b.isLoggable(Level.FINE)) {
                                Logger a = Socket.f55254b;
                                Object[] objArr = objArr;
                                if (objArr.length == 0) {
                                    objArr = null;
                                }
                                a.fine(String.format("sending ack %s", objArr));
                            }
                            JSONArray jSONArray = new JSONArray();
                            for (Object put : objArr) {
                                jSONArray.put(put);
                            }
                            Packet packet = new Packet(3, jSONArray);
                            packet.f55286id = i;
                            this.m41026a(packet);
                        }
                    }
                });
            }
        };
    }

    /* renamed from: d */
    private void m41038d(Packet<JSONArray> packet) {
        Ack remove = this.f55261h.remove(Integer.valueOf(packet.f55286id));
        if (remove != null) {
            if (f55254b.isLoggable(Level.FINE)) {
                f55254b.fine(String.format("calling ack %s with %s", new Object[]{Integer.valueOf(packet.f55286id), packet.data}));
            }
            remove.call(m41028a((JSONArray) packet.data));
        } else if (f55254b.isLoggable(Level.FINE)) {
            f55254b.fine(String.format("bad ack %s", new Object[]{Integer.valueOf(packet.f55286id)}));
        }
    }

    /* renamed from: d */
    private void m41036d() {
        this.f55256c = true;
        emit("connect", new Object[0]);
        m41040e();
    }

    /* renamed from: e */
    private void m41040e() {
        while (true) {
            List poll = this.f55263j.poll();
            if (poll == null) {
                break;
            }
            super.emit((String) poll.get(0), poll.toArray());
        }
        this.f55263j.clear();
        while (true) {
            Packet poll2 = this.f55264k.poll();
            if (poll2 != null) {
                m41026a(poll2);
            } else {
                this.f55264k.clear();
                return;
            }
        }
    }

    /* renamed from: f */
    private void m41042f() {
        if (f55254b.isLoggable(Level.FINE)) {
            f55254b.fine(String.format("server disconnect (%s)", new Object[]{this.f55258e}));
        }
        m41044g();
        m41027a("io server disconnect");
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m41044g() {
        Queue<C19376On.Handle> queue = this.f55262i;
        if (queue != null) {
            for (C19376On.Handle destroy : queue) {
                destroy.destroy();
            }
            this.f55262i = null;
        }
        this.f55259f.mo148437a(this);
    }

    public Socket close() {
        EventThread.exec(new Runnable() {
            public void run() {
                if (Socket.this.f55256c) {
                    if (Socket.f55254b.isLoggable(Level.FINE)) {
                        Socket.f55254b.fine(String.format("performing disconnect (%s)", new Object[]{Socket.this.f55258e}));
                    }
                    Socket.this.m41026a(new Packet(1));
                }
                Socket.this.m41044g();
                if (Socket.this.f55256c) {
                    Socket.this.m41027a("io client disconnect");
                }
            }
        });
        return this;
    }

    public Socket disconnect() {
        return close();
    }

    /* renamed from: io */
    public Manager mo148473io() {
        return this.f55259f;
    }

    public boolean connected() {
        return this.f55256c;
    }

    /* renamed from: id */
    public String mo148472id() {
        return this.f55255a;
    }

    /* renamed from: a */
    private static Object[] m41028a(JSONArray jSONArray) {
        Object obj;
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            Object obj2 = null;
            try {
                obj = jSONArray.get(i);
            } catch (JSONException e) {
                f55254b.log(Level.WARNING, "An error occured while retrieving data from JSONArray", e);
                obj = null;
            }
            if (!JSONObject.NULL.equals(obj)) {
                obj2 = obj;
            }
            objArr[i] = obj2;
        }
        return objArr;
    }
}
