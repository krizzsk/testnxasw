package rui.config;

import android.content.Context;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import rui.config.model.IRModel;
import rui.config.model.RuleEntry;
import rui.config.parser.ColorParser;
import rui.config.parser.IRParser;
import rui.config.parser.ResourceParser;

public final class RConfigEngine {

    /* renamed from: a */
    private static Map<String, RuleEntry> f8581a = new HashMap();

    /* renamed from: b */
    private static Map<String, IRParser> f8582b = new HashMap();

    /* renamed from: c */
    private static Context f8583c;

    static {
        ColorParser colorParser = new ColorParser();
        ResourceParser resourceParser = new ResourceParser();
        f8582b.put(colorParser.type(), colorParser);
        f8582b.put(resourceParser.type(), resourceParser);
    }

    public static void setConfig(Context context, String str) throws JSONException, ConfigEmptyException {
        f8583c = context.getApplicationContext();
        m7231a(str);
    }

    /* renamed from: a */
    static void m7231a(String str) throws JSONException, ConfigEmptyException {
        List<RuleEntry> a = C3567a.m7232a(str, RConfigConstants.SEGMENT_THEME);
        if (!a.isEmpty()) {
            for (RuleEntry next : a) {
                f8581a.put(next.getName(), next);
            }
            return;
        }
        throw new ConfigEmptyException("config json null");
    }

    public static <T extends IRModel> T get(String str) throws ConfigParseException {
        if (str == null || str.isEmpty()) {
            throw new ConfigParseException("key is null or empty");
        } else if (f8581a.containsKey(str)) {
            RuleEntry ruleEntry = f8581a.get(str);
            if (f8582b.containsKey(ruleEntry.getType())) {
                return f8582b.get(ruleEntry.getType()).parse(ruleEntry.getValue());
            }
            throw new ConfigParseException("parser " + ruleEntry.getType() + " not found");
        } else {
            throw new ConfigParseException("name " + str + " not found");
        }
    }

    public static Context getContext() {
        return f8583c;
    }

    public static void clear() {
        f8581a.clear();
    }

    public static class ConfigEmptyException extends Exception {
        public ConfigEmptyException(String str) {
            super(str);
        }
    }

    public static class ConfigParseException extends Exception {
        public ConfigParseException(String str) {
            super(str);
        }
    }
}
