package com.didi.globalsafetoolkit.util;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: SfInputMethodUtil.kt */
final class SfInputMethodUtil$showInputMethod$1 implements Runnable {
    final /* synthetic */ EditText $editText;
    final /* synthetic */ InputMethodManager $inManager;

    SfInputMethodUtil$showInputMethod$1(InputMethodManager inputMethodManager, EditText editText) {
        this.$inManager = inputMethodManager;
        this.$editText = editText;
    }

    public final void run() {
        this.$inManager.showSoftInput(this.$editText, 0);
    }
}
