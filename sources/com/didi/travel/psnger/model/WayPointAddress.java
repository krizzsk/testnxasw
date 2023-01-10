package com.didi.travel.psnger.model;

import android.text.TextUtils;
import com.didi.sdk.address.address.entity.Address;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WayPointAddress {
    public static final int STATUS_ARRIVED = 1;
    public static final int STATUS_NO_ARRIVED = 0;

    /* renamed from: a */
    private int f46870a = 0;

    /* renamed from: b */
    private Address f46871b = new Address();

    public WayPointAddress() {
    }

    public WayPointAddress(Address address) {
        if (address != null) {
            setStatus(0);
            if (!TextUtils.isEmpty(address.poiId)) {
                setPoiId(address.poiId);
            } else {
                setPoiId(address.uid);
            }
            this.f46871b = address;
        }
    }

    public WayPointAddress(int i, double d, double d2, String str, String str2, String str3) {
        setStatus(i);
        setLatitude(d);
        setLongitude(d2);
        setPoiId(str);
        setName(str2);
        setAddress(str3);
    }

    public static WayPointAddress createWayPointAddress(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new WayPointAddress(jSONObject.getInt("status"), jSONObject.getDouble("lat"), jSONObject.getDouble("lng"), jSONObject.getString("poi_id"), jSONObject.getString("name"), jSONObject.getString("address"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String listToJson(List<WayPointAddress> list) {
        if (list == null) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (WayPointAddress json : list) {
                JSONObject json2 = json.toJson();
                if (json2 != null) {
                    jSONArray.put(json2);
                }
            }
            return jSONArray.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", getStatus());
            jSONObject.put("lat", getLatitude());
            jSONObject.put("lng", getLongitude());
            jSONObject.put("poi_id", getPoiId());
            jSONObject.put("name", getName());
            jSONObject.put("address", getAddress());
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<WayPointAddress> jsonToList(String str) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    WayPointAddress createWayPointAddress = createWayPointAddress(jSONArray.getJSONObject(i));
                    if (createWayPointAddress != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(createWayPointAddress);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void setStatus(int i) {
        this.f46870a = i;
    }

    public int getStatus() {
        return this.f46870a;
    }

    public void setLatitude(double d) {
        this.f46871b.setLatitude(d);
    }

    public double getLatitude() {
        return this.f46871b.getLatitude();
    }

    public void setLongitude(double d) {
        this.f46871b.setLongitude(d);
    }

    public double getLongitude() {
        return this.f46871b.getLongitude();
    }

    public void setPoiId(String str) {
        this.f46871b.poiId = str;
    }

    public String getPoiId() {
        if (TextUtils.isEmpty(this.f46871b.poiId)) {
            return this.f46871b.uid;
        }
        return this.f46871b.poiId;
    }

    public void setName(String str) {
        this.f46871b.displayName = str;
    }

    public String getName() {
        return this.f46871b.displayName;
    }

    public void setAddress(String str) {
        this.f46871b.address = str;
    }

    public String getAddress() {
        return this.f46871b.address;
    }

    public Address getAddressObject() {
        return this.f46871b;
    }

    public boolean valid() {
        return !TextUtils.isEmpty(getPoiId()) && !"null".equalsIgnoreCase(getPoiId());
    }
}
