package com.didi.entrega.address.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.entrega.address.list.component.feed.AddressFeedMessageComponent;
import com.didi.entrega.address.list.component.search.SearchAddressComponent;
import com.didi.entrega.address.utils.omega.AddressOmegaHelper;
import com.didi.entrega.customer.base.pages.FloatingCustomerPage;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;
import com.didi.rfusion.widget.floating.RFFloatingChangeHandler;
import com.taxis99.R;

@Route({"addressListPage"})
public class SelectAddressPage extends FloatingCustomerPage {

    /* renamed from: n */
    private static final String f21273n = "SelectAddressPage";

    /* renamed from: a */
    FrameLayout f21274a;

    /* renamed from: b */
    FrameLayout f21275b;

    /* renamed from: c */
    CustomerAppCompatTextView f21276c;

    /* renamed from: d */
    ViewGroup f21277d;

    /* renamed from: e */
    LottieAnimationView f21278e;

    /* renamed from: f */
    View f21279f;

    /* renamed from: g */
    View f21280g;

    /* renamed from: h */
    View f21281h;

    /* renamed from: i */
    CustomerAppCompatTextView f21282i;

    /* renamed from: j */
    SearchAddressComponent f21283j;

    /* renamed from: k */
    AddressFeedMessageComponent f21284k;

    public SelectAddressPage() {
        DiRouter.registerHub("addressListPage", this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setContentView(this.f21281h);
        setType(2);
        int i = getScopeContext().getBundle().getInt("from", -1);
        this.f21274a.setVisibility(8);
        this.f21278e.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
            public void onCompositionLoaded(LottieComposition lottieComposition) {
                SelectAddressPage.this.f21278e.setFrame((int) lottieComposition.getEndFrame());
            }
        });
        this.f21277d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SelectAddressPage.this.m17961a(view);
            }
        });
        this.f21279f.setOnClickListener(new View.OnClickListener(i) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                SelectAddressPage.this.m17960a(this.f$1, view);
            }
        });
        m17962b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m17961a(View view) {
        this.f21278e.setSpeed(-2.0f);
        this.f21278e.playAnimation();
        this.f21274a.setVisibility(0);
        this.f21283j.showOrHide(true, (SearchAddressComponent.OnSearchAnimationListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m17960a(int i, View view) {
        if (this.f21274a.getVisibility() == 0) {
            m17963c();
            return;
        }
        dismiss();
        AddressOmegaHelper.INSTANCE.trackDeliverySearchReturnCK(i);
    }

    /* renamed from: b */
    private void m17962b() {
        int i = getScopeContext().getBundle().getInt("from", -1);
        if (i == 2 || i == 4 || i == 6) {
            this.f21276c.setText(ResourceHelper.getString(R.string.FoodC_search_Address_of_XLJA));
            this.f21282i.setText(ResourceHelper.getString(R.string.FoodC_search_Where_does_JuOK));
            this.f21283j.setSearchTextHint(ResourceHelper.getString(R.string.FoodC_search_Where_does_JuOK));
            return;
        }
        this.f21276c.setText(ResourceHelper.getString(R.string.FoodC_search_Mail_address_DnuS));
        this.f21282i.setText(ResourceHelper.getString(R.string.FoodC_search_Where_does_XByG));
        this.f21283j.setSearchTextHint(ResourceHelper.getString(R.string.FoodC_search_Where_does_XByG));
    }

    public boolean onHandleBack() {
        if (this.f21274a.getVisibility() != 0) {
            return super.onHandleBack();
        }
        m17963c();
        return true;
    }

    public void setupComponents(View view) {
        super.setupComponents(view);
        SearchAddressComponent searchAddressComponent = new SearchAddressComponent(this.f21274a);
        this.f21283j = searchAddressComponent;
        addComponent(searchAddressComponent);
        AddressFeedMessageComponent addressFeedMessageComponent = new AddressFeedMessageComponent(this.f21275b);
        this.f21284k = addressFeedMessageComponent;
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
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.entrega_customer_page_address_home, (ViewGroup) getView(), false);
        this.f21281h = inflate;
        this.f21274a = (FrameLayout) inflate.findViewById(R.id.fl_search_top_container);
        this.f21275b = (FrameLayout) this.f21281h.findViewById(R.id.fl_recommend_address_container);
        this.f21276c = (CustomerAppCompatTextView) this.f21281h.findViewById(R.id.customer_tv_title_label);
        this.f21277d = (ViewGroup) this.f21281h.findViewById(R.id.customer_search_view);
        this.f21278e = (LottieAnimationView) this.f21281h.findViewById(R.id.customer_iv_page_arrow_back);
        this.f21279f = this.f21281h.findViewById(R.id.customer_fl_address_back_container);
        this.f21280g = this.f21281h.findViewById(R.id.customer_fl_address_mask_container);
        this.f21282i = (CustomerAppCompatTextView) this.f21281h.findViewById(R.id.customer_custom_address_search);
    }

    /* renamed from: c */
    private void m17963c() {
        this.f21278e.setSpeed(2.0f);
        this.f21278e.playAnimation();
        this.f21283j.showOrHide(false, new SearchAddressComponent.OnSearchAnimationListener() {
            public final void onAnimationCompleted() {
                SelectAddressPage.this.m17964d();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m17964d() {
        this.f21274a.setVisibility(8);
    }
}
