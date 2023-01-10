package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.yyyyqy;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class qyyyyy {
    private static final String bff00660066ff = yyyyqy.b0074t007400740074t(qyyyyy.class);
    private final String b0066006600660066ff;
    private final String b0066f00660066ff;
    private final boolean b0066fff0066f;
    private final String bf006600660066ff;
    private String bf0066ff0066f;
    private final String bffff0066f;

    public qyyyyy(@Nonnull tqtqqt tqtqqt, @Nonnull String str, @Nonnull String str2, @Nullable String str3, @Nullable String str4, boolean z) {
        this.bf006600660066ff = str;
        this.b0066f00660066ff = str2;
        this.b0066006600660066ff = !yqqyqq.bi0069i0069i0069(str3) ? yqqyqq.b0069i0069i00690069(str3.getBytes()) : str3;
        this.bffff0066f = !yqqyqq.bi0069i0069i0069(str4) ? yqqyqq.b0069i0069i00690069(str4.getBytes()) : str4;
        this.b0066fff0066f = z;
        String bh00680068h00680068 = jkkjjj.bh00680068h00680068(tqtqqt, str, str2);
        if (!yqqyqq.bi0069i0069i0069(bh00680068h00680068)) {
            this.bf0066ff0066f = bh00680068h00680068;
        } else if (yqqyqq.b0069ii0069i0069(this.b0066006600660066ff)) {
            jkkjjj.bh00680068006800680068(tqtqqt, str, str2, this.b0066006600660066ff);
            this.bf0066ff0066f = this.b0066006600660066ff;
        }
    }

    public boolean by0079y007900790079(@Nonnull tqtqqt tqtqqt) {
        if (yqqyqq.bi0069i0069i0069(this.bf0066ff0066f)) {
            this.bf0066ff0066f = jkkjjj.bh00680068h00680068(tqtqqt, this.bf006600660066ff, this.b0066f00660066ff);
        }
        String str = bff00660066ff;
        yyyyqy.qyyyqy.bt0074tttt(str, "saved id for key " + this.b0066f00660066ff + " is " + this.bf0066ff0066f + " the value retrieved before is " + this.b0066006600660066ff);
        return yqqyqq.bi0069i0069i0069(this.b0066006600660066ff) ? (yqqyqq.b0069ii0069i0069(this.bffff0066f) && this.b0066fff0066f) || yqqyqq.b0069ii0069i0069(this.bf0066ff0066f) : (!this.b0066006600660066ff.equalsIgnoreCase(this.bffff0066f) && this.b0066fff0066f) || !this.b0066006600660066ff.equalsIgnoreCase(this.bf0066ff0066f);
    }
}
