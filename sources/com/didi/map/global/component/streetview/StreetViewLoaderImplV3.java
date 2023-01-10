package com.didi.map.global.component.streetview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.taxis99.R;

public class StreetViewLoaderImplV3 implements IStreetViewLoader {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ImageView f28517a;

    /* renamed from: b */
    private ImageView f28518b;

    /* renamed from: c */
    private TextView f28519c;

    /* renamed from: d */
    private TextView f28520d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f28521e = false;

    /* renamed from: f */
    private String f28522f = "StreetViewLoaderImplV3";

    /* renamed from: g */
    private StreetViewCompParams f28523g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f28524h;

    /* renamed from: i */
    private ImageView f28525i;

    /* renamed from: j */
    private FrameLayout f28526j;

    /* renamed from: k */
    private FrameLayout f28527k;

    /* renamed from: l */
    private StreetViewComp.ILoadCallback f28528l;

    /* renamed from: m */
    private ProgressBar f28529m;

    /* renamed from: n */
    private LinearLayout f28530n;

    /* renamed from: o */
    private LinearLayout f28531o;

    public void cancelStreetViewLoad() {
    }

    public int getLayoutResId() {
        return R.layout.map_comp_layout_street_view_dialog_v3;
    }

    public View createView(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(getLayoutResId(), (ViewGroup) null);
        this.f28517a = (ImageView) inflate.findViewById(R.id.streetImg);
        this.f28518b = (ImageView) inflate.findViewById(R.id.closeImg);
        this.f28520d = (TextView) inflate.findViewById(R.id.issueTv);
        this.f28519c = (TextView) inflate.findViewById(R.id.tipsTv);
        this.f28526j = (FrameLayout) inflate.findViewById(R.id.map_street_load_container);
        this.f28527k = (FrameLayout) inflate.findViewById(R.id.map_street_image_container);
        this.f28525i = (ImageView) inflate.findViewById(R.id.map_street_load_status_iv);
        this.f28529m = (ProgressBar) inflate.findViewById(R.id.map_street_loading_bar);
        this.f28530n = (LinearLayout) inflate.findViewById(R.id.lin_issue_view);
        this.f28531o = (LinearLayout) inflate.findViewById(R.id.line_bottom_view);
        return inflate;
    }

