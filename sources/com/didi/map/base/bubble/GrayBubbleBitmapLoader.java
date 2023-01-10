package com.didi.map.base.bubble;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.map.alpha.maps.internal.BlueLableBubble;
import com.didi.map.base.bubble.Bubble;

public class GrayBubbleBitmapLoader extends BaseBubbleBitmapLoader {
    public static final String TAG = "GrayRoadBitmapLoader";

    /* renamed from: a */
    private final BlueLableBubble f26838a;

    public String toString() {
        return TAG;
    }

    public GrayBubbleBitmapLoader(Context context, BlueLableBubble blueLableBubble) {
        super(context);
        this.f26838a = blueLableBubble;
    }

    public Bitmap loadBitmap(Bubble bubble, int i) {
        Bubble.OverlayRect overlayRect = bubble.getOverlayRect(i);
        if (overlayRect == null) {
            return null;
        }
        GrayBubbleBitmapOpt grayBubbleBitmapOpt = (GrayBubbleBitmapOpt) overlayRect.resourcePaths;
        String text = grayBubbleBitmapOpt.getText();
        return this.f26838a.getMarkerBitmap(this.context, text, this.f26838a.getTextColor(grayBubbleBitmapOpt.isNight(), text), grayBubbleBitmapOpt.getFileName(0), "", true, 0);
    }
}
