package p218io.flutter.embedding.engine.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: io.flutter.embedding.engine.loader.ApplicationInfoLoader */
public final class ApplicationInfoLoader {
    public static final String NETWORK_POLICY_METADATA_KEY = "io.flutter.network-policy";
    public static final String PUBLIC_AOT_SHARED_LIBRARY_NAME = (FlutterLoader.class.getName() + '.' + "aot-shared-library-name");
    public static final String PUBLIC_AUTOMATICALLY_REGISTER_PLUGINS_METADATA_KEY = "io.flutter.automatically-register-plugins";
    public static final String PUBLIC_FLUTTER_ASSETS_DIR_KEY = (FlutterLoader.class.getName() + '.' + "flutter-assets-dir");
    public static final String PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY = (FlutterLoader.class.getName() + '.' + "isolate-snapshot-data");
    public static final String PUBLIC_VM_SNAPSHOT_DATA_KEY = (FlutterLoader.class.getName() + '.' + "vm-snapshot-data");

    /* renamed from: a */
    private static ApplicationInfo m45565a(Context context) {
        try {
            return SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static String m45567a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str, (String) null);
    }

    /* renamed from: a */
    private static boolean m45570a(Bundle bundle, String str, boolean z) {
        return bundle == null ? z : bundle.getBoolean(str, z);
    }

    /* renamed from: a */
    private static String m45566a(ApplicationInfo applicationInfo, Context context) {
        int i;
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i = bundle.getInt(NETWORK_POLICY_METADATA_KEY, 0)) <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            XmlResourceParser xml = context.getResources().getXml(i);
            xml.next();
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2 && xml.getName().equals("domain-config")) {
                    m45569a(xml, jSONArray, false);
                }
            }
            return jSONArray.toString();
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static void m45569a(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z) throws IOException, XmlPullParserException {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue((String) null, "cleartextTrafficPermitted", z);
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                if (xmlResourceParser.getName().equals("domain")) {
                    m45571b(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else if (xmlResourceParser.getName().equals("domain-config")) {
                    m45569a(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else {
                    m45568a(xmlResourceParser);
                }
            } else if (next == 3) {
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m45568a(XmlResourceParser xmlResourceParser) throws IOException, XmlPullParserException {
        String name = xmlResourceParser.getName();
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            if (eventType != 3 || xmlResourceParser.getName() != name) {
                eventType = xmlResourceParser.next();
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private static void m45571b(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z) throws IOException, XmlPullParserException {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue((String) null, "includeSubdomains", false);
        xmlResourceParser.next();
        if (xmlResourceParser.getEventType() == 4) {
            String trim = xmlResourceParser.getText().trim();
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(trim);
            jSONArray2.put(attributeBooleanValue);
            jSONArray2.put(z);
            jSONArray.put(jSONArray2);
            xmlResourceParser.next();
            if (xmlResourceParser.getEventType() != 3) {
                throw new IllegalStateException("Expected end of domain tag");
            }
            return;
        }
        throw new IllegalStateException("Expected text");
    }

    public static FlutterApplicationInfo load(Context context) {
        ApplicationInfo a = m45565a(context);
        return new FlutterApplicationInfo(m45567a(a.metaData, PUBLIC_AOT_SHARED_LIBRARY_NAME), m45567a(a.metaData, PUBLIC_VM_SNAPSHOT_DATA_KEY), m45567a(a.metaData, PUBLIC_ISOLATE_SNAPSHOT_DATA_KEY), m45567a(a.metaData, PUBLIC_FLUTTER_ASSETS_DIR_KEY), m45566a(a, context), a.nativeLibraryDir, m45570a(a.metaData, PUBLIC_AUTOMATICALLY_REGISTER_PLUGINS_METADATA_KEY, true));
    }
}
