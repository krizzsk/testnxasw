package com.didi.safety.god.p145ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safety.god.event.RestartDetectionEvent;
import com.didi.safety.god.util.FragmentUtils;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.taxis99.R;

/* renamed from: com.didi.safety.god.ui.UploadFailedFragment */
public class UploadFailedFragment extends Fragment {

    /* renamed from: a */
    private String f37566a = null;

    /* renamed from: b */
    private String f37567b = null;

    /* renamed from: c */
    private int f37568c = R.drawable.safety_god_china_btn_bg;

    public static UploadFailedFragment newInstance() {
        return new UploadFailedFragment();
    }

    public UploadFailedFragment setErrorMessage(String str) {
        this.f37566a = str;
        return this;
    }

    public UploadFailedFragment setButtonContent(String str) {
        this.f37567b = str;
        return this;
    }

    public UploadFailedFragment setButtonBackground(int i) {
        this.f37568c = i;
        return this;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upload_failed_layout, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.detection_error_msg)).setText(this.f37566a);
        TextView textView = (TextView) inflate.findViewById(R.id.iknow_btn);
        textView.setText(this.f37567b);
        textView.setBackgroundResource(this.f37568c);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FragmentUtils.closeFragment(UploadFailedFragment.this);
                BusUtils.post(new RestartDetectionEvent());
            }
        });
        inflate.requestFocus();
        inflate.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        });
        return inflate;
    }
}
