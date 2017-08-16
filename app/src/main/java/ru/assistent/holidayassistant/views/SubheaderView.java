package ru.assistent.holidayassistant.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.assistent.holidayassistant.R;

/**
 * Created by Денис on 16.08.2017.
 */

public class SubheaderView extends LinearLayout  {
    @BindView(R.id.title)
    TextView mTitle;

    public SubheaderView(Context context) {
        super(context);
        init(null);
    }

    public SubheaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SubheaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SubheaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.kit_subheader, this);
        ButterKnife.bind(this);
        setAttrs(attrs);
    }

    private void setAttrs(AttributeSet attrs) {
        if (attrs == null) {
            return;
        }

        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.SubheaderView,
                0, 0
        );

        setText(a.getString(R.styleable.SubheaderView_text));
        a.recycle();
    }

    public void setText(String text) {
        mTitle.setText(text);
    }

    public void setText(@StringRes int resId) {
        mTitle.setText(resId);
    }
}
