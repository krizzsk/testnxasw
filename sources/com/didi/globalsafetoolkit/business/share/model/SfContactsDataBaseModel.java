package com.didi.globalsafetoolkit.business.share.model;

import android.text.TextUtils;
import com.didi.globalsafetoolkit.business.share.util.SfCharMapUtil;
import com.didi.globalsafetoolkit.model.SfContactsModel;

public class SfContactsDataBaseModel extends SfContactsModel implements Comparable<SfContactsDataBaseModel> {

    /* renamed from: id */
    public long f25102id;

    public int compareTo(SfContactsDataBaseModel sfContactsDataBaseModel) {
        if (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(sfContactsDataBaseModel.name)) {
            return -1;
        }
        return compareTo(sfContactsDataBaseModel, 0);
    }

    public int compareTo(SfContactsDataBaseModel sfContactsDataBaseModel, int i) {
        if (i < this.name.length() || i < sfContactsDataBaseModel.name.length()) {
            if (i >= this.name.length()) {
                return -1;
            }
            if (i >= sfContactsDataBaseModel.name.length()) {
                return 1;
            }
            char charAt = sfContactsDataBaseModel.name.charAt(i);
            char charAt2 = this.name.charAt(i);
            if (i == 0) {
                charAt = SfCharMapUtil.getGroupCharForSort(charAt);
                charAt2 = SfCharMapUtil.getGroupCharForSort(charAt2);
            }
            if (charAt2 > charAt) {
                return 1;
            }
            if (charAt2 < charAt) {
                return -1;
            }
            return compareTo(sfContactsDataBaseModel, i + 1);
        } else if (this.f25102id > sfContactsDataBaseModel.f25102id) {
            return 1;
        } else {
            return -1;
        }
    }
}
