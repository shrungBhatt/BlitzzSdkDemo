package com.example.shrung.blitzzsdk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.shrung.blitzzsdk.adapter.Adapter_Participants;
import com.example.shrung.blitzzsdk.listeners.Listener_OnLongClick;
import com.example.shrung.blitzzsdk.models.Model_Participants;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Listner.Callback;
import SSUserService.UserServices;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_ActiveUsers extends BaseActivity implements Listener_OnLongClick {

    private static final String TAG = "Activity_ActiveUsers";
    @BindView(R.id.active_users_recycler_view)
    RecyclerView mActiveUsersRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_users);
        ButterKnife.bind(this);
        getActiveUsers("");

        mActiveUsersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    private void getActiveUsers(String query) {
        new UserServices().getUserListWith(1, 60, query, new Callback() {
            @Override
            public void onSuccess(String json) {
                Toast.makeText(getApplicationContext(), "User Details List Success", Toast.LENGTH_SHORT).show();

                try {
                    JSONObject jsonObject = new JSONObject(json);
                    Model_Participants model_participants;
                    model_participants = new Gson().fromJson(jsonObject.toString(),
                            Model_Participants.class);

                    populateRecyclerView(model_participants.getParticipants());

                } catch (JSONException e) {
                    Log.e(TAG, e.getMessage());
                }

                Log.e(TAG, json);
            }

            @Override
            public void onError(String json) {
                Toast.makeText(getApplicationContext(), "Error in User Details List", Toast.LENGTH_SHORT).show();
                Log.e(TAG, json);
            }
        });


    }

    private void populateRecyclerView(ArrayList<Model_Participants.Participant> participants) {

        if (participants != null) {
            mActiveUsersRecyclerView.setAdapter(new Adapter_Participants(this, participants,
                    this));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.menu_item_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                getActiveUsers(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                getActiveUsers(s);
                return true;
            }
        });
        return true;
    }

    @Override
    public void onLongClick(Model_Participants.Participant participant, int position) {

        deactivateUser(String.valueOf(participant.getUCID()));

    }

    private void deactivateUser(String ucid) {

        new UserServices().deActivateUser(ucid, new Callback() {
            @Override
            public void onSuccess(String json) {
                Toast.makeText(getApplicationContext(), "User Deactivated", Toast.LENGTH_SHORT).show();
                Log.e(TAG, json);
                getActiveUsers("");
            }

            @Override
            public void onError(String json) {
                Toast.makeText(getApplicationContext(), "Error in User Deactivated", Toast.LENGTH_SHORT).show();
                Log.e(TAG, json);
            }
        });


    }
}
