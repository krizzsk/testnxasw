package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import androidx.fragment.app.FragmentManager;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManager;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManagerFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.DefaultCardPwdUI$onInputDone$2$onSuccess$1 */
/* compiled from: ICardPwdUI.kt */
final class DefaultCardPwdUI$onInputDone$2$onSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DefaultCardPwdUI$onInputDone$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultCardPwdUI$onInputDone$2$onSuccess$1(DefaultCardPwdUI$onInputDone$2 defaultCardPwdUI$onInputDone$2) {
        super(0);
        this.this$0 = defaultCardPwdUI$onInputDone$2;
    }

    public final void invoke() {
        CardPwdManager cardPwdManager = CardPwdManager.INSTANCE;
        FragmentManager fragmentManager = this.this$0.$fragment.getFragmentManager();
        CardPwdManagerFragment cardPwdManagerFragment = this.this$0.$cardFragment;
        String cardId = cardPwdManagerFragment != null ? cardPwdManagerFragment.getCardId() : null;
        CardPwdManagerFragment cardPwdManagerFragment2 = this.this$0.$cardFragment;
        String sessionId = cardPwdManagerFragment2 != null ? cardPwdManagerFragment2.getSessionId() : null;
        CardPwdManagerFragment cardPwdManagerFragment3 = this.this$0.$cardFragment;
        CardPwdManager.startFragment$default(cardPwdManager, fragmentManager, 2, false, cardId, sessionId, cardPwdManagerFragment3 != null ? cardPwdManagerFragment3.getScene() : null, (String) null, 64, (Object) null);
    }
}
