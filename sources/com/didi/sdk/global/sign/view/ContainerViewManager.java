package com.didi.sdk.global.sign.view;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.RTLUtil;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelGroupData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.view.helper.ExpandShrinkViewHelper;
import com.didi.sdk.payment.util.PayUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ContainerViewManager {

    /* renamed from: a */
    private Context f39066a;

    /* renamed from: b */
    private ICardViewController f39067b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f39068c = false;

    /* renamed from: d */
    private View.OnClickListener f39069d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<PaySelItemData> f39070e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LinearLayout f39071f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EnterprisePayway f39072g;

    public interface ICardViewController {
        void addCardView(LinearLayout linearLayout, PaySelItemData paySelItemData, boolean z);

        void addCreditCardAddView(LinearLayout linearLayout, PaySelItemData paySelItemData);

        void addEnterpriseView(LinearLayout linearLayout, List<PaySelItemData> list, EnterprisePayway enterprisePayway);

        void removeCardViews(LinearLayout linearLayout);
    }

    public ContainerViewManager(Context context, ICardViewController iCardViewController) {
        this.f39066a = context;
        this.f39067b = iCardViewController;
        this.f39069d = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ContainerViewManager containerViewManager = ContainerViewManager.this;
                boolean unused = containerViewManager.f39068c = !containerViewManager.f39068c;
                ContainerViewManager containerViewManager2 = ContainerViewManager.this;
                containerViewManager2.insertPayMethodView(containerViewManager2.f39071f, ContainerViewManager.this.f39070e, ContainerViewManager.this.f39072g);
            }
        };
    }

    public void insertPayMethodView(LinearLayout linearLayout, List<PaySelItemData> list, EnterprisePayway enterprisePayway) {
        List<PaySelItemData> list2;
        this.f39070e = list;
        this.f39071f = linearLayout;
        this.f39072g = enterprisePayway;
        m29401a(linearLayout);
        if (this.f39071f != null && (list2 = this.f39070e) != null && list2.size() != 0) {
            if (this.f39072g != null) {
                m29404a(linearLayout, this.f39066a.getString(R.string.one_payment_global_select_pay_model));
                ICardViewController iCardViewController = this.f39067b;
                if (iCardViewController != null) {
                    iCardViewController.addEnterpriseView(linearLayout, this.f39070e, this.f39072g);
                }
                m29414d(linearLayout);
                m29404a(linearLayout, this.f39066a.getString(R.string.one_payment_global_select_pay_way));
            }
            int maxDisplayCardIndex = ExpandShrinkViewHelper.getMaxDisplayCardIndex(list, this.f39068c);
            int i = 0;
            while (i < list.size()) {
                int i2 = list.get(i).channelId;
                int i3 = i + 1;
                int i4 = list.get(Math.min(list.size() - 1, i3)).channelId;
                if (i2 != 150) {
                    if (i2 == 153 || i2 == 154) {
                        m29402a(linearLayout, list.get(i));
                        if (i2 != i4) {
                            if (i4 == 153 || i4 == 154) {
                                m29409b(linearLayout);
                            } else {
                                m29414d(linearLayout);
                            }
                        }
                    } else {
                        m29402a(linearLayout, list.get(i));
                        if (i < list.size()) {
                            m29414d(linearLayout);
                        }
                    }
                } else if (i > maxDisplayCardIndex) {
                    m29403a(linearLayout, list.get(i), false);
                } else {
                    m29402a(linearLayout, list.get(i));
                    if (i == maxDisplayCardIndex) {
                        if (ExpandShrinkViewHelper.isShowSwitchView(list)) {
                            m29409b(linearLayout);
                            View a = m29400a(linearLayout, this.f39068c);
                            if (a != null) {
                                a.setOnClickListener(this.f39069d);
                            }
                        }
                        if (i < list.size() - 1) {
                            m29414d(linearLayout);
                        }
                    } else {
                        m29409b(linearLayout);
                    }
                }
                i = i3;
            }
        }
    }

    public void insertPayMethodViewByGroup(LinearLayout linearLayout, List<PaySelItemData> list, List<PaySelGroupData> list2, EnterprisePayway enterprisePayway) {
        if (linearLayout != null && !CollectionUtil.isEmpty((Collection) list) && !CollectionUtil.isEmpty((Collection) list2)) {
            this.f39070e = list;
            this.f39071f = linearLayout;
            this.f39072g = enterprisePayway;
            m29401a(linearLayout);
            if (this.f39072g != null) {
                m29404a(linearLayout, this.f39066a.getString(R.string.one_payment_global_select_pay_model));
                ICardViewController iCardViewController = this.f39067b;
                if (iCardViewController != null) {
                    iCardViewController.addEnterpriseView(linearLayout, this.f39070e, this.f39072g);
                }
                m29414d(linearLayout);
                m29404a(linearLayout, this.f39066a.getString(R.string.one_payment_global_select_pay_way));
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (PaySelItemData next : this.f39070e) {
                if (next != null) {
                    if (next.channelId != 150 || TextUtils.isEmpty(next.cardIndex)) {
                        hashMap.put(Integer.valueOf(next.channelId), next);
                    } else {
                        arrayList.add(next);
                    }
                }
            }
            m29405a(linearLayout, list2, hashMap, arrayList);
            if (!CollectionUtil.isEmpty((Map) hashMap)) {
                int i = 0;
                for (PaySelItemData a : hashMap.values()) {
                    m29402a(linearLayout, a);
                    if (i != list.size() - 1) {
                        m29409b(linearLayout);
                    }
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    private void m29405a(LinearLayout linearLayout, List<PaySelGroupData> list, Map<Integer, PaySelItemData> map, List<PaySelItemData> list2) {
        PaySelItemData createGroupHeaderItem;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < list.size(); i++) {
            PaySelGroupData paySelGroupData = list.get(i);
            if (!(paySelGroupData == null || paySelGroupData.channelIds == null || paySelGroupData.channelIds.length == 0 || (createGroupHeaderItem = createGroupHeaderItem(paySelGroupData)) == null)) {
                ArrayList arrayList = new ArrayList();
                for (int i2 : paySelGroupData.channelIds) {
                    PaySelItemData remove = map.remove(Integer.valueOf(i2));
                    if (remove != null) {
                        if (i2 == 150 && list2 != null) {
                            arrayList.addAll(list2);
                        }
                        arrayList.add(remove);
                    }
                }
                linkedHashMap.put(createGroupHeaderItem, arrayList);
            }
        }
        if (!CollectionUtil.isEmpty((Map) linkedHashMap)) {
            for (PaySelItemData paySelItemData : linkedHashMap.keySet()) {
                List list3 = (List) linkedHashMap.get(paySelItemData);
                if (list3 != null) {
                    m29402a(linearLayout, paySelItemData);
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        PaySelItemData paySelItemData2 = (PaySelItemData) list3.get(i3);
                        if (paySelItemData2 != null) {
                            paySelItemData2.isTitleBold = false;
                            if (paySelItemData2.isAddCreditCard()) {
                                m29412c(linearLayout);
                                m29410b(linearLayout, paySelItemData2);
                            } else {
                                m29409b(linearLayout);
                                paySelItemData2.iconUrl = null;
                                m29402a(linearLayout, paySelItemData2);
                            }
                        }
                    }
                    m29414d(linearLayout);
                }
            }
        }
    }

    public PaySelItemData createGroupHeaderItem(PaySelGroupData paySelGroupData) {
        if (paySelGroupData == null) {
            return null;
        }
        PaySelItemData paySelItemData = new PaySelItemData();
        paySelItemData.iconUrl = paySelGroupData.iconUrl;
        paySelItemData.title = paySelGroupData.name;
        paySelItemData.style = 0;
        return paySelItemData;
    }

    public void insertPromotionView(LinearLayout linearLayout, List<PaySelItemData> list) {
        m29401a(linearLayout);
        for (int i = 0; i < list.size(); i++) {
            m29402a(linearLayout, list.get(i));
            if (i != list.size() - 1) {
                m29409b(linearLayout);
            }
        }
    }

    /* renamed from: a */
    private void m29402a(LinearLayout linearLayout, PaySelItemData paySelItemData) {
        m29403a(linearLayout, paySelItemData, true);
    }

    /* renamed from: a */
    private void m29403a(LinearLayout linearLayout, PaySelItemData paySelItemData, boolean z) {
        ICardViewController iCardViewController = this.f39067b;
        if (iCardViewController != null && linearLayout != null && paySelItemData != null) {
            iCardViewController.addCardView(linearLayout, paySelItemData, z);
        }
    }

    /* renamed from: b */
    private void m29410b(LinearLayout linearLayout, PaySelItemData paySelItemData) {
        ICardViewController iCardViewController = this.f39067b;
        if (iCardViewController != null && linearLayout != null && paySelItemData != null) {
            iCardViewController.addCreditCardAddView(linearLayout, paySelItemData);
        }
    }

    /* renamed from: a */
    private void m29401a(LinearLayout linearLayout) {
        ICardViewController iCardViewController = this.f39067b;
        if (iCardViewController != null && linearLayout != null) {
            iCardViewController.removeCardViews(linearLayout);
        }
    }

    /* renamed from: b */
    private void m29409b(LinearLayout linearLayout) {
        if (linearLayout != null) {
            View view = new View(this.f39066a);
            view.setBackgroundColor(this.f39066a.getResources().getColor(R.color.one_payment_04000000));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            layoutParams.setMargins(PayUtil.dip2px(this.f39066a, 18.0f), 0, 0, 0);
            if (RTLUtil.isInRTLMode()) {
                layoutParams.setMarginStart(PayUtil.dip2px(this.f39066a, 18.0f));
            }
            linearLayout.addView(view, layoutParams);
        }
    }

    /* renamed from: c */
    private void m29412c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            View view = new View(this.f39066a);
            view.setBackgroundColor(this.f39066a.getResources().getColor(R.color.one_payment_04000000));
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, 1));
        }
    }

    /* renamed from: d */
    private void m29414d(LinearLayout linearLayout) {
        if (linearLayout != null) {
            View view = new View(this.f39066a);
            view.setBackgroundColor(this.f39066a.getResources().getColor(R.color.one_payment_wallet_bg));
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, PayUtil.dip2px(this.f39066a, 10.0f)));
        }
    }

    /* renamed from: a */
    private void m29404a(LinearLayout linearLayout, String str) {
        if (linearLayout != null) {
            TextView textView = new TextView(this.f39066a);
            textView.setBackgroundColor(this.f39066a.getResources().getColor(R.color.one_payment_wallet_bg));
            textView.setText(str);
            if (RTLUtil.isInRTLMode()) {
                textView.setGravity(GravityCompat.START);
                if (Build.VERSION.SDK_INT >= 17) {
                    textView.setTextDirection(5);
                    textView.setTextAlignment(5);
                }
            }
            textView.setTextSize(2, 14.0f);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, PayUtil.dip2px(this.f39066a, 20.0f)));
        }
    }

    /* renamed from: a */
    private View m29400a(LinearLayout linearLayout, boolean z) {
        if (linearLayout == null) {
            return null;
        }
        ExpandShrinkView expandShrinkView = new ExpandShrinkView(this.f39066a);
        expandShrinkView.setIsExpand(z);
        linearLayout.addView(expandShrinkView);
        return expandShrinkView;
    }
}
