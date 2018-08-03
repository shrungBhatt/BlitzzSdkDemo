package com.example.shrung.blitzzsdk;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mylibrary.BlitzzClient;
import com.example.shrung.blitzzsdk.utils.Const;
import com.example.shrung.blitzzsdk.utils.LoggerConfig;
import com.mobsandgeeks.saripaar.ValidationError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class BaseActivity extends AppCompatActivity {

    public void initSDK(String json, Context context,String tag) {
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

    public void validateErrors(List<ValidationError> errors,Context context){
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

}