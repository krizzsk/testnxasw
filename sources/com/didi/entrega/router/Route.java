package com.didi.entrega.router;

import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Route {

    /* renamed from: a */
    private String f22888a;

    /* renamed from: b */
    private String f22889b;

    /* renamed from: c */
    private String[] f22890c;

    /* renamed from: d */
    private String f22891d;

    /* renamed from: e */
    private String f22892e;

    public static Route parse(String str) {
        Route route = new Route();
        route.f22888a = m18833d(str);
        route.f22889b = m18832c(str);
        route.f22890c = m18830b(route, str);
        route.f22891d = m18827a(route, str);
        if (route.m18829a()) {
            route.f22892e = str;
        }
        return route;
    }

    public static Route create(Route route) {
        Route create = create(route.getScheme(), route.getHost(), route.getPath(), route.getParams());
        create.f22892e = route.getAbsolutePath();
        return create;
    }

    public static Route create(String str, String str2, String str3, String str4) {
        Route route = new Route();
        route.setScheme(str);
        route.setHost(str2);
        route.f22890c = m18831b(str3);
        route.f22891d = m18828a(str4);
        return route;
    }

    private Route() {
    }

    public void setScheme(String str) {
        if (C8813c.m18846a(str)) {
            this.f22888a = null;
        } else if (str.contains(HWMapConstant.HTTP.SEPARATOR)) {
            this.f22888a = m18833d(str);
        } else {
            this.f22888a = m18833d(str + HWMapConstant.HTTP.SEPARATOR);
        }
        this.f22892e = null;
    }

    public void setHost(String str) {
        this.f22889b = m18832c(str);
        this.f22892e = null;
    }

    public String getScheme() {
        return this.f22888a;
    }

    public String getHost() {
        return this.f22889b;
    }

    public String[] getPaths() {
        return this.f22890c;
    }

    public String getPath() {
        String[] strArr = this.f22890c;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[strArr.length - 1];
    }

    public String getParams() {
        return this.f22891d;
    }

    public String getAbsolutePath() {
        String str = this.f22892e;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (!C8813c.m18846a(this.f22888a)) {
            sb.append(this.f22888a);
            sb.append(HWMapConstant.HTTP.SEPARATOR);
        }
        if (!C8813c.m18846a(this.f22889b)) {
            sb.append(this.f22889b);
        }
        String[] strArr = this.f22890c;
        if (strArr != null && strArr.length > 0) {
            if (!C8813c.m18846a(this.f22889b)) {
                sb.append("/");
            }
            sb.append(getPath());
        }
        if (!C8813c.m18846a(this.f22891d)) {
            sb.append("?");
            sb.append(this.f22891d);
        }
        String sb2 = sb.toString();
        this.f22892e = sb2;
        return sb2;
    }

    public boolean isChild(Route route) {
        if (!C8813c.m18847a(getScheme(), route.getScheme()) || !C8813c.m18847a(getHost(), route.getHost())) {
            return false;
        }
        int length = route.getPaths() == null ? 0 : route.getPaths().length;
        if ((getPaths() == null ? 0 : getPaths().length) <= length) {
            return false;
        }
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!C8813c.m18847a(route.getPaths()[i], getPaths()[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isDirectChild(Route route) {
        if (!C8813c.m18847a(getScheme(), route.getScheme()) || !C8813c.m18847a(getHost(), route.getHost())) {
            return false;
        }
        int length = route.getPaths() == null ? 0 : route.getPaths().length;
        int length2 = getPaths() == null ? 0 : getPaths().length;
        if (length2 <= length || length2 - length > 1) {
            return false;
        }
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!C8813c.m18847a(route.getPaths()[i], getPaths()[i])) {
                return false;
            }
        }
        return true;
    }

    public Route[] parents() {
        String[] strArr = this.f22890c;
        if (strArr == null || strArr.length == 0) {
            return new Route[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f22890c.length - 1; i++) {
            arrayList.add(create(getScheme(), getHost(), this.f22890c[i], (String) null));
        }
        Route[] routeArr = new Route[arrayList.size()];
        arrayList.toArray(routeArr);
        return routeArr;
    }

    public int hashCode() {
        int i;
        int i2;
        String str = this.f22888a;
        int i3 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int i4 = (i * 17) + 31;
        String str2 = this.f22889b;
        if (str2 == null) {
            i2 = 0;
        } else {
            i2 = str2.hashCode();
        }
        int i5 = i4 + (i2 * 17);
        String[] strArr = this.f22890c;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.f22890c;
                if (i3 >= strArr2.length) {
                    break;
                }
                i5 += (strArr2[i3].hashCode() * 17) + 31;
                i3++;
            }
        }
        return i5;
    }

    public String toString() {
        return "[scheme:" + this.f22888a + ", host:" + this.f22889b + ", paths:" + Arrays.toString(this.f22890c) + ", params:" + this.f22891d + Const.jaRight;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        return C8813c.m18847a(this.f22888a, route.f22888a) && C8813c.m18847a(this.f22889b, route.f22889b) && Arrays.equals(this.f22890c, route.f22890c);
    }

    /* renamed from: a */
    private boolean m18829a() {
        return !C8813c.m18846a(this.f22888a) && !C8813c.m18846a(this.f22889b);
    }

    /* renamed from: a */
    private static String m18827a(Route route, String str) {
        int indexOf;
        if (route == null || C8813c.m18846a(str) || (indexOf = str.indexOf("?")) < 0) {
            return null;
        }
        String substring = str.substring(indexOf + 1);
        if (substring.startsWith(ParamKeys.SIGN_AND)) {
            substring = substring.substring(1);
        }
        if (C8813c.m18846a(substring)) {
            return null;
        }
        return substring;
    }

    /* renamed from: a */
    private static String m18828a(String str) {
        if (C8813c.m18846a(str)) {
            return null;
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            str = str.substring(indexOf + 1);
        }
        if (str.startsWith(ParamKeys.SIGN_AND)) {
            str = str.substring(1);
        }
        if (C8813c.m18846a(str)) {
            return null;
        }
        return str;
    }

    /* renamed from: b */
    private static String[] m18831b(String str) {
        if (str == null || str.isEmpty()) {
            return new String[0];
        }
        int indexOf = str.indexOf("?");
        if (indexOf == -1) {
            indexOf = str.length();
        }
        String substring = str.substring(str.startsWith("/") ? 1 : 0, indexOf);
        if (substring.isEmpty()) {
            return new String[0];
        }
        String[] split = substring.split("/");
        if (split == null || split.length == 0) {
            return new String[0];
        }
        int length = split.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                strArr[i] = split[i];
            } else {
                strArr[i] = strArr[i - 1] + "/" + split[i];
            }
        }
        return strArr;
    }

    /* renamed from: b */
    private static String[] m18830b(Route route, String str) {
        if (route == null || C8813c.m18846a(str)) {
            return new String[0];
        }
        int indexOf = str.indexOf("?");
        if (indexOf == -1) {
            indexOf = str.length();
        }
        String str2 = route.f22888a;
        int length = str2 == null ? 0 : str2.length() + 3;
        String str3 = route.f22889b;
        if (str3 != null) {
            length += str3.length();
        }
        if (length > indexOf) {
            return null;
        }
        String substring = str.substring(length, indexOf);
        if (substring.startsWith("/")) {
            substring = substring.substring(1);
        }
        if (C8813c.m18846a(substring)) {
            return new String[0];
        }
        String[] split = substring.split("/");
        if (split == null || split.length == 0) {
            return new String[0];
        }
        int length2 = split.length;
        String[] strArr = new String[length2];
        for (int i = 0; i < length2; i++) {
            if (i == 0) {
                strArr[i] = split[i];
            } else {
                strArr[i] = strArr[i - 1] + "/" + split[i];
            }
        }
        return strArr;
    }

    /* renamed from: c */
    private static String m18832c(String str) {
        if (C8813c.m18846a(str)) {
            return null;
        }
        int indexOf = str.indexOf(HWMapConstant.HTTP.SEPARATOR);
        if (indexOf >= 0) {
            str = str.substring(indexOf + 3, str.length());
        }
        try {
            Matcher matcher = Pattern.compile("([\\w-]*\\.)?[\\w-]*(\\.[\\w-]*){1,3}(:[0-9]{1,7})?", 2).matcher(str);
            matcher.find();
            return matcher.group();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    private static String m18833d(String str) {
        int indexOf;
        if (!C8813c.m18846a(str) && (indexOf = str.indexOf(HWMapConstant.HTTP.SEPARATOR)) > 0) {
            return str.substring(0, indexOf);
        }
        return null;
    }
}
