package ru.assistent.holidayassistant.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.assistent.holidayassistant.R;
import ru.assistent.holidayassistant.views.elements.AutoTextCompatFonted;

/**
 * Created by Денис on 17.08.2017.
 */

public class KitAutoTextField extends LinearLayout {

    @BindView(R.id.textinput_layout)
    TextInputLayout mTextInputLayout;

    @BindView(R.id.input_field)
    AutoTextCompatFonted mAutoTextCompatFonted;

    public KitAutoTextField(Context context) {
        super(context);
        init(null);
    }

    public KitAutoTextField(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public KitAutoTextField(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public KitAutoTextField(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attributeSet) {

        inflate(getContext(), R.layout.kit_row_auto_text_field, this);
        ButterKnife.bind(this);
        if (attributeSet != null) {
            setAttrs(attributeSet);
        }
    }

    private void setAttrs(AttributeSet attributeSet) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attributeSet,
                R.styleable.KitTextFieldView,
                0, 0
        );

        setHint(a.getString(R.styleable.KitTextFieldView_hint));
        setInputHint(a.getString(R.styleable.KitTextFieldView_inputHint));
        setText(a.getString(R.styleable.KitTextFieldView_text));
    }

    public void setHint(CharSequence hint) {
        mTextInputLayout.setHint(hint);
    }

    public void setInputHint(CharSequence hint) {
        mAutoTextCompatFonted.setHint(hint);
    }

    public void setInputHint(@StringRes int hint) {
        mAutoTextCompatFonted.setHint(hint);
    }

    public void setText(CharSequence text) {
        mAutoTextCompatFonted.setText(text);
    }

    public void setText(@StringRes int text) {
        mAutoTextCompatFonted.setText(text);
    }

    public String getText() {
        return mAutoTextCompatFonted.getText().toString();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        mAutoTextCompatFonted.setEnabled(enabled);
        mTextInputLayout.setEnabled(enabled);
    }
}
