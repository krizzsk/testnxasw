package com.didi.global.fintech.cashier.p118ui.viewholder;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingItem;", "", "type", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingItem$Type;", "title", "", "subtitle", "clickEvent", "Lkotlin/Function0;", "", "(Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingItem$Type;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getClickEvent", "()Lkotlin/jvm/functions/Function0;", "getSubtitle", "()Ljava/lang/String;", "getTitle", "getType", "()Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingItem$Type;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "Type", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FastPaySettingItem */
/* compiled from: FastPaySettingContentViewHolder.kt */
public final class FastPaySettingItem {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Type f23687a;

    /* renamed from: b */
    private final String f23688b;

    /* renamed from: c */
    private final String f23689c;

    /* renamed from: d */
    private final Function0<Unit> f23690d;

    @Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingItem$Type;", "", "(Ljava/lang/String;I)V", "Limit", "Order", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FastPaySettingItem$Type */
    /* compiled from: FastPaySettingContentViewHolder.kt */
    public enum Type {
        Limit,
        Order
    }

    public static /* synthetic */ FastPaySettingItem copy$default(FastPaySettingItem fastPaySettingItem, Type type, String str, String str2, Function0<Unit> function0, int i, Object obj) {
        if ((i & 1) != 0) {
            type = fastPaySettingItem.f23687a;
        }
        if ((i & 2) != 0) {
            str = fastPaySettingItem.f23688b;
        }
        if ((i & 4) != 0) {
            str2 = fastPaySettingItem.f23689c;
        }
        if ((i & 8) != 0) {
            function0 = fastPaySettingItem.f23690d;
        }
        return fastPaySettingItem.copy(type, str, str2, function0);
    }

    public final Type component1() {
        return this.f23687a;
    }

    public final String component2() {
        return this.f23688b;
    }

    public final String component3() {
        return this.f23689c;
    }

    public final Function0<Unit> component4() {
        return this.f23690d;
    }

    public final FastPaySettingItem copy(Type type, String str, String str2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(str, "title");
        return new FastPaySettingItem(type, str, str2, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastPaySettingItem)) {
            return false;
        }
        FastPaySettingItem fastPaySettingItem = (FastPaySettingItem) obj;
        return this.f23687a == fastPaySettingItem.f23687a && Intrinsics.areEqual((Object) this.f23688b, (Object) fastPaySettingItem.f23688b) && Intrinsics.areEqual((Object) this.f23689c, (Object) fastPaySettingItem.f23689c) && Intrinsics.areEqual((Object) this.f23690d, (Object) fastPaySettingItem.f23690d);
    }

    public int hashCode() {
        int hashCode = ((this.f23687a.hashCode() * 31) + this.f23688b.hashCode()) * 31;
        String str = this.f23689c;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Function0<Unit> function0 = this.f23690d;
        if (function0 != null) {
            i = function0.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "FastPaySettingItem(type=" + this.f23687a + ", title=" + this.f23688b + ", subtitle=" + this.f23689c + ", clickEvent=" + this.f23690d + VersionRange.RIGHT_OPEN;
    }

    public FastPaySettingItem(Type type, String str, String str2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(str, "title");
        this.f23687a = type;
        this.f23688b = str;
        this.f23689c = str2;
        this.f23690d = function0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FastPaySettingItem(Type type, String str, String str2, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : function0);
    }

    public final Type getType() {
        return this.f23687a;
    }

    public final String getTitle() {
        return this.f23688b;
    }

    public final String getSubtitle() {
        return this.f23689c;
    }

    public final Function0<Unit> getClickEvent() {
        return this.f23690d;
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ,\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¨\u0006\f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingItem$Companion;", "", "()V", "insByLimit", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingItem;", "title", "", "subtitle", "clickEvent", "Lkotlin/Function0;", "", "insByOrder", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FastPaySettingItem$Companion */
    /* compiled from: FastPaySettingContentViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ FastPaySettingItem insByLimit$default(Companion companion, String str, String str2, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                function0 = null;
            }
            return companion.insByLimit(str, str2, function0);
        }

        public final FastPaySettingItem insByLimit(String str, String str2, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new FastPaySettingItem(Type.Limit, str, str2, function0);
        }

        public static /* synthetic */ FastPaySettingItem insByOrder$default(Companion companion, String str, String str2, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                function0 = null;
            }
            return companion.insByOrder(str, str2, function0);
        }

        public final FastPaySettingItem insByOrder(String str, String str2, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new FastPaySettingItem(Type.Order, str, str2, function0);
        }
    }
}
