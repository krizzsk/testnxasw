package com.didi.soda.search.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.soda.customer.animation.transitions.compat.SearchSharedElementCompat;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.base.rxdux.RxduxPage;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.listener.OnBackListener;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.didi.soda.search.component.header.SearchHeaderComponent;
import com.didi.soda.search.component.panel.SearchEntrancePanelComponent;
import com.didi.soda.search.component.result.SearchResultComponent;
import com.didi.soda.search.component.suggestion.SearchSugListener;
import com.didi.soda.search.component.suggestion.SearchSuggestionComponent;
import com.didi.soda.search.repo.SearchWordRepo;
import com.taxis99.R;

@Route({"searchPage"})
public class SearchHomePage extends RxduxPage implements OnBackListener, SearchSugListener {

    /* renamed from: b */
    SearchHeaderComponent f46334b;

    /* renamed from: c */
    SearchEntrancePanelComponent f46335c;

    /* renamed from: d */
    SearchResultComponent f46336d;

    /* renamed from: e */
    SearchSuggestionComponent f46337e;

    /* renamed from: f */
    private boolean f46338f = true;
    @BindView(18205)
    FrameLayout mSearchHeaderContainer;
    @BindView(18158)
    FrameLayout mSearchPanelContainer;
    @BindView(18208)
    FrameLayout mSearchResultContainer;
    @BindView(18211)
    FrameLayout mSearchSuggestionContainer;

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return 0;
    }

    public /* synthetic */ void onBack(int i) {
        OnBackListener.CC.$default$onBack((OnBackListener) this, i);
    }

    public /* synthetic */ void onBack(Bundle bundle) {
        OnBackListener.CC.$default$onBack((OnBackListener) this, bundle);
    }

    public SearchHomePage() {
        DiRouter.registerHub(RoutePath.SEARCH_HOME, this);
    }

    public ControllerChangeHandler getPopHandler() {
        if (SearchSharedElementCompat.supportSharedElementTransition(getScopeContext())) {
            return new SearchHomeChangeHandler(getScopeContext().getBundle().getString(Const.PageParams.TRANSITION_NAMES));
        }
        return super.getPopHandler();
    }

    public ControllerChangeHandler getPushHandler() {
        if (SearchSharedElementCompat.supportSharedElementTransition(getScopeContext())) {
            return new SearchHomeChangeHandler(getScopeContext().getBundle().getString(Const.PageParams.TRANSITION_NAMES));
        }
        return super.getPushHandler();
    }

    public void onDestroy() {
        super.onDestroy();
        RepoFactory.clearRepo(SearchWordRepo.class);
    }

    public void onResume() {
        super.onResume();
        this.f46338f = false;
    }

    public boolean onHandleBack() {
        if (this.f46338f) {
            return true;
        }
        onBack(Boolean.valueOf(((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).mIsResultViewVisible));
        this.f46334b.handleBack();
        super.onHandleBack();
        return true;
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_search_home, viewGroup, false);
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        getPageView().setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_10_a100));
        SearchHeaderComponent searchHeaderComponent = new SearchHeaderComponent(this.mSearchHeaderContainer);
        this.f46334b = searchHeaderComponent;
        searchHeaderComponent.setSearchHomeBackListener(this);
        addComponent(this.f46334b);
        if (SearchSharedElementCompat.supportSharedElementTransition(getScopeContext())) {
            this.f46334b.getScopeContext().getBundle().putString(Const.PageParams.TRANSITION_NAMES, getScopeContext().getBundle().getString(Const.PageParams.TRANSITION_NAMES));
        }
        SearchEntrancePanelComponent searchEntrancePanelComponent = new SearchEntrancePanelComponent(this.mSearchPanelContainer);
        this.f46335c = searchEntrancePanelComponent;
        addComponent(searchEntrancePanelComponent);
        if (SearchSharedElementCompat.supportSharedElementTransition(getScopeContext())) {
            this.f46335c.getScopeContext().getBundle().putString(Const.PageParams.TRANSITION_NAMES, getScopeContext().getBundle().getString(Const.PageParams.TRANSITION_NAMES));
        }
        SearchResultComponent searchResultComponent = new SearchResultComponent(this.mSearchResultContainer);
        this.f46336d = searchResultComponent;
        searchResultComponent.setSearchHeaderInterface(this.f46334b);
        this.f46336d.setLoadingViewSupporter(this.f46334b);
        addComponent(this.f46336d);
        SearchSuggestionComponent searchSuggestionComponent = new SearchSuggestionComponent(this.mSearchSuggestionContainer);
        this.f46337e = searchSuggestionComponent;
        searchSuggestionComponent.setOnNoSugListener(this);
        addComponent(this.f46337e);
    }

    public void onBack(Boolean bool) {
        if (!bool.booleanValue()) {
            getScopeContext().getNavigator().finish();
            return;
        }
        int i = C149791.$SwitchMap$com$didi$soda$search$repo$SearchWordModel$SearchFrom[((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).getValue().mSearchFrom.ordinal()];
        if (i == 1 || i == 2) {
            this.f46336d.setSearchResultLayoutVisibility(8);
            this.f46335c.setPanelLayoutVisibility(0);
            this.f46334b.showSoftInput();
        } else if (i == 3 || i == 4 || i == 5) {
            this.f46336d.setSearchResultLayoutVisibility(8);
            this.f46337e.setSearchSuggestionLayoutVisibility(0);
            this.f46334b.refreshSuggestion();
        } else {
            getScopeContext().getNavigator().finish();
        }
    }

    /* renamed from: com.didi.soda.search.page.SearchHomePage$1 */
    static /* synthetic */ class C149791 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$soda$search$repo$SearchWordModel$SearchFrom;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.soda.search.repo.SearchWordModel$SearchFrom[] r0 = com.didi.soda.search.repo.SearchWordModel.SearchFrom.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$soda$search$repo$SearchWordModel$SearchFrom = r0
                com.didi.soda.search.repo.SearchWordModel$SearchFrom r1 = com.didi.soda.search.repo.SearchWordModel.SearchFrom.HISTORY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$soda$search$repo$SearchWordModel$SearchFrom     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.soda.search.repo.SearchWordModel$SearchFrom r1 = com.didi.soda.search.repo.SearchWordModel.SearchFrom.RECOMMEND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$soda$search$repo$SearchWordModel$SearchFrom     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.soda.search.repo.SearchWordModel$SearchFrom r1 = com.didi.soda.search.repo.SearchWordModel.SearchFrom.EDIT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$soda$search$repo$SearchWordModel$SearchFrom     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.soda.search.repo.SearchWordModel$SearchFrom r1 = com.didi.soda.search.repo.SearchWordModel.SearchFrom.SUGGESTION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$soda$search$repo$SearchWordModel$SearchFrom     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.soda.search.repo.SearchWordModel$SearchFrom r1 = com.didi.soda.search.repo.SearchWordModel.SearchFrom.HOT_WORD     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.search.page.SearchHomePage.C149791.<clinit>():void");
        }
    }

    public void onNoSug() {
        this.f46337e.setSearchSuggestionLayoutVisibility(8);
        if (((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).mIsResultViewVisible) {
            this.f46336d.setSearchResultLayoutVisibility(0);
            this.f46335c.setPanelLayoutVisibility(8);
            return;
        }
        this.f46336d.setSearchResultLayoutVisibility(8);
        this.f46335c.setPanelLayoutVisibility(0);
    }

    public void onPageResult(Bundle bundle) {
        if (bundle != null && RoutePath.BUSINESS_HOME.equals(bundle.getString("fromPage"))) {
            this.f46334b.resetIsFirstInputShow();
        }
        SearchResultComponent searchResultComponent = this.f46336d;
        if (searchResultComponent != null) {
            searchResultComponent.onPageResult(bundle);
        }
    }
}
