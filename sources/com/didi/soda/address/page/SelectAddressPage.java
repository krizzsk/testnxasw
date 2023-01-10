package com.didi.soda.address.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.rfusion.widget.floating.RFFloatingChangeHandler;
import com.didi.soda.address.component.feed.AddressFeedMessageComponent;
import com.didi.soda.address.component.search.SearchAddressComponent;
import com.didi.soda.address.manager.AddressMessageRepo;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.util.AppConfigUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"addressSelectPage", "addressListPage"})
public class SelectAddressPage extends FloatingCustomerPage {

    /* renamed from: k */
    private static final String f41501k = "SelectAddressPage";

    /* renamed from: a */
    FrameLayout f41502a;

    /* renamed from: b */
    FrameLayout f41503b;

    /* renamed from: c */
    CustomerAppCompatTextView f41504c;

    /* renamed from: d */
    ViewGroup f41505d;

    /* renamed from: e */
    LottieAnimationView f41506e;

    /* renamed from: f */
    View f41507f;

    /* renamed from: g */
    View f41508g;

    /* renamed from: h */
    View f41509h;

    /* renamed from: i */
    SearchAddressComponent f41510i;

    /* renamed from: j */
    AddressFeedMessageComponent f41511j;

    public SelectAddressPage() {
        DiRouter.registerHub(RoutePath.ADDRESS_HOME, this);
        DiRouter.registerHub("addressListPage", this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setContentView(this.f41509h);
        setType(2);
        this.f41502a.setVisibility(8);
        this.f41506e.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
            public void onCompositionLoaded(LottieComposition lottieComposition) {
                SelectAddressPage.this.f41506e.setFrame((int) lottieComposition.getEndFrame());
            }
        });
        this.f41505d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SelectAddressPage.this.m31161b(view);
            }
        });
        this.f41507f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SelectAddressPage.this.m31159a(view);
            }
        });
        if (!AppConfigUtil.isGuideAnimShowed()) {
            m31162c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m31161b(View view) {
        this.f41506e.setSpeed(-2.0f);
        this.f41506e.playAnimation();
        this.f41502a.setVisibility(0);
        this.f41510i.showOrHide(true, (SearchAddressComponent.OnSearchAnimationListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m31159a(View view) {
        if (this.f41502a.getVisibility() == 0) {
            m31160b();
            return;
        }
        dismiss();
        OmegaTracker.Builder.create("sailing_c_x_page_return_ck").addEventParam("from", (getScopeContext() == null || getScopeContext().getObject("PageName") == null) ? "" : (String) getScopeContext().getObject("PageName")).build().track();
    }

    public boolean onHandleBack() {
        if (this.f41502a.getVisibility() != 0) {
            return super.onHandleBack();
        }
        m31160b();
        return true;
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        SearchAddressComponent searchAddressComponent = new SearchAddressComponent(this.f41502a);
        this.f41510i = searchAddressComponent;
        addComponent(searchAddressComponent);
        AddressFeedMessageComponent addressFeedMessageComponent = new AddressFeedMessageComponent(this.f41503b);
        this.f41511j = addressFeedMessageComponent;
        addComponent(addressFeedMessageComponent);
    }

    public ControllerChangeHandler getPushHandler() {
        boolean z = false;
        if (getScopeContext() != null) {
            z = getScopeContext().getBundle().getBoolean("remove_font_page", false);
        }
        return new RFFloatingChangeHandler(z);
    }

    /* access modifiers changed from: protected */
    public void updateFloatingConfig() {
        super.updateFloatingConfig();
        getNavBar().setVisible(false);
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_address_home, (ViewGroup) getView(), false);
        this.f41509h = inflate;
        this.f41502a = (FrameLayout) inflate.findViewById(R.id.fl_search_top_container);
        this.f41503b = (FrameLayout) this.f41509h.findViewById(R.id.fl_recommend_address_container);
        this.f41504c = (CustomerAppCompatTextView) this.f41509h.findViewById(R.id.customer_tv_title_label);
        this.f41505d = (ViewGroup) this.f41509h.findViewById(R.id.customer_search_view);
        this.f41506e = (LottieAnimationView) this.f41509h.findViewById(R.id.customer_iv_page_arrow_back);
        this.f41507f = this.f41509h.findViewById(R.id.customer_fl_address_back_container);
        this.f41508g = this.f41509h.findViewById(R.id.customer_fl_address_mask_container);
    }

    /* renamed from: b */
    private void m31160b() {
        this.f41506e.setSpeed(2.0f);
        this.f41506e.playAnimation();
        this.f41510i.showOrHide(false, new SearchAddressComponent.OnSearchAnimationListener() {
            public final void onAnimationCompleted() {
                SelectAddressPage.this.m31163d();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m31163d() {
        this.f41502a.setVisibility(8);
    }

    /* renamed from: c */
    private void m31162c() {
        ((AddressMessageRepo) RepoFactory.getRepo(AddressMessageRepo.class)).subscribeAddressAnimMessage(getScopeContext(), new Action2<AddressMessageRepo.AddressAnimStatus>() {
            public void call(AddressMessageRepo.AddressAnimStatus addressAnimStatus, Subscription subscription) {
                if (addressAnimStatus == AddressMessageRepo.AddressAnimStatus.ANIM_START) {
                    SelectAddressPage.this.f41508g.setVisibility(0);
                } else if (addressAnimStatus == AddressMessageRepo.AddressAnimStatus.ANIM_END) {
                    AppConfigUtil.setGuideAnimShowed();
                    SelectAddressPage.this.f41508g.setVisibility(8);
                    subscription.unsubscribe();
                }
            }
        });
    }
}
