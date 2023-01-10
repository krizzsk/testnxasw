package com.didi.map.global.component.departure.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.collide.CollideStrategyFactory;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.strategy3.IDMarkerContractV3;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.OnMarkerCompClickListener;
import com.didi.map.global.component.markers.view.ILabelView;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;
import java.util.List;

public class LoadingInfoWindow {

    /* renamed from: a */
    ICollideStrategy f27605a = CollideStrategyFactory.getCollideStrategyV3(new IDMarkerContractV3() {
        public /* synthetic */ int getDefaultLabelPosition() {
            return IDMarkerContractV3.CC.$default$getDefaultLabelPosition(this);
        }

        public /* synthetic */ int getEnableLabelPosition() {
            return IDMarkerContractV3.CC.$default$getEnableLabelPosition(this);
        }

        public boolean isCanWork() {
            return true;
        }

        public Map getMap() {
            if (LoadingInfoWindow.this.f27609e == null) {
                return null;
            }
            return LoadingInfoWindow.this.f27609e.getMap();
        }

        public void setLabelDirect(String str, int i) {
            Marker labelMarkerById;
            if (LoadingInfoWindow.this.f27616l != null && (labelMarkerById = LoadingInfoWindow.this.f27616l.getLabelMarkerById(str)) != null && labelMarkerById.isVisible()) {
                LoadingInfoWindow.this.f27616l.updateMarkerLabelDirect(str, i);
            }
        }

        public List<Rect> getCollideAvoidRect() {
            if (LoadingInfoWindow.this.f27620p != null) {
                return LoadingInfoWindow.this.f27620p.getCollideAvoidRect();
            }
            return null;
        }

        public Padding getPadding() {
            return LoadingInfoWindow.this.f27619o == null ? new Padding() : LoadingInfoWindow.this.f27619o;
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f27606b;

    /* renamed from: c */
    private TextView f27607c;

    /* renamed from: d */
    private LottieAnimationView f27608d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MapView f27609e;

    /* renamed from: f */
    private Context f27610f;

    /* renamed from: g */
    private SpannableString f27611g;

    /* renamed from: h */
    private ValueAnimator f27612h;

    /* renamed from: i */
    private long f27613i;

    /* renamed from: j */
    private String f27614j = "lottie_departure_loading.json";

    /* renamed from: k */
    private int f27615k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IMarkersCompContract f27616l;

    /* renamed from: m */
    private String f27617m;

    /* renamed from: n */
    private boolean f27618n = true;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Padding f27619o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public CollideRectCallback f27620p;

    /* renamed from: q */
    private ILabelView f27621q = new ILabelView() {
        public /* synthetic */ View getView(Context context, String str, int i) {
            return ILabelView.CC.$default$getView(this, context, str, i);
        }

        public /* synthetic */ View getView(Context context, String str, int i, boolean z) {
            return ILabelView.CC.$default$getView(this, context, str, i, z);
        }

        public View getView(Context context, String str) {
            return LoadingInfoWindow.this.f27606b;
        }
    };

    public interface CollideRectCallback {
        List<Rect> getCollideAvoidRect();
    }

    public void setCollideRectCallback(CollideRectCallback collideRectCallback) {
        this.f27620p = collideRectCallback;
    }

    public LoadingInfoWindow(Context context, IMarkersCompContract iMarkersCompContract, String str, MapView mapView) {
        this.f27610f = context;
        this.f27616l = iMarkersCompContract;
        this.f27617m = str;
        this.f27609e = mapView;
        m21828a();
    }

    /* renamed from: a */
    private void m21828a() {
        Context context = this.f27610f;
        if (context != null && this.f27609e != null && this.f27616l != null && this.f27617m != null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.loading_info_window, (ViewGroup) null);
            this.f27606b = inflate;
            this.f27607c = (TextView) inflate.findViewById(R.id.tv_content);
            this.f27608d = (LottieAnimationView) this.f27606b.findViewById(R.id.loading_lottie);
            DIDIFontUtils.Companion.setTypeface(this.f27610f, this.f27607c);
            this.f27613i = System.currentTimeMillis();
            LottieAnimationView lottieAnimationView = this.f27608d;
            if (lottieAnimationView != null) {
                lottieAnimationView.setAnimation(this.f27614j);
                this.f27608d.setRepeatCount(-1);
            }
        }
    }

    /* renamed from: b */
    private void m21831b() {
        MapView mapView = this.f27609e;
        if (mapView == null || mapView.getMapVendor() != MapVendor.HUAWEI || System.currentTimeMillis() - this.f27613i >= 300) {
            this.f27613i = System.currentTimeMillis();
            IMarkersCompContract iMarkersCompContract = this.f27616l;
            if (iMarkersCompContract == null) {
                return;
            }
            if (this.f27618n) {
                MarkerModel markerModel = new MarkerModel();
                markerModel.setAddressName("breath");
                markerModel.setLabelZIndex(this.f27615k);
                markerModel.setLabelView(this.f27621q);
                markerModel.setLabelDirection(64);
                markerModel.setLabelSelected(false);
                markerModel.setLabelAnchorPadding((Padding) null);
                markerModel.setStrategy(this.f27605a);
                this.f27616l.addMarkerLabel(this.f27617m, markerModel);
                this.f27618n = false;
                return;
            }
            iMarkersCompContract.updateLabelView(this.f27617m, this.f27621q);
        }
    }

    /* renamed from: c */
    private void m21833c() {
        hideLoadingView();
        TextView textView = this.f27607c;
        if (textView != null) {
            textView.setText(this.f27611g);
            this.f27607c.setVisibility(0);
            LottieAnimationView lottieAnimationView = this.f27608d;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(8);
            }
            this.f27607c.bringToFront();
        }
        m21831b();
    }

    /* renamed from: d */
    private void m21835d() {
        if (this.f27612h == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f27612h = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LoadingInfoWindow.this.m21829a(valueAnimator);
                }
            });
            this.f27612h.setDuration(1000);
            this.f27612h.setRepeatCount(-1);
            this.f27612h.setRepeatMode(1);
        }
        if (!this.f27612h.isRunning()) {
            this.f27612h.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21829a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        LottieAnimationView lottieAnimationView = this.f27608d;
        if (lottieAnimationView != null) {
            lottieAnimationView.setProgress(floatValue);
        }
        m21831b();
    }

    /* renamed from: e */
    private void m21837e() {
        ValueAnimator valueAnimator = this.f27612h;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f27612h.cancel();
        }
    }

    public void setInfoWindowClickListener(OnMarkerCompClickListener onMarkerCompClickListener) {
        IMarkersCompContract iMarkersCompContract = this.f27616l;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setOnClickListener(onMarkerCompClickListener);
        }
    }

    public void showLoadingView() {
        if (this.f27608d != null) {
            TextView textView = this.f27607c;
            if (textView != null) {
                textView.setVisibility(8);
            }
            this.f27608d.setVisibility(0);
            m21835d();
        }
    }

    public void hideLoadingView() {
        LottieAnimationView lottieAnimationView = this.f27608d;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        m21837e();
    }

    public void showText(String str) {
        this.f27611g = new SpannableString(str);
        m21833c();
    }

    public void showText(SpannableString spannableString) {
        this.f27611g = spannableString;
        m21833c();
    }

    public void releaseView() {
        LottieAnimationView lottieAnimationView = this.f27608d;
        if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
            this.f27608d.cancelAnimation();
        }
        ICollideStrategy iCollideStrategy = this.f27605a;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
        }
        m21837e();
        this.f27606b = null;
        this.f27612h = null;
    }

    public void hideInfoWindow() {
        hideLoadingView();
        IMarkersCompContract iMarkersCompContract = this.f27616l;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setLabelVisible(this.f27617m, false);
        }
    }

    public void showInfoWindow() {
        IMarkersCompContract iMarkersCompContract = this.f27616l;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setLabelVisible(this.f27617m, true);
        }
    }

    public void setInfoWindowZIndex(int i) {
        this.f27615k = i;
        this.f27616l.updateLabelZindex(this.f27617m, i);
    }

    public void setPadding(Padding padding) {
        this.f27619o = padding;
    }
}
