package com.didi.addressnew.view.enhance;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.addressnew.util.ViewUtils;
import com.didi.common.map.util.DisplayUtils;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfoTag;
import com.taxis99.R;

public class SugRecItemEnhancer implements IAddressItemEnhancer {

    /* renamed from: a */
    private boolean f9432a;

    /* renamed from: b */
    private boolean f9433b;

    /* renamed from: c */
    private boolean f9434c;

    /* renamed from: d */
    private boolean f9435d;

    public void enhance(View view, int i, RpcPoi rpcPoi) {
        if (view != null && i >= 0 && rpcPoi != null && rpcPoi.base_info != null) {
            m8208a(view, i, rpcPoi);
        }
    }

    /* renamed from: a */
    private void m8210a(View view, TextPaint textPaint, String str, RpcPoi rpcPoi, DisplayMetrics displayMetrics) {
        TextView textView = (TextView) view.findViewById(R.id.cf_tag);
        if (this.f9434c && textView != null && rpcPoi.extend_info != null && rpcPoi.extend_info.enable_confirm_dropoff == 1) {
            Context context = textView.getContext();
            if (context != null) {
                textView.setVisibility(0);
                textView.setText(context.getString(R.string.GRider_destination_Confirm_exit_lILB));
                if (!isInvadeOutside(textView, textPaint, str, displayMetrics)) {
                    textView.setTextColor(-1);
                    Drawable background = textView.getBackground();
                    if (background instanceof GradientDrawable) {
                        GradientDrawable gradientDrawable = (GradientDrawable) background;
                        gradientDrawable.setColor(-169679);
                        textView.setBackgroundDrawable(gradientDrawable);
                    }
                }
            }
        } else if (rpcPoi.base_info == null || rpcPoi.base_info.poi_tag == null || rpcPoi.base_info.poi_tag.size() <= 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            RpcPoiBaseInfoTag rpcPoiBaseInfoTag = rpcPoi.base_info.poi_tag.get(0);
            textView.setText(rpcPoiBaseInfoTag.name);
            if (!isInvadeOutside(textView, textPaint, str, displayMetrics)) {
                if (!TextUtils.isEmpty(rpcPoiBaseInfoTag.content_color)) {
                    try {
                        textView.setTextColor(Color.parseColor(rpcPoiBaseInfoTag.content_color));
                    } catch (IllegalArgumentException e) {
                        DLog.m36225d("Exception: " + e.toString());
                    }
                } else {
                    textView.setTextColor(-34761);
                }
                Drawable background2 = textView.getBackground();
                if (background2 instanceof GradientDrawable) {
                    try {
                        GradientDrawable gradientDrawable2 = (GradientDrawable) background2;
                        if (!TextUtils.isEmpty(rpcPoiBaseInfoTag.background_color)) {
                            gradientDrawable2.setColor(Color.parseColor(rpcPoiBaseInfoTag.background_color));
                        } else {
                            gradientDrawable2.setColor(-3091);
                        }
                        textView.setBackgroundDrawable(gradientDrawable2);
                    } catch (IllegalArgumentException e2) {
                        DLog.m36225d("Exception: " + e2.toString());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m8209a(View view, TextPaint textPaint, String str, int i, RpcPoi rpcPoi, DisplayMetrics displayMetrics) {
        TextView textView = (TextView) view.findViewById(R.id.rec_tag);
        if (i > 1) {
            textView.setVisibility(8);
        } else if (rpcPoi.extend_info == null || TextUtils.isEmpty(rpcPoi.extend_info.rec_tag_tittle)) {
            textView.setVisibility(8);
        } else {
            textView.setText(rpcPoi.extend_info.rec_tag_tittle);
            isInvadeOutside(textView, textPaint, str, displayMetrics);
        }
    }

    /* renamed from: a */
    private void m8208a(View view, int i, RpcPoi rpcPoi) {
        SpannableString a;
        SpannableString a2;
        TextView textView = (TextView) view.findViewById(R.id.sug_name);
        TextView textView2 = (TextView) view.findViewById(R.id.sug_addr);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout_item);
        DisplayMetrics displayMetrics = ViewUtils.getDisplayMetrics(view);
        int dp2px = DisplayUtils.dp2px(view.getContext(), 16.0f);
        relativeLayout.setPadding(0, dp2px, 0, dp2px);
        if (!this.f9435d || !isAddressInvadeOutside(view, textView, displayMetrics)) {
            textView2.setMaxLines(2);
            textView.setSingleLine(true);
            if (this.f9433b) {
                m8210a(view, textView.getPaint(), textView.getText().toString(), rpcPoi, displayMetrics);
            }
            if (this.f9432a) {
                m8209a(view, textView.getPaint(), textView.getText().toString(), i, rpcPoi, displayMetrics);
                return;
            }
            return;
        }
        int dp2px2 = DisplayUtils.dp2px(view.getContext(), 8.0f);
        textView2.setMaxLines(1);
        textView.setSingleLine(false);
        textView.setMaxLines(2);
        relativeLayout.setPadding(0, dp2px2, 0, dp2px2);
        if (this.f9433b && (a2 = m8206a(view, textView.getText().toString(), rpcPoi)) != null) {
            String charSequence = textView.getText().toString();
            textView.setText(a2);
            if (m8211a(view, textView, m8207a(view, textView, displayMetrics), displayMetrics)) {
                textView.setText(charSequence);
            }
        }
        if (this.f9432a && (a = m8205a(view, textView.getText().toString(), i, rpcPoi)) != null) {
            String charSequence2 = textView.getText().toString();
            textView.setText(a);
            if (m8211a(view, textView, m8207a(view, textView, displayMetrics), displayMetrics)) {
                textView.setText(charSequence2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isInvadeOutside(TextView textView, TextPaint textPaint, String str, DisplayMetrics displayMetrics) {
        int i = displayMetrics.widthPixels;
        Rect rect = new Rect();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        int width = rect.width();
        textView.getPaint().getTextBounds(textView.getText().toString(), 0, textView.getText().length(), rect);
        if (rect.width() + width > ((i * 3) / 4) - ((textView == null || textView.getContext() == null) ? 20 : DisplayUtils.dp2px(textView.getContext(), 20.0f))) {
            textView.setVisibility(8);
            return true;
        }
        textView.setVisibility(0);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isAddressInvadeOutside(View view, TextView textView, DisplayMetrics displayMetrics) {
        if (!(view == null || textView == null || displayMetrics == null)) {
            TextView textView2 = (TextView) view.findViewById(R.id.sug_distance);
            int i = displayMetrics.widthPixels;
            Rect rect = new Rect();
            textView.getPaint().getTextBounds(textView.getText().toString(), 0, textView.getText().length(), rect);
            if (rect.width() > (i - m8204a((TextView) view.findViewById(R.id.cf_tag))) - m8203a(view, textView)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private String m8207a(View view, TextView textView, DisplayMetrics displayMetrics) {
        TextView textView2 = (TextView) view.findViewById(R.id.sug_distance);
        TextView textView3 = (TextView) view.findViewById(R.id.cf_tag);
        new Rect();
        textView.getPaint();
        if (textView != null && textView.getText().length() > 0) {
            int i = displayMetrics.widthPixels;
            int a = (i - m8204a(textView3)) - m8203a(view, textView);
            if (a <= 0) {
                return null;
            }
            float measureText = textView.getPaint().measureText(textView.getText().toString()) / ((float) textView.getText().length());
            if (measureText > 0.0f) {
                return textView.getText().toString().substring((int) (((float) a) / measureText));
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m8211a(View view, TextView textView, String str, DisplayMetrics displayMetrics) {
        if (view != null && textView != null && !TextUtils.isEmpty(str) && str.length() > 0) {
            Rect rect = new Rect();
            TextPaint paint = textView.getPaint();
            int a = m8204a((TextView) view.findViewById(R.id.cf_tag));
            paint.getTextBounds(str, 0, str.length(), rect);
            if (rect.width() > (displayMetrics.widthPixels - a) - m8203a(view, textView)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private int m8203a(View view, TextView textView) {
        if (view == null || textView == null) {
            return 0;
        }
        TextView textView2 = (TextView) view.findViewById(R.id.sug_distance);
        Rect rect = new Rect();
        textView.getPaint();
        if (TextUtils.isEmpty(textView2.getText())) {
            return 0;
        }
        textView2.getPaint().getTextBounds(textView2.getText().toString(), 0, textView2.getText().length(), rect);
        return rect.width();
    }

    /* renamed from: a */
    private int m8204a(TextView textView) {
        if (textView == null || textView.getContext() == null) {
            return 90;
        }
        return DisplayUtils.dp2px(textView.getContext(), 90.0f);
    }

    /* renamed from: a */
    private SpannableString m8206a(View view, String str, RpcPoi rpcPoi) {
        TextView textView = (TextView) view.findViewById(R.id.cf_tag);
        Context context = textView.getContext();
        if (!this.f9434c || textView == null || rpcPoi.extend_info == null || rpcPoi.extend_info.enable_confirm_dropoff != 1) {
            if (rpcPoi.base_info == null || rpcPoi.base_info.poi_tag == null || rpcPoi.base_info.poi_tag.size() <= 0) {
                textView.setVisibility(8);
                return null;
            }
            RpcPoiBaseInfoTag rpcPoiBaseInfoTag = rpcPoi.base_info.poi_tag.get(0);
            String str2 = rpcPoiBaseInfoTag.name;
            if (rpcPoiBaseInfoTag.background_color == null || rpcPoiBaseInfoTag.content_color == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str + str2);
            int parseColor = Color.parseColor(rpcPoiBaseInfoTag.background_color);
            spannableString.setSpan(new RoundBackgroundColorSpan(context, parseColor, Color.parseColor(rpcPoiBaseInfoTag.content_color), m8202a(context, 9.0f), true), str.length(), spannableString.length(), 33);
            return spannableString;
        } else if (context == null) {
            return null;
        } else {
            String string = context.getString(R.string.GRider_destination_Confirm_exit_lILB);
            SpannableString spannableString2 = new SpannableString(str + string);
            spannableString2.setSpan(new RoundBackgroundColorSpan(context, -169679, -1, m8202a(context, 9.0f), true), str.length(), spannableString2.length(), 33);
            return spannableString2;
        }
    }

    /* renamed from: a */
    private SpannableString m8205a(View view, String str, int i, RpcPoi rpcPoi) {
        Context context = ((TextView) view.findViewById(R.id.rec_tag)).getContext();
        if (i > 1 || rpcPoi.extend_info == null || TextUtils.isEmpty(rpcPoi.extend_info.rec_tag_tittle)) {
            return null;
        }
        String str2 = rpcPoi.extend_info.rec_tag_tittle;
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new RoundBackgroundColorSpan(context, Color.parseColor("#00ac00"), Color.parseColor("#ffffff"), m8202a(context, 9.0f), true), str.length(), spannableString.length(), 33);
        return spannableString;
    }

    public void setSupportConfirmDropOff(boolean z) {
        this.f9434c = z;
    }

    public void setSupportMultiLineName(boolean z) {
        this.f9435d = z;
    }

    public void setRecSwitch(boolean z) {
        this.f9432a = z;
    }

    public void setSugSwitch(boolean z) {
        this.f9433b = z;
    }

    /* renamed from: a */
    private int m8202a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
