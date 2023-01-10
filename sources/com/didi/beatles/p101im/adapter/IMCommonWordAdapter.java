package com.didi.beatles.p101im.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.IMCommonContextInfoHelper;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.utils.IMTextUtils;
import com.didi.beatles.p101im.omega.IMMsgOmega;
import com.didi.beatles.p101im.pref.IMPreference;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.views.IMPadCommonWordItemView;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.beatles.p101im.views.popup.IMDeletePopup;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.adapter.IMCommonWordAdapter */
public class IMCommonWordAdapter extends RecyclerView.Adapter {
    public static final int TYPE_DEFAULT = 1;
    public static final int TYPE_DRIVER = 2;
    public static final int TYPE_FOOTER = 3;
    public static final int TYPE_PAD = 4;
    public static final int TYPE_SEND_STREET_IMAGE = 5;

    /* renamed from: a */
    private List<String> f10884a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<String> f10885b;

    /* renamed from: c */
    private List<String> f10886c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f10887d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f10888e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IMCommonWordClickListener f10889f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IMDeletePopup f10890g;

    /* renamed from: h */
    private int f10891h;

    /* renamed from: com.didi.beatles.im.adapter.IMCommonWordAdapter$IMCommonWordClickListener */
    public interface IMCommonWordClickListener {
        void addCommonWord(int i);

        void deleteCommonWord(String str);

        void sendCommonWord(String str, int i);
    }

    public IMCommonWordAdapter(Context context, List<String> list, List<String> list2, int i, int i2, boolean z) {
        this.f10884a = list;
        this.f10887d = context;
        this.f10888e = i;
        this.f10890g = new IMDeletePopup(context);
        this.f10885b = list2;
        this.f10891h = i2;
        handleStreetImageList(z);
    }

    public void setCommonWordClickListener(IMCommonWordClickListener iMCommonWordClickListener) {
        this.f10889f = iMCommonWordClickListener;
    }

    public void replaceSystemList(List<String> list, boolean z) {
        IMLog.m10024i("commonword", "replaceSystemList");
        this.f10884a = list;
        handleStreetImageList(z);
        notifyDataSetChanged();
    }

