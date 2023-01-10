package p218io.flutter.embedding.engine;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import p218io.flutter.FlutterInjector;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.dart.DartExecutor;
import p218io.flutter.embedding.engine.loader.FlutterLoader;

/* renamed from: io.flutter.embedding.engine.FlutterEngineGroup */
public class FlutterEngineGroup {

    /* renamed from: a */
    final List<FlutterEngine> f60366a;

    public FlutterEngineGroup(Context context) {
        this(context, (String[]) null);
    }

    public FlutterEngineGroup(Context context, String[] strArr) {
        this.f60366a = new ArrayList();
        FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
        if (!flutterLoader.initialized()) {
            flutterLoader.startInitialization(context.getApplicationContext());
            flutterLoader.ensureInitializationComplete(context.getApplicationContext(), strArr);
        }
    }

    public FlutterEngine createAndRunDefaultEngine(Context context) {
        return createAndRunEngine(context, (DartExecutor.DartEntrypoint) null);
    }

    public FlutterEngine createAndRunEngine(Context context, DartExecutor.DartEntrypoint dartEntrypoint) {
        return createAndRunEngine(context, dartEntrypoint, (String) null);
    }

    public FlutterEngine createAndRunEngine(Context context, DartExecutor.DartEntrypoint dartEntrypoint, String str) {
        return createAndRunEngine(new Options(context).setDartEntrypoint(dartEntrypoint).setInitialRoute(str));
    }

    public FlutterEngine createAndRunEngine(Options options) {
        final FlutterEngine flutterEngine;
        Context context = options.getContext();
        DartExecutor.DartEntrypoint dartEntrypoint = options.getDartEntrypoint();
        String initialRoute = options.getInitialRoute();
        List<String> dartEntrypointArgs = options.getDartEntrypointArgs();
        if (dartEntrypoint == null) {
            dartEntrypoint = DartExecutor.DartEntrypoint.createDefault();
        }
        if (this.f60366a.size() == 0) {
            flutterEngine = mo182199a(context);
            if (initialRoute != null) {
                flutterEngine.getNavigationChannel().setInitialRoute(initialRoute);
            }
            flutterEngine.getDartExecutor().executeDartEntrypoint(dartEntrypoint, dartEntrypointArgs);
        } else {
            flutterEngine = this.f60366a.get(0).mo182112a(context, dartEntrypoint, initialRoute, dartEntrypointArgs);
        }
        this.f60366a.add(flutterEngine);
        flutterEngine.addEngineLifecycleListener(new FlutterEngine.EngineLifecycleListener() {
            public void onPreEngineRestart() {
            }

            public void onEngineWillDestroy() {
                FlutterEngineGroup.this.f60366a.remove(flutterEngine);
            }
        });
        return flutterEngine;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public FlutterEngine mo182199a(Context context) {
        return new FlutterEngine(context);
    }

    /* renamed from: io.flutter.embedding.engine.FlutterEngineGroup$Options */
    public static class Options {
        private Context context;
        private DartExecutor.DartEntrypoint dartEntrypoint;
        private List<String> dartEntrypointArgs;
        private String initialRoute;

        public Options(Context context2) {
            this.context = context2;
        }

        public Context getContext() {
            return this.context;
        }

        public DartExecutor.DartEntrypoint getDartEntrypoint() {
            return this.dartEntrypoint;
        }

        public String getInitialRoute() {
            return this.initialRoute;
        }

        public List<String> getDartEntrypointArgs() {
            return this.dartEntrypointArgs;
        }

        public Options setDartEntrypoint(DartExecutor.DartEntrypoint dartEntrypoint2) {
            this.dartEntrypoint = dartEntrypoint2;
            return this;
        }

        public Options setInitialRoute(String str) {
            this.initialRoute = str;
            return this;
        }

        public Options setDartEntrypointArgs(List<String> list) {
            this.dartEntrypointArgs = list;
            return this;
        }
    }
}
