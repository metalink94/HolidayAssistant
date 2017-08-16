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
import ru.assistent.holidayassistant.views.elements.EditTextFonted;

/**
 * Created by Денис on 16.08.2017.
 */

public class KitTextFieldView extends LinearLayout {

    @BindView(R.id.textinput_layout)
    TextInputLayout mTextInputLayout;

    @BindView(R.id.input_field)
    EditTextFonted mEditTextFonted;


    public KitTextFieldView(Context context) {
        super(context);
        init(null);
    }

    public KitTextFieldView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public KitTextFieldView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public KitTextFieldView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attributeSet) {

        inflate(getContext(), R.layout.kit_row_text_field, this);
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
        mEditTextFonted.setHint(hint);
    }

    public void setInputHint(@StringRes int hint) {
        mEditTextFonted.setHint(hint);
    }

    public void setText(CharSequence text) {
        mEditTextFonted.setText(text);
    }

    public void setText(@StringRes int text) {
        mEditTextFonted.setText(text);
    }

    public String getText() {
        return mEditTextFonted.getText().toString();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        mEditTextFonted.setEnabled(enabled);
        mTextInputLayout.setEnabled(enabled);
    }
}
