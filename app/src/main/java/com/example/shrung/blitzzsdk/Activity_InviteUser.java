package com.example.shrung.blitzzsdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mylibrary.BlitzzClient;
import com.example.shrung.blitzzsdk.models.Model_RoleList;
import com.example.shrung.blitzzsdk.utils.LoggerConfig;
import com.google.gson.Gson;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Listner.Callback;
import Model.UserEmail;
import SSUserService.UserServices;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_InviteUser extends BaseActivity implements
        AdapterView.OnItemSelectedListener, Validator.ValidationListener {

    public static final String TAG = "Activity_InviteUser";

    private static final String SDKAUTHTOKEN = "A2E5CD5E6E6D48B88DD433C2869EC318";
    @BindView(R.id.add_user_button)
    Button mAddUserButton;

    @NotEmpty
    @Email
    @BindView(R.id.email_id)
    EditText mEmailId;
    @BindView(R.id.user_role_spinner)
    Spinner mUserRoleSpinner;
    Validator mValidator;
    private String mRoleCode;
    private ArrayList<Model_RoleList.ROLELIST> mROLELISTArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_user);
        ButterKnife.bind(this);

        BlitzzClient.getInstance().initiliazeSDK(SDKAUTHTOKEN);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);


        getRoleList();

        /**
         * Chat services are not working properly according to the documentation. Caused by error
         *java.lang.RuntimeException: applicationId is null. You must call QBSettings.getInstance().init(Context, String, String, String) before using the QuickBlox library.
         */

/*        ChatServices.getInstance().addChatConnectionListener(this);


        ChatServices.getInstance().chatLogin(new SessionCallbacks() {
            @Override
            public void onSuccess() {
                Toast.makeText(getApplicationContext(), "Login ==>  OnSuccess", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(BlitzzResponseException blitzzResponseException) {
                Toast.makeText(getApplicationContext(), "Login ==> " + blitzzResponseException.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/


    }

    /**
     * This method is giving response:
     * {"ERRORMESSAGE":"User token not found.","ERRORTITLE":"User token missing","stackTrace":[],"suppressedExceptions":[]}
     * I have followed the documentation sequentially and implemented all the steps above it.
     */

    private void getRoleList() {


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
                    setAdapter(mUserRoleSpinner, mROLELISTArrayList);

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

    }

    private void inviteNewUser(String email) {

        ArrayList<UserEmail> userEmails = new ArrayList<>();
        UserEmail inviteUserByTechID = new UserEmail(email, mRoleCode);
        userEmails.add(inviteUserByTechID);
        new UserServices().inviteByUserEmail(userEmails, new Callback() {
            @Override
            public void onSuccess(String json) {
                Toast.makeText(getApplicationContext(), "Invited", Toast.LENGTH_SHORT).show();
                LoggerConfig.infoLog(TAG, json);
            }

            @Override
            public void onError(String json) {
                Toast.makeText(getApplicationContext(), "Error in invite user by email id", Toast.LENGTH_SHORT).show();
                LoggerConfig.errorLog(TAG, json);
            }
        });

    }


    private void setAdapter(Spinner spinner, ArrayList<Model_RoleList.ROLELIST> modelRoleLists) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.simple_spinner_layout, getRoleListNames(modelRoleLists));
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private ArrayList<String> getRoleListNames(ArrayList<Model_RoleList.ROLELIST> modelRoleLists) {

        ArrayList<String> roleNames = new ArrayList<>();

        for (Model_RoleList.ROLELIST rolelist : modelRoleLists) {

            roleNames.add(rolelist.getDISPLAYNAME());

        }

        return roleNames;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (i) {
            case 0:
                mRoleCode = mROLELISTArrayList.get(i).getRCODE();
                break;
            case 1:
                mRoleCode = mROLELISTArrayList.get(i).getRCODE();
                break;
            case 2:
                mRoleCode = mROLELISTArrayList.get(i).getRCODE();
                break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    @OnClick(R.id.add_user_button)
    public void onViewClicked() {

        mValidator.validate();

    }

    @Override
    public void onValidationSucceeded() {
        if(mRoleCode != null && !mRoleCode.equalsIgnoreCase("")) {
            inviteNewUser(mEmailId.getText().toString().trim());
        }else{
            Toast.makeText(getApplicationContext(),"Select Role Code",Toast.LENGTH_SHORT).
                    show();
        }
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
