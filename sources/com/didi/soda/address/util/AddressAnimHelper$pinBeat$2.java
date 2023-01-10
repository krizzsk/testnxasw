package com.didi.soda.address.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.didi.soda.address.util.AddressAnimHelper;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/soda/address/util/AddressAnimHelper$pinBeat$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AddressAnimHelper.kt */
public final class AddressAnimHelper$pinBeat$2 extends AnimatorListenerAdapter {
    final /* synthetic */ AddressAnimHelper.AnimListener $animListener;

    AddressAnimHelper$pinBeat$2(AddressAnimHelper.AnimListener animListener) {
        this.$animListener = animListener;
    }

    public void onAnimationEnd(Animator animator) {
        this.$animListener.onAnimEnd();
    }
}
