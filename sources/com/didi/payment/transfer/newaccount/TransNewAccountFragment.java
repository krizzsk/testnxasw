package com.didi.payment.transfer.newaccount;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.event.PayEventPublisher;
import com.didi.payment.base.widget.CommonEditText;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.transfer.common.PayEventKeys;
import com.didi.payment.transfer.common.TransBaseFragment;
import com.didi.payment.transfer.common.model.TransBankInfo;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.newaccount.TransBankAccountTypeResp;
import com.didi.payment.transfer.newaccount.presenter.ITransNewAccountPresenter;
import com.didi.payment.transfer.newaccount.presenter.TransNewAccountPresenter;
import com.didi.payment.transfer.newaccount.task.LoadJsonDataTask;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.payment.transfer.widget.TransAccountFieldView;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.SimpleWheelPopup;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TransNewAccountFragment extends TransBaseFragment<ITransNewAccountPresenter> implements INewAccountPageView, LoadJsonDataTask.IViewCallback {

    /* renamed from: a */
    private final int f33950a = 1;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TransAccountFieldView f33951b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TransAccountFieldView f33952c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TransAccountFieldView f33953d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TransAccountFieldView f33954e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TransAccountFieldView f33955f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TransAccountFieldView f33956g;

    /* renamed from: h */
    private ConstraintLayout f33957h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public TextView f33958i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LoadJsonDataTask f33959j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Trans2BankModel f33960k = new Trans2BankModel();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public BankDataModel f33961l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f33962m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ArrayList<TransBankAccountTypeResp.AccountType> f33963n;

    /* renamed from: o */
    private CommonEditText.OnTextChangeListener f33964o = new CommonEditText.OnTextChangeListener() {
        public void onTextChanged(String str) {
            if (TransNewAccountFragment.this.f33962m) {
                if (TransNewAccountFragment.this.f33952c.unMaskInput().length() == 11) {
                    if (TransNewAccountFragment.this.f33952c.isCPFValidInput()) {
                        TransNewAccountFragment.this.f33952c.hideErrorInfo();
                    } else {
                        TransNewAccountFragment.this.f33952c.showErrorInfo(TransNewAccountFragment.this.getString(R.string.Fintech_Payment_verification_CPF_is_gzeF));
                    }
                }
                if (TransNewAccountFragment.this.f33953d.unMaskInput().length() == 4) {
                    TransNewAccountFragment.this.f33953d.hideErrorInfo();
                }
            }
            TransNewAccountFragment.this.f33958i.setEnabled(TransNewAccountFragment.this.m25854b());
        }
    };

    /* renamed from: p */
    private TransAccountFieldView.onLoseFocusListener f33965p = new TransAccountFieldView.onLoseFocusListener() {
        public void onLoseFocus(TransAccountFieldView transAccountFieldView) {
            if (transAccountFieldView.getId() == R.id.trans_account_cpf) {
                if (TransNewAccountFragment.this.f33952c.unMaskInput().length() < 11) {
                    TransNewAccountFragment.this.f33952c.showErrorInfo(TransNewAccountFragment.this.getString(R.string.GRider_PAX_Enter_11_wxDm));
                } else if (!TransNewAccountFragment.this.f33952c.isCPFValidInput()) {
                    TransNewAccountFragment.this.f33952c.showErrorInfo(TransNewAccountFragment.this.getString(R.string.Fintech_Payment_verification_CPF_is_gzeF));
                } else if (TransNewAccountFragment.this.f33952c.isCPFValidInput()) {
                    TransNewAccountFragment.this.f33952c.hideErrorInfo();
                }
            } else if (transAccountFieldView.getId() != R.id.trans_account_agentcode) {
            } else {
                if (TransNewAccountFragment.this.f33953d.isAgencyCodeValidInput()) {
                    TransNewAccountFragment.this.f33953d.hideErrorInfo();
                } else {
                    TransNewAccountFragment.this.f33953d.showErrorInfo(TransNewAccountFragment.this.getString(R.string.GRider_PAX_Enter_4_kgPI));
                }
            }
        }
    };

    /* renamed from: q */
    private PayEventPublisher.OnEventListener<String> f33966q = new PayEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (TransNewAccountFragment.this.f33961l != null && !CollectionUtil.isEmpty((Map<?, ?>) TransNewAccountFragment.this.f33961l.fullValues) && TransNewAccountFragment.this.f33961l.fullValues.containsKey(str2)) {
                TransBankInfo transBankInfo = TransNewAccountFragment.this.f33961l.fullValues.get(str2);
                TransNewAccountFragment.this.f33955f.setText(transBankInfo.name);
                TransNewAccountFragment.this.f33960k.toBankCode = (String) transBankInfo.value;
            }
        }
    };

    /* renamed from: r */
    private Trans2BankModel f33967r = null;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_addnew_account_lay;
    }

    public void showSuggestBankDialog() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m25850a();
    }

    /* renamed from: a */
    private void m25850a() {
        if (getArguments() != null) {
            this.f33962m = getArguments().containsKey(TransferContants.IntentKey.INTENT_PARAMS_KEY_2BANK_NEW_VERSION) && getArguments().getBoolean(TransferContants.IntentKey.INTENT_PARAMS_KEY_2BANK_NEW_VERSION);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m25854b() {
        if (this.f33962m) {
            if (!this.f33951b.isValidInput() || !this.f33952c.isCPFValidInput() || !this.f33954e.isValidInput() || !this.f33955f.isValidInput() || !this.f33953d.isAgencyCodeValidInput() || !this.f33956g.isValidInput()) {
                return false;
            }
            return true;
        } else if (!this.f33951b.isValidInput() || !this.f33952c.isValidInput() || !this.f33954e.isValidInput() || !this.f33955f.isValidInput() || !this.f33953d.isValidInput() || !this.f33956g.isValidInput()) {
            return false;
        } else {
            return true;
        }
    }

    public void registeEventListeners() {
        PayEventPublisher.getPublisher().subscribe("selected_bank_data", this.f33966q);
    }

    public void unregisteEventListeners() {
        PayEventPublisher.getPublisher().unsubscribe("selected_bank_data", this.f33966q);
    }

    /* access modifiers changed from: protected */
    public ITransNewAccountPresenter onCreatePresenter() {
        return new TransNewAccountPresenter(getActivity(), this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m25856c();
        return onCreateView;
    }

    /* renamed from: c */
    private void m25856c() {
        if (getArguments() != null && getArguments().containsKey("pix_transfer")) {
            Bundle arguments = getArguments();
            Trans2BankModel trans2BankModel = new Trans2BankModel();
            this.f33967r = trans2BankModel;
            trans2BankModel.toName = arguments.getString("name", "");
            this.f33967r.toCPF = arguments.getString("cpf", "");
            this.f33967r.toBankName = arguments.getString("bank_name", "");
            this.f33967r.toBankCode = arguments.getString("bank_code", "");
            this.f33967r.toBankCard = arguments.getString("bank_card", "");
            this.f33967r.toAgentCode = arguments.getString("agent_code", "");
            m25851a(this.f33967r);
        }
    }

    /* renamed from: a */
    private void m25851a(Trans2BankModel trans2BankModel) {
        this.f33951b.setText(trans2BankModel.toName);
        this.f33952c.setText(trans2BankModel.toCPF);
        this.f33955f.setText(trans2BankModel.toBankName);
        this.f33954e.setText(trans2BankModel.toBankCard);
        this.f33953d.setText(trans2BankModel.toAgentCode);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_bank_account_new_account_sw", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
    }

    /* access modifiers changed from: protected */
    public void initViews(View view) {
        super.initViews(view);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f33957h = (ConstraintLayout) view.findViewById(R.id.containerView);
        TransAccountFieldView transAccountFieldView = (TransAccountFieldView) view.findViewById(R.id.trans_account_name);
        this.f33951b = transAccountFieldView;
        transAccountFieldView.setMaxLength(150);
        TransAccountFieldView transAccountFieldView2 = (TransAccountFieldView) view.findViewById(R.id.trans_account_cpf);
        this.f33952c = transAccountFieldView2;
        transAccountFieldView2.setType(CommonEditText.TYPE.CARD_NUMBER);
        TransAccountFieldView transAccountFieldView3 = (TransAccountFieldView) view.findViewById(R.id.trans_field_bankname);
        this.f33955f = transAccountFieldView3;
        transAccountFieldView3.getInputET().setSingleLine();
        this.f33955f.setEnableExpand(true);
        TransAccountFieldView transAccountFieldView4 = (TransAccountFieldView) view.findViewById(R.id.trans_field_banktype);
        this.f33956g = transAccountFieldView4;
        transAccountFieldView4.getInputET().setSingleLine();
        this.f33956g.setEnableExpand(true);
        TransAccountFieldView transAccountFieldView5 = (TransAccountFieldView) view.findViewById(R.id.trans_field_bankaccount);
        this.f33954e = transAccountFieldView5;
        transAccountFieldView5.setType(CommonEditText.TYPE.CARD_NUMBER);
        TransAccountFieldView transAccountFieldView6 = (TransAccountFieldView) view.findViewById(R.id.trans_account_agentcode);
        this.f33953d = transAccountFieldView6;
        transAccountFieldView6.setType(CommonEditText.TYPE.CARD_NUMBER);
        this.f33953d.setMaxLength(4);
        this.f33953d.getInputET().setFocusable(true);
        this.f33953d.getInputET().setFocusableInTouchMode(true);
        this.f33951b.setLabel(getString(R.string.GRider_PAX_Name_NVSg), "");
        this.f33954e.getInputET().setFocusable(true);
        this.f33954e.getInputET().setFocusableInTouchMode(true);
        this.f33951b.setOnTextChangeListener(this.f33964o);
        this.f33952c.setOnTextChangeListener(this.f33964o);
        this.f33953d.setOnTextChangeListener(this.f33964o);
        this.f33954e.setOnTextChangeListener(this.f33964o);
        this.f33955f.getInputET().setFocusableInTouchMode(false);
        this.f33955f.setOnTextChangeListener(this.f33964o);
        this.f33956g.getInputET().setFocusableInTouchMode(false);
        this.f33956g.setOnTextChangeListener(this.f33964o);
        this.f33956g.setLabel(getString(R.string.Fintech_Payment_type_Account_Type_yTPI), getString(R.string.Fintech_Payment_type_Select_Account_lwkQ));
        if (this.f33962m) {
            this.f33952c.setMaxLength(14);
            this.f33954e.setMaxLength(17);
            this.f33952c.setLabel(getString(R.string.GRider_PAX_CPF_fMMn), "000.000.000-00");
            this.f33953d.setLabel(getString(R.string.GRider_PAX_Agency_code_IfjA), "0000");
            this.f33954e.setLabel(getString(R.string.GRider_PAX_Bank_accounts_JfbH), getString(R.string.Fintech_Payment_verification2_Fill_in_FYtt));
            this.f33955f.setLabel(getString(R.string.GRider_PAX_Name_of_mjpR), getString(R.string.Fintech_Payment_verification2_Select_Bank_jTYP));
            this.f33954e.addBankCardInputListener();
            this.f33952c.addCPFCardInputListener();
            this.f33952c.setLoseFocusListener(this.f33965p);
            this.f33953d.setLoseFocusListener(this.f33965p);
            this.f33954e.setLoseFocusListener(this.f33965p);
        } else {
            this.f33952c.setMaxLength(11);
            this.f33954e.setMaxLength(14);
            this.f33952c.setLabel(getString(R.string.GRider_PAX_CPF_fMMn), getString(R.string.GRider_PAX_Enter_11_wxDm));
            this.f33953d.setLabel(getString(R.string.GRider_PAX_Agency_code_IfjA), getString(R.string.GRider_PAX_Enter_4_kgPI));
            this.f33955f.setLabel(getString(R.string.GRider_PAX_Name_of_mjpR), getString(R.string.GRider_PAX_Enter_the_xPSI));
            this.f33954e.setLabel(getString(R.string.GRider_PAX_Bank_accounts_JfbH), "");
        }
        this.f33955f.setOnExpandListener(new TransAccountFieldView.OnExpandListener() {
            public void onExpandIconClick() {
                Bundle bundle = new Bundle();
                bundle.putString("last_option", TransNewAccountFragment.this.getContext().getString(R.string.GRider_PAX_Choosing_Other_uGBd));
                LoadJsonDataTask unused = TransNewAccountFragment.this.f33959j = new LoadJsonDataTask(TransNewAccountFragment.this.getActivity(), TransNewAccountFragment.this, bundle);
                TransNewAccountFragment.this.f33959j.execute(new String[]{TransferContants.BankData.STATIC_BANK_JSON_FILE});
                TransNewAccountFragment.this.m25857d();
            }
        });
        this.f33955f.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("last_option", TransNewAccountFragment.this.getContext().getString(R.string.GRider_PAX_Choosing_Other_uGBd));
                LoadJsonDataTask unused = TransNewAccountFragment.this.f33959j = new LoadJsonDataTask(TransNewAccountFragment.this.getActivity(), TransNewAccountFragment.this, bundle);
                TransNewAccountFragment.this.f33959j.execute(new String[]{TransferContants.BankData.STATIC_BANK_JSON_FILE});
                TransNewAccountFragment.this.m25857d();
            }
        });
        this.f33956g.setOnExpandListener(new TransAccountFieldView.OnExpandListener() {
            public void onExpandIconClick() {
                TransNewAccountFragment.this.showAccountTypeDialog();
                TransNewAccountFragment.this.m25857d();
            }
        });
        this.f33956g.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransNewAccountFragment.this.showAccountTypeDialog();
                TransNewAccountFragment.this.m25857d();
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.trans_newaccount_confirm_btn);
        this.f33958i = textView;
        textView.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransOmegaUtil.trackEvent("ibt_didipay_p2p_bank_account_new_account_confirm_ck", TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_WALLET_PAGEID);
                TransNewAccountFragment.this.f33960k.toName = TransNewAccountFragment.this.f33951b.getInputValue();
                TransNewAccountFragment.this.f33960k.toCPF = TransNewAccountFragment.this.f33952c.unMaskInput();
                TransNewAccountFragment.this.f33960k.toBankName = TransNewAccountFragment.this.f33955f.getInputValue();
                TransNewAccountFragment.this.f33960k.toBankCard = TransNewAccountFragment.this.f33954e.unMaskInput();
                try {
                    TransNewAccountFragment.this.f33960k.toAgentCode = TransNewAccountFragment.this.f33953d.getInputValue();
                } catch (Exception unused) {
                    WalletToastNew.showFailedMsg(TransNewAccountFragment.this.getContext(), "Invalid input agency code");
                }
                PayEventPublisher.getPublisher().publish(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_CONFIRM_TRANAMOUNT, TransNewAccountFragment.this.f33960k);
            }
        });
    }

    public void showAccountTypeDialog() {
        if (this.f33963n != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<TransBankAccountTypeResp.AccountType> it = this.f33963n.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().key);
            }
            final SimpleWheelPopup simpleWheelPopup = new SimpleWheelPopup();
            simpleWheelPopup.setTitle(getString(R.string.Fintech_Payment_type_Select_Account_lwkQ));
            simpleWheelPopup.setRightText(getString(R.string.GRider_PAX_Confirmation_YVVM));
            simpleWheelPopup.setWheelData((List<String>) arrayList);
            simpleWheelPopup.setOnSelectListener(new SimpleWheelPopup.OnSelectListener() {
                public void onSelect(int i, Object obj) {
                    int selectedIndex = simpleWheelPopup.getSelectedIndex();
                    TransNewAccountFragment.this.f33956g.setText(((TransBankAccountTypeResp.AccountType) TransNewAccountFragment.this.f33963n.get(selectedIndex)).key);
                    TransNewAccountFragment.this.f33960k.toAccountType = ((TransBankAccountTypeResp.AccountType) TransNewAccountFragment.this.f33963n.get(selectedIndex)).key;
                    TransNewAccountFragment.this.f33960k.toAccountTypeValue = String.valueOf(((TransBankAccountTypeResp.AccountType) TransNewAccountFragment.this.f33963n.get(selectedIndex)).value);
                }
            });
            simpleWheelPopup.show(getFragmentManager(), "account_type_fragment");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25857d() {
        this.f33951b.getInputET().clearFocus();
        this.f33952c.getInputET().clearFocus();
        this.f33953d.getInputET().clearFocus();
        this.f33954e.getInputET().clearFocus();
    }

    public void onBankDataLoaded(final BankDataModel bankDataModel) {
        if (getContext() != null && isVisible()) {
            this.f33961l = bankDataModel;
            final SimpleWheelPopup simpleWheelPopup = new SimpleWheelPopup();
            simpleWheelPopup.setTitle(getString(R.string.GRider_PAX_Select_the_LXxn));
            simpleWheelPopup.setRightText(getString(R.string.GRider_PAX_Confirmation_YVVM));
            simpleWheelPopup.setWheelData(bankDataModel.getTopFiveInStringList(1));
            simpleWheelPopup.setOnSelectListener(new SimpleWheelPopup.OnSelectListener() {
                public void onSelect(int i, Object obj) {
                    if (i == bankDataModel.topFive.size() - 1) {
                        PayEventPublisher.getPublisher().publish(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_BANKLIST_TRANAMOUNT, bankDataModel);
                        return;
                    }
                    TransBankInfo transBankInfo = bankDataModel.topFive.get(simpleWheelPopup.getSelectedValue());
                    TransNewAccountFragment.this.f33955f.setText(String.valueOf(transBankInfo.name));
                    TransNewAccountFragment.this.f33960k.toBankCode = (String) transBankInfo.value;
                }
            });
            simpleWheelPopup.show(getFragmentManager(), "country_list_fragment");
        }
    }

    public void gotoFullBankList() {
        startActivityForResult(new Intent(), 1);
    }

    public void onGetAccountTypeList(TransBankAccountTypeResp.DataBean dataBean) {
        this.f33963n = dataBean.accountTypeList;
        if (dataBean.hitBankImprove) {
            this.f33952c.setMaxLength(14);
            this.f33954e.setMaxLength(17);
            this.f33952c.setLabel(getString(R.string.GRider_PAX_CPF_fMMn), "000.000.000-00");
            this.f33953d.setLabel(getString(R.string.GRider_PAX_Agency_code_IfjA), "0000");
            this.f33954e.setLabel(getString(R.string.GRider_PAX_Bank_accounts_JfbH), getString(R.string.Fintech_Payment_verification2_Fill_in_FYtt));
            this.f33955f.setLabel(getString(R.string.GRider_PAX_Name_of_mjpR), getString(R.string.Fintech_Payment_verification2_Select_Bank_jTYP));
            this.f33954e.addBankCardInputListener();
            this.f33952c.addCPFCardInputListener();
            this.f33952c.setLoseFocusListener(this.f33965p);
            this.f33953d.setLoseFocusListener(this.f33965p);
            this.f33954e.setLoseFocusListener(this.f33965p);
        }
        this.f33957h.setVisibility(0);
    }

    public void onShowPageLoadding() {
        notifyParentPageLoading(true);
    }

    public void onDismissPageLoadding() {
        notifyParentPageLoading(false);
    }
}
