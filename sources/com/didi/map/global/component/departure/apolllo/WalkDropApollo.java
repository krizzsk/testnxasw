package com.didi.map.global.component.departure.apolllo;

import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/map/global/component/departure/apolllo/WalkDropApollo;", "", "()V", "Companion", "compDeparture_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalkDropApollo.kt */
public final class WalkDropApollo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f27139a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f27140b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static boolean f27141c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static boolean f27142d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static boolean f27143e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static boolean f27144f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static boolean f27145g;

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, mo148868d2 = {"Lcom/didi/map/global/component/departure/apolllo/WalkDropApollo$Companion;", "", "()V", "dropline_enable", "", "getDropline_enable", "()Z", "setDropline_enable", "(Z)V", "enable", "getEnable", "setEnable", "hms_enable", "getHms_enable", "setHms_enable", "recpoint_enable", "getRecpoint_enable", "setRecpoint_enable", "subtitle_adsorbed", "getSubtitle_adsorbed", "setSubtitle_adsorbed", "subtitle_not_adsorbed", "getSubtitle_not_adsorbed", "setSubtitle_not_adsorbed", "walkline_enable", "getWalkline_enable", "setWalkline_enable", "compDeparture_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalkDropApollo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getHms_enable() {
            return WalkDropApollo.f27139a;
        }

        public final void setHms_enable(boolean z) {
            WalkDropApollo.f27139a = z;
        }

        public final boolean getRecpoint_enable() {
            return WalkDropApollo.f27140b;
        }

        public final void setRecpoint_enable(boolean z) {
            WalkDropApollo.f27140b = z;
        }

        public final boolean getEnable() {
            return WalkDropApollo.f27141c;
        }

        public final void setEnable(boolean z) {
            WalkDropApollo.f27141c = z;
        }

        public final boolean getDropline_enable() {
            return WalkDropApollo.f27142d;
        }

        public final void setDropline_enable(boolean z) {
            WalkDropApollo.f27142d = z;
        }

        public final boolean getSubtitle_adsorbed() {
            return WalkDropApollo.f27143e;
        }

        public final void setSubtitle_adsorbed(boolean z) {
            WalkDropApollo.f27143e = z;
        }

        public final boolean getSubtitle_not_adsorbed() {
            return WalkDropApollo.f27144f;
        }

        public final void setSubtitle_not_adsorbed(boolean z) {
            WalkDropApollo.f27144f = z;
        }

        public final boolean getWalkline_enable() {
            return WalkDropApollo.f27145g;
        }

        public final void setWalkline_enable(boolean z) {
            WalkDropApollo.f27145g = z;
        }
    }

    static {
        IToggle toggle = Apollo.getToggle("global_map_pickup_page_walk_line_toggle");
        boolean z = true;
        if (toggle.allow()) {
            IExperiment experiment = toggle.getExperiment();
            Integer num = (Integer) experiment.getParam("hms_enable", 0);
            f27139a = num != null && num.intValue() == 1;
            Integer num2 = (Integer) experiment.getParam("recpoint_enable", 0);
            f27140b = num2 != null && num2.intValue() == 1;
            Integer num3 = (Integer) experiment.getParam("dropline_enable", 0);
            f27142d = num3 != null && num3.intValue() == 1;
            Integer num4 = (Integer) experiment.getParam("subtitle_adsorbed", 0);
            f27143e = num4 != null && num4.intValue() == 1;
            Integer num5 = (Integer) experiment.getParam("subtitle_not_adsorbed", 0);
            f27144f = num5 != null && num5.intValue() == 1;
            Integer num6 = (Integer) experiment.getParam("enable", 0);
            f27141c = num6 != null && num6.intValue() == 1;
        }
        IToggle toggle2 = Apollo.getToggle("global_map_waiting_for_driving_page_walk_line_toggle");
        if (toggle2.allow()) {
            Integer num7 = (Integer) toggle2.getExperiment().getParam("walkline_enable", 0);
            if (num7 == null || num7.intValue() != 1) {
                z = false;
            }
            f27145g = z;
        }
        DLog.m10773d("WalkDropApollo", "enable = " + f27141c + ", hms_enable =" + f27139a + ", recpoint_enable =" + f27140b + ", dropline_enable =" + f27142d + " , subtitle_adsorbed =" + f27143e + " ,subtitle_not_adsorbed =" + f27144f + " , walkline_enable = " + f27145g, new Object[0]);
    }
}
