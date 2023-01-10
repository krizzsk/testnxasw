package com.didi.map.setting.global;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.setting.common.MapSettingAppInfo;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.map.setting.common.apollo.MapSettingApolloUtil;
import com.didi.map.setting.global.diversion.NavDiversionPloyImpl;
import com.taxis99.R;
import java.util.List;

public class NavListView extends FrameLayout {

    /* renamed from: a */
    private RecyclerView f31464a;

    /* renamed from: b */
    private MapSettingAdapter f31465b;

    /* renamed from: c */
    private OnItemClickListener f31466c;

    /* renamed from: d */
    private Context f31467d;

    public interface OnItemClickListener {
        void onItemClick(MapSettingAppInfo mapSettingAppInfo, int i);
    }

    public NavListView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f31467d = context;
        m24024a();
    }

    /* renamed from: a */
    private void m24024a() {
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(getContext()).inflate(R.layout.map_setting_list_view, this).findViewById(R.id.list_view);
        this.f31464a = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void initListData(List<MapSettingAppInfo> list, boolean z) {
        this.f31465b = new MapSettingAdapter(getContext(), list);
        if (z) {
            this.f31465b.setDiversionTarget(NavDiversionPloyImpl.newInstance(getContext()).getDiversionTarget(MapSettingNavUtils.getInstallNavTypeList(list)));
        }
        this.f31465b.setOnItemClickListener(this.f31466c);
        this.f31464a.setAdapter(this.f31465b);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f31466c = onItemClickListener;
        MapSettingAdapter mapSettingAdapter = this.f31465b;
        if (mapSettingAdapter != null) {
            mapSettingAdapter.setOnItemClickListener(onItemClickListener);
        }
    }

    private static class MapSettingAdapter extends RecyclerView.Adapter<C11043VH> {
        private Context mContext;
        /* access modifiers changed from: private */
        public OnItemClickListener mOnItemClickListener;
        private String mTargetNavType;
        private List<MapSettingAppInfo> mThirdNavList;

        public MapSettingAdapter(Context context, List<MapSettingAppInfo> list) {
            this.mContext = context;
            this.mThirdNavList = list;
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mOnItemClickListener = onItemClickListener;
        }

        public void setDiversionTarget(String str) {
            this.mTargetNavType = str;
        }

        public C11043VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C11043VH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.map_setting_item_view, viewGroup, false));
        }

        public void onBindViewHolder(C11043VH vh, final int i) {
            final MapSettingAppInfo item = getItem(i);
            if (item != null) {
                if (i == 0) {
                    vh.mDivider.setVisibility(8);
                } else {
                    vh.mDivider.setVisibility(0);
                }
                vh.mNavIconImg.setImageDrawable(item.appIcon);
                vh.mNavNameTv.setText(item.appLabel);
                if (TextUtils.isEmpty(this.mTargetNavType) || !item.isInstalled) {
                    vh.mRecommendFlagTv.setVisibility(8);
                } else if (TextUtils.equals(item.navType, this.mTargetNavType)) {
                    vh.mRecommendFlagTv.setVisibility(0);
                } else {
                    vh.mRecommendFlagTv.setVisibility(8);
                }
                if (item.isInstalled) {
                    vh.mNavNameTv.setTextColor(this.mContext.getResources().getColor(R.color.map_setting_item_text));
                    vh.itemView.setEnabled(true);
                    vh.itemView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (MapSettingAdapter.this.mOnItemClickListener != null) {
                                MapSettingAdapter.this.mOnItemClickListener.onItemClick(item, i);
                            }
                        }
                    });
                } else {
                    vh.mNavNameTv.setTextColor(this.mContext.getResources().getColor(R.color.map_setting_item_gray));
                    vh.itemView.setEnabled(false);
                }
                if (!MapSettingApolloUtil.isShowYandexNavTimes() || !MapSettingNavConstant.YANDEX_NAV.equals(item.pkgName)) {
                    vh.mNavNameDesc.setVisibility(8);
                    return;
                }
                int yandexNavLeftTimes = MapSettingNavUtils.getYandexNavLeftTimes(this.mContext);
                vh.mNavNameDesc.setVisibility(0);
                vh.mNavNameDesc.setText(String.format(this.mContext.getString(R.string.GDriver_yandex2_Number_of_tJxg), new Object[]{String.valueOf(yandexNavLeftTimes)}));
            }
        }

        private MapSettingAppInfo getItem(int i) {
            List<MapSettingAppInfo> list = this.mThirdNavList;
            if (list == null || list.size() <= i) {
                return null;
            }
            return this.mThirdNavList.get(i);
        }

        public int getItemCount() {
            List<MapSettingAppInfo> list = this.mThirdNavList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        /* renamed from: com.didi.map.setting.global.NavListView$MapSettingAdapter$VH */
        private static class C11043VH extends RecyclerView.ViewHolder {
            /* access modifiers changed from: private */
            public View mDivider;
            /* access modifiers changed from: private */
            public ImageView mNavIconImg;
            /* access modifiers changed from: private */
            public TextView mNavNameDesc;
            /* access modifiers changed from: private */
            public TextView mNavNameTv;
            /* access modifiers changed from: private */
            public TextView mRecommendFlagTv;

            public C11043VH(View view) {
                super(view);
                this.mNavIconImg = (ImageView) view.findViewById(R.id.nav_icon);
                this.mNavNameTv = (TextView) view.findViewById(R.id.nav_name);
                this.mNavNameDesc = (TextView) view.findViewById(R.id.nav_desc);
                this.mRecommendFlagTv = (TextView) view.findViewById(R.id.nav_recommend);
                this.mDivider = view.findViewById(R.id.nav_divider);
            }
        }
    }
}
