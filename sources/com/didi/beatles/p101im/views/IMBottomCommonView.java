package com.didi.beatles.p101im.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.beatles.p101im.resource.IMResource;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.IMBottomCommonView */
public class IMBottomCommonView extends LinearLayout {

    /* renamed from: a */
    private ListView f11695a;

    /* renamed from: b */
    private List<String> f11696b;

    /* renamed from: c */
    private CommonAdapter f11697c;

    public IMBottomCommonView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMBottomCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.bts_im_bottom_common, this, true);
        this.f11695a = (ListView) findViewById(R.id.bottom_list);
        m10059a(context);
    }

    /* renamed from: a */
    private void m10059a(Context context) {
        CommonAdapter commonAdapter = new CommonAdapter(this.f11696b, context);
        this.f11697c = commonAdapter;
        this.f11695a.setAdapter(commonAdapter);
    }

    public void setDatas(List<String> list) {
        this.f11696b = list;
        this.f11697c.notifyDataSetChanged();
    }

    /* renamed from: com.didi.beatles.im.views.IMBottomCommonView$CommonAdapter */
    public class CommonAdapter extends BaseAdapter {
        private List<String> datas = new ArrayList();
        private Context mContext;

        public int getCount() {
            return 6;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public CommonAdapter(List<String> list, Context context) {
            this.mContext = context;
        }

        public Object getItem(int i) {
            return this.datas.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHodler viewHodler;
            if (view == null) {
                viewHodler = new ViewHodler();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.bts_common_item_layout, (ViewGroup) null);
                viewHodler.f11698tv = (TextView) view.findViewById(R.id.common_text);
                view.setTag(viewHodler);
            } else {
                viewHodler = (ViewHodler) view.getTag();
            }
            viewHodler.f11698tv.setText(IMResource.getString(R.string.im_say_hi));
            return view;
        }

        /* renamed from: com.didi.beatles.im.views.IMBottomCommonView$CommonAdapter$ViewHodler */
        class ViewHodler {

            /* renamed from: tv */
            TextView f11698tv;

            ViewHodler() {
            }
        }
    }
}
