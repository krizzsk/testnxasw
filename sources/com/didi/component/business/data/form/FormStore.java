package com.didi.component.business.data.form;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.address.util.SugWayPointsUtils;
import com.didi.addressold.util.AddressTrack;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.core.IComponent;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.component.express.ExpressShareStore;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.travel.psnger.model.response.CarConfig;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.DispatchFeeConfig;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.MapLineInfo;
import com.didi.travel.psnger.model.response.MarkerInfo;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.model.response.estimate.CarConfigModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.MapInfoModel;
import com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import com.didi.travel.psnger.model.response.estimate.daijiao.SubstituteCallModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class FormStore {
    public static final int CARPOOL_ORDER_NOT_CARPOOL = -1;
    public static final String KEY_PAY_ENTERPRISE = "store_key_pay_enterprise";
    public static final String KEY_RECALL_ORDER = "store_recall_order";
    public static final int TYPE_CHANGE_ADDRESS_END_ESTIMATE_SUG = 8;
    public static final int TYPE_CHANGE_ADDRESS_START_ESTIMATE_SUG = 4;
    public static final int TYPE_CHANGE_ADDRESS_START_GET_ON_DRAG = 1;
    public static final int TYPE_CHANGE_ADDRESS_START_GET_ON_SUG = 2;

    /* renamed from: A */
    private Map<String, Object> f13037A = new HashMap();

    /* renamed from: B */
    private int f13038B = 0;
    public int Bid;

    /* renamed from: C */
    private boolean f13039C;

    /* renamed from: D */
    private long f13040D = 0;

    /* renamed from: E */
    private List<PayWayModel.PayWayItem> f13041E = new ArrayList();

    /* renamed from: F */
    private String f13042F;

    /* renamed from: G */
    private String f13043G;

    /* renamed from: H */
    private CarInfo f13044H;

    /* renamed from: I */
    private CarInfo f13045I;

    /* renamed from: J */
    private DepartureAddress f13046J;

    /* renamed from: K */
    private int f13047K = 1;

    /* renamed from: L */
    private int[] f13048L;

    /* renamed from: M */
    private String[] f13049M;

    /* renamed from: N */
    private int f13050N = 0;

    /* renamed from: O */
    private int f13051O;

    /* renamed from: P */
    private int f13052P;

    /* renamed from: Q */
    private boolean f13053Q = false;

    /* renamed from: R */
    private CarOrder f13054R;

    /* renamed from: S */
    private boolean f13055S;
    public String Sid;

    /* renamed from: T */
    private boolean f13056T;

    /* renamed from: U */
    private int f13057U;

    /* renamed from: V */
    private List<WayPoint> f13058V = new ArrayList();

    /* renamed from: W */
    private String f13059W;

    /* renamed from: X */
    private TaxiCompanyListModel.CompanyModel f13060X;

    /* renamed from: Y */
    private Map<String, String> f13061Y = new HashMap();

    /* renamed from: Z */
    private boolean f13062Z;

    /* renamed from: a */
    private JSONObject f13063a;

    /* renamed from: aA */
    private String f13064aA;

    /* renamed from: aB */
    private Map<String, Boolean> f13065aB = new HashMap();

    /* renamed from: aC */
    private String f13066aC = "";

    /* renamed from: aD */
    private String f13067aD;

    /* renamed from: aE */
    private EstimateItemModel f13068aE;

    /* renamed from: aF */
    private String f13069aF = "";

    /* renamed from: aG */
    private HashMap<Integer, IComponent> f13070aG = new HashMap<>();

    /* renamed from: aa */
    private int f13071aa = 1;

    /* renamed from: ab */
    private String f13072ab;

    /* renamed from: ac */
    private String f13073ac = "";

    /* renamed from: ad */
    private boolean f13074ad = false;

    /* renamed from: ae */
    private boolean f13075ae = false;

    /* renamed from: af */
    private boolean f13076af = false;

    /* renamed from: ag */
    private Map<String, Object> f13077ag;

    /* renamed from: ah */
    private boolean f13078ah = false;

    /* renamed from: ai */
    private boolean f13079ai = false;

    /* renamed from: aj */
    private long f13080aj;

    /* renamed from: ak */
    private boolean f13081ak = false;

    /* renamed from: al */
    private boolean f13082al = false;

    /* renamed from: am */
    private SugParams.MapSelectOper f13083am = SugParams.MapSelectOper.OTHER;

    /* renamed from: an */
    private boolean f13084an;

    /* renamed from: ao */
    private boolean f13085ao;

    /* renamed from: ap */
    private boolean f13086ap;

    /* renamed from: aq */
    private boolean f13087aq;

    /* renamed from: ar */
    private boolean f13088ar;

    /* renamed from: as */
    private BusinessContext f13089as;

    /* renamed from: at */
    private String f13090at;

    /* renamed from: au */
    private boolean f13091au;

    /* renamed from: av */
    private String f13092av;

    /* renamed from: aw */
    private String f13093aw;

    /* renamed from: ax */
    private String f13094ax;

    /* renamed from: ay */
    private String f13095ay;

    /* renamed from: az */
    private boolean f13096az;

    /* renamed from: b */
    private Address f13097b;

    /* renamed from: c */
    private Address f13098c;

    /* renamed from: d */
    private Address f13099d;

    /* renamed from: e */
    private boolean f13100e = true;

    /* renamed from: f */
    private AddressSrcType f13101f = AddressSrcType.LOC_REVER;

    /* renamed from: g */
    private Address f13102g;

    /* renamed from: h */
    private boolean f13103h;

    /* renamed from: i */
    private boolean f13104i;

    /* renamed from: j */
    private long f13105j;

    /* renamed from: k */
    private int f13106k;

    /* renamed from: l */
    private int f13107l = -1;

    /* renamed from: m */
    private EstimateItem f13108m;
    public SparseBooleanArray mDynamicTipShown = new SparseBooleanArray();

    /* renamed from: n */
    private String f13109n;

    /* renamed from: o */
    private SubstituteCallModel f13110o;

    /* renamed from: p */
    private FriendItem f13111p;

    /* renamed from: q */
    private String f13112q;

    /* renamed from: r */
    private String f13113r;

    /* renamed from: s */
    private boolean f13114s = false;

    /* renamed from: t */
    private boolean f13115t = false;

    /* renamed from: u */
    private boolean f13116u = false;

    /* renamed from: v */
    private int f13117v = 0;

    /* renamed from: w */
    private PinCodeInfoResult f13118w;

    /* renamed from: x */
    private boolean f13119x;

    /* renamed from: y */
    private String f13120y;

    /* renamed from: z */
    private boolean f13121z = false;

    /* renamed from: a */
    private boolean m11004a(Object obj) {
        return true;
    }

    public String getStartParkingProperty() {
        return this.f13072ab;
    }

    public void setStartParkingProperty(String str) {
        this.f13072ab = str;
    }

    public boolean isShowInterceptorPop() {
        return this.f13103h;
    }

    public void setIsShowInterceptorPop(boolean z) {
        this.f13103h = z;
    }

    public boolean isShowRealPicInXpanel() {
        return this.f13104i;
    }

    public void setShowRealPicInXpanel(boolean z) {
        this.f13104i = z;
    }

    public String getPassengerSheetKey() {
        return this.f13073ac;
    }

    public void setPassengerSheetKey(String str) {
        this.f13073ac = str;
    }

    public boolean ismGroupFormViewChanged() {
        return this.f13084an;
    }

    public void setmGroupFormViewChanged(boolean z) {
        this.f13084an = z;
    }

    public String getSubstituteCallIcon() {
        return this.f13092av;
    }

    public void setSubstituteCallIcon(String str) {
        this.f13092av = str;
    }

    public String getSubstituteCallText() {
        return this.f13093aw;
    }

    public void setSubstituteCallText(String str) {
        this.f13093aw = str;
    }

    public SubstituteCallModel getSubstituteCallModel() {
        return this.f13110o;
    }

    public void setSubstituteCallModel(SubstituteCallModel substituteCallModel) {
        this.f13110o = substituteCallModel;
    }

    public boolean isHasSubstituteCall() {
        return this.f13088ar;
    }

    public void setHasSubstituteCall(boolean z) {
        this.f13088ar = z;
    }

    public FriendItem getSelectedFriend() {
        return this.f13111p;
    }

    public void setSelectedFriend(FriendItem friendItem) {
        this.f13111p = friendItem;
    }

    public enum AddressSrcType {
        LOC_REVER(0),
        MAP_DRAG(1),
        SUG_SEARCH(2),
        SUG_RECOMMEND(3),
        HOME(4),
        COMPANY(5),
        FAVORITE(6),
        QUICK_REQ(7),
        BY_USER(8),
        BY_USER_AT_ERROR(9),
        HOME_RECOMMEND(10),
        OTHER_APP(11),
        UNKOWN(99);
        
        private int type;

        private AddressSrcType(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    public Map<String, Object> getSelectValueParams() {
        return this.f13077ag;
    }

    public void setSelectValueParams(Map<String, Object> map) {
        this.f13077ag = map;
    }

    public boolean isInMiniBus() {
        return this.f13087aq;
    }

    public void setIsInMiniBus(boolean z) {
        this.f13087aq = z;
    }

    public void setIsClickGuessDestination(boolean z) {
        this.f13091au = z;
    }

    public boolean getIsClickGuessDestination() {
        return this.f13091au;
    }

    public void setDisplayName(String str) {
        this.f13090at = str;
    }

    public String getDisplayName() {
        return this.f13090at;
    }

    public String getFlex_recommend_price() {
        return this.f13064aA;
    }

    public void setFlex_recommend_price(String str) {
        this.f13064aA = str;
    }

    public String getInputOfferPrice() {
        return this.f13094ax;
    }

    public void setInputOfferPrice(String str) {
        this.f13094ax = str;
    }

    public String getFlex_order_params() {
        return this.f13095ay;
    }

    public void setFlex_order_params(String str) {
        this.f13095ay = str;
    }

    public boolean isFlexOfferPrice() {
        return this.f13096az;
    }

    public void setFlexOfferPrice(boolean z) {
        this.f13096az = z;
    }

    public boolean getIsSeatConfirmDialogShowed(String str) {
        Boolean bool = this.f13065aB.get(str);
        return bool != null && bool.booleanValue();
    }

    public void setIsSeatConfirmDialogShowed(String str, Boolean bool) {
        this.f13065aB.put(str, bool);
    }

    public String getBubbleId() {
        return this.f13066aC;
    }

    public void setBubbleId(String str) {
        this.f13066aC = str;
    }

    public void setMapSelectOper(SugParams.MapSelectOper mapSelectOper) {
        this.f13083am = mapSelectOper;
    }

    public SugParams.MapSelectOper getMapSelectOper() {
        return this.f13083am;
    }

    private static class FormStoreHolder {
        /* access modifiers changed from: private */
        public static final FormStore INSTANCE = new FormStore();

        private FormStoreHolder() {
        }
    }

    public static final FormStore getInstance() {
        return FormStoreHolder.INSTANCE;
    }

    public void initData(String str, int i, int i2) {
        this.Sid = str;
        setBid(i);
        setCurrentComboType(i2);
        m11002a();
    }

    public List<WayPoint> getWayPoints() {
        Address startAddress = getStartAddress();
        Address endAddress = getEndAddress();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WayPoint(1, startAddress));
        for (WayPoint address : this.f13058V) {
            arrayList.add(new WayPoint(2, address.getAddress()));
        }
        arrayList.add(new WayPoint(3, endAddress));
        return arrayList;
    }

    public boolean hasStopPoints() {
        return !this.f13058V.isEmpty();
    }

    public void saveWayPoint(List<WayPoint> list) {
        if (list != null) {
            for (WayPoint next : list) {
                if (next.getWayPointType() == 1) {
                    setStartAddress(next.getAddress());
                } else if (next.getWayPointType() == 3) {
                    setEndAddress(next.getAddress());
                } else if (next.getWayPointType() == 2) {
                    m11003a(next);
                }
            }
        }
    }

    public void clearStopPoints() {
        this.f13058V.clear();
    }

    /* renamed from: a */
    private void m11003a(WayPoint wayPoint) {
        if (wayPoint != null) {
            this.f13058V.add(wayPoint);
        }
    }

    public void setData(String str, Object obj) {
        setData("", str, obj);
    }

    public <T> T getData(String str) throws Exception {
        return getData("", str);
    }

    public void setData(String str, String str2, Object obj) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            str3 = str + "_";
        }
        if (m11004a(obj)) {
            this.f13037A.put(this.Sid + "_" + str3 + str2, obj);
            return;
        }
        throw new IllegalArgumentException("obj param must be base data type");
    }

    public <T> T getData(String str, String str2) throws Exception {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            str3 = str + "_";
        }
        T t = this.f13037A.get(this.Sid + "_" + str3 + str2);
        if (t != null) {
            return t;
        }
        return null;
    }

    public <T> T getDataSilence(String str) {
        try {
            return getData(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public <T> T getDataSilence(String str, String str2) {
        try {
            return getData(str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public int getIntData(String str, int i) {
        return getIntData("", str, i);
    }

    public int getIntData(String str, String str2, int i) {
        Integer num = (Integer) getDataSilence(str, str2);
        if (num == null) {
            return i;
        }
        return num.intValue();
    }

    public boolean getBooleanData(String str, boolean z) {
        return getBooleanData("", str, z);
    }

    public boolean getBooleanData(String str, String str2, boolean z) {
        Boolean bool = (Boolean) getDataSilence(str, str2);
        if (bool == null) {
            return z;
        }
        return bool.booleanValue();
    }

    public Address getGetOnStartAddress() {
        return this.f13099d;
    }

    public void setGetOnStartAddress(Address address) {
        this.f13099d = address;
    }

    public Address getStartAddress() {
        return this.f13097b;
    }

    public void setStartAddress(Address address) {
        setStartAddress(address, this.f13101f, true);
    }

    public void setStartAddressSrcType(AddressSrcType addressSrcType) {
        this.f13101f = addressSrcType;
    }

    public void setStartAddress(Address address, boolean z) {
        setStartAddress(address, this.f13101f, z);
    }

    public void setStartAddress(Address address, AddressSrcType addressSrcType) {
        setStartAddress(address, addressSrcType, true);
    }

    public void setStartAddress(Address address, AddressSrcType addressSrcType, boolean z) {
        this.f13101f = addressSrcType;
        this.f13097b = address;
        this.f13100e = z;
        ExpressShareStore.getInstance().setFromAddress(address);
    }

    @Deprecated
    public CarInfo getLastSelectCarInfo() {
        return this.f13044H;
    }

    @Deprecated
    public void setLastSelectCarInfo(CarInfo carInfo) {
        this.f13044H = carInfo;
    }

    @Deprecated
    public CarInfo getCurrentCarInfo() {
        return this.f13045I;
    }

    @Deprecated
    public void setCurrentCarInfo(CarInfo carInfo) {
        this.f13045I = carInfo;
    }

    public void setDepartureAddress(Address address) {
        this.f13102g = address;
    }

    public Address getDepartureAddress() {
        return this.f13102g;
    }

    public Address getEndAddress() {
        return this.f13098c;
    }

    public void setEndAddress(Address address) {
        this.f13098c = address;
        ExpressShareStore.getInstance().setToAddress(address);
    }

    public AddressSrcType getStartAddressSrcType() {
        return this.f13101f;
    }

    public int getSeatCount() {
        int i = this.f13047K;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public void setSeatCount(int i) {
        this.f13047K = i;
    }

    public int[] getSeatCountArray() {
        return this.f13048L;
    }

    public void setSeatCountArray(int[] iArr) {
        this.f13048L = iArr;
    }

    public String[] getSeatFeeArray() {
        return this.f13049M;
    }

    public void setSeatFeeArray(String[] strArr) {
        this.f13049M = strArr;
    }

    public long getTransportTime() {
        return this.f13105j;
    }

    public String getOrderType() {
        if (getInstance().isQuotaInCurEstimateItem()) {
            return "AirportFixed";
        }
        return getInstance().getTransportTime() > 0 ? "Reservation" : "Realtime";
    }

    public boolean isAddressValid() {
        return (this.f13097b == null || this.f13098c == null) ? false : true;
    }

    public void setTransportTime(long j) {
        this.f13105j = j;
        ExpressShareStore.getInstance().setDepartureTime(j);
    }

    public int getCarLevel() {
        return this.f13106k;
    }

    public void setCarLevel(int i) {
        if (this.f13106k != i) {
            this.f13106k = i;
        }
    }

    public int getCarpoolOrderScene() {
        return this.f13107l;
    }

    public void setCarpoolOrderScene(int i) {
        this.f13107l = i;
    }

    public void setBid(int i) {
        GLog.m11354d("FormStore", "setBid:" + i);
        this.Bid = i;
    }

    public void setCarTypeInfo(int i, int i2, int i3, int i4) {
        if (this.Bid != i || i2 != this.f13050N || i3 != this.f13106k || i4 != this.f13107l) {
            this.f13106k = i3;
            setBid(i);
            setCarpoolOrderScene(i4);
            setCurrentComboType(i2);
        }
    }

    public void setCarTypeInfo(int i, int i2, int i3) {
        if (this.Bid != i || i2 != this.f13050N || i3 != this.f13106k) {
            this.f13106k = i3;
            setBid(i);
            setCurrentComboType(i2);
        }
    }

    public boolean isMatchToGo() {
        return this.f13107l == 2;
    }

    public boolean isNotMatchDiscount() {
        return this.f13107l == 3;
    }

    public EstimateItem getEstimateItem() {
        return this.f13108m;
    }

    public void setEstimateItem(EstimateItem estimateItem) {
        if (this.f13108m != estimateItem) {
            this.f13108m = estimateItem;
        }
    }

    public void setSelectedSeat(String str) {
        this.f13109n = str;
    }

    public String getSelectedSeat() {
        return this.f13109n;
    }

    public CarConfig.ConfirmActionInfo getConfirmActionInfo() {
        EstimateItemModel newEstimateItem = getInstance().getNewEstimateItem();
        if (!(newEstimateItem == null || newEstimateItem.carBreakModel == null || newEstimateItem.carBreakModel.carBreakDelivery == null || newEstimateItem.carConfig == null)) {
            try {
                JSONObject jSONObject = new JSONObject(newEstimateItem.carBreakModel.carBreakDelivery.toString());
                return new CarConfig.ConfirmActionInfo(newEstimateItem.carConfig.carProductId + "", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setPayWay(String str) {
        this.f13112q = str;
    }

    public String getPayWay() {
        return this.f13112q;
    }

    public String getPayWayMsg() {
        return this.f13113r;
    }

    public void setPayWayMsg(String str) {
        this.f13113r = str;
    }

    public List<PayWayModel.PayWayItem> getPayWaySelectedItem() {
        return this.f13041E;
    }

    public void setPayWaySelectedItem(List<PayWayModel.PayWayItem> list) {
        if (list != null && !list.isEmpty()) {
            this.f13041E = list;
            for (PayWayModel.PayWayItem next : list) {
                if (next != null) {
                    this.f13042F = next.cardIndex;
                    this.f13043G = next.cardPrefix;
                }
            }
        }
    }

    public String getCardIndex() {
        String str = this.f13042F;
        return str == null ? "" : str;
    }

    public String getCardPrefix() {
        String str = this.f13043G;
        return str == null ? "" : str;
    }

    public void setCardIndex(String str) {
        this.f13042F = str;
    }

    /* renamed from: a */
    private void m11002a() {
        setStartAddress(new Address(), this.f13101f, true);
        setEndAddress(new Address());
        setTransportTime(ExpressShareStore.getInstance().getDepartureTime());
    }

    public void clear() {
        setEndAddress((Address) null);
        this.f13106k = 0;
        this.f13108m = null;
        this.f13112q = null;
        this.f13037A.clear();
        this.f13121z = false;
        clearChangeAddressTypes();
        this.f13099d = null;
        this.f13039C = false;
        this.f13041E.clear();
        this.f13117v = 0;
        this.f13118w = null;
        this.f13114s = false;
        this.f13115t = false;
        this.f13116u = false;
        this.f13050N = 0;
        this.f13101f = AddressSrcType.LOC_REVER;
        this.f13056T = false;
        this.f13057U = 0;
        this.f13053Q = false;
        this.f13058V.clear();
        this.f13051O = 0;
        this.f13059W = null;
        this.f13060X = null;
        this.f13045I = null;
        this.f13061Y.clear();
        this.f13071aa = 1;
        this.f13103h = false;
        this.f13104i = false;
        this.f13074ad = false;
        this.f13075ae = false;
        this.f13076af = false;
        this.f13063a = null;
        this.f13067aD = null;
        this.f13068aE = null;
        this.f13046J = null;
        this.f13073ac = "";
        this.f13066aC = "";
        this.f13065aB.clear();
        this.f13078ah = false;
        this.f13079ai = false;
        this.f13080aj = 0;
        this.f13081ak = false;
        this.f13082al = false;
        this.f13091au = false;
        this.f13092av = null;
        this.f13093aw = null;
        this.f13110o = null;
        this.f13111p = null;
        this.f13094ax = null;
        this.f13095ay = null;
        this.f13096az = false;
    }

    public void clearAllTypeData(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str + "_";
        }
        String str3 = this.Sid + "_" + str2;
        Iterator<String> it = this.f13037A.keySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                String next = it.next();
                if (next.startsWith(str3)) {
                    it.remove();
                    this.f13037A.remove(next);
                }
            }
        }
    }

    public boolean isNeedNearRoad() {
        return this.f13100e;
    }

    public void setNeedNearRoad(boolean z) {
        this.f13100e = z;
    }

    public void setShowPayWayAfterEstimate(boolean z) {
        this.f13121z = z;
    }

    public boolean isShowPayWayAfterEstimate() {
        return this.f13121z;
    }

    public void addChangeAddressTypes(int i) {
        this.f13038B = i | this.f13038B;
    }

    public void removeChangeAddressTypes(int i) {
        this.f13038B = (~i) & this.f13038B;
    }

    public void clearChangeAddressTypes() {
        this.f13038B = 0;
    }

    public boolean hasChangeAddressType(int i) {
        return (i & this.f13038B) != 0;
    }

    public boolean isAccessibleCar() {
        return this.f13039C;
    }

    public void setAccessibleCar(boolean z) {
        this.f13039C = z;
    }

    public void setEstimateTime(long j) {
        this.f13040D = j;
    }

    public long getEstimateTime() {
        return this.f13040D;
    }

    public DepartureAddress getAirPotAddress() {
        return this.f13046J;
    }

    public void setAirPotAddress(DepartureAddress departureAddress) {
        this.f13046J = departureAddress;
    }

    public int getCurrentComboType() {
        return this.f13050N;
    }

    public void setCurrentComboType(int i) {
        this.f13050N = i;
        GlobalOmegaUtils.putGlobal("g_ComboType", Integer.valueOf(i));
    }

    public CarOrder getCreateFailOrder() {
        return this.f13054R;
    }

    public void setCreateFailOrder(CarOrder carOrder) {
        this.f13054R = carOrder;
    }

    public int getCarpoolRadius() {
        return this.f13052P;
    }

    public void setCarpoolRadius(int i) {
        this.f13052P = i;
    }

    public boolean isCarpoolShow() {
        return this.f13053Q;
    }

    public void setCarpoolShow(boolean z) {
        this.f13053Q = z;
        GlobalOmegaUtils.trackEvent("pas_confirm_allcar_sw", z ? "1" : "0");
    }

    public boolean isSkipEstimateGet() {
        return this.f13055S;
    }

    public void setSkipEstimateGet(boolean z) {
        this.f13055S = z;
    }

    public void setIsFromOpenRide(boolean z) {
        this.f13114s = z;
    }

    public boolean isFromOpenRide() {
        return this.f13114s || BusinessDataUtil.isOpenRideOrder(CarOrderHelper.getOrder());
    }

    public void setIsOpenRideFromDeepLink(boolean z) {
        this.f13115t = z;
    }

    public boolean isOpenRideFromDeepLink() {
        return this.f13115t;
    }

    public void setIsOpenRideFromDeepLinkBindCardSuc(boolean z) {
        this.f13116u = z;
    }

    public boolean isOpenRideFromDeepLinkBindCardSuc() {
        return this.f13116u;
    }

    public void setDriverCode(int i) {
        this.f13117v = i;
    }

    public int getDriverCode() {
        return this.f13117v;
    }

    public PinCodeInfoResult getDriverInfo() {
        return this.f13118w;
    }

    public void setDriverInfo(PinCodeInfoResult pinCodeInfoResult) {
        this.f13118w = pinCodeInfoResult;
    }

    public void setOpenRideHasOnlinePayAbility(boolean z) {
        this.f13119x = z;
    }

    public boolean getOpenRideHasOnlinePayAbility() {
        return this.f13119x;
    }

    public void setOpenRideBrand(String str) {
        this.f13120y = str;
    }

    public String getOpenRideBrand() {
        return this.f13120y;
    }

    public boolean isCarPoolLineBeforeHaveOrder() {
        return getCurrentComboType() == 4;
    }

    public boolean isQuotaInCurEstimateItem() {
        EstimateItemModel newEstimateItem = getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.countPriceType != 100) {
            return false;
        }
        return true;
    }

    public boolean isCountPriceTypeFixed() {
        EstimateItemModel newEstimateItem = getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.countPriceType != 2) {
            return false;
        }
        return true;
    }

    public void updateStartAddressSrcTypeBySug() {
        switch (AddressTrack.getAddressSrcByType(1)) {
            case 1:
                setStartAddressSrcType(AddressSrcType.MAP_DRAG);
                return;
            case 2:
                setStartAddressSrcType(AddressSrcType.SUG_RECOMMEND);
                return;
            case 3:
                setStartAddressSrcType(AddressSrcType.SUG_SEARCH);
                return;
            case 4:
                setStartAddressSrcType(AddressSrcType.HOME);
                return;
            case 5:
                setStartAddressSrcType(AddressSrcType.COMPANY);
                return;
            case 6:
                setStartAddressSrcType(AddressSrcType.FAVORITE);
                return;
            default:
                return;
        }
    }

    public void setNearbyCarNum(int i) {
        this.f13057U = i;
    }

    public int getNearbyCarNum() {
        return this.f13057U;
    }

    public void setShowNearCarMsg(boolean z) {
        this.f13056T = z;
    }

    public boolean isShowNearCarMsg() {
        return this.f13056T;
    }

    public void setWayPointAddressList(String str) {
        this.f13058V = SugWayPointsUtils.getWayPointListFromJson(str);
    }

    public String getWayPointAddressListJsonArray() {
        return SugWayPointsUtils.getJsonStrFromWayPoints(this.f13058V);
    }

    public List<WayPoint> getWayPointAddressList() {
        return this.f13058V;
    }

    public int getEta() {
        return this.f13051O;
    }

    public void setEta(int i) {
        this.f13051O = i;
    }

    public String getFlightNum() {
        return this.f13059W;
    }

    public void setFlightNum(String str) {
        this.f13059W = str;
    }

    public void setCurCompany(TaxiCompanyListModel.CompanyModel companyModel) {
        this.f13060X = companyModel;
    }

    public TaxiCompanyListModel.CompanyModel getCurCompany() {
        return this.f13060X;
    }

    public boolean isShowingPopupCompoent() {
        return this.f13062Z;
    }

    public void setShowingPopupCompoent(boolean z) {
        this.f13062Z = z;
    }

    public Map<String, String> getPayedWay() {
        return this.f13061Y;
    }

    public void setPayedWay(Map<String, String> map) {
        this.f13061Y = map;
    }

    public int getEnterpriseFlag() {
        return this.f13071aa;
    }

    public void setEnterpriseFlag(int i) {
        this.f13071aa = i;
    }

    public boolean isTwoPriceBiz() {
        return this.f13074ad;
    }

    public void setTwoPriceBiz(boolean z) {
        this.f13074ad = z;
    }

    public boolean isTwoPriceSeatConfirm() {
        return this.f13075ae;
    }

    public void setTwoPriceSeatConfirm(boolean z) {
        this.f13075ae = z;
    }

    public boolean isShiftSelected() {
        return this.f13076af;
    }

    public void setShiftSelected(boolean z) {
        this.f13076af = z;
    }

    public boolean isOrderBan() {
        return this.f13085ao;
    }

    public void setOrderBan(boolean z) {
        this.f13085ao = z;
    }

    public boolean isSafetyTrain() {
        return this.f13086ap;
    }

    public void setSafetyTrain(boolean z) {
        this.f13086ap = z;
    }

    public JSONObject getDeliveryInfo() {
        return this.f13063a;
    }

    public void setDeliveryInfo(JSONObject jSONObject) {
        this.f13063a = jSONObject;
    }

    public void setEstimatePassConfirm(boolean z) {
        this.f13078ah = z;
    }

    public boolean isEstimatePassConfirm() {
        return this.f13078ah;
    }

    public void setIsHasEstimatePassData(boolean z) {
        this.f13079ai = z;
    }

    public boolean isHasEstimatePassData() {
        return this.f13079ai;
    }

    public void setIsPassShowDialog(boolean z) {
        this.f13081ak = z;
    }

    public boolean getIsPassShowDialog() {
        return this.f13081ak;
    }

    public void setIsDialogPassConfirm(boolean z) {
        this.f13082al = z;
    }

    public boolean getIsDialogPassConfirm() {
        return this.f13082al;
    }

    public long getPassPackageId() {
        return this.f13080aj;
    }

    public void setPassPackageId(long j) {
        this.f13080aj = j;
    }

    public HashMap<Integer, IComponent> getCarOprationComponet() {
        return this.f13070aG;
    }

    public void setEstimateModelTraceId(String str) {
        this.f13067aD = str;
    }

    public String getEstimateModelTraceId() {
        return this.f13067aD;
    }

    public void setNewEstimateItem(EstimateItemModel estimateItemModel) {
        this.f13068aE = estimateItemModel;
        if (estimateItemModel != null) {
            if (estimateItemModel.carConfig != null) {
                CarConfigModel carConfigModel = estimateItemModel.carConfig;
                setCarLevel(carConfigModel.carLevel);
                setCarpoolRadius(carConfigModel.carCircleRadius);
                setCurrentComboType(carConfigModel.carComboType);
                setCarTypeInfo(carConfigModel.carBussinessId, carConfigModel.carComboType, carConfigModel.carLevel);
                setCarpoolOrderScene(-1);
            }
            NewEstimateChoosedOpration newEstimateChoosedOpration = estimateItemModel.twoPriceChoice;
            if (newEstimateChoosedOpration == null || newEstimateChoosedOpration.selectedValue == null || newEstimateChoosedOpration.selectedValue.isEmpty() || newEstimateChoosedOpration.selectedValue.equals("0")) {
                setTwoPriceBiz(false);
            } else {
                setTwoPriceBiz(true);
            }
            NewEstimateChoosedOpration newEstimateChoosedOpration2 = estimateItemModel.dispatchFeeChoice;
            if (!(newEstimateChoosedOpration2 == null || newEstimateChoosedOpration2.selectedValue == null || newEstimateChoosedOpration2.selectedValue.isEmpty())) {
                DispatchFeeConfig.DispatchFee dispatchFee = new DispatchFeeConfig.DispatchFee();
                try {
                    dispatchFee.value = new BigDecimal(newEstimateChoosedOpration2.selectedValue);
                    dispatchFee.name = newEstimateChoosedOpration2.selectedText.getContent();
                    dispatchFee.selectedName = newEstimateChoosedOpration2.selectedText.getContent();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            NewEstimateChoosedOpration newEstimateChoosedOpration3 = estimateItemModel.extraChoice;
            if (newEstimateChoosedOpration3 == null || newEstimateChoosedOpration3.selectedValue == null || newEstimateChoosedOpration3.selectedValue.isEmpty() || newEstimateChoosedOpration3.selectedValue.equals("0")) {
                setAccessibleCar(false);
            } else {
                setAccessibleCar(true);
            }
            NewEstimateChoosedOpration newEstimateChoosedOpration4 = estimateItemModel.estimatePass;
            if (newEstimateChoosedOpration4 == null || newEstimateChoosedOpration4.selectedValue == null || newEstimateChoosedOpration4.selectedValue.isEmpty() || newEstimateChoosedOpration4.selectedValue.equals("0")) {
                setEstimatePassConfirm(false);
            } else {
                setEstimatePassConfirm(true);
            }
            setEstimateItem(estimateItemModel.oldEstimateItem);
        }
    }

    public EstimateItemModel getNewEstimateItem() {
        return this.f13068aE;
    }

    public BusinessContext getBusinessContext() {
        return this.f13089as;
    }

    public void setBusinessContext(BusinessContext businessContext) {
        this.f13089as = businessContext;
    }

    public String getInfoList() {
        return this.f13069aF;
    }

    public void setInfoList(String str) {
        this.f13069aF = str;
    }

    public boolean isBubbleShowCarpoolStyle() {
        return m11005b() != null && m11005b().routeType == 2;
    }

    public boolean isBubbleEnablePassingPoint() {
        MapInfoModel b = m11005b();
        return b != null && b.isEnablePassingPoint();
    }

    public String getConfirmPickupSubTitle() {
        MapInfoModel b = m11005b();
        return (b == null || TextUtils.isEmpty(b.confirmPickupSubText)) ? "" : b.confirmPickupSubText;
    }

    public int getBubbleRouteType() {
        MapInfoModel b = m11005b();
        if (b != null) {
            return b.routeType;
        }
        return 0;
    }

    public List<MapLineInfo> getLineInfo() {
        MapInfoModel b = m11005b();
        if (b == null) {
            return null;
        }
        return b.lineInfo;
    }

    public List<MarkerInfo> getMarkerInfo() {
        MapInfoModel b = m11005b();
        if (b == null) {
            return null;
        }
        return b.markerInfo;
    }

    /* renamed from: b */
    private MapInfoModel m11005b() {
        EstimateItemModel newEstimateItem = getInstance().getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.mapInfoModel == null) {
            return null;
        }
        return newEstimateItem.mapInfoModel;
    }
}
