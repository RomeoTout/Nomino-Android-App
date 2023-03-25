package com.rtlab.babyname;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SaveUtil {

    final String NAMES_LIST = "namesList";



    //checks existing saved name array. if exists it adds the existing list to a new list along with the new saved name and replaces the old list in the shared prefs
    public void saveNames(Context context, ArrayList<String> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Set<String> set = new HashSet<String>();

        Set<String> existingSet = prefs.getStringSet(NAMES_LIST, new HashSet<String>());
        if (existingSet != null){
            set.addAll(existingSet);
        }

        set.addAll(list);
        editor.putStringSet(key, set);
        editor.apply();
        Toast.makeText(context, context.getString(R.string.savedtoast), Toast.LENGTH_LONG).show();
    }

    public ArrayList<String> getNamesList(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Set<String> set = prefs.getStringSet(NAMES_LIST, new HashSet<String>());
        assert set != null;
        return new ArrayList<>(set);
    }

    //it is used in Fav Activity. it replaces the existing list in the shared pref with a new one where a name was deleted
    public void replaceNames(Context context, ArrayList<String> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Set<String> set = new HashSet<String>();

        set.addAll(list);
        editor.putStringSet(key, set);
        editor.apply();
        Toast.makeText(context, context.getString(R.string.del_msg), Toast.LENGTH_LONG).show();
    }
}

