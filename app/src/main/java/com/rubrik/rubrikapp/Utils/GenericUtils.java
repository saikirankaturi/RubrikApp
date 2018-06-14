package com.rubrik.rubrikapp.Utils;

import android.os.StrictMode;
import android.util.Log;
import android.util.Xml;

import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class GenericUtils {
    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public static boolean isValidIpAddress(final String ip) {
        return PATTERN.matcher(ip).matches();
    }

    public static boolean isIpAccessibleOver443(final String ip) {
        return true;
//        try {
//            Log.d("addr", ip);
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//            Log.d("IsReachable", Boolean.toString(InetAddress.getByName(ip).isReachable(100)));
//            return InetAddress.getByName(ip).isReachable(100);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//        Runtime runtime = Runtime.getRuntime();
//        Process proc;
//        try {
//            proc = runtime.exec("ping -c 1" + ip);
//            proc.waitFor(1, TimeUnit.MINUTES);
//            int exit = proc.exitValue();
//            Log.d("Woah Yeah: ", proc.getOutputStream().toString());
//            System.out.println("Woah Yeah: " + exit);
//            return (exit == 0);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//            return false;
//        }
    }
}
