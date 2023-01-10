package rui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.taxis99.R;
import java.lang.reflect.Field;
import rui.util.ViewUtils;

public class Switch extends android.widget.Switch {

    /* renamed from: a */
    private int f8662a;

    public Switch(Context context) {
        super(context);
        m7250a(context);
    }

    public Switch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7250a(context);
    }

    public Switch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7250a(context);
    }

    /* renamed from: a */
    private void m7250a(Context context) {
        this.f8662a = (int) ViewUtils.m7249dp(context, 54.0f);
        setThumbResource(R.drawable.rui_switch_thumb_selector);
        setTrackResource(R.drawable.rui_switch_track_selector);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        try {
            Field declaredField = android.widget.Switch.class.getDeclaredField("mSwitchWidth");
            declaredField.setAccessible(true);
            declaredField.setInt(this, this.f8662a);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }
}
