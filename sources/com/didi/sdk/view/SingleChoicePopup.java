package com.didi.sdk.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.taxis99.R;
import java.util.List;

public class SingleChoicePopup extends SimplePopupBase {

    /* renamed from: a */
    private CommonPopupTitleBar f40603a;

    /* renamed from: b */
    private String f40604b;

    /* renamed from: c */
    private String f40605c;

    /* renamed from: d */
    private View.OnClickListener f40606d;

    /* renamed from: e */
    private ListView f40607e;

    /* renamed from: f */
    private SingleChoiceAdapter f40608f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AdapterView.OnItemClickListener f40609g;

    /* renamed from: h */
    private int f40610h = -1;

    public static class SingleChoiceItem {
        public int mItemIconId = 0;
        public String mItemName = "";
        public String mMincontext;
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.v_common_single_choice_popup;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        m30487a(this.mRootView);
    }

    public void setTitle(String str) {
        this.f40604b = str;
    }

    public void setMessage(String str) {
        this.f40605c = str;
    }

    public void setLeftClickListener(View.OnClickListener onClickListener) {
        this.f40606d = onClickListener;
    }

    public void setContentAdapter(SingleChoiceAdapter singleChoiceAdapter) {
        this.f40608f = singleChoiceAdapter;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f40609g = onItemClickListener;
    }

    public void setLastSelectedIndex(int i) {
        this.f40610h = i;
    }

    /* renamed from: a */
    private void m30487a(View view) {
        CommonPopupTitleBar commonPopupTitleBar = (CommonPopupTitleBar) view.findViewById(R.id.title_bar);
        this.f40603a = commonPopupTitleBar;
        commonPopupTitleBar.setTitle(this.f40604b);
        if (!TextUtils.isEmpty(this.f40605c)) {
            this.f40603a.setMessage(this.f40605c);
        }
        CommonPopupTitleBar commonPopupTitleBar2 = this.f40603a;
        View.OnClickListener onClickListener = this.f40606d;
        if (onClickListener == null) {
            onClickListener = new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SingleChoicePopup.this.dismiss();
                }
            };
        }
        commonPopupTitleBar2.setLeft(onClickListener);
        SingleChoiceAdapter singleChoiceAdapter = this.f40608f;
        if (singleChoiceAdapter != null) {
            singleChoiceAdapter.setLastSelectedIndex(this.f40610h);
        }
        ListView listView = (ListView) view.findViewById(R.id.lv_content_list);
        this.f40607e = listView;
        listView.setAdapter(this.f40608f);
        this.f40607e.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (SingleChoicePopup.this.f40609g != null) {
                    SingleChoicePopup.this.f40609g.onItemClick(adapterView, view, i, j);
                }
                SingleChoicePopup.this.dismiss();
            }
        });
    }

    public static class SingleChoiceAdapter extends BaseAdapter {
        protected Context mContext;
        protected LayoutInflater mInflater;
        protected int mLastSelectedIndex = -1;
        protected List<SingleChoiceItem> mListContent;

        public long getItemId(int i) {
            return 0;
        }

        /* access modifiers changed from: protected */
        public int getTxtGravity() {
            return 8388627;
        }

        public SingleChoiceAdapter(Activity activity, List<SingleChoiceItem> list) {
            this.mContext = activity;
            this.mInflater = LayoutInflater.from(activity);
            this.mListContent = list;
        }

        public void setLastSelectedIndex(int i) {
            this.mLastSelectedIndex = i;
        }

        public int getCount() {
            List<SingleChoiceItem> list = this.mListContent;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public SingleChoiceItem getItem(int i) {
            List<SingleChoiceItem> list = this.mListContent;
            if (list == null || i < 0 || i >= list.size()) {
                return null;
            }
            return this.mListContent.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = this.mInflater.inflate(R.layout.v_common_pop_list_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            SingleChoiceItem item = getItem(i);
            if (item != null) {
                viewHolder.textView.setText(item.mItemName);
                if (!TextUtils.isEmpty(item.mMincontext)) {
                    viewHolder.minContextView.setVisibility(0);
                    viewHolder.minContextView.setText(item.mMincontext);
                }
                if (item.mItemIconId > 0) {
                    viewHolder.imageView.setImageResource(item.mItemIconId);
                    viewHolder.imageView.setVisibility(0);
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewHolder.contentView.getLayoutParams();
                layoutParams.gravity = getTxtGravity();
                viewHolder.contentView.setLayoutParams(layoutParams);
                if (i == this.mLastSelectedIndex) {
                    viewHolder.textView.setTextColor(this.mContext.getResources().getColor(R.color.common_dialog_recommend_option_txt_color));
                } else {
                    viewHolder.textView.setTextColor(this.mContext.getResources().getColor(R.color.dark_gray));
                }
            }
            return view;
        }

        public static class ViewHolder {
            public LinearLayout contentView;
            public ImageView imageView;
            public TextView minContextView;
            public TextView textView;

            public ViewHolder(View view) {
                this.contentView = (LinearLayout) view.findViewById(R.id.ll_root);
                this.imageView = (ImageView) view.findViewById(R.id.iv_icon);
                this.textView = (TextView) view.findViewById(R.id.tv_content);
                this.minContextView = (TextView) view.findViewById(R.id.tv_min_content);
            }
        }
    }
}
