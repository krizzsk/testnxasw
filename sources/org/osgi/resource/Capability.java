package org.osgi.resource;

import java.util.Map;

public interface Capability {
    boolean equals(Object obj);

    Map<String, Object> getAttributes();

    Map<String, String> getDirectives();

    String getNamespace();

    Resource getResource();

    int hashCode();
}
