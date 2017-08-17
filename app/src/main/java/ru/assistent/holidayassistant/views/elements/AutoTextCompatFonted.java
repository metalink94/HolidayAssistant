package ru.assistent.holidayassistant.views.elements;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;

import ru.assistent.holidayassistant.R;
import timber.log.Timber;

/**
 * Created by Денис on 17.08.2017.
 */

public class AutoTextCompatFonted extends android.support.v7.widget.AppCompatAutoCompleteTextView {

    private BackPressedListener mOnImeBack;

    public AutoTextCompatFonted(Context context) {
        super(context);
    }

    public AutoTextCompatFonted(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public AutoTextCompatFonted(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context, attrs);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            if (mOnImeBack != null) mOnImeBack.onImeBack(this);
        }
        return super.dispatchKeyEvent(event);
    }

    public interface BackPressedListener {
        void onImeBack(AutoTextCompatFonted autoTextCompatFonted);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.TextViewFonted);
        String customFont = a.getString(R.styleable.TextViewFonted_customFont);
        if (customFont == null) customFont = "Roboto-Light.ttf";
        setCustomFont(ctx, customFont);
        a.recycle();
    }

    public boolean setCustomFont(Context ctx, String asset) {
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), asset);
        } catch (Exception e) {
            Timber.e(e, "Could not get typeface");
            return false;
        }

        setTypeface(tf);
        setLineSpacing(getTextSize() * 0.3f, 0.75f);
        return true;
    }
}
