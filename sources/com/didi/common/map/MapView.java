package com.didi.common.map;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.common.map.internal.IMapDelegate;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.DLog;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.ArrayList;
import java.util.Iterator;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

public class MapView extends FrameLayout {

    /* renamed from: f */
    private static final String f12527f = "saveMapVendor";

    /* renamed from: a */
    private IMapDelegate f12528a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Map f12529b;

    /* renamed from: c */
    private Context f12530c;

    /* renamed from: d */
    private MapVendor f12531d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MapVendor f12532e;

    /* renamed from: g */
    private TopViewManager f12533g;

    /* renamed from: h */
    private State f12534h;

    /* renamed from: i */
    private TextView f12535i;

    /* renamed from: j */
    private MapOption f12536j;

    /* renamed from: k */
    private ArrayList<TouchEventListener> f12537k;

    public interface InnerMapReadyCallBack {
        void onMapFailed(int i);

        void onMapReady();
    }

    private enum State {
        STATE_IDLE,
        STATE_CREATED,
        STATE_STARTED,
        STATE_RESUMED,
        STATE_PAUSED,
        STATE_STOPPED
    }

    public interface TouchEventListener {
        void onTouchEvent(MotionEvent motionEvent);
    }

    public MapView(Context context) {
        super(context);
        this.f12534h = State.STATE_IDLE;
        this.f12537k = new ArrayList<>();
        this.f12530c = context;
        if (context != null) {
            OmegaSDK.init(context.getApplicationContext());
        }
    }

    public MapView(Context context, MapOption mapOption) {
        this(context);
        this.f12536j = mapOption;
    }

