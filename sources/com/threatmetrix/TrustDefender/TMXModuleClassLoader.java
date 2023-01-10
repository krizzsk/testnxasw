package com.threatmetrix.TrustDefender;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class TMXModuleClassLoader extends ClassLoader {
    private final ClassLoader bd0064d0064dd;

    public TMXModuleClassLoader(ClassLoader classLoader) {
        this.bd0064d0064dd = classLoader;
    }

    public Enumeration<URL> getResources(String str) throws IOException {
        return this.bd0064d0064dd.getResources(str.replace("META-INF/services", "assets/services"));
    }

    public Class<?> loadClass(String str) throws ClassNotFoundException {
        return this.bd0064d0064dd.loadClass(str);
    }
}
