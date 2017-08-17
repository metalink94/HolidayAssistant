package ru.assistent.holidayassistant.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import ru.assistent.holidayassistant.R;
import ru.assistent.holidayassistant.utils.dots.DotLoader;
import ru.assistent.holidayassistant.views.elements.TextViewFonted;

/**
 * Created by Денис on 17.08.2017.
 */

public class ProgressButton extends FrameLayout {
    private TextViewFonted mButton;
    private DotLoader mDots;
    private ProgressBar mProgress;

    private String mText;
    private int mDisabledTextColor;
    private int mTextColor;

    public ProgressButton(Context context) {
        super(context);
        init(null);
    }

    public ProgressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ProgressButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ProgressButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        mButton.setEnabled(enabled);
        if (enabled) {
            mButton.setTextColor(mTextColor);
        } else {
            mButton.setTextColor(mDisabledTextColor);
        }
    }

    @Override
    public void setClickable(boolean clickable) {
        super.setClickable(clickable);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.progressbutton_layout, this);

        mButton = (TextViewFonted) findViewById(R.id.button_of_action);
        mDots = (DotLoader) findViewById(R.id.dots);
        mProgress = (ProgressBar) findViewById(R.id.progressbar_progressbutton);

        mDots.setVisibility(INVISIBLE);
        mProgress.setVisibility(INVISIBLE);
        mProgress.setIndeterminate(true);
        mProgress.getIndeterminateDrawable().setColorFilter(0xFFFFFFFF, android.graphics.PorterDuff.Mode.MULTIPLY);

        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.ProgressButton,
                    0, 0
            );
            setText(a.getString(R.styleable.ProgressButton_text));
            mTextColor = a.getColor(R.styleable.ProgressButton_textColor, getResources().getColor(R.color.white));
            mButton.setTextColor(mTextColor);
            mDisabledTextColor = a.getColor(R.styleable.ProgressButton_disabledTextColor, getResources().getColor(R.color.text_disabled));
            if (a.getDrawable(R.styleable.ProgressButton_background) != null) {
                mButton.setBackground(a.getDrawable(R.styleable.ProgressButton_background));
            }

            a.recycle();
        }
    }

    public void setText(String text) {
        mText = text;
        mButton.setText(text);
    }

    public void setButtonsCount(int count) {
        mDots.setNumberOfDots(count);
    }

    public void setDotsVisible() {
        if (Build.VERSION.SDK_INT > 20) {
            mDots.setVisibility(VISIBLE);
            mDots._startAnimation();
        } else {
            mProgress.setVisibility(VISIBLE);
        }
        mButton.setText("");
        setClickable(false);
        setEnabled(false);

    }

    public void setDotsHide() {
        if (Build.VERSION.SDK_INT > 20) {
            mDots.setVisibility(INVISIBLE);
            mDots._stopAnimations();
        } else {
            mProgress.setVisibility(INVISIBLE);
        }
        mButton.setText(mText);
        setClickable(true);
        setEnabled(true);
    }

    public TextViewFonted getTextView() {
        return mButton;
    }
}
