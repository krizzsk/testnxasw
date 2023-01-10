package com.didi.beatles.p101im.views.popup;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.popup.IMMessageOperatePopup */
public class IMMessageOperatePopup implements View.OnClickListener {

    /* renamed from: b */
    private static IMMessageOperatePopup f12255b = null;

    /* renamed from: k */
    private static final int f12256k = 1;

    /* renamed from: l */
    private static final int f12257l = 2;

    /* renamed from: m */
    private static final int f12258m = 3;

    /* renamed from: a */
    private PopupWindow f12259a;

    /* renamed from: c */
    private OnItemClickListener f12260c;

    /* renamed from: d */
    private int f12261d = ((int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.message_item_popup_width_single_short));

    /* renamed from: e */
    private int f12262e = ((int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.popup_height));

    /* renamed from: f */
    private int f12263f;

    /* renamed from: g */
    private TextView f12264g;

    /* renamed from: h */
    private TextView f12265h;

    /* renamed from: i */
    private TextView f12266i;

    /* renamed from: j */
    private RelativeLayout f12267j;

    /* renamed from: n */
    private int f12268n;

    /* renamed from: o */
    private boolean f12269o;

    /* renamed from: com.didi.beatles.im.views.popup.IMMessageOperatePopup$OnItemClickListener */
    public interface OnItemClickListener {
        void onAddWordClick();

        void onCopyClick();

        void onDelClick();
    }

    public static IMMessageOperatePopup instance(ViewGroup viewGroup, boolean z) {
        if (f12255b == null) {
            synchronized (IMMessageOperatePopup.class) {
                f12255b = new IMMessageOperatePopup(viewGroup);
            }
        }
        IMMessageOperatePopup iMMessageOperatePopup = f12255b;
        iMMessageOperatePopup.f12269o = z;
        return iMMessageOperatePopup;
    }

    public void hidePopup() {
        IMMessageOperatePopup iMMessageOperatePopup = f12255b;
        if (iMMessageOperatePopup != null) {
            iMMessageOperatePopup.dismiss();
            this.f12260c = null;
        }
    }

    private IMMessageOperatePopup(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(IMContextInfoHelper.getContext()).inflate(R.layout.bts_im_popup_list, (ViewGroup) null);
        this.f12264g = (TextView) inflate.findViewById(R.id.left_btn);
        this.f12267j = (RelativeLayout) inflate.findViewById(R.id.right_content);
        this.f12265h = (TextView) inflate.findViewById(R.id.middle_btn);
        this.f12266i = (TextView) inflate.findViewById(R.id.right_btn);
        this.f12264g.setOnClickListener(this);
        this.f12265h.setOnClickListener(this);
        this.f12267j.setOnClickListener(this);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        this.f12263f = iArr[1];
        PopupWindow popupWindow = new PopupWindow(inflate, this.f12261d, this.f12262e);
        this.f12259a = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.f12259a.setBackgroundDrawable(new BitmapDrawable());
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f12260c = onItemClickListener;
    }

    public void show(View view, int i, boolean z) {
        boolean z2;
        PopupWindow popupWindow = this.f12259a;
        if (popupWindow != null && !popupWindow.isShowing()) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[1] - this.f12263f <= 0) {
                z2 = false;
            } else {
                iArr[1] = iArr[1] - 10;
                z2 = true;
            }
            if (i != 65536) {
                this.f12268n = 1;
            } else if (!this.f12269o) {
                this.f12268n = 2;
            } else if (z) {
                this.f12268n = 3;
            } else {
                this.f12268n = 2;
            }
            m10483a();
            this.f12259a.setWidth(this.f12261d);
            iArr[0] = iArr[0] + ((view.getWidth() - this.f12261d) / 2);
            if (z2) {
                this.f12259a.showAtLocation(view, 0, iArr[0], iArr[1] - ((int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.popup_height)));
            } else {
                this.f12259a.showAtLocation(view, 0, iArr[0], iArr[1]);
            }
        }
    }

    public static void onDestory() {
        f12255b = null;
    }

    /* renamed from: a */
    private void m10483a() {
        int i = this.f12268n;
        if (i == 1) {
            this.f12265h.setVisibility(0);
            this.f12264g.setVisibility(8);
            this.f12267j.setVisibility(8);
            this.f12261d = (int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.message_item_popup_width_single_short);
            this.f12265h.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_popup_center_selector));
        } else if (i == 2) {
            this.f12265h.setVisibility(8);
            this.f12264g.setVisibility(0);
            this.f12267j.setVisibility(0);
            this.f12261d = (int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.message_item_popup_width_double_short);
            this.f12266i.setText(IMResource.getString(R.string.im_pop_delete));
        } else if (i == 3) {
            this.f12265h.setVisibility(0);
            this.f12264g.setVisibility(0);
            this.f12267j.setVisibility(0);
            this.f12261d = (int) IMContextInfoHelper.getContext().getResources().getDimension(R.dimen.im_popup_threee_item_width);
            this.f12261d = (int) (((float) this.f12261d) + IMTextUtil.getTextWidth(this.f12266i, IMResource.getString(R.string.im_add_this_commom_word)));
            this.f12266i.setText(IMResource.getString(R.string.im_add_this_commom_word));
            this.f12265h.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_middle_popup_seletor));
        }
    }

    public void dismiss() {
        PopupWindow popupWindow = this.f12259a;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f12259a.dismiss();
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (R.id.left_btn == id) {
            dismiss();
            OnItemClickListener onItemClickListener = this.f12260c;
            if (onItemClickListener != null) {
                onItemClickListener.onCopyClick();
            }
        } else if (R.id.middle_btn == id) {
            dismiss();
            OnItemClickListener onItemClickListener2 = this.f12260c;
            if (onItemClickListener2 != null) {
                onItemClickListener2.onDelClick();
            }
        } else if (R.id.right_content == id) {
            dismiss();
            OnItemClickListener onItemClickListener3 = this.f12260c;
            if (onItemClickListener3 == null) {
                return;
            }
            if (this.f12268n == 2) {
                onItemClickListener3.onDelClick();
            } else {
                onItemClickListener3.onAddWordClick();
            }
        }
    }
}
