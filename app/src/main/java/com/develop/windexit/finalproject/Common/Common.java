package com.develop.windexit.finalproject.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.develop.windexit.finalproject.Model.User;

/**
 * Created by WINDEX IT on 16-Feb-18.
 */

public class Common {
    public static User currentUser;

    public static String convertCodeToStatus(String status) {
        if (status.equals("0")) {
            return "Placed";
        } else if (status.equals("1")) {
            return "On my way";
        } else {
            return "Shipped";
        }
    }

    public static final String DELETE = "Delete";

    public static boolean isConnectedToINternet(Context context)
    {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            return true;
        }

        NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            return true;
        }

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        }

        return false;
    }
   /* public static boolean isConnectedToINternet(Context context) {

        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connec != null) {
            NetworkInfo info[] = connec.getAllNetworkInfo();  //All network info

            if (info != null)
            {
                int i;
                for (i = 0; i < info.length; i++) ;
                {

                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                        return false;
                }

            }
        }
        return false;
    }*/
}

