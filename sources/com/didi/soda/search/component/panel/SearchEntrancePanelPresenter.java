package com.didi.soda.search.component.panel;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.soda.business.BusinessOpen;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.rpc.entity.SearchRecommendTagEntity;
import com.didi.soda.customer.foundation.storage.ServerConfigStorage;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.topgun.model.HomeSearchHotWordsModel;
import com.didi.soda.search.component.panel.Contract;
import com.didi.soda.search.helper.SearchLogHelper;
import com.didi.soda.search.helper.SearchNewOmegaHelper;
import com.didi.soda.search.repo.SearchHeaderRepo;
import com.didi.soda.search.repo.SearchHotWordsModel;
import com.didi.soda.search.repo.SearchTagRepo;
import com.didi.soda.search.repo.SearchWordModel;
import com.didi.soda.search.repo.SearchWordRepo;
import com.didi.soda.search.storage.HistoryTag;
import com.didi.soda.search.storage.SearchHistoryStorage;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchEntrancePanelPresenter extends Contract.AbsSearchEntrancePanelPresenter {

    /* renamed from: a */
    private static final String f46262a = "SearchEntrancePanelPresenter";

    /* renamed from: b */
    private SearchTagRepo f46263b;

    /* renamed from: c */
    private SearchHistoryStorage f46264c = new SearchHistoryStorage();

    /* renamed from: d */
    private boolean f46265d = true;

    /* renamed from: e */
    private Subscription f46266e;

    /* renamed from: f */
    private HomeSearchHotWordsModel f46267f;

    /* renamed from: g */
    private String f46268g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<SearchHotWordsModel> f46269h;

    public void onDeleteHistoryClicked() {
        SearchLogHelper.info(f46262a, "Delete Search HISTORY Dialog Show");
        DialogUtil.deleteSearchHistoryDialog(getScopeContext().getNavigator(), new RFDialogInterface.OnClickListener() {
            public final void onClick(RFDialog rFDialog) {
                SearchEntrancePanelPresenter.this.m34407a(rFDialog);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34407a(RFDialog rFDialog) {
        SearchLogHelper.info(f46262a, "Delete Search HISTORY click");
        this.f46264c.setData(null);
        updateSearchHistory(new HistoryTag());
        rFDialog.dismiss();
    }

    public void onSearchRecommendTagClicked(String str, int i) {
        SearchLogHelper.info(f46262a, "on search recommend word clicked");
        SearchWordModel searchWordModel = new SearchWordModel(str);
        searchWordModel.mSearchFrom = SearchWordModel.SearchFrom.RECOMMEND;
        searchWordModel.mIndex = i;
        m34410a(searchWordModel);
        SearchNewOmegaHelper.getInstance().trackRecommendWordClick(str, this.f46263b.getRecId(), i);
    }

    public void onSearchHotWordsClicked(SearchHotWordsModel searchHotWordsModel) {
        if (searchHotWordsModel != null && Objects.equals(searchHotWordsModel.getType(), 2)) {
            SchemeHelper.dispatchMsg(searchHotWordsModel.getUrl());
        }
    }

    public void onSearchHistoryTagClicked(String str, int i) {
        SearchLogHelper.info(f46262a, "on search history word clicked");
        SearchWordModel searchWordModel = new SearchWordModel(str);
        searchWordModel.mSearchFrom = SearchWordModel.SearchFrom.HISTORY;
        searchWordModel.mIndex = i;
        m34410a(searchWordModel);
    }

    public void onSearchShopTagClicked(String str, String str2, int i) {
        SearchLogHelper.info(f46262a, "on search shop word clicked");
        BusinessOpen.Companion.create(str).open();
    }

    public void onRecommendTagsShow(int i, List<SearchHotWordsModel> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("recommend words show:");
        sb.append(list != null ? list.toString() : "");
        SearchLogHelper.info(f46262a, sb.toString());
        SearchNewOmegaHelper.getInstance().trackRecommendTagShow(this.f46263b.getRecId(), i, list);
    }

    public void onHistoryTagsShow(int i, List<String> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("on history word show:");
        sb.append(list != null ? list.toString() : "");
        SearchLogHelper.info(f46262a, sb.toString());
        SearchNewOmegaHelper.getInstance().trackHistoryTagShow(this.f46263b.getRecId(), i, list);
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((Contract.AbsSearchEntrancePanelView) getLogicView()).setRecommendTagsRow(Math.max(((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData().searchRecTagsRow, 2));
        getScopeContext().getBundle();
        try {
            this.f46267f = (HomeSearchHotWordsModel) getScopeContext().getBundle().getSerializable(Const.PageParams.SEARCH_HOME_MODEL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f46268g = getScopeContext().getBundle().getString("fromPage");
        this.f46263b = (SearchTagRepo) RepoFactory.getRepo(SearchTagRepo.class);
        m34406a();
        m34412b();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f46266e == null) {
            this.f46266e = this.f46263b.subscribe(getScopeContext(), new Action1<CustomerResource<SearchRecommendTagEntity>>() {
                public void call(CustomerResource<SearchRecommendTagEntity> customerResource) {
                    SearchLogHelper.info(SearchEntrancePanelPresenter.f46262a, "SearchTagRepo call");
                    if (customerResource.status == Resource.Status.SUCCESS && customerResource.data != null) {
                        ((Contract.AbsSearchEntrancePanelView) SearchEntrancePanelPresenter.this.getLogicView()).setRecommendTags(((SearchRecommendTagEntity) customerResource.data).getTagStringList());
                        List unused = SearchEntrancePanelPresenter.this.f46269h = ((SearchRecommendTagEntity) customerResource.data).getTagStringList();
                        ((Contract.AbsSearchEntrancePanelView) SearchEntrancePanelPresenter.this.getLogicView()).setShopTags(((SearchRecommendTagEntity) customerResource.data).mRecommendShopList);
                        SearchEntrancePanelPresenter.this.m34411a(((SearchRecommendTagEntity) customerResource.data).mRecId);
                        SearchLogHelper.info(SearchEntrancePanelPresenter.f46262a, "RECOMMEND Tag: " + ((SearchRecommendTagEntity) customerResource.data).getTagStringList());
                    } else if (customerResource.status == Resource.Status.ERROR) {
                        ErrorTracker.Builder addModuleName = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SEARCH_ABNORMAL_HOME).addModuleName("search");
                        addModuleName.addErrorType(customerResource.code + "").build().trackError();
                    }
                    SearchEntrancePanelPresenter.this.updateSearchHistory((HistoryTag) null);
                    SearchEntrancePanelPresenter.this.m34417e();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    private void m34410a(SearchWordModel searchWordModel) {
        if (!StringUtils.isEmpty(searchWordModel.mSearchTag)) {
            SearchLogHelper.info(f46262a, "setSearchHeaderTag, " + searchWordModel.toString());
            ((SearchHeaderRepo) RepoFactory.getRepo(SearchHeaderRepo.class)).setValue(searchWordModel);
        }
    }

    /* renamed from: a */
    private void m34406a() {
        ((SearchWordRepo) RepoFactory.getRepo(SearchWordRepo.class)).subscribe(getScopeContext(), new Action1<SearchWordModel>() {
            public void call(SearchWordModel searchWordModel) {
                StringBuilder sb = new StringBuilder();
                sb.append("SearchWordRepo call, SearchWordModel = ");
                sb.append(searchWordModel != null ? searchWordModel.toString() : "");
                SearchLogHelper.info(SearchEntrancePanelPresenter.f46262a, sb.toString());
                if (searchWordModel.mSearchTag == null || TextUtils.isEmpty(searchWordModel.mSearchTag.trim())) {
                    ((Contract.AbsSearchEntrancePanelView) SearchEntrancePanelPresenter.this.getLogicView()).setPanelLayoutVisibility(0);
                    SearchEntrancePanelPresenter.this.m34414c();
                    return;
                }
                ((Contract.AbsSearchEntrancePanelView) SearchEntrancePanelPresenter.this.getLogicView()).setPanelLayoutVisibility(8);
                SearchEntrancePanelPresenter.this.m34416d();
            }
        });
    }

    /* renamed from: b */
    private void m34412b() {
        this.f46263b.getSearchTag();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34414c() {
        SearchLogHelper.info(f46262a, "onPanelLayoutVisible");
        updateSearchHistory((HistoryTag) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m34416d() {
        SearchLogHelper.info(f46262a, "onPanelLayoutGone");
    }

    public void updateSearchHistory(HistoryTag historyTag) {
        if (historyTag == null) {
            historyTag = this.f46264c.getData();
        }
        SearchLogHelper.info(f46262a, "updateSearchHistory: " + historyTag.mTagList);
        ((Contract.AbsSearchEntrancePanelView) getLogicView()).setHistoryTags(historyTag.mTagList);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34411a(String str) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Search.ENTRANCE_SW, getScopeContext());
        HomeSearchHotWordsModel homeSearchHotWordsModel = this.f46267f;
        if (homeSearchHotWordsModel != null) {
            try {
                String str2 = "";
                create.addEventParam("search_word", !TextUtils.isEmpty(homeSearchHotWordsModel.getWord()) ? this.f46267f.getWord() : str2);
                create.addEventParam("activity_id", !TextUtils.isEmpty(this.f46267f.getActivityId()) ? this.f46267f.getActivityId() : str2);
                if (!TextUtils.isEmpty(this.f46267f.getActivityCate())) {
                    str2 = this.f46267f.getActivityCate();
                }
                create.addEventParam("activity_type", str2);
                create.addEventParam("index", Integer.valueOf(this.f46267f.getIndex()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f46268g.contains("homePage")) {
            create.addEventParam("from", 1);
        } else if (this.f46268g.contains(Const.HomeBusinessPageSource.SHOP_SPECIAL_PAGE) || this.f46268g.contains(RoutePath.SHOP_CATEGORY_LANDING_PAGE)) {
            create.addEventParam("from", 2);
        }
        List<SearchHotWordsModel> list = this.f46269h;
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < this.f46269h.size(); i++) {
                SearchHotWordsModel searchHotWordsModel = this.f46269h.get(i);
                if (Objects.equals(searchHotWordsModel.getType(), 2)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(ParamConst.INPUT_WORD, searchHotWordsModel.getWord());
                        jSONObject.put("activity_id", searchHotWordsModel.getActivityId());
                        jSONObject.put("activity_type", searchHotWordsModel.getActivityCate());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                    if (sb.length() <= 0) {
                        sb.append(searchHotWordsModel.getResourceId());
                    } else {
                        sb.append(",");
                        sb.append(searchHotWordsModel.getResourceId());
                    }
                    if (sb2.length() <= 0) {
                        sb2.append(searchHotWordsModel.getUrl());
                    } else {
                        sb2.append(",");
                        sb2.append(searchHotWordsModel.getUrl());
                    }
                }
            }
            create.addEventParam("resource_id", sb.toString());
            create.addEventParam("activity_url", sb2.toString());
            if (jSONArray.length() > 0) {
                create.addEventParam(ParamConst.MARKET_WORD_LIST, jSONArray.toString());
            }
        }
        create.addEventParam(ParamConst.RECOMMEND_REC_ID, str).build().track();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m34417e() {
        if (this.f46265d) {
            this.f46265d = false;
            ((Contract.AbsSearchEntrancePanelView) getLogicView()).doFirstInAnimation();
        }
    }
}
