package location.com.nearme.uiutil;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;

import location.com.nearme.ApplicationConstant;

/**
 * Created by S430729 on 23/12/2017.
 */

public class AlertMessage {
    public void show(Context context, String title,
                     String msg, ApplicationConstant.AlertButton buttons,
                     AlertInterface alertInterface) {
        switch (buttons) {
            case NoButton:
                break;
            case TwoButtons:
                showAlertWith2Buttons(context, title, msg, alertInterface);
                break;
            case SingleButton:
                showAlertWith1Buttons(context, title, msg, alertInterface);
                break;
        }
    }

    private void showAlertWith2Buttons(Context context, String title, String msg, final AlertInterface alertInterface) {
        makeAlert(context, title, msg).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertInterface.onPositiveButtonClick();
            }
        }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertInterface.onNegativeButtonClick();
            }
        }).show();
    }

    private void showAlertWith1Buttons(Context context, String title, String msg, final AlertInterface alertInterface) {
        makeAlert(context, title, msg).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertInterface.onPositiveButtonClick();
            }
        }).show();
    }

    private AlertDialog.Builder makeAlert(Context context, String title, String msg) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        return builder.setTitle(title)
                .setMessage(msg);
    }
}
