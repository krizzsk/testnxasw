package didihttpdns.model;

import java.io.Serializable;
import org.json.JSONObject;

public class IpRecord implements Serializable {

    /* renamed from: ip */
    private String f59805ip;

    public String getIp() {
        return this.f59805ip;
    }

    public void setIp(String str) {
        this.f59805ip = str;
    }

    public String toString() {
        return this.f59805ip;
    }

    public static IpRecord parseFromJsonObject(JSONObject jSONObject) {
        IpRecord ipRecord = new IpRecord();
        ipRecord.f59805ip = jSONObject.optString("ip");
        return ipRecord;
    }
}
