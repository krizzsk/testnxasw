package com.didi.global.loading.render;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import java.util.ArrayList;
import java.util.Iterator;

public class LottieLoadingRender extends BaseLoadingRender {
    public static final String kAnimatorAssetFileName = "Loading::Animation::Lottie::Asset::File::Name";
    public static final String kAnimatorAssetImagesPath = "Loading::Animation::Lottie::Asset::Images::Path";
    public static final String kAnimatorLoopRanges = "Loading::Animation::Lottie::LoopRanges";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LottieAnimationView f24594b;

    /* renamed from: c */
    private int f24595c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f24596d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f24597e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<LoopRange> f24598f;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19758a(ArrayList<LoopRange> arrayList) {
        LoopRange loopRange = null;
        if (arrayList != null) {
            Iterator<LoopRange> it = arrayList.iterator();
            while (it.hasNext()) {
                LoopRange next = it.next();
                if (next.loopIndex != null && next.loopIndex[0] <= this.f24595c && next.loopIndex[1] >= this.f24595c) {
                    loopRange = next;
                }
            }
        }
        if (loopRange != null) {
            this.f24594b.setMinAndMaxFrame(Math.max(loopRange.minFrame, this.f24597e), Math.min(loopRange.maxFrame, this.f24596d));
        } else if (!(this.f24594b.getMinFrame() == ((float) this.f24597e) && this.f24594b.getMaxFrame() == ((float) this.f24596d))) {
            this.f24594b.setMinAndMaxFrame(this.f24597e, this.f24596d);
        }
        this.f24595c++;
    }

    /* access modifiers changed from: package-private */
    public View onCreateView(Context context, Bundle bundle) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.f24594b = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder(bundle.getString("Loading::Animation::Lottie::Asset::Images::Path", ""));
        this.f24594b.setRepeatCount(-1);
        this.f24594b.setRepeatMode(1);
        this.f24594b.setBackgroundColor(bundle.getInt("Loading::Background::Color", -1));
        String string = bundle.getString("Loading::Animation::Lottie::Asset::File::Name", (String) null);
        if (string != null) {
            this.f24594b.setAnimation(string);
            this.f24594b.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
                public void onCompositionLoaded(LottieComposition lottieComposition) {
                    LottieLoadingRender lottieLoadingRender = LottieLoadingRender.this;
                    int unused = lottieLoadingRender.f24597e = (int) lottieLoadingRender.f24594b.getMinFrame();
                    LottieLoadingRender lottieLoadingRender2 = LottieLoadingRender.this;
                    int unused2 = lottieLoadingRender2.f24596d = (int) lottieLoadingRender2.f24594b.getMaxFrame();
                }
            });
        }
        this.f24598f = bundle.getParcelableArrayList("Loading::Animation::Lottie::LoopRanges");
        return this.f24594b;
    }

    public Rect getBorder() {
        if (this.f24594b.getComposition() != null) {
            return this.f24594b.getComposition().getBounds();
        }
        return super.getBorder();
    }

    /* access modifiers changed from: package-private */
    public void onStartLoading() {
        ArrayList<LoopRange> arrayList = this.f24598f;
        if (arrayList != null) {
            this.f24595c = 0;
            m19758a(arrayList);
            this.f24594b.addAnimatorListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LottieLoadingRender lottieLoadingRender = LottieLoadingRender.this;
                    lottieLoadingRender.m19758a((ArrayList<LoopRange>) lottieLoadingRender.f24598f);
                }
            });
        }
        this.f24594b.playAnimation();
    }

    /* access modifiers changed from: package-private */
    public void onStopLoading() {
        this.f24594b.setMinAndMaxFrame(this.f24597e, this.f24596d);
        this.f24594b.removeAllAnimatorListeners();
        this.f24594b.cancelAnimation();
    }

    public boolean isRunning() {
        return this.f24594b.isAnimating();
    }

    public static class LoopRange implements Parcelable {
        public final Parcelable.Creator<LoopRange> CREATOR = new Parcelable.Creator<LoopRange>() {
            public LoopRange createFromParcel(Parcel parcel) {
                return new LoopRange(parcel);
            }

            public LoopRange[] newArray(int i) {
                return new LoopRange[i];
            }
        };
        int[] loopIndex;
        int maxFrame = 0;
        int minFrame = 0;

        public int describeContents() {
            return 0;
        }

        public LoopRange(int i, int i2, int[] iArr) {
            this.minFrame = i;
            this.maxFrame = i2;
            this.loopIndex = iArr;
        }

        public LoopRange(Parcel parcel) {
            this.minFrame = parcel.readInt();
            this.maxFrame = parcel.readInt();
            this.loopIndex = parcel.createIntArray();
        }

        /* access modifiers changed from: package-private */
        public LoopRange setLoopRange(int[] iArr, int i, int i2) {
            this.loopIndex = iArr;
            this.minFrame = i;
            this.maxFrame = i2;
            return this;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.minFrame);
            parcel.writeInt(this.maxFrame);
            parcel.writeIntArray(this.loopIndex);
        }
    }
}
