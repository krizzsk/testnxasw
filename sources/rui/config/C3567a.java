package rui.config;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rui.config.model.RuleEntry;

/* renamed from: rui.config.a */
/* compiled from: RConfigHelper */
final class C3567a {

    /* renamed from: a */
    public static final String f8584a = "type";

    /* renamed from: b */
    public static final String f8585b = "name";

    /* renamed from: c */
    public static final String f8586c = "value";

    private C3567a() {
    }

    /* renamed from: a */
    static List<RuleEntry> m7232a(String str, String str2) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                arrayList.add(new RuleEntry(jSONObject.getString("type"), jSONObject.getString("name"), jSONObject.getString("value")));
            }
        }
        return arrayList;
    }
}
