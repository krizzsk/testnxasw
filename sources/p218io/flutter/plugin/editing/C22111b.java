package p218io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputMethodManager;
import kotlinx.coroutines.DebugKt;
import p218io.flutter.Log;
import p218io.flutter.embedding.android.KeyboardManager;
import p218io.flutter.embedding.engine.FlutterJNI;
import p218io.flutter.embedding.engine.systemchannels.TextInputChannel;
import p218io.flutter.plugin.editing.ListenableEditingState;

/* renamed from: io.flutter.plugin.editing.b */
/* compiled from: InputConnectionAdaptor */
class C22111b extends BaseInputConnection implements ListenableEditingState.EditingStateWatcher {

    /* renamed from: a */
    private static final String f60594a = "InputConnectionAdaptor";

    /* renamed from: b */
    private final View f60595b;

    /* renamed from: c */
    private final int f60596c;

    /* renamed from: d */
    private final TextInputChannel f60597d;

    /* renamed from: e */
    private final ListenableEditingState f60598e;

    /* renamed from: f */
    private final EditorInfo f60599f;

    /* renamed from: g */
    private ExtractedTextRequest f60600g;

    /* renamed from: h */
    private boolean f60601h;

    /* renamed from: i */
    private CursorAnchorInfo.Builder f60602i;

    /* renamed from: j */
    private ExtractedText f60603j;

    /* renamed from: k */
    private InputMethodManager f60604k;

    /* renamed from: l */
    private final Layout f60605l;

    /* renamed from: m */
    private C22110a f60606m;

    /* renamed from: n */
    private final KeyboardManager f60607n;

    /* renamed from: o */
    private int f60608o;

