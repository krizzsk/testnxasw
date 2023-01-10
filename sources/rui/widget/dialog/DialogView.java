package rui.widget.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class DialogView extends LinearLayout {
    public DialogView(Context context) {
        super(context);
        m7251a(context);
    }

    public DialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7251a(context);
    }

    public DialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7251a(context);
    }

    /* renamed from: a */
    private void m7251a(Context context) {
        setOrientation(1);
        setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.rui_color_white, (Resources.Theme) null));
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
    }

    public void init(DialogModel dialogModel) {
        removeAllViews();
        dialogModel.getFactory().mo43379a(this, dialogModel);
    }
}
