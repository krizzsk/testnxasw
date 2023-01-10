package rui.widget.popup.type.startend;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import java.util.List;
import rui.base.BaseViews;
import rui.internal.loopview.LoopView;
import rui.internal.loopview.OnItemSelectedListener;
import rui.util.ViewUtils;
import rui.widget.button.ButtonStyles;
import rui.widget.popup.PopupView;
import rui.widget.popup.base.IPopupFactory;
import rui.widget.popup.base.PopupViews;

public class FactoryPopupStartEnd implements IPopupFactory<PopupStartEnd> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Button f8671a;

    /* renamed from: b */
    private Button f8672b;

    /* renamed from: c */
    private Button f8673c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f8674d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f8675e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f8676f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f8677g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f8678h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LoopView f8679i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public LoopView f8680j;

    public void create(PopupView popupView, final PopupStartEnd popupStartEnd) {
        Context context = popupView.getContext();
        this.f8678h = popupStartEnd.defaultTab;
        View createTabTwo = PopupViews.createTabTwo(context, popupStartEnd.startTitle, popupStartEnd.endTitle, true);
        this.f8672b = (Button) createTabTwo.findViewById(R.id.tv_left_tab);
        this.f8673c = (Button) createTabTwo.findViewById(R.id.tv_right_tab);
        createTabTwo.findViewById(R.id.rui_ct_roller_picker_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (popupStartEnd.listener != null) {
                    popupStartEnd.listener.onCloseClicked();
                }
            }
        });
        this.f8672b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FactoryPopupStartEnd.this.f8679i.setItems(popupStartEnd.startDataLeft);
                FactoryPopupStartEnd.this.f8680j.setItems(popupStartEnd.startDataRight);
                FactoryPopupStartEnd.this.selectTab("left");
            }
        });
        this.f8673c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FactoryPopupStartEnd.this.f8679i.setItems(popupStartEnd.endDataLeft);
                FactoryPopupStartEnd.this.f8680j.setItems(popupStartEnd.endDataRight);
                FactoryPopupStartEnd.this.selectTab("right");
            }
        });
        popupView.addView(createTabTwo);
        View createSplit = BaseViews.createSplit(context);
        popupView.addView(createSplit);
        ((ViewGroup.MarginLayoutParams) createSplit.getLayoutParams()).topMargin = (int) ViewUtils.m7249dp(context, 18.0f);
        final View createLoopContainer = PopupViews.createLoopContainer(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        this.f8679i = PopupViews.createLoopView(context);
        this.f8680j = PopupViews.createLoopView(context);
        C35864 r3 = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    FactoryPopupStartEnd.this.f8671a.setEnabled(false);
                }
                return false;
            }
        };
        this.f8679i.setOnTouchListener(r3);
        this.f8680j.setOnTouchListener(r3);
        this.f8679i.setListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                FactoryPopupStartEnd.this.f8671a.setEnabled(true);
                if ("left".equals(FactoryPopupStartEnd.this.f8678h)) {
                    int unused = FactoryPopupStartEnd.this.f8674d = i;
                } else if ("right".equals(FactoryPopupStartEnd.this.f8678h)) {
                    int unused2 = FactoryPopupStartEnd.this.f8676f = i;
                }
                if (popupStartEnd.listener != null) {
                    popupStartEnd.listener.onUpdate(popupStartEnd.startDataLeft.get(FactoryPopupStartEnd.this.f8674d), popupStartEnd.startDataRight.get(FactoryPopupStartEnd.this.f8675e), popupStartEnd.endDataLeft.get(FactoryPopupStartEnd.this.f8676f), popupStartEnd.endDataRight.get(FactoryPopupStartEnd.this.f8677g));
                }
            }
        });
        this.f8680j.setListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                FactoryPopupStartEnd.this.f8671a.setEnabled(true);
                if ("left".equals(FactoryPopupStartEnd.this.f8678h)) {
                    int unused = FactoryPopupStartEnd.this.f8675e = i;
                } else if ("right".equals(FactoryPopupStartEnd.this.f8678h)) {
                    int unused2 = FactoryPopupStartEnd.this.f8677g = i;
                }
                if (popupStartEnd.listener != null) {
                    popupStartEnd.listener.onUpdate(popupStartEnd.startDataLeft.get(FactoryPopupStartEnd.this.f8674d), popupStartEnd.startDataRight.get(FactoryPopupStartEnd.this.f8675e), popupStartEnd.endDataLeft.get(FactoryPopupStartEnd.this.f8676f), popupStartEnd.endDataRight.get(FactoryPopupStartEnd.this.f8677g));
                }
            }
        });
        m7261a(this.f8678h, popupStartEnd, this.f8679i, this.f8680j);
        this.f8679i.setDecoratorLineLocationListener(new LoopView.DecoratorLineLocationListener() {
            public void onLineLocationChange(int i, int i2) {
                ((ViewGroup.MarginLayoutParams) createLoopContainer.findViewWithTag("split1").getLayoutParams()).topMargin = i;
                ((ViewGroup.MarginLayoutParams) createLoopContainer.findViewWithTag("split2").getLayoutParams()).topMargin = i2;
            }
        });
        ((LinearLayout) createLoopContainer.findViewWithTag("content")).addView(this.f8679i, layoutParams);
        ((LinearLayout) createLoopContainer.findViewWithTag("content")).addView(this.f8680j, layoutParams);
        popupView.addView(createLoopContainer);
        LinearLayout createButtonContainer = PopupViews.createButtonContainer(context);
        Button createButton = BaseViews.createButton(context, TextUtils.isEmpty(popupStartEnd.buttonTitle) ? "确定" : popupStartEnd.buttonTitle, ButtonStyles.BUTTON_MAIN_ORANGE, Integer.MIN_VALUE, (View.OnClickListener) null);
        this.f8671a = createButton;
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (popupStartEnd.listener != null) {
                    popupStartEnd.listener.onConfirm(popupStartEnd.startDataLeft.get(FactoryPopupStartEnd.this.f8674d), popupStartEnd.startDataRight.get(FactoryPopupStartEnd.this.f8675e), popupStartEnd.endDataLeft.get(FactoryPopupStartEnd.this.f8676f), popupStartEnd.endDataRight.get(FactoryPopupStartEnd.this.f8677g));
                }
            }
        });
        createButtonContainer.addView(this.f8671a);
        popupView.addView(createButtonContainer);
        m7262a(popupStartEnd);
        selectTab(this.f8678h);
    }

    public void updateConfirmTitle(String str) {
        Button button = this.f8671a;
        if (button != null) {
            button.setText(str);
        }
    }

    public void selectTab(String str) {
        if ("left".equals(str)) {
            this.f8672b.setSelected(true);
            this.f8673c.setSelected(false);
            this.f8678h = "left";
            this.f8679i.setCurrentPosition(this.f8674d);
            this.f8680j.setCurrentPosition(this.f8675e);
        } else if ("right".equals(str)) {
            this.f8672b.setSelected(false);
            this.f8673c.setSelected(true);
            this.f8678h = "right";
            this.f8679i.setCurrentPosition(this.f8676f);
            this.f8680j.setCurrentPosition(this.f8677g);
        }
    }

    /* renamed from: a */
    private void m7262a(PopupStartEnd popupStartEnd) {
        this.f8674d = m7258a(popupStartEnd.defaultStartLeft, popupStartEnd.startDataLeft);
        this.f8675e = m7258a(popupStartEnd.defaultStartRight, popupStartEnd.startDataRight);
        this.f8676f = m7258a(popupStartEnd.defaultEndLeft, popupStartEnd.endDataLeft);
        this.f8677g = m7258a(popupStartEnd.defaultEndRight, popupStartEnd.endDataRight);
    }

    /* renamed from: a */
    private static int m7258a(String str, List<String> list) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty() && (indexOf = list.indexOf(str)) != -1) {
            return indexOf;
        }
        return 0;
    }

    /* renamed from: a */
    private static void m7261a(String str, PopupStartEnd popupStartEnd, LoopView loopView, LoopView loopView2) {
        List<String> list;
        List<String> list2 = null;
        if ("left".equals(str)) {
            list2 = popupStartEnd.startDataLeft;
            list = popupStartEnd.startDataRight;
        } else if ("right".equals(str)) {
            list2 = popupStartEnd.endDataLeft;
            list = popupStartEnd.endDataRight;
        } else {
            list = null;
        }
        if (list2 != null && list != null) {
            loopView.setItems(list2);
            loopView2.setItems(list);
        }
    }
}
