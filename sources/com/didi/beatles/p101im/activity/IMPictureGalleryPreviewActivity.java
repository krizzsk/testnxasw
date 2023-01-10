package com.didi.beatles.p101im.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.picture.adapter.IMPicturePreviewFragmentAdapter;
import com.didi.beatles.p101im.picture.anim.IMOptAnimationLoader;
import com.didi.beatles.p101im.picture.config.IMPictureConfig;
import com.didi.beatles.p101im.picture.entity.IMEventEntity;
import com.didi.beatles.p101im.picture.entity.IMLocalMedia;
import com.didi.beatles.p101im.picture.observable.IMMediaObservable;
import com.didi.beatles.p101im.utils.IMScreenUtil;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.beatles.p101im.views.widget.IMViewPager;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* renamed from: com.didi.beatles.im.activity.IMPictureGalleryPreviewActivity */
public class IMPictureGalleryPreviewActivity extends IMPictureBaseActivity implements View.OnClickListener, Animation.AnimationListener, IMPicturePreviewFragmentAdapter.OnCallBackActivity {

    /* renamed from: a */
    private ImageView f10829a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f10830b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMViewPager f10831c;

    /* renamed from: d */
    private FrameLayout f10832d;

    /* renamed from: e */
    private TextView f10833e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f10834f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<IMLocalMedia> f10835g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<IMLocalMedia> f10836h = new ArrayList();

    /* renamed from: i */
    private IMPicturePreviewFragmentAdapter f10837i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Animation f10838j;

    /* renamed from: k */
    private boolean f10839k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f10840l;

    /* renamed from: m */
    private int f10841m;

