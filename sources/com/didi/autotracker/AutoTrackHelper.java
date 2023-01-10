package com.didi.autotracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ToggleButton;
import androidx.appcompat.widget.SwitchCompat;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.omega.sdk.analysis.AnalysisFragmentListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AutoTrackHelper {

    /* renamed from: a */
    private static boolean f10515a = false;

    public static void track(Map<String, Object> map) {
        map.put("pn", AnalysisFragmentListener.getCurrentFramentName());
        map.put("at", "1");
        LoggerFactory.getLogger("GlobalUiTrack").info("ui click", (Map<?, ?>) map);
    }

    public static void setEnable(boolean z) {
        f10515a = z;
    }

    public static void trackViewOnClick(DialogInterface dialogInterface, int i) {
        if (f10515a) {
            try {
                Button button = null;
                Dialog dialog = dialogInterface instanceof Dialog ? (Dialog) dialogInterface : null;
                if (dialog != null) {
                    Activity a = C4358a.m9200a(dialog.getContext());
                    if (a == null) {
                        a = dialog.getOwnerActivity();
                    }
                    HashMap hashMap = new HashMap();
                    if (a != null) {
                        hashMap.put("rpn", a.getClass().getCanonicalName());
                    }
                    if (dialog instanceof AlertDialog) {
                        button = ((AlertDialog) dialog).getButton(i);
                    } else if (dialog instanceof androidx.appcompat.app.AlertDialog) {
                        button = ((androidx.appcompat.app.AlertDialog) dialog).getButton(i);
                    }
                    if (button != null) {
                        hashMap.put("content", button.getText());
                    }
                    hashMap.put("type", "Dialog");
                    track(hashMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void trackViewOnClick(CompoundButton compoundButton, boolean z) {
        String str;
        String charSequence;
        if (f10515a) {
            try {
                Context context = compoundButton.getContext();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    Activity a = C4358a.m9200a(context);
                    hashMap.put("id", C4358a.m9201a((View) compoundButton));
                    if (a != null) {
                        hashMap.put("rpn", a.getClass().getCanonicalName());
                    }
                    String str2 = null;
                    if (compoundButton instanceof CheckBox) {
                        str = "CheckBox";
                        CheckBox checkBox = (CheckBox) compoundButton;
                        if (!TextUtils.isEmpty(checkBox.getText())) {
                            str2 = checkBox.getText().toString();
                        }
                    } else if (compoundButton instanceof SwitchCompat) {
                        str = "SwitchCompat";
                        SwitchCompat switchCompat = (SwitchCompat) compoundButton;
                        if (z) {
                            if (!TextUtils.isEmpty(switchCompat.getTextOn())) {
                                str2 = switchCompat.getTextOn().toString();
                            }
                        } else if (!TextUtils.isEmpty(switchCompat.getTextOff())) {
                            str2 = switchCompat.getTextOff().toString();
                        }
                    } else {
                        if (compoundButton instanceof ToggleButton) {
                            str = "ToggleButton";
                            ToggleButton toggleButton = (ToggleButton) compoundButton;
                            if (z) {
                                if (!TextUtils.isEmpty(toggleButton.getTextOn())) {
                                    charSequence = toggleButton.getTextOn().toString();
                                }
                            } else if (!TextUtils.isEmpty(toggleButton.getTextOff())) {
                                charSequence = toggleButton.getTextOff().toString();
                            }
                        } else if (compoundButton instanceof RadioButton) {
                            str = "RadioButton";
                            RadioButton radioButton = (RadioButton) compoundButton;
                            if (!TextUtils.isEmpty(radioButton.getText())) {
                                charSequence = radioButton.getText().toString();
                            }
                        } else {
                            str = compoundButton.getClass().getCanonicalName();
                        }
                        str2 = charSequence;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap.put("content", str2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put("type", str);
                    }
                    hashMap.put("isChecked", Boolean.valueOf(z));
                    track(hashMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void trackViewOnClick(RadioGroup radioGroup, int i) {
        if (f10515a) {
            try {
                Context context = radioGroup.getContext();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    Activity a = C4358a.m9200a(context);
                    hashMap.put("id", C4358a.m9201a((View) radioGroup));
                    if (a != null) {
                        hashMap.put("rpn", a.getClass().getCanonicalName());
                    }
                    int childCount = radioGroup.getChildCount();
                    String str = null;
                    String str2 = null;
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = radioGroup.getChildAt(i2);
                        if (childAt.getId() == i && (childAt instanceof RadioButton)) {
                            str2 = "RadioButton";
                            RadioButton radioButton = (RadioButton) childAt;
                            if (!TextUtils.isEmpty(radioButton.getText())) {
                                str = radioButton.getText().toString();
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put("content", str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap.put("type", str2);
                    }
                    hashMap.put("checkedId", Integer.valueOf(i));
                    track(hashMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void trackViewOnClick(DialogInterface dialogInterface, int i, boolean z) {
        Object item;
        if (f10515a) {
            try {
                ListView listView = null;
                Dialog dialog = dialogInterface instanceof Dialog ? (Dialog) dialogInterface : null;
                if (dialog != null) {
                    Activity a = C4358a.m9200a(dialog.getContext());
                    if (a == null) {
                        a = dialog.getOwnerActivity();
                    }
                    HashMap hashMap = new HashMap();
                    if (a != null) {
                        hashMap.put("rpn", a.getClass().getCanonicalName());
                    }
                    if (dialog instanceof AlertDialog) {
                        listView = ((AlertDialog) dialog).getListView();
                    } else if (dialog instanceof androidx.appcompat.app.AlertDialog) {
                        listView = ((androidx.appcompat.app.AlertDialog) dialog).getListView();
                    }
                    if (!(listView == null || (item = listView.getAdapter().getItem(i)) == null || !(item instanceof String))) {
                        hashMap.put("content", item);
                    }
                    hashMap.put("isChecked", Boolean.valueOf(z));
                    hashMap.put("type", "Dialog");
                    track(hashMap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void trackViewOnClick(Object obj, MenuItem menuItem) {
        if (f10515a) {
            try {
                String str = null;
                Context context = obj instanceof Context ? (Context) obj : null;
                HashMap hashMap = new HashMap();
                hashMap.put("type", "menuItem");
                hashMap.put("content", menuItem.getTitle());
                if (context != null) {
                    try {
                        str = context.getResources().getResourceEntryName(menuItem.getItemId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put("id", str);
                    }
                    Activity a = C4358a.m9200a(context);
                    if (a != null) {
                        hashMap.put("rpn", a.getClass().getCanonicalName());
                    }
                }
                track(hashMap);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void trackTabHost(String str) {
        if (f10515a) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("type", "TabHost");
                hashMap.put("content", str);
                track(hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void trackExpandableListViewGroupOnClick(ExpandableListView expandableListView, View view, int i) {
        trackExpandableListViewChildOnClick(expandableListView, view, i, -1);
    }

    public static void trackExpandableListViewChildOnClick(ExpandableListView expandableListView, View view, int i, int i2) {
        if (f10515a) {
            try {
                Context context = expandableListView.getContext();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    Activity a = C4358a.m9200a(context);
                    if (a != null) {
                        hashMap.put("rpn", a.getClass().getCanonicalName());
                    }
                    if (i2 != -1) {
                        hashMap.put("position", String.format(Locale.CHINA, "%d:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                    } else {
                        hashMap.put("position", String.format(Locale.CHINA, TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(i)}));
                    }
                    String a2 = C4358a.m9201a((View) expandableListView);
                    if (!TextUtils.isEmpty(a2)) {
                        hashMap.put("id", a2);
                    }
                    hashMap.put("type", "ExpandableListView");
                    String str = null;
                    if (view instanceof ViewGroup) {
                        try {
                            str = C4358a.m9202a(new StringBuilder(), (ViewGroup) view);
                            if (!TextUtils.isEmpty(str)) {
                                str = str.substring(0, str.length() - 1);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put("content", str);
                    }
                    hashMap.put("name", view.getClass().getName());
                    track(hashMap);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void trackViewOnClick(AdapterView adapterView, View view, int i) {
        if (f10515a) {
            try {
                Context context = adapterView.getContext();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    Activity a = C4358a.m9200a(context);
                    String a2 = C4358a.m9201a((View) adapterView);
                    if (!TextUtils.isEmpty(a2)) {
                        hashMap.put("id", a2);
                    }
                    if (a != null) {
                        hashMap.put("rpn", a.getClass().getCanonicalName());
                    }
                    hashMap.put("position", String.valueOf(i));
                    if (adapterView instanceof Spinner) {
                        hashMap.put("type", "Spinner");
                        Object itemAtPosition = adapterView.getItemAtPosition(i);
                        if (itemAtPosition != null && (itemAtPosition instanceof String)) {
                            hashMap.put("content", itemAtPosition);
                        }
                    } else {
                        if (adapterView instanceof ListView) {
                            hashMap.put("type", "ListView");
                        } else if (adapterView instanceof GridView) {
                            hashMap.put("type", "GridView");
                        }
                        String str = null;
                        if (view instanceof ViewGroup) {
                            try {
                                str = C4358a.m9202a(new StringBuilder(), (ViewGroup) view);
                                if (!TextUtils.isEmpty(str)) {
                                    str = str.substring(0, str.length() - 1);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            str = C4358a.m9204c(view);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            hashMap.put("content", str);
                        }
                    }
                    hashMap.put("name", view.getClass().getName());
                    track(hashMap);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void trackViewOnClick(View view) {
        if (f10515a) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("type", C4358a.m9203b(view));
                hashMap.put("id", C4358a.m9201a(view));
                hashMap.put("name", view.getClass().getName());
                hashMap.put("content", C4358a.m9204c(view));
                Activity d = C4358a.m9205d(view);
                if (d != null) {
                    hashMap.put("rpn", d.getClass().getCanonicalName());
                }
                track(hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
