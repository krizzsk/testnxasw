package rui.widget.popup.type.upgrade;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import rui.base.ButtonModel;
import rui.widget.popup.base.BasePopupModel;

public class PopupUpgrade extends BasePopupModel<FactoryPopupUpgrade> implements IPopupUpgrade {

    /* renamed from: a */
    private List<ButtonModel> f8687a = new ArrayList();

    /* renamed from: b */
    private List<ButtonModel> f8688b = new ArrayList();
    public CharSequence content;
    public int progressDrawable = Integer.MIN_VALUE;
    public View.OnClickListener progressOnClick;
    public CharSequence title;

    public void addConfirmButton(CharSequence charSequence, String str, View.OnClickListener onClickListener) {
        this.f8687a.add(new ButtonModel(charSequence, str, Integer.MIN_VALUE, onClickListener));
    }

    public void addFinishButton(CharSequence charSequence, String str, View.OnClickListener onClickListener) {
        this.f8688b.add(new ButtonModel(charSequence, str, Integer.MIN_VALUE, onClickListener));
    }

    public List<ButtonModel> getConfirmButtons() {
        return this.f8687a;
    }

    public List<ButtonModel> getFinishButtons() {
        return this.f8688b;
    }

    public PopupUpgrade() {
        this.factory = new FactoryPopupUpgrade();
    }

    public void updateContent(String str) {
        ((FactoryPopupUpgrade) this.factory).updateContent(str);
    }

    public void updateTitle(String str) {
        ((FactoryPopupUpgrade) this.factory).updateTitle(str);
    }

    public void showConfirm() {
        ((FactoryPopupUpgrade) this.factory).showConfirm();
    }

    public void showProgress(String str) {
        ((FactoryPopupUpgrade) this.factory).showProgress(str);
    }

    public void showProgress(int i, String str) {
        ((FactoryPopupUpgrade) this.factory).showProgress(i, str);
    }

    public void showFinish() {
        ((FactoryPopupUpgrade) this.factory).showFinish();
    }
}
