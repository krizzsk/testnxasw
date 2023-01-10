package com.threatmetrix.TrustDefender;

import android.location.Location;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

public class qqqqyy extends kkjkjk {
    @Nullable
    private static final Method b00700070pppp = b00730073ss007300730073(Location.class, "isMock", new Class[0]);
    @Nullable
    private static final Method bp0070pppp = b00730073ss007300730073(Location.class, "isFromMockProvider", new Class[0]);
    private static final String bpp0070ppp = yyyyqy.b0074t007400740074t(qqqqyy.class);

    public static boolean b0074ttttt(Location location) {
        if (location == null) {
            yyyyqy.b007400740074tt0074(bpp0070ppp, "Null context");
            return false;
        }
        Boolean bool = (Boolean) bs00730073s007300730073(location, bp0070pppp, new Object[0]);
        Boolean bool2 = (Boolean) bs00730073s007300730073(location, b00700070pppp, new Object[0]);
        return (bool2 != null ? bool2.booleanValue() : false) || (bool != null ? bool.booleanValue() : false);
    }
}
