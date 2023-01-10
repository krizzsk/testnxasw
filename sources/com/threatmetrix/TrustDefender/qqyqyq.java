package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.TMXProfilingModule.BuildConfig;
import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;
import javax.annotation.Nonnull;

public class qqyqyq extends tqqqqt {
    private String b006100610061a00610061;
    private String b0061aa006100610061;
    private String ba00610061a00610061;
    private String ba0061a006100610061;
    private String baaa006100610061;

    public qqyqyq(long j) {
        super(j);
    }

    private String b0069i0069iii(@Nonnull yyqyqy yyqyqy, String str, tqtqqt tqtqqt) {
        String str2 = tqtqqt.bll006C006C006C006C.getApplicationInfo().nativeLibraryDir;
        String bgg0067ggg = yyqyqy.bgg0067ggg(str);
        return (!yqqyqq.b0069ii0069i0069(str2) || !yqqyqq.b0069ii0069i0069(bgg0067ggg)) ? "" : str2.concat("/lib".concat(bgg0067ggg).concat(".so"));
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.APP_SELF_HASH_MD5.b00780078x00780078x(), this.ba00610061a00610061);
            map.put(yyyyyq.APP_SELF_HASH_SHA256.b00780078x00780078x(), this.b006100610061a00610061);
            map.put(yyyyyq.SELF_HASH_BASE_MODULE.b00780078x00780078x(), this.baaa006100610061);
            map.put(yyyyyq.SELF_HASH_AUTH_MODULE.b00780078x00780078x(), this.ba0061a006100610061);
            map.put(yyyyyq.SELF_HASH_DSH_MODULE.b00780078x00780078x(), this.b0061aa006100610061);
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null && ttqqqt.byyy0079yy() != null) {
            if (this.ba00610061a00610061 == null) {
                this.ba00610061a00610061 = qttqqq.b0075uu00750075u(ttqqqt.byy0079yyy(), tqtttt.MD5);
                this.b006100610061a00610061 = qttqqq.b0075uu00750075u(ttqqqt.byy0079yyy(), tqtttt.SHA256);
            }
            String concat = ttqqqt.byy0079yyy().bll006C006C006C006C.getApplicationInfo().nativeLibraryDir.concat("/lib".concat(BuildConfig.JNI_FILENAME).concat(".so"));
            String b0069i0069iii = b0069i0069iii(ttqqqt.byyy0079yy(), qqyyqy.b007000700070p0070p, ttqqqt.byy0079yyy());
            String b0069i0069iii2 = b0069i0069iii(ttqqqt.byyy0079yy(), qqyyqy.bp00700070p0070p, ttqqqt.byy0079yyy());
            this.baaa006100610061 = qqqyqy.bg00670067g0067g().b00670067006700670067g(concat);
            this.ba0061a006100610061 = qqqyqy.bg00670067g0067g().b00670067006700670067g(b0069i0069iii2);
            this.b0061aa006100610061 = qqqyqy.bg00670067g0067g().b00670067006700670067g(b0069i0069iii);
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_SELF_HASH;
    }
}
