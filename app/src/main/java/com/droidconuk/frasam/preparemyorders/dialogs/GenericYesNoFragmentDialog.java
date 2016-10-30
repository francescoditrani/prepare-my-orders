package com.droidconuk.frasam.preparemyorders.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.droidconuk.frasam.preparemyorders.R;


/**
 * Created by fditrani on 08/05/15.
 */
public class GenericYesNoFragmentDialog extends MyFixedDialogFragment{
    private String title;
    private String message;
    private String requestCode;

    public interface GenericYesNoFragmentDialogListener{

        void onYesGenericDialogFragment(String requestCode);
    }


    public static GenericYesNoFragmentDialog newInstance(String title, String message, String requestCode){
        GenericYesNoFragmentDialog f = new GenericYesNoFragmentDialog();
        Bundle args = new Bundle();
//        args.putString("title", title);
        args.putString("message", message);
        args.putString("requestCode", requestCode);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("title");
        message = getArguments().getString("message");
        requestCode = getArguments().getString("requestCode");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message);
        if (title != null && !title.isEmpty()){
            builder.setTitle(title);
        }
        builder.setPositiveButton(R.string.addtocart, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                ((GenericYesNoFragmentDialogListener) getActivity()).onYesGenericDialogFragment(requestCode);
             }
        })
        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                GenericYesNoFragmentDialog.this.dismissAllowingStateLoss();
            }
        });
        return builder.create();
    }
}
