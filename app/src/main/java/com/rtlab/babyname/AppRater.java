package com.rtlab.babyname;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AppRater {


    private final static int DAYS_UNTIL_PROMPT = 0;//Min number of days
    private final static int LAUNCHES_UNTIL_PROMPT = 0;//Min number of launches

    public static void app_launched(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("apprater", 0);
        if (prefs.getBoolean("dontshowagain", false)) { return ; }

        SharedPreferences.Editor editor = prefs.edit();

        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        // Wait at least n days before opening
        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch +
                    (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                showRateDialog(mContext, editor);
            }
        }

        editor.commit();
    }

    public static void showRateDialog(final Context mContext, final SharedPreferences.Editor editor) {
        final String APP_TITLE = mContext.getString(R.string.app_name);
        final String APP_PNAME = mContext.getString(R.string.package_name);
        final String RATE = mContext.getString(R.string.rate);
        final String URI = mContext.getString(R.string.uri);

        final Dialog dialog = new Dialog(mContext);
        dialog.setTitle(RATE + APP_TITLE);

        LinearLayout ll = new LinearLayout(mContext);
        ll.setBackgroundResource(R.drawable.custom_dropdown);
        ll.setPadding(55, 65, 55, 55);
        ll.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView tv = new TextView(mContext);
        tv.setLayoutParams(params);
        tv.setText(mContext.getString(R.string.rate_question));
        tv.setWidth(540);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,19);
        tv.setTextColor(mContext.getResources().getColor(R.color.textRedColor));
        ll.addView(tv);

        Button b1 = new Button(mContext);
        String rateTitle = RATE + " " + APP_TITLE;
        b1.setText(rateTitle);
        b1.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
        params.setMargins(5,10, 5, 10);
        b1.setTextSize(22);
        b1.setAllCaps(false);
        b1.setLayoutParams(params);

        b1.setBackground(mContext.getResources().getDrawable(R.drawable.rate_button));
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(URI)));
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });


        Button b3 = new Button(mContext);
        b3.setText(mContext.getString(R.string.no));
        b3.setLayoutParams(params);
        b3.setBackground(mContext.getResources().getDrawable(R.drawable.rate_button));
        b3.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
        b3.setTextSize(18);
        b3.setAllCaps(false);
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (editor != null) {
                    editor.putBoolean("dontshowagain", true);
                    editor.commit();
                }
                dialog.dismiss();
            }
        });


        Button b2 = new Button(mContext);
        b2.setText(mContext.getString(R.string.remind_me_later));
        b2.setLayoutParams(params);
        b2.setTextSize(20);
        b2.setAllCaps(false);
        b2.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
        b2.setBackground(mContext.getResources().getDrawable(R.drawable.rate_button));
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ll.addView(b2);
        ll.addView(b3);
        ll.addView(b1);

        dialog.setContentView(ll);
        dialog.show();
    }
}
