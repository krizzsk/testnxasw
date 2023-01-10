package p238for;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: for.if */
/* compiled from: FlashPattern */
public final class C21842if {

    /* renamed from: a */
    private ArrayList<C21839do> f60021a = new ArrayList<>();

    public C21842if(JSONArray jSONArray) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArray2.length()) {
                    break;
                }
                JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                String optString = optJSONObject.optString("type");
                String optString2 = optJSONObject.optString("colour");
                if (optString.toLowerCase().equals("flash") && optString2.length() > 0) {
                    this.f60021a.add(new C21839do(optString2.charAt(0)));
                    break;
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    private static C21839do m45175a() {
        return new C21839do('0');
    }

    /* renamed from: do */
    public List<C21839do> mo180491do(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i; i3++) {
            arrayList.add(m45175a());
        }
        arrayList.addAll(this.f60021a);
        for (int i4 = 0; i4 < i2; i4++) {
            arrayList.add(m45175a());
        }
        return arrayList;
    }

    @Deprecated
    public C21842if(String str) {
        for (int i = 0; i < str.length(); i++) {
            this.f60021a.add(new C21839do(str.charAt(i)));
        }
    }
}
