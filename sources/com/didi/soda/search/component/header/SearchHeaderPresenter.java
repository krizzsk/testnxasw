package com.didi.soda.search.component.header;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.nova.assembly.serial.SerialTaskQueue;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.rxdux.SkeletonStore;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.rpc.entity.SearchSuggestionEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.listener.OnBackListener;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.component.feed.listener.HomeSortClickListener;
import com.didi.soda.search.component.header.Contract;
import com.didi.soda.search.component.suggestion.SearchSuggestionActionCreator;
import com.didi.soda.search.component.suggestion.SearchSuggestionTask;
import com.didi.soda.search.helper.SearchLogHelper;
import com.didi.soda.search.helper.SearchNewOmegaHelper;
import com.didi.soda.search.repo.SearchHeaderRepo;
import com.didi.soda.search.repo.SearchWordModel;
import com.didi.soda.search.repo.SearchWordRepo;
import com.taxis99.R;

public class SearchHeaderPresenter extends Contract.AbsSearchHeaderPresenter {

    /* renamed from: a */
    private static final String f46240a = "SearchHeaderPresenter";

    /* renamed from: b */
    private HomeSortClickListener.Type f46241b = HomeSortClickListener.Type.RECOMMEND;

    /* renamed from: c */
    private SerialTaskQueue f46242c = new SerialTaskQueue();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f46243d = null;

    /* renamed from: e */
    private int f46244e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f46245f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f46246g = true;

    /* renamed from: h */
    private String f46247h;

    /* renamed from: i */
    private String f46248i;

    /* renamed from: j */
    private OnBackListener f46249j;

    public void setSearchHomeBackListener(OnBackListener onBackListener) {
        this.f46249j = onBackListener;
    }

    public void onBack(Boolean bool) {
        SearchLogHelper.info(f46240a, "onBack.");
        this.f46249j.onBack(bool);
        OmegaTracker.Builder.create(EventConst.Search.ENTRANCE_BACK_CK).build().track();
        SearchNewOmegaHelper.getInstance().trackSearchBackClick(bool);
    }

    public void handleBack() {
        SearchLogHelper.info(f46240a, "onBack.");
        OmegaTracker.Builder.create(EventConst.Search.ENTRANCE_BACK_CK).build().track();
        SearchNewOmegaHelper.getInstance().trackSearchBackClick(Boolean.valueOf(((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).mIsResultViewVisible));
    }

    public void onSearchClicked(String str) {
        SearchWordModel.SearchFrom searchFrom = SearchWordModel.SearchFrom.EDIT;
        if (StringUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(this.f46248i)) {
                SchemeHelper.dispatchMsg(this.f46248i);
            } else {
                str = this.f46247h;
            }
            searchFrom = SearchWordModel.SearchFrom.HOT_WORD;
        }
        if (str.equals(ResourceHelper.getString(R.string.customer_global_home_search_hit))) {
            SearchWordModel.SearchFrom searchFrom2 = SearchWordModel.SearchFrom.EDIT;
            return;
        }
        m34394b();
        SearchWordModel searchWordModel = new SearchWordModel(str);
        searchWordModel.mSearchFrom = searchFrom;
        SearchLogHelper.info(f46240a, "onSearchClicked, searchTag = " + str);
        ((Contract.AbsSearchHeaderView) getLogicView()).goneAllSearchRightView();
        ((SearchHeaderRepo) RepoFactory.getRepo(SearchHeaderRepo.class)).setValue(searchWordModel);
    }

    public void onSearchTagClear() {
        SearchLogHelper.info(f46240a, "onSearchTagClear.");
        m34394b();
        m34391a(new SearchWordModel(""));
    }

    public void onSearchSuggestion(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("on search sug words:");
        sb.append(str != null ? str : "");
        SearchLogHelper.info(f46240a, sb.toString());
        if (TextUtils.isEmpty(str)) {
            this.f46243d = null;
            this.f46244e = 0;
            this.f46245f = true;
            SkeletonStore.getStore().dispatch(SearchSuggestionActionCreator.updateSuggestion(str, (SearchSuggestionEntity) null));
            return;
        }
        this.f46245f = false;
        SearchNewOmegaHelper.getInstance().trackSearchWordInput(str);
        m34392a(str, this.f46243d);
    }

    public void refreshSuggestion() {
        SearchWordModel searchWordModel = (SearchWordModel) ((SearchHeaderRepo) RepoFactory.getRepo(SearchHeaderRepo.class)).getValue();
        if (searchWordModel != null && !TextUtils.isEmpty(searchWordModel.mSearchTag)) {
            m34392a(searchWordModel.mSearchTag, this.f46243d);
        }
    }

    public void onSearchEditViewClick() {
        SearchLogHelper.info(f46240a, "on search editView clicked");
        SearchNewOmegaHelper.getInstance().trackSearchEditViewClick();
    }

