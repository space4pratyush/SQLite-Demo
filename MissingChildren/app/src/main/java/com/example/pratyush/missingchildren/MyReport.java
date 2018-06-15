package com.example.pratyush.missingchildren;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyReport extends Fragment {

    public static final String EXTRA_URL="imageUrl";
    public static final String EXTRA_NAME="name";
    public static final String EXTRA_DESCRIPTION="description";
    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;
    private ArrayList<ListItem> mListItem;
    private RequestQueue requestQueue;

    public MyReport() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_report, container, false);

        mRecyclerView = view.findViewById(R.id.myRecyclerView1);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mListItem= new ArrayList<>();

//

        //Volley request quee.........
        requestQueue= Volley.newRequestQueue(getActivity());
        ParseJSON();

        return view;



    }
    private void ParseJSON(){
        String URL="https://api.myjson.com/bins/1ebswp";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray=response.getJSONArray("response");
                            //for loop for count number of data from api
                            for (int i=0; i < jsonArray.length(); i++){
                                JSONObject res=jsonArray.getJSONObject(i);

                                //get data...
                                String name=res.getString("name");
                                String image=res.getString("image_url");
                                String description=res.getString("description");

                                mListItem.add(new ListItem(name, image, description));
                            }
                            mMyAdapter=new MyAdapter(getActivity(), mListItem);
                            mRecyclerView.setAdapter(mMyAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}