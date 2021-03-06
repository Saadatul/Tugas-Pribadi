package id.sch.smktelkom_mlg.privateassignment.xirpl632.privateassignment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PageDetail3 extends AppCompatActivity {

    private static final String URL_DATA = "https://api.themoviedb.org/3/movie/popular?api_key=0bc12e9b8cdad4c2fdb7ad83354e7055";
    public TextView textViewHeading;
    public TextView textViewDesc;
    public TextView textViewReview;
    public ImageView imageViewDetail;
    public String url;

    private Integer mPostkey = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        mPostkey = getIntent().getExtras().getInt("blog_id");
        loadRecyclerViewData();

        textViewHeading = (TextView) findViewById(R.id.textViewHeading3);
        textViewDesc = (TextView) findViewById(R.id.textViewDesc3);
        textViewReview = (TextView) findViewById(R.id.textViewReview3);
        imageViewDetail = (ImageView) findViewById(R.id.imageViewDetail3);
    }

    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading data ...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray array = jsonObject.getJSONArray("results");
                    JSONObject o = array.getJSONObject(mPostkey);

                    setTitle("Movie Details");
                    textViewHeading.setText(o.getString("title"));
                    textViewDesc.setText("Overview" + o.getString("overview"));
                    textViewReview.setText("Popularity : " + o.getString("popularity"));
                    url = o.getJSONObject("link").getString("url");
                    Glide
                            .with(PageDetail3.this)
                            .load("http://image.tmdb.org/t/p/w500" + o.getString("poster_path"))
                            .into(imageViewDetail);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
