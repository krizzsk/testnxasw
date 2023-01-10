package com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.addressnew.view.enhance.CommonItemEnhancer;
import com.didi.addressnew.view.enhance.EndItemEnhancer;
import com.didi.addressnew.view.enhance.IAddressItemEnhancer;
import com.didi.addressnew.view.enhance.StartItemEnhancer;
import com.didi.addressnew.view.enhance.SugRecItemEnhancer;
import com.didi.addressnew.widget.SubAddressViewApi;
import com.didi.sdk.util.collection.CollectionUtil;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiExtendInfo;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.model.recsug.RpcRecSugInfo;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    public static final int ADDRESS_TYPE_END = 2;
    public static final int ADDRESS_TYPE_START = 1;

    /* renamed from: a */
    private List<RpcPoi> f9059a;

    /* renamed from: b */
    private int f9060b;

    /* renamed from: c */
    private RpcRecSug.TrackParameterForChild f9061c;

    /* renamed from: d */
    private IAddressItemEnhancer f9062d;

    /* renamed from: e */
    private boolean f9063e;

    /* renamed from: f */
    private OnItemSelectedListener f9064f;

    /* renamed from: g */
    private int f9065g;

    public interface OnItemSelectedListener {
        void onItemSelected(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public ListViewAdapter(List<RpcPoi> list, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
        this.f9059a = list;
        this.f9060b = i;
        this.f9061c = trackParameterForChild;
        this.f9065g = i2;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f9064f = onItemSelectedListener;
    }

    public void setSupportConfirmDropOff(boolean z) {
        this.f9063e = z;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        Context context = viewGroup.getContext();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.poi_one_address_address_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.itemLayout = view.findViewById(R.id.layout_item);
            viewHolder.contentLayout = view.findViewById(R.id.layout_content);
            viewHolder.markImage = (ImageView) view.findViewById(R.id.sug_icon);
            viewHolder.nameLayout = (ViewGroup) view.findViewById(R.id.layout_name);
            viewHolder.displayNameText = (TextView) view.findViewById(R.id.sug_name);
            viewHolder.sugDistrictText = (TextView) view.findViewById(R.id.sug_district);
            viewHolder.addressText = (TextView) view.findViewById(R.id.sug_addr);
            viewHolder.suggestTagView = (TextView) view.findViewById(R.id.cf_tag);
            viewHolder.recTagView = (TextView) view.findViewById(R.id.rec_tag);
            viewHolder.distanceText = (TextView) view.findViewById(R.id.sug_distance);
            viewHolder.subView = (SubAddressViewApi) view.findViewById(R.id.view_subpoi);
            viewHolder.discountView = (SubAddressViewApi) view.findViewById(R.id.view_discountpoi);
            viewHolder.broadArrow = (ImageView) view.findViewById(R.id.poi_item_arrow);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        RpcPoi item = getItem(i);
        if (item.extend_info != null) {
            if (!TextUtils.isEmpty(item.extend_info.pre_icon_url)) {
                int i2 = this.f9060b;
                if (i2 == 1) {
                    ((RequestBuilder) ((RequestBuilder) Glide.with(context.getApplicationContext()).load(item.extend_info.pre_icon_url).placeholder((int) R.drawable.icon_position_start)).error((int) R.drawable.icon_position_start)).into(viewHolder.markImage);
                } else if (i2 == 2 || i2 == 6 || i2 == 101 || i2 == 102 || i2 == 4 || i2 == 3 || i2 == 5) {
                    ((RequestBuilder) ((RequestBuilder) Glide.with(context.getApplicationContext()).load(item.extend_info.pre_icon_url).placeholder((int) R.drawable.icon_position_end)).error((int) R.drawable.icon_position_end)).into(viewHolder.markImage);
                }
            } else {
                ((RequestBuilder) ((RequestBuilder) Glide.with(context.getApplicationContext()).load(item.extend_info.pre_logo_url).placeholder((int) R.drawable.icon_position)).error((int) R.drawable.icon_position)).into(viewHolder.markImage);
            }
        }
        if (item.base_info != null) {
            View view2 = viewHolder.contentLayout;
            view2.setContentDescription(item.base_info.displayname + item.base_info.addressAll);
            m7760a(viewHolder.displayNameText, TextUtils.isEmpty(item.base_info.displayname) ? item.base_info.address : item.base_info.displayname, (List<RpcPoiExtendInfo.DisplayNameAttribute>) item.extend_info.displayName_attribute);
        }
        m7765b(viewHolder);
        if (this.f9062d == null) {
            SugRecItemEnhancer sugRecItemEnhancer = new SugRecItemEnhancer();
            sugRecItemEnhancer.setSupportConfirmDropOff(this.f9063e);
            sugRecItemEnhancer.setSupportMultiLineName(true);
            int i3 = this.f9060b;
            if (i3 == 1) {
                this.f9062d = new StartItemEnhancer(sugRecItemEnhancer);
            } else if (i3 == 2) {
                this.f9062d = new EndItemEnhancer(sugRecItemEnhancer);
            } else {
                this.f9062d = new CommonItemEnhancer(sugRecItemEnhancer);
            }
        }
        this.f9062d.enhance(view, i, item);
        viewHolder.nameLayout.requestLayout();
        if (item.extend_info == null || TextUtils.isEmpty(item.extend_info.business_district)) {
            viewHolder.sugDistrictText.setVisibility(8);
        } else {
            viewHolder.sugDistrictText.setVisibility(0);
            viewHolder.sugDistrictText.setText(item.extend_info.business_district);
            if (!TextUtils.isEmpty(item.extend_info.business_district_color)) {
                viewHolder.sugDistrictText.setTextColor(Color.parseColor(item.extend_info.business_district_color));
            }
        }
        if (item.base_info != null) {
            m7764b(viewHolder.addressText, TextUtils.isEmpty(item.base_info.address) ? item.base_info.displayname : item.base_info.address, (List<RpcPoiExtendInfo.AddressAttribute>) item.extend_info.address_attribute);
        }
        if (item.extend_info == null || TextUtils.isEmpty(item.extend_info.distance)) {
            viewHolder.distanceText.setVisibility(8);
        } else {
            viewHolder.distanceText.setVisibility(0);
            viewHolder.distanceText.setText(item.extend_info.distance);
        }
        viewHolder.itemLayout.setOnClickListener(new View.OnClickListener(item, i) {
            public final /* synthetic */ RpcPoi f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                ListViewAdapter.this.m7762a(this.f$1, this.f$2, view);
            }
        });
        viewHolder.discountView.fillData((RpcPoi) null, item.discount_poi, !CollectionUtil.isEmpty((Collection<?>) item.discount_poi), this.f9061c);
        viewHolder.discountView.setOnItemClickLister(new SubAddressViewApi.OnItemClickListener(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onItemClick(RpcPoi rpcPoi, int i) {
                ListViewAdapter.this.m7763b(this.f$1, rpcPoi, i);
            }
        });
        viewHolder.subView.fillData((RpcPoi) null, item.sub_poi_list, true, this.f9061c);
        viewHolder.subView.setOnItemClickLister(new SubAddressViewApi.OnItemClickListener(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onItemClick(RpcPoi rpcPoi, int i) {
                ListViewAdapter.this.m7759a(this.f$1, rpcPoi, i);
            }
        });
        return view;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7762a(RpcPoi rpcPoi, int i, View view) {
        OnItemSelectedListener onItemSelectedListener = this.f9064f;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(rpcPoi, this.f9061c, i, -1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7763b(int i, RpcPoi rpcPoi, int i2) {
        OnItemSelectedListener onItemSelectedListener = this.f9064f;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(rpcPoi, this.f9061c, i, i2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7759a(int i, RpcPoi rpcPoi, int i2) {
        OnItemSelectedListener onItemSelectedListener = this.f9064f;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(rpcPoi, this.f9061c, i, i2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r2 = java.lang.Math.max(r8.location, 0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7760a(android.widget.TextView r6, java.lang.String r7, java.util.List<com.sdk.poibase.model.RpcPoiExtendInfo.DisplayNameAttribute> r8) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L_0x0056
            if (r8 == 0) goto L_0x0056
            int r0 = r8.size()
            if (r0 != 0) goto L_0x000f
            goto L_0x0056
        L_0x000f:
            int r0 = r7.length()
            android.text.SpannableString r1 = new android.text.SpannableString
            r1.<init>(r7)
            java.util.Iterator r7 = r8.iterator()
        L_0x001c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0052
            java.lang.Object r8 = r7.next()
            com.sdk.poibase.model.RpcPoiExtendInfo$DisplayNameAttribute r8 = (com.sdk.poibase.model.RpcPoiExtendInfo.DisplayNameAttribute) r8
            if (r8 == 0) goto L_0x001c
            int r2 = r8.location
            if (r2 >= r0) goto L_0x001c
            int r2 = r8.length
            if (r2 > 0) goto L_0x0033
            goto L_0x001c
        L_0x0033:
            int r2 = r8.location
            r3 = 0
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r8.location
            int r8 = r8.length
            int r3 = r3 + r8
            int r8 = java.lang.Math.min(r3, r0)
            if (r8 > r2) goto L_0x0046
            goto L_0x001c
        L_0x0046:
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r4 = 1
            r3.<init>(r4)
            r4 = 33
            r1.setSpan(r3, r2, r8, r4)
            goto L_0x001c
        L_0x0052:
            r6.setText(r1)
            return
        L_0x0056:
            r6.setText(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch.ListViewAdapter.m7760a(android.widget.TextView, java.lang.String, java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r2 = java.lang.Math.max(r8.location, 0);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7764b(android.widget.TextView r6, java.lang.String r7, java.util.List<com.sdk.poibase.model.RpcPoiExtendInfo.AddressAttribute> r8) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L_0x0063
            if (r8 == 0) goto L_0x0063
            int r0 = r8.size()
            if (r0 != 0) goto L_0x000f
            goto L_0x0063
        L_0x000f:
            int r0 = r7.length()
            android.text.SpannableString r1 = new android.text.SpannableString
            r1.<init>(r7)
            java.util.Iterator r7 = r8.iterator()
        L_0x001c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x005f
            java.lang.Object r8 = r7.next()
            com.sdk.poibase.model.RpcPoiExtendInfo$AddressAttribute r8 = (com.sdk.poibase.model.RpcPoiExtendInfo.AddressAttribute) r8
            if (r8 == 0) goto L_0x001c
            int r2 = r8.location
            if (r2 >= r0) goto L_0x001c
            int r2 = r8.length
            if (r2 <= 0) goto L_0x001c
            java.lang.String r2 = r8.color
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x003b
            goto L_0x001c
        L_0x003b:
            int r2 = r8.location
            r3 = 0
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r8.location
            int r4 = r8.length
            int r3 = r3 + r4
            int r3 = java.lang.Math.min(r3, r0)
            if (r3 > r2) goto L_0x004e
            goto L_0x001c
        L_0x004e:
            android.text.style.ForegroundColorSpan r4 = new android.text.style.ForegroundColorSpan
            java.lang.String r8 = r8.color
            int r8 = android.graphics.Color.parseColor(r8)
            r4.<init>(r8)
            r8 = 33
            r1.setSpan(r4, r2, r3, r8)
            goto L_0x001c
        L_0x005f:
            r6.setText(r1)
            return
        L_0x0063:
            r6.setText(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch.ListViewAdapter.m7764b(android.widget.TextView, java.lang.String, java.util.List):void");
    }

    /* renamed from: a */
    private void m7761a(final ViewHolder viewHolder) {
        viewHolder.displayNameText.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                viewHolder.displayNameText.removeOnLayoutChangeListener(this);
                viewHolder.displayNameText.setMaxWidth(viewHolder.getDisplayNameMaxSize());
            }
        });
    }

    /* renamed from: b */
    private void m7765b(ViewHolder viewHolder) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewHolder.distanceText.getLayoutParams();
        if (this.f9065g == RpcRecSugInfo.TYPE_EMPTY_RESULT) {
            layoutParams.rightMargin = 34;
            viewHolder.broadArrow.setVisibility(0);
        } else {
            layoutParams.rightMargin = 20;
            viewHolder.broadArrow.setVisibility(8);
        }
        viewHolder.distanceText.setLayoutParams(layoutParams);
    }

    public int getCount() {
        return CollectionUtil.size((Collection<?>) this.f9059a);
    }

    public RpcPoi getItem(int i) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f9059a)) {
            return this.f9059a.get(i);
        }
        return null;
    }

    private class ViewHolder {
        public TextView addressText;
        public ImageView broadArrow;
        public View contentLayout;
        public SubAddressViewApi discountView;
        public TextView displayNameText;
        public TextView distanceText;
        public View itemLayout;
        public ImageView markImage;
        public ViewGroup nameLayout;
        public TextView recTagView;
        public SubAddressViewApi subView;
        public TextView sugDistrictText;
        public TextView suggestTagView;

        private ViewHolder() {
        }

        public int getDisplayNameMaxSize() {
            return this.nameLayout.getWidth() - this.suggestTagView.getWidth();
        }
    }
}
