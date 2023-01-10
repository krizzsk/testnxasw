package com.didi.soda.datasource.page;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.datasource.listener.DataMapFunction;
import com.didi.soda.datasource.listener.DataSourceListener;
import com.didi.soda.datasource.page.UpdateUtils;
import java.util.ArrayList;
import java.util.List;

public class PageStore<Value, Target> {

    /* renamed from: a */
    private static final String f44835a = "PageStore";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ArrayList<Target> f44836b = new ArrayList<>();

    /* renamed from: c */
    private DataMapFunction<Value, Target> f44837c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DataSourceListener<Value, Target> f44838d;

    public PageStore(DataMapFunction<Value, Target> dataMapFunction, DataSourceListener<Value, Target> dataSourceListener) {
        this.f44837c = dataMapFunction;
        this.f44838d = dataSourceListener;
    }

    public void insert(int i, Target target) {
        if (i <= this.f44836b.size() && i >= 0) {
            this.f44836b.add(i, target);
            DataSourceListener<Value, Target> dataSourceListener = this.f44838d;
            if (dataSourceListener != null) {
                dataSourceListener.onDataSourceChanged(this, new ArrayList(this.f44836b));
            }
        }
    }

    public void insert(int i, List<Target> list) {
        if (i <= this.f44836b.size() && i >= 0) {
            this.f44836b.addAll(i, list);
            DataSourceListener<Value, Target> dataSourceListener = this.f44838d;
            if (dataSourceListener != null) {
                dataSourceListener.onDataSourceChanged(this, new ArrayList(this.f44836b));
            }
        }
    }

    public void update(UpdateUtils.DiffCallback<Target> diffCallback, UpdateUtils.UpdateCallback<Target> updateCallback) {
        UpdateUtils.dispatchUpdate(diffCallback, updateCallback, new UpdateUtils.UpdateCompleteCallback<Target>() {
            public void onCompleted(List<Target> list) {
                if (PageStore.this.f44838d != null) {
                    PageStore.this.f44838d.onDataSourceUpdate(list);
                }
            }
        }, this.f44836b);
    }

    public int find(UpdateUtils.DiffCallback<Target> diffCallback) {
        return UpdateUtils.find(diffCallback, this.f44836b);
    }

    public void remove(UpdateUtils.DiffCallback<Target> diffCallback) {
        UpdateUtils.dispatchRemove(diffCallback, new UpdateUtils.UpdateCompleteCallback<Target>() {
            public void onCompleted(List<Target> list) {
                if (PageStore.this.f44838d != null) {
                    PageStore.this.f44838d.onDataSourceChanged(PageStore.this, new ArrayList(PageStore.this.f44836b));
                }
            }
        }, this.f44836b);
    }

    public boolean contains(UpdateUtils.DiffCallback<Target> diffCallback) {
        return UpdateUtils.contains(diffCallback, this.f44836b);
    }

    public List<Target> getTargetList() {
        return new ArrayList(this.f44836b);
    }

    public void receivePageResult(PageResult<Value> pageResult) {
        List<Target> mapData = this.f44837c.mapData(pageResult.getCurrentPage(), pageResult.getValueList());
        if (mapData == null || mapData.size() == 0) {
            LogUtil.m32586e(f44835a, "mapList 返回的数据列表为空，列表不会有任何变化，请返回一个数组，我才知道刷新列表数据");
        }
        if (pageResult.getResultType() == 1) {
            if (mapData != null) {
                this.f44836b.clear();
                this.f44836b.addAll(mapData);
            }
        } else if (pageResult.getResultType() == 2 && mapData != null) {
            this.f44836b.addAll(mapData);
        }
        DataSourceListener<Value, Target> dataSourceListener = this.f44838d;
        if (dataSourceListener != null) {
            dataSourceListener.onDataSourceChanged(this, new ArrayList(this.f44836b));
        }
    }

    public void provideStoredData() {
        DataSourceListener<Value, Target> dataSourceListener;
        ArrayList<Target> arrayList = this.f44836b;
        if (arrayList != null && arrayList.size() > 0 && (dataSourceListener = this.f44838d) != null) {
            dataSourceListener.onDataSourceChanged(this, new ArrayList(this.f44836b));
        }
    }
}
