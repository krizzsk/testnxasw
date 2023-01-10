package com.didi.component.service.activity.risk.animation;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseItemAnimator extends SimpleItemAnimator {

    /* renamed from: a */
    private static final boolean f17571a = false;

    /* renamed from: b */
    private ArrayList<RecyclerView.ViewHolder> f17572b = new ArrayList<>();

    /* renamed from: c */
    private ArrayList<RecyclerView.ViewHolder> f17573c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<MoveInfo> f17574d = new ArrayList<>();

    /* renamed from: e */
    private ArrayList<ChangeInfo> f17575e = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList<ArrayList<RecyclerView.ViewHolder>> f17576f = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ArrayList<ArrayList<MoveInfo>> f17577g = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ArrayList<ArrayList<ChangeInfo>> f17578h = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ArrayList<RecyclerView.ViewHolder> f17579i = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ArrayList<RecyclerView.ViewHolder> f17580j = new ArrayList<>();
    protected ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<>();
    protected Interpolator mInterpolator = new DecelerateInterpolator();
    protected ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<>();

    /* access modifiers changed from: protected */
    public abstract void animateAddImpl(RecyclerView.ViewHolder viewHolder);

    /* access modifiers changed from: protected */
    public abstract void animateRemoveImpl(RecyclerView.ViewHolder viewHolder);

    /* access modifiers changed from: protected */
    public void preAnimateAddImpl(RecyclerView.ViewHolder viewHolder) {
    }

    /* access modifiers changed from: protected */
    public void preAnimateRemoveImpl(RecyclerView.ViewHolder viewHolder) {
    }

    private static class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        private MoveInfo(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.holder = viewHolder;
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }
    }

    private static class ChangeInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder newHolder;
        public RecyclerView.ViewHolder oldHolder;
        public int toX;
        public int toY;

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.oldHolder = viewHolder;
            this.newHolder = viewHolder2;
        }

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }
    }

    public BaseItemAnimator() {
        setSupportsChangeAnimations(false);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void runPendingAnimations() {
        boolean z = !this.f17572b.isEmpty();
        boolean z2 = !this.f17574d.isEmpty();
        boolean z3 = !this.f17575e.isEmpty();
        boolean z4 = !this.f17573c.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.f17572b.iterator();
            while (it.hasNext()) {
                m14898c(it.next());
            }
            this.f17572b.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f17574d);
                this.f17577g.add(arrayList);
                this.f17574d.clear();
                C76131 r6 = new Runnable() {
                    public void run() {
                        if (BaseItemAnimator.this.f17577g.remove(arrayList)) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                MoveInfo moveInfo = (MoveInfo) it.next();
                                BaseItemAnimator.this.m14887a(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
                            }
                            arrayList.clear();
                        }
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(((MoveInfo) arrayList.get(0)).holder.itemView, r6, getRemoveDuration());
                } else {
                    r6.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f17575e);
                this.f17578h.add(arrayList2);
                this.f17575e.clear();
                C76142 r62 = new Runnable() {
                    public void run() {
                        if (BaseItemAnimator.this.f17578h.remove(arrayList2)) {
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                BaseItemAnimator.this.m14888a((ChangeInfo) it.next());
                            }
                            arrayList2.clear();
                        }
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimationDelayed(((ChangeInfo) arrayList2.get(0)).oldHolder.itemView, r62, getRemoveDuration());
                } else {
                    r62.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f17573c);
                this.f17576f.add(arrayList3);
                this.f17573c.clear();
                C76153 r5 = new Runnable() {
                    public void run() {
                        if (BaseItemAnimator.this.f17576f.remove(arrayList3)) {
                            Iterator it = arrayList3.iterator();
                            while (it.hasNext()) {
                                BaseItemAnimator.this.m14900d((RecyclerView.ViewHolder) it.next());
                            }
                            arrayList3.clear();
                        }
                    }
                };
                if (z || z2 || z3) {
                    long j = 0;
                    long removeDuration = z ? getRemoveDuration() : 0;
                    long moveDuration = z2 ? getMoveDuration() : 0;
                    if (z3) {
                        j = getChangeDuration();
                    }
                    ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder) arrayList3.get(0)).itemView, r5, removeDuration + Math.max(moveDuration, j));
                    return;
                }
                r5.run();
            }
        }
    }

    /* renamed from: a */
    private void m14886a(RecyclerView.ViewHolder viewHolder) {
        ViewHelper.clear(viewHolder.itemView);
        if (viewHolder instanceof AnimateViewHolder) {
            ((AnimateViewHolder) viewHolder).preAnimateRemoveImpl(viewHolder);
        } else {
            preAnimateRemoveImpl(viewHolder);
        }
    }

    /* renamed from: b */
    private void m14895b(RecyclerView.ViewHolder viewHolder) {
        ViewHelper.clear(viewHolder.itemView);
        if (viewHolder instanceof AnimateViewHolder) {
            ((AnimateViewHolder) viewHolder).preAnimateAddImpl(viewHolder);
        } else {
            preAnimateAddImpl(viewHolder);
        }
    }

    /* renamed from: c */
    private void m14898c(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof AnimateViewHolder) {
            ((AnimateViewHolder) viewHolder).animateRemoveImpl(viewHolder, new DefaultRemoveVpaListener(viewHolder));
        } else {
            animateRemoveImpl(viewHolder);
        }
        this.mRemoveAnimations.add(viewHolder);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m14900d(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof AnimateViewHolder) {
            ((AnimateViewHolder) viewHolder).animateAddImpl(viewHolder, new DefaultAddVpaListener(viewHolder));
        } else {
            animateAddImpl(viewHolder);
        }
        this.mAddAnimations.add(viewHolder);
    }

    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        endAnimation(viewHolder);
        m14886a(viewHolder);
        this.f17572b.add(viewHolder);
        return true;
    }

    /* access modifiers changed from: protected */
    public long getRemoveDelay(RecyclerView.ViewHolder viewHolder) {
        return Math.abs((((long) viewHolder.getOldPosition()) * getRemoveDuration()) / 4);
    }

    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        endAnimation(viewHolder);
        m14895b(viewHolder);
        this.f17573c.add(viewHolder);
        return true;
    }

    /* access modifiers changed from: protected */
    public long getAddDelay(RecyclerView.ViewHolder viewHolder) {
        return Math.abs((((long) viewHolder.getAdapterPosition()) * getAddDuration()) / 4);
    }

    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int translationX = (int) (((float) i) + ViewCompat.getTranslationX(viewHolder.itemView));
        int translationY = (int) (((float) i2) + ViewCompat.getTranslationY(viewHolder.itemView));
        endAnimation(viewHolder);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i5 != 0) {
            ViewCompat.setTranslationX(view, (float) (-i5));
        }
        if (i6 != 0) {
            ViewCompat.setTranslationY(view, (float) (-i6));
        }
        this.f17574d.add(new MoveInfo(viewHolder, translationX, translationY, i3, i4));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14887a(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            ViewCompat.animate(view).translationX(0.0f);
        }
        if (i6 != 0) {
            ViewCompat.animate(view).translationY(0.0f);
        }
        this.f17579i.add(viewHolder);
        final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view);
        final RecyclerView.ViewHolder viewHolder2 = viewHolder;
        animate.setDuration(getMoveDuration()).setListener(new VpaListenerAdapter() {
            public void onAnimationStart(View view) {
                BaseItemAnimator.this.dispatchMoveStarting(viewHolder2);
            }

            public void onAnimationCancel(View view) {
                if (i5 != 0) {
                    ViewCompat.setTranslationX(view, 0.0f);
                }
                if (i6 != 0) {
                    ViewCompat.setTranslationY(view, 0.0f);
                }
            }

            public void onAnimationEnd(View view) {
                animate.setListener((ViewPropertyAnimatorListener) null);
                BaseItemAnimator.this.dispatchMoveFinished(viewHolder2);
                BaseItemAnimator.this.f17579i.remove(viewHolder2);
                BaseItemAnimator.this.m14885a();
            }
        }).start();
    }

    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        RecyclerView.ViewHolder viewHolder3 = viewHolder;
        RecyclerView.ViewHolder viewHolder4 = viewHolder2;
        float translationX = ViewCompat.getTranslationX(viewHolder3.itemView);
        float translationY = ViewCompat.getTranslationY(viewHolder3.itemView);
        float alpha = ViewCompat.getAlpha(viewHolder3.itemView);
        endAnimation(viewHolder);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        ViewCompat.setTranslationX(viewHolder3.itemView, translationX);
        ViewCompat.setTranslationY(viewHolder3.itemView, translationY);
        ViewCompat.setAlpha(viewHolder3.itemView, alpha);
        if (!(viewHolder4 == null || viewHolder4.itemView == null)) {
            endAnimation(viewHolder2);
            ViewCompat.setTranslationX(viewHolder4.itemView, (float) (-i5));
            ViewCompat.setTranslationY(viewHolder4.itemView, (float) (-i6));
            ViewCompat.setAlpha(viewHolder4.itemView, 0.0f);
        }
        this.f17575e.add(new ChangeInfo(viewHolder, viewHolder2, i, i2, i3, i4));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14888a(final ChangeInfo changeInfo) {
        View view;
        RecyclerView.ViewHolder viewHolder = changeInfo.oldHolder;
        final View view2 = null;
        if (viewHolder == null) {
            view = null;
        } else {
            view = viewHolder.itemView;
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            view2 = viewHolder2.itemView;
        }
        if (view != null) {
            this.f17580j.add(changeInfo.oldHolder);
            final ViewPropertyAnimatorCompat duration = ViewCompat.animate(view).setDuration(getChangeDuration());
            duration.translationX((float) (changeInfo.toX - changeInfo.fromX));
            duration.translationY((float) (changeInfo.toY - changeInfo.fromY));
            duration.alpha(0.0f).setListener(new VpaListenerAdapter() {
                public void onAnimationStart(View view) {
                    BaseItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }

                public void onAnimationEnd(View view) {
                    duration.setListener((ViewPropertyAnimatorListener) null);
                    ViewCompat.setAlpha(view, 1.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    ViewCompat.setTranslationY(view, 0.0f);
                    BaseItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                    BaseItemAnimator.this.f17580j.remove(changeInfo.oldHolder);
                    BaseItemAnimator.this.m14885a();
                }
            }).start();
        }
        if (view2 != null) {
            this.f17580j.add(changeInfo.newHolder);
            final ViewPropertyAnimatorCompat animate = ViewCompat.animate(view2);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new VpaListenerAdapter() {
                public void onAnimationStart(View view) {
                    BaseItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }

                public void onAnimationEnd(View view) {
                    animate.setListener((ViewPropertyAnimatorListener) null);
                    ViewCompat.setAlpha(view2, 1.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    ViewCompat.setTranslationY(view2, 0.0f);
                    BaseItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                    BaseItemAnimator.this.f17580j.remove(changeInfo.newHolder);
                    BaseItemAnimator.this.m14885a();
                }
            }).start();
        }
    }

    /* renamed from: a */
    private void m14892a(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (m14893a(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
        }
    }

    /* renamed from: b */
    private void m14896b(ChangeInfo changeInfo) {
        if (changeInfo.oldHolder != null) {
            m14893a(changeInfo, changeInfo.oldHolder);
        }
        if (changeInfo.newHolder != null) {
            m14893a(changeInfo, changeInfo.newHolder);
        }
    }

    /* renamed from: a */
    private boolean m14893a(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.newHolder == viewHolder) {
            changeInfo.newHolder = null;
        } else if (changeInfo.oldHolder != viewHolder) {
            return false;
        } else {
            changeInfo.oldHolder = null;
            z = true;
        }
        ViewCompat.setAlpha(viewHolder.itemView, 1.0f);
        ViewCompat.setTranslationX(viewHolder.itemView, 0.0f);
        ViewCompat.setTranslationY(viewHolder.itemView, 0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewCompat.animate(view).cancel();
        int size = this.f17574d.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f17574d.get(size).holder == viewHolder) {
                ViewCompat.setTranslationY(view, 0.0f);
                ViewCompat.setTranslationX(view, 0.0f);
                dispatchMoveFinished(viewHolder);
                this.f17574d.remove(size);
            }
        }
        m14892a((List<ChangeInfo>) this.f17575e, viewHolder);
        if (this.f17572b.remove(viewHolder)) {
            ViewHelper.clear(viewHolder.itemView);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.f17573c.remove(viewHolder)) {
            ViewHelper.clear(viewHolder.itemView);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.f17578h.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f17578h.get(size2);
            m14892a((List<ChangeInfo>) arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f17578h.remove(size2);
            }
        }
        for (int size3 = this.f17577g.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f17577g.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((MoveInfo) arrayList2.get(size4)).holder == viewHolder) {
                    ViewCompat.setTranslationY(view, 0.0f);
                    ViewCompat.setTranslationX(view, 0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f17577g.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f17576f.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f17576f.get(size5);
            if (arrayList3.remove(viewHolder)) {
                ViewHelper.clear(viewHolder.itemView);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f17576f.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(viewHolder);
        this.mAddAnimations.remove(viewHolder);
        this.f17580j.remove(viewHolder);
        this.f17579i.remove(viewHolder);
        m14885a();
    }

    public boolean isRunning() {
        return !this.f17573c.isEmpty() || !this.f17575e.isEmpty() || !this.f17574d.isEmpty() || !this.f17572b.isEmpty() || !this.f17579i.isEmpty() || !this.mRemoveAnimations.isEmpty() || !this.mAddAnimations.isEmpty() || !this.f17580j.isEmpty() || !this.f17577g.isEmpty() || !this.f17576f.isEmpty() || !this.f17578h.isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14885a() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    public void endAnimations() {
        int size = this.f17574d.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.f17574d.get(size);
            View view = moveInfo.holder.itemView;
            ViewCompat.setTranslationY(view, 0.0f);
            ViewCompat.setTranslationX(view, 0.0f);
            dispatchMoveFinished(moveInfo.holder);
            this.f17574d.remove(size);
        }
        for (int size2 = this.f17572b.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.f17572b.get(size2));
            this.f17572b.remove(size2);
        }
        for (int size3 = this.f17573c.size() - 1; size3 >= 0; size3--) {
            RecyclerView.ViewHolder viewHolder = this.f17573c.get(size3);
            ViewHelper.clear(viewHolder.itemView);
            dispatchAddFinished(viewHolder);
            this.f17573c.remove(size3);
        }
        for (int size4 = this.f17575e.size() - 1; size4 >= 0; size4--) {
            m14896b(this.f17575e.get(size4));
        }
        this.f17575e.clear();
        if (isRunning()) {
            for (int size5 = this.f17577g.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f17577g.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList.get(size6);
                    View view2 = moveInfo2.holder.itemView;
                    ViewCompat.setTranslationY(view2, 0.0f);
                    ViewCompat.setTranslationX(view2, 0.0f);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f17577g.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f17576f.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f17576f.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = (RecyclerView.ViewHolder) arrayList2.get(size8);
                    ViewCompat.setAlpha(viewHolder2.itemView, 1.0f);
                    dispatchAddFinished(viewHolder2);
                    if (size8 < arrayList2.size()) {
                        arrayList2.remove(size8);
                    }
                    if (arrayList2.isEmpty()) {
                        this.f17576f.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f17578h.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f17578h.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m14896b((ChangeInfo) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f17578h.remove(arrayList3);
                    }
                }
            }
            mo57986a((List<RecyclerView.ViewHolder>) this.mRemoveAnimations);
            mo57986a((List<RecyclerView.ViewHolder>) this.f17579i);
            mo57986a((List<RecyclerView.ViewHolder>) this.mAddAnimations);
            mo57986a((List<RecyclerView.ViewHolder>) this.f17580j);
            dispatchAnimationsFinished();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo57986a(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ViewCompat.animate(list.get(size).itemView).cancel();
        }
    }

    private static class VpaListenerAdapter implements ViewPropertyAnimatorListener {
        public void onAnimationCancel(View view) {
        }

        public void onAnimationEnd(View view) {
        }

        public void onAnimationStart(View view) {
        }

        private VpaListenerAdapter() {
        }
    }

    protected class DefaultAddVpaListener extends VpaListenerAdapter {
        RecyclerView.ViewHolder mViewHolder;

        public DefaultAddVpaListener(RecyclerView.ViewHolder viewHolder) {
            super();
            this.mViewHolder = viewHolder;
        }

        public void onAnimationStart(View view) {
            BaseItemAnimator.this.dispatchAddStarting(this.mViewHolder);
        }

        public void onAnimationCancel(View view) {
            ViewHelper.clear(view);
        }

        public void onAnimationEnd(View view) {
            ViewHelper.clear(view);
            BaseItemAnimator.this.dispatchAddFinished(this.mViewHolder);
            BaseItemAnimator.this.mAddAnimations.remove(this.mViewHolder);
            BaseItemAnimator.this.m14885a();
        }
    }

    protected class DefaultRemoveVpaListener extends VpaListenerAdapter {
        RecyclerView.ViewHolder mViewHolder;

        public DefaultRemoveVpaListener(RecyclerView.ViewHolder viewHolder) {
            super();
            this.mViewHolder = viewHolder;
        }

        public void onAnimationStart(View view) {
            BaseItemAnimator.this.dispatchRemoveStarting(this.mViewHolder);
        }

        public void onAnimationCancel(View view) {
            ViewHelper.clear(view);
        }

        public void onAnimationEnd(View view) {
            ViewHelper.clear(view);
            BaseItemAnimator.this.dispatchRemoveFinished(this.mViewHolder);
            BaseItemAnimator.this.mRemoveAnimations.remove(this.mViewHolder);
            BaseItemAnimator.this.m14885a();
        }
    }
}
