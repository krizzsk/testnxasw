package p218io.socket.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.WebSocket;
import p218io.socket.backo.Backoff;
import p218io.socket.client.C19376On;
import p218io.socket.emitter.Emitter;
import p218io.socket.engineio.client.Socket;
import p218io.socket.parser.IOParser;
import p218io.socket.parser.Packet;
import p218io.socket.parser.Parser;
import p218io.socket.thread.EventThread;
import rui.config.RConfigConstants;

/* renamed from: io.socket.client.Manager */
public class Manager extends Emitter {
    public static final String EVENT_CLOSE = "close";
    public static final String EVENT_CONNECT_ERROR = "connect_error";
    public static final String EVENT_CONNECT_TIMEOUT = "connect_timeout";
    public static final String EVENT_ERROR = "error";
    public static final String EVENT_OPEN = "open";
    public static final String EVENT_PACKET = "packet";
    public static final String EVENT_PING = "ping";
    public static final String EVENT_PONG = "pong";
    public static final String EVENT_RECONNECT = "reconnect";
    public static final String EVENT_RECONNECTING = "reconnecting";
    public static final String EVENT_RECONNECT_ATTEMPT = "reconnect_attempt";
    public static final String EVENT_RECONNECT_ERROR = "reconnect_error";
    public static final String EVENT_RECONNECT_FAILED = "reconnect_failed";
    public static final String EVENT_TRANSPORT = "transport";

    /* renamed from: a */
    static WebSocket.Factory f55230a;

    /* renamed from: b */
    static Call.Factory f55231b;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final Logger f55232f = Logger.getLogger(Manager.class.getName());

    /* renamed from: c */
    ReadyState f55233c;

    /* renamed from: d */
    Socket f55234d;

    /* renamed from: e */
    ConcurrentHashMap<String, Socket> f55235e;

    /* renamed from: g */
    private boolean f55236g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f55237h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f55238i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f55239j;

    /* renamed from: k */
    private int f55240k;

    /* renamed from: l */
    private long f55241l;

    /* renamed from: m */
    private long f55242m;

    /* renamed from: n */
    private double f55243n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Backoff f55244o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f55245p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Set<Socket> f55246q;

    /* renamed from: r */
    private Date f55247r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public URI f55248s;

    /* renamed from: t */
    private List<Packet> f55249t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public Queue<C19376On.Handle> f55250u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Options f55251v;

    /* renamed from: w */
    private Parser.Encoder f55252w;

    /* renamed from: x */
    private Parser.Decoder f55253x;

    /* renamed from: io.socket.client.Manager$OpenCallback */
    public interface OpenCallback {
        void call(Exception exc);
    }

    /* renamed from: io.socket.client.Manager$Options */
    public static class Options extends Socket.Options {
        public Parser.Decoder decoder;
        public Parser.Encoder encoder;
        public double randomizationFactor;
        public boolean reconnection = true;
        public int reconnectionAttempts;
        public long reconnectionDelay;
        public long reconnectionDelayMax;
        public long timeout = 20000;
    }

    /* renamed from: io.socket.client.Manager$ReadyState */
    enum ReadyState {
        CLOSED,
        OPENING,
        OPEN
    }

    public Manager() {
        this((URI) null, (Options) null);
    }

    public Manager(URI uri) {
        this(uri, (Options) null);
    }

    public Manager(Options options) {
        this((URI) null, options);
    }

