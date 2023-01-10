package com.iproov.sdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.iproov.sdk.logging.IPLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.osgi.framework.VersionRange;

/* renamed from: com.iproov.sdk.core.native */
/* compiled from: RootedDetector.kt */
public final class C20883native {

    /* renamed from: a */
    private final PackageManager f57169a;

    /* renamed from: b */
    private final List<String> f57170b = CollectionsKt.listOf(C20786catch.m43137ah(), C20786catch.m43138ai(), C20786catch.m43139aj(), C20786catch.m43140ak(), C20786catch.m43141al(), C20786catch.m43142am(), C20786catch.m43143an(), C20786catch.m43144ao(), C20786catch.m43145ap(), C20786catch.m43146aq(), C20786catch.m43147ar(), C20786catch.m43148as(), C20786catch.m43149at(), C20786catch.m43150au());

    /* renamed from: c */
    private final List<Pair<String, String>> f57171c = CollectionsKt.listOf(new Pair(C20786catch.m43108aE(), "1"), new Pair(C20786catch.m43109aF(), "0"));

    /* renamed from: d */
    private final List<String> f57172d = CollectionsKt.listOf(C20786catch.m43248u(), C20786catch.m43249v(), C20786catch.m43250w(), C20786catch.m43251x(), C20786catch.m43252y(), C20786catch.m43253z(), C20786catch.m43076A(), C20786catch.m43077B(), C20786catch.m43078C(), C20786catch.m43079D(), C20786catch.m43080E(), C20786catch.m43081F(), C20786catch.m43082G(), C20786catch.m43083H(), C20786catch.m43084I(), C20786catch.m43085J(), C20786catch.m43086K(), C20786catch.m43087L(), C20786catch.m43088M(), C20786catch.m43089N(), C20786catch.m43090O(), C20786catch.m43091P(), C20786catch.m43092Q(), C20786catch.m43093R(), C20786catch.m43094S(), C20786catch.m43095T(), C20786catch.m43096U(), C20786catch.m43097V(), C20786catch.m43098W(), C20786catch.m43099X(), C20786catch.m43100Y(), C20786catch.m43101Z(), C20786catch.m43130aa(), C20786catch.m43131ab(), C20786catch.m43132ac(), C20786catch.m43133ad(), C20786catch.m43134ae(), C20786catch.m43135af(), C20786catch.m43136ag());

    /* renamed from: e */
    private final List<String> f57173e = CollectionsKt.listOf(C20786catch.m43151av(), C20786catch.m43152aw(), C20786catch.m43153ax(), C20786catch.m43154ay(), C20786catch.m43155az(), C20786catch.m43104aA(), C20786catch.m43105aB());

    /* renamed from: f */
    private final int f57174f;

    /* renamed from: g */
    private final boolean f57175g;

    /* renamed from: h */
    private final int f57176h;

    public C20883native(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f57169a = context.getPackageManager();
        boolean z = false;
        int i = 4;
        int i2 = Build.VERSION.SDK_INT;
        this.f57174f = i2;
        z = i2 < 23 ? true : z;
        this.f57175g = z;
        this.f57176h = !z ? 6 : i;
    }

