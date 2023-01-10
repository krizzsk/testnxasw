package com.didi.map.global.component.streetview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.streetview.IStreetViewLoader;
import com.didi.map.global.component.streetview.StreetViewComp;
import com.didi.map.global.component.streetview.utils.DisplayUtil;
import com.didi.map.global.component.streetview.utils.StreetOmegaUtils;
import com.didi.sdk.util.Base64;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.guideentrance.StreetCheckParam;
import com.sdk.poibase.model.guideentrance.StreetCheckResult;
import com.taxis99.R;
import java.io.IOException;

public class StreetViewLoaderImplV2 implements IStreetViewLoader {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ImageView f28498a;

    /* renamed from: b */
    private ImageView f28499b;

    /* renamed from: c */
    private TextView f28500c;

    /* renamed from: d */
    private TextView f28501d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f28502e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f28503f = "StreetViewLoaderNewImpl";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public StreetViewCompParams f28504g;

    /* renamed from: h */
    private ImageView f28505h;

    /* renamed from: i */
    private ImageView f28506i;

    /* renamed from: j */
    private ProgressBar f28507j;

    /* renamed from: k */
    private FrameLayout f28508k;

    /* renamed from: l */
    private FrameLayout f28509l;

    /* renamed from: m */
    private StreetViewComp.ILoadCallback f28510m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f28511n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f28512o = false;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public long f28513p = 0;

