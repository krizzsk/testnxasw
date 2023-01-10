package com.didi.component.common.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.appsflyer.internal.referrer.Payload;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class GlobalDialog extends BaseDialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f13378a;

    /* renamed from: b */
    private TextView f13379b;

    /* renamed from: c */
    private TextView f13380c;

    /* renamed from: d */
    private TextView f13381d;

    /* renamed from: e */
    private TextView f13382e;

    /* renamed from: f */
    private Builder f13383f;

    /* renamed from: g */
    private boolean f13384g;

    public interface IButtonAction {

        public enum ButtonType {
            NEGATIVE,
            POSITIVE
        }

        Runnable getAction();

        String getName();

        ButtonType getType();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017496);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_dialog_layout, viewGroup, false);
        m11217a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m11217a(View view) {
        this.f13378a = view.findViewById(R.id.global_dialog_content);
        this.f13379b = (TextView) view.findViewById(R.id.global_dialog_title);
        this.f13380c = (TextView) view.findViewById(R.id.global_dialog_desc);
        this.f13381d = (TextView) view.findViewById(R.id.global_dialog_negative);
        this.f13382e = (TextView) view.findViewById(R.id.global_dialog_positive);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Builder builder = this.f13383f;
        if (builder != null) {
            this.f13379b.setText(builder.title);
            this.f13380c.setVisibility(TextUtils.isEmpty(this.f13383f.message) ? 8 : 0);
            this.f13380c.setText(this.f13383f.message);
            this.f13382e.setVisibility(8);
            this.f13381d.setVisibility(8);
            for (final IButtonAction iButtonAction : this.f13383f.buttonActions) {
                int i = C53125.f13385x7f103bf7[iButtonAction.getType().ordinal()];
                if (i == 1) {
                    this.f13381d.setVisibility(0);
                    this.f13381d.setText(iButtonAction.getName());
                    this.f13381d.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (iButtonAction.getAction() != null) {
                                iButtonAction.getAction().run();
                            } else {
                                GlobalDialog.this.dismiss();
                            }
                        }
                    });
                } else if (i == 2) {
                    this.f13382e.setVisibility(0);
                    this.f13382e.setText(iButtonAction.getName());
                    this.f13382e.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (iButtonAction.getAction() != null) {
                                iButtonAction.getAction().run();
                            } else {
                                GlobalDialog.this.dismiss();
                            }
                        }
                    });
                }
            }
        }
        this.f13384g = false;
        this.f13378a.post(new Runnable() {
            public void run() {
                int measuredHeight = GlobalDialog.this.f13378a.getMeasuredHeight();
                GlobalDialog.this.f13378a.animate().cancel();
                GlobalDialog.this.f13378a.setTranslationY((float) measuredHeight);
                GlobalDialog.this.f13378a.animate().withStartAction(new Runnable() {
                    public void run() {
                        GlobalDialog.this.f13378a.setVisibility(0);
                    }
                }).translationYBy((float) (-measuredHeight)).setDuration(300).start();
            }
        });
    }

    /* renamed from: com.didi.component.common.dialog.GlobalDialog$5 */
    static /* synthetic */ class C53125 {

        /* renamed from: $SwitchMap$com$didi$component$common$dialog$GlobalDialog$IButtonAction$ButtonType */
        static final /* synthetic */ int[] f13385x7f103bf7;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.component.common.dialog.GlobalDialog$IButtonAction$ButtonType[] r0 = com.didi.component.common.dialog.GlobalDialog.IButtonAction.ButtonType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13385x7f103bf7 = r0
                com.didi.component.common.dialog.GlobalDialog$IButtonAction$ButtonType r1 = com.didi.component.common.dialog.GlobalDialog.IButtonAction.ButtonType.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13385x7f103bf7     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.component.common.dialog.GlobalDialog$IButtonAction$ButtonType r1 = com.didi.component.common.dialog.GlobalDialog.IButtonAction.ButtonType.POSITIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.common.dialog.GlobalDialog.C53125.<clinit>():void");
        }
    }

    public void dismiss() {
        View view = this.f13378a;
        if (view != null) {
            this.f13384g = true;
            this.f13378a.animate().translationYBy((float) view.getMeasuredHeight()).setDuration(300).withEndAction(new Runnable() {
                public void run() {
                    GlobalDialog.this.f13378a.setVisibility(4);
                    GlobalDialog.super.dismiss();
                }
            }).start();
        }
    }

    public boolean isPendingDismiss() {
        return this.f13384g;
    }

    public Builder build() {
        Builder builder = new Builder();
        this.f13383f = builder;
        return builder;
    }

    public class Builder {
        IButtonAction[] buttonActions;
        String message;
        String title;

        public Builder() {
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder content(String str) {
            this.message = str;
            return this;
        }

        public Builder actions(IButtonAction[] iButtonActionArr) {
            this.buttonActions = iButtonActionArr;
            return this;
        }

        public void show(final FragmentManager fragmentManager, final String str) {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    if (fragmentManager != null) {
                        GlobalDialog.this.show(fragmentManager, str);
                    }
                }
            }, 300);
        }
    }

    public static abstract class PositiveButtonAction implements IButtonAction {
        public Runnable getAction() {
            return null;
        }

        public String getName() {
            return Payload.RESPONSE_OK;
        }

        public IButtonAction.ButtonType getType() {
            return IButtonAction.ButtonType.POSITIVE;
        }
    }
}
