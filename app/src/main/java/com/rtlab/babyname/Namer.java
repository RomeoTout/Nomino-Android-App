package com.rtlab.babyname;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Namer {



    public static String myAssetReader(Context context){
        BufferedReader reader = null;
        String myNames = "";
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open("allfemale.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                myNames += mLine;

            }
        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return myNames;
    }

    public static ArrayList<String> myListAssetReader(Context context, String listName){
        BufferedReader reader = null;
        ArrayList names = new ArrayList();
        try {
            reader = new BufferedReader(
                    new InputStreamReader(context.getAssets().open(listName)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                names.add(mLine);

            }
        } catch (IOException e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return names;
    }

    public static ArrayList<Name> nameLister(ArrayList<String> list){
        ArrayList nameList = new ArrayList();
        for(int i = 0; i< list.size(); i++){
            nameList.add(nameCreator(list.get(i)));
        }

        return nameList;
    }

    //creates the name object
    public static Name nameCreator(String listLine){
        Name name = null;
        for (int i = 0; i < listLine.length(); i++){
            if(listLine.charAt(i) == '='){
                name = new Name(listLine.substring(0, i-1), listLine.substring(i));
            }
        }
        return name;
    }
    


    public static int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public static Name nameFromNameList (ArrayList<Name> nameList){
        return nameList.get(randomWithRange(0, nameList.size()-1));
    }
}