    /* renamed from: n */
    private Handler f10842n;

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    public static void startActivity(Context context, List<IMLocalMedia> list, int i) {
        Intent intent = new Intent(context, IMPictureGalleryPreviewActivity.class);
        Bundle bundle = new Bundle();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        bundle.putSerializable(IMPictureConfig.EXTRA_SELECT_LIST, (Serializable) list);
        bundle.putInt("position", i);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, List<IMLocalMedia> list, List<IMLocalMedia> list2, boolean z) {
        Intent intent = new Intent(context, IMPictureGalleryPreviewActivity.class);
        Bundle bundle = new Bundle();
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        bundle.putSerializable(IMPictureConfig.EXTRA_PREVIEW_SELECT_LIST, (Serializable) list);
        bundle.putSerializable(IMPictureConfig.EXTRA_SELECT_LIST, (Serializable) list2);
        bundle.putBoolean(IMPictureConfig.EXTRA_BOTTOM_PREVIEW, z);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityCreate(Bundle bundle) {
        super.onActivityCreate(bundle);
        setContentView((int) R.layout.activity_im_picture_gallery_preview);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        this.f10842n = new Handler();
        this.f10841m = IMScreenUtil.instance(this).getScreenWidth();
        Animation loadAnimation = IMOptAnimationLoader.loadAnimation(this, R.anim.im_picture_modal_in);
        this.f10838j = loadAnimation;
        loadAnimation.setAnimationListener(this);
        this.f10829a = (ImageView) findViewById(R.id.common_title_bar_left_img);
        this.f10830b = (TextView) findViewById(R.id.tv_preview_select);
        this.f10831c = (IMViewPager) findViewById(R.id.preview_pager);
        this.f10832d = (FrameLayout) findViewById(R.id.fl_bottom_bar);
        this.f10833e = (TextView) findViewById(R.id.tv_send_image);
        this.f10829a.setOnClickListener(this);
        this.f10833e.setOnClickListener(this);
        this.f10834f = getIntent().getIntExtra("position", 0);
        this.f10836h = (List) getIntent().getSerializableExtra(IMPictureConfig.EXTRA_SELECT_LIST);
        if (getIntent().getBooleanExtra(IMPictureConfig.EXTRA_BOTTOM_PREVIEW, false)) {
            this.f10835g = (List) getIntent().getSerializableExtra(IMPictureConfig.EXTRA_PREVIEW_SELECT_LIST);
        } else {
            this.f10835g = IMMediaObservable.getInstance().readLocalMedias();
        }
        m9496c();
        this.f10830b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean z;
                AutoTrackHelper.trackViewOnClick(view);
                if (IMPictureGalleryPreviewActivity.this.f10835g != null && IMPictureGalleryPreviewActivity.this.f10835g.size() > 0) {
                    IMLocalMedia iMLocalMedia = (IMLocalMedia) IMPictureGalleryPreviewActivity.this.f10835g.get(IMPictureGalleryPreviewActivity.this.f10831c.getCurrentItem());
                    if (!IMPictureGalleryPreviewActivity.this.f10830b.isSelected()) {
                        IMPictureGalleryPreviewActivity.this.f10830b.setSelected(true);
                        IMPictureGalleryPreviewActivity.this.f10830b.startAnimation(IMPictureGalleryPreviewActivity.this.f10838j);
                        z = true;
                    } else {
                        IMPictureGalleryPreviewActivity.this.f10830b.setSelected(false);
                        z = false;
                    }
                    if (IMPictureGalleryPreviewActivity.this.f10836h.size() < IMPictureGalleryPreviewActivity.this.config.maxSelectNum || !z) {
                        if (!z) {
                            Iterator it = IMPictureGalleryPreviewActivity.this.f10836h.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                IMLocalMedia iMLocalMedia2 = (IMLocalMedia) it.next();
                                if (iMLocalMedia2.getPath().equals(iMLocalMedia.getPath())) {
                                    IMPictureGalleryPreviewActivity.this.f10836h.remove(iMLocalMedia2);
                                    IMPictureGalleryPreviewActivity.this.m9498d();
                                    IMPictureGalleryPreviewActivity.this.m9489a(iMLocalMedia2);
                                    break;
                                }
                            }
                        } else {
                            if (IMPictureGalleryPreviewActivity.this.config.selectionMode == 1) {
                                IMPictureGalleryPreviewActivity.this.m9494b();
                            }
                            IMPictureGalleryPreviewActivity.this.f10836h.add(iMLocalMedia);
                            iMLocalMedia.setNum(IMPictureGalleryPreviewActivity.this.f10836h.size());
                            IMPictureGalleryPreviewActivity.this.f10830b.setText(String.valueOf(iMLocalMedia.getNum()));
                        }
                        IMPictureGalleryPreviewActivity.this.onSelectNumChange(true);
                        return;
                    }
                    Context context = IMPictureGalleryPreviewActivity.this.mContext;
                    IMPictureGalleryPreviewActivity iMPictureGalleryPreviewActivity = IMPictureGalleryPreviewActivity.this;
                    SystemUtils.showToast(IMTipsToast.makeText(context, (CharSequence) iMPictureGalleryPreviewActivity.getString(R.string.im_picture_message_max_num, new Object[]{Integer.valueOf(iMPictureGalleryPreviewActivity.config.maxSelectNum)}), 0));
                    IMPictureGalleryPreviewActivity.this.f10830b.setSelected(false);
                }
            }
        });
        this.f10831c.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
                IMPictureGalleryPreviewActivity iMPictureGalleryPreviewActivity = IMPictureGalleryPreviewActivity.this;
                iMPictureGalleryPreviewActivity.m9491a(iMPictureGalleryPreviewActivity.config.previewEggs, i, i2);
            }

            public void onPageSelected(int i) {
                int unused = IMPictureGalleryPreviewActivity.this.f10834f = i;
                IMLocalMedia iMLocalMedia = (IMLocalMedia) IMPictureGalleryPreviewActivity.this.f10835g.get(IMPictureGalleryPreviewActivity.this.f10834f);
                int unused2 = IMPictureGalleryPreviewActivity.this.f10840l = iMLocalMedia.getPosition();
                if (!IMPictureGalleryPreviewActivity.this.config.previewEggs) {
                    TextView c = IMPictureGalleryPreviewActivity.this.f10830b;
                    c.setText(iMLocalMedia.getNum() + "");
                    IMPictureGalleryPreviewActivity.this.m9489a(iMLocalMedia);
                    IMPictureGalleryPreviewActivity iMPictureGalleryPreviewActivity = IMPictureGalleryPreviewActivity.this;
                    iMPictureGalleryPreviewActivity.onImageChecked(iMPictureGalleryPreviewActivity.f10834f);
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(IMEventEntity iMEventEntity) {
        if (iMEventEntity.what == 2770) {
            this.f10842n.postDelayed(new Runnable() {
                public void run() {
                    IMPictureGalleryPreviewActivity.this.onBackPressed();
                }
            }, 150);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9491a(boolean z, int i, int i2) {
        List<IMLocalMedia> list;
        if (z && this.f10835g.size() > 0 && (list = this.f10835g) != null) {
            if (i2 < this.f10841m / 2) {
                IMLocalMedia iMLocalMedia = list.get(i);
                this.f10830b.setSelected(isSelected(iMLocalMedia));
                int num = iMLocalMedia.getNum();
                TextView textView = this.f10830b;
                textView.setText(num + "");
                m9489a(iMLocalMedia);
                onImageChecked(i);
                return;
            }
            int i3 = i + 1;
            IMLocalMedia iMLocalMedia2 = list.get(i3);
            this.f10830b.setSelected(isSelected(iMLocalMedia2));
            int num2 = iMLocalMedia2.getNum();
            TextView textView2 = this.f10830b;
            textView2.setText(num2 + "");
            m9489a(iMLocalMedia2);
            onImageChecked(i3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9494b() {
        List<IMLocalMedia> list = this.f10836h;
        if (list != null && list.size() > 0) {
            EventBus.getDefault().post(new IMEventEntity(2774, this.f10836h.get(0).getPosition(), this.f10836h));
            this.f10836h.clear();
        }
    }

    /* renamed from: c */
    private void m9496c() {
        IMPicturePreviewFragmentAdapter iMPicturePreviewFragmentAdapter = new IMPicturePreviewFragmentAdapter(this.f10835g, this, this);
        this.f10837i = iMPicturePreviewFragmentAdapter;
        this.f10831c.setAdapter(iMPicturePreviewFragmentAdapter);
        this.f10831c.setCurrentItem(this.f10834f);
        onSelectNumChange(false);
        onImageChecked(this.f10834f);
        if (this.f10835g.size() > 0) {
            IMLocalMedia iMLocalMedia = this.f10835g.get(this.f10834f);
            this.f10840l = iMLocalMedia.getPosition();
            TextView textView = this.f10830b;
            textView.setText(iMLocalMedia.getNum() + "");
            m9489a(iMLocalMedia);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9489a(IMLocalMedia iMLocalMedia) {
        this.f10830b.setText("");
        for (IMLocalMedia next : this.f10836h) {
            if (next.getPath().equals(iMLocalMedia.getPath())) {
                iMLocalMedia.setNum(next.getNum());
                this.f10830b.setText(String.valueOf(iMLocalMedia.getNum()));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m9498d() {
        int size = this.f10836h.size();
        int i = 0;
        while (i < size) {
            i++;
            this.f10836h.get(i).setNum(i);
        }
    }

    public void onImageChecked(int i) {
        List<IMLocalMedia> list = this.f10835g;
        if (list == null || list.size() <= 0) {
            this.f10830b.setSelected(false);
        } else {
            this.f10830b.setSelected(isSelected(this.f10835g.get(i)));
        }
    }

    public boolean isSelected(IMLocalMedia iMLocalMedia) {
        for (IMLocalMedia path : this.f10836h) {
            if (path.getPath().equals(iMLocalMedia.getPath())) {
                return true;
            }
        }
        return false;
    }

    public void onSelectNumChange(boolean z) {
        this.f10839k = z;
        if (this.f10836h.size() > 0) {
            this.f10833e.setEnabled(true);
            this.f10833e.setAlpha(1.0f);
            this.f10833e.setText(String.format(getString(R.string.im_picture_send_with_count), new Object[]{Integer.valueOf(this.f10836h.size())}));
        } else {
            this.f10833e.setEnabled(false);
            this.f10833e.setText(String.format(getString(R.string.im_picture_send), new Object[0]));
            this.f10833e.setAlpha(0.5f);
        }
        m9490a(this.f10839k);
    }

    /* renamed from: a */
    private void m9490a(boolean z) {
        if (z) {
            EventBus.getDefault().post(new IMEventEntity(2774, this.f10840l, this.f10836h));
        }
    }

    public void onAnimationEnd(Animation animation) {
        m9490a(this.f10839k);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.common_title_bar_left_img) {
            onBackPressed();
        }
        if (id == R.id.tv_send_image) {
            int size = this.f10836h.size();
            if (this.f10836h.size() > 0) {
                IMLocalMedia iMLocalMedia = this.f10836h.get(0);
            }
            if (this.config.minSelectNum <= 0 || size >= this.config.minSelectNum || this.config.selectionMode != 2) {
                onResult(this.f10836h);
                return;
            }
            SystemUtils.showToast(IMTipsToast.makeText(this.mContext, (CharSequence) getString(R.string.im_picture_min_img_num, new Object[]{Integer.valueOf(this.config.minSelectNum)}), 0));
        }
    }

    public void onResult(List<IMLocalMedia> list) {
        EventBus.getDefault().post(new IMEventEntity(2771, list));
        if (!this.config.isCompress) {
            onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        Handler handler = this.f10842n;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f10842n = null;
        }
        Animation animation = this.f10838j;
        if (animation != null) {
            animation.cancel();
            this.f10838j = null;
        }
    }

    public void onActivityBackPressed() {
        onBackPressed();
    }
}
