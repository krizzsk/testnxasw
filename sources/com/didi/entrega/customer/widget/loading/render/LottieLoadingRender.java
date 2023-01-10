package com.didi.entrega.customer.widget.loading.render;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
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
    public static final String K_ANIMATOR_ASSET_FILE_NAME = "Loading::Animation::Lottie::Asset::File::Name";
    public static final String K_ANIMATOR_ASSET_IMAGES_PATH = "Loading::Animation::Lottie::Asset::Images::Path";
    public static final String K_ANIMATOR_LOOP_RANGES = "Loading::Animation::Lottie::LoopRanges";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LottieAnimationView f22429b;

    /* renamed from: c */
    private int f22430c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f22431d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f22432e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<LoopRangeModel> f22433f;

    public boolean isRunning() {
        return this.f22429b.isAnimating();
    }

    /* access modifiers changed from: package-private */
    public View onCreateView(Context context, Bundle bundle) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.f22429b = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder(bundle.getString("Loading::Animation::Lottie::Asset::Images::Path", ""));
        this.f22429b.setRepeatCount(-1);
        this.f22429b.setRepeatMode(1);
        this.f22429b.setBackgroundColor(bundle.getInt("Loading::Background::Color", -1));
        String string = bundle.getString("Loading::Animation::Lottie::Asset::File::Name", (String) null);
        if (string != null) {
            this.f22429b.setAnimation(string);
            this.f22429b.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
                public void onCompositionLoaded(LottieComposition lottieComposition) {
                    LottieLoadingRender lottieLoadingRender = LottieLoadingRender.this;
                    int unused = lottieLoadingRender.f22432e = (int) lottieLoadingRender.f22429b.getMinFrame();
                    LottieLoadingRender lottieLoadingRender2 = LottieLoadingRender.this;
                    int unused2 = lottieLoadingRender2.f22431d = (int) lottieLoadingRender2.f22429b.getMaxFrame();
                }
            });
        }
        this.f22433f = bundle.getParcelableArrayList("Loading::Animation::Lottie::LoopRanges");
        return this.f22429b;
    }

    /* access modifiers changed from: package-private */
    public void onStartLoading() {
        ArrayList<LoopRangeModel> arrayList = this.f22433f;
        if (arrayList != null) {
            this.f22430c = 0;
            m18474a(arrayList);
            this.f22429b.addAnimatorListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LottieLoadingRender lottieLoadingRender = LottieLoadingRender.this;
                    lottieLoadingRender.m18474a((ArrayList<LoopRangeModel>) lottieLoadingRender.f22433f);
                }
            });
        }
        this.f22429b.playAnimation();
    }

    /* access modifiers changed from: package-private */
    public void onStopLoading() {
        this.f22429b.setMinAndMaxFrame(this.f22432e, this.f22431d);
        this.f22429b.removeAllAnimatorListeners();
        this.f22429b.cancelAnimation();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18474a(ArrayList<LoopRangeModel> arrayList) {
        LoopRangeModel loopRangeModel = null;
        if (arrayList != null) {
            Iterator<LoopRangeModel> it = arrayList.iterator();
            while (it.hasNext()) {
                LoopRangeModel next = it.next();
                if (next.mLoopIndex != null && next.mLoopIndex[0] <= this.f22430c && next.mLoopIndex[1] >= this.f22430c) {
                    loopRangeModel = next;
                }
            }
        }
        if (loopRangeModel != null) {
            this.f22429b.setMinAndMaxFrame(Math.max(loopRangeModel.mMinFrame, this.f22432e), Math.min(loopRangeModel.mMaxFrame, this.f22431d));
        } else if (!(this.f22429b.getMinFrame() == ((float) this.f22432e) && this.f22429b.getMaxFrame() == ((float) this.f22431d))) {
            this.f22429b.setMinAndMaxFrame(this.f22432e, this.f22431d);
        }
        this.f22430c++;
    }

    public static class LoopRangeModel implements Parcelable {
        public final Parcelable.Creator<LoopRangeModel> CREATOR = new Parcelable.Creator<LoopRangeModel>() {
            public LoopRangeModel createFromParcel(Parcel parcel) {
                return new LoopRangeModel(parcel);
            }

            public LoopRangeModel[] newArray(int i) {
                return new LoopRangeModel[i];
            }
        };
        int[] mLoopIndex;
        int mMaxFrame = 0;
        int mMinFrame = 0;

        public int describeContents() {
            return 0;
        }

        public LoopRangeModel(int i, int i2, int[] iArr) {
            this.mMinFrame = i;
            this.mMaxFrame = i2;
            this.mLoopIndex = iArr;
        }

        public LoopRangeModel(Parcel parcel) {
            this.mMinFrame = parcel.readInt();
            this.mMaxFrame = parcel.readInt();
            this.mLoopIndex = parcel.createIntArray();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mMinFrame);
            parcel.writeInt(this.mMaxFrame);
            parcel.writeIntArray(this.mLoopIndex);
        }

        /* access modifiers changed from: package-private */
        public LoopRangeModel setLoopRange(int[] iArr, int i, int i2) {
            this.mLoopIndex = iArr;
            this.mMinFrame = i;
            this.mMaxFrame = i2;
            return this;
        }
    }
}
