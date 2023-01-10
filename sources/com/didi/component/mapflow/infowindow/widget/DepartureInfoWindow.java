package com.didi.component.mapflow.infowindow.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.component.common.view.RichTextView;
import com.didi.component.mapflow.infowindow.model.BusComingModel;
import com.didi.component.mapflow.infowindow.model.DepartureModel;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.omega.sdk.Omega;
import com.taxis99.R;

public class DepartureInfoWindow extends LinearLayout {

    /* renamed from: a */
    private final int f16110a = 300;

    /* renamed from: b */
    private TextView f16111b;

    /* renamed from: c */
    private TextView f16112c;

    /* renamed from: d */
    private RichTextView f16113d;

    /* renamed from: e */
    private RichTextView f16114e;

    /* renamed from: f */
    private RichTextView f16115f;

    /* renamed from: g */
    private View f16116g;

    /* renamed from: h */
    private ImageView f16117h;

    /* renamed from: i */
    private View f16118i;

    /* renamed from: j */
    private View f16119j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f16120k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IUpdateCallback f16121l;

    /* renamed from: m */
    private Bitmap[] f16122m;

    /* renamed from: n */
    private int f16123n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f16124o = 300;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Handler f16125p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Runnable f16126q = new Runnable() {
        public void run() {
            DepartureInfoWindow.this.updateLoadingImage();
            if (DepartureInfoWindow.this.f16121l != null) {
                DepartureInfoWindow.this.f16121l.update();
            }
            if (!DepartureInfoWindow.this.f16120k) {
                DepartureInfoWindow.this.f16125p.postDelayed(DepartureInfoWindow.this.f16126q, (long) DepartureInfoWindow.this.f16124o);
            }
        }
    };

    public interface IUpdateCallback {
        void update();
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.global_map_two_line_with_loading;
    }

    public DepartureInfoWindow(Context context) {
        super(context);
        m13324a(context);
    }

    /* renamed from: a */
    private void m13324a(Context context) {
        this.f16125p = new Handler(Looper.getMainLooper());
        inflate(getContext(), getLayoutId(), this);
        this.f16111b = (TextView) findViewById(R.id.left_data_item1);
        this.f16112c = (TextView) findViewById(R.id.left_data_item2);
        this.f16113d = (RichTextView) findViewById(R.id.right_tips);
        this.f16114e = (RichTextView) findViewById(R.id.right_txt);
        this.f16115f = (RichTextView) findViewById(R.id.right_etd_txt);
        this.f16117h = (ImageView) findViewById(R.id.left_loading);
        this.f16116g = findViewById(R.id.left_data);
        this.f16118i = findViewById(R.id.divider);
        this.f16119j = findViewById(R.id.arrow);
        this.f16122m = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.global_mapflow_loading_one), BitmapFactory.decodeResource(getResources(), R.drawable.global_mapflow_loading_two), BitmapFactory.decodeResource(getResources(), R.drawable.global_mapflow_loading_three)};
        try {
            int color = DidiThemeManager.getIns().getResPicker(context).getColor(R.attr.caution_color);
            this.f16111b.setTextColor(color);
            this.f16112c.setTextColor(color);
            this.f16115f.setTextColor(color);
        } catch (Resources.NotFoundException e) {
            Omega.trackError("comp-mapflow", e);
        }
    }

    public void setData(BusComingModel busComingModel) {
        showLoading(false);
        TextView textView = this.f16111b;
        textView.setText(busComingModel.getTime() + "");
        this.f16112c.setText(busComingModel.getTimeUnit());
        this.f16114e.setText(busComingModel.getPlace());
    }

    public void setData(DepartureModel departureModel) {
        showLoading(departureModel.isShowLoading());
        this.f16111b.setText(departureModel.getEtaValue());
        this.f16112c.setText(departureModel.getEtaUnit());
        this.f16114e.setText(departureModel.getMessage());
        if (TextUtils.isEmpty(departureModel.getEtd())) {
            this.f16115f.setVisibility(8);
            this.f16114e.setMaxLines(2);
        } else {
            this.f16115f.setVisibility(0);
            this.f16115f.setText(departureModel.getEtd());
            this.f16114e.setMaxLines(1);
        }
        if (this.f16113d != null) {
            if (TextUtils.isEmpty(departureModel.getMapStartPointText())) {
                this.f16113d.setVisibility(8);
            } else {
                this.f16113d.setVisibility(0);
                this.f16113d.setText(departureModel.getMapStartPointText());
            }
        }
        showArrow(departureModel.isArrow());
        showMessageOnly(departureModel.isMessageOnly());
        if (departureModel.isShowNearbyHint()) {
            this.f16111b.setMaxWidth(ResourcesHelper.getDimensionPixelSize(getContext(), R.dimen.mapflow_departure_info_nearcar_msg_max_width));
            this.f16111b.setTypeface(Typeface.defaultFromStyle(0));
            this.f16112c.setVisibility(8);
            return;
        }
        this.f16111b.setTypeface(Typeface.defaultFromStyle(1));
        this.f16112c.setVisibility(0);
    }

    public void setEtaValue(CharSequence charSequence) {
        this.f16111b.setText(charSequence);
    }

    public void setEtaUnit(CharSequence charSequence) {
        this.f16112c.setText(charSequence);
    }

    public void setRightText(CharSequence charSequence) {
        this.f16114e.setText(charSequence);
    }

    public void setUpdateCallback(IUpdateCallback iUpdateCallback) {
        this.f16121l = iUpdateCallback;
    }

    public void showLoadingState() {
        this.f16123n = 0;
        this.f16120k = false;
        this.f16125p.removeCallbacks(this.f16126q);
        this.f16125p.postDelayed(this.f16126q, (long) this.f16124o);
    }

    public void showLoadingStateOnly(boolean z) {
        showLoading(true);
        if (z) {
            this.f16118i.setVisibility(8);
            this.f16114e.setVisibility(8);
            return;
        }
        this.f16118i.setVisibility(0);
        this.f16114e.setVisibility(0);
    }

    public void setInterval(int i) {
        if (i > 0) {
            this.f16124o = i;
        }
    }

    public void hideLoadingState() {
        this.f16120k = true;
        this.f16125p.removeCallbacks(this.f16126q);
    }

    public void updateLoadingImage() {
        int i = this.f16123n + 1;
        this.f16123n = i;
        if (i < 0 || i >= this.f16122m.length) {
            this.f16123n = 0;
        }
        this.f16117h.setImageBitmap(this.f16122m[this.f16123n]);
    }

    public void showLoading(boolean z) {
        if (z) {
            this.f16117h.setVisibility(0);
            this.f16118i.setVisibility(0);
            this.f16116g.setVisibility(8);
            showLoadingState();
            return;
        }
        hideLoadingState();
        this.f16117h.setVisibility(8);
        this.f16116g.setVisibility(0);
        this.f16118i.setVisibility(0);
    }

    public void showArrow(boolean z) {
        if (z) {
            this.f16119j.setVisibility(0);
        } else {
            this.f16119j.setVisibility(8);
        }
    }

    public void showMessageOnly(boolean z) {
        if (z) {
            this.f16116g.setVisibility(8);
            this.f16118i.setVisibility(8);
            this.f16117h.setVisibility(8);
        }
    }
}
