package p218io.socket.hasbinary;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.socket.hasbinary.HasBinary */
public class HasBinary {

    /* renamed from: a */
    private static final Logger f55281a = Logger.getLogger(HasBinary.class.getName());

    private HasBinary() {
    }

    public static boolean hasBinary(Object obj) {
        return m41085a(obj);
    }

    /* renamed from: a */
    private static boolean m41085a(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof byte[]) {
            return true;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    if (m41085a(jSONArray.isNull(i) ? null : jSONArray.get(i))) {
                        return true;
                    }
                    i++;
                } catch (JSONException e) {
                    f55281a.log(Level.WARNING, "An error occured while retrieving data from JSONArray", e);
                    return false;
                }
            }
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    if (m41085a(jSONObject.get(keys.next()))) {
                        return true;
                    }
                } catch (JSONException e2) {
                    f55281a.log(Level.WARNING, "An error occured while retrieving data from JSONObject", e2);
                }
            }
        }
        return false;
    }
}
