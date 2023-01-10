package com.didi.sdk.view.actionsheet;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.sidebar.account.MyAccountBaseFragment;
import com.taxis99.R;

public class ActionSheet extends MyAccountBaseFragment {
    public static final String KEY_ACTION_SHEET_CALLBACK = "com.didi.sdk.action.KEY_ACTION_SHEET_CALLBACK";
    public static final String KEY_LIST_ITEM_ARRAY = "com.didi.sdk.action.KEY_LIST_ITEM_ARRAY";

    /* renamed from: a */
    private TextView f40644a;

    /* renamed from: b */
    private ListView f40645b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ArrayAdapter<String> f40646c;

    /* renamed from: d */
    private View f40647d;

    /* renamed from: e */
    private FragmentManager f40648e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ActionSheetCallback f40649f;

    public interface ActionSheetCallback {
        void onItemSelected(int i, String str);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ActionSheetCallback) {
            this.f40649f = (ActionSheetCallback) activity;
        }
    }

    public void setActionSheetCallback(ActionSheetCallback actionSheetCallback) {
        this.f40649f = actionSheetCallback;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f40648e = getActivity().getSupportFragmentManager();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!initStyle()) {
            return null;
        }
        View inflate = layoutInflater.inflate(R.layout.v_bottom_list_menu, (ViewGroup) null);
        Bundle arguments = getArguments();
        if (arguments != null) {
            initView(inflate, arguments.getStringArray(KEY_LIST_ITEM_ARRAY));
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void initView(View view, String[] strArr) {
        TextView textView = (TextView) view.findViewById(R.id.cancel_text);
        this.f40644a = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ActionSheet.this.dismiss();
            }
        });
        this.f40645b = (ListView) view.findViewById(R.id.menu_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.v_bottom_list_menu_item, strArr);
        this.f40646c = arrayAdapter;
        this.f40645b.setAdapter(arrayAdapter);
        this.f40645b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                ActionSheet.this.dismiss();
                if (ActionSheet.this.f40649f != null) {
                    ActionSheet.this.f40649f.onItemSelected(i, (String) ActionSheet.this.f40646c.getItem(i));
                }
            }
        });
        View findViewById = view.findViewById(R.id.root);
        this.f40647d = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ActionSheet.this.dismiss();
            }
        });
    }
}
