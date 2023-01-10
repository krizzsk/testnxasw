package p218io.flutter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import p218io.flutter.embedding.engine.FlutterJNI;
import p218io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import p218io.flutter.embedding.engine.loader.FlutterLoader;

/* renamed from: io.flutter.FlutterInjector */
public final class FlutterInjector {

    /* renamed from: a */
    private static FlutterInjector f60069a;

    /* renamed from: b */
    private static boolean f60070b;

    /* renamed from: c */
    private FlutterLoader f60071c;

    /* renamed from: d */
    private DeferredComponentManager f60072d;

    /* renamed from: e */
    private FlutterJNI.Factory f60073e;

    /* renamed from: f */
    private ExecutorService f60074f;

    public static void setInstance(FlutterInjector flutterInjector) {
        if (!f60070b) {
            f60069a = flutterInjector;
            return;
        }
        throw new IllegalStateException("Cannot change the FlutterInjector instance once it's been read. If you're trying to dependency inject, be sure to do so at the beginning of the program");
    }

    public static FlutterInjector instance() {
        f60070b = true;
        if (f60069a == null) {
            f60069a = new Builder().build();
        }
        return f60069a;
    }

    public static void reset() {
        f60070b = false;
        f60069a = null;
    }

    private FlutterInjector(FlutterLoader flutterLoader, DeferredComponentManager deferredComponentManager, FlutterJNI.Factory factory, ExecutorService executorService) {
        this.f60071c = flutterLoader;
        this.f60072d = deferredComponentManager;
        this.f60073e = factory;
        this.f60074f = executorService;
    }

    public FlutterLoader flutterLoader() {
        return this.f60071c;
    }

    public DeferredComponentManager deferredComponentManager() {
        return this.f60072d;
    }

    public ExecutorService executorService() {
        return this.f60074f;
    }

    public FlutterJNI.Factory getFlutterJNIFactory() {
        return this.f60073e;
    }

    /* renamed from: io.flutter.FlutterInjector$Builder */
    public static final class Builder {
        private DeferredComponentManager deferredComponentManager;
        private ExecutorService executorService;
        private FlutterJNI.Factory flutterJniFactory;
        private FlutterLoader flutterLoader;

        /* renamed from: io.flutter.FlutterInjector$Builder$NamedThreadFactory */
        private class NamedThreadFactory implements ThreadFactory {
            private int threadId;

            private NamedThreadFactory() {
                this.threadId = 0;
            }

            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("flutter-worker-");
                int i = this.threadId;
                this.threadId = i + 1;
                sb.append(i);
                thread.setName(sb.toString());
                return thread;
            }
        }

        public Builder setFlutterLoader(FlutterLoader flutterLoader2) {
            this.flutterLoader = flutterLoader2;
            return this;
        }

        public Builder setDeferredComponentManager(DeferredComponentManager deferredComponentManager2) {
            this.deferredComponentManager = deferredComponentManager2;
            return this;
        }

        public Builder setFlutterJNIFactory(FlutterJNI.Factory factory) {
            this.flutterJniFactory = factory;
            return this;
        }

        public Builder setExecutorService(ExecutorService executorService2) {
            this.executorService = executorService2;
            return this;
        }

        private void fillDefaults() {
            if (this.flutterJniFactory == null) {
                this.flutterJniFactory = new FlutterJNI.Factory();
            }
            if (this.executorService == null) {
                this.executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
            }
            if (this.flutterLoader == null) {
                this.flutterLoader = new FlutterLoader(this.flutterJniFactory.provideFlutterJNI(), this.executorService);
            }
        }

        public FlutterInjector build() {
            fillDefaults();
            return new FlutterInjector(this.flutterLoader, this.deferredComponentManager, this.flutterJniFactory, this.executorService);
        }
    }
}
