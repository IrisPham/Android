package com.example.visualstudio.canthouniversity.modules.rateMark.data;

import android.app.DownloadManager;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Visual Studio on 8/8/2017.
 */

public class EvaluationCriteria {
    private Context mcontext;
    public EvaluationCriteria(Context context) {
        this.mcontext = context;
        String url = "http://androidctu.96.lt/getJSONEC.php";
        RequestQueue requestQueue = Volley.newRequestQueue(mcontext);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mcontext, ""+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
