package kotlin.reflect.jvm.internal.impl.platform;

import org.osgi.framework.VersionRange;

/* compiled from: TargetPlatform.kt */
public abstract class SimplePlatform {

    /* renamed from: a */
    private final String f5451a;

    /* renamed from: b */
    private final TargetPlatformVersion f5452b;

    public String toString() {
        String targetName = getTargetName();
        if (!(targetName.length() > 0)) {
            return this.f5451a;
        }
        return this.f5451a + " (" + targetName + VersionRange.RIGHT_OPEN;
    }

    public String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    public TargetPlatformVersion getTargetPlatformVersion() {
        return this.f5452b;
    }
}
