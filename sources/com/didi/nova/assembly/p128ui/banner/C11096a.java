package com.didi.nova.assembly.p128ui.banner;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.app.nova.skeleton.image.Fly;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.nova.assembly.ui.banner.a */
/* compiled from: BannerPagerAdapter */
class C11096a extends PagerAdapter {

    /* renamed from: a */
    public int f31704a;

    /* renamed from: b */
    public FitType f31705b = FitType.FIT_None;

    /* renamed from: c */
    private List<String> f31706c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final WeakReference<Banner> f31707d;

    /* renamed from: e */
    private boolean f31708e;

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public C11096a(Banner banner, List<String> list, boolean z) {
        this.f31708e = z;
        m24240b(list);
        this.f31707d = new WeakReference<>(banner);
    }

    public int getCount() {
        return this.f31706c.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        viewGroup.addView(imageView);
        Fly.with(viewGroup.getContext()).load(this.f31705b, this.f31706c.get(i)).placeholder(this.f31704a).error(this.f31704a).centerCrop().into(imageView);
        imageView.setOnClickListener(new BannerPagerAdapter$1(this, i));
        return imageView;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    /* renamed from: a */
    public void mo86160a(List<String> list) {
        m24240b(list);
    }

    /* renamed from: b */
    private void m24240b(List<String> list) {
        this.f31706c.clear();
        int size = list.size();
        if (size <= 1 || !this.f31708e) {
            this.f31706c.addAll(list);
            return;
        }
        this.f31706c.add(list.get(size - 1));
        this.f31706c.addAll(list);
        this.f31706c.add(list.get(0));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m24239b(int i) {
        if (!this.f31708e) {
            return i;
        }
        if (this.f31706c.size() <= 1) {
            return 0;
        }
        int size = this.f31706c.size() - 2;
        return ((i + size) - 1) % size;
    }

    /* renamed from: a */
    public void mo86159a(int i) {
        this.f31704a = i;
    }

    /* renamed from: a */
    private boolean m24238a(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().endsWith(".gif");
    }
}