    public Manager(URI uri, Options options) {
        this.f55246q = new HashSet();
        options = options == null ? new Options() : options;
        if (options.path == null) {
            options.path = "/socket.io";
        }
        if (options.webSocketFactory == null) {
            options.webSocketFactory = f55230a;
        }
        if (options.callFactory == null) {
            options.callFactory = f55231b;
        }
        this.f55251v = options;
        this.f55235e = new ConcurrentHashMap<>();
        this.f55250u = new LinkedList();
        reconnection(options.reconnection);
        reconnectionAttempts(options.reconnectionAttempts != 0 ? options.reconnectionAttempts : Integer.MAX_VALUE);
        reconnectionDelay(options.reconnectionDelay != 0 ? options.reconnectionDelay : 1000);
        reconnectionDelayMax(options.reconnectionDelayMax != 0 ? options.reconnectionDelayMax : 5000);
        randomizationFactor(options.randomizationFactor != 0.0d ? options.randomizationFactor : 0.5d);
        this.f55244o = new Backoff().setMin(reconnectionDelay()).setMax(reconnectionDelayMax()).setJitter(randomizationFactor());
        timeout(options.timeout);
        this.f55233c = ReadyState.CLOSED;
        this.f55248s = uri;
        this.f55239j = false;
        this.f55249t = new ArrayList();
        this.f55252w = options.encoder != null ? options.encoder : new IOParser.Encoder();
        this.f55253x = options.decoder != null ? options.decoder : new IOParser.Decoder();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40982a(String str, Object... objArr) {
        emit(str, objArr);
        for (Socket emit : this.f55235e.values()) {
            emit.emit(str, objArr);
        }
    }

    /* renamed from: c */
    private void m40992c() {
        for (Map.Entry next : this.f55235e.entrySet()) {
            ((Socket) next.getValue()).f55255a = m40974a((String) next.getKey());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m40974a(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if ("/".equals(str)) {
            str2 = "";
        } else {
            str2 = str + RConfigConstants.KEYWORD_COLOR_SIGN;
        }
        sb.append(str2);
        sb.append(this.f55234d.mo148491id());
        return sb.toString();
    }

    public boolean reconnection() {
        return this.f55236g;
    }

    public Manager reconnection(boolean z) {
        this.f55236g = z;
        return this;
    }

    public boolean isReconnecting() {
        return this.f55238i;
    }

    public int reconnectionAttempts() {
        return this.f55240k;
    }

    public Manager reconnectionAttempts(int i) {
        this.f55240k = i;
        return this;
    }

    public final long reconnectionDelay() {
        return this.f55241l;
    }

    public Manager reconnectionDelay(long j) {
        this.f55241l = j;
        Backoff backoff = this.f55244o;
        if (backoff != null) {
            backoff.setMin(j);
        }
        return this;
    }

    public final double randomizationFactor() {
        return this.f55243n;
    }

    public Manager randomizationFactor(double d) {
        this.f55243n = d;
        Backoff backoff = this.f55244o;
        if (backoff != null) {
            backoff.setJitter(d);
        }
        return this;
    }

    public final long reconnectionDelayMax() {
        return this.f55242m;
    }

    public Manager reconnectionDelayMax(long j) {
        this.f55242m = j;
        Backoff backoff = this.f55244o;
        if (backoff != null) {
            backoff.setMax(j);
        }
        return this;
    }

    public long timeout() {
        return this.f55245p;
    }

    public Manager timeout(long j) {
        this.f55245p = j;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m40996d() {
        if (!this.f55238i && this.f55236g && this.f55244o.getAttempts() == 0) {
            m41009j();
        }
    }

    public Manager open() {
        return open((OpenCallback) null);
    }

    public Manager open(final OpenCallback openCallback) {
        EventThread.exec(new Runnable() {
            public void run() {
                if (Manager.f55232f.isLoggable(Level.FINE)) {
                    Manager.f55232f.fine(String.format("readyState %s", new Object[]{Manager.this.f55233c}));
                }
                if (Manager.this.f55233c != ReadyState.OPEN && Manager.this.f55233c != ReadyState.OPENING) {
                    if (Manager.f55232f.isLoggable(Level.FINE)) {
                        Manager.f55232f.fine(String.format("opening %s", new Object[]{Manager.this.f55248s}));
                    }
                    Manager manager = Manager.this;
                    manager.f55234d = new Engine(manager.f55248s, Manager.this.f55251v);
                    final Socket socket = Manager.this.f55234d;
                    final Manager manager2 = Manager.this;
                    manager2.f55233c = ReadyState.OPENING;
                    boolean unused = Manager.this.f55237h = false;
                    socket.mo148487on("transport", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            manager2.emit("transport", objArr);
                        }
                    });
                    C19376On.Handle on = C19376On.m41019on(socket, "open", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            manager2.m40998e();
                            if (openCallback != null) {
                                openCallback.call((Exception) null);
                            }
                        }
                    });
                    C19376On.Handle on2 = C19376On.m41019on(socket, "error", new Emitter.Listener() {
                        public void call(Object... objArr) {
                            Exception exc = null;
                            Exception exc2 = objArr.length > 0 ? objArr[0] : null;
                            Manager.f55232f.fine("connect_error");
                            manager2.m41006i();
                            manager2.f55233c = ReadyState.CLOSED;
                            manager2.m40982a("connect_error", exc2);
                            if (openCallback != null) {
                                if (exc2 instanceof Exception) {
                                    exc = exc2;
                                }
                                openCallback.call(new SocketIOException("Connection error", exc));
                                return;
                            }
                            manager2.m40996d();
                        }
                    });
                    if (Manager.this.f55245p >= 0) {
                        long f = Manager.this.f55245p;
                        Manager.f55232f.fine(String.format("connection attempt will timeout after %d", new Object[]{Long.valueOf(f)}));
                        final Timer timer = new Timer();
                        final long j = f;
                        final C19376On.Handle handle = on;
                        timer.schedule(new TimerTask() {
                            public void run() {
                                EventThread.exec(new Runnable() {
                                    public void run() {
                                        Manager.f55232f.fine(String.format("connect attempt timed out after %d", new Object[]{Long.valueOf(j)}));
                                        handle.destroy();
                                        socket.close();
                                        socket.emit("error", new SocketIOException("timeout"));
                                        manager2.m40982a("connect_timeout", Long.valueOf(j));
                                    }
                                });
                            }
                        }, f);
                        Manager.this.f55250u.add(new C19376On.Handle() {
                            public void destroy() {
                                timer.cancel();
                            }
                        });
                    }
                    Manager.this.f55250u.add(on);
                    Manager.this.f55250u.add(on2);
                    Manager.this.f55234d.open();
                }
            }
        });
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m40998e() {
        f55232f.fine("open");
        m41006i();
        this.f55233c = ReadyState.OPEN;
        emit("open", new Object[0]);
        Socket socket = this.f55234d;
        this.f55250u.add(C19376On.m41019on(socket, "data", new Emitter.Listener() {
            public void call(Object... objArr) {
                String str = objArr[0];
                if (str instanceof String) {
                    Manager.this.m40989b(str);
                } else if (str instanceof byte[]) {
                    Manager.this.m40983a((byte[]) str);
                }
            }
        }));
        this.f55250u.add(C19376On.m41019on(socket, "ping", new Emitter.Listener() {
            public void call(Object... objArr) {
                Manager.this.m41001f();
            }
        }));
        this.f55250u.add(C19376On.m41019on(socket, "pong", new Emitter.Listener() {
            public void call(Object... objArr) {
                Manager.this.m41003g();
            }
        }));
        this.f55250u.add(C19376On.m41019on(socket, "error", new Emitter.Listener() {
            public void call(Object... objArr) {
                Manager.this.m40981a(objArr[0]);
            }
        }));
        this.f55250u.add(C19376On.m41019on(socket, "close", new Emitter.Listener() {
            public void call(Object... objArr) {
                Manager.this.m40994c(objArr[0]);
            }
        }));
        this.f55253x.onDecoded(new Parser.Decoder.Callback() {
            public void call(Packet packet) {
                Manager.this.m40988b(packet);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m41001f() {
        this.f55247r = new Date();
        m40982a("ping", new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m41003g() {
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(this.f55247r != null ? new Date().getTime() - this.f55247r.getTime() : 0);
        m40982a("pong", objArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40989b(String str) {
        this.f55253x.add(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40983a(byte[] bArr) {
        this.f55253x.add(bArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m40988b(Packet packet) {
        emit("packet", packet);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40981a(Exception exc) {
        f55232f.log(Level.FINE, "error", exc);
        m40982a("error", exc);
    }

    public Socket socket(final String str, Options options) {
        Socket socket = this.f55235e.get(str);
        if (socket != null) {
            return socket;
        }
        final Socket socket2 = new Socket(this, str, options);
        Socket putIfAbsent = this.f55235e.putIfAbsent(str, socket2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        socket2.mo148487on(Socket.EVENT_CONNECTING, new Emitter.Listener() {
            public void call(Object... objArr) {
                this.f55246q.add(socket2);
            }
        });
        socket2.mo148487on("connect", new Emitter.Listener() {
            public void call(Object... objArr) {
                socket2.f55255a = this.m40974a(str);
            }
        });
        return socket2;
    }

    public Socket socket(String str) {
        return socket(str, (Options) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo148437a(Socket socket) {
        this.f55246q.remove(socket);
        if (this.f55246q.isEmpty()) {
            mo148436a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo148438a(Packet packet) {
        if (f55232f.isLoggable(Level.FINE)) {
            f55232f.fine(String.format("writing packet %s", new Object[]{packet}));
        }
        if (packet.query != null && !packet.query.isEmpty() && packet.type == 0) {
            packet.nsp += "?" + packet.query;
        }
        if (!this.f55239j) {
            this.f55239j = true;
            this.f55252w.encode(packet, new Parser.Encoder.Callback() {
                public void call(Object[] objArr) {
                    for (String str : objArr) {
                        if (str instanceof String) {
                            this.f55234d.write(str);
                        } else if (str instanceof byte[]) {
                            this.f55234d.write((byte[]) str);
                        }
                    }
                    boolean unused = this.f55239j = false;
                    this.m41004h();
                }
            });
            return;
        }
        this.f55249t.add(packet);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m41004h() {
        if (!this.f55249t.isEmpty() && !this.f55239j) {
            mo148438a(this.f55249t.remove(0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m41006i() {
        f55232f.fine("cleanup");
        while (true) {
            C19376On.Handle poll = this.f55250u.poll();
            if (poll != null) {
                poll.destroy();
            } else {
                this.f55253x.onDecoded((Parser.Decoder.Callback) null);
                this.f55249t.clear();
                this.f55239j = false;
                this.f55247r = null;
                this.f55253x.destroy();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo148436a() {
        f55232f.fine(Socket.EVENT_DISCONNECT);
        this.f55237h = true;
        this.f55238i = false;
        if (this.f55233c != ReadyState.OPEN) {
            m41006i();
        }
        this.f55244o.reset();
        this.f55233c = ReadyState.CLOSED;
        Socket socket = this.f55234d;
        if (socket != null) {
            socket.close();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m40994c(String str) {
        f55232f.fine("onclose");
        m41006i();
        this.f55244o.reset();
        this.f55233c = ReadyState.CLOSED;
        emit("close", str);
        if (this.f55236g && !this.f55237h) {
            m41009j();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m41009j() {
        if (!this.f55238i && !this.f55237h) {
            if (this.f55244o.getAttempts() >= this.f55240k) {
                f55232f.fine("reconnect failed");
                this.f55244o.reset();
                m40982a("reconnect_failed", new Object[0]);
                this.f55238i = false;
                return;
            }
            long duration = this.f55244o.duration();
            f55232f.fine(String.format("will wait %dms before reconnect attempt", new Object[]{Long.valueOf(duration)}));
            this.f55238i = true;
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    EventThread.exec(new Runnable() {
                        public void run() {
                            if (!this.f55237h) {
                                Manager.f55232f.fine("attempting reconnect");
                                int attempts = this.f55244o.getAttempts();
                                this.m40982a("reconnect_attempt", Integer.valueOf(attempts));
                                this.m40982a("reconnecting", Integer.valueOf(attempts));
                                if (!this.f55237h) {
                                    this.open(new OpenCallback() {
                                        public void call(Exception exc) {
                                            if (exc != null) {
                                                Manager.f55232f.fine("reconnect attempt error");
                                                boolean unused = this.f55238i = false;
                                                this.m41009j();
                                                this.m40982a("reconnect_error", exc);
                                                return;
                                            }
                                            Manager.f55232f.fine("reconnect success");
                                            this.m41010k();
                                        }
                                    });
                                }
                            }
                        }
                    });
                }
            }, duration);
            this.f55250u.add(new C19376On.Handle() {
                public void destroy() {
                    timer.cancel();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m41010k() {
        int attempts = this.f55244o.getAttempts();
        this.f55238i = false;
        this.f55244o.reset();
        m40992c();
        m40982a("reconnect", Integer.valueOf(attempts));
    }

    /* renamed from: io.socket.client.Manager$Engine */
    private static class Engine extends Socket {
        Engine(URI uri, Socket.Options options) {
            super(uri, options);
        }
    }
}
