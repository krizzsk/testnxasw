package com.didi.sdk.global.enterprise.model.data;

import com.didi.sdk.global.enterprise.model.bean.CompanyBean;
import com.didi.sdk.global.enterprise.model.bean.CostCenterBean;
import com.didi.sdk.global.enterprise.model.bean.ProjectBean;
import com.didi.sdk.global.indexbar.data.BaseGroup;
import com.didi.sdk.logging.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import rui.config.RConfigConstants;

@Deprecated
public class EnterpriseItem extends BaseGroup {

    /* renamed from: a */
    private String f38925a;

    /* renamed from: b */
    private String f38926b;

    /* renamed from: c */
    private Object f38927c;

    public String getId() {
        return this.f38925a;
    }

    public void setId(String str) {
        this.f38925a = str;
    }

    public String getName() {
        return this.f38926b;
    }

    public void setName(String str) {
        this.f38926b = str;
    }

    public Object getBean() {
        return this.f38927c;
    }

    public void setBean(Object obj) {
        this.f38927c = obj;
    }

    public static EnterpriseItem transform(CompanyBean companyBean) {
        if (companyBean == null) {
            return null;
        }
        EnterpriseItem enterpriseItem = new EnterpriseItem();
        enterpriseItem.setId(companyBean.f38922id);
        enterpriseItem.setName(companyBean.name);
        enterpriseItem.setBean(companyBean);
        return enterpriseItem;
    }

    public static List<EnterpriseItem> transformCompanyList(List<CompanyBean> list) {
        if (list == null) {
            return null;
        }
        LoggerFactory.getLogger("Enterprise").info(">>>> transformCompanyList, %d", Integer.valueOf(list.size()));
        ArrayList arrayList = new ArrayList();
        for (CompanyBean transform : list) {
            EnterpriseItem transform2 = transform(transform);
            if (transform2 != null) {
                arrayList.add(transform2);
            }
        }
        LoggerFactory.getLogger("Enterprise").info(">>>> transformCompanyList, %d", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public static EnterpriseItem transform(CostCenterBean costCenterBean) {
        if (costCenterBean == null) {
            return null;
        }
        EnterpriseItem enterpriseItem = new EnterpriseItem();
        enterpriseItem.setId(costCenterBean.f38923id);
        enterpriseItem.setName(costCenterBean.name);
        enterpriseItem.setBean(costCenterBean);
        return enterpriseItem;
    }

    public static List<EnterpriseItem> transformCostCenterList(List<CostCenterBean> list) {
        if (list == null) {
            return null;
        }
        LoggerFactory.getLogger("Enterprise").info(">>>> transformCostCenterList, %d", Integer.valueOf(list.size()));
        ArrayList arrayList = new ArrayList();
        for (CostCenterBean transform : list) {
            EnterpriseItem transform2 = transform(transform);
            if (transform2 != null) {
                arrayList.add(transform2);
            }
        }
        LoggerFactory.getLogger("Enterprise").info(">>>> transformCostCenterList, %d", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public static EnterpriseItem transform(ProjectBean projectBean) {
        if (projectBean == null) {
            return null;
        }
        EnterpriseItem enterpriseItem = new EnterpriseItem();
        enterpriseItem.setId(projectBean.f38924id);
        enterpriseItem.setName(projectBean.name);
        enterpriseItem.setBean(projectBean);
        return enterpriseItem;
    }

    public static List<EnterpriseItem> transformProjectList(List<ProjectBean> list) {
        if (list == null) {
            return null;
        }
        LoggerFactory.getLogger("Enterprise").info(">>>> transformProjectList, %d", Integer.valueOf(list.size()));
        ArrayList arrayList = new ArrayList();
        for (ProjectBean transform : list) {
            EnterpriseItem transform2 = transform(transform);
            if (transform2 != null) {
                arrayList.add(transform2);
            }
        }
        LoggerFactory.getLogger("Enterprise").info(">>>> transformProjectList, %d", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void generateGroup() {
        char c = this.f38926b.toCharArray()[0];
        if (String.valueOf(c).matches("[A-Za-z]")) {
            setGroup(String.valueOf(c).toUpperCase());
        } else {
            setGroup(RConfigConstants.KEYWORD_COLOR_SIGN);
        }
    }
}
