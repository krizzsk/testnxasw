package com.didi.addressold.view;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.MotionEventCompat;
import androidx.customview.widget.ViewDragHelper;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;

public class CommonAddressItemView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ViewGroup f9702a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f9703b;

    /* renamed from: c */
    private ImageView f9704c;

    /* renamed from: d */
    private ImageView f9705d;

    /* renamed from: e */
    private LinearLayout f9706e;

    /* renamed from: f */
    private TextView f9707f;

    /* renamed from: g */
    private TextView f9708g;

    /* renamed from: h */
    private TextView f9709h;

    /* renamed from: i */
    private ViewDragHelper f9710i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Point f9711j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Point f9712k;

    /* renamed from: l */
    private RpcCommonPoi f9713l;

    /* renamed from: m */
    private boolean f9714m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f9715n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public DragStateCallback f9716o;

    /* renamed from: p */
    private ViewDragHelper.Callback f9717p;

    public interface DragStateCallback {
        void onDragToExpand();
    }

    public CommonAddressItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommonAddressItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9702a = null;
        this.f9703b = null;
        this.f9704c = null;
        this.f9705d = null;
        this.f9706e = null;
        this.f9707f = null;
        this.f9708g = null;
        this.f9709h = null;
        this.f9710i = null;
        this.f9711j = new Point();
        this.f9712k = new Point();
        this.f9713l = null;
        this.f9714m = false;
        this.f9715n = false;
        this.f9717p = new ViewDragHelper.Callback() {
            public boolean tryCaptureView(View view, int i) {
                return CommonAddressItemView.this.f9702a == view;
            }

            public void onViewDragStateChanged(int i) {
                if (i != 0) {
                    return;
                }
                if (CommonAddressItemView.this.f9702a.getLeft() == 0) {
                    boolean unused = CommonAddressItemView.this.f9715n = false;
                } else {
                    boolean unused2 = CommonAddressItemView.this.f9715n = true;
                }
            }

            public int clampViewPositionHorizontal(View view, int i, int i2) {
                if (view != CommonAddressItemView.this.f9702a) {
                    return 0;
                }
                if (CommonAddressItemView.this.f9703b.getWidth() + i < 0) {
                    return -CommonAddressItemView.this.f9703b.getWidth();
                }
                if (i > 0) {
                    return 0;
                }
                return i;
            }

            public void onViewReleased(View view, float f, float f2) {
                if (view != CommonAddressItemView.this.f9702a) {
                    return;
                }
                if (f > 0.0f) {
                    CommonAddressItemView.this.close();
                } else if (f < 0.0f) {
                    CommonAddressItemView.this.expand();
                    CommonAddressItemView.this.f9716o.onDragToExpand();
                } else if (CommonAddressItemView.this.f9702a.getLeft() <= (CommonAddressItemView.this.f9712k.x - CommonAddressItemView.this.f9711j.x) / 2) {
                    CommonAddressItemView.this.expand();
                    CommonAddressItemView.this.f9716o.onDragToExpand();
                } else {
                    CommonAddressItemView.this.close();
                }
            }

            public int getViewHorizontalDragRange(View view) {
                return CommonAddressItemView.this.f9703b.getWidth();
            }
        };
        LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_view_common_address_item, this);
        this.f9702a = (ViewGroup) findViewById(R.id.layout_item);
        this.f9704c = (ImageView) findViewById(R.id.image_delete);
        this.f9705d = (ImageView) findViewById(R.id.image_title);
        this.f9706e = (LinearLayout) findViewById(R.id.text_container);
        this.f9707f = (TextView) findViewById(R.id.text_title);
        this.f9708g = (TextView) findViewById(R.id.text_content);
        this.f9709h = (TextView) findViewById(R.id.text_not_set);
        this.f9703b = findViewById(R.id.button_delete);
        this.f9710i = ViewDragHelper.create(this, 1.0f, this.f9717p);
    }

    public void expand() {
        ViewDragHelper viewDragHelper = this.f9710i;
        if (viewDragHelper != null && this.f9714m) {
            viewDragHelper.smoothSlideViewTo(this.f9702a, this.f9712k.x, this.f9712k.y);
            invalidate();
        }
    }

    public void close() {
        ViewDragHelper viewDragHelper = this.f9710i;
        if (viewDragHelper != null) {
            viewDragHelper.smoothSlideViewTo(this.f9702a, this.f9711j.x, this.f9711j.y);
            invalidate();
        }
    }

    public void setDeleteState(boolean z) {
        if (z) {
            this.f9704c.setVisibility(0);
        } else {
            this.f9704c.setVisibility(8);
        }
    }

    public boolean getDeleteState() {
        return this.f9714m && this.f9704c.getVisibility() == 0;
    }

    public void setDragClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f9702a;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public boolean isExpanded() {
        if (this.f9702a.getLeft() == 0) {
            return false;
        }
        return this.f9715n;
    }

    public void setDeleteClickListener(View.OnClickListener onClickListener) {
        View view = this.f9703b;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        ImageView imageView = this.f9704c;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setExpandable(boolean z) {
        this.f9714m = z;
    }

    public void setCommonAddress(RpcCommonPoi rpcCommonPoi) {
        this.f9713l = rpcCommonPoi;
        if (rpcCommonPoi == null) {
            return;
        }
        if (3 == rpcCommonPoi.type) {
            this.f9705d.setImageResource(R.drawable.poi_one_address_list_home);
            if (getContext().getString(R.string.global_sug_add_home).equals(this.f9713l.displayName)) {
                this.f9706e.setVisibility(8);
                this.f9709h.setVisibility(0);
                this.f9709h.setText(this.f9713l.displayName);
                return;
            }
            this.f9709h.setVisibility(8);
            this.f9706e.setVisibility(0);
            this.f9707f.setText(this.f9713l.name);
            this.f9708g.setText(this.f9713l.getAddress());
        } else if (4 == this.f9713l.type) {
            this.f9705d.setImageResource(R.drawable.poi_one_address_list_company);
            if (getContext().getString(R.string.global_sug_add_company).equals(this.f9713l.displayName)) {
                this.f9706e.setVisibility(8);
                this.f9709h.setVisibility(0);
                this.f9709h.setText(this.f9713l.displayName);
                return;
            }
            this.f9709h.setVisibility(8);
            this.f9706e.setVisibility(0);
            this.f9707f.setText(this.f9713l.name);
            this.f9708g.setText(this.f9713l.getAddress());
        } else if (5 == this.f9713l.type) {
            this.f9705d.setImageResource(R.drawable.poi_one_address_favorite);
            this.f9709h.setVisibility(8);
            this.f9706e.setVisibility(0);
            this.f9707f.setText(this.f9713l.aliasName);
            this.f9708g.setText(this.f9713l.address);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f9711j.x = this.f9702a.getLeft();
        this.f9711j.y = this.f9702a.getTop();
        this.f9712k.x = this.f9702a.getLeft() - this.f9703b.getWidth();
        this.f9712k.y = this.f9702a.getTop();
    }

    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.f9710i;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true) && this.f9714m) {
            invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f9714m || this.f9710i == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 3 && actionMasked != 1) {
            return this.f9710i.shouldInterceptTouchEvent(motionEvent);
        }
        this.f9710i.cancel();
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!this.f9714m || (viewDragHelper = this.f9710i) == null) {
            return true;
        }
        viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.savedCommonAddress = this.f9713l;
        savedState.savedExpandable = this.f9714m ? 1 : 0;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setCommonAddress(savedState.savedCommonAddress);
            setExpandable(savedState.savedExpandable != 0);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        RpcCommonPoi savedCommonAddress;
        int savedExpandable;

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.savedCommonAddress = null;
            this.savedExpandable = 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSerializable(this.savedCommonAddress);
            parcel.writeInt(this.savedExpandable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.savedCommonAddress = null;
            this.savedExpandable = 0;
            this.savedCommonAddress = (RpcCommonPoi) parcel.readSerializable();
            this.savedExpandable = parcel.readInt();
        }
    }

    public void setDragStateCallback(DragStateCallback dragStateCallback) {
        this.f9716o = dragStateCallback;
    }
}
