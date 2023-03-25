package com.rtlab.babyname;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;

public class MenuUtil {
    public static boolean handleMenuItemClick(Context context, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mShare:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.app_name));
                String link = context.getString(R.string.uri);
                shareIntent.putExtra(Intent.EXTRA_TEXT, link);
                context.startActivity(Intent.createChooser(shareIntent, context.getString(R.string.share)));
                return true;
            case R.id.mFavourites:
                Intent intent = new Intent(context, FavouriteActivity.class);
                context.startActivity(intent);
                return true;
            case R.id.mRate:
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.uri))));
                return true;
            case R.id.mPrivacyPolicy:
                context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.privacy_uri))));
                return true;
            case R.id.mFeedback:
                Intent feedbackIntent = new Intent(Intent.ACTION_SEND);
                feedbackIntent.setType("text/plain");
                feedbackIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { context.getString(R.string.feedback_email) });
                feedbackIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.feedback);
                context.startActivity(Intent.createChooser(feedbackIntent, ""));
                return true;
            default:
                return false;
        }
    }
}

