package com.didi.beatles.p101im.picture.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.picture.adapter.IMAlbumAdapter;
import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import com.didi.beatles.p101im.picture.entity.IMLocalMediaFolder;
import com.didi.beatles.p101im.picture.utils.IMStringUtils;
import com.didi.beatles.p101im.views.IMDividerItemDecoration;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.picture.widget.IMAlbumPopupWindow */
public class IMAlbumPopupWindow extends PopupWindow implements View.OnClickListener {

    /* renamed from: a */
    private Context f11292a;

    /* renamed from: b */
    private View f11293b;

    /* renamed from: c */
    private RecyclerView f11294c;

    /* renamed from: d */
    private IMAlbumAdapter f11295d;

    /* renamed from: e */
    private Animation f11296e;

    /* renamed from: f */
    private Animation f11297f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f11298g = false;

    /* renamed from: h */
    private LinearLayout f11299h;

    /* renamed from: i */
    private TextView f11300i;

    /* renamed from: j */
    private Drawable f11301j;

    /* renamed from: k */
    private Drawable f11302k;

    /* renamed from: l */
    private int f11303l;

    public IMAlbumPopupWindow(Context context, int i) {
        this.f11292a = context;
        this.f11303l = i;
        View inflate = LayoutInflater.from(context).inflate(R.layout.im_picture_album_popup, (ViewGroup) null);
        this.f11293b = inflate;
        setContentView(inflate);
        setWidth(-1);
        setHeight(-1);
        setAnimationStyle(R.style.IMAlbumPopup);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        setBackgroundDrawable(new ColorDrawable(Color.argb(123, 0, 0, 0)));
        this.f11301j = context.getResources().getDrawable(R.drawable.im_picture_ic_arrow_up);
        this.f11302k = context.getResources().getDrawable(R.drawable.im_picture_ic_arrow_down);
        this.f11296e = AnimationUtils.loadAnimation(context, R.anim.im_picture_album_show);
        this.f11297f = AnimationUtils.loadAnimation(context, R.anim.im_picture_album_dismiss);
        initView();
    }

    public void initView() {
        this.f11299h = (LinearLayout) this.f11293b.findViewById(R.id.ll_album_container);
        this.f11295d = new IMAlbumAdapter(this.f11292a);
        RecyclerView recyclerView = (RecyclerView) this.f11293b.findViewById(R.id.rv_im_album);
        this.f11294c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f11292a));
        RecyclerView recyclerView2 = this.f11294c;
        Context context = this.f11292a;
        recyclerView2.addItemDecoration(new IMDividerItemDecoration(context, 0, 1, context.getResources().getColor(R.color.white)));
        this.f11294c.setAdapter(this.f11295d);
        this.f11299h.setOnClickListener(this);
    }

    public void bindFolder(List<IMLocalMediaFolder> list) {
        this.f11295d.setMimeType(this.f11303l);
        this.f11295d.bindAlbumData(list);
    }

    public void setPictureTitleView(TextView textView) {
        this.f11300i = textView;
    }

    public void showAsDropDown(View view) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                setHeight(view.getResources().getDisplayMetrics().heightPixels - rect.bottom);
            }
            super.showAsDropDown(view);
            this.f11298g = false;
            this.f11294c.startAnimation(this.f11296e);
            IMStringUtils.modifyTextViewDrawable(this.f11300i, this.f11301j, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnAlbumSelectListener(IMAlbumAdapter.OnAlbumSelectListener onAlbumSelectListener) {
        this.f11295d.setOnAlbumSelectListener(onAlbumSelectListener);
    }

    public void dismiss() {
        if (!this.f11298g) {
            IMStringUtils.modifyTextViewDrawable(this.f11300i, this.f11302k, 2);
            this.f11298g = true;
            this.f11294c.startAnimation(this.f11297f);
            dismiss();
            this.f11297f.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    boolean unused = IMAlbumPopupWindow.this.f11298g = false;
                    if (Build.VERSION.SDK_INT <= 16) {
                        IMAlbumPopupWindow.this.m9809a();
                    } else {
                        IMAlbumPopupWindow.super.dismiss();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9809a() {
        new Handler().post(new Runnable() {
            public void run() {
                IMAlbumPopupWindow.super.dismiss();
            }
        });
    }

    public void notifyDataCheckedStatus(List<IMLocalMedia> list) {
        try {
            List<IMLocalMediaFolder> folderData = this.f11295d.getFolderData();
            for (IMLocalMediaFolder checkedNum : folderData) {
                checkedNum.setCheckedNum(0);
            }
            if (list.size() > 0) {
                for (IMLocalMediaFolder next : folderData) {
                    int i = 0;
                    for (IMLocalMedia path : next.getImages()) {
                        String path2 = path.getPath();
                        for (IMLocalMedia path3 : list) {
                            if (path2.equals(path3.getPath())) {
                                i++;
                                next.setCheckedNum(i);
                            }
                        }
                    }
                }
            }
            this.f11295d.bindAlbumData(folderData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.ll_album_container) {
            dismiss();
        }
    }
}
