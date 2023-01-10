package com.didiglobal.pay.paysecure.p204ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0006\u0010\u001e\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020\u0017J\u0006\u0010 \u001a\u00020\u0017R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/ui/view/InputPwdListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didiglobal/pay/paysecure/ui/view/InputPwdListViewHolder;", "context", "Landroid/content/Context;", "pwdCount", "", "(Landroid/content/Context;I)V", "inputIndex", "inputList", "", "getInputList", "()[C", "setInputList", "([C)V", "layoutInflater", "Landroid/view/LayoutInflater;", "addPwd", "", "pwd", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removePwd", "reset", "showErr", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.view.InputPwdListAdapter */
/* compiled from: InputPwdView.kt */
public final class InputPwdListAdapter extends RecyclerView.Adapter<InputPwdListViewHolder> {

    /* renamed from: a */
    private final LayoutInflater f52977a;

    /* renamed from: b */
    private char[] f52978b;

    /* renamed from: c */
    private int f52979c;

    /* renamed from: d */
    private int f52980d;

    public InputPwdListAdapter(Context context, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f52980d = i;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkExpressionValueIsNotNull(from, "LayoutInflater.from(context)");
        this.f52977a = from;
        int i2 = this.f52980d;
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = ' ';
        }
        this.f52978b = cArr;
    }

    public final char[] getInputList() {
        return this.f52978b;
    }

    public final void setInputList(char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "<set-?>");
        this.f52978b = cArr;
    }

    public InputPwdListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = this.f52977a.inflate(R.layout.item_input_pwd, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "itemView");
        return new InputPwdListViewHolder(inflate);
    }

    public void onBindViewHolder(InputPwdListViewHolder inputPwdListViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(inputPwdListViewHolder, "holder");
        inputPwdListViewHolder.setStatus(this.f52978b[i]);
    }

    public int getItemCount() {
        return this.f52978b.length;
    }

    public final boolean addPwd(char c) {
        int i = this.f52979c;
        if (i >= this.f52980d) {
            return false;
        }
        this.f52978b[i] = c;
        notifyDataSetChanged();
        int i2 = this.f52979c + 1;
        this.f52979c = i2;
        if (i2 >= this.f52980d) {
            return true;
        }
        return false;
    }

    public final void removePwd() {
        int i = this.f52979c;
        if (i > 0) {
            int i2 = i - 1;
            this.f52979c = i2;
            this.f52978b[i2] = ' ';
            notifyDataSetChanged();
        }
    }

    public final void showErr() {
        int i = this.f52980d;
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = '-';
        }
        this.f52978b = cArr;
        notifyDataSetChanged();
    }

    public final void reset() {
        this.f52979c = 0;
        int i = this.f52980d;
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = ' ';
        }
        this.f52978b = cArr;
        notifyDataSetChanged();
    }
}
