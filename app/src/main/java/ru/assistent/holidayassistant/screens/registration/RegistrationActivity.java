package ru.assistent.holidayassistant.screens.registration;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.assistent.holidayassistant.R;
import ru.assistent.holidayassistant.utils.BaseActivity;
import ru.assistent.holidayassistant.views.KitAutoTextField;
import ru.assistent.holidayassistant.views.KitTextFieldView;
import ru.assistent.holidayassistant.views.ProgressButton;
import ru.assistent.holidayassistant.views.elements.NoScrollViewPager;

/**
 * Created by Денис on 17.08.2017.
 */

public class RegistrationActivity extends BaseActivity implements RegistrationView {

    @BindView(R.id.pager)
    NoScrollViewPager mPager;

    @BindView(R.id.accept_button)
    ProgressButton mButton;

    private RegistrationPagerAdapter mPagerAdapter;
    private RegistrationPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        mPresenter = new RegistrationPresenter();
        mPresenter.setView(this);
        mPagerAdapter = new RegistrationPagerAdapter();
        mPager.setAdapter(mPagerAdapter);
    }

    @OnClick(R.id.accept_button)
    public void onAcceptButtonClick() {
        mPresenter.onAcceptButtonClick(mPager.getCurrentItem());
    }

    @Override
    public void checkFirstPage() {
        mPresenter.onCheckFirstPage(mPagerAdapter.getLogin(), mPagerAdapter.getPassword(), mPagerAdapter.isCorrectPassword());
    }

    @Override
    public void checkSecondPage() {
        mPresenter.onCheckSecondPage(mPagerAdapter.getName(), mPagerAdapter.getSurname(), mPagerAdapter.getCity());
    }

    @Override
    public void showErrorToast(int message) {
        showToast(message);
    }

    @Override
    public void changeButtonText(int text) {
        mButton.setText(getString(text));
    }

    @Override
    public void changePage() {
        mPager.setCurrentItem(mPager.getCurrentItem() + 1);
    }

    private class RegistrationPagerAdapter extends PagerAdapter {

        private static final int COUNT = 2;
        private int mLayouts[] = {R.layout.view_registration_first, R.layout.view_registration_second};
        KitTextFieldView login;
        KitTextFieldView password;
        KitTextFieldView passwordRepeat;
        KitTextFieldView name;
        KitTextFieldView surname;
        KitAutoTextField city;

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater inflater = LayoutInflater.from(RegistrationActivity.this);
            ViewGroup layout = (ViewGroup) inflater.inflate(mLayouts[position], container, false);
            container.addView(layout);
            if (position == 0) {
                login = layout.findViewById(R.id.login);
                password = layout.findViewById(R.id.password);
                passwordRepeat = layout.findViewById(R.id.repeat_password);
            } else {
                name = layout.findViewById(R.id.name);
                surname = layout.findViewById(R.id.surname);
                city = layout.findViewById(R.id.city);
            }
            return layout;
        }

        public String getLogin() {
            return login.getText();
        }

        public String getPassword() {
            return password.getText();
        }

        public boolean isCorrectPassword() {
            return password.getText().equals(passwordRepeat.getText());
        }

        public String getName() {
            return name.getText();
        }

        public String getSurname() {
            return name.getText();
        }

        public String getCity() {
            return city.getText();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
