package com.didi.sdk.global.sign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.view.PayMethodBaseFragmentView;
import com.didi.sdk.util.Utils;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;
import java.util.List;

public class EnterpriseCardView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f39073a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f39074b;

    /* renamed from: c */
    private ImageView f39075c;

    /* renamed from: d */
    private TextView f39076d;

    /* renamed from: e */
    private TextView f39077e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Switch f39078f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public PayMethodBaseFragmentView.PayMethodSelectListener f39079g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public AlertDialogFragment f39080h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public AlertDialogFragment f39081i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AlertDialogFragment f39082j;

    interface Callback {
        void onClick();
    }

    public EnterpriseCardView(Context context) {
        super(context);
        m29419a(context);
    }

    public EnterpriseCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29419a(context);
    }

    public EnterpriseCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29419a(context);
    }

    /* renamed from: a */
    private void m29419a(Context context) {
        this.f39073a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.pay_way_enterprise, this, true);
        this.f39074b = inflate;
        this.f39075c = (ImageView) inflate.findViewById(R.id.iv_paymethod_icon);
        this.f39076d = (TextView) this.f39074b.findViewById(R.id.tv_paymethod_name);
        this.f39077e = (TextView) this.f39074b.findViewById(R.id.tv_paymethod_desc);
        this.f39078f = (Switch) this.f39074b.findViewById(R.id.switch_enterprise_item);
    }

    public void setMethodClickListener(PayMethodBaseFragmentView.PayMethodSelectListener payMethodSelectListener) {
        this.f39079g = payMethodSelectListener;
    }

    public void setData(final List<PaySelItemData> list, EnterprisePayway enterprisePayway) {
        if (enterprisePayway != null) {
            GlideUtils.with2load2into(this.f39073a, enterprisePayway.iconUrl, this.f39075c);
            this.f39076d.setText(enterprisePayway.title);
            if (enterprisePayway.toggle) {
                this.f39077e.setText(enterprisePayway.descEnable);
            } else {
                this.f39077e.setText(enterprisePayway.descDisable);
            }
            this.f39078f.setChecked(enterprisePayway.toggle);
            this.f39074b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int i;
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!Utils.isFastDoubleClick()) {
                        boolean z = !EnterpriseCardView.this.f39078f.isChecked();
                        PaySelItemData paySelItemData = null;
                        int i2 = 0;
                        if (list != null) {
                            int i3 = 0;
                            i = 0;
                            while (i2 < list.size()) {
                                PaySelItemData paySelItemData2 = (PaySelItemData) list.get(i2);
                                if (paySelItemData2.channelId == 153 && paySelItemData2.isSelected) {
                                    i3 = 1;
                                }
                                if (paySelItemData2.channelId != 153 && paySelItemData2.status == 1 && (i = i + 1) == 1) {
                                    paySelItemData = paySelItemData2;
                                }
                                i2++;
                            }
                            i2 = i3;
                        } else {
                            i = 0;
                        }
                        if (!z || i2 == 0) {
                            EnterpriseCardView.this.m29418a();
                        } else if (i == 0) {
                            EnterpriseCardView enterpriseCardView = EnterpriseCardView.this;
                            enterpriseCardView.m29424b(enterpriseCardView.f39073a);
                        } else if (i != 1) {
                            EnterpriseCardView enterpriseCardView2 = EnterpriseCardView.this;
                            enterpriseCardView2.m29426c(enterpriseCardView2.f39073a);
                        } else {
                            EnterpriseCardView enterpriseCardView3 = EnterpriseCardView.this;
                            enterpriseCardView3.m29420a(enterpriseCardView3.f39073a, paySelItemData);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29418a() {
        boolean z = !this.f39078f.isChecked();
        this.f39078f.setChecked(z);
        PayMethodBaseFragmentView.PayMethodSelectListener payMethodSelectListener = this.f39079g;
        if (payMethodSelectListener != null) {
            payMethodSelectListener.enterpriseClick(this.f39074b, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m29424b(Context context) {
        FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        if (this.f39080h == null) {
            this.f39080h = m29416a(context, context.getString(R.string.one_payment_global_enterprise_no_card), context.getString(R.string.one_payment_global_enterprise_ok), new Callback() {
                public void onClick() {
                    EnterpriseCardView.this.f39080h.dismiss();
                }
            });
        }
        this.f39080h.show(supportFragmentManager, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m29426c(Context context) {
        FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        if (this.f39082j == null) {
            this.f39082j = m29416a(context, context.getString(R.string.one_payment_global_enterprise_mul_card), context.getString(R.string.one_payment_global_enterprise_ok), new Callback() {
                public void onClick() {
                    EnterpriseCardView.this.f39082j.dismiss();
                }
            });
        }
        this.f39082j.show(supportFragmentManager, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29420a(Context context, final PaySelItemData paySelItemData) {
        FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        Context context2 = context;
        AlertDialogFragment a = m29417a(context2, context.getString(R.string.one_payment_global_enterprise_one_card, new Object[]{paySelItemData.title}), context.getString(R.string.one_payment_global_enterprise_cancel), new Callback() {
            public void onClick() {
                EnterpriseCardView.this.f39081i.dismiss();
            }
        }, context.getString(R.string.one_payment_global_enterprise_ok), new Callback() {
            public void onClick() {
                EnterpriseCardView.this.f39081i.dismiss();
                EnterpriseCardView.this.m29418a();
                if (EnterpriseCardView.this.f39079g != null) {
                    EnterpriseCardView.this.f39079g.updateItemInfo(paySelItemData);
                    EnterpriseCardView.this.f39079g.onClick(EnterpriseCardView.this.f39074b);
                }
            }
        });
        this.f39081i = a;
        a.show(supportFragmentManager, (String) null);
    }

    /* renamed from: a */
    private AlertDialogFragment m29416a(Context context, String str, String str2, Callback callback) {
        return m29417a(context, str, str2, callback, (String) null, (Callback) null);
    }

    /* renamed from: a */
    private AlertDialogFragment m29417a(Context context, String str, String str2, final Callback callback, String str3, final Callback callback2) {
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(context);
        builder.setIcon((int) R.drawable.common_dialog_icon_info);
        builder.setMessage(str);
        builder.setCancelable(false);
        builder.setNegativeButton((CharSequence) str2, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                callback.onClick();
            }
        });
        if (!(str3 == null || callback2 == null)) {
            builder.setPositiveButton((CharSequence) str3, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    callback2.onClick();
                }
            }).setDefaultButtonTxtColor(R.color.pay_text_orage).setPositiveButtonDefault();
        }
        return builder.create();
    }
}
