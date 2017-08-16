package ru.assistent.holidayassistant.views.elements;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;

import ru.assistent.holidayassistant.R;
import timber.log.Timber;

/**
 * Created by Денис on 16.08.2017.
 */

public class EditTextFonted extends AppCompatEditText {
    private static final String TAG = "TextView";

    private BackPressedListener mOnImeBack;

    public EditTextFonted(Context context) {
        super(context);
    }

    public EditTextFonted(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public EditTextFonted(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    public String getTextTrimmed() {
        String text = super.getText().toString();
        text = text.trim();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if ((i + 1) >= text.length() || text.charAt(i) != ' ' || text.charAt(i + 1) != ' ') {
                builder.append(text.charAt(i));
            }
        }
        return builder.toString();
    }


    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            if (mOnImeBack != null) mOnImeBack.onImeBack(this);
        }
        return super.dispatchKeyEvent(event);
    }

    public void setBackPressedListener(BackPressedListener listener) {
        mOnImeBack = listener;
    }

    public interface BackPressedListener {
        void onImeBack(EditTextFonted editText);
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
