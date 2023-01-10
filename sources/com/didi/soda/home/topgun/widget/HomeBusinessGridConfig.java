package com.didi.soda.home.topgun.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\b\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003JG\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018¨\u0006,"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeBusinessGridConfig;", "", "maxRow", "", "divider", "", "itemSpace", "lineSpace", "", "showDividerIndex", "exactlyHeight", "", "(ILjava/lang/String;IFIZ)V", "getDivider", "()Ljava/lang/String;", "setDivider", "(Ljava/lang/String;)V", "getExactlyHeight", "()Z", "setExactlyHeight", "(Z)V", "getItemSpace", "()I", "setItemSpace", "(I)V", "getLineSpace", "()F", "setLineSpace", "(F)V", "getMaxRow", "setMaxRow", "getShowDividerIndex", "setShowDividerIndex", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeBusinessGrid.kt */
public final class HomeBusinessGridConfig {

    /* renamed from: a */
    private int f45593a;

    /* renamed from: b */
    private String f45594b;

    /* renamed from: c */
    private int f45595c;

    /* renamed from: d */
    private float f45596d;

    /* renamed from: e */
    private int f45597e;

    /* renamed from: f */
    private boolean f45598f;

    public HomeBusinessGridConfig() {
        this(0, (String) null, 0, 0.0f, 0, false, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HomeBusinessGridConfig copy$default(HomeBusinessGridConfig homeBusinessGridConfig, int i, String str, int i2, float f, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = homeBusinessGridConfig.f45593a;
        }
        if ((i4 & 2) != 0) {
            str = homeBusinessGridConfig.f45594b;
        }
        String str2 = str;
        if ((i4 & 4) != 0) {
            i2 = homeBusinessGridConfig.f45595c;
        }
        int i5 = i2;
        if ((i4 & 8) != 0) {
            f = homeBusinessGridConfig.f45596d;
        }
        float f2 = f;
        if ((i4 & 16) != 0) {
            i3 = homeBusinessGridConfig.f45597e;
        }
        int i6 = i3;
        if ((i4 & 32) != 0) {
            z = homeBusinessGridConfig.f45598f;
        }
        return homeBusinessGridConfig.copy(i, str2, i5, f2, i6, z);
    }

    public final int component1() {
        return this.f45593a;
    }

    public final String component2() {
        return this.f45594b;
    }

    public final int component3() {
        return this.f45595c;
    }

    public final float component4() {
        return this.f45596d;
    }

    public final int component5() {
        return this.f45597e;
    }

    public final boolean component6() {
        return this.f45598f;
    }

    public final HomeBusinessGridConfig copy(int i, String str, int i2, float f, int i3, boolean z) {
        return new HomeBusinessGridConfig(i, str, i2, f, i3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeBusinessGridConfig)) {
            return false;
        }
        HomeBusinessGridConfig homeBusinessGridConfig = (HomeBusinessGridConfig) obj;
        return this.f45593a == homeBusinessGridConfig.f45593a && Intrinsics.areEqual((Object) this.f45594b, (Object) homeBusinessGridConfig.f45594b) && this.f45595c == homeBusinessGridConfig.f45595c && Intrinsics.areEqual((Object) Float.valueOf(this.f45596d), (Object) Float.valueOf(homeBusinessGridConfig.f45596d)) && this.f45597e == homeBusinessGridConfig.f45597e && this.f45598f == homeBusinessGridConfig.f45598f;
    }

    public int hashCode() {
        int i = this.f45593a * 31;
        String str = this.f45594b;
        int hashCode = (((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.f45595c) * 31) + Float.floatToIntBits(this.f45596d)) * 31) + this.f45597e) * 31;
        boolean z = this.f45598f;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "HomeBusinessGridConfig(maxRow=" + this.f45593a + ", divider=" + this.f45594b + ", itemSpace=" + this.f45595c + ", lineSpace=" + this.f45596d + ", showDividerIndex=" + this.f45597e + ", exactlyHeight=" + this.f45598f + VersionRange.RIGHT_OPEN;
    }

    public HomeBusinessGridConfig(int i, String str, int i2, float f, int i3, boolean z) {
        this.f45593a = i;
        this.f45594b = str;
        this.f45595c = i2;
        this.f45596d = f;
        this.f45597e = i3;
        this.f45598f = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HomeBusinessGridConfig(int r5, java.lang.String r6, int r7, float r8, int r9, boolean r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0005
            r5 = 1
        L_0x0005:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000a
            r6 = 0
        L_0x000a:
            r12 = r6
            r6 = r11 & 4
            r0 = 0
            if (r6 == 0) goto L_0x0012
            r1 = 0
            goto L_0x0013
        L_0x0012:
            r1 = r7
        L_0x0013:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001a
            r8 = 0
            r2 = 0
            goto L_0x001b
        L_0x001a:
            r2 = r8
        L_0x001b:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0022
            r9 = -1
            r3 = -1
            goto L_0x0023
        L_0x0022:
            r3 = r9
        L_0x0023:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r0 = r10
        L_0x0029:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.widget.HomeBusinessGridConfig.<init>(int, java.lang.String, int, float, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getMaxRow() {
        return this.f45593a;
    }

    public final void setMaxRow(int i) {
        this.f45593a = i;
    }

    public final String getDivider() {
        return this.f45594b;
    }

    public final void setDivider(String str) {
        this.f45594b = str;
    }

    public final int getItemSpace() {
        return this.f45595c;
    }

    public final void setItemSpace(int i) {
        this.f45595c = i;
    }

    public final float getLineSpace() {
        return this.f45596d;
    }

    public final void setLineSpace(float f) {
        this.f45596d = f;
    }

    public final int getShowDividerIndex() {
        return this.f45597e;
    }

    public final void setShowDividerIndex(int i) {
        this.f45597e = i;
    }

    public final boolean getExactlyHeight() {
        return this.f45598f;
    }

    public final void setExactlyHeight(boolean z) {
        this.f45598f = z;
    }
}
