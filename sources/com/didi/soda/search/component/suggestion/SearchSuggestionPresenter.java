package com.didi.soda.search.component.suggestion;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.scope.BlockScopeBase;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.search.component.suggestion.Contract;
import com.didi.soda.search.helper.SearchNewOmegaHelper;

public class SearchSuggestionPresenter extends Contract.AbsSearchSuggestionPresenter {

    /* renamed from: a */
    ChildDataListManager<RecyclerModel> f46313a;

    /* renamed from: b */
    private IBlockScope f46314b = null;

    /* access modifiers changed from: package-private */
    public void onRetryClick() {
    }

    /* access modifiers changed from: protected */
    public void setState(SearchSuggestionState searchSuggestionState) {
        int size;
        if (searchSuggestionState != null) {
            int i = 0;
            if (searchSuggestionState.sugList != null && searchSuggestionState.sugList.size() > 0) {
                size = searchSuggestionState.sugList.size();
                ((Contract.AbsSearchSuggestionView) getLogicView()).setSearchSuggestionLayoutVisibility(0);
                m34468a(searchSuggestionState);
            } else if (searchSuggestionState.suggestions == null || searchSuggestionState.suggestions.size() <= 0) {
                if (this.searchSugListener != null) {
                    this.searchSugListener.onNoSug();
                } else {
                    ((Contract.AbsSearchSuggestionView) getLogicView()).setSearchSuggestionLayoutVisibility(8);
                }
                SearchNewOmegaHelper.getInstance().trackSugWordResultShow(searchSuggestionState, i);
            } else {
                size = searchSuggestionState.suggestions.size();
                ((Contract.AbsSearchSuggestionView) getLogicView()).setSearchSuggestionLayoutVisibility(0);
                m34468a(searchSuggestionState);
            }
            i = size;
            SearchNewOmegaHelper.getInstance().trackSugWordResultShow(searchSuggestionState, i);
        }
    }

    /* renamed from: a */
    private void m34468a(SearchSuggestionState searchSuggestionState) {
        ChildDataListManager<RecyclerModel> childDataListManager = this.f46313a;
        if (childDataListManager == null) {
            clearDataManagers();
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager(SearchSuggestionViewModel.convertToViewModel(searchSuggestionState));
            this.f46313a = createChildDataListManager;
            addDataManager(createChildDataListManager);
            return;
        }
        childDataListManager.clear();
        this.f46313a.set(SearchSuggestionViewModel.convertToViewModel(searchSuggestionState));
    }

    public IBlockScope getScope() {
        if (this.f46314b == null) {
            BlockScopeBase createBlockScope = BlocksEngine.Companion.getInstance().createBlockScope();
            this.f46314b = createBlockScope;
            createBlockScope.attach(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT, getScopeContext());
        }
        return this.f46314b;
    }
}
