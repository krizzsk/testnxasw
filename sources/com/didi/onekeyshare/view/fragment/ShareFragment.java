package com.didi.onekeyshare.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onekeyshare.ShareConfig;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.ShareInstrInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.track.OmegaTrack;
import com.didi.onekeyshare.util.ShareConvertCompat;
import com.didi.onekeyshare.view.ShareInstructView;
import com.didi.onekeyshare.view.fragment.ShareFragmentView;
import com.didi.onekeyshare.wrapper.ShareWrapper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareFragment extends DialogFragment implements ShareFragmentView.IShareListener {

    /* renamed from: a */
    private int f32269a = 8;

    /* renamed from: b */
    private int f32270b = 16;

    /* renamed from: c */
    private int f32271c = 24;

    /* renamed from: d */
    private ViewPager f32272d;

    /* renamed from: e */
    private ArrayList<View> f32273e;

    /* renamed from: f */
    private ViewGroup f32274f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ImageView[] f32275g;

    /* renamed from: h */
    private ImageView f32276h;

    /* renamed from: i */
    private ShareInstructView f32277i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ICallback f32278j;

    /* renamed from: k */
    private View f32279k;

    /* renamed from: l */
    private ImageView f32280l;

    /* renamed from: m */
    private String f32281m;

    /* renamed from: n */
    private boolean f32282n;

    /* renamed from: o */
    private ICallback.IPlatformClickCallback f32283o;

    public int getInflateId() {
        return -1;
    }

    public void initViews(View view) {
    }

    public static ShareFragment newInstance(ShareInfo shareInfo) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ShareInfo", shareInfo);
        ShareFragment shareFragment = new ShareFragment();
        shareFragment.setArguments(bundle);
        return shareFragment;
    }

    public static ShareFragment newInstance(ArrayList<OneKeyShareInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ShareList", arrayList);
        ShareFragment shareFragment = new ShareFragment();
        shareFragment.setArguments(bundle);
        return shareFragment;
    }

    public static ShareFragment newInstance(ShareInfo shareInfo, ShareInstrInfo shareInstrInfo) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ShareInfo", shareInfo);
        bundle.putSerializable("ShareInstrInfo", shareInstrInfo);
        ShareFragment shareFragment = new ShareFragment();
        shareFragment.setArguments(bundle);
        return shareFragment;
    }

    public static ShareFragment newInstance(ShareInfo shareInfo, ShareInstrInfo shareInstrInfo, int i) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ShareInfo", shareInfo);
        bundle.putSerializable("ShareInstrInfo", shareInstrInfo);
        ShareFragment shareFragment = new ShareFragment();
        shareFragment.setArguments(bundle);
        return shareFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT <= 20) {
            setStyle(2, R.style.DialogWithoutTopLine);
        } else {
            setStyle(0, R.style.DialogWithoutTopLine);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        try {
            view = layoutInflater.inflate(getInflateId() >= 0 ? getInflateId() : R.layout.f_share_dialog, viewGroup);
        } catch (Exception unused) {
            view = layoutInflater.inflate(R.layout.f_share_dialog, viewGroup);
        }
        this.f32277i = (ShareInstructView) view.findViewById(R.id.share_instr_view);
        this.f32272d = (ViewPager) view.findViewById(R.id.view_pager);
        this.f32274f = (ViewGroup) view.findViewById(R.id.layout_dot);
        this.f32279k = view.findViewById(R.id.btn_cancel);
        this.f32280l = (ImageView) view.findViewById(R.id.share_big_image);
        this.f32279k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ShareFragment.this.dismissAllowingStateLoss();
                if (ShareFragment.this.f32278j != null && (ShareFragment.this.f32278j instanceof ICallback.IPlatformShareCallback)) {
                    ((ICallback.IPlatformShareCallback) ShareFragment.this.f32278j).onCancel(SharePlatform.REFRESH_ICON);
                }
                OmegaTrack.trackCancelClick("1");
            }
        });
        if (getResources().getConfiguration().orientation == 2) {
            this.f32269a = 12;
            this.f32270b = 24;
            this.f32271c = 36;
            this.f32282n = true;
        } else {
            this.f32269a = 8;
            this.f32270b = 16;
            this.f32271c = 24;
            this.f32282n = false;
        }
        initViews(view);
        m24527c();
        m24525b();
        m24524a();
        SystemUtils.log(6, "SHARE", "NEW SHARE", (Throwable) null, "com.didi.onekeyshare.view.fragment.ShareFragment", 161);
        return view;
    }

    /* renamed from: a */
    private void m24524a() {
        if (this.f32281m != null) {
            this.f32280l.setVisibility(0);
            Glide.with(getContext()).load(new File(this.f32281m)).into(this.f32280l);
        }
    }

    /* renamed from: b */
    private void m24525b() {
        ShareInstrInfo shareInstrInfo = (ShareInstrInfo) getArguments().getSerializable("ShareInstrInfo");
        if (shareInstrInfo == null) {
            this.f32277i.setVisibility(8);
        } else {
            this.f32277i.setVisibility(0);
        }
        this.f32277i.setData(shareInstrInfo);
    }

    /* renamed from: c */
    private void m24527c() {
        List list;
        double d;
        OneKeyShareInfo oneKeyShareInfo;
        this.f32273e = new ArrayList<>();
        ShareInfo shareInfo = (ShareInfo) getArguments().getSerializable("ShareInfo");
        if (shareInfo == null) {
            list = (ArrayList) getArguments().getSerializable("ShareList");
        } else {
            list = ShareConvertCompat.convert(shareInfo);
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            OneKeyShareInfo oneKeyShareInfo2 = (OneKeyShareInfo) it.next();
            if (oneKeyShareInfo2.platform == SharePlatform.REFRESH_ICON) {
                OmegaTrack.trackRefreshShow();
                break;
            } else if (this.f32281m == null && oneKeyShareInfo2.extra != null && oneKeyShareInfo2.extra.containsKey("big_image")) {
                this.f32281m = oneKeyShareInfo2.extra.get("big_image");
            }
        }
        if (!(list == null || list.size() <= 0 || (oneKeyShareInfo = (OneKeyShareInfo) list.get(0)) == null)) {
            OmegaTrack.trackShareShow(list, oneKeyShareInfo.extra);
        }
        if (this.f32282n) {
            this.f32269a = 16;
            d = Math.ceil((double) (((float) list.size()) / 16.0f));
        } else {
            d = Math.ceil((double) (((float) list.size()) / 8.0f));
        }
        int i = (int) d;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f32269a;
            int i4 = i2 * i3;
            List subList = list.subList(i4, i3 + i4 > list.size() ? list.size() : this.f32269a + i4);
            ShareFragmentView shareFragmentView = new ShareFragmentView((Context) getActivity(), this.f32282n, i2);
            shareFragmentView.setShareInfo(subList);
            shareFragmentView.setShareListener(this);
            this.f32273e.add(shareFragmentView);
        }
        if (this.f32273e.size() > 1) {
            this.f32275g = new ImageView[this.f32273e.size()];
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(15, 0, 0, 0);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(layoutParams.leftMargin);
            }
            for (int i5 = 0; i5 < this.f32273e.size(); i5++) {
                ImageView imageView = new ImageView(getActivity());
                this.f32276h = imageView;
                imageView.setLayoutParams(new LinearLayout.LayoutParams(5, 5));
                this.f32276h.setScaleType(ImageView.ScaleType.CENTER);
                if (i5 == 0) {
                    this.f32276h.setBackgroundResource(R.drawable.tone_share_dot_orange);
                } else {
                    this.f32276h.setBackgroundResource(R.drawable.tone_share_dot_gray);
                }
                ImageView[] imageViewArr = this.f32275g;
                imageViewArr[i5] = this.f32276h;
                this.f32274f.addView(imageViewArr[i5], layoutParams);
            }
            this.f32272d.setOnPageChangeListener(new SharePageChangeListener());
            OmegaTrack.trackSlideShow();
        }
        this.f32272d.setAdapter(new ShareViewAdapter(this.f32273e));
    }

    public void setSharePlatformClickCallBack(ICallback.IPlatformClickCallback iPlatformClickCallback) {
        this.f32283o = iPlatformClickCallback;
    }

    public void setPlatformClickListener(final PlatformClickListener platformClickListener) {
        this.f32283o = new ICallback.IPlatformClickCallback() {
            public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
                if (platformClickListener != null && oneKeyShareInfo != null && oneKeyShareInfo.platform != null) {
                    platformClickListener.onClick(oneKeyShareInfo.platform);
                }
            }
        };
    }

    private class SharePageChangeListener implements ViewPager.OnPageChangeListener {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        private SharePageChangeListener() {
        }

        public void onPageSelected(int i) {
            for (int i2 = 0; i2 < ShareFragment.this.f32275g.length; i2++) {
                ShareFragment.this.f32275g[i].setBackgroundResource(R.drawable.tone_share_dot_orange);
                if (i != i2) {
                    ShareFragment.this.f32275g[i2].setBackgroundResource(R.drawable.tone_share_dot_gray);
                }
            }
        }
    }

    public class ShareViewAdapter extends PagerAdapter {
        private final ArrayList<View> list;

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public ShareViewAdapter(ArrayList<View> arrayList) {
            this.list = arrayList;
        }

        public int getCount() {
            return this.list.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.list.get(i);
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeAllViews();
            }
            viewGroup.addView(view);
            return view;
        }

        public Object instantiateItem(View view, int i) {
            ((ViewPager) view).addView(this.list.get(i));
            return this.list.get(i);
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.list.get(i));
        }
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        ShareConfig config = ShareConfig.getConfig();
        if (config.getFragmentListener() != null) {
            config.getFragmentListener().onDismiss(getActivity());
        }
    }

    public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
        dismissAllowingStateLoss();
        ICallback.IPlatformClickCallback iPlatformClickCallback = this.f32283o;
        if (iPlatformClickCallback != null) {
            iPlatformClickCallback.onClickPlatform(oneKeyShareInfo);
        }
        share(oneKeyShareInfo);
    }

    public int show(FragmentTransaction fragmentTransaction, String str) {
        return super.show(fragmentTransaction, str);
    }

    public void onCancel() {
        dismissAllowingStateLoss();
    }

    /* access modifiers changed from: protected */
    public void share(OneKeyShareInfo oneKeyShareInfo) {
        if (oneKeyShareInfo != null && oneKeyShareInfo.platform != null && oneKeyShareInfo.platform != SharePlatform.UNKNOWN) {
            if (oneKeyShareInfo.platform == SharePlatform.REFRESH_ICON) {
                ICallback iCallback = this.f32278j;
                if (iCallback != null && (iCallback instanceof ICallback.IH5ShareCallback)) {
                    ((ICallback.IH5ShareCallback) iCallback).onRefresh();
                    OmegaTrack.trackRefreshClick();
                }
                dismissAllowingStateLoss();
                return;
            }
            OmegaTrack.trackShareChannelClick(oneKeyShareInfo.platform.platformName(), oneKeyShareInfo.extra);
            ShareWrapper.shareToPlatform(getActivity(), oneKeyShareInfo, new ICallback.IPlatformShareCallback2() {
                public void onError(SharePlatform sharePlatform, int i) {
                    if (ShareFragment.this.f32278j != null && (ShareFragment.this.f32278j instanceof ICallback.IPlatformShareCallback2)) {
                        ((ICallback.IPlatformShareCallback2) ShareFragment.this.f32278j).onError(sharePlatform, i);
                    }
                }

                public void onComplete(SharePlatform sharePlatform) {
                    if (ShareFragment.this.f32278j != null) {
                        ((ICallback.IPlatformShareCallback) ShareFragment.this.f32278j).onComplete(sharePlatform);
                    }
                }

                public void onError(SharePlatform sharePlatform) {
                    if (ShareFragment.this.f32278j != null) {
                        ((ICallback.IPlatformShareCallback) ShareFragment.this.f32278j).onError(sharePlatform);
                    }
                }

                public void onCancel(SharePlatform sharePlatform) {
                    if (ShareFragment.this.f32278j != null) {
                        ((ICallback.IPlatformShareCallback) ShareFragment.this.f32278j).onCancel(sharePlatform);
                    }
                }
            });
        }
    }

    public void setShareCallBack(ICallback iCallback) {
        this.f32278j = iCallback;
    }

    public void dismissTrack() {
        OmegaTrack.trackCancelClick("2");
        dismissAllowingStateLoss();
    }
}
