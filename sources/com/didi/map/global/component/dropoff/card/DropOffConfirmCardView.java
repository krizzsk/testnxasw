package com.didi.map.global.component.dropoff.card;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.map.global.component.dropoff.card.IDropOffCard;
import com.didi.map.global.component.dropoff.model.DropOffAddress;
import com.didi.map.global.component.dropoff.model.DropOffAddressExtendInfo;
import com.taxis99.R;

public class DropOffConfirmCardView extends FrameLayout implements View.OnClickListener, IDropOffCard {

    /* renamed from: a */
    private TextView f27714a;

    /* renamed from: b */
    private TextView f27715b;

    /* renamed from: c */
    private ImageView f27716c;

    /* renamed from: d */
    private TextView f27717d;

    /* renamed from: e */
    private TextView f27718e;

    /* renamed from: f */
    private IDropOffCard.DropOffCardCallback f27719f;

    public DropOffConfirmCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DropOffConfirmCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DropOffConfirmCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_dropoff_confirm_card_view, this, true);
        this.f27714a = (TextView) findViewById(R.id.tv_confirm_dropoff_point_title);
        this.f27715b = (TextView) findViewById(R.id.tv_confirm_dropoff_point_subtitle);
        this.f27716c = (ImageView) findViewById(R.id.dropoff_confirm_address_name_pre_icon);
        this.f27717d = (TextView) findViewById(R.id.dropoff_confirm_address_name);
        TextView textView = (TextView) findViewById(R.id.dropoff_confirm_request);
        this.f27718e = textView;
        textView.setOnClickListener(this);
        try {
            this.f27718e.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f27718e.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCardCallback(IDropOffCard.DropOffCardCallback dropOffCardCallback) {
        this.f27719f = dropOffCardCallback;
    }

    public void updateCard(DropOffAddress dropOffAddress) {
        if (dropOffAddress != null && dropOffAddress.getAddress() != null) {
            boolean z = true;
            this.f27718e.setEnabled(true);
            String displayName = dropOffAddress.getAddress().getDisplayName();
            if (!TextUtils.isEmpty(displayName)) {
                setAddressNameText(displayName);
            }
            if (dropOffAddress.getExtendInfo() != null) {
                DropOffAddressExtendInfo extendInfo = dropOffAddress.getExtendInfo();
                String mainTitle = extendInfo.getMainTitle();
                if (!TextUtils.isEmpty(mainTitle)) {
                    setMainTitleText(mainTitle);
                }
                String subTitle = extendInfo.getSubTitle();
                if (!TextUtils.isEmpty(subTitle)) {
                    setSubTitleText(subTitle);
                    return;
                }
                if (dropOffAddress.getRecPointSize() <= 0) {
                    z = false;
                }
                setDefaultSubTitle(z);
                return;
            }
            if (dropOffAddress.getRecPointSize() <= 0) {
                z = false;
            }
            setDefaultSubTitle(z);
        }
    }

    private void setDefaultSubTitle(boolean z) {
        String string = getContext().getResources().getString(R.string.GRider_destination_Drag_the_uahD);
        if (z) {
            string = getContext().getResources().getString(R.string.GRider_destination_Drag_the_Mqxt);
        }
        setSubTitleText(string);
    }

    public void setAddressNameText(String str) {
        TextView textView = this.f27717d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setMainTitleText(String str) {
        if (!TextUtils.isEmpty(str)) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(str);
            richTextInfo.bindTo(this.f27714a);
        }
    }

    public void setSubTitleText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f27715b.setVisibility(0);
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(str);
            richTextInfo.bindTo(this.f27715b);
            return;
        }
        this.f27715b.setVisibility(4);
    }

    public void onDataLoading() {
        this.f27718e.setEnabled(false);
        setAddressNameText(getResources().getString(R.string.GRider_Sug_2020_map_searchingAddress));
    }

    public void onClick(View view) {
        IDropOffCard.DropOffCardCallback dropOffCardCallback;
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.dropoff_confirm_request && (dropOffCardCallback = this.f27719f) != null) {
            dropOffCardCallback.onCardItemClick(0);
        }
    }

    public void setSubTitleEnable(boolean z) {
        if (z) {
            this.f27715b.setVisibility(0);
        } else {
            this.f27715b.setVisibility(8);
        }
    }

    public void setAddressIcon(int i) {
        if (i == 1) {
            this.f27716c.setImageResource(R.drawable.com_icon_pickup);
        } else if (i == 2) {
            this.f27716c.setImageResource(R.drawable.com_icon_dest);
        }
    }
}
