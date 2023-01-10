package com.didi.beatles.p101im.views.popup;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.module.IMExtendBtnModule;
import com.didi.beatles.p101im.omega.IMMsgOmega;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.views.widget.IMDividerDecoration;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.popup.IMExtendBtnPopup */
public class IMExtendBtnPopup {

    /* renamed from: a */
    private static final String f12246a = "IMExtendBtnPopup";

    /* renamed from: f */
    private static final int f12247f = 45;

    /* renamed from: g */
    private static final int f12248g = 106;

    /* renamed from: h */
    private static final int f12249h = 30;

    /* renamed from: i */
    private static final int f12250i = 130;

    /* renamed from: b */
    private PopupWindow f12251b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f12252c;

    /* renamed from: d */
    private RecyclerView f12253d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<IMExtendBtnModule> f12254e;

    public IMExtendBtnPopup(Context context, List<IMExtendBtnModule> list) {
        if (list == null || list.size() == 0) {
            IMLog.m10020d(f12246a, "the button list is null !");
            return;
        }
        this.f12252c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.im_extend_btns_popup, (ViewGroup) null);
        this.f12251b = new PopupWindow(inflate, IMViewUtil.dp2px(context, 106.0f), IMViewUtil.dp2px(context, 45.0f));
        this.f12253d = (RecyclerView) inflate.findViewById(R.id.extend_popup_rview);
        this.f12254e = list;
        this.f12251b.setOutsideTouchable(true);
        this.f12251b.setBackgroundDrawable(new BitmapDrawable());
    }

    public void dismiss() {
        this.f12251b.dismiss();
    }

    public boolean isShowing() {
        return this.f12251b.isShowing();
    }

    public void show(View view) {
        List<IMExtendBtnModule> list;
        if (view != null && (list = this.f12254e) != null && list.size() != 0) {
            this.f12251b.setHeight(IMViewUtil.dp2px(this.f12252c, (float) ((this.f12254e.size() * 50) + 10 + 11)));
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            this.f12251b.showAtLocation(view, 48, IMViewUtil.dp2px(this.f12252c, 130.0f), iArr[1] + IMViewUtil.dp2px(this.f12252c, 30.0f));
            IMExtendBtnsAdapter iMExtendBtnsAdapter = new IMExtendBtnsAdapter();
            this.f12253d.setLayoutManager(new LinearLayoutManager(this.f12252c));
            this.f12253d.setAdapter(iMExtendBtnsAdapter);
            IMDividerDecoration iMDividerDecoration = new IMDividerDecoration();
            iMDividerDecoration.setDividerColor(IMResource.getColor(R.color.im_op_gray_line));
            this.f12253d.addItemDecoration(iMDividerDecoration);
            this.f12251b.setFocusable(true);
        }
    }

    /* renamed from: com.didi.beatles.im.views.popup.IMExtendBtnPopup$IMExtendBtnsAdapter */
    private class IMExtendBtnsAdapter extends RecyclerView.Adapter {
        private IMExtendBtnsAdapter() {
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new IMExtendViewHolder(LayoutInflater.from(IMExtendBtnPopup.this.f12252c).inflate(R.layout.im_item_extend_btns, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
            IMExtendViewHolder iMExtendViewHolder = (IMExtendViewHolder) viewHolder;
            if (((IMExtendBtnModule) IMExtendBtnPopup.this.f12254e.get(i)).icon != null) {
                BtsImageLoader.getInstance().loadInto(((IMExtendBtnModule) IMExtendBtnPopup.this.f12254e.get(i)).icon, iMExtendViewHolder.mImageview);
            }
            iMExtendViewHolder.mTextView.setText(((IMExtendBtnModule) IMExtendBtnPopup.this.f12254e.get(i)).text);
            iMExtendViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (((IMExtendBtnModule) IMExtendBtnPopup.this.f12254e.get(i)).link == null) {
                        IMLog.m10020d(IMExtendBtnPopup.f12246a, "link is null !");
                        return;
                    }
                    IMCommonUtil.startUriActivity(IMExtendBtnPopup.this.f12252c, ((IMExtendBtnModule) IMExtendBtnPopup.this.f12254e.get(i)).link);
                    IMExtendBtnPopup.this.dismiss();
                    IMMsgOmega.getInstance().trackMoreBtn(((IMExtendBtnModule) IMExtendBtnPopup.this.f12254e.get(i)).text);
                }
            });
        }

        public int getItemCount() {
            if (IMExtendBtnPopup.this.f12254e != null) {
                return IMExtendBtnPopup.this.f12254e.size();
            }
            return 0;
        }

        /* renamed from: com.didi.beatles.im.views.popup.IMExtendBtnPopup$IMExtendBtnsAdapter$IMExtendViewHolder */
        class IMExtendViewHolder extends RecyclerView.ViewHolder {
            ImageView mImageview;
            TextView mTextView;
            View rootView;

            public IMExtendViewHolder(View view) {
                super(view);
                this.mImageview = (ImageView) view.findViewById(R.id.extend_btn_icon);
                this.mTextView = (TextView) view.findViewById(R.id.extend_btn_text);
                this.rootView = view;
            }
        }
    }
}