    /* renamed from: q */
    private Handler f28514q = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null && message.what == 0 && !StreetViewLoaderImplV2.this.f28502e && !StreetViewLoaderImplV2.this.f28512o) {
                DLog.m10773d(StreetViewLoaderImplV2.this.f28503f, "加载街景超时", new Object[0]);
                boolean unused = StreetViewLoaderImplV2.this.f28511n = true;
                StreetViewLoaderImplV2.this.m22264a(StreetStatus.STREET_LOAD_TIMEOUT);
                if (StreetViewLoaderImplV2.this.f28504g != null) {
                    StreetOmegaUtils.onStreetViewLoadTimeout(StreetViewLoaderImplV2.this.f28504g.getOrderId());
                }
            }
        }
    };

    /* renamed from: r */
    private boolean f28515r = false;

    /* renamed from: s */
    private int f28516s = 0;

    public int getLayoutResId() {
        return R.layout.map_comp_layout_street_view_dialog_v2;
    }

    public View createView(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(getLayoutResId(), (ViewGroup) null);
        this.f28498a = (ImageView) inflate.findViewById(R.id.streetImg);
        this.f28499b = (ImageView) inflate.findViewById(R.id.closeImg);
        this.f28501d = (TextView) inflate.findViewById(R.id.issueTv);
        this.f28500c = (TextView) inflate.findViewById(R.id.tipsTv);
        this.f28508k = (FrameLayout) inflate.findViewById(R.id.map_street_load_container);
        this.f28509l = (FrameLayout) inflate.findViewById(R.id.map_street_image_container);
        this.f28506i = (ImageView) inflate.findViewById(R.id.map_street_load_status_iv);
        this.f28507j = (ProgressBar) inflate.findViewById(R.id.map_street_loading_bar);
        Drawable drawable = inflate.getResources().getDrawable(R.drawable.map_comp_ic_street_view_arrow);
        drawable.setAutoMirrored(true);
        this.f28501d.setCompoundDrawablePadding(DisplayUtil.dp2px(inflate.getContext(), 5.0f));
        this.f28501d.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        return inflate;
    }

    public void load(StreetViewCompParams streetViewCompParams, ImageView imageView, StreetViewComp.ILoadCallback iLoadCallback) {
        FragmentActivity activity = streetViewCompParams.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            this.f28504g = streetViewCompParams;
            this.f28505h = imageView;
            this.f28510m = iLoadCallback;
            m22262a((Context) activity);
        }
    }

    public void setListener(IStreetViewLoader.OnStreetViewActionListener onStreetViewActionListener) {
        ImageView imageView = this.f28499b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    StreetViewLoaderImplV2.m22269b(IStreetViewLoader.OnStreetViewActionListener.this, view);
                }
            });
        }
        TextView textView = this.f28501d;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    StreetViewLoaderImplV2.m22263a(IStreetViewLoader.OnStreetViewActionListener.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m22269b(IStreetViewLoader.OnStreetViewActionListener onStreetViewActionListener, View view) {
        if (onStreetViewActionListener != null) {
            onStreetViewActionListener.hideView();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m22263a(IStreetViewLoader.OnStreetViewActionListener onStreetViewActionListener, View view) {
        if (onStreetViewActionListener != null) {
            onStreetViewActionListener.goFeedback();
        }
    }

    /* renamed from: a */
    private void m22262a(Context context) {
        Handler handler;
        if (this.f28504g != null) {
            m22264a(StreetStatus.STREET_LOADING);
            this.f28513p = System.currentTimeMillis();
            m22261a();
            int i = this.f28516s;
            if (i > 0 && (handler = this.f28514q) != null) {
                handler.sendEmptyMessageDelayed(0, (long) i);
            }
            String streetViewUrl = this.f28504g.getStreetViewUrl();
            if (!TextUtils.isEmpty(streetViewUrl)) {
                try {
                    final String str = new String(Base64.decode(streetViewUrl));
                    String str2 = this.f28503f;
                    DLog.m10773d(str2, "decodeUrl -->" + str, new Object[0]);
                    if (!this.f28515r) {
                        DLog.m10773d(this.f28503f, "do not network check", new Object[0]);
                        loadStreetUrl(str);
                        return;
                    }
                    DLog.m10773d(this.f28503f, "do network check with street", new Object[0]);
                    StreetCheckParam streetCheckParam = new StreetCheckParam();
                    streetCheckParam.setStreetViewUrl(str);
                    streetCheckParam.setTirpid(this.f28504g.getTripId());
                    PoiBaseApiFactory.createDidiApi(context).checkStreetIsValid(streetCheckParam, new IHttpListener<StreetCheckResult>() {
                        public void onSuccess(StreetCheckResult streetCheckResult) {
                            if (StreetViewLoaderImplV2.this.f28511n) {
                                DLog.m10773d(StreetViewLoaderImplV2.this.f28503f, "check result success，but timeout", new Object[0]);
                                boolean unused = StreetViewLoaderImplV2.this.f28511n = false;
                            } else if (streetCheckResult != null) {
                                if (streetCheckResult.viewenable == 1) {
                                    StreetViewLoaderImplV2.this.loadStreetUrl(str);
                                } else {
                                    boolean unused2 = StreetViewLoaderImplV2.this.f28512o = true;
                                    boolean unused3 = StreetViewLoaderImplV2.this.f28502e = false;
                                    StreetViewLoaderImplV2.this.m22264a(StreetStatus.STREET_INVALID);
                                }
                                if (StreetViewLoaderImplV2.this.f28504g != null) {
                                    StreetOmegaUtils.streetCheckNetworkTime(StreetViewLoaderImplV2.this.f28504g.getOrderId(), (int) (System.currentTimeMillis() - StreetViewLoaderImplV2.this.f28513p));
                                    long unused4 = StreetViewLoaderImplV2.this.f28513p = System.currentTimeMillis();
                                }
                            } else {
                                StreetViewLoaderImplV2.this.m22264a(StreetStatus.STREET_LOAD_FAILS);
                            }
                        }

                        public void onFail(IOException iOException) {
                            boolean unused = StreetViewLoaderImplV2.this.f28512o = true;
                            boolean unused2 = StreetViewLoaderImplV2.this.f28502e = false;
                            if (StreetViewLoaderImplV2.this.f28511n) {
                                DLog.m10773d(StreetViewLoaderImplV2.this.f28503f, "check result fail & timeout", new Object[0]);
                                boolean unused3 = StreetViewLoaderImplV2.this.f28511n = false;
                                return;
                            }
                            StreetViewLoaderImplV2.this.m22264a(StreetStatus.STREET_LOAD_FAILS);
                        }
                    });
                } catch (Exception e) {
                    String str3 = this.f28503f;
                    DLog.m10773d(str3, "base 64 url Exception:" + e.toString(), new Object[0]);
                    this.f28512o = true;
                    this.f28502e = false;
                    if (this.f28511n) {
                        DLog.m10773d(this.f28503f, "check result fail & timeout", new Object[0]);
                        this.f28511n = false;
                        return;
                    }
                    m22264a(StreetStatus.STREET_LOAD_FAILS);
                }
            }
        }
    }

    public void loadStreetUrl(String str) {
        if (this.f28504g != null && !TextUtils.isEmpty(str)) {
            LazyHeaders.Builder builder = new LazyHeaders.Builder();
            if (!TextUtils.isEmpty(this.f28504g.getTripId())) {
                builder.addHeader("X-Goog-Maps-Experience-ID", this.f28504g.getTripId());
            }
            Glide.with(this.f28504g.getActivity()).asBitmap().load((Object) new GlideUrl(str, (Headers) builder.build())).into(new CustomTarget<Bitmap>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    boolean unused = StreetViewLoaderImplV2.this.f28512o = true;
                    if (StreetViewLoaderImplV2.this.f28511n) {
                        DLog.m10773d(StreetViewLoaderImplV2.this.f28503f, "load  street success，but timeout", new Object[0]);
                        boolean unused2 = StreetViewLoaderImplV2.this.f28511n = false;
                        return;
                    }
                    if (bitmap != null) {
                        boolean unused3 = StreetViewLoaderImplV2.this.f28502e = true;
                        if (StreetViewLoaderImplV2.this.f28498a != null) {
                            StreetViewLoaderImplV2.this.f28498a.setImageBitmap(bitmap);
                        }
                        StreetViewLoaderImplV2.this.m22264a(StreetStatus.STREET_LOAD_SUCCESS);
                    } else {
                        boolean unused4 = StreetViewLoaderImplV2.this.f28502e = false;
                        StreetViewLoaderImplV2.this.m22264a(StreetStatus.STREET_LOAD_FAILS);
                    }
                    if (StreetViewLoaderImplV2.this.f28504g != null) {
                        StreetOmegaUtils.streetViewLoadTime(StreetViewLoaderImplV2.this.f28504g.getOrderId(), (int) (System.currentTimeMillis() - StreetViewLoaderImplV2.this.f28513p));
                        long unused5 = StreetViewLoaderImplV2.this.f28513p = System.currentTimeMillis();
                    }
                }

                public void onLoadFailed(Drawable drawable) {
                    super.onLoadFailed(drawable);
                    boolean unused = StreetViewLoaderImplV2.this.f28512o = true;
                    boolean unused2 = StreetViewLoaderImplV2.this.f28502e = false;
                    if (StreetViewLoaderImplV2.this.f28511n) {
                        DLog.m10773d(StreetViewLoaderImplV2.this.f28503f, "load  street success，but timeout", new Object[0]);
                        boolean unused3 = StreetViewLoaderImplV2.this.f28511n = false;
                        return;
                    }
                    StreetViewLoaderImplV2.this.m22264a(StreetStatus.STREET_LOAD_FAILS);
                }
            });
        }
    }

    public void cancelStreetViewLoad() {
        this.f28511n = false;
        this.f28512o = false;
        this.f28502e = false;
        this.f28513p = 0;
        Handler handler = this.f28514q;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f28514q.removeMessages(0);
        }
    }

    /* renamed from: com.didi.map.global.component.streetview.StreetViewLoaderImplV2$4 */
    static /* synthetic */ class C103884 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$global$component$streetview$StreetStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.map.global.component.streetview.StreetStatus[] r0 = com.didi.map.global.component.streetview.StreetStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$map$global$component$streetview$StreetStatus = r0
                com.didi.map.global.component.streetview.StreetStatus r1 = com.didi.map.global.component.streetview.StreetStatus.STREET_LOADING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$map$global$component$streetview$StreetStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.streetview.StreetStatus r1 = com.didi.map.global.component.streetview.StreetStatus.STREET_LOAD_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$map$global$component$streetview$StreetStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.component.streetview.StreetStatus r1 = com.didi.map.global.component.streetview.StreetStatus.STREET_LOAD_FAILS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$map$global$component$streetview$StreetStatus     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.component.streetview.StreetStatus r1 = com.didi.map.global.component.streetview.StreetStatus.STREET_INVALID     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$map$global$component$streetview$StreetStatus     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.map.global.component.streetview.StreetStatus r1 = com.didi.map.global.component.streetview.StreetStatus.STREET_LOAD_SUCCESS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.streetview.StreetViewLoaderImplV2.C103884.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22264a(StreetStatus streetStatus) {
        int i = C103884.$SwitchMap$com$didi$map$global$component$streetview$StreetStatus[streetStatus.ordinal()];
        if (i == 1) {
            DLog.m10773d(this.f28503f, "status == loading", new Object[0]);
            m22266a(false);
            ProgressBar progressBar = this.f28507j;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            ImageView imageView = this.f28506i;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = this.f28500c;
            if (textView != null) {
                textView.setText(R.string.GRider_change_Image_loading_DwLs);
            }
            TextView textView2 = this.f28501d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else if (i == 2 || i == 3) {
            DLog.m10773d(this.f28503f, "status == timeOut|| fails", new Object[0]);
            m22266a(false);
            ImageView imageView2 = this.f28506i;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                this.f28506i.setImageResource(R.drawable.map_street_net_bad);
            }
            ProgressBar progressBar2 = this.f28507j;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
            TextView textView3 = this.f28500c;
            if (textView3 != null) {
                textView3.setText(R.string.GRider_change_A_network_HLhC);
            }
            TextView textView4 = this.f28501d;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            StreetViewComp.ILoadCallback iLoadCallback = this.f28510m;
            if (iLoadCallback != null) {
                iLoadCallback.onFail();
            }
        } else if (i == 4) {
            DLog.m10773d(this.f28503f, "status == invalid", new Object[0]);
            m22266a(false);
            ImageView imageView3 = this.f28506i;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
                this.f28506i.setImageResource(R.drawable.map_street_not_use);
            }
            ProgressBar progressBar3 = this.f28507j;
            if (progressBar3 != null) {
                progressBar3.setVisibility(8);
            }
            TextView textView5 = this.f28500c;
            if (textView5 != null) {
                textView5.setText(R.string.GRider_change_I_am_UHdp);
            }
            TextView textView6 = this.f28501d;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            StreetViewComp.ILoadCallback iLoadCallback2 = this.f28510m;
            if (iLoadCallback2 != null) {
                iLoadCallback2.onStreetViewInvalid();
            }
        } else if (i == 5) {
            DLog.m10773d(this.f28503f, "status == success", new Object[0]);
            m22266a(true);
            TextView textView7 = this.f28500c;
            if (textView7 != null) {
                textView7.setText(R.string.GRider_view2_The_driver_pQXa);
            }
            TextView textView8 = this.f28501d;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            StreetViewComp.ILoadCallback iLoadCallback3 = this.f28510m;
            if (iLoadCallback3 != null) {
                iLoadCallback3.onSuccess();
            }
        }
    }

    /* renamed from: a */
    private void m22266a(boolean z) {
        FrameLayout frameLayout = this.f28508k;
        int i = 8;
        if (frameLayout != null) {
            frameLayout.setVisibility(z ? 8 : 0);
        }
        FrameLayout frameLayout2 = this.f28509l;
        if (frameLayout2 != null) {
            if (z) {
                i = 0;
            }
            frameLayout2.setVisibility(i);
        }
    }

    /* renamed from: a */
    private String m22261a() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("map_global_street_view_check_toggle");
            if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
                return null;
            }
            boolean z = true;
            if (((Integer) experiment.getParam("enable", 0)).intValue() != 1) {
                z = false;
            }
            this.f28515r = z;
            if (!z) {
                return null;
            }
            this.f28516s = ((Integer) experiment.getParam("network_time", 0)).intValue();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