    public C22111b(View view, int i, TextInputChannel textInputChannel, KeyboardManager keyboardManager, ListenableEditingState listenableEditingState, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.f60601h = false;
        this.f60603j = new ExtractedText();
        this.f60608o = 0;
        this.f60595b = view;
        this.f60596c = i;
        this.f60597d = textInputChannel;
        this.f60598e = listenableEditingState;
        listenableEditingState.mo182552a((ListenableEditingState.EditingStateWatcher) this);
        this.f60599f = editorInfo;
        this.f60607n = keyboardManager;
        this.f60606m = new C22110a(flutterJNI);
        this.f60605l = new DynamicLayout(this.f60598e, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f60604k = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    public C22111b(View view, int i, TextInputChannel textInputChannel, KeyboardManager keyboardManager, ListenableEditingState listenableEditingState, EditorInfo editorInfo) {
        this(view, i, textInputChannel, keyboardManager, listenableEditingState, editorInfo, new FlutterJNI());
    }

    /* renamed from: a */
    private ExtractedText m45696a(ExtractedTextRequest extractedTextRequest) {
        CharSequence charSequence;
        this.f60603j.startOffset = 0;
        this.f60603j.partialStartOffset = -1;
        this.f60603j.partialEndOffset = -1;
        this.f60603j.selectionStart = this.f60598e.mo182557e();
        this.f60603j.selectionEnd = this.f60598e.mo182558f();
        ExtractedText extractedText = this.f60603j;
        if (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) {
            charSequence = this.f60598e.toString();
        } else {
            charSequence = this.f60598e;
        }
        extractedText.text = charSequence;
        return this.f60603j;
    }

    /* renamed from: a */
    private CursorAnchorInfo m45695a() {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        CursorAnchorInfo.Builder builder = this.f60602i;
        if (builder == null) {
            this.f60602i = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.f60602i.setSelectionRange(this.f60598e.mo182557e(), this.f60598e.mo182558f());
        int g = this.f60598e.mo182559g();
        int h = this.f60598e.mo182560h();
        if (g < 0 || h <= g) {
            this.f60602i.setComposingText(-1, "");
        } else {
            this.f60602i.setComposingText(g, this.f60598e.toString().subSequence(g, h));
        }
        return this.f60602i.build();
    }

    public Editable getEditable() {
        return this.f60598e;
    }

    public boolean beginBatchEdit() {
        this.f60598e.mo182555c();
        this.f60608o++;
        return super.beginBatchEdit();
    }

    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.f60608o--;
        this.f60598e.mo182556d();
        return endBatchEdit;
    }

    public boolean commitText(CharSequence charSequence, int i) {
        return super.commitText(charSequence, i);
    }

    public boolean deleteSurroundingText(int i, int i2) {
        if (this.f60598e.mo182557e() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i, i2);
    }

    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return super.deleteSurroundingTextInCodePoints(i, i2);
    }

    public boolean setComposingRegion(int i, int i2) {
        return super.setComposingRegion(i, i2);
    }

    public boolean setComposingText(CharSequence charSequence, int i) {
        boolean z;
        beginBatchEdit();
        if (charSequence.length() == 0) {
            z = super.commitText(charSequence, i);
        } else {
            z = super.setComposingText(charSequence, i);
        }
        endBatchEdit();
        return z;
    }

    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        boolean z = true;
        boolean z2 = (i & 1) != 0;
        if (this.f60600g != null) {
            z = false;
        }
        if (z2 == z) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z2 ? "on" : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            Log.m45253d(f60594a, sb.toString());
        }
        this.f60600g = z2 ? extractedTextRequest : null;
        return m45696a(extractedTextRequest);
    }

    public boolean requestCursorUpdates(int i) {
        boolean z = false;
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if ((i & 1) != 0) {
            this.f60604k.updateCursorAnchorInfo(this.f60595b, m45695a());
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if (z != this.f60601h) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z ? "on" : DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            Log.m45253d(f60594a, sb.toString());
        }
        this.f60601h = z;
        return true;
    }

    public boolean clearMetaKeyStates(int i) {
        return super.clearMetaKeyStates(i);
    }

    public void closeConnection() {
        super.closeConnection();
        this.f60598e.mo182554b(this);
        while (this.f60608o > 0) {
            endBatchEdit();
            this.f60608o--;
        }
    }

    public boolean setSelection(int i, int i2) {
        beginBatchEdit();
        boolean selection = super.setSelection(i, i2);
        endBatchEdit();
        return selection;
    }

    /* renamed from: a */
    private static int m45694a(int i, Editable editable) {
        int max = Math.max(0, Math.min(editable.length(), i));
        if (max != i) {
            Log.m45253d("flutter", "Text selection index was clamped (" + i + "->" + max + ") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
        }
        return max;
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.f60607n.handleEvent(keyEvent);
    }

    /* renamed from: a */
    public boolean mo182602a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 21) {
                return m45698a(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 22) {
                return m45698a(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 19) {
                return m45699b(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 20) {
                return m45699b(false, keyEvent.isShiftPressed());
            }
            if ((keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) && (131072 & this.f60599f.inputType) == 0) {
                performEditorAction(this.f60599f.imeOptions & 255);
                return true;
            }
            int selectionStart = Selection.getSelectionStart(this.f60598e);
            int selectionEnd = Selection.getSelectionEnd(this.f60598e);
            int unicodeChar = keyEvent.getUnicodeChar();
            if (selectionStart < 0 || selectionEnd < 0 || unicodeChar == 0) {
                return false;
            }
            int min = Math.min(selectionStart, selectionEnd);
            int max = Math.max(selectionStart, selectionEnd);
            beginBatchEdit();
            if (min != max) {
                this.f60598e.delete(min, max);
            }
            this.f60598e.insert(min, String.valueOf((char) unicodeChar));
            int i = min + 1;
            setSelection(i, i);
            endBatchEdit();
            return true;
        } else if (keyEvent.getAction() != 1 || (keyEvent.getKeyCode() != 59 && keyEvent.getKeyCode() != 60)) {
            return false;
        } else {
            int selectionEnd2 = Selection.getSelectionEnd(this.f60598e);
            setSelection(selectionEnd2, selectionEnd2);
            return true;
        }
    }

    /* renamed from: a */
    private boolean m45698a(boolean z, boolean z2) {
        int i;
        int selectionStart = Selection.getSelectionStart(this.f60598e);
        int selectionEnd = Selection.getSelectionEnd(this.f60598e);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (z) {
            i = Math.max(this.f60606m.mo182593a(this.f60598e, selectionEnd), 0);
        } else {
            i = Math.min(this.f60606m.mo182595b(this.f60598e, selectionEnd), this.f60598e.length());
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        if (z3) {
            setSelection(i, i);
        } else {
            setSelection(selectionStart, i);
        }
        return true;
    }

    /* renamed from: b */
    private boolean m45699b(boolean z, boolean z2) {
        int selectionStart = Selection.getSelectionStart(this.f60598e);
        int selectionEnd = Selection.getSelectionEnd(this.f60598e);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        beginBatchEdit();
        if (z3) {
            if (z) {
                Selection.moveUp(this.f60598e, this.f60605l);
            } else {
                Selection.moveDown(this.f60598e, this.f60605l);
            }
            int selectionStart2 = Selection.getSelectionStart(this.f60598e);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z) {
                Selection.extendUp(this.f60598e, this.f60605l);
            } else {
                Selection.extendDown(this.f60598e, this.f60605l);
            }
            setSelection(Selection.getSelectionStart(this.f60598e), Selection.getSelectionEnd(this.f60598e));
        }
        endBatchEdit();
        return true;
    }

    public boolean performContextMenuAction(int i) {
        beginBatchEdit();
        boolean a = m45697a(i);
        endBatchEdit();
        return a;
    }

    /* renamed from: a */
    private boolean m45697a(int i) {
        if (i == 16908319) {
            setSelection(0, this.f60598e.length());
            return true;
        } else if (i == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.f60598e);
            int selectionEnd = Selection.getSelectionEnd(this.f60598e);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.f60595b.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f60598e.subSequence(min, max)));
                this.f60598e.delete(min, max);
                setSelection(min, min);
            }
            return true;
        } else if (i == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.f60598e);
            int selectionEnd2 = Selection.getSelectionEnd(this.f60598e);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.f60595b.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f60598e.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        } else if (i != 16908322) {
            return false;
        } else {
            ClipData primaryClip = ((ClipboardManager) this.f60595b.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null) {
                CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.f60595b.getContext());
                int max2 = Math.max(0, Selection.getSelectionStart(this.f60598e));
                int max3 = Math.max(0, Selection.getSelectionEnd(this.f60598e));
                int min2 = Math.min(max2, max3);
                int max4 = Math.max(max2, max3);
                if (min2 != max4) {
                    this.f60598e.delete(min2, max4);
                }
                this.f60598e.insert(min2, coerceToText);
                int length = min2 + coerceToText.length();
                setSelection(length, length);
            }
            return true;
        }
    }

    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.f60597d.performPrivateCommand(this.f60596c, str, bundle);
        return true;
    }

    public boolean performEditorAction(int i) {
        if (i == 0) {
            this.f60597d.unspecifiedAction(this.f60596c);
        } else if (i == 1) {
            this.f60597d.newline(this.f60596c);
        } else if (i == 2) {
            this.f60597d.mo182481go(this.f60596c);
        } else if (i == 3) {
            this.f60597d.search(this.f60596c);
        } else if (i == 4) {
            this.f60597d.send(this.f60596c);
        } else if (i == 5) {
            this.f60597d.next(this.f60596c);
        } else if (i != 7) {
            this.f60597d.done(this.f60596c);
        } else {
            this.f60597d.previous(this.f60596c);
        }
        return true;
    }

    public void didChangeEditingState(boolean z, boolean z2, boolean z3) {
        this.f60604k.updateSelection(this.f60595b, this.f60598e.mo182557e(), this.f60598e.mo182558f(), this.f60598e.mo182559g(), this.f60598e.mo182560h());
        if (Build.VERSION.SDK_INT >= 21) {
            ExtractedTextRequest extractedTextRequest = this.f60600g;
            if (extractedTextRequest != null) {
                this.f60604k.updateExtractedText(this.f60595b, extractedTextRequest.token, m45696a(this.f60600g));
            }
            if (this.f60601h) {
                this.f60604k.updateCursorAnchorInfo(this.f60595b, m45695a());
            }
        }
    }
}
