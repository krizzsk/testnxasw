package com.koushikdutta.async.http;

import android.text.TextUtils;
import com.koushikdutta.async.util.TaggedList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class Headers {

    /* renamed from: a */
    final Multimap f58138a = new Multimap() {
        /* access modifiers changed from: protected */
        public List<String> newList() {
            return new TaggedList();
        }
    };

    public Headers() {
    }

    public Headers(Map<String, List<String>> map) {
        for (String next : map.keySet()) {
            addAll(next, map.get(next));
        }
    }

    public Multimap getMultiMap() {
        return this.f58138a;
    }

    public List<String> getAll(String str) {
        return (List) this.f58138a.get(str.toLowerCase(Locale.US));
    }

    public String get(String str) {
        return this.f58138a.getString(str.toLowerCase(Locale.US));
    }

    public Headers set(String str, String str2) {
        if (str2 == null || (!str2.contains("\n") && !str2.contains(StringUtils.f7475CR))) {
            String lowerCase = str.toLowerCase(Locale.US);
            this.f58138a.put(lowerCase, str2);
            ((TaggedList) this.f58138a.get(lowerCase)).tagNull(str);
            return this;
        }
        throw new IllegalArgumentException("value must not contain a new line or line feed");
    }

    public Headers add(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.US);
        this.f58138a.add(lowerCase, str2);
        ((TaggedList) this.f58138a.get(lowerCase)).tagNull(str);
        return this;
    }

    public Headers addLine(String str) {
        if (str != null) {
            String[] split = str.trim().split(":", 2);
            if (split.length == 2) {
                add(split[0].trim(), split[1].trim());
            } else {
                add(split[0].trim(), "");
            }
        }
        return this;
    }

    public Headers addAll(String str, List<String> list) {
        for (String add : list) {
            add(str, add);
        }
        return this;
    }

    public Headers addAll(Map<String, List<String>> map) {
        for (String next : map.keySet()) {
            for (String add : map.get(next)) {
                add(next, add);
            }
        }
        return this;
    }

    public Headers addAllMap(Map<String, String> map) {
        for (String next : map.keySet()) {
            add(next, map.get(next));
        }
        return this;
    }

    public Headers addAll(Headers headers) {
        this.f58138a.putAll(headers.f58138a);
        return this;
    }

    public List<String> removeAll(String str) {
        return (List) this.f58138a.remove(str.toLowerCase(Locale.US));
    }

    public String remove(String str) {
        List<String> removeAll = removeAll(str.toLowerCase(Locale.US));
        if (removeAll == null || removeAll.size() == 0) {
            return null;
        }
        return removeAll.get(0);
    }

    public Headers removeAll(Collection<String> collection) {
        for (String remove : collection) {
            remove(remove);
        }
        return this;
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(256);
        for (String str : this.f58138a.keySet()) {
            TaggedList taggedList = (TaggedList) this.f58138a.get(str);
            Iterator it = taggedList.iterator();
            while (it.hasNext()) {
                sb.append((String) taggedList.tag());
                sb.append(": ");
                sb.append((String) it.next());
                sb.append("\r\n");
            }
        }
        sb.append("\r\n");
        return sb;
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    public String toPrefixString(String str) {
        StringBuilder stringBuilder = toStringBuilder();
        return stringBuilder.insert(0, str + "\r\n").toString();
    }

    public static Headers parse(String str) {
        String[] split = str.split("\n");
        Headers headers = new Headers();
        for (String trim : split) {
            String trim2 = trim.trim();
            if (!TextUtils.isEmpty(trim2)) {
                headers.addLine(trim2);
            }
        }
        return headers;
    }
}
