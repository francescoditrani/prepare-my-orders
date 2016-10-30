package com.droidconuk.frasam.preparemyorders.dialogs;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by fditrani on 28/04/15.
 */
public class MyFixedDialogFragment extends DialogFragment {

    @Override
    public void show(FragmentManager manager, String tag) {
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commitAllowingStateLoss();
    }

}