    public MapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12534h = State.STATE_IDLE;
        this.f12537k = new ArrayList<>();
        this.f12530c = context;
        OmegaSDK.init(context.getApplicationContext());
    }

    public void removeErrorHintView() {
        TextView textView = this.f12535i;
        if (textView != null) {
            removeView(textView);
        }
    }

    public void addErrorHintView(String str) {
        IMapDelegate iMapDelegate;
        if (!TextUtils.isEmpty(str) && (iMapDelegate = this.f12528a) != null && iMapDelegate.IsDegrade()) {
            TextView textView = new TextView(getContext());
            this.f12535i = textView;
            textView.setText(str);
            this.f12535i.setGravity(17);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            Padding padding = this.f12529b.getPadding();
            if (padding != null) {
                layoutParams.leftMargin = padding.left;
                layoutParams.rightMargin = padding.right;
                layoutParams.topMargin = padding.top;
                layoutParams.bottomMargin = padding.bottom;
            }
            addView(this.f12535i, layoutParams);
        }
    }

    public void updateErrorHintPosition() {
        if (this.f12535i != null && this.f12529b != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            Padding padding = this.f12529b.getPadding();
            if (padding != null) {
                layoutParams.leftMargin = padding.left;
                layoutParams.rightMargin = padding.right;
                layoutParams.topMargin = padding.top;
                layoutParams.bottomMargin = padding.bottom;
            }
            updateViewLayout(this.f12535i, layoutParams);
        }
    }

    public void init(MapVendor mapVendor) {
        System.currentTimeMillis();
        if (mapVendor != null) {
            this.f12531d = mapVendor;
            MapVendor mapVendor2 = this.f12532e;
            if ((mapVendor2 == null || mapVendor2 != mapVendor) && this.f12529b == null) {
                m10694b();
                return;
            }
            return;
        }
        throw new NullPointerException("param MapVendor is null");
    }

    public Map getMap() {
        return this.f12529b;
    }

    public void getMapAsync(final OnMapReadyCallBack onMapReadyCallBack) {
        Map map;
        IMapDelegate iMapDelegate = this.f12528a;
        if (iMapDelegate != null) {
            iMapDelegate.getMapAsync(new InnerMapReadyCallBack() {
                public void onMapReady() {
                    if (onMapReadyCallBack != null && MapView.this.f12529b != null) {
                        MapView.this.f12529b.setMapStatus(0);
                        onMapReadyCallBack.onMapReady(MapView.this.f12529b);
                    }
                }

                public void onMapFailed(int i) {
                    if (onMapReadyCallBack != null && MapView.this.f12529b != null) {
                        if (MapView.this.f12532e == MapVendor.GOOGLE) {
                            MapView.this.f12529b.setMapStatus(MapAvailability.isAvailable(MapView.this.getContext(), MapView.this.f12532e));
                        } else if (MapView.this.f12532e == MapVendor.Empty) {
                            MapView.this.f12529b.setMapStatus(0);
                        } else {
                            MapView.this.f12529b.setMapStatus(i);
                        }
                        onMapReadyCallBack.onMapReady(MapView.this.f12529b);
                    }
                }
            });
        } else if (onMapReadyCallBack != null && (map = this.f12529b) != null) {
            map.setMapStatus(-1);
            onMapReadyCallBack.onMapReady(this.f12529b);
        }
    }

    public MapVendor getMapVendor() {
        return this.f12532e;
    }

    public MapVendor getTargetMapVendor() {
        return this.f12531d;
    }

    public void onCreate(Bundle bundle) {
        if (this.f12529b != null && this.f12534h == State.STATE_IDLE) {
            this.f12529b.onCreate(bundle);
            this.f12534h = State.STATE_CREATED;
        }
    }

    public void onStart() {
        Map map = this.f12529b;
        if (map != null) {
            map.onStart();
            this.f12534h = State.STATE_STARTED;
        }
    }

    public void onResume() {
        Map map = this.f12529b;
        if (map != null) {
            map.onResume();
            this.f12534h = State.STATE_RESUMED;
        }
    }

    public void onPause() {
        Map map = this.f12529b;
        if (map != null) {
            map.onPause();
            this.f12534h = State.STATE_PAUSED;
        }
    }

    public void onStop() {
        Map map = this.f12529b;
        if (map != null) {
            map.onStop();
            this.f12534h = State.STATE_STOPPED;
        }
    }

    public void onDestroy() {
        Map map = this.f12529b;
        if (map != null) {
            map.onDestroy();
            this.f12529b = null;
            this.f12530c = null;
            this.f12534h = State.STATE_IDLE;
        }
    }

    public void onLowMemory() {
        Map map = this.f12529b;
        if (map != null) {
            map.onLowMemory();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Map map = this.f12529b;
        if (map != null) {
            map.onSaveInstanceState(bundle);
            bundle.putSerializable(f12527f, this.f12532e);
        }
    }

    public void setTopViewToCenter(View view, float f, float f2) {
        if (view != null && this.f12529b != null) {
            if (this.f12533g == null) {
                this.f12533g = new TopViewManager();
            }
            this.f12533g.setTopViewToCenter(view, f, f2);
        }
    }

    public void setTopViewToCenter(View view, float f, float f2, int i) {
        if (view != null && this.f12529b != null) {
            if (this.f12533g == null) {
                this.f12533g = new TopViewManager();
            }
            this.f12533g.setTopViewToCenter(view, f, f2, i);
        }
    }

    public void removeTopView() {
        TopViewManager topViewManager = this.f12533g;
        if (topViewManager != null) {
            topViewManager.removeTopView();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo49653a() {
        mo49654a(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo49654a(boolean z) {
        TopViewManager topViewManager = this.f12533g;
        if (topViewManager != null) {
            topViewManager.updateTopViewPosition(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TopViewManager topViewManager = this.f12533g;
        if (topViewManager != null) {
            topViewManager.checkToUpdateTopViewPosition();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* renamed from: b */
    private void m10694b() {
        if (this.f12529b == null && this.f12530c != null) {
            setClickable(true);
            StringBuilder sb = new StringBuilder();
            sb.append("initMap:");
            MapVendor mapVendor = this.f12531d;
            sb.append(mapVendor == null ? "null" : mapVendor.toString());
            DLog.m10773d("MapView", sb.toString(), new Object[0]);
            MapOption mapOption = this.f12536j;
            if (mapOption != null) {
                this.f12528a = C5006a.m10702a(this.f12531d, this.f12530c, mapOption.isUseTextureMap());
            } else {
                this.f12528a = C5006a.m10701a(this.f12531d, this.f12530c);
            }
            IMapDelegate iMapDelegate = this.f12528a;
            if (iMapDelegate == null) {
                DLog.m10773d("MapView", "map initMap（）  is error, MapDelegate = null, MapVendor = " + this.f12532e, new Object[0]);
                return;
            }
            this.f12529b = new Map(this.f12530c, iMapDelegate, this);
            this.f12532e = this.f12528a.getMapVendor();
            removeTopView();
            removeAllViews();
            View view = this.f12528a.getView();
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(view);
            DLog.m10773d("MapView", "map initMap（）  is ok , MapDelegate = " + this.f12528a + ", MapVendor = " + this.f12532e, new Object[0]);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Iterator<TouchEventListener> it = this.f12537k.iterator();
        while (it.hasNext()) {
            it.next().onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void addTouchEventListener(TouchEventListener touchEventListener) {
        if (!this.f12537k.contains(touchEventListener)) {
            this.f12537k.add(touchEventListener);
        }
    }

    public void removeTouchEventListener(TouchEventListener touchEventListener) {
        this.f12537k.remove(touchEventListener);
    }

    private class TopViewManager {
        private static final int OFFSET_X = 1;
        private static final int OFFSET_Y = 2;
        /* access modifiers changed from: private */
        public View mTopView;
        /* access modifiers changed from: private */
        public float mTopViewAnchorX;
        /* access modifiers changed from: private */
        public float mTopViewAnchorY;
        /* access modifiers changed from: private */
        public boolean mTopViewAnimating;
        private TopViewAnimationManager mTopViewAnimationManager;
        private int mTopViewHeight;
        private int mTopViewTopMargin;
        private int mTopViewWidth;

        private TopViewManager() {
            this.mTopView = null;
            this.mTopViewWidth = 0;
            this.mTopViewHeight = 0;
            this.mTopViewAnchorX = 0.5f;
            this.mTopViewAnchorY = 0.5f;
            this.mTopViewTopMargin = 0;
            this.mTopViewAnimating = false;
        }

        public void setTopViewToCenter(View view, float f, float f2) {
            removeTopView();
            this.mTopView = view;
            this.mTopViewAnchorX = f;
            this.mTopViewAnchorY = f2;
            this.mTopViewTopMargin = 0;
            FrameLayout.LayoutParams calculateLayoutParams = calculateLayoutParams(view, f, f2);
            if (calculateLayoutParams != null) {
                MapView.this.addView(view, calculateLayoutParams);
            }
        }

        public void setTopViewToCenter(View view, float f, float f2, int i) {
            removeTopView();
            this.mTopView = view;
            this.mTopViewAnchorX = f;
            this.mTopViewAnchorY = f2;
            this.mTopViewTopMargin = i;
            FrameLayout.LayoutParams calculateLayoutParams = calculateLayoutParams(view, f, f2);
            if (calculateLayoutParams != null) {
                MapView.this.addView(view, calculateLayoutParams);
            }
        }

        public void removeTopView() {
            if (this.mTopView != null) {
                TopViewAnimationManager topViewAnimationManager = this.mTopViewAnimationManager;
                if (topViewAnimationManager != null) {
                    topViewAnimationManager.cancel();
                }
                MapView.this.removeView(this.mTopView);
                this.mTopView = null;
                this.mTopViewWidth = 0;
                this.mTopViewHeight = 0;
                this.mTopViewAnchorX = 0.5f;
                this.mTopViewAnchorY = 0.5f;
            }
        }

        public void checkToUpdateTopViewPosition() {
            if (isTopViewSizeChanged()) {
                updateTopViewPosition(false);
            }
        }

        public void updateTopViewPosition(boolean z) {
            if (isTopViewVisible()) {
                if (this.mTopViewAnimating) {
                    if (z) {
                        updateTopViewPositionWithAnim();
                        return;
                    }
                    TopViewAnimationManager topViewAnimationManager = this.mTopViewAnimationManager;
                    if (topViewAnimationManager != null) {
                        topViewAnimationManager.pause();
                    }
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mTopView.getLayoutParams();
                    int i = layoutParams.leftMargin;
                    measureView(this.mTopView);
                    this.mTopView.getMeasuredWidth();
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.topMargin = ((int) (((float) ((int) (((float) (layoutParams.topMargin - 2)) + (((float) this.mTopViewHeight) * this.mTopViewAnchorY)))) - (((float) this.mTopView.getMeasuredHeight()) * this.mTopViewAnchorY))) + 2 + this.mTopViewTopMargin;
                    layoutParams2.gravity = 1;
                    MapView.this.updateViewLayout(this.mTopView, layoutParams2);
                    TopViewAnimationManager topViewAnimationManager2 = this.mTopViewAnimationManager;
                    if (topViewAnimationManager2 != null) {
                        topViewAnimationManager2.resume();
                    }
                } else if (z) {
                    updateTopViewPositionWithAnim();
                } else {
                    updateTopViewPositionDirectly();
                }
            }
        }

        /* access modifiers changed from: private */
        public boolean isTopViewVisible() {
            View view = this.mTopView;
            return view != null && view.getVisibility() == 0;
        }

        private boolean isTopViewSizeChanged() {
            if (!isTopViewVisible()) {
                return false;
            }
            measureView(this.mTopView);
            int measuredWidth = this.mTopView.getMeasuredWidth();
            int measuredHeight = this.mTopView.getMeasuredHeight();
            if (this.mTopViewWidth == measuredWidth && this.mTopViewHeight == measuredHeight) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public FrameLayout.LayoutParams calculateLayoutParams(View view, float f, float f2) {
            if (view == null || MapView.this.f12529b == null) {
                return null;
            }
            measureView(this.mTopView);
            int measuredWidth = this.mTopView.getMeasuredWidth();
            int measuredHeight = this.mTopView.getMeasuredHeight();
            this.mTopViewWidth = measuredWidth;
            this.mTopViewHeight = measuredHeight;
            PointF visibleRegionCenterInScreen = MapView.this.f12529b.getVisibleRegionCenterInScreen();
            if (visibleRegionCenterInScreen == null) {
                return null;
            }
            float f3 = visibleRegionCenterInScreen.x;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = ((int) (visibleRegionCenterInScreen.y - (((float) measuredHeight) * f2))) + 2 + this.mTopViewTopMargin;
            layoutParams.gravity = 1;
            return layoutParams;
        }

        private void updateTopViewPositionDirectly() {
            FrameLayout.LayoutParams calculateLayoutParams = calculateLayoutParams(this.mTopView, this.mTopViewAnchorX, this.mTopViewAnchorY);
            if (calculateLayoutParams != null) {
                MapView.this.updateViewLayout(this.mTopView, calculateLayoutParams);
            }
        }

        private void updateTopViewPositionWithAnim() {
            if (this.mTopViewAnimationManager == null) {
                this.mTopViewAnimationManager = new TopViewAnimationManager();
            }
            this.mTopViewAnimationManager.execute();
        }

        private void measureView(View view) {
            view.measure(View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, Integer.MIN_VALUE));
        }

        private class TopViewAnimationManager {
            private static final long ANIM_DURATION = 250;
            private static final int ANIM_FRAME_COUNT = 20;
            private static final int MSG_UPDATE = 0;
            private int mExecutedFrameCount;
            private Handler mHandler;

            private TopViewAnimationManager() {
                this.mExecutedFrameCount = 0;
                this.mHandler = new Handler() {
                    public void handleMessage(Message message) {
                        if (message.what == 0) {
                            TopViewAnimationManager.this.innerExecute();
                        }
                    }
                };
            }

            public void execute() {
                this.mExecutedFrameCount = 0;
                innerCancel();
                onAnimationStart();
                innerExecute();
            }

            public void cancel() {
                innerCancel();
                onAnimationCanceled();
            }

            public void resume() {
                innerExecute();
            }

            public void pause() {
                innerCancel();
            }

            /* access modifiers changed from: private */
            public void innerExecute() {
                if (TopViewManager.this.isTopViewVisible()) {
                    TopViewManager topViewManager = TopViewManager.this;
                    translate((FrameLayout.LayoutParams) TopViewManager.this.mTopView.getLayoutParams(), topViewManager.calculateLayoutParams(topViewManager.mTopView, TopViewManager.this.mTopViewAnchorX, TopViewManager.this.mTopViewAnchorY));
                }
            }

            private void innerCancel() {
                if (this.mHandler.hasMessages(0)) {
                    this.mHandler.removeMessages(0);
                }
            }

            private void translate(FrameLayout.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2) {
                if (layoutParams != null && layoutParams2 != null) {
                    int i = layoutParams2.leftMargin - layoutParams.leftMargin;
                    int i2 = layoutParams2.topMargin - layoutParams.topMargin;
                    int i3 = 20 - this.mExecutedFrameCount;
                    if (i3 <= 0) {
                        i3 = 1;
                    }
                    int i4 = i / i3;
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.topMargin = layoutParams.topMargin + (i2 / i3);
                    layoutParams3.gravity = 1;
                    MapView.this.updateViewLayout(TopViewManager.this.mTopView, layoutParams3);
                    int i5 = this.mExecutedFrameCount + 1;
                    this.mExecutedFrameCount = i5;
                    if (i5 >= 20) {
                        MapView.this.updateViewLayout(TopViewManager.this.mTopView, layoutParams2);
                        onAnimationEnd();
                        return;
                    }
                    this.mHandler.sendEmptyMessageDelayed(0, 12);
                }
            }

            private void onAnimationStart() {
                boolean unused = TopViewManager.this.mTopViewAnimating = true;
            }

            private void onAnimationEnd() {
                boolean unused = TopViewManager.this.mTopViewAnimating = false;
            }

            private void onAnimationCanceled() {
                boolean unused = TopViewManager.this.mTopViewAnimating = false;
            }
        }
    }
}
