package com.example.shrung.blitzzsdk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mylibrary.BlitzzClient;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.ArrayList;
import java.util.List;

import Listner.Callback;
import Model.BlitzzUser;
import Model.UserEmail;
import SSUserService.UserServices;
import Utility.Logger;
import Utility.MyEnum;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Signup extends BaseActivity implements Validator.ValidationListener {

    private static final String TAG = "Activity_Signup";
    private static final String SDKAUTHTOKEN = "A2E5CD5E6E6D48B88DD433C2869EC318";


    @NotEmpty
    @Email
    @BindView(R.id.signup_email_edit_text)
    EditText mSignupEmailEditText;

    @NotEmpty
    @Password
    @BindView(R.id.signup_password_edit_text)
    EditText mSignupPasswordEditText;

    @NotEmpty
    @BindView(R.id.signup_first_name_edit_text)
    EditText mSignupFirstNameEditText;

    @NotEmpty
    @BindView(R.id.signup_last_name_edit_text)
    EditText mSignupLastNameEditText;

    @BindView(R.id.signup_pc_code_edit_text)
    EditText mSignupPcCodeEditText;

    @NotEmpty
    @BindView(R.id.signup_phone_no_edit_text)
    EditText mSignupPhoneNoEditText;

    @BindView(R.id.signup_job_role_edit_text)
    EditText mSignupJobRoleEditText;

    @BindView(R.id.signup_register_btn)
    Button mSignupRegisterBtn;

    private Validator mValidator;
    private String mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        BlitzzClient.getInstance().initiliazeSDK(SDKAUTHTOKEN);

        Logger.getLogger().setLogLevel(MyEnum.DEBUGLEVEL.ON);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
    }

    @OnClick(R.id.signup_register_btn)
    public void onViewClicked() {
        mValidator.validate();
    }

    @Override
    public void onValidationSucceeded() {

        createAccount();

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

    private void createAccount() {

        BlitzzUser blitzzUser = new BlitzzUser(
                mSignupEmailEditText.getText().toString().trim(),
                mSignupPasswordEditText.getText().toString().trim(),
                mSignupFirstNameEditText.getText().toString().trim(),
                mSignupLastNameEditText.getText().toString().trim(),
                mSignupPcCodeEditText.getText().toString().trim(),
                mSignupPhoneNoEditText.getText().toString().trim(),
                mSignupJobRoleEditText.getText().toString().trim(),
                "ADM");


        new UserServices().createUserWithUserEmail(this, blitzzUser, new Callback() {
            @Override
            public void onSuccess(String json) {
                Toast.makeText(Activity_Signup.this, "Create user Success with email id", Toast.LENGTH_SHORT).show();
                Log.d(TAG, json);
                setResult(RESULT_OK);
            }

            @Override
            public void onError(String json) {
                Log.e(TAG, json);
            }
        });


    }


}
