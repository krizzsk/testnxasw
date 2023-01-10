package com.didi.payment.transfer.fillphone;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.payment.base.event.PayEventPublisher;
import com.didi.payment.base.widget.CommonEditText;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.fragment.ContactPermissionFragment;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.transfer.DebugUtil;
import com.didi.payment.transfer.accounts.presenter.NNPayAccount;
import com.didi.payment.transfer.common.PayEventKeys;
import com.didi.payment.transfer.common.TransBaseFragment;
import com.didi.payment.transfer.common.model.ConfirmInfo;
import com.didi.payment.transfer.fillphone.CountryCodePickerDialog;
import com.didi.payment.transfer.fillphone.presenter.IPhoneConfirmPresenter;
import com.didi.payment.transfer.fillphone.presenter.TransCfmPhonePresenter;
import com.didi.payment.transfer.historyaccounts.TransHistoryAccountAdapter;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifiedPay.util.LogUtil;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TransCfmPhoneFragment extends TransBaseFragment<IPhoneConfirmPresenter> implements CountryCodePickerDialog.CountryCodeSelectedListener, IPhoneCfmView {

    /* renamed from: q */
    private static final int f33914q = 100;

    /* renamed from: a */
    List<String> f33915a;

    /* renamed from: b */
    private View f33916b;

    /* renamed from: c */
    private TextView f33917c;

    /* renamed from: d */
    private TextView f33918d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f33919e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CommonEditText f33920f;

    /* renamed from: g */
    private TextView f33921g;

    /* renamed from: h */
    private ImageView f33922h;

    /* renamed from: i */
    private CountryCodePickerDialog f33923i;

    /* renamed from: j */
    private final int f33924j = 11;

    /* renamed from: k */
    private TransHistoryAccountAdapter f33925k;

    /* renamed from: l */
    private RecyclerView f33926l;

    /* renamed from: m */
    private TextView f33927m;

    /* renamed from: n */
    private List<NNPayAccount> f33928n = null;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public AtomicInteger f33929o = new AtomicInteger(0);

    /* renamed from: p */
    private View f33930p;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_fragment_fillphone_lay;
    }

    public static TransCfmPhoneFragment getInstance(Bundle bundle) {
        TransCfmPhoneFragment transCfmPhoneFragment = new TransCfmPhoneFragment();
        transCfmPhoneFragment.setArguments(bundle);
        return transCfmPhoneFragment;
    }

    /* access modifiers changed from: protected */
    public IPhoneConfirmPresenter onCreatePresenter() {
        return new TransCfmPhonePresenter(getContext(), this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_99pay_mobile_input_sw", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* access modifiers changed from: protected */
    public void initViews(View view) {
        this.f33916b = view;
        super.initViews(view);
        m25795a(view);
        m25794a();
    }

    public void onResume() {
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle) {
        this.f33929o.set(2);
        super.onViewCreated(view, bundle);
    }

    public void onShowPageLoadding() {
        notifyParentPageLoading(true);
    }

    public void onDismissPageLoadding() {
        if (this.f33929o.get() <= 0) {
            notifyParentPageLoading(false);
        }
    }

    /* renamed from: a */
    private void m25795a(View view) {
        this.f33930p = view.findViewById(R.id.trans_cfm_phone_content_rl_root);
        this.f33917c = (TextView) view.findViewById(R.id.trans_tv_phone_number_title);
        this.f33918d = (TextView) view.findViewById(R.id.trans_tv_phone_number_sub_title);
        TextView textView = (TextView) view.findViewById(R.id.trans_country_switch_view);
        this.f33919e = textView;
        textView.setEnabled(false);
        CommonEditText commonEditText = (CommonEditText) view.findViewById(R.id.trans_et_phone_number);
        this.f33920f = commonEditText;
        commonEditText.setType(CommonEditText.TYPE.CARD_NUMBER);
        this.f33920f.setMaxLength(11);
        TextView textView2 = (TextView) view.findViewById(R.id.trans_btn_cfm_transamount_next);
        this.f33921g = textView2;
        textView2.setEnabled(false);
        this.f33922h = (ImageView) view.findViewById(R.id.tv_phone_number_edit_func_img);
        this.f33923i = new CountryCodePickerDialog();
        this.f33927m = (TextView) view.findViewById(R.id.trans_history_records_title);
        this.f33926l = (RecyclerView) view.findViewById(R.id.trans_history_receiver_record_lv);
        TransHistoryAccountAdapter transHistoryAccountAdapter = new TransHistoryAccountAdapter(getActivity(), 0, new ArrayList());
        this.f33925k = transHistoryAccountAdapter;
        transHistoryAccountAdapter.setOnItemclickListener(new TransHistoryAccountAdapter.OnItemClickListener() {
            public void onItemClick(NNPayAccount nNPayAccount) {
                TransOmegaUtil.removeGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
                TransOmegaUtil.addGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS, 1);
                TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_99pay_existing_payee_mobile_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
                TransCfmPhoneFragment.this.gotoEditAmountPage(nNPayAccount);
            }
        });
        this.f33926l.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f33926l.setAdapter(this.f33925k);
    }

    /* renamed from: a */
    private void m25794a() {
        this.f33916b.setOnTouchListener(new OnTouchEventImpl());
        this.f33919e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (CollectionUtil.isEmpty((Collection<?>) TransCfmPhoneFragment.this.f33915a)) {
                    LogUtil.m35172fi("wallet_transfer", "country code list empty, return!");
                } else {
                    TransCfmPhoneFragment.this.m25799c();
                }
            }
        });
        this.f33920f.registeTextChangeListener(new CommonEditText.OnTextChangeListener() {
            public void onTextChanged(String str) {
                TransCfmPhoneFragment.this.f33920f.setTextColor(-16777216);
                TransCfmPhoneFragment.this.m25801d();
            }
        });
        this.f33920f.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        this.f33921g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TransCfmPhoneFragment.this.m25804e()) {
                    DebugUtil.log("user input phone is : " + (TransCfmPhoneFragment.this.f33919e.getText() + TransCfmPhoneFragment.this.f33920f.getTextString()), new Object[0]);
                    TransCfmPhoneFragment.this.f33929o.set(0);
                    ((IPhoneConfirmPresenter) TransCfmPhoneFragment.this.mDefaultPresenter).query99AcountByTel(String.valueOf(TransCfmPhoneFragment.this.f33919e.getText()), TransCfmPhoneFragment.this.f33920f.getTextString());
                } else {
                    WalletToastNew.showFailedMsg(TransCfmPhoneFragment.this.getContext(), TransCfmPhoneFragment.this.getString(R.string.GRider_PAX_Enter_the_YYuL));
                }
                TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_99pay_mobile_confirm_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
            }
        });
        this.f33922h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_99pay_contact_ck", TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_WALLET_PAGEID);
                new ContactPermissionFragment.Builder().setClickListener("", new ContactPermissionFragment.OnClickListener() {
                    public void onClick(ContactPermissionFragment contactPermissionFragment) {
                        String[] strArr = {Permission.READ_CONTACTS};
                        boolean checkPermissionAllGranted = PermissionUtil.checkPermissionAllGranted(TransCfmPhoneFragment.this.getContext(), strArr);
                        DebugUtil.log("check read contact permission failed!", new Object[0]);
                        if (!checkPermissionAllGranted) {
                            ActivityCompat.requestPermissions(TransCfmPhoneFragment.this.requireActivity(), strArr, 1001);
                        } else {
                            TransCfmPhoneFragment.this.m25798b();
                        }
                        contactPermissionFragment.dismiss();
                    }
                }).create().show(TransCfmPhoneFragment.this.requireActivity().getSupportFragmentManager(), "");
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        DebugUtil.log("Request read contacts onResult() requestCOde " + i, new Object[0]);
        TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_99pay_contact_access_sw", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
        if (i == 1001 && iArr[0] == 0) {
            TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_99pay_contact_access_confirm_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
            m25798b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25798b() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("vnd.android.cursor.dir/phone_v2");
        startActivityForResult(intent, 100);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1 && intent != null) {
            try {
                if (intent.getData() != null) {
                    Cursor query = getActivity().getContentResolver().query(intent.getData(), new String[]{"data1", "display_name"}, (String) null, (String[]) null, (String) null);
                    while (query.moveToNext()) {
                        String replaceAll = query.getString(1).replaceAll(" ", "");
                        String replaceAll2 = query.getString(0).replaceAll(" ", "").replaceAll("-", "");
                        if (replaceAll2.length() > 11) {
                            replaceAll2 = replaceAll2.substring(replaceAll2.length() - 11, replaceAll2.length());
                        }
                        LogUtil.m35172fi("99pay_transfer", "Contact info: name:" + replaceAll + " number:" + replaceAll2);
                        this.f33920f.setText(replaceAll2);
                    }
                    query.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m25799c() {
        this.f33923i.setData(this.f33915a);
        this.f33923i.setWalletSendEmailContract(this);
        if (getFragmentManager() != null) {
            this.f33923i.show(getFragmentManager(), "countryCodePicker");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25801d() {
        this.f33921g.setEnabled(!TextUtil.isEmpty(this.f33920f.getTextString()));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m25804e() {
        return !TextUtil.isEmpty(this.f33920f.getTextString()) && this.f33920f.getTextString().length() >= 11;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onCountryCodeSelected(String str) {
        this.f33923i.dismissEmailDialog();
        this.f33919e.setText(str);
    }

    class OnTouchEventImpl implements View.OnTouchListener {
        OnTouchEventImpl() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                View currentFocus = TransCfmPhoneFragment.this.getActivity().getCurrentFocus();
                if (currentFocus instanceof EditText) {
                    Rect rect = new Rect();
                    currentFocus.getGlobalVisibleRect(rect);
                    if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        currentFocus.clearFocus();
                        ((InputMethodManager) TransCfmPhoneFragment.this.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                    }
                }
            }
            return true;
        }
    }

    public void showConfirmTransferDialog(ConfirmInfo confirmInfo, final NNPayAccount nNPayAccount) {
        showChooseDialogInHOri(confirmInfo.titleMain, confirmInfo.titleDesc, confirmInfo.btnTextPositive, confirmInfo.btnTextNegative, new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransCfmPhoneFragment.this.gotoEditAmountPage(nNPayAccount);
                TransOmegaUtil.trackEventWithGlobal(nNPayAccount.account99PayExist ? "ibt_didipay_p2p_99pay_payee_verified_confirm_ck" : "ibt_didipay_p2p_99pay_payee_unverified_confirm_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
            }
        }, new DoubleCheckOnClickListener() {
            public void doClick(View view) {
            }
        }, true);
        TransOmegaUtil.trackEventWithGlobal(nNPayAccount.account99PayExist ? "ibt_didipay_p2p_99pay_payee_verified_confirm_sw" : "ibt_didipay_p2p_99pay_payee_unverified_confirm_sw", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS);
    }

    public void gotoEditAmountPage(NNPayAccount nNPayAccount) {
        PayEventPublisher.getPublisher().publish(PayEventKeys.TransferFillAmount.EVENT_KEY_GOTO_EDIT_AMOUNT, nNPayAccount);
    }

    public void onCountryCodeLoaded(List<String> list) {
        if (this.f33915a == null) {
            this.f33915a = new ArrayList();
        }
        this.f33915a.clear();
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f33915a.add("+55");
        } else {
            this.f33915a.addAll(list);
        }
        m25806f();
    }

    public void onHistoryTransAccountLoaded(List<NNPayAccount> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f33928n = list;
        }
        m25806f();
    }

    public void onMultiTaskFinish(String str) {
        if (this.f33929o.get() > 0) {
            this.f33929o.decrementAndGet();
        }
    }

    /* renamed from: f */
    private void m25806f() {
        if (this.f33929o.get() <= 0) {
            if (this.f33930p.getVisibility() != 0) {
                this.f33930p.setVisibility(0);
            }
            if (!CollectionUtil.isEmpty((Collection<?>) this.f33915a)) {
                this.f33919e.setText(this.f33915a.get(0));
                this.f33919e.setEnabled(true);
                this.f33920f.setEnabled(true);
                this.f33920f.setText("");
                m25801d();
            }
            if (!CollectionUtil.isEmpty((Collection<?>) this.f33928n)) {
                this.f33927m.setVisibility(0);
                this.f33926l.setVisibility(0);
                this.f33925k.updateData(this.f33928n);
            }
            UIHandler.getHandler().postDelayed(new Runnable() {
                public void run() {
                    TransCfmPhoneFragment.this.f33920f.requestFocus();
                    ((InputMethodManager) TransCfmPhoneFragment.this.f33920f.getContext().getSystemService("input_method")).showSoftInput(TransCfmPhoneFragment.this.f33920f, 1);
                }
            }, 100);
        }
    }
}
