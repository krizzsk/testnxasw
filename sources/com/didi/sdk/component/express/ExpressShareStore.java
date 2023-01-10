package com.didi.sdk.component.express;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.util.SingletonHolder;

public class ExpressShareStore extends BaseStore {
    public static final String ACTION_FROM_ADDRESS_CHANGED = "com.sdu.didi.psnger.action.FROM_ADDRESS_CHANGED";

    /* renamed from: a */
    private static final String f38415a = "exshare-debug";

    /* renamed from: b */
    private Logger f38416b = LoggerFactory.getLogger("ExpressShareStore");

    /* renamed from: c */
    private Address f38417c;

    /* renamed from: d */
    private Address f38418d;

    /* renamed from: e */
    private long f38419e;

    /* renamed from: f */
    private long f38420f;

    private ExpressShareStore() {
        super("framework-ExpressShareStore");
    }

    public static ExpressShareStore getInstance() {
        return (ExpressShareStore) SingletonHolder.getInstance(ExpressShareStore.class);
    }

    public synchronized Address getFromAddress() {
        return this.f38417c;
    }

    public synchronized long getLastFromTime() {
        return this.f38420f;
    }

    public synchronized void setFromAddress(Address address) {
        this.f38416b.infoEvent(f38415a, f38415a, "setFromAddress");
        this.f38417c = address;
        if (address != null) {
            Logger logger = this.f38416b;
            logger.infoEvent(f38415a, f38415a, "setFromAddress name = " + address.getDisplayName() + " cityId = " + address.getCityId());
        }
        this.f38420f = System.currentTimeMillis();
    }

    public synchronized Address getToAddress() {
        return this.f38418d;
    }

    public void setToAddress(Address address) {
        this.f38418d = address;
        if (address != null) {
            this.f38416b.infoEvent(f38415a, f38415a, address.toString());
        }
    }

    public synchronized long getDepartureTime() {
        return this.f38419e;
    }

    public synchronized void setDepartureTime(long j) {
        Logger logger = this.f38416b;
        logger.infoEvent(f38415a, f38415a, "ExpressShareStore setDepartureTime  mDepartureTime = " + j);
        this.f38419e = j;
    }

    public void notifyFromAddressChanged(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(ACTION_FROM_ADDRESS_CHANGED));
    }
}
