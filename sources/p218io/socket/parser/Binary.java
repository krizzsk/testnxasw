package p218io.socket.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.socket.parser.Binary */
public class Binary {

    /* renamed from: a */
    private static final String f55282a = "_placeholder";

    /* renamed from: b */
    private static final String f55283b = "num";

    /* renamed from: c */
    private static final Logger f55284c = Logger.getLogger(Binary.class.getName());

    /* renamed from: io.socket.parser.Binary$DeconstructedPacket */
    public static class DeconstructedPacket {
        public byte[][] buffers;
        public Packet packet;
    }

    public static DeconstructedPacket deconstructPacket(Packet packet) {
        ArrayList arrayList = new ArrayList();
        packet.data = m41086a((Object) packet.data, (List<byte[]>) arrayList);
        packet.attachments = arrayList.size();
        DeconstructedPacket deconstructedPacket = new DeconstructedPacket();
        deconstructedPacket.packet = packet;
        deconstructedPacket.buffers = (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
        return deconstructedPacket;
    }

    /* renamed from: a */
    private static Object m41086a(Object obj, List<byte[]> list) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f55282a, true);
                jSONObject.put(f55283b, list.size());
                list.add((byte[]) obj);
                return jSONObject;
            } catch (JSONException e) {
                f55284c.log(Level.WARNING, "An error occured while putting data to JSONObject", e);
                return null;
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = (JSONArray) obj;
            int length = jSONArray2.length();
            int i = 0;
            while (i < length) {
                try {
                    jSONArray.put(i, m41086a(jSONArray2.get(i), list));
                    i++;
                } catch (JSONException e2) {
                    f55284c.log(Level.WARNING, "An error occured while putting packet data to JSONObject", e2);
                    return null;
                }
            }
            return jSONArray;
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = (JSONObject) obj;
            Iterator<String> keys = jSONObject3.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject2.put(next, m41086a(jSONObject3.get(next), list));
                } catch (JSONException e3) {
                    f55284c.log(Level.WARNING, "An error occured while putting data to JSONObject", e3);
                    return null;
                }
            }
            return jSONObject2;
        }
    }

    public static Packet reconstructPacket(Packet packet, byte[][] bArr) {
        packet.data = m41087a((Object) packet.data, bArr);
        packet.attachments = -1;
        return packet;
    }

    /* renamed from: a */
    private static Object m41087a(Object obj, byte[][] bArr) {
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                try {
                    jSONArray.put(i, m41087a(jSONArray.get(i), bArr));
                    i++;
                } catch (JSONException e) {
                    f55284c.log(Level.WARNING, "An error occured while putting packet data to JSONObject", e);
                    return null;
                }
            }
            return jSONArray;
        }
        boolean z = obj instanceof JSONObject;
        JSONObject jSONObject = obj;
        if (z) {
            JSONObject jSONObject2 = (JSONObject) obj;
            if (jSONObject2.optBoolean(f55282a)) {
                int optInt = jSONObject2.optInt(f55283b, -1);
                if (optInt < 0 || optInt >= bArr.length) {
                    return null;
                }
                return bArr[optInt];
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject2.put(next, m41087a(jSONObject2.get(next), bArr));
                } catch (JSONException e2) {
                    f55284c.log(Level.WARNING, "An error occured while putting data to JSONObject", e2);
                    return null;
                }
            }
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }
}
