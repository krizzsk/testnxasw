package com.didi.beatles.p101im.access.briage;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p101im.access.card.OperationCardT1;
import com.didi.beatles.p101im.access.card.OperationCardT2;
import com.didi.beatles.p101im.access.card.OperationCardT3;
import com.didi.beatles.p101im.access.card.OperationCardT4;
import com.didi.beatles.p101im.access.utils.Parser;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.views.IMCustomChatRowProvider;
import com.didi.beatles.p101im.views.messageCard.IMBaseRenderView;

/* renamed from: com.didi.beatles.im.access.briage.IMCustomChatRowProviderImpl */
public class IMCustomChatRowProviderImpl implements IMCustomChatRowProvider {
    public static final int MsgTypeExtend = 528385;
    public static final int OPERATION_TEMPLATE1 = 501;
    public static final int OPERATION_TEMPLATE2 = 502;
    public static final int OPERATION_TEMPLATE3 = 503;
    public static final int OPERATION_TEMPLATE4 = 504;

    /* renamed from: a */
    private Context f10553a;

    public IMCustomChatRowProviderImpl(Context context) {
        this.f10553a = context;
    }

    public int getCustomChatRowType(IMMessage iMMessage) {
        String content;
        if (iMMessage.getType() == 528385 && (content = iMMessage.getContent()) != null && !content.equals("")) {
            if (!TextUtils.isEmpty(Parser.parseSubType(content))) {
                Parser.parseSubType(content);
            } else if (Parser.parseType(content) == 1) {
                int parseTemplate = Parser.parseTemplate(content);
                if (parseTemplate == 1) {
                    return 501;
                }
                if (parseTemplate == 2) {
                    return 502;
                }
                if (parseTemplate == 3) {
                    return 503;
                }
                if (parseTemplate == 4) {
                    return 504;
                }
            }
        }
        return -1;
    }

    public IMBaseRenderView getCustomChatRow(int i, MessageAdapter messageAdapter) {
        switch (i) {
            case 501:
                return new OperationCardT1(this.f10553a, messageAdapter);
            case 502:
                return new OperationCardT2(this.f10553a, messageAdapter);
            case 503:
                return new OperationCardT3(this.f10553a, messageAdapter);
            case 504:
                return new OperationCardT4(this.f10553a, messageAdapter);
            default:
                return null;
        }
    }
}
