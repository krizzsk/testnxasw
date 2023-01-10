package com.didi.payment.utilities.scan.collect;

import android.text.TextUtils;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.utilities.scan.utils.PreviewCollectionUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.ditest.agent.android.util.C16337Util;
import com.didichuxing.omega.sdk.corelink.node.EventSpecialNode;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;

public class CollectionManager {

    /* renamed from: a */
    private static final String f34215a = "key_action_hit";

    /* renamed from: b */
    private String f34216b;

    /* renamed from: c */
    private int[] f34217c;

    /* renamed from: d */
    private int f34218d;

    /* renamed from: e */
    private float f34219e;

    /* renamed from: f */
    private int f34220f;

    /* renamed from: g */
    private int f34221g;

    /* renamed from: h */
    private Set<String> f34222h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public List<CollectionModel> f34223i;

    /* renamed from: j */
    private long f34224j;

    /* renamed from: k */
    private volatile boolean f34225k;

    public CollectionManager() {
        this.f34218d = 0;
        this.f34219e = 0.5f;
        this.f34220f = 70;
        this.f34221g = 3;
        this.f34222h = new HashSet();
        this.f34223i = new ArrayList();
        this.f34224j = System.currentTimeMillis();
        this.f34216b = new UUID(C16337Util.getRandom().nextLong(), C16337Util.getRandom().nextLong()).toString();
        this.f34221g = ((Integer) WalletApolloUtil.getParam(CollectionConstant.APOLLO_ID, CollectionConstant.APOLLO_PARAM_MAX_TIME, 3)).intValue();
        this.f34219e = ((Float) WalletApolloUtil.getParam(CollectionConstant.APOLLO_ID, CollectionConstant.APOLLO_PARAM_RATIO, Float.valueOf(0.5f))).floatValue();
        this.f34220f = ((Integer) WalletApolloUtil.getParam(CollectionConstant.APOLLO_ID, CollectionConstant.APOLLO_PARAM_QUALITY, 70)).intValue();
        m26148a();
        m26150b();
    }

    /* renamed from: a */
    private void m26148a() {
        String str = (String) WalletApolloUtil.getParam(CollectionConstant.APOLLO_ID, CollectionConstant.APOLLO_PARAM_TIME_POINTS, "[6]");
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                this.f34217c = new int[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f34217c[i] = jSONArray.optInt(i) * 1000;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m26150b() {
        if (EventSpecialNode.getSpecial(CollectionConstant.EVENT_ID) == null) {
            Map map = null;
            Class<EventSpecialNode> cls = EventSpecialNode.class;
            try {
                Field declaredField = cls.getDeclaredField("specialMap");
                declaredField.setAccessible(true);
                map = (Map) declaredField.get(cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (map == null) {
                map = new HashMap();
            }
            PrintStream printStream = System.out;
            printStream.println("specialMap size: " + map.size());
            HashMap hashMap = new HashMap();
            hashMap.put("r", 1);
            map.put(CollectionConstant.EVENT_ID, hashMap);
            EventSpecialNode.putSpecial(map);
        }
    }

    public void collectIfNeeded(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        if (!this.f34225k && this.f34222h.size() < this.f34221g) {
            long currentTimeMillis = System.currentTimeMillis() - this.f34224j;
            int[] iArr = this.f34217c;
            if (iArr != null && iArr.length > 0) {
                int length = iArr.length;
                int i3 = 0;
                while (i3 < length) {
                    int i4 = iArr[i3];
                    if (i4 == 0 || currentTimeMillis <= ((long) i4) || this.f34222h.contains(String.valueOf(i4))) {
                        i3++;
                    } else {
                        String valueOf = String.valueOf(i4);
                        CollectionModel a = m26146a(bArr, i, i2, z, z2);
                        this.f34222h.add(valueOf);
                        m26149a(a);
                        return;
                    }
                }
            }
            if (z && !this.f34222h.contains(f34215a)) {
                CollectionModel a2 = m26146a(bArr, i, i2, z, z2);
                this.f34222h.add(f34215a);
                m26149a(a2);
            }
        }
    }

    /* renamed from: a */
    private CollectionModel m26146a(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        String compressData = PreviewCollectionUtils.compressData(bArr, i, i2, this.f34219e, this.f34220f);
        String str = this.f34216b;
        int i3 = this.f34218d;
        this.f34218d = i3 + 1;
        return new CollectionModel(compressData, str, i3, z, z2);
    }

    /* renamed from: a */
    private void m26149a(final CollectionModel collectionModel) {
        if (collectionModel != null) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    CollectionManager.this.f34223i.add(collectionModel);
                }
            });
        }
    }

    public void dump(boolean z) {
        this.f34225k = true;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f34223i)) {
            if (z) {
                for (CollectionModel map : this.f34223i) {
                    System.out.println("dump !!!!!!!!!!!");
                    PayTracker.trackEvent(CollectionConstant.EVENT_ID, map.toMap());
                }
            } else {
                System.out.println("dump !!!!!!!!! no track");
            }
            this.f34223i.clear();
        }
    }

    public boolean hasCollectedData() {
        return !this.f34225k && !CollectionUtil.isEmpty((Collection<?>) this.f34223i);
    }
}
