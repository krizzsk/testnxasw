package com.didichuxing.xpanel.log;

import android.view.View;
import android.view.ViewGroup;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.xcard.ILifecycle;
import com.didichuxing.xpanel.xcard.loader.XCardManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;

public class CardLifecyclerHelper {
    public void dispatchLifecycle(ArrayList<XPanelCardData> arrayList, String str) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<XPanelCardData> it = arrayList.iterator();
            while (it.hasNext()) {
                dispatchViewLifecycle(it.next(), str);
            }
        }
    }

    public void dispatchViewLifecycle(XPanelCardData xPanelCardData, String str) {
        if (xPanelCardData.content != null) {
            View view = xPanelCardData.content.getView();
            if (xPanelCardData.content != null && view != null && XCardManager.XML_VIEW.equals(view.getTag(R.id.itemId))) {
                m39211a(view, str);
            }
        }
    }

    /* renamed from: a */
    private void m39211a(View view, String str) {
        m39212b(view, str);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                m39211a(viewGroup.getChildAt(i), str);
            }
        }
    }

    /* renamed from: b */
    private void m39212b(View view, String str) {
        if (view instanceof ILifecycle) {
            ILifecycle iLifecycle = (ILifecycle) view;
            char c = 65535;
            switch (str.hashCode()) {
                case -1340212393:
                    if (str.equals("onPause")) {
                        c = 1;
                        break;
                    }
                    break;
                case 474116102:
                    if (str.equals("cardMoveIn")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1463983852:
                    if (str.equals("onResume")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1812703373:
                    if (str.equals("cardMoveOut")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                iLifecycle.onResume();
            } else if (c == 1) {
                iLifecycle.onPause();
            } else if (c == 2) {
                iLifecycle.cardMoveOut();
            } else if (c == 3) {
                iLifecycle.cardMoveIn();
            }
        }
    }
}
