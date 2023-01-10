package com.didi.beatles.p101im.views.feed;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMRTLUtils;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.feed.IMListTopVHolder */
public class IMListTopVHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private TextView f12118a = ((TextView) this.itemView.findViewById(R.id.change_txt));

    /* renamed from: b */
    private TextView f12119b = ((TextView) this.itemView.findViewById(R.id.clear_txt));

    /* renamed from: c */
    private View f12120c = this.itemView.findViewById(R.id.mid_line);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ClearListener f12121d;

    /* renamed from: com.didi.beatles.im.views.feed.IMListTopVHolder$ClearListener */
    public interface ClearListener {
        void changeFeed(boolean z);

        void clearMsg(View view);
    }

    public IMListTopVHolder(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_list_item_top, viewGroup, false));
    }

    public void bindData(boolean z, boolean z2, boolean z3, int i, ClearListener clearListener) {
        this.f12121d = clearListener;
        if (z) {
            m10406a(z2);
            this.f12118a.setVisibility(0);
        } else {
            this.f12118a.setVisibility(8);
        }
        if (z3) {
            m10403a(i);
            this.f12119b.setVisibility(0);
        } else {
            this.f12119b.setVisibility(8);
        }
        if (!z || !z3) {
            this.f12120c.setVisibility(8);
        } else {
            this.f12120c.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m10406a(final boolean z) {
        if (z) {
            this.f12118a.setText(this.itemView.getResources().getString(R.string.im_change_list));
            IMRTLUtils.setCompoundDrawablesWithIntrinsicBoundsRTL(this.f12118a, this.itemView.getResources().getDrawable(R.drawable.im_icon_switch_list), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.f12118a.setText(this.itemView.getResources().getString(R.string.im_change_feed));
            IMRTLUtils.setCompoundDrawablesWithIntrinsicBoundsRTL(this.f12118a, this.itemView.getResources().getDrawable(R.drawable.im_icon_switch_card), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.f12118a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IMListTopVHolder.this.f12121d != null) {
                    IMListTopVHolder.this.f12121d.changeFeed(!z);
                }
            }
        });
    }

    /* renamed from: a */
    private void m10403a(final int i) {
        this.f12119b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMTraceUtil.addBusinessEvent("ddim_service_list_notice_clean_ck").report();
                if (i <= 0) {
                    IMListTopVHolder iMListTopVHolder = IMListTopVHolder.this;
                    iMListTopVHolder.m10405a(iMListTopVHolder.itemView.getResources().getString(R.string.im_list_clear_empty));
                }
                if (IMListTopVHolder.this.f12121d != null) {
                    IMListTopVHolder.this.f12121d.clearMsg(IMListTopVHolder.this.itemView);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10405a(String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) "", 0);
        if (Build.VERSION.SDK_INT < 14) {
            makeText.cancel();
        }
        SystemUtils.showToast(makeText);
        IMTipsToast.setIcon(makeText, IMResource.getDrawableID(R.drawable.im_toast_warm));
        IMTipsToast.setText(makeText, str);
    }
}
