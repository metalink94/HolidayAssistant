package ru.assistent.holidayassistant.views.elements;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;

import java.lang.reflect.Field;

import ru.assistent.holidayassistant.R;
import ru.assistent.holidayassistant.utils.ScrollerCustomDuration;
import timber.log.Timber;

/**
 * Created by Денис on 17.08.2017.
 */

public class NoScrollViewPager extends ViewPager {

    private static final String TAG = "NoScrollViewPager";

    private static final int DEFAULT_OFFSCREEN_PAGES = 0;//change default to load one page,no offset,ViewPager is 1,so cache 2 Fragment
    private static final int MAX_SETTLE_DURATION = 600; // ms
    private int mOffscreenPageLimit = DEFAULT_OFFSCREEN_PAGES;

    private boolean isPagingEnabled = true;
    private ScrollerCustomDuration mScroller = null;

    public NoScrollViewPager(Context context) {
        super(context);
        postInitViewPager(null);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        postInitViewPager(attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    public void setPagingEnabled(boolean b) {
        this.isPagingEnabled = b;
    }

    /**
     * Override the Scroller instance with our own class so we can change the
     * duration
     * @param attrs
     */
    private void postInitViewPager(AttributeSet attrs) {
        if (attrs != null) {
            setAttrs(attrs);
        }
        try {
            Field scroller = ViewPager.class.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            Field interpolator = ViewPager.class.getDeclaredField("sInterpolator");
            interpolator.setAccessible(true);

            mScroller = new ScrollerCustomDuration(getContext(),
                    (Interpolator) interpolator.get(null));
            scroller.set(this, mScroller);
        } catch (Exception e) {
            Timber.e(e.getMessage());
        }
    }

    private void setAttrs(AttributeSet attrs) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.NoScrollViewPager,
                0, 0
        );
        setPagingEnabled(a.getBoolean(R.styleable.NoScrollViewPager_scrolleEnable, true));
    }

    /**
     * Set the factor by which the duration will change
     */
    public void setScrollDurationFactor(double scrollFactor) {
        mScroller.setScrollDurationFactor(scrollFactor);
    }
}