    public HomeSortClickListener.Type getCurrentSortType() {
        return this.f46241b;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m34387a();
        if (getScopeContext().getBundle() != null) {
            this.f46247h = getScopeContext().getBundle().getString("search_word");
            this.f46248i = getScopeContext().getBundle().getString(Const.PageParams.SEARCH_URL);
        }
        if (TextUtils.isEmpty(this.f46247h)) {
            this.f46247h = ResourceHelper.getString(R.string.customer_global_home_search_hit);
            ((Contract.AbsSearchHeaderView) getLogicView()).setSearchHint(ResourceHelper.getString(R.string.customer_global_home_search_hit));
            return;
        }
        ((Contract.AbsSearchHeaderView) getLogicView()).setSearchHint(this.f46247h);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        RepoFactory.clearRepo(SearchHeaderRepo.class);
        super.onDestroy();
    }

    /* renamed from: a */
    private void m34387a() {
        ((SearchHeaderRepo) RepoFactory.getRepo(SearchHeaderRepo.class)).subscribe(getScopeContext(), new Action1<SearchWordModel>() {
            public void call(SearchWordModel searchWordModel) {
                StringBuilder sb = new StringBuilder();
                sb.append("SearchHeaderRepo call, mSearchTag = ");
                sb.append(searchWordModel != null ? searchWordModel.mSearchTag : "");
                SearchLogHelper.info(SearchHeaderPresenter.f46240a, sb.toString());
                if (searchWordModel != null && !TextUtils.isEmpty(searchWordModel.mSearchTag.trim())) {
                    ((Contract.AbsSearchHeaderView) SearchHeaderPresenter.this.getLogicView()).setFilterIvVisibility(0);
                    ((Contract.AbsSearchHeaderView) SearchHeaderPresenter.this.getLogicView()).setSearchTag(searchWordModel.mSearchTag);
                    SearchHeaderPresenter.this.m34391a(searchWordModel);
                }
            }
        });
    }

    /* renamed from: b */
    private void m34394b() {
        this.f46241b = HomeSortClickListener.Type.RECOMMEND;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34391a(SearchWordModel searchWordModel) {
        this.f46246g = false;
        ((Contract.AbsSearchHeaderView) getLogicView()).hideSoftInput();
        SkeletonStore.getStore().dispatch(SearchSuggestionActionCreator.clearSuggestion());
        SearchLogHelper.info(f46240a, "setWord, SearchWordModel = " + searchWordModel.toString());
        ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).setValue(searchWordModel);
    }

    /* renamed from: a */
    private void m34392a(final String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f46246g = true;
            ((Contract.AbsSearchHeaderView) getLogicView()).showOrHideSuggestionLoading(true);
            this.f46242c.append(new SearchSuggestionTask(new CustomerRpcCallback<SearchSuggestionEntity>() {
                public void onRpcFailure(SFRpcException sFRpcException) {
                    super.onRpcFailure(sFRpcException);
                    SearchLogHelper.info(SearchHeaderPresenter.f46240a, "getSuggestion fail");
                    ((Contract.AbsSearchHeaderView) SearchHeaderPresenter.this.getLogicView()).showOrHideSuggestionLoading(false);
                    ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SEARCH_ABNORMAL_SUG).addModuleName("search");
                    addModuleName.addErrorType(sFRpcException.getCode() + "").addErrorMsg(sFRpcException.getOriginalMessage()).build().trackError();
                }

                public void onRpcSuccess(SearchSuggestionEntity searchSuggestionEntity, long j) {
                    SearchLogHelper.info(SearchHeaderPresenter.f46240a, "getSuggestion success");
                    ((Contract.AbsSearchHeaderView) SearchHeaderPresenter.this.getLogicView()).showOrHideSuggestionLoading(false);
                    if (!SearchHeaderPresenter.this.f46245f && SearchHeaderPresenter.this.f46246g) {
                        if (searchSuggestionEntity != null) {
                            String unused = SearchHeaderPresenter.this.f46243d = searchSuggestionEntity.suggestionId;
                            SearchHeaderPresenter.this.m34388a(searchSuggestionEntity);
                        }
                        SkeletonStore.getStore().dispatch(SearchSuggestionActionCreator.updateSuggestion(str, searchSuggestionEntity));
                    }
                }
            }, str, str2, this.f46244e), SerialTaskQueue.AppendMode.ReplaceStrict);
            this.f46244e++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34388a(SearchSuggestionEntity searchSuggestionEntity) {
        if (searchSuggestionEntity != null && !CollectionsUtil.isEmpty(searchSuggestionEntity.templates)) {
            BlocksEngine.Companion.getInstance().initTemplate(searchSuggestionEntity.templates);
        }
    }
}
