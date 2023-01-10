package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.bg */
final class C19922bg extends AssetPackLocation {

    /* renamed from: a */
    private final int f55743a;

    /* renamed from: b */
    private final String f55744b;

    /* renamed from: c */
    private final String f55745c;

    C19922bg(int i, String str, String str2) {
        this.f55743a = i;
        this.f55744b = str;
        this.f55745c = str2;
    }

    public final String assetsPath() {
        return this.f55745c;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackLocation) {
            AssetPackLocation assetPackLocation = (AssetPackLocation) obj;
            if (this.f55743a == assetPackLocation.packStorageMethod() && ((str = this.f55744b) != null ? str.equals(assetPackLocation.path()) : assetPackLocation.path() == null)) {
                String str2 = this.f55745c;
                String assetsPath = assetPackLocation.assetsPath();
                if (str2 != null ? str2.equals(assetsPath) : assetsPath == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.f55743a ^ 1000003) * 1000003;
        String str = this.f55744b;
        int i2 = 0;
        int hashCode = (i ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f55745c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode ^ i2;
    }

    public final int packStorageMethod() {
        return this.f55743a;
    }

    public final String path() {
        return this.f55744b;
    }

    public final String toString() {
        int i = this.f55743a;
        String str = this.f55744b;
        String str2 = this.f55745c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(i);
        sb.append(", path=");
        sb.append(str);
        sb.append(", assetsPath=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
