package com.didi.component.evaluateentrance.evaluate.toolkit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuestionItemAnimator extends SimpleItemAnimator {

    /* renamed from: h */
    private static final boolean f15335h = false;

    /* renamed from: i */
    private static TimeInterpolator f15336i;

    /* renamed from: a */
    ArrayList<ArrayList<RecyclerView.ViewHolder>> f15337a = new ArrayList<>();

    /* renamed from: b */
    ArrayList<ArrayList<MoveInfo>> f15338b = new ArrayList<>();

    /* renamed from: c */
    ArrayList<ArrayList<ChangeInfo>> f15339c = new ArrayList<>();

    /* renamed from: d */
    ArrayList<RecyclerView.ViewHolder> f15340d = new ArrayList<>();

    /* renamed from: e */
    ArrayList<RecyclerView.ViewHolder> f15341e = new ArrayList<>();

    /* renamed from: f */
    ArrayList<RecyclerView.ViewHolder> f15342f = new ArrayList<>();

    /* renamed from: g */
    ArrayList<RecyclerView.ViewHolder> f15343g = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<RecyclerView.ViewHolder> f15344j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<RecyclerView.ViewHolder> f15345k = new ArrayList<>();

    /* renamed from: l */
    private ArrayList<MoveInfo> f15346l = new ArrayList<>();

    /* renamed from: m */
    private ArrayList<ChangeInfo> f15347m = new ArrayList<>();

    private static class MoveInfo {
        public int fromX;
        public int fromY;
        public RecyclerView.ViewHolder holder;
        public int toX;
        public int toY;

        MoveInfo(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
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

        ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
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

    public void runPendingAnimations() {
        boolean z = !this.f15344j.isEmpty();
        boolean z2 = !this.f15346l.isEmpty();
        boolean z3 = !this.f15347m.isEmpty();
        boolean z4 = !this.f15345k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.f15344j.iterator();
            while (it.hasNext()) {
                m12644b(it.next());
            }
            this.f15344j.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f15346l);
                this.f15338b.add(arrayList);
                this.f15346l.clear();
                C62181 r6 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            MoveInfo moveInfo = (MoveInfo) it.next();
                            QuestionItemAnimator.this.mo53974a(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
                        }
                        arrayList.clear();
                        QuestionItemAnimator.this.f15338b.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimation(((MoveInfo) arrayList.get(0)).holder.itemView, r6);
                } else {
                    r6.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f15347m);
                this.f15339c.add(arrayList2);
                this.f15347m.clear();
                C62192 r62 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            QuestionItemAnimator.this.mo53975a((ChangeInfo) it.next());
                        }
                        arrayList2.clear();
                        QuestionItemAnimator.this.f15339c.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.postOnAnimation(((ChangeInfo) arrayList2.get(0)).oldHolder.itemView, r62);
                } else {
                    r62.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f15345k);
                this.f15337a.add(arrayList3);
                this.f15345k.clear();
                C62203 r5 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            QuestionItemAnimator.this.mo53973a((RecyclerView.ViewHolder) it.next());
                        }
                        arrayList3.clear();
                        QuestionItemAnimator.this.f15337a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    if (z) {
                        getRemoveDuration();
                    }
                    long j = 0;
                    long moveDuration = z2 ? getMoveDuration() : 0;
                    if (z3) {
                        j = getChangeDuration();
                    }
                    Math.max(moveDuration, j);
                    ViewCompat.postOnAnimation(((RecyclerView.ViewHolder) arrayList3.get(0)).itemView, r5);
                    return;
                }
                r5.run();
            }
        }
    }

    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        m12646c(viewHolder);
        this.f15344j.add(viewHolder);
        return true;
    }

    /* renamed from: b */
    private void m12644b(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f15342f.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                QuestionItemAnimator.this.dispatchRemoveStarting(viewHolder);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                view.setAlpha(1.0f);
                QuestionItemAnimator.this.dispatchRemoveFinished(viewHolder);
                QuestionItemAnimator.this.f15342f.remove(viewHolder);
                QuestionItemAnimator.this.mo53972a();
            }
        }).start();
    }

    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        m12646c(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.f15345k.add(viewHolder);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo53973a(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f15340d.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                QuestionItemAnimator.this.dispatchAddStarting(viewHolder);
            }

            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                QuestionItemAnimator.this.dispatchAddFinished(viewHolder);
                QuestionItemAnimator.this.f15340d.remove(viewHolder);
                QuestionItemAnimator.this.mo53972a();
            }
        }).start();
    }

    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int translationX = i + ((int) viewHolder.itemView.getTranslationX());
        int translationY = i2 + ((int) viewHolder.itemView.getTranslationY());
        m12646c(viewHolder);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.f15346l.add(new MoveInfo(viewHolder, translationX, translationY, i3, i4));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo53974a(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        final View view = viewHolder.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.f15341e.add(viewHolder);
        final RecyclerView.ViewHolder viewHolder2 = viewHolder;
        animate.setDuration(getMoveDuration()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                QuestionItemAnimator.this.dispatchMoveStarting(viewHolder2);
            }

            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                QuestionItemAnimator.this.dispatchMoveFinished(viewHolder2);
                QuestionItemAnimator.this.f15341e.remove(viewHolder2);
                QuestionItemAnimator.this.mo53972a();
            }
        }).start();
    }

    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i, i2, i3, i4);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        m12646c(viewHolder);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            m12646c(viewHolder2);
            viewHolder2.itemView.setTranslationX((float) (-i5));
            viewHolder2.itemView.setTranslationY((float) (-i6));
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.f15347m.add(new ChangeInfo(viewHolder, viewHolder2, i, i2, i3, i4));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo53975a(final ChangeInfo changeInfo) {
        final View view;
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
            final ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.f15343g.add(changeInfo.oldHolder);
            duration.translationX((float) (changeInfo.toX - changeInfo.fromX));
            duration.translationY((float) (changeInfo.toY - changeInfo.fromY));
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    QuestionItemAnimator.this.dispatchChangeStarting(changeInfo.oldHolder, true);
                }

                public void onAnimationEnd(Animator animator) {
                    duration.setListener((Animator.AnimatorListener) null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    QuestionItemAnimator.this.dispatchChangeFinished(changeInfo.oldHolder, true);
                    QuestionItemAnimator.this.f15343g.remove(changeInfo.oldHolder);
                    QuestionItemAnimator.this.mo53972a();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.f15343g.add(changeInfo.newHolder);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    QuestionItemAnimator.this.dispatchChangeStarting(changeInfo.newHolder, false);
                }

                public void onAnimationEnd(Animator animator) {
                    animate.setListener((Animator.AnimatorListener) null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    QuestionItemAnimator.this.dispatchChangeFinished(changeInfo.newHolder, false);
                    QuestionItemAnimator.this.f15343g.remove(changeInfo.newHolder);
                    QuestionItemAnimator.this.mo53972a();
                }
            }).start();
        }
    }

    /* renamed from: a */
    private void m12642a(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (m12643a(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
        }
    }

    /* renamed from: b */
    private void m12645b(ChangeInfo changeInfo) {
        if (changeInfo.oldHolder != null) {
            m12643a(changeInfo, changeInfo.oldHolder);
        }
        if (changeInfo.newHolder != null) {
            m12643a(changeInfo, changeInfo.newHolder);
        }
    }

    /* renamed from: a */
    private boolean m12643a(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.newHolder == viewHolder) {
            changeInfo.newHolder = null;
        } else if (changeInfo.oldHolder != viewHolder) {
            return false;
        } else {
            changeInfo.oldHolder = null;
            z = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.f15346l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f15346l.get(size).holder == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.f15346l.remove(size);
            }
        }
        m12642a((List<ChangeInfo>) this.f15347m, viewHolder);
        if (this.f15344j.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.f15345k.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.f15339c.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f15339c.get(size2);
            m12642a((List<ChangeInfo>) arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.f15339c.remove(size2);
            }
        }
        for (int size3 = this.f15338b.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f15338b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((MoveInfo) arrayList2.get(size4)).holder == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f15338b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f15337a.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f15337a.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.f15337a.remove(size5);
                }
            }
        }
        this.f15342f.remove(viewHolder);
        this.f15340d.remove(viewHolder);
        this.f15343g.remove(viewHolder);
        this.f15341e.remove(viewHolder);
        mo53972a();
    }

    /* renamed from: c */
    private void m12646c(RecyclerView.ViewHolder viewHolder) {
        if (f15336i == null) {
            f15336i = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(f15336i);
        endAnimation(viewHolder);
    }

    public boolean isRunning() {
        return !this.f15345k.isEmpty() || !this.f15347m.isEmpty() || !this.f15346l.isEmpty() || !this.f15344j.isEmpty() || !this.f15341e.isEmpty() || !this.f15342f.isEmpty() || !this.f15340d.isEmpty() || !this.f15343g.isEmpty() || !this.f15338b.isEmpty() || !this.f15337a.isEmpty() || !this.f15339c.isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo53972a() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    public void endAnimations() {
        int size = this.f15346l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.f15346l.get(size);
            View view = moveInfo.holder.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(moveInfo.holder);
            this.f15346l.remove(size);
        }
        for (int size2 = this.f15344j.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.f15344j.get(size2));
            this.f15344j.remove(size2);
        }
        int size3 = this.f15345k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.f15345k.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            this.f15345k.remove(size3);
        }
        for (int size4 = this.f15347m.size() - 1; size4 >= 0; size4--) {
            m12645b(this.f15347m.get(size4));
        }
        this.f15347m.clear();
        if (isRunning()) {
            for (int size5 = this.f15338b.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f15338b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList.get(size6);
                    View view2 = moveInfo2.holder.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f15338b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f15337a.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f15337a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = (RecyclerView.ViewHolder) arrayList2.get(size8);
                    viewHolder2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f15337a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f15339c.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f15339c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m12645b((ChangeInfo) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f15339c.remove(arrayList3);
                    }
                }
            }
            mo53976a((List<RecyclerView.ViewHolder>) this.f15342f);
            mo53976a((List<RecyclerView.ViewHolder>) this.f15341e);
            mo53976a((List<RecyclerView.ViewHolder>) this.f15340d);
            mo53976a((List<RecyclerView.ViewHolder>) this.f15343g);
            dispatchAnimationsFinished();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo53976a(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }
}
