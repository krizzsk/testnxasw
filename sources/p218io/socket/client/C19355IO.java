package p218io.socket.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.WebSocket;
import p218io.socket.client.Manager;

/* renamed from: io.socket.client.IO */
public class C19355IO {

    /* renamed from: a */
    private static final Logger f55228a = Logger.getLogger(C19355IO.class.getName());

    /* renamed from: b */
    private static final ConcurrentHashMap<String, Manager> f55229b = new ConcurrentHashMap<>();
    public static int protocol = 4;

    /* renamed from: io.socket.client.IO$Options */
    public static class Options extends Manager.Options {
        public boolean forceNew;
        public boolean multiplex = true;
    }

    public static void setDefaultOkHttpWebSocketFactory(WebSocket.Factory factory) {
        Manager.f55230a = factory;
    }

    public static void setDefaultOkHttpCallFactory(Call.Factory factory) {
        Manager.f55231b = factory;
    }

    private C19355IO() {
    }

    public static Socket socket(String str) throws URISyntaxException {
        return socket(str, (Options) null);
    }

    public static Socket socket(String str, Options options) throws URISyntaxException {
        return socket(new URI(str), options);
    }

    public static Socket socket(URI uri) {
        return socket(uri, (Options) null);
    }

    public static Socket socket(URI uri, Options options) {
        Manager manager;
        if (options == null) {
            options = new Options();
        }
        URL parse = Url.parse(uri);
        try {
            URI uri2 = parse.toURI();
            String extractId = Url.extractId(parse);
            if (options.forceNew || !options.multiplex || (f55229b.containsKey(extractId) && f55229b.get(extractId).f55235e.containsKey(parse.getPath()))) {
                if (f55228a.isLoggable(Level.FINE)) {
                    f55228a.fine(String.format("ignoring socket cache for %s", new Object[]{uri2}));
                }
                manager = new Manager(uri2, options);
            } else {
                if (!f55229b.containsKey(extractId)) {
                    if (f55228a.isLoggable(Level.FINE)) {
                        f55228a.fine(String.format("new io instance for %s", new Object[]{uri2}));
                    }
                    f55229b.putIfAbsent(extractId, new Manager(uri2, options));
                }
                manager = f55229b.get(extractId);
            }
            String query = parse.getQuery();
            if (query != null && (options.query == null || options.query.isEmpty())) {
                options.query = query;
            }
            return manager.socket(parse.getPath(), options);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
