package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.holder;

import com.didi.payment.base.utils.WalletApolloUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$14$gifResult$1 */
/* compiled from: TopCardViewHolder.kt */
final class TopCardViewHolder$onBindViewHolder$1$14$gifResult$1 extends Lambda implements Function0<String> {
    public static final TopCardViewHolder$onBindViewHolder$1$14$gifResult$1 INSTANCE = new TopCardViewHolder$onBindViewHolder$1$14$gifResult$1();

    TopCardViewHolder$onBindViewHolder$1$14$gifResult$1() {
        super(0);
    }

    public final String invoke() {
        return (String) WalletApolloUtil.getParamByStatus("BR_bank_card_enhance", "show_gif", "0");
    }
}
