package com.didi.soda.business.widget;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.business.widget.BusinessDyHeaderAnimator;

public interface IBusinessHeaderAnimator {
    void bindScopeContext(ScopeContext scopeContext);

    void collapseHeader();

    void collapseHeader(OnHeaderCollapseListener onHeaderCollapseListener);

    void expandHeader();

    float getAnimatedProgress();

    float getAnimatedY();

    float getMaxAnimatedY();

    int getShadowHeight();

    boolean isCollapsed();

    boolean isExpanded();

    void recordAnimationSpec();

    void setAnimatedY(float f);

    void setDependentViewDyChangedCallback(BusinessDyHeaderAnimator.DependentViewChangedCallback dependentViewChangedCallback);

    void setOnHeaderStateChangeListener(OnHeaderStateChangeListener onHeaderStateChangeListener);

    void updateRecordState(boolean z);
}
