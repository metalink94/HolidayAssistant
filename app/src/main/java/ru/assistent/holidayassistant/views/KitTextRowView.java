package ru.assistent.holidayassistant.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.assistent.holidayassistant.R;
import ru.assistent.holidayassistant.views.elements.TextViewFonted;

/**
 * Created by Денис on 21.08.2017.
 */

public class KitTextRowView extends LinearLayout {

    @BindView(R.id.hint)
    TextViewFonted hint;

    @BindView(R.id.main_text)
    TextViewFonted mainText;


    public KitTextRowView(Context context) {
        super(context);
        init(null);
    }

    public KitTextRowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public KitTextRowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public KitTextRowView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.kit_text_view, this);
        ButterKnife.bind(this);
        if (attrs != null) {
            setAttrs(attrs);
        }
    }

    private void setAttrs(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.KitTextRowView,
                0, 0
        );

        setHint(a.getString(R.styleable.KitTextRowView_hint));
        setText(a.getString(R.styleable.KitTextRowView_text));
    }

    public void setHint(CharSequence text) {
        hint.setText(text);
    }

    public void setHint(@StringRes int text) {
        hint.setText(text);
    }

    public void setText(CharSequence text) {
        mainText.setText(text);
    }

    public void setText(@StringRes int text) {
        mainText.setText(text);
    }

}
