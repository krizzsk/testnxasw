package p218io.socket.client;

import p218io.socket.emitter.Emitter;

/* renamed from: io.socket.client.On */
public class C19376On {

    /* renamed from: io.socket.client.On$Handle */
    public interface Handle {
        void destroy();
    }

    private C19376On() {
    }

    /* renamed from: on */
    public static Handle m41019on(final Emitter emitter, final String str, final Emitter.Listener listener) {
        emitter.mo148487on(str, listener);
        return new Handle() {
            public void destroy() {
                emitter.off(str, listener);
            }
        };
    }
}
