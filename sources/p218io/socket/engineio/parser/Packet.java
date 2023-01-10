package p218io.socket.engineio.parser;

/* renamed from: io.socket.engineio.parser.Packet */
public class Packet<T> {
    public static final String CLOSE = "close";
    public static final String ERROR = "error";
    public static final String MESSAGE = "message";
    public static final String NOOP = "noop";
    public static final String OPEN = "open";
    public static final String PING = "ping";
    public static final String PONG = "pong";
    public static final String UPGRADE = "upgrade";
    public T data;
    public String type;

    public Packet(String str) {
        this(str, (Object) null);
    }

    public Packet(String str, T t) {
        this.type = str;
        this.data = t;
    }
}
