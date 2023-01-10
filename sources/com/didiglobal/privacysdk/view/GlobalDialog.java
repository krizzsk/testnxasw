package com.didiglobal.privacysdk.view;

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
    public View f53215a;

    /* renamed from: b */
    private TextView f53216b;

    /* renamed from: c */
    private TextView f53217c;

    /* renamed from: d */
    private TextView f53218d;

    /* renamed from: e */
    private TextView f53219e;

    /* renamed from: f */
    private Builder f53220f;

    /* renamed from: g */
    private boolean f53221g;

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
        View inflate = layoutInflater.inflate(R.layout.global_privacy_global_dialog_layout, viewGroup, false);
        m39808a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m39808a(View view) {
        this.f53215a = view.findViewById(R.id.global_dialog_content);
        this.f53216b = (TextView) view.findViewById(R.id.global_dialog_title);
        this.f53217c = (TextView) view.findViewById(R.id.global_dialog_desc);
        this.f53218d = (TextView) view.findViewById(R.id.global_dialog_negative);
        this.f53219e = (TextView) view.findViewById(R.id.global_dialog_positive);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Builder builder = this.f53220f;
        if (builder != null) {
            this.f53216b.setText(builder.title);
            this.f53217c.setVisibility(TextUtils.isEmpty(this.f53220f.message) ? 8 : 0);
            this.f53217c.setText(this.f53220f.message);
            this.f53219e.setVisibility(8);
            this.f53218d.setVisibility(8);
            for (final IButtonAction iButtonAction : this.f53220f.buttonActions) {
                int i = C178595.f53222x3bc6f677[iButtonAction.getType().ordinal()];
                if (i == 1) {
                    this.f53218d.setVisibility(0);
                    this.f53218d.setText(iButtonAction.getName());
                    this.f53218d.setOnClickListener(new View.OnClickListener() {
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
                    this.f53219e.setVisibility(0);
                    this.f53219e.setText(iButtonAction.getName());
                    this.f53219e.setOnClickListener(new View.OnClickListener() {
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
        this.f53221g = false;
        this.f53215a.post(new Runnable() {
            public void run() {
                int measuredHeight = GlobalDialog.this.f53215a.getMeasuredHeight();
                GlobalDialog.this.f53215a.animate().cancel();
                GlobalDialog.this.f53215a.setTranslationY((float) measuredHeight);
                GlobalDialog.this.f53215a.animate().withStartAction(new Runnable() {
                    public void run() {
                        GlobalDialog.this.f53215a.setVisibility(0);
                    }
                }).translationYBy((float) (-measuredHeight)).setDuration(300).start();
            }
        });
    }

    /* renamed from: com.didiglobal.privacysdk.view.GlobalDialog$5 */
    static /* synthetic */ class C178595 {

        /* renamed from: $SwitchMap$com$didiglobal$privacysdk$view$GlobalDialog$IButtonAction$ButtonType */
        static final /* synthetic */ int[] f53222x3bc6f677;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didiglobal.privacysdk.view.GlobalDialog$IButtonAction$ButtonType[] r0 = com.didiglobal.privacysdk.view.GlobalDialog.IButtonAction.ButtonType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f53222x3bc6f677 = r0
                com.didiglobal.privacysdk.view.GlobalDialog$IButtonAction$ButtonType r1 = com.didiglobal.privacysdk.view.GlobalDialog.IButtonAction.ButtonType.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f53222x3bc6f677     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didiglobal.privacysdk.view.GlobalDialog$IButtonAction$ButtonType r1 = com.didiglobal.privacysdk.view.GlobalDialog.IButtonAction.ButtonType.POSITIVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.privacysdk.view.GlobalDialog.C178595.<clinit>():void");
        }
    }

    public void dismiss() {
        this.f53221g = true;
        this.f53215a.animate().translationYBy((float) this.f53215a.getMeasuredHeight()).setDuration(300).withEndAction(new Runnable() {
            public void run() {
                GlobalDialog.this.f53215a.setVisibility(4);
                GlobalDialog.super.dismiss();
            }
        }).start();
    }

    public boolean isPendingDismiss() {
        return this.f53221g;
    }

    public Builder build() {
        Builder builder = new Builder();
        this.f53220f = builder;
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
