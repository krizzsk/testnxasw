package com.didi.sdk.fastframe.view.systembar;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BuildProperties {

    /* renamed from: a */
    private final Properties f38697a;

    private BuildProperties() throws IOException {
        Properties properties = new Properties();
        this.f38697a = properties;
        properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
    }

    public boolean containsKey(Object obj) {
        return this.f38697a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f38697a.containsValue(obj);
    }

    public Set<Map.Entry<Object, Object>> entrySet() {
        return this.f38697a.entrySet();
    }

    public String getProperty(String str) {
        return this.f38697a.getProperty(str);
    }

    public String getProperty(String str, String str2) {
        return this.f38697a.getProperty(str, str2);
    }

    public boolean isEmpty() {
        return this.f38697a.isEmpty();
    }

    public Enumeration<Object> keys() {
        return this.f38697a.keys();
    }

    public Set<Object> keySet() {
        return this.f38697a.keySet();
    }

    public int size() {
        return this.f38697a.size();
    }

    public Collection<Object> values() {
        return this.f38697a.values();
    }

    public static BuildProperties newInstance() throws IOException {
        return new BuildProperties();
    }
}
