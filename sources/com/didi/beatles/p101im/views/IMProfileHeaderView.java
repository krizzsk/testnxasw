package com.didi.beatles.p101im.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.adapter.GalleryAdapter;
import com.didi.beatles.p101im.api.entity.IMNewstandResponse;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.views.imageView.IMCircleImageView;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.IMProfileHeaderView */
public class IMProfileHeaderView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f11754a;

    /* renamed from: b */
    private IMCircleImageView f11755b;

    /* renamed from: c */
    private TextView f11756c;

    /* renamed from: d */
    private IMFolderTextView f11757d;

    /* renamed from: e */
    private RecyclerView f11758e;

    /* renamed from: f */
    private TextView f11759f;

    /* renamed from: g */
    private TextView f11760g;

    /* renamed from: h */
    private GalleryAdapter f11761h;

    /* renamed from: i */
    private ImageView f11762i;

    public IMProfileHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11754a = context;
        m10085a();
    }

    public IMProfileHeaderView(Context context) {
        super(context);
        this.f11754a = context;
        m10085a();
    }

    /* renamed from: a */
    private void m10085a() {
        View inflate = inflate(this.f11754a, R.layout.bts_message_profile_header, this);
        this.f11757d = (IMFolderTextView) inflate.findViewById(R.id.expand_text_view);
        this.f11755b = (IMCircleImageView) inflate.findViewById(R.id.user_portrait);
        this.f11756c = (TextView) inflate.findViewById(R.id.user_nick);
        this.f11758e = (RecyclerView) inflate.findViewById(R.id.gallery_list);
        this.f11759f = (TextView) inflate.findViewById(R.id.aciton_title);
        this.f11760g = (TextView) inflate.findViewById(R.id.summy_txt);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.im_chat_mark);
        this.f11762i = imageView;
        imageView.setImageResource(IMResource.getDrawableID(R.drawable.im_chat_user_mark_icon));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f11754a);
        linearLayoutManager.setOrientation(0);
        this.f11758e.setLayoutManager(linearLayoutManager);
    }

    public void bindUserInfo(final IMNewstandResponse.NewStandInfo newStandInfo) {
        if (newStandInfo != null) {
            IMNewstandResponse.NewStandUserInfo newStandUserInfo = newStandInfo.user;
            if (newStandUserInfo != null) {
                this.f11757d.setText(newStandUserInfo.user_info);
                this.f11756c.setText(newStandUserInfo.user_name);
                if (!TextUtils.isEmpty(newStandUserInfo.user_img)) {
                    BtsImageLoader.getInstance().loadInto((Object) newStandUserInfo.user_img, (View) this.f11755b, (int) R.drawable.bts_im_general_default_avatar);
                }
            }
            IMNewstandResponse.NewStandActivity newStandActivity = newStandInfo.activity;
            if (newStandActivity == null) {
                this.f11759f.setVisibility(8);
                this.f11758e.setVisibility(8);
                return;
            }
            if (newStandActivity.type == 1001) {
                this.f11760g.setVisibility(8);
                GalleryAdapter galleryAdapter = new GalleryAdapter(this.f11754a, newStandActivity.info);
                this.f11761h = galleryAdapter;
                this.f11758e.setAdapter(galleryAdapter);
            } else if (newStandActivity.type == 1002) {
                this.f11760g.setText(newStandInfo.activity.info[0].activity_summary);
                this.f11758e.setVisibility(8);
                this.f11760g.setVisibility(0);
            } else if (newStandActivity.type == 1003) {
                this.f11760g.setVisibility(8);
                this.f11758e.setVisibility(8);
            }
            if (newStandActivity.info == null || newStandActivity.info.length == 0) {
                this.f11758e.setVisibility(8);
            }
            if (TextUtils.isEmpty(newStandInfo.activity.title_url)) {
                this.f11759f.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.f11759f.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        IMCommonUtil.startUriActivity(IMProfileHeaderView.this.f11754a, newStandInfo.activity.title_url);
                    }
                });
            }
            this.f11759f.setText(newStandActivity.title);
        }
    }
}