    public void load(StreetViewCompParams streetViewCompParams, ImageView imageView, StreetViewComp.ILoadCallback iLoadCallback) {
        FragmentActivity activity;
        if (streetViewCompParams != null && (activity = streetViewCompParams.getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
            this.f28523g = streetViewCompParams;
            this.f28524h = imageView;
            this.f28528l = iLoadCallback;
            loadStreetUrl();
        }
    }

    public void setListener(IStreetViewLoader.OnStreetViewActionListener onStreetViewActionListener) {
        ImageView imageView = this.f28518b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    StreetViewLoaderImplV3.m22285b(IStreetViewLoader.OnStreetViewActionListener.this, view);
                }
            });
        }
        TextView textView = this.f28520d;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    StreetViewLoaderImplV3.m22279a(IStreetViewLoader.OnStreetViewActionListener.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m22285b(IStreetViewLoader.OnStreetViewActionListener onStreetViewActionListener, View view) {
        if (onStreetViewActionListener != null) {
            onStreetViewActionListener.hideView();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m22279a(IStreetViewLoader.OnStreetViewActionListener onStreetViewActionListener, View view) {
        if (onStreetViewActionListener != null) {
            onStreetViewActionListener.goFeedback();
        }
    }

    public void loadStreetUrl() {
        if (this.f28523g != null) {
            LazyHeaders.Builder builder = new LazyHeaders.Builder();
            if (!TextUtils.isEmpty(this.f28523g.getTripId())) {
                builder.addHeader("X-Goog-Maps-Experience-ID", this.f28523g.getTripId());
            }
            String streetViewUrl = this.f28523g.getStreetViewUrl();
            if (!TextUtils.isEmpty(streetViewUrl)) {
                GlideUrl glideUrl = new GlideUrl(streetViewUrl, (Headers) builder.build());
                m22280a(StreetStatus.STREET_LOADING);
                Glide.with(this.f28523g.getActivity()).asBitmap().load((Object) glideUrl).into(new CustomTarget<Bitmap>() {
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                        if (bitmap != null) {
                            boolean unused = StreetViewLoaderImplV3.this.f28521e = true;
                            if (StreetViewLoaderImplV3.this.f28517a != null) {
                                StreetViewLoaderImplV3.this.f28517a.setImageBitmap(bitmap);
                            }
                            if (StreetViewLoaderImplV3.this.f28524h != null) {
                                StreetViewLoaderImplV3.this.f28524h.setImageBitmap(bitmap);
                            }
                            StreetViewLoaderImplV3.this.m22280a(StreetStatus.STREET_LOAD_SUCCESS);
                            return;
                        }
                        boolean unused2 = StreetViewLoaderImplV3.this.f28521e = false;
                        StreetViewLoaderImplV3.this.m22280a(StreetStatus.STREET_LOAD_FAILS);
                    }

                    public void onLoadFailed(Drawable drawable) {
                        super.onLoadFailed(drawable);
                        boolean unused = StreetViewLoaderImplV3.this.f28521e = false;
                        StreetViewLoaderImplV3.this.m22280a(StreetStatus.STREET_LOAD_FAILS);
                    }
                });
            }
        }
    }

    /* renamed from: com.didi.map.global.component.streetview.StreetViewLoaderImplV3$2 */
    static /* synthetic */ class C103902 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.streetview.StreetViewLoaderImplV3.C103902.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22280a(StreetStatus streetStatus) {
        int i = C103902.$SwitchMap$com$didi$map$global$component$streetview$StreetStatus[streetStatus.ordinal()];
        if (i == 1) {
            DLog.m10773d(this.f28522f, "status == loading", new Object[0]);
            m22282a(false);
            ProgressBar progressBar = this.f28529m;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            ImageView imageView = this.f28525i;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView = this.f28519c;
            if (textView != null) {
                textView.setText(R.string.GRider_change_Image_loading_DwLs);
            }
            TextView textView2 = this.f28520d;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            LinearLayout linearLayout = this.f28530n;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
            LinearLayout linearLayout2 = this.f28531o;
            if (linearLayout2 != null) {
                linearLayout2.setBackground((Drawable) null);
            }
        } else if (i == 2 || i == 3) {
            DLog.m10773d(this.f28522f, "status == timeOut|| fails", new Object[0]);
            m22282a(false);
            ImageView imageView2 = this.f28525i;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
                this.f28525i.setImageResource(R.drawable.map_street_net_bad);
            }
            ProgressBar progressBar2 = this.f28529m;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
            TextView textView3 = this.f28519c;
            if (textView3 != null) {
                textView3.setText(R.string.GRider_change_A_network_HLhC);
            }
            TextView textView4 = this.f28520d;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            StreetViewComp.ILoadCallback iLoadCallback = this.f28528l;
            if (iLoadCallback != null) {
                iLoadCallback.onFail();
            }
            LinearLayout linearLayout3 = this.f28530n;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            LinearLayout linearLayout4 = this.f28531o;
            if (linearLayout4 != null) {
                linearLayout4.setBackground((Drawable) null);
            }
        } else if (i == 4) {
            DLog.m10773d(this.f28522f, "status == invalid", new Object[0]);
            m22282a(false);
            ImageView imageView3 = this.f28525i;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
                this.f28525i.setImageResource(R.drawable.map_street_not_use);
            }
            ProgressBar progressBar3 = this.f28529m;
            if (progressBar3 != null) {
                progressBar3.setVisibility(8);
            }
            TextView textView5 = this.f28519c;
            if (textView5 != null) {
                textView5.setText(R.string.GRider_change_I_am_UHdp);
            }
            TextView textView6 = this.f28520d;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            StreetViewComp.ILoadCallback iLoadCallback2 = this.f28528l;
            if (iLoadCallback2 != null) {
                iLoadCallback2.onStreetViewInvalid();
            }
            LinearLayout linearLayout5 = this.f28530n;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
            LinearLayout linearLayout6 = this.f28531o;
            if (linearLayout6 != null) {
                linearLayout6.setBackground((Drawable) null);
            }
        } else if (i == 5) {
            DLog.m10773d(this.f28522f, "status == success", new Object[0]);
            m22282a(true);
            TextView textView7 = this.f28519c;
            if (textView7 != null) {
                textView7.setText(R.string.GRider_view2_The_driver_pQXa);
            }
            TextView textView8 = this.f28520d;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            StreetViewComp.ILoadCallback iLoadCallback3 = this.f28528l;
            if (iLoadCallback3 != null) {
                iLoadCallback3.onSuccess();
            }
            LinearLayout linearLayout7 = this.f28530n;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(0);
            }
            LinearLayout linearLayout8 = this.f28531o;
            if (linearLayout8 != null) {
                linearLayout8.setBackgroundResource(R.drawable.map_comp_shape_street_dialog_bottom);
            }
        }
    }

    /* renamed from: a */
    private void m22282a(boolean z) {
        FrameLayout frameLayout = this.f28526j;
        int i = 8;
        if (frameLayout != null) {
            frameLayout.setVisibility(z ? 8 : 0);
        }
        FrameLayout frameLayout2 = this.f28527k;
        if (frameLayout2 != null) {
            if (z) {
                i = 0;
            }
            frameLayout2.setVisibility(i);
        }
    }
}
