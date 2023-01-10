package p237final;

import android.os.Build;
import com.iproov.sdk.cameray.C20752break;
import com.iproov.sdk.cameray.C20759const;
import java.util.ArrayList;
import java.util.List;
import p055case.C1272else;
import p237final.C21836if;

/* renamed from: final.do */
/* compiled from: DeviceManager */
public class C21833do {

    /* renamed from: a */
    private static C21833do f59997a;

    /* renamed from: b */
    private final List<C21836if> f59998b;

    private C21833do() {
        ArrayList arrayList = new ArrayList();
        this.f59998b = arrayList;
        C21836if.C21837do doVar = new C21836if.C21837do("asus", "Nexus 7", "grouper");
        C20752break breakR = C20752break.f56850if;
        arrayList.add(doVar.mo180478do(breakR).mo180480do());
        arrayList.add(new C21836if.C21837do("android", "Amazon Tate", "bowser").mo180478do(breakR).mo180480do());
        arrayList.add(new C21836if.C21837do("Xiaomi", "Mi MIX 2", "qcom").mo180479do(C20759const.CAMERA2).mo180480do());
        arrayList.add(new C21836if.C21837do("LGE", "LG-M700", "mh").mo180479do(C20759const.CAMERA1).mo180480do());
        arrayList.add(new C21836if.C21837do("Huawei", "EML-L09", "kirin970").mo180477do(C1272else.AVC).mo180480do());
    }

    /* renamed from: do */
    public static C21833do m45150do() {
        if (f59997a == null) {
            f59997a = new C21833do();
        }
        return f59997a;
    }

    /* renamed from: if */
    public C21836if mo180466if() {
        return m45149a(Build.MANUFACTURER, Build.MODEL, Build.HARDWARE);
    }

    /* renamed from: a */
    private C21836if m45149a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("Looking for device profile for: ");
        sb.append(Build.MANUFACTURER);
        sb.append(" | ");
        sb.append(Build.MODEL);
        sb.append(" | ");
        sb.append(Build.HARDWARE);
        for (C21836if next : this.f59998b) {
            if ((next.m48240case() == null || next.m48240case().equalsIgnoreCase(str)) && ((next.m48241else() == null || next.m48241else().equalsIgnoreCase(str2)) && (next.m48245try() == null || next.m48245try().equalsIgnoreCase(str3)))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Device profile found: ");
                sb2.append(next.m48240case());
                sb2.append(" | ");
                sb2.append(next.m48241else());
                sb2.append(" | ");
                sb2.append(next.m48245try());
                return next;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("No device-specific profile found. Returning default device profile. ");
        sb3.append(str);
        sb3.append(" | ");
        sb3.append(str2);
        sb3.append(" | ");
        sb3.append(str3);
        return new C21836if(str, str2, str3, (C20752break) null, (C20759const) null, (Double) null, (C1272else) null);
    }
}
