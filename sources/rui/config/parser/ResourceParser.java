package rui.config.parser;

import rui.config.RConfigConstants;
import rui.config.RConfigEngine;
import rui.config.model.IRModel;
import rui.config.model.resource.ResDrawable;

public class ResourceParser implements IRParser {
    public String type() {
        return RConfigConstants.TYPE_DRAWABLE;
    }

    public IRModel parse(String str) throws RConfigEngine.ConfigParseException {
        if (str != null && !str.isEmpty()) {
            return new ResDrawable(str, RResourceDrawableIdHelper.m7233a(RConfigEngine.getContext(), str), RResourceDrawableIdHelper.m7235b(RConfigEngine.getContext(), str), RResourceDrawableIdHelper.m7236c(RConfigEngine.getContext(), str));
        }
        throw new RConfigEngine.ConfigParseException("modelString cannot be null or empty");
    }
}
