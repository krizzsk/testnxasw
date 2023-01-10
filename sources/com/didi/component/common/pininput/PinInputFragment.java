package com.didi.component.common.pininput;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.common.widget.pin.PinInputLayout;
import com.didi.component.core.PresenterGroup;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class PinInputFragment extends AbsNormalFragment implements View.OnClickListener, IPinInputView, PinInputLayout.OnStateChangedListener {

    /* renamed from: a */
    private PinInputPresenter f13497a;

    /* renamed from: b */
    private CommonTitleBar f13498b;

    /* renamed from: c */
    private ViewGroup f13499c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PinInputLayout f13500d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f13501e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f13502f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f13503g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f13504h;

    /* renamed from: i */
    private Handler f13505i = new Handler(Looper.getMainLooper());

    /* renamed from: j */
    private ProgressDialogFragment f13506j;

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1030;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        PinInputPresenter pinInputPresenter = new PinInputPresenter(getContext(), getArguments());
        this.f13497a = pinInputPresenter;
        return pinInputPresenter;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.global_pin_input_fragment, viewGroup, false);
        this.f13499c = viewGroup2;
        m11276a(viewGroup2);
        return this.f13499c;
    }

    /* renamed from: a */
    private void m11276a(ViewGroup viewGroup) {
        m11279b(viewGroup);
        PinInputLayout pinInputLayout = (PinInputLayout) viewGroup.findViewById(R.id.oc_pin_input_layout);
        this.f13500d = pinInputLayout;
        pinInputLayout.setOnStateChangedListener(this);
        this.f13501e = (TextView) viewGroup.findViewById(R.id.oc_tips_title);
        this.f13502f = (TextView) viewGroup.findViewById(R.id.oc_tips_content);
        TextView textView = (TextView) viewGroup.findViewById(R.id.oc_confirm_btn);
        this.f13503g = textView;
        textView.setOnClickListener(this);
        showPinInputView();
    }

    /* renamed from: b */
    private void m11279b(ViewGroup viewGroup) {
        CommonTitleBar commonTitleBar = (CommonTitleBar) viewGroup.findViewById(R.id.oc_title_bar);
        this.f13498b = commonTitleBar;
        commonTitleBar.setTitleBarLineVisible(8);
        this.f13498b.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PinInputFragment.this.finishWithResultCancel();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        this.f13497a = null;
        this.f13499c = null;
        this.f13498b = null;
    }

    public void setTitle(String str) {
        this.f13498b.setTitle(str);
    }

    public void showUploadingDialog() {
        this.f13505i.post(new Runnable() {
            public void run() {
                PinInputFragment.this.displayProgressDialog((String) null);
            }
        });
    }

    public void dismissUploadingDialog() {
        this.f13505i.post(new Runnable() {
            public void run() {
                PinInputFragment.this.dismissProgressDialog();
            }
        });
    }

    public void showUploadFailedToast() {
        this.f13505i.post(new Runnable() {
            public void run() {
                ToastHelper.showShortInfo(PinInputFragment.this.getContext(), PinInputFragment.this.getContext().getResources().getString(R.string.global_pin_input_create_failed_toast));
            }
        });
    }

    public View getFallbackView() {
        return this.f13498b;
    }

    public void displayProgressDialog(String str) {
        showMaskLayerLoading();
    }

    public void dismissProgressDialog() {
        hideLoading();
    }

    public void showPinCreatedView() {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                boolean unused = PinInputFragment.this.f13504h = true;
                PinInputFragment.this.f13500d.setEditable(false);
                PinInputFragment.this.f13501e.setText(R.string.global_pin_input_finish_tips_title);
                PinInputFragment.this.f13502f.setText(R.string.global_pin_input_finish_tips_content);
                PinInputFragment.this.f13503g.setText(R.string.global_pin_input_finish_confirm);
                PinInputFragment.this.f13503g.setEnabled(true);
            }
        });
    }

    public void showPinInputView() {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                boolean unused = PinInputFragment.this.f13504h = false;
                PinInputFragment.this.f13500d.setEditable(true);
                PinInputFragment.this.f13501e.setText(R.string.global_pin_input_create_tips_title);
                PinInputFragment.this.f13502f.setText(R.string.global_pin_input_create_tips_content);
                PinInputFragment.this.f13503g.setText(R.string.global_pin_input_create_btn);
                PinInputFragment.this.f13503g.setEnabled(PinInputFragment.this.f13500d.isCompleted());
            }
        });
    }

    public void finishWithResultOk() {
        getActivity().setResult(-1);
        getActivity().finish();
    }

    public void finishWithResultCancel() {
        getActivity().setResult(0);
        getActivity().finish();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view != this.f13503g) {
            return;
        }
        if (this.f13504h) {
            finishWithResultOk();
            return;
        }
        this.f13497a.createPin(this.f13500d.getPin());
    }

    public void onStateChanged(PinInputLayout.State state) {
        if (state.equals(PinInputLayout.State.COMPLETE)) {
            this.f13503g.setEnabled(true);
        } else if (state.equals(PinInputLayout.State.INCOMPLETE)) {
            this.f13503g.setEnabled(false);
        }
    }
}
