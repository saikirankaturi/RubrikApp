package com.rubrik.rubrikapp.RestApi;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rubrik.rubrikapp.AppController;

import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class JsonObjectRetriever {

    private static void handleSSLHandshake() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                @Override
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
        } catch (Exception ignored) {
        }
    }

    public static <T> void getObjectFromRest(
            final String url,
            final ProgressDialog pDialog,
            final Class<T> clazz,
            final String TAG,
            final JsonObjectVolleyInterface jsonObjectVolleyInterface
    ) {
        handleSSLHandshake();
        final String tag_json_obj = "json_obj_req";
        pDialog.setMessage("Loading...");
        pDialog.show();
        GsonRequest<T> jsonObjectRequest =
            new GsonRequest<T>(
                "https://" + AppController.getInstance().getClusterIp() + "/api/" + url,
                clazz,
                null,
                new Response.Listener<T>() {
                    @Override
                    public void onResponse(T response) {
                        Log.d(TAG, response.toString());
                        pDialog.hide();
                        jsonObjectVolleyInterface.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        error.printStackTrace();
                        pDialog.hide();
                    }
                }
            );
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, tag_json_obj);
    }
}