    public void replaceCustomList(List<String> list) {
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("[replaceCustomList] size=");
        sb.append(list != null ? list.size() : 0);
        objArr[0] = sb.toString();
        IMLog.m10024i("commonword", objArr);
        this.f10885b = list;
        notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m9542a() {
        List<String> list = this.f10885b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: b */
    private int m9549b() {
        List<String> list = this.f10886c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getItemViewType(int i) {
        List<String> list = this.f10886c;
        if (list != null && i < list.size()) {
            return 5;
        }
        if (i == getItemCount() - 1) {
            return 3;
        }
        return this.f10891h;
    }

    public void handleStreetImageList(boolean z) {
        List<String> list;
        List<String> list2 = this.f10884a;
        if (list2 != null && list2.size() > 0) {
            List<String> list3 = this.f10886c;
            if (list3 == null) {
                this.f10886c = new ArrayList();
            } else {
                list3.clear();
            }
            if (2 == this.f10891h) {
                Iterator<String> it = this.f10884a.iterator();
                while (it.hasNext()) {
                    String streetImageContent = IMTextUtils.getStreetImageContent(it.next(), 8);
                    if (!TextUtils.isEmpty(streetImageContent)) {
                        if (z) {
                            this.f10886c.add(streetImageContent);
                        }
                        it.remove();
                    }
                }
                if (!z && (list = this.f10886c) != null) {
                    list.clear();
                }
            }
        }
    }

    public int getItemCount() {
        List<String> list = this.f10886c;
        int i = 0;
        if (list != null) {
            i = 0 + list.size();
        }
        List<String> list2 = this.f10884a;
        if (list2 != null) {
            i += list2.size();
        }
        List<String> list3 = this.f10885b;
        if (list3 != null) {
            i += list3.size();
        }
        return i + 1;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i == getItemCount() - 1) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (IMCommonWordAdapter.this.f10889f != null) {
                        IMCommonWordAdapter.this.f10889f.addCommonWord(IMCommonWordAdapter.this.f10885b != null ? IMCommonWordAdapter.this.f10885b.size() : 0);
                    }
                }
            });
            return;
        }
        m9544a(viewHolder, i);
        ((BaseViewHolder) viewHolder).setData(getText(i).text);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder;
        if (i == 1) {
            viewHolder = new DefaultViewHolder(viewGroup);
        } else if (i == 2) {
            viewHolder = new DriverViewHolder(viewGroup);
        } else if (i == 3) {
            int i2 = this.f10891h;
            if (i2 == 1) {
                viewHolder = new FootViewHolder(viewGroup);
            } else {
                viewHolder = i2 == 2 ? new DriverFootViewHolder(viewGroup) : new PadFootViewHolder(viewGroup);
            }
        } else if (i == 4) {
            viewHolder = new PadViewHolder(viewGroup);
        } else if (i != 5) {
            return null;
        } else {
            viewHolder = new DriverSendStreetViewHolder(viewGroup);
        }
        return viewHolder;
    }

    /* renamed from: a */
    private void m9544a(final RecyclerView.ViewHolder viewHolder, final int i) {
        final View view = viewHolder.itemView;
        if (view != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (IMCommonWordAdapter.this.getItemViewType(i) == 5) {
                        return true;
                    }
                    IMMsgOmega.getInstance().track("ddim_dy_all_leftup_ck", (Map<String, Object>) null);
                    IMCommonWordAdapter.this.f10890g.show(view, new IMDeletePopup.PopupOnClickListener() {
                        public void onClick() {
                            if (IMCommonWordAdapter.this.f10889f == null) {
                                return;
                            }
                            if (i >= IMCommonWordAdapter.this.m9542a()) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("state", 2);
                                IMMsgOmega.getInstance().track("ddim_dy_all_del_ck", hashMap);
                                IMCommonWordAdapter.this.m9548a(IMResource.getString(R.string.im_cant_delete_system_word));
                                return;
                            }
                            IMCommonWordAdapter.this.f10889f.deleteCommonWord(IMCommonWordAdapter.this.getText(i).text);
                        }
                    });
                    return true;
                }
            });
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (IMCommonWordAdapter.this.f10889f != null) {
                        IMCommonWord text = IMCommonWordAdapter.this.getText(i);
                        if (!TextUtils.isEmpty(text.text)) {
                            if (IMCommonWordAdapter.this.getItemViewType(i) == 5) {
                                RecyclerView.ViewHolder viewHolder = viewHolder;
                                if (viewHolder instanceof DriverSendStreetViewHolder) {
                                    IMCommonWordAdapter.this.m9545a((DriverSendStreetViewHolder) viewHolder);
                                }
                            }
                            IMCommonWordAdapter.this.f10889f.sendCommonWord(IMTextUtils.getContent(text.text), text.type);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9545a(DriverSendStreetViewHolder driverSendStreetViewHolder) {
        int btmTabRedDotShowedCount = IMPreference.getInstance(IMContextInfoHelper.getContext()).getBtmTabRedDotShowedCount(IMCommonContextInfoHelper.getUid(), 8);
        if (btmTabRedDotShowedCount < 1) {
            IMPreference.getInstance(IMContextInfoHelper.getContext()).saveBtmTabRedDotShowedCount(IMCommonContextInfoHelper.getUid(), 8, btmTabRedDotShowedCount + 1);
        }
        driverSendStreetViewHolder.setStreetDot(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9548a(String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) "", 0);
        if (Build.VERSION.SDK_INT < 14) {
            makeText.cancel();
        }
        SystemUtils.showToast(makeText);
        IMTipsToast.setIcon(makeText, IMResource.getDrawableID(R.drawable.im_toast_warm));
        IMTipsToast.setText(makeText, str);
    }

    public IMCommonWord getText(int i) {
        if (this.f10886c != null && i < m9549b()) {
            return new IMCommonWord(this.f10886c.get(i), 3);
        }
        if (i - m9549b() < m9542a()) {
            return new IMCommonWord(this.f10885b.get(i - m9549b()), 1);
        }
        if (this.f10884a == null) {
            return null;
        }
        if ((i - m9542a()) - m9549b() < this.f10884a.size()) {
            return new IMCommonWord(this.f10884a.get((i - m9542a()) - m9549b()), 2);
        }
        IMCommonWord iMCommonWord = new IMCommonWord();
        IMLog.m10021e("IMCommonwordAdapter", "invalid index " + i + ", size is " + this.f10884a.size() + "when getText() !");
        return iMCommonWord;
    }

    /* renamed from: com.didi.beatles.im.adapter.IMCommonWordAdapter$BaseViewHolder */
    abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        public abstract void setData(String str);

        public BaseViewHolder(View view) {
            super(view);
        }
    }

    /* renamed from: com.didi.beatles.im.adapter.IMCommonWordAdapter$DefaultViewHolder */
    private class DefaultViewHolder extends BaseViewHolder {
        View mLineView;
        TextView mTextView = ((TextView) this.itemView.findViewById(R.id.common_text));

        public DefaultViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(IMCommonWordAdapter.this.f10887d).inflate(R.layout.bts_common_item_layout, viewGroup, false));
            this.itemView.setLayoutParams(new AbsListView.LayoutParams(-1, IMCommonWordAdapter.this.f10888e));
            View findViewById = this.itemView.findViewById(R.id.im_common_text_line);
            this.mLineView = findViewById;
            findViewById.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_custom_word_divider_line));
        }

        public void setData(String str) {
            this.mTextView.setText(IMTextUtils.getContent(str));
        }
    }

    /* renamed from: com.didi.beatles.im.adapter.IMCommonWordAdapter$DriverViewHolder */
    private class DriverViewHolder extends BaseViewHolder {
        TextView mContentTv = ((TextView) this.itemView.findViewById(R.id.driver_item_content));
        TextView mTitleTv = ((TextView) this.itemView.findViewById(R.id.driver_item_title));

        public DriverViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(IMCommonWordAdapter.this.f10887d).inflate(R.layout.im_common_word_driver_item, viewGroup, false));
        }

        public void setData(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (!str.contains(IMTextUtils.DEVIDER_TAG)) {
                    this.mTitleTv.setText(str);
                    this.mTitleTv.setTextSize(24.0f);
                    this.mContentTv.setVisibility(8);
                    return;
                }
                this.mContentTv.setVisibility(0);
                this.mTitleTv.setTextSize(25.0f);
                this.mTitleTv.setText(IMTextUtils.getTitle(str));
                this.mContentTv.setText(IMTextUtils.getContent(str));
            }
        }
    }

    /* renamed from: com.didi.beatles.im.adapter.IMCommonWordAdapter$DriverSendStreetViewHolder */
    private class DriverSendStreetViewHolder extends BaseViewHolder {
        TextView mContentTv = ((TextView) this.itemView.findViewById(R.id.street_item_content));
        View mStreetDot = this.itemView.findViewById(R.id.street_item_dot);
        TextView mTitleTv = ((TextView) this.itemView.findViewById(R.id.street_item_title));

        public DriverSendStreetViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(IMCommonWordAdapter.this.f10887d).inflate(R.layout.im_common_word_street_item, viewGroup, false));
            Drawable drawable = IMCommonWordAdapter.this.f10887d.getResources().getDrawable(R.drawable.im_picture_ic_street_camera_icon);
            drawable.setBounds(0, 0, IMCommonWordAdapter.this.f10887d.getResources().getDimensionPixelSize(R.dimen.im_21_dp), IMCommonWordAdapter.this.f10887d.getResources().getDimensionPixelSize(R.dimen.im_23_dp));
            this.mTitleTv.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            if (IMPreference.getInstance(IMContextInfoHelper.getContext()).getBtmTabRedDotShowedCount(IMCommonContextInfoHelper.getUid(), 8) < 1) {
                IMViewUtil.show(this.mStreetDot);
            } else {
                IMViewUtil.hide(this.mStreetDot);
            }
        }

        public void setData(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (!str.contains(IMTextUtils.DEVIDER_TAG)) {
                    this.mTitleTv.setText(str);
                    this.mTitleTv.setTextSize(24.0f);
                    this.mContentTv.setVisibility(8);
                    return;
                }
                this.mContentTv.setVisibility(0);
                this.mTitleTv.setTextSize(25.0f);
                this.mTitleTv.setText(IMTextUtils.getTitle(str));
                this.mContentTv.setText(IMTextUtils.getContent(str));
            }
        }

        public void setStreetDot(int i) {
            if (i == 0) {
                IMViewUtil.show(this.mStreetDot);
            } else {
                IMViewUtil.hide(this.mStreetDot);
            }
        }
    }

    /* renamed from: com.didi.beatles.im.adapter.IMCommonWordAdapter$PadViewHolder */
    private class PadViewHolder extends BaseViewHolder {
        private IMPadCommonWordItemView commonWordItemView = ((IMPadCommonWordItemView) this.itemView.findViewById(R.id.im_pad_common_word_item_view));

        public PadViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(IMCommonWordAdapter.this.f10887d).inflate(R.layout.im_pad_common_word_item_view, viewGroup, false));
            this.itemView.getLayoutParams().height = (int) ((((double) IMCommonWordAdapter.this.f10888e) * 4.5d) - ((double) IMViewUtil.dp2px(IMCommonWordAdapter.this.f10887d, 20.0f)));
        }

        public void setData(String str) {
            this.commonWordItemView.bind(str);
        }
    }

    /* renamed from: com.didi.beatles.im.adapter.IMCommonWordAdapter$FootViewHolder */
    private class FootViewHolder extends BaseViewHolder {
        private TextView mTextView;

        public void setData(String str) {
        }

        public FootViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(IMCommonWordAdapter.this.f10887d).inflate(R.layout.im_common_item_footer, viewGroup, false));
            TextView textView = (TextView) this.itemView.findViewById(R.id.im_item_footer_tv);
            this.mTextView = textView;
            textView.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
            this.mTextView.setCompoundDrawablesWithIntrinsicBounds(IMResource.getDrawableID(R.drawable.im_nomix_edit), 0, 0, 0);
            ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
            layoutParams.height = IMCommonWordAdapter.this.f10888e;
            this.mTextView.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.didi.beatles.im.adapter.IMCommonWordAdapter$DriverFootViewHolder */
    private class DriverFootViewHolder extends BaseViewHolder {
        private TextView mTextView;

        public void setData(String str) {
        }

        public DriverFootViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(IMCommonWordAdapter.this.f10887d).inflate(R.layout.im_driver_word_footer_item, viewGroup, false));
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
            layoutParams.setMargins(IMViewUtil.dp2px(IMCommonWordAdapter.this.f10887d, 15.0f), IMViewUtil.dp2px(IMCommonWordAdapter.this.f10887d, 6.0f), IMViewUtil.dp2px(IMCommonWordAdapter.this.f10887d, 15.0f), IMViewUtil.dp2px(IMCommonWordAdapter.this.f10887d, 15.0f));
            this.itemView.setLayoutParams(layoutParams);
            TextView textView = (TextView) this.itemView.findViewById(R.id.im_item_footer_tv);
            this.mTextView = textView;
            textView.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
            this.mTextView.setCompoundDrawablesWithIntrinsicBounds(0, IMResource.getDrawableID(R.drawable.im_add_common_word), 0, 0);
        }
    }

    /* renamed from: com.didi.beatles.im.adapter.IMCommonWordAdapter$PadFootViewHolder */
    private class PadFootViewHolder extends BaseViewHolder {
        private TextView mTextView;

        public void setData(String str) {
        }

        public PadFootViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(IMCommonWordAdapter.this.f10887d).inflate(R.layout.im_pad_item_foot, viewGroup, false));
            this.itemView.getLayoutParams().height = (int) ((((double) IMCommonWordAdapter.this.f10888e) * 4.5d) - ((double) IMViewUtil.dp2px(IMCommonWordAdapter.this.f10887d, 20.0f)));
            TextView textView = (TextView) this.itemView.findViewById(R.id.im_item_footer_tv);
            this.mTextView = textView;
            textView.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
        }
    }

    /* renamed from: com.didi.beatles.im.adapter.IMCommonWordAdapter$IMCommonWord */
    public static class IMCommonWord {
        public static final int IM_COMMON_WORD_TYPE_CUSTOM = 1;
        public static final int IM_COMMON_WORD_TYPE_STREET = 3;
        public static final int IM_COMMON_WORD_TYPE_SYSTEM = 2;
        String text;
        int type;

        IMCommonWord(String str, int i) {
            this.text = str;
            this.type = i;
        }

        IMCommonWord() {
        }
    }
}
