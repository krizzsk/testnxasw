package com.didichuxing.dfbasesdk.touch;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didichuxing.dfbasesdk.touch.TouchData;
import java.util.LinkedList;
import java.util.List;

public class TouchHandler {

    /* renamed from: g */
    private static int[] f49339g = new int[2];

    /* renamed from: h */
    private static int[] f49340h = new int[2];

    /* renamed from: a */
    private Resources f49341a;

    /* renamed from: b */
    private TouchPage f49342b;

    /* renamed from: c */
    private OnTouchDataListener f49343c;

    /* renamed from: d */
    private List<MotionEvent> f49344d = new LinkedList();

    /* renamed from: e */
    private int f49345e = 20;

    /* renamed from: f */
    private View f49346f = null;

    public void onTouchEvent(MotionEvent motionEvent) {
    }

    public TouchHandler(Context context) {
        this.f49341a = context.getResources();
    }

    public void setPage(TouchPage touchPage) {
        this.f49342b = touchPage;
    }

    public void setMotionUpListener(OnTouchDataListener onTouchDataListener) {
        this.f49343c = onTouchDataListener;
    }

    public void setEventLimit(int i) {
        this.f49345e = i;
    }

    /* renamed from: a */
    private boolean m37017a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    /* renamed from: a */
    private TouchData m37016a(MotionEvent motionEvent) {
        TouchPage touchPage;
        TouchData touchData = new TouchData();
        TouchPage touchPage2 = this.f49342b;
        if (touchPage2 != null) {
            touchData.page = touchPage2.getPageName();
        }
        touchData.deviceId = motionEvent.getDeviceId();
        touchData.source = motionEvent.getSource();
        touchData.action = motionEvent.getAction();
        touchData.actionMasked = motionEvent.getActionMasked();
        touchData.actionIndex = motionEvent.getActionIndex();
        touchData.flags = motionEvent.getFlags();
        touchData.downTime = motionEvent.getDownTime();
        touchData.eventTime = motionEvent.getEventTime();
        touchData.metaState = motionEvent.getMetaState();
        touchData.buttonState = motionEvent.getButtonState();
        touchData.xPrecision = motionEvent.getXPrecision();
        touchData.yPrecision = motionEvent.getYPrecision();
        touchData.edgeFlags = motionEvent.getEdgeFlags();
        touchData.pointerCount = motionEvent.getPointerCount();
        if (touchData.pointerCount > 0) {
            touchData.pointers = new TouchData.Pointer[touchData.pointerCount];
            for (int i = 0; i < touchData.pointerCount; i++) {
                TouchData.Pointer[] pointerArr = touchData.pointers;
                TouchData.Pointer pointer = new TouchData.Pointer();
                pointerArr[i] = pointer;
                pointer.pointerId = motionEvent.getPointerId(i);
                pointer.toolType = motionEvent.getToolType(i);
                pointer.f49337x = motionEvent.getX(i);
                pointer.f49338y = motionEvent.getY(i);
                pointer.pressure = motionEvent.getPressure(i);
                pointer.size = motionEvent.getSize(i);
                pointer.touchMajor = motionEvent.getTouchMajor(i);
                pointer.touchMinor = motionEvent.getTouchMinor(i);
                pointer.toolMajor = motionEvent.getToolMajor(i);
                pointer.toolMinor = motionEvent.getToolMinor(i);
                pointer.orientation = motionEvent.getOrientation(i);
                View view = this.f49346f;
                if (view != null) {
                    this.f49346f = m37014a(view, (int) pointer.f49337x, (int) pointer.f49338y);
                }
                if (this.f49346f == null && (touchPage = this.f49342b) != null) {
                    this.f49346f = m37014a(touchPage.getRootView(), (int) pointer.f49337x, (int) pointer.f49338y);
                }
                View view2 = this.f49346f;
                if (view2 != null) {
                    pointer.view = m37015a(view2);
                }
            }
        }
        return touchData;
    }

    /* renamed from: a */
    private TouchData.PView m37015a(View view) {
        CharSequence text;
        TouchData.PView pView = new TouchData.PView();
        pView.f49336id = view.getId() == -1 ? "" : this.f49341a.getResourceEntryName(view.getId());
        pView.type = view.getClass().getSimpleName();
        view.getLocationOnScreen(f49339g);
        pView.locationX = f49339g[0];
        pView.locationY = f49339g[1];
        pView.measuredWidth = view.getMeasuredWidth();
        pView.measuredHeight = view.getMeasuredHeight();
        if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null) {
            pView.content = text.toString();
            if (pView.content.length() > 10) {
                pView.content = pView.content.substring(0, 10);
            }
        }
        return pView;
    }

    /* renamed from: a */
    private View m37014a(View view, int i, int i2) {
        if (!m37018b(view, i, i2)) {
            return null;
        }
        if (!(view instanceof ViewGroup)) {
            return view;
        }
        int i3 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i3 >= viewGroup.getChildCount()) {
                return view;
            }
            View childAt = viewGroup.getChildAt(i3);
            if (m37018b(childAt, i, i2)) {
                return m37014a(childAt, i, i2);
            }
            i3++;
        }
    }

    /* renamed from: b */
    private boolean m37018b(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        view.getLocationOnScreen(f49340h);
        int[] iArr = f49340h;
        int i3 = iArr[0];
        int i4 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        int measuredHeight = view.getMeasuredHeight() + i4;
        if (i < i3 || i > measuredWidth || i2 < i4 || i2 > measuredHeight) {
            return false;
        }
        return true;
    }
}
