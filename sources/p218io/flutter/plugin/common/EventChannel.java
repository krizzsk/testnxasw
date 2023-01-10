package p218io.flutter.plugin.common;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p218io.flutter.Log;
import p218io.flutter.plugin.common.BinaryMessenger;

/* renamed from: io.flutter.plugin.common.EventChannel */
public final class EventChannel {

    /* renamed from: a */
    private static final String f60519a = "EventChannel#";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final BinaryMessenger f60520b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f60521c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final MethodCodec f60522d;

    /* renamed from: e */
    private final BinaryMessenger.TaskQueue f60523e;

    /* renamed from: io.flutter.plugin.common.EventChannel$EventSink */
    public interface EventSink {
        void endOfStream();

        void error(String str, String str2, Object obj);

        void success(Object obj);
    }

    /* renamed from: io.flutter.plugin.common.EventChannel$StreamHandler */
    public interface StreamHandler {
        void onCancel(Object obj);

        void onListen(Object obj, EventSink eventSink);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
        this(binaryMessenger, str, methodCodec, (BinaryMessenger.TaskQueue) null);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec, BinaryMessenger.TaskQueue taskQueue) {
        this.f60520b = binaryMessenger;
        this.f60521c = str;
        this.f60522d = methodCodec;
        this.f60523e = taskQueue;
    }

    public void setStreamHandler(StreamHandler streamHandler) {
        IncomingStreamRequestHandler incomingStreamRequestHandler = null;
        if (this.f60523e != null) {
            BinaryMessenger binaryMessenger = this.f60520b;
            String str = this.f60521c;
            if (streamHandler != null) {
                incomingStreamRequestHandler = new IncomingStreamRequestHandler(streamHandler);
            }
            binaryMessenger.setMessageHandler(str, incomingStreamRequestHandler, this.f60523e);
            return;
        }
        BinaryMessenger binaryMessenger2 = this.f60520b;
        String str2 = this.f60521c;
        if (streamHandler != null) {
            incomingStreamRequestHandler = new IncomingStreamRequestHandler(streamHandler);
        }
        binaryMessenger2.setMessageHandler(str2, incomingStreamRequestHandler);
    }

    /* renamed from: io.flutter.plugin.common.EventChannel$IncomingStreamRequestHandler */
    private final class IncomingStreamRequestHandler implements BinaryMessenger.BinaryMessageHandler {
        /* access modifiers changed from: private */
        public final AtomicReference<EventSink> activeSink = new AtomicReference<>((Object) null);
        private final StreamHandler handler;

        IncomingStreamRequestHandler(StreamHandler streamHandler) {
            this.handler = streamHandler;
        }

        public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            MethodCall decodeMethodCall = EventChannel.this.f60522d.decodeMethodCall(byteBuffer);
            if (decodeMethodCall.method.equals("listen")) {
                onListen(decodeMethodCall.arguments, binaryReply);
            } else if (decodeMethodCall.method.equals("cancel")) {
                onCancel(decodeMethodCall.arguments, binaryReply);
            } else {
                binaryReply.reply((ByteBuffer) null);
            }
        }

        private void onListen(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            EventSinkImplementation eventSinkImplementation = new EventSinkImplementation();
            if (this.activeSink.getAndSet(eventSinkImplementation) != null) {
                try {
                    this.handler.onCancel((Object) null);
                } catch (RuntimeException e) {
                    Log.m45256e(EventChannel.f60519a + EventChannel.this.f60521c, "Failed to close existing event stream", e);
                }
            }
            try {
                this.handler.onListen(obj, eventSinkImplementation);
                binaryReply.reply(EventChannel.this.f60522d.encodeSuccessEnvelope((Object) null));
            } catch (RuntimeException e2) {
                this.activeSink.set((Object) null);
                Log.m45256e(EventChannel.f60519a + EventChannel.this.f60521c, "Failed to open event stream", e2);
                binaryReply.reply(EventChannel.this.f60522d.encodeErrorEnvelope("error", e2.getMessage(), (Object) null));
            }
        }

        private void onCancel(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            if (this.activeSink.getAndSet((Object) null) != null) {
                try {
                    this.handler.onCancel(obj);
                    binaryReply.reply(EventChannel.this.f60522d.encodeSuccessEnvelope((Object) null));
                } catch (RuntimeException e) {
                    Log.m45256e(EventChannel.f60519a + EventChannel.this.f60521c, "Failed to close event stream", e);
                    binaryReply.reply(EventChannel.this.f60522d.encodeErrorEnvelope("error", e.getMessage(), (Object) null));
                }
            } else {
                binaryReply.reply(EventChannel.this.f60522d.encodeErrorEnvelope("error", "No active stream to cancel", (Object) null));
            }
        }

        /* renamed from: io.flutter.plugin.common.EventChannel$IncomingStreamRequestHandler$EventSinkImplementation */
        private final class EventSinkImplementation implements EventSink {
            final AtomicBoolean hasEnded;

            private EventSinkImplementation() {
                this.hasEnded = new AtomicBoolean(false);
            }

            public void success(Object obj) {
                if (!this.hasEnded.get() && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.f60520b.send(EventChannel.this.f60521c, EventChannel.this.f60522d.encodeSuccessEnvelope(obj));
                }
            }

            public void error(String str, String str2, Object obj) {
                if (!this.hasEnded.get() && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.f60520b.send(EventChannel.this.f60521c, EventChannel.this.f60522d.encodeErrorEnvelope(str, str2, obj));
                }
            }

            public void endOfStream() {
                if (!this.hasEnded.getAndSet(true) && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.f60520b.send(EventChannel.this.f60521c, (ByteBuffer) null);
                }
            }
        }
    }
}
