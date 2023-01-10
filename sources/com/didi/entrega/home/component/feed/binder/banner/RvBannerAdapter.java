package com.didi.entrega.home.component.feed.binder.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.app.nova.skeleton.image.ImageRequestListener;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RvBannerAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    /* renamed from: d */
    private static final String f22531d = "RvBannerAdapter";

    /* renamed from: a */
    int f22532a;

    /* renamed from: b */
    FitType f22533b = FitType.FIT_None;

    /* renamed from: c */
    boolean f22534c = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final OnBannerImageDownLoadListener f22535e;

    /* renamed from: f */
    private final WeakReference<RvBanner> f22536f;

    /* renamed from: g */
    private List<String> f22537g;

    /* renamed from: h */
    private Context f22538h;

    /* renamed from: i */
    private int f22539i;

    /* renamed from: j */
    private float f22540j;

    RvBannerAdapter(RvBanner rvBanner, Context context, float f, List<String> list, OnBannerImageDownLoadListener onBannerImageDownLoadListener) {
        ArrayList arrayList = new ArrayList();
        this.f22537g = arrayList;
        this.f22538h = context;
        arrayList.clear();
        this.f22537g.addAll(list);
        this.f22536f = new WeakReference<>(rvBanner);
        this.f22539i = CustomerSystemUtil.getScreenWidth(this.f22538h) - this.f22538h.getResources().getDimensionPixelOffset(R.dimen.rf_dimen_64);
        this.f22540j = f;
        this.f22535e = onBannerImageDownLoadListener;
    }

    public int getItemCount() {
        if (this.f22534c) {
            return Integer.MAX_VALUE;
        }
        return this.f22537g.size();
    }

    public void onBindViewHolder(ItemViewHolder itemViewHolder, final int i) {
        if (this.f22534c) {
            i %= this.f22537g.size();
        }
        String str = this.f22537g.get(i);
        ViewGroup.LayoutParams layoutParams = itemViewHolder.mBannerImage.getLayoutParams();
        layoutParams.width = this.f22539i;
        layoutParams.height = getHeight();
        itemViewHolder.mBannerImage.setLayoutParams(layoutParams);
        if (itemViewHolder.mBannerImage.getTag() == null || !TextUtils.equals(itemViewHolder.mBannerImage.getTag().toString(), str)) {
            final long currentTimeMillis = System.currentTimeMillis();
            FlyImageLoader.loadImageUnspecified(this.f22538h, str).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder((int) R.drawable.entrega_skin_img_placeholder_x2110).centerCrop().listener(new ImageRequestListener() {
                public boolean onException(Exception exc, boolean z) {
                    if (exc != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(exc.getMessage());
                        sb.append(",getCause = ");
                        sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "null");
                        String sb2 = sb.toString();
                        LogUtil.m18185i(RvBannerAdapter.f22531d, "down load image fail = " + sb2);
                    }
                    LogUtil.m18185i(RvBannerAdapter.f22531d, "time = " + (System.currentTimeMillis() - currentTimeMillis));
                    if (RvBannerAdapter.this.f22535e == null) {
                        return false;
                    }
                    RvBannerAdapter.this.f22535e.onFail(i);
                    return false;
                }

                public boolean onResourceReady(Object obj, boolean z, boolean z2) {
                    LogUtil.m18185i(RvBannerAdapter.f22531d, "time = " + (System.currentTimeMillis() - currentTimeMillis) + ",isFromMemoryCache = " + z + ",isFirstResource = " + z2);
                    if (RvBannerAdapter.this.f22535e == null) {
                        return false;
                    }
                    RvBannerAdapter.this.f22535e.onSuccess(i, System.currentTimeMillis() - currentTimeMillis);
                    return false;
                }
            }).into(itemViewHolder.mBannerImage);
            itemViewHolder.mBannerImage.setTag(str);
        }
        itemViewHolder.mBannerImageMark.setOnClickListener(new View.OnClickListener(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                RvBannerAdapter.this.m18553a(this.f$1, view);
            }
        });
        LogUtil.m18185i(f22531d, "onBindViewHolder banner item width =" + this.f22539i + ",height = " + getHeight());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18553a(int i, View view) {
        if (((RvBanner) this.f22536f.get()).mOnBannerClickListener != null) {
            ((RvBanner) this.f22536f.get()).mOnBannerClickListener.onBannerClick(i);
        }
    }

    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.entrega_layout_banner_item, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.width = this.f22539i;
        layoutParams.height = getHeight();
        inflate.setLayoutParams(layoutParams);
        if (layoutParams != null) {
            LogUtil.m18185i(f22531d, "onCreateViewHolder banner item width =" + layoutParams.width + ",height = " + layoutParams.height);
        }
        return new ItemViewHolder(inflate);
    }

    public int getHeight() {
        return (int) (((float) this.f22539i) * this.f22540j);
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView mBannerImage;
        View mBannerImageMark;

        ItemViewHolder(View view) {
            super(view);
            this.mBannerImage = (ImageView) view.findViewById(R.id.iv_banner_icon);
            this.mBannerImageMark = view.findViewById(R.id.iv_banner_icon_mark);
        }
    }
}
