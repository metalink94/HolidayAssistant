package ru.assistent.holidayassistant.utils;


import android.app.ProgressDialog;
import android.support.annotation.StringRes;
import android.widget.Toast;

import ru.assistent.holidayassistant.R;

/**
 * Created by Денис on 16.08.2017.
 */

public class BaseActivity extends AbstractBaseActivity {

    private ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.please_wait));
            mProgressDialog.setCancelable(false);
        }
        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    public void killCurrentProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    protected void showToast(@StringRes int msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
