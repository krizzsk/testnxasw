package com.didi.soda.web.p168ui;

import android.content.Context;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.support.rui.Popup;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.taxis99.R;
import rui.widget.popup.type.menu.list.PopupMenuList;

/* renamed from: com.didi.soda.web.ui.WebMenuListPopup */
public class WebMenuListPopup implements Cancelable {

    /* renamed from: a */
    private Context f46494a;

    /* renamed from: b */
    private ScopeContext f46495b;

    /* renamed from: c */
    private Popup f46496c;

    /* renamed from: d */
    private PopupMenuList f46497d;

    /* renamed from: e */
    private boolean f46498e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public MenuListClickListener f46499f;

    /* renamed from: com.didi.soda.web.ui.WebMenuListPopup$MenuListClickListener */
    public interface MenuListClickListener {
        void onMenuCancel();

        void onStartAlbum();

        void onStartCamera();
    }

    public WebMenuListPopup(Context context, ScopeContext scopeContext) {
        this.f46494a = context;
        this.f46495b = scopeContext;
        this.f46496c = new Popup(context);
        PopupMenuList popupMenuList = new PopupMenuList();
        this.f46497d = popupMenuList;
        popupMenuList.hasCancel = true;
        this.f46497d.cancelText = this.f46494a.getResources().getString(R.string.cancel);
        this.f46497d.cancelClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (WebMenuListPopup.this.f46499f != null) {
                    WebMenuListPopup.this.f46499f.onMenuCancel();
                }
            }
        };
        this.f46497d.addButton(this.f46494a.getResources().getString(R.string.soda_web_take_photo), new View.OnClickListener() {
            public void onClick(View view) {
                if (WebMenuListPopup.this.f46499f != null) {
                    WebMenuListPopup.this.f46499f.onStartCamera();
                }
            }
        });
        this.f46497d.addButton(this.f46494a.getResources().getString(R.string.soda_web_page_choice_from_pictures), new View.OnClickListener() {
            public void onClick(View view) {
                if (WebMenuListPopup.this.f46499f != null) {
                    WebMenuListPopup.this.f46499f.onStartAlbum();
                }
            }
        });
        this.f46496c.init(this.f46497d);
        this.f46496c.setCancelable(false);
        this.f46495b.getLiveHandler().bind(this);
    }

    public void setListener(MenuListClickListener menuListClickListener) {
        this.f46499f = menuListClickListener;
    }

    public void show() {
        ScopeContext scopeContext = this.f46495b;
        if (scopeContext != null && this.f46496c != null && !this.f46498e) {
            this.f46498e = true;
            scopeContext.getNavigator().showDialog(this.f46496c, "WebMenuListPopup");
        }
    }

    public void dismiss() {
        Popup popup = this.f46496c;
        if (popup != null) {
            this.f46498e = false;
            popup.dismiss();
        }
    }

    public void cancel() {
        dismiss();
        if (this.f46497d != null) {
            this.f46497d = null;
        }
    }
}
