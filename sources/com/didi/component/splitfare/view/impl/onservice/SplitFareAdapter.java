package com.didi.component.splitfare.view.impl.onservice;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.UIUtils;
import com.didi.component.splitfare.model.SplitFareManager;
import com.didi.component.splitfare.presenter.impl.SplitFareOnServicePresenter;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.sidebar.component.GlideRoundTransform;
import com.didi.travel.psnger.core.model.response.DTSDKSplitFareInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SplitFareAdapter extends RecyclerView.Adapter<BaseVH> {
    public static int EXT_TYPE_ACTION = 1;
    public static int EXT_TYPE_USER = 0;

    /* renamed from: a */
    private static final int f17891a = 0;

    /* renamed from: b */
    private static final int f17892b = 1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final boolean f17893c;

    /* renamed from: d */
    private List<Object> f17894d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SplitFareOnServicePresenter f17895e;

    public SplitFareAdapter(boolean z) {
        this.f17893c = z;
    }

    public BaseVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new BaseVH(LayoutInflater.from(viewGroup.getContext()).inflate(i == 0 ? R.layout.comp_sf_item_user : R.layout.comp_sf_item_padding, viewGroup, false), i);
    }

    public void onBindViewHolder(BaseVH baseVH, int i) {
        baseVH.bind(this.f17894d.get(i));
    }

    public int getItemCount() {
        return this.f17894d.size();
    }

    public void setPresenter(SplitFareOnServicePresenter splitFareOnServicePresenter) {
        this.f17895e = splitFareOnServicePresenter;
    }

    public void update(List<DTSDKSplitFareInfo.SplitUser> list, int i, int i2) {
        double d;
        this.f17894d.clear();
        if (i <= 0 || i2 <= 0 || list.size() <= 1) {
            this.f17894d.addAll(list);
        } else {
            double d2 = i2 > 4 ? 4.5d : 4.0d;
            double d3 = (double) i;
            double dip2pxInt = (double) UIUtils.dip2pxInt(DIDIApplicationDelegate.getAppContext(), 80.0f);
            double d4 = d3 - (d2 * dip2pxInt);
            if (d4 >= 0.0d) {
                d = d4 / ((double) (list.size() - 1));
            } else {
                d = (d3 - (dip2pxInt * 3.5d)) / ((double) (list.size() - 1));
            }
            int floor = (int) Math.floor(d);
            if (floor > 0) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (i3 != 0) {
                        this.f17894d.add(Integer.valueOf(floor));
                    }
                    this.f17894d.add(list.get(i3));
                }
            } else {
                this.f17894d.addAll(list);
            }
        }
        notifyDataSetChanged();
    }

    public int getItemViewType(int i) {
        return (this.f17894d.get(i) instanceof DTSDKSplitFareInfo.SplitUser) ^ true ? 1 : 0;
    }

    class BaseVH extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView name;
        View paddingView;
        ImageView statusIcon;
        int viewType;

        public BaseVH(View view, int i) {
            super(view);
            this.viewType = i;
            if (i == 0) {
                this.avatar = (ImageView) view.findViewById(R.id.iv_avatar);
                this.name = (TextView) view.findViewById(R.id.tv_name);
                this.statusIcon = (ImageView) view.findViewById(R.id.iv_status);
                if (SplitFareAdapter.this.f17893c) {
                    view.setOnClickListener(new View.OnClickListener(SplitFareAdapter.this) {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (view.getTag() instanceof DTSDKSplitFareInfo.SplitUser) {
                                SplitFareAdapter.this.f17895e.onItemClicked((DTSDKSplitFareInfo.SplitUser) view.getTag());
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.paddingView = view.findViewById(R.id.padding);
        }

        public void bind(Object obj) {
            if (obj instanceof DTSDKSplitFareInfo.SplitUser) {
                DTSDKSplitFareInfo.SplitUser splitUser = (DTSDKSplitFareInfo.SplitUser) obj;
                this.itemView.setTag(splitUser);
                String str = splitUser.avatar_url;
                if (!TextUtils.isEmpty(str)) {
                    Context context = this.itemView.getContext();
                    ((RequestBuilder) ((RequestBuilder) Glide.with(context).asBitmap().load(str).placeholder((int) R.drawable.comp_sf_user_default)).transform((Transformation<Bitmap>) new GlideRoundTransform(context, 42))).into(this.avatar);
                } else if (splitUser._extType == SplitFareAdapter.EXT_TYPE_USER) {
                    this.avatar.setImageResource(R.drawable.comp_sf_user_default);
                } else {
                    this.avatar.setImageResource(R.drawable.comp_sf_add);
                }
                int i = splitUser.status;
                if (!SplitFareAdapter.this.f17893c) {
                    this.statusIcon.setVisibility(8);
                } else if (SplitFareManager.isSplitFareOwner(splitUser) || SplitFareManager.isMe(splitUser)) {
                    this.statusIcon.setVisibility(8);
                } else if (i == 2) {
                    this.statusIcon.setImageResource(R.drawable.comp_sf_reject);
                    this.statusIcon.setVisibility(0);
                } else if (i == 1) {
                    this.statusIcon.setImageResource(R.drawable.comp_sf_accept);
                    this.statusIcon.setVisibility(0);
                } else {
                    this.statusIcon.setVisibility(8);
                }
                this.name.setText(splitUser.nick);
            } else if (obj instanceof Integer) {
                ViewGroup.LayoutParams layoutParams = this.paddingView.getLayoutParams();
                layoutParams.width = ((Integer) obj).intValue();
                this.paddingView.setLayoutParams(layoutParams);
            }
        }
    }
}
