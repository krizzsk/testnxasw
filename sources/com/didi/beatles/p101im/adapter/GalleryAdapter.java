package com.didi.beatles.p101im.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.api.entity.IMNewstandResponse;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.adapter.GalleryAdapter */
public class GalleryAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private OnItemClickLitener f10880a;

    /* renamed from: b */
    private LayoutInflater f10881b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMNewstandResponse.ActivityInfo[] f10882c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f10883d;

    /* renamed from: com.didi.beatles.im.adapter.GalleryAdapter$OnItemClickLitener */
    public interface OnItemClickLitener {
        void onItemClick(View view, int i);
    }

    public void setOnItemClickLitener(OnItemClickLitener onItemClickLitener) {
        this.f10880a = onItemClickLitener;
    }

    public GalleryAdapter(Context context, IMNewstandResponse.ActivityInfo[] activityInfoArr) {
        this.f10883d = context;
        this.f10881b = LayoutInflater.from(context);
        this.f10882c = activityInfoArr;
    }

    /* renamed from: com.didi.beatles.im.adapter.GalleryAdapter$ViewHolder */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImg;

        public ViewHolder(View view) {
            super(view);
        }
    }

    public int getItemCount() {
        return this.f10882c.length;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.f10881b.inflate(R.layout.activity_index_gallery_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        viewHolder.mImg = (ImageView) inflate.findViewById(R.id.id_index_gallery_item_image);
        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        BtsImageLoader.getInstance().loadRoundInto((Object) this.f10882c[i].activity_img, (View) viewHolder.mImg, (int) R.drawable.im_activity_img_holder);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMCommonUtil.startUriActivity(GalleryAdapter.this.f10883d, GalleryAdapter.this.f10882c[i].activity_url);
            }
        });
    }
}
