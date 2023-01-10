package p218io.socket.parser;

/* renamed from: io.socket.parser.Parser */
public interface Parser {
    public static final int ACK = 3;
    public static final int BINARY_ACK = 6;
    public static final int BINARY_EVENT = 5;
    public static final int CONNECT = 0;
    public static final int DISCONNECT = 1;
    public static final int ERROR = 4;
    public static final int EVENT = 2;
    public static final int protocol = 4;
    public static final String[] types = {"CONNECT", "DISCONNECT", "EVENT", "ACK", "ERROR", "BINARY_EVENT", "BINARY_ACK"};

    /* renamed from: io.socket.parser.Parser$Decoder */
    public interface Decoder {

        /* renamed from: io.socket.parser.Parser$Decoder$Callback */
        public interface Callback {
            void call(Packet packet);
        }

        void add(String str);

        void add(byte[] bArr);

        void destroy();

        void onDecoded(Callback callback);
    }

    /* renamed from: io.socket.parser.Parser$Encoder */
    public interface Encoder {

        /* renamed from: io.socket.parser.Parser$Encoder$Callback */
        public interface Callback {
            void call(Object[] objArr);
        }

        void encode(Packet packet, Callback callback);
    }
}
