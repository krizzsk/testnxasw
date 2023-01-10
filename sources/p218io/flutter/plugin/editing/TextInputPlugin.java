package p218io.flutter.plugin.editing;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import java.util.ArrayList;
import java.util.HashMap;
import p218io.flutter.Log;
import p218io.flutter.embedding.android.KeyboardManager;
import p218io.flutter.embedding.engine.systemchannels.TextInputChannel;
import p218io.flutter.plugin.editing.ListenableEditingState;
import p218io.flutter.plugin.platform.PlatformViewsController;

/* renamed from: io.flutter.plugin.editing.TextInputPlugin */
public class TextInputPlugin implements ListenableEditingState.EditingStateWatcher {

    /* renamed from: a */
    private static final String f60571a = "TextInputPlugin";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final View f60572b;

    /* renamed from: c */
    private final InputMethodManager f60573c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final AutofillManager f60574d;

    /* renamed from: e */
    private final TextInputChannel f60575e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public InputTarget f60576f = new InputTarget(InputTarget.Type.NO_TARGET, 0);

    /* renamed from: g */
    private TextInputChannel.Configuration f60577g;

    /* renamed from: h */
    private SparseArray<TextInputChannel.Configuration> f60578h;

    /* renamed from: i */
    private ListenableEditingState f60579i;

    /* renamed from: j */
    private boolean f60580j;

    /* renamed from: k */
    private InputConnection f60581k;

    /* renamed from: l */
    private PlatformViewsController f60582l;

    /* renamed from: m */
    private Rect f60583m;

    /* renamed from: n */
    private ImeSyncDeferringInsetsCallback f60584n;

    /* renamed from: o */
    private TextInputChannel.TextEditState f60585o;

    /* renamed from: p */
    private boolean f60586p;

    /* renamed from: io.flutter.plugin.editing.TextInputPlugin$MinMax */
    private interface MinMax {
        void inspect(double d, double d2);
    }

