package com.didi.component.safetoolkit.sodaentregaapi;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.config.GlobalComponentConfig;
import com.didi.component.common.dialog.GlobalDialog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.safetoolkit.api.ISFTripRecordingService;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;

@ServiceProvider(alias = "sodaEntrega", value = {ISFTripRecordingService.class})
public class SodaEntregaAudioRecordingService implements ISFTripRecordingService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public GlobalDialog f17293a = new GlobalDialog();

    public String getAlias() {
        return GlobalComponentConfig.TRIP_AUDIO_RECORD_ALIAS_PASSENGET;
    }

    public void onRecordingStatusChanged(boolean z) {
        BaseEventPublisher.getPublisher().publish("event_record_status_changed", Boolean.valueOf(z));
    }

    public void openLawWebView() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_OPEN_LAW_URL);
    }

    public void showDialog(final FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, final View.OnClickListener onClickListener) {
        if (this.f17293a.isPendingDismiss() || !this.f17293a.isVisible()) {
            this.f17293a.build().title(str2).actions(new GlobalDialog.IButtonAction[]{new GlobalDialog.PositiveButtonAction() {
                public String getName() {
                    return fragmentActivity.getString(R.string.global_record_permission_confirm);
                }

                public Runnable getAction() {
                    return new Runnable() {
                        public void run() {
                            onClickListener.onClick((View) null);
                            SodaEntregaAudioRecordingService.this.f17293a.dismiss();
                        }
                    };
                }

                public GlobalDialog.IButtonAction.ButtonType getType() {
                    return GlobalDialog.IButtonAction.ButtonType.POSITIVE;
                }
            }, new GlobalDialog.PositiveButtonAction() {
                public String getName() {
                    return fragmentActivity.getString(R.string.global_record_permission_cancel);
                }

                public Runnable getAction() {
                    return new Runnable() {
                        public void run() {
                            SodaEntregaAudioRecordingService.this.f17293a.dismiss();
                        }
                    };
                }

                public GlobalDialog.IButtonAction.ButtonType getType() {
                    return GlobalDialog.IButtonAction.ButtonType.NEGATIVE;
                }
            }}).show(fragmentActivity.getSupportFragmentManager(), "audio_record");
        }
    }
}