    /* renamed from: a */
    private final boolean m43419a() {
        List<String> list = this.f57170b;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            Intrinsics.checkNotNullExpressionValue(str, "path");
            String aC = C20786catch.m43106aC();
            Intrinsics.checkNotNullExpressionValue(aC, "getSu()");
            arrayList.add(Boolean.valueOf(C20885public.m43434do(str, aC)));
        }
        return C20885public.m43435do(arrayList);
    }

    /* renamed from: b */
    private final boolean m43422b() {
        List<String> list = this.f57170b;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            Intrinsics.checkNotNullExpressionValue(str, "path");
            String aG = C20786catch.m43110aG();
            Intrinsics.checkNotNullExpressionValue(aG, "getMagisk()");
            arrayList.add(Boolean.valueOf(C20885public.m43434do(str, aG)));
        }
        return C20885public.m43435do(arrayList);
    }

    /* renamed from: c */
    private final boolean m43423c() {
        String aH = C20786catch.m43111aH();
        Intrinsics.checkNotNullExpressionValue(aH, "getWhich()");
        String aC = C20786catch.m43106aC();
        Intrinsics.checkNotNullExpressionValue(aC, "getSu()");
        boolean z = false;
        String[] strArr = C20885public.m43436do(aH, new String[]{aC});
        if (strArr == null) {
            return false;
        }
        if (strArr.length == 0) {
            z = true;
        }
        return !z;
    }

    /* renamed from: d */
    private final boolean m43424d() {
        String str = Build.TAGS;
        if (str == null) {
            return false;
        }
        String aD = C20786catch.m43107aD();
        Intrinsics.checkNotNullExpressionValue(aD, "getTestKeys()");
        return StringsKt.contains$default((CharSequence) str, (CharSequence) aD, false, 2, (Object) null);
    }

    /* renamed from: e */
    private final boolean m43425e() {
        boolean z;
        String aI = C20786catch.m43112aI();
        Intrinsics.checkNotNullExpressionValue(aI, "getGetprop()");
        String[] strArr = C20885public.m43437do(aI, (String[]) null, 1, (Object) null);
        if (strArr == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            i++;
            List<Pair<String, String>> list = this.f57171c;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Pair pair : list) {
                Object first = pair.getFirst();
                Intrinsics.checkNotNullExpressionValue(first, "pair.first");
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) first, false, 2, (Object) null)) {
                    if (StringsKt.contains$default((CharSequence) str, (CharSequence) VersionRange.LEFT_CLOSED + ((String) pair.getSecond()) + VersionRange.RIGHT_CLOSED, false, 2, (Object) null)) {
                        z = true;
                        arrayList2.add(Boolean.valueOf(z));
                    }
                }
                z = false;
                arrayList2.add(Boolean.valueOf(z));
            }
            arrayList.add(Boolean.valueOf(C20885public.m43435do(arrayList2)));
        }
        return C20885public.m43435do(arrayList);
    }

    /* renamed from: f */
    private final boolean m43426f() {
        String aJ = C20786catch.m43113aJ();
        Intrinsics.checkNotNullExpressionValue(aJ, "getMount()");
        String[] strArr = C20885public.m43437do(aJ, (String[]) null, 1, (Object) null);
        if (strArr == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            i++;
            arrayList.add(StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null));
        }
        ArrayList<List> arrayList2 = new ArrayList<>();
        for (Object next : arrayList) {
            if (((List) next).size() >= this.f57176h) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (List list : arrayList2) {
            List<String> list2 = this.f57173e;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (String str2 : list2) {
                Intrinsics.checkNotNullExpressionValue(str2, "path");
                arrayList4.add(Boolean.valueOf(m43421a(str2, list)));
            }
            arrayList3.add(Boolean.valueOf(C20885public.m43435do(arrayList4)));
        }
        return C20885public.m43435do(arrayList3);
    }

    /* renamed from: g */
    private final boolean m43427g() {
        List<String> list = this.f57172d;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            Intrinsics.checkNotNullExpressionValue(str, "it");
            arrayList.add(Boolean.valueOf(m43420a(str)));
        }
        return C20885public.m43435do(arrayList);
    }

    /* renamed from: h */
    private final boolean m43428h() {
        if (!NativeLibraryLoader.f56928a) {
            return true;
        }
        List<String> list = this.f57170b;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String stringPlus : list) {
            arrayList.add(Intrinsics.stringPlus(stringPlus, C20786catch.m43106aC()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            try {
                if (new NativeLibraryLoader().suNativeCheck((String[]) array) > 0) {
                    return true;
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                IPLog.m43494w("NativeLib", "Not loaded");
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    /* renamed from: this  reason: not valid java name */
    public final boolean m48137this() {
        return m43419a() || m43423c() || m43424d() || m43425e() || m43426f() || m43422b() || m43427g() || m43428h();
    }

    /* renamed from: a */
    private final boolean m43421a(String str, List<String> list) {
        List<String> list2 = list;
        String str2 = this.f57175g ? list2.get(1) : list2.get(2);
        String str3 = list2.get(this.f57175g ? 3 : 5);
        if (!StringsKt.equals(str2, str, true)) {
            return false;
        }
        if (!this.f57175g) {
            str3 = StringsKt.replace$default(StringsKt.replace$default(str3, "(", "", false, 4, (Object) null), ")", "", false, 4, (Object) null);
        }
        List<String> split$default = StringsKt.split$default((CharSequence) str3, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String equals : split$default) {
            arrayList.add(Boolean.valueOf(StringsKt.equals(equals, C20786catch.m43114aK(), true)));
        }
        return C20885public.m43435do(arrayList);
    }

    /* renamed from: a */
    private final boolean m43420a(String str) {
        try {
            SystemUtils.getPackageInfo(this.f57169a, str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
