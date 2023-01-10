package com.didi.nova.kyc.jumio.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.nova.kyc.jumio.module.JumioParams;
import com.didi.nova.kyc.jumio.util.JumioOmegaUtil;
import com.didi.nova.kyc.jumio.widget.BottomTipsWindow;
import com.didi.sdk.apm.SystemUtils;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioScanView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.AdminPermission;

@Metadata(mo148867d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u001bJ\u0006\u0010$\u001a\u00020\u001bJ\u0012\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u000bJ\u0006\u0010)\u001a\u00020\u001bJ\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, mo148868d2 = {"Lcom/didi/nova/kyc/jumio/view/JumioScanCustomView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "inlineScanLayout", "Landroid/view/View;", "mScanPart", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "scanView", "Lcom/jumio/sdk/views/JumioScanView;", "startFallback", "Landroid/widget/TextView;", "subTitleView", "subTitleView1", "subTitleView2", "takePicture", "Landroid/widget/Button;", "tipWindow", "Lcom/didi/nova/kyc/jumio/widget/BottomTipsWindow;", "tipsView", "titleView", "toggleFlash", "attachView", "", "container", "Landroid/view/ViewGroup;", "cameraAvailable", "canFinish", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "closeTipWindow", "fallBack", "initScanView", "onClick", "v", "resetScanPart", "scanPart", "resetTitle", "stepScanView", "kyc-jumios_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: JumioScanCustomView.kt */
public final class JumioScanCustomView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    private View f31833a;

    /* renamed from: b */
    private TextView f31834b;

    /* renamed from: c */
    private TextView f31835c;

    /* renamed from: d */
    private TextView f31836d;

    /* renamed from: e */
    private TextView f31837e;

    /* renamed from: f */
    private JumioScanView f31838f;

    /* renamed from: g */
    private Button f31839g;

    /* renamed from: h */
    private Button f31840h;

    /* renamed from: i */
    private TextView f31841i;

    /* renamed from: j */
    private Button f31842j;

    /* renamed from: k */
    private BottomTipsWindow f31843k;

    /* renamed from: l */
    private JumioScanPart f31844l;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public JumioScanCustomView(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioScanCustomView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JumioScanCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f31833a = LayoutInflater.from(context).inflate(R.layout.jumio_scan_part, this, true);
        this.f31833a = findViewById(R.id.inlineScanLayout);
        this.f31834b = (TextView) findViewById(R.id.scan_title);
        this.f31835c = (TextView) findViewById(R.id.scan_sub_title);
        this.f31836d = (TextView) findViewById(R.id.scan_sub_title1);
        this.f31837e = (TextView) findViewById(R.id.scan_sub_title2);
        this.f31838f = (JumioScanView) findViewById(R.id.scanView);
        this.f31839g = (Button) findViewById(R.id.toggleFlash);
        this.f31840h = (Button) findViewById(R.id.takePicture);
        this.f31842j = (Button) findViewById(R.id.tips_view);
        this.f31841i = (TextView) findViewById(R.id.startFallback);
        Button button = this.f31839g;
        if (button != null) {
            button.setOnClickListener(this);
        }
        Button button2 = this.f31840h;
        if (button2 != null) {
            button2.setOnClickListener(this);
        }
        Button button3 = this.f31842j;
        if (button3 != null) {
            button3.setOnClickListener(this);
        }
        TextView textView = this.f31841i;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
    }

    public void attachView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        viewGroup.addView(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        boolean z = false;
        if (valueOf != null && valueOf.intValue() == R.id.toggleFlash) {
            JumioOmegaUtil.Companion.fin_jumiodocument_button_ck(JumioParams.INSTANCE.getBUTTON_FLASH());
            JumioScanView jumioScanView = this.f31838f;
            if (jumioScanView != null) {
                jumioScanView.setFlash(!(jumioScanView != null && jumioScanView.getFlash()));
            }
            JumioScanView jumioScanView2 = this.f31838f;
            if (jumioScanView2 != null && jumioScanView2.getFlash()) {
                z = true;
            }
            if (z) {
                JumioParams.INSTANCE.setFLASH_STATUS(1);
                Button button = this.f31839g;
                if (button != null) {
                    button.setBackgroundResource(R.drawable.kyc_jumio_flash_on);
                    return;
                }
                return;
            }
            JumioParams.INSTANCE.setFLASH_STATUS(2);
            Button button2 = this.f31839g;
            if (button2 != null) {
                button2.setBackgroundResource(R.drawable.kyc_jumio_flash_off);
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.takePicture) {
            JumioOmegaUtil.Companion.fin_jumiodocument_button_ck(JumioParams.INSTANCE.getBUTTON_TACK_PIC());
            JumioScanView jumioScanView3 = this.f31838f;
            if (jumioScanView3 != null) {
                jumioScanView3.takePicture();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.tips_view) {
            Button button3 = this.f31842j;
            if (button3 != null) {
                button3.setEnabled(false);
            }
            Button button4 = this.f31842j;
            if (button4 != null) {
                button4.setClickable(false);
            }
            JumioOmegaUtil.Companion.fin_jumiodocument_button_ck(JumioParams.INSTANCE.getBUTTON_TIPS());
            BottomTipsWindow bottomTipsWindow = new BottomTipsWindow();
            this.f31843k = bottomTipsWindow;
            if (bottomTipsWindow != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                if (bottomTipsWindow.showWindow(context, this)) {
                    z = true;
                }
            }
            if (z) {
                Button button5 = this.f31842j;
                if (button5 != null) {
                    button5.setEnabled(true);
                }
                Button button6 = this.f31842j;
                if (button6 != null) {
                    button6.setClickable(true);
                }
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.startFallback) {
            JumioOmegaUtil.Companion.fin_jumiodocument_button_ck(JumioParams.INSTANCE.getBUTTON_AUTO());
            JumioScanPart jumioScanPart = this.f31844l;
            if (jumioScanPart != null) {
                jumioScanPart.fallback();
            }
        }
    }

    public final void cameraAvailable() {
        Button button = this.f31839g;
        boolean z = false;
        if (button != null) {
            JumioScanView jumioScanView = this.f31838f;
            button.setEnabled(jumioScanView != null && jumioScanView.getHasFlash());
        }
        Button button2 = this.f31840h;
        if (button2 != null) {
            JumioScanView jumioScanView2 = this.f31838f;
            button2.setEnabled(jumioScanView2 != null && jumioScanView2.isShutterEnabled());
        }
        JumioScanView jumioScanView3 = this.f31838f;
        if (jumioScanView3 != null && jumioScanView3.isShutterEnabled()) {
            Button button3 = this.f31840h;
            if (button3 != null) {
                button3.setVisibility(0);
            }
        } else {
            Button button4 = this.f31840h;
            if (button4 != null) {
                button4.setVisibility(8);
            }
        }
        JumioScanView jumioScanView4 = this.f31838f;
        if (jumioScanView4 != null && jumioScanView4.getFlash()) {
            z = true;
        }
        if (z) {
            JumioParams.INSTANCE.setFLASH_STATUS(1);
            Button button5 = this.f31839g;
            if (button5 != null) {
                button5.setBackgroundResource(R.drawable.kyc_jumio_flash_on);
                return;
            }
            return;
        }
        JumioParams.INSTANCE.setFLASH_STATUS(2);
        Button button6 = this.f31839g;
        if (button6 != null) {
            button6.setBackgroundResource(R.drawable.kyc_jumio_flash_off);
        }
    }

    public final void resetScanPart(JumioScanPart jumioScanPart) {
        Intrinsics.checkNotNullParameter(jumioScanPart, "scanPart");
        this.f31844l = jumioScanPart;
        resetTitle();
    }

    public final void resetTitle() {
        if (JumioParams.INSTANCE.getDOCUMENT_SIDE() == 1) {
            TextView textView = this.f31834b;
            if (textView != null) {
                textView.setText(getContext().getString(R.string.Fintech_Payment_Integration__GDeS));
            }
            if (JumioParams.INSTANCE.getAUTO_TYPE() == 1) {
                TextView textView2 = this.f31835c;
                if (textView2 != null) {
                    textView2.setText(getContext().getString(R.string.Fintech_Payment_improvment_QDpd_lhsy));
                }
                TextView textView3 = this.f31836d;
                if (textView3 != null) {
                    textView3.setText(getContext().getString(R.string.Finance_improve_2_Remove_fZHO));
                }
                TextView textView4 = this.f31837e;
                if (textView4 != null) {
                    textView4.setText(getContext().getString(R.string.Fintech_Payment_improvment_vYjh_vGjP));
                    return;
                }
                return;
            }
            TextView textView5 = this.f31835c;
            if (textView5 != null) {
                textView5.setText(getContext().getString(R.string.Fintech_Payment_improvment_VqtR_QlHL));
            }
            TextView textView6 = this.f31836d;
            if (textView6 != null) {
                textView6.setText(getContext().getString(R.string.Finance_improve_2_Remove_fZHO));
            }
            TextView textView7 = this.f31837e;
            if (textView7 != null) {
                textView7.setText(getContext().getString(R.string.Finance_improve_3_Shoot_RzjJ));
                return;
            }
            return;
        }
        TextView textView8 = this.f31834b;
        if (textView8 != null) {
            textView8.setText(getContext().getString(R.string.Fintech_Payment_Integration__wroQ));
        }
        if (JumioParams.INSTANCE.getAUTO_TYPE() == 1) {
            TextView textView9 = this.f31835c;
            if (textView9 != null) {
                textView9.setText(getContext().getString(R.string.Fintech_Payment_Integration__UKGY));
            }
            TextView textView10 = this.f31836d;
            if (textView10 != null) {
                textView10.setText(getContext().getString(R.string.Finance_improve_2_Remove_fZHO));
            }
            TextView textView11 = this.f31837e;
            if (textView11 != null) {
                textView11.setText(getContext().getString(R.string.Fintech_Payment_improvment_vYjh_vGjP));
                return;
            }
            return;
        }
        TextView textView12 = this.f31835c;
        if (textView12 != null) {
            textView12.setText(getContext().getString(R.string.Fintech_Payment_Integration__tqqQ));
        }
        TextView textView13 = this.f31836d;
        if (textView13 != null) {
            textView13.setText(getContext().getString(R.string.Finance_improve_2_Remove_fZHO));
        }
        TextView textView14 = this.f31837e;
        if (textView14 != null) {
            textView14.setText(getContext().getString(R.string.Finance_improve_3_Shoot_RzjJ));
        }
    }

    public final void fallBack() {
        JumioScanPart jumioScanPart = this.f31844l;
        if (jumioScanPart != null) {
            SystemUtils.log(3, "jumio_test", Intrinsics.stringPlus("Start Fallback: ", jumioScanPart.getScanMode()), (Throwable) null, "com.didi.nova.kyc.jumio.view.JumioScanCustomView", 156);
            if (jumioScanPart.getHasFallback()) {
                TextView textView = this.f31841i;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            } else {
                TextView textView2 = this.f31841i;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
            Button button = this.f31840h;
            if (button != null) {
                JumioScanView jumioScanView = this.f31838f;
                button.setEnabled(jumioScanView != null && jumioScanView.isShutterEnabled());
            }
            TextView textView3 = this.f31841i;
            if (textView3 != null) {
                textView3.setEnabled(jumioScanPart.getHasFallback());
            }
            JumioScanView jumioScanView2 = this.f31838f;
            if (jumioScanView2 != null && jumioScanView2.isShutterEnabled()) {
                JumioParams.INSTANCE.setAUTO_TYPE(2);
                Button button2 = this.f31840h;
                if (button2 != null) {
                    button2.setVisibility(0);
                }
            } else {
                JumioParams.INSTANCE.setAUTO_TYPE(1);
                Button button3 = this.f31840h;
                if (button3 != null) {
                    button3.setVisibility(8);
                }
            }
            resetTitle();
            JumioOmegaUtil.Companion.fin_jumiodocument_sw();
        }
    }

    public final void stepScanView(Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, AdminPermission.LIFECYCLE);
        JumioScanView jumioScanView = this.f31838f;
        if (jumioScanView != null) {
            jumioScanView.invalidate();
            jumioScanView.requestLayout();
            jumioScanView.setExtraction(true);
            JumioScanPart jumioScanPart = this.f31844l;
            if (jumioScanPart != null) {
                jumioScanView.attach(jumioScanPart);
                lifecycle.addObserver(jumioScanView);
                boolean z = false;
                if (jumioScanPart.getHasFallback()) {
                    JumioParams.INSTANCE.setAUTO_TYPE(1);
                    TextView textView = this.f31841i;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                } else {
                    JumioParams.INSTANCE.setAUTO_TYPE(2);
                    TextView textView2 = this.f31841i;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                }
                TextView textView3 = this.f31841i;
                if (textView3 != null) {
                    if (jumioScanPart.getHasFallback()) {
                        z = true;
                    }
                    textView3.setEnabled(z);
                }
                if (jumioScanView.getFlash()) {
                    JumioParams.INSTANCE.setFLASH_STATUS(1);
                    Button button = this.f31839g;
                    if (button != null) {
                        button.setBackgroundResource(R.drawable.kyc_jumio_flash_on);
                    }
                } else {
                    JumioParams.INSTANCE.setFLASH_STATUS(2);
                    Button button2 = this.f31839g;
                    if (button2 != null) {
                        button2.setBackgroundResource(R.drawable.kyc_jumio_flash_off);
                    }
                }
                resetTitle();
            }
        }
    }

    public final void initScanView() {
        JumioScanView jumioScanView = this.f31838f;
        if (jumioScanView != null) {
            jumioScanView.setRatio(0.5f);
        }
        JumioScanView jumioScanView2 = this.f31838f;
        if (jumioScanView2 != null) {
            jumioScanView2.invalidate();
        }
        JumioScanView jumioScanView3 = this.f31838f;
        if (jumioScanView3 != null) {
            jumioScanView3.requestLayout();
        }
    }

    public final void canFinish(Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, AdminPermission.LIFECYCLE);
        JumioScanView jumioScanView = this.f31838f;
        if (jumioScanView != null) {
            lifecycle.removeObserver(jumioScanView);
        }
    }

    public final void closeTipWindow() {
        BottomTipsWindow bottomTipsWindow = this.f31843k;
        if (bottomTipsWindow != null) {
            bottomTipsWindow.closeWindow();
        }
    }
}
