package com.threatmetrix.TrustDefender;

import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.threatmetrix.TrustDefender.kkjkjk;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.lang.reflect.Method;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ttttqt extends kkjkjk {
    @Nullable
    private static final Class<?> b0072r0072r0072r;
    @Nullable
    private static final Method br00720072r0072r;
    private static final String brr0072r0072r = yyyyqy.b0074t007400740074t(ttttqt.class);
    private Display b007200720072r0072r;
    @Nullable
    private Point brrr00720072r;

    static {
        Class<?> b00730073s0073s00730073 = b00730073s0073s00730073(kkjkjk.jjkkjk.WINDOW_MANAGER);
        b0072r0072r0072r = b00730073s0073s00730073;
        br00720072r0072r = b00730073ss007300730073(b00730073s0073s00730073, "getDefaultDisplay", new Class[0]);
    }

    public ttttqt(@Nonnull tqtqqt tqtqqt) {
        if (br00720072r0072r != null) {
            try {
                Object systemService = tqtqqt.bll006C006C006C006C.getSystemService("window");
                if (systemService instanceof WindowManager) {
                    this.b007200720072r0072r = ((WindowManager) systemService).getDefaultDisplay();
                    this.brrr00720072r = byyy00790079y();
                }
            } catch (SecurityException e) {
                yyyyqy.qyyyqy.b00740074tttt(brr0072r0072r, "User refuse granting permission {}", e.toString());
                qqqtqt.byyyy0079y(e);
            } catch (Exception e2) {
                yyyyqy.bt0074007400740074t(brr0072r0072r, e2.toString());
            }
        }
    }

    private Point byyy00790079y() {
        Point point = new Point();
        this.b007200720072r0072r.getRealSize(point);
        if (point.x == 0 || point.y == 0) {
            return null;
        }
        return point;
    }

    public int b007900790079y0079y() {
        if (this.b007200720072r0072r == null) {
            return 0;
        }
        Point point = this.brrr00720072r;
        if (point != null) {
            return point.y;
        }
        Point point2 = new Point();
        this.b007200720072r0072r.getSize(point2);
        return point2.y;
    }

    public int b0079yy00790079y() {
        if (this.b007200720072r0072r == null) {
            return 0;
        }
        Point point = this.brrr00720072r;
        if (point != null) {
            return point.x;
        }
        Point point2 = new Point();
        this.b007200720072r0072r.getSize(point2);
        return point2.x;
    }
}
