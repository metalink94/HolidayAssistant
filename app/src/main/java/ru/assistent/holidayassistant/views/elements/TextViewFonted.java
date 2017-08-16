package ru.assistent.holidayassistant.views.elements;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import ru.assistent.holidayassistant.R;
import timber.log.Timber;

/**
 * Created by Денис on 16.08.2017.
 */

public class TextViewFonted extends AppCompatTextView {

    private static final String TAG = "TextView";

    public TextViewFonted(Context context) {
        super(context);
    }

    public TextViewFonted(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public TextViewFonted(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.TextViewFonted);
        String customFont = a.getString(R.styleable.TextViewFonted_customFont);
        if (customFont == null) customFont = "Roboto-Regular.ttf";
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
