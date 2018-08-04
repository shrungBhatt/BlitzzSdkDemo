package com.example.shrung.blitzzsdk;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mylibrary.BlitzzClient;
import com.example.shrung.blitzzsdk.models.Model_RoleList;
import com.example.shrung.blitzzsdk.utils.Const;
import com.example.shrung.blitzzsdk.utils.LoggerConfig;
import com.google.gson.Gson;
import com.mobsandgeeks.saripaar.ValidationError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Listner.Callback;
import SSUserService.UserServices;

public class BaseActivity extends AppCompatActivity {

    public ArrayList<Model_RoleList.ROLELIST> mROLELISTArrayList;

    public void initSDK(String json, Context context, String tag) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("response", new JSONObject(json));
            String userAuthToken = jsonObject.getJSONObject("response").optString("USERAUTHTOKEN");
            BlitzzClient.getInstance().initiliazeSDK(context, Const.SDKAUTHTOKEN, userAuthToken);
            LoggerConfig.infoLog(tag, userAuthToken);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void validateErrors(List<ValidationError> errors, Context context) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(context);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        }

    }

    public ArrayList<Model_RoleList.ROLELIST> getRoleList(final String TAG,
                                                           final Spinner spinner,
                                                           final AdapterView.OnItemSelectedListener onItemSelectedListener,
                                                           final Context context) {


        new UserServices().getRoleList(new Callback() {
            @Override
            public void onSuccess(String json) {
                // PREPARE ARRAY OF ROLELIST USING JSON.
                LoggerConfig.infoLog(TAG, json);

                try {
                    JSONObject jsonObject = new JSONObject(json);
                    Model_RoleList model_roleList;
                    model_roleList = new Gson().fromJson(jsonObject.toString(), Model_RoleList.class);
                    mROLELISTArrayList = model_roleList.getROLELIST();
                    setAdapter(spinner, model_roleList.getROLELIST(),
                            onItemSelectedListener,
                            context);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(String json) {
                Toast.makeText(getApplicationContext(), "Error in Role list", Toast.LENGTH_SHORT).show();
                LoggerConfig.errorLog(TAG, json);
            }
        });

        return mROLELISTArrayList;

    }

    public void setAdapter(Spinner spinner, ArrayList<Model_RoleList.ROLELIST> modelRoleLists,
                           AdapterView.OnItemSelectedListener onItemSelectedListener, Context context) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                R.layout.simple_spinner_layout, getRoleListNames(modelRoleLists));
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    private ArrayList<String> getRoleListNames(ArrayList<Model_RoleList.ROLELIST> modelRoleLists) {

        ArrayList<String> roleNames = new ArrayList<>();

        for (Model_RoleList.ROLELIST rolelist : modelRoleLists) {

            roleNames.add(rolelist.getDISPLAYNAME());

        }

        return roleNames;
    }

}