    public TextInputPlugin(View view, TextInputChannel textInputChannel, PlatformViewsController platformViewsController) {
        int i = 0;
        this.f60572b = view;
        this.f60579i = new ListenableEditingState((TextInputChannel.TextEditState) null, this.f60572b);
        this.f60573c = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f60574d = (AutofillManager) view.getContext().getSystemService(AutofillManager.class);
        } else {
            this.f60574d = null;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            i = (this.f60572b.getWindowSystemUiVisibility() & 2) == 0 ? 0 | WindowInsets.Type.navigationBars() : i;
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view, (this.f60572b.getWindowSystemUiVisibility() & 4) == 0 ? i | WindowInsets.Type.statusBars() : i, WindowInsets.Type.ime());
            this.f60584n = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.f60575e = textInputChannel;
        textInputChannel.setTextInputMethodHandler(new TextInputChannel.TextInputMethodHandler() {
            public void show() {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.mo182577a(textInputPlugin.f60572b);
            }

            public void hide() {
                if (TextInputPlugin.this.f60576f.type == InputTarget.Type.HC_PLATFORM_VIEW) {
                    TextInputPlugin.this.m45678g();
                    return;
                }
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.m45671b(textInputPlugin.f60572b);
            }

            public void requestAutofill() {
                TextInputPlugin.this.m45677f();
            }

            public void finishAutofillContext(boolean z) {
                if (Build.VERSION.SDK_INT >= 26 && TextInputPlugin.this.f60574d != null) {
                    if (z) {
                        TextInputPlugin.this.f60574d.commit();
                    } else {
                        TextInputPlugin.this.f60574d.cancel();
                    }
                }
            }

            public void setClient(int i, TextInputChannel.Configuration configuration) {
                TextInputPlugin.this.mo182576a(i, configuration);
            }

            public void setPlatformViewClient(int i, boolean z) {
                TextInputPlugin.this.m45663a(i, z);
            }

            public void setEditingState(TextInputChannel.TextEditState textEditState) {
                TextInputPlugin textInputPlugin = TextInputPlugin.this;
                textInputPlugin.mo182578a(textInputPlugin.f60572b, textEditState);
            }

            public void setEditableSizeAndTransform(double d, double d2, double[] dArr) {
                TextInputPlugin.this.m45662a(d, d2, dArr);
            }

            public void clearClient() {
                TextInputPlugin.this.mo182581c();
            }

            public void sendAppPrivateCommand(String str, Bundle bundle) {
                TextInputPlugin.this.sendTextInputAppPrivateCommand(str, bundle);
            }
        });
        textInputChannel.requestExistingInputState();
        this.f60582l = platformViewsController;
        platformViewsController.attachTextInputPlugin(this);
    }

    public InputMethodManager getInputMethodManager() {
        return this.f60573c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Editable mo182575a() {
        return this.f60579i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ImeSyncDeferringInsetsCallback mo182580b() {
        return this.f60584n;
    }

    public void lockPlatformViewInputConnection() {
        if (this.f60576f.type == InputTarget.Type.VD_PLATFORM_VIEW) {
            this.f60586p = true;
        }
    }

    public void unlockPlatformViewInputConnection() {
        this.f60586p = false;
    }

    public void destroy() {
        this.f60582l.detachTextInputPlugin();
        this.f60575e.setTextInputMethodHandler((TextInputChannel.TextInputMethodHandler) null);
        m45678g();
        this.f60579i.mo182554b(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.f60584n;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    /* renamed from: a */
    private static int m45660a(TextInputChannel.InputType inputType, boolean z, boolean z2, boolean z3, boolean z4, TextInputChannel.TextCapitalization textCapitalization) {
        int i;
        if (inputType.type == TextInputChannel.TextInputType.DATETIME) {
            return 4;
        }
        if (inputType.type == TextInputChannel.TextInputType.NUMBER) {
            int i2 = 2;
            if (inputType.isSigned) {
                i2 = 4098;
            }
            return inputType.isDecimal ? i2 | 8192 : i2;
        } else if (inputType.type == TextInputChannel.TextInputType.PHONE) {
            return 3;
        } else {
            if (inputType.type == TextInputChannel.TextInputType.NONE) {
                return 0;
            }
            int i3 = 1;
            if (inputType.type == TextInputChannel.TextInputType.MULTILINE) {
                i3 = 131073;
            } else if (inputType.type == TextInputChannel.TextInputType.EMAIL_ADDRESS) {
                i3 = 33;
            } else if (inputType.type == TextInputChannel.TextInputType.URL) {
                i3 = 17;
            } else if (inputType.type == TextInputChannel.TextInputType.VISIBLE_PASSWORD) {
                i3 = 145;
            } else if (inputType.type == TextInputChannel.TextInputType.NAME) {
                i3 = 97;
            } else if (inputType.type == TextInputChannel.TextInputType.POSTAL_ADDRESS) {
                i3 = 113;
            }
            if (z) {
                i = 524288 | i3 | 128;
            } else {
                if (z2) {
                    i3 |= 32768;
                }
                i = !z3 ? 524288 | i3 : i3;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.CHARACTERS) {
                return i | 4096;
            }
            if (textCapitalization == TextInputChannel.TextCapitalization.WORDS) {
                return i | 8192;
            }
            return textCapitalization == TextInputChannel.TextCapitalization.SENTENCES ? i | 16384 : i;
        }
    }

    public InputConnection createInputConnection(View view, KeyboardManager keyboardManager, EditorInfo editorInfo) {
        int i;
        if (this.f60576f.type == InputTarget.Type.NO_TARGET) {
            this.f60581k = null;
            return null;
        } else if (this.f60576f.type == InputTarget.Type.HC_PLATFORM_VIEW) {
            return null;
        } else {
            if (this.f60576f.type != InputTarget.Type.VD_PLATFORM_VIEW) {
                editorInfo.inputType = m45660a(this.f60577g.inputType, this.f60577g.obscureText, this.f60577g.autocorrect, this.f60577g.enableSuggestions, this.f60577g.enableIMEPersonalizedLearning, this.f60577g.textCapitalization);
                editorInfo.imeOptions = 33554432;
                if (Build.VERSION.SDK_INT >= 26 && !this.f60577g.enableIMEPersonalizedLearning) {
                    editorInfo.imeOptions |= 16777216;
                }
                if (this.f60577g.inputAction == null) {
                    i = (131072 & editorInfo.inputType) != 0 ? 1 : 6;
                } else {
                    i = this.f60577g.inputAction.intValue();
                }
                if (this.f60577g.actionLabel != null) {
                    editorInfo.actionLabel = this.f60577g.actionLabel;
                    editorInfo.actionId = i;
                }
                editorInfo.imeOptions = i | editorInfo.imeOptions;
                C22111b bVar = new C22111b(view, this.f60576f.f60587id, this.f60575e, keyboardManager, this.f60579i, editorInfo);
                editorInfo.initialSelStart = this.f60579i.mo182557e();
                editorInfo.initialSelEnd = this.f60579i.mo182558f();
                this.f60581k = bVar;
                return bVar;
            } else if (this.f60586p) {
                return this.f60581k;
            } else {
                InputConnection onCreateInputConnection = this.f60582l.getPlatformViewById(Integer.valueOf(this.f60576f.f60587id)).onCreateInputConnection(editorInfo);
                this.f60581k = onCreateInputConnection;
                return onCreateInputConnection;
            }
        }
    }

    public InputConnection getLastInputConnection() {
        return this.f60581k;
    }

    public void clearPlatformViewClient(int i) {
        if ((this.f60576f.type == InputTarget.Type.VD_PLATFORM_VIEW || this.f60576f.type == InputTarget.Type.HC_PLATFORM_VIEW) && this.f60576f.f60587id == i) {
            this.f60576f = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            m45678g();
            this.f60573c.hideSoftInputFromWindow(this.f60572b.getApplicationWindowToken(), 0);
            this.f60573c.restartInput(this.f60572b);
            this.f60580j = false;
        }
    }

    public void sendTextInputAppPrivateCommand(String str, Bundle bundle) {
        this.f60573c.sendAppPrivateCommand(this.f60572b, str, bundle);
    }

    /* renamed from: d */
    private boolean m45674d() {
        TextInputChannel.Configuration configuration = this.f60577g;
        if (configuration == null || configuration.inputType == null || this.f60577g.inputType.type != TextInputChannel.TextInputType.NONE) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182577a(View view) {
        if (m45674d()) {
            view.requestFocus();
            this.f60573c.showSoftInput(view, 0);
            return;
        }
        m45671b(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m45671b(View view) {
        m45678g();
        this.f60573c.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182576a(int i, TextInputChannel.Configuration configuration) {
        m45678g();
        this.f60577g = configuration;
        if (m45674d()) {
            this.f60576f = new InputTarget(InputTarget.Type.FRAMEWORK_CLIENT, i);
        } else {
            this.f60576f = new InputTarget(InputTarget.Type.NO_TARGET, i);
        }
        this.f60579i.mo182554b(this);
        this.f60579i = new ListenableEditingState(configuration.autofill != null ? configuration.autofill.editState : null, this.f60572b);
        m45664a(configuration);
        this.f60580j = true;
        unlockPlatformViewInputConnection();
        this.f60583m = null;
        this.f60579i.mo182552a((ListenableEditingState.EditingStateWatcher) this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45663a(int i, boolean z) {
        if (z) {
            this.f60572b.requestFocus();
            this.f60576f = new InputTarget(InputTarget.Type.VD_PLATFORM_VIEW, i);
            this.f60573c.restartInput(this.f60572b);
            this.f60580j = false;
            return;
        }
        this.f60576f = new InputTarget(InputTarget.Type.HC_PLATFORM_VIEW, i);
        this.f60581k = null;
    }

    /* renamed from: a */
    private static boolean m45669a(TextInputChannel.TextEditState textEditState, TextInputChannel.TextEditState textEditState2) {
        int i = textEditState.composingEnd - textEditState.composingStart;
        if (i != textEditState2.composingEnd - textEditState2.composingStart) {
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (textEditState.text.charAt(textEditState.composingStart + i2) != textEditState2.text.charAt(textEditState2.composingStart + i2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182578a(View view, TextInputChannel.TextEditState textEditState) {
        TextInputChannel.TextEditState textEditState2;
        if (!this.f60580j && (textEditState2 = this.f60585o) != null && textEditState2.hasComposing()) {
            boolean a = m45669a(this.f60585o, textEditState);
            this.f60580j = a;
            if (a) {
                Log.m45257i(f60571a, "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.f60585o = textEditState;
        this.f60579i.mo182551a(textEditState);
        if (this.f60580j) {
            this.f60573c.restartInput(view);
            this.f60580j = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45662a(double d, double d2, double[] dArr) {
        double d3 = d;
        double d4 = d2;
        final double[] dArr2 = dArr;
        final double[] dArr3 = new double[4];
        final boolean z = dArr2[3] == 0.0d && dArr2[7] == 0.0d && dArr2[15] == 1.0d;
        double d5 = dArr2[12] / dArr2[15];
        dArr3[1] = d5;
        dArr3[0] = d5;
        double d6 = dArr2[13] / dArr2[15];
        dArr3[3] = d6;
        dArr3[2] = d6;
        C221092 r10 = new MinMax() {
            public void inspect(double d, double d2) {
                double d3 = 1.0d;
                if (!z) {
                    double[] dArr = dArr2;
                    d3 = 1.0d / (((dArr[3] * d) + (dArr[7] * d2)) + dArr[15]);
                }
                double[] dArr2 = dArr2;
                double d4 = ((dArr2[0] * d) + (dArr2[4] * d2) + dArr2[12]) * d3;
                double d5 = ((dArr2[1] * d) + (dArr2[5] * d2) + dArr2[13]) * d3;
                double[] dArr3 = dArr3;
                if (d4 < dArr3[0]) {
                    dArr3[0] = d4;
                } else if (d4 > dArr3[1]) {
                    dArr3[1] = d4;
                }
                double[] dArr4 = dArr3;
                if (d5 < dArr4[2]) {
                    dArr4[2] = d5;
                } else if (d5 > dArr4[3]) {
                    dArr4[3] = d5;
                }
            }
        };
        r10.inspect(d3, 0.0d);
        r10.inspect(d3, d4);
        r10.inspect(0.0d, d4);
        Float valueOf = Float.valueOf(this.f60572b.getContext().getResources().getDisplayMetrics().density);
        this.f60583m = new Rect((int) (dArr3[0] * ((double) valueOf.floatValue())), (int) (dArr3[2] * ((double) valueOf.floatValue())), (int) Math.ceil(dArr3[1] * ((double) valueOf.floatValue())), (int) Math.ceil(dArr3[3] * ((double) valueOf.floatValue())));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo182581c() {
        if (this.f60576f.type != InputTarget.Type.VD_PLATFORM_VIEW) {
            this.f60579i.mo182554b(this);
            m45678g();
            m45664a((TextInputChannel.Configuration) null);
            this.f60576f = new InputTarget(InputTarget.Type.NO_TARGET, 0);
            unlockPlatformViewInputConnection();
            this.f60583m = null;
        }
    }

    /* renamed from: io.flutter.plugin.editing.TextInputPlugin$InputTarget */
    private static class InputTarget {

        /* renamed from: id */
        int f60587id;
        Type type;

        /* renamed from: io.flutter.plugin.editing.TextInputPlugin$InputTarget$Type */
        enum Type {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VD_PLATFORM_VIEW,
            HC_PLATFORM_VIEW
        }

        public InputTarget(Type type2, int i) {
            this.type = type2;
            this.f60587id = i;
        }
    }

    public boolean handleKeyEvent(KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!getInputMethodManager().isAcceptingText() || (inputConnection = this.f60581k) == null) {
            return false;
        }
        if (inputConnection instanceof C22111b) {
            return ((C22111b) inputConnection).mo182602a(keyEvent);
        }
        return inputConnection.sendKeyEvent(keyEvent);
    }

    public void didChangeEditingState(boolean z, boolean z2, boolean z3) {
        if (z) {
            m45668a(this.f60579i.toString());
        }
        int e = this.f60579i.mo182557e();
        int f = this.f60579i.mo182558f();
        int g = this.f60579i.mo182559g();
        int h = this.f60579i.mo182560h();
        ArrayList<TextEditingDelta> a = this.f60579i.mo182549a();
        if (!(this.f60585o == null || (this.f60579i.toString().equals(this.f60585o.text) && e == this.f60585o.selectionStart && f == this.f60585o.selectionEnd && g == this.f60585o.composingStart && h == this.f60585o.composingEnd))) {
            Log.m45259v(f60571a, "send EditingState to flutter: " + this.f60579i.toString());
            if (this.f60577g.enableDeltaModel) {
                this.f60575e.updateEditingStateWithDeltas(this.f60576f.f60587id, a);
                this.f60579i.mo182553b();
            } else {
                this.f60575e.updateEditingState(this.f60576f.f60587id, this.f60579i.toString(), e, f, g, h);
            }
            this.f60585o = new TextInputChannel.TextEditState(this.f60579i.toString(), e, f, g, h);
            return;
        }
        this.f60579i.mo182553b();
    }

    /* renamed from: e */
    private boolean m45676e() {
        return this.f60578h != null;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m45677f() {
        if (Build.VERSION.SDK_INT >= 26 && this.f60574d != null && m45676e()) {
            String str = this.f60577g.autofill.uniqueIdentifier;
            int[] iArr = new int[2];
            this.f60572b.getLocationOnScreen(iArr);
            Rect rect = new Rect(this.f60583m);
            rect.offset(iArr[0], iArr[1]);
            this.f60574d.notifyViewEntered(this.f60572b, str.hashCode(), rect);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m45678g() {
        TextInputChannel.Configuration configuration;
        if (Build.VERSION.SDK_INT >= 26 && this.f60574d != null && (configuration = this.f60577g) != null && configuration.autofill != null && m45676e()) {
            this.f60574d.notifyViewExited(this.f60572b, this.f60577g.autofill.uniqueIdentifier.hashCode());
        }
    }

    /* renamed from: a */
    private void m45668a(String str) {
        if (Build.VERSION.SDK_INT >= 26 && this.f60574d != null && m45676e()) {
            this.f60574d.notifyValueChanged(this.f60572b, this.f60577g.autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(str));
        }
    }

    /* renamed from: a */
    private void m45664a(TextInputChannel.Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (configuration == null || configuration.autofill == null) {
                this.f60578h = null;
                return;
            }
            TextInputChannel.Configuration[] configurationArr = configuration.fields;
            SparseArray<TextInputChannel.Configuration> sparseArray = new SparseArray<>();
            this.f60578h = sparseArray;
            if (configurationArr == null) {
                sparseArray.put(configuration.autofill.uniqueIdentifier.hashCode(), configuration);
                return;
            }
            for (TextInputChannel.Configuration configuration2 : configurationArr) {
                TextInputChannel.Configuration.Autofill autofill = configuration2.autofill;
                if (autofill != null) {
                    this.f60578h.put(autofill.uniqueIdentifier.hashCode(), configuration2);
                    this.f60574d.notifyValueChanged(this.f60572b, autofill.uniqueIdentifier.hashCode(), AutofillValue.forText(autofill.editState.text));
                }
            }
        }
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        Rect rect;
        ViewStructure viewStructure2 = viewStructure;
        if (Build.VERSION.SDK_INT >= 26 && m45676e()) {
            String str = this.f60577g.autofill.uniqueIdentifier;
            AutofillId autofillId = viewStructure.getAutofillId();
            for (int i2 = 0; i2 < this.f60578h.size(); i2++) {
                int keyAt = this.f60578h.keyAt(i2);
                TextInputChannel.Configuration.Autofill autofill = this.f60578h.valueAt(i2).autofill;
                if (autofill != null) {
                    viewStructure2.addChildCount(1);
                    ViewStructure newChild = viewStructure2.newChild(i2);
                    newChild.setAutofillId(autofillId, keyAt);
                    newChild.setAutofillHints(autofill.hints);
                    newChild.setAutofillType(1);
                    newChild.setVisibility(0);
                    if (autofill.hintText != null) {
                        newChild.setHint(autofill.hintText);
                    }
                    if (str.hashCode() != keyAt || (rect = this.f60583m) == null) {
                        ViewStructure viewStructure3 = newChild;
                        viewStructure3.setDimens(0, 0, 0, 0, 1, 1);
                        viewStructure3.setAutofillValue(AutofillValue.forText(autofill.editState.text));
                    } else {
                        newChild.setDimens(rect.left, this.f60583m.top, 0, 0, this.f60583m.width(), this.f60583m.height());
                        newChild.setAutofillValue(AutofillValue.forText(this.f60579i));
                    }
                }
            }
        }
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        TextInputChannel.Configuration.Autofill autofill;
        if (Build.VERSION.SDK_INT >= 26 && (autofill = this.f60577g.autofill) != null) {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                TextInputChannel.Configuration configuration = this.f60578h.get(sparseArray.keyAt(i));
                if (!(configuration == null || configuration.autofill == null)) {
                    TextInputChannel.Configuration.Autofill autofill2 = configuration.autofill;
                    String charSequence = sparseArray.valueAt(i).getTextValue().toString();
                    TextInputChannel.TextEditState textEditState = new TextInputChannel.TextEditState(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                    if (autofill2.uniqueIdentifier.equals(autofill.uniqueIdentifier)) {
                        this.f60579i.mo182551a(textEditState);
                    } else {
                        hashMap.put(autofill2.uniqueIdentifier, textEditState);
                    }
                }
            }
            this.f60575e.updateEditingStateWithTag(this.f60576f.f60587id, hashMap);
        }
    }
}
