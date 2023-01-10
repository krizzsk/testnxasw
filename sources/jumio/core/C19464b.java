package jumio.core;

import android.location.Address;
import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import java.util.ArrayList;

@PersistWith("AddressModel")
/* renamed from: jumio.core.b */
/* compiled from: AddressModel */
public class C19464b implements StaticModel {

    /* renamed from: a */
    public ArrayList<String> f55324a;

    /* renamed from: b */
    public String f55325b;

    /* renamed from: c */
    public String f55326c;

    /* renamed from: d */
    public String f55327d;

    /* renamed from: a */
    public void mo148601a(Address address) {
        address.getLocale();
        address.getFeatureName();
        this.f55324a = new ArrayList<>();
        for (int i = 0; i <= address.getMaxAddressLineIndex(); i++) {
            this.f55324a.add(address.getAddressLine(i));
        }
        this.f55325b = address.getAdminArea();
        address.getSubAdminArea();
        address.getLocality();
        address.getSubLocality();
        address.getThoroughfare();
        address.getSubThoroughfare();
        address.getPremises();
        this.f55326c = address.getPostalCode();
        this.f55327d = address.getCountryCode();
        address.getCountryName();
        address.getLatitude();
        address.getLongitude();
        address.getPhone();
        address.getUrl();
    }

    /* renamed from: b */
    public String mo148602b() {
        return this.f55325b;
    }

    /* renamed from: c */
    public String mo148603c() {
        return this.f55327d;
    }

    /* renamed from: d */
    public String mo148604d() {
        return this.f55326c;
    }

    /* renamed from: a */
    public ArrayList<String> mo148600a() {
        return this.f55324a;
    }
}
