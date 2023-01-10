package org.osgi.framework.dto;

import java.util.Map;
import org.osgi.dto.DTO;

public class ServiceReferenceDTO extends DTO {
    public long bundle;

    /* renamed from: id */
    public long f8535id;
    public Map<String, Object> properties;
    public long[] usingBundles;
}
