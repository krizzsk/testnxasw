package com.didi.soda.customer.widget.loading.render;

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
    public LottieAnimationView f44672b;

    /* renamed from: c */
    private int f44673c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f44674d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f44675e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<LoopRangeModel> f44676f;

    public boolean isRunning() {
        return this.f44672b.isAnimating();
    }

    /* access modifiers changed from: package-private */
    public View onCreateView(Context context, Bundle bundle) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.f44672b = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder(bundle.getString("Loading::Animation::Lottie::Asset::Images::Path", ""));
        this.f44672b.setRepeatCount(-1);
        this.f44672b.setRepeatMode(1);
        this.f44672b.setBackgroundColor(bundle.getInt("Loading::Background::Color", -1));
        String string = bundle.getString("Loading::Animation::Lottie::Asset::File::Name", (String) null);
        if (string != null) {
            this.f44672b.setAnimation(string);
            this.f44672b.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
                public void onCompositionLoaded(LottieComposition lottieComposition) {
                    LottieLoadingRender lottieLoadingRender = LottieLoadingRender.this;
                    int unused = lottieLoadingRender.f44675e = (int) lottieLoadingRender.f44672b.getMinFrame();
                    LottieLoadingRender lottieLoadingRender2 = LottieLoadingRender.this;
                    int unused2 = lottieLoadingRender2.f44674d = (int) lottieLoadingRender2.f44672b.getMaxFrame();
                }
            });
        }
        this.f44676f = bundle.getParcelableArrayList("Loading::Animation::Lottie::LoopRanges");
        return this.f44672b;
    }

    /* access modifiers changed from: package-private */
    public void onStartLoading() {
        ArrayList<LoopRangeModel> arrayList = this.f44676f;
        if (arrayList != null) {
            this.f44673c = 0;
            m33162a(arrayList);
            this.f44672b.addAnimatorListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LottieLoadingRender lottieLoadingRender = LottieLoadingRender.this;
                    lottieLoadingRender.m33162a((ArrayList<LoopRangeModel>) lottieLoadingRender.f44676f);
                }
            });
        }
        this.f44672b.playAnimation();
    }

    /* access modifiers changed from: package-private */
    public void onStopLoading() {
        this.f44672b.setMinAndMaxFrame(this.f44675e, this.f44674d);
        this.f44672b.removeAllAnimatorListeners();
        this.f44672b.cancelAnimation();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33162a(ArrayList<LoopRangeModel> arrayList) {
        LoopRangeModel loopRangeModel = null;
        if (arrayList != null) {
            Iterator<LoopRangeModel> it = arrayList.iterator();
            while (it.hasNext()) {
                LoopRangeModel next = it.next();
                if (next.mLoopIndex != null && next.mLoopIndex[0] <= this.f44673c && next.mLoopIndex[1] >= this.f44673c) {
                    loopRangeModel = next;
                }
            }
        }
        if (loopRangeModel != null) {
            this.f44672b.setMinAndMaxFrame(Math.max(loopRangeModel.mMinFrame, this.f44675e), Math.min(loopRangeModel.mMaxFrame, this.f44674d));
        } else if (!(this.f44672b.getMinFrame() == ((float) this.f44675e) && this.f44672b.getMaxFrame() == ((float) this.f44674d))) {
            this.f44672b.setMinAndMaxFrame(this.f44675e, this.f44674d);
        }
        this.f44673c++;
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
