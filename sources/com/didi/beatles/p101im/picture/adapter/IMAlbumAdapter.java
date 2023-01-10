package com.didi.beatles.p101im.picture.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import com.didi.beatles.p101im.picture.entity.IMLocalMediaFolder;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.didi.beatles.p101im.utils.imageloader.IMImageRequestOptions;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.adapter.IMAlbumAdapter */
public class IMAlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f11193a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public List<IMLocalMediaFolder> f11194b = new ArrayList();

    /* renamed from: c */
    private int f11195c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnAlbumSelectListener f11196d;

    /* renamed from: com.didi.beatles.im.picture.adapter.IMAlbumAdapter$OnAlbumSelectListener */
    public interface OnAlbumSelectListener {
        void onAlbumSelect(String str, List<IMLocalMedia> list);
    }

    public IMAlbumAdapter(Context context) {
        this.f11193a = context;
    }

    public void bindAlbumData(List<IMLocalMediaFolder> list) {
        this.f11194b = list;
        notifyDataSetChanged();
    }

    public void setMimeType(int i) {
        this.f11195c = i;
    }

    public List<IMLocalMediaFolder> getFolderData() {
        if (this.f11194b == null) {
            this.f11194b = new ArrayList();
        }
        return this.f11194b;
    }

    public void setOnAlbumSelectListener(OnAlbumSelectListener onAlbumSelectListener) {
        this.f11196d = onAlbumSelectListener;
    }

    public AlbumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AlbumViewHolder(LayoutInflater.from(this.f11193a).inflate(R.layout.im_picture_album_item_view, viewGroup, false));
    }

    public void onBindViewHolder(final AlbumViewHolder albumViewHolder, int i) {
        final IMLocalMediaFolder iMLocalMediaFolder = this.f11194b.get(i);
        final Context context = albumViewHolder.itemView.getContext();
        String name = iMLocalMediaFolder.getName();
        int imageNum = iMLocalMediaFolder.getImageNum();
        String firstImagePath = iMLocalMediaFolder.getFirstImagePath();
        boolean isChecked = iMLocalMediaFolder.isChecked();
        if (iMLocalMediaFolder.getCheckedNum() > 0) {
            IMViewUtil.show((View) albumViewHolder.ivSelectDot);
        } else {
            IMViewUtil.hide((View) albumViewHolder.ivSelectDot);
        }
        albumViewHolder.itemView.setSelected(isChecked);
        BtsImageLoader.getInstance().download(firstImagePath, 150, 150, new IMImageRequestOptions().placeholder(R.drawable.im_picture_ic_image).centerCrop().sizeMultiplier(0.5f).diskCacheStrategy(IMImageRequestOptions.DiskCacheStrategy.ALL), new Callback() {
            public void onFailed() {
            }

            public void onStart() {
            }

            public void onSuccess(Bitmap bitmap) {
                if (bitmap != null) {
                    RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(IMAlbumAdapter.this.f11193a.getResources(), bitmap);
                    create.setCornerRadius((float) IMViewUtil.dp2px(context, 5.0f));
                    albumViewHolder.ivAlbumImage.setImageDrawable(create);
                }
            }
        });
        albumViewHolder.tvAlbumInfo.setText(String.format(context.getString(R.string.im_picture_album_info), new Object[]{name, Integer.valueOf(imageNum)}));
        albumViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IMAlbumAdapter.this.f11196d != null) {
                    for (IMLocalMediaFolder checked : IMAlbumAdapter.this.f11194b) {
                        checked.setChecked(false);
                    }
                    iMLocalMediaFolder.setChecked(true);
                    IMAlbumAdapter.this.notifyDataSetChanged();
                    IMAlbumAdapter.this.f11196d.onAlbumSelect(iMLocalMediaFolder.getName(), iMLocalMediaFolder.getImages());
                }
            }
        });
    }

    public int getItemCount() {
        List<IMLocalMediaFolder> list = this.f11194b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: com.didi.beatles.im.picture.adapter.IMAlbumAdapter$AlbumViewHolder */
    static class AlbumViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public ImageView ivAlbumImage;
        /* access modifiers changed from: private */
        public ImageView ivSelectDot;
        /* access modifiers changed from: private */
        public TextView tvAlbumInfo;

        public AlbumViewHolder(View view) {
            super(view);
            this.ivAlbumImage = (ImageView) view.findViewById(R.id.iv_album_image);
            this.ivSelectDot = (ImageView) view.findViewById(R.id.iv_album_select_dot);
            this.tvAlbumInfo = (TextView) view.findViewById(R.id.tv_album_info);
        }
    }
}
