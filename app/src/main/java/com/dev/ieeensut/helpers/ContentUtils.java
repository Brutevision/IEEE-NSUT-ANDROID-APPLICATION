package com.dev.ieeensut.helpers;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/**
 *
 */

public class ContentUtils {

    public static final String EVENTS = "Events";
    public static final String IEEE_RESOURCES = "IEEE Resources";
    public static final String ABOUT_IEEE = "About IEEE";
    public static final String SHARED_PREF = "ieee_nsut";

    public static final String STATE_RESOLVING_ERROR = "resolving_error";

    public static final String TRANSITION_NAME = "transition_name";

    public static final String WEBSITE_URL = "https://www.ieeensut.com/";
    public static final String FACEBOOK_URL = "https://www.facebook.com/ieeensit/";
    public static final String INSTAGRAM_URL = "";
    public static final String TWITTER_URL = "";
    public static final String JOIN_IEEE_URL = "https://docs.google.com/forms/d/e/1FAIpQLSe92LHpgIFl9dvsDGR1H_Rwl9dQyvGbtjfBr67IcmkAbf-Rrw/viewform";


    public static ArrayList<String> getInterestArrayList(String interest) {
        ArrayList<String> interestArrayList = new ArrayList<>();
        if (interest != null) {
            String interestArray[] = interest.split(";");
            Collections.addAll(interestArrayList, interestArray);
            interestArrayList.remove(0);
        }

        return interestArrayList;
    }

    public static int convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }

    public static HashMap<String, Boolean> getMapFromArrayList(ArrayList<String> interestArrayList) {
        HashMap<String, Boolean> interestMap = new HashMap<>();
        for (String interest : interestArrayList) {
            interestMap.put(interest, true);
        }
        return interestMap;
    }

    public static ArrayList<String> getArrayListFromMap(HashMap<String, Boolean> interestMap) {
        ArrayList<String> interestArrayList = new ArrayList<>();
        interestArrayList.addAll(interestMap.keySet());
        return interestArrayList;
    }

    public static String formatString(String description){
        description = description.replace("\\n", "\n").replace("\\r", "\r");
        return description;

    }
}