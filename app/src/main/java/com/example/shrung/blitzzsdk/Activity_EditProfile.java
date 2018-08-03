package com.example.shrung.blitzzsdk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import Listner.Callback;
import Model.BlitzzUser;
import SSUserService.UserServices;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_EditProfile extends BaseActivity implements Validator.ValidationListener{

    private static final String TAG = "Activity_EditProfile";

    @NotEmpty
    @BindView(R.id.edit_profile_first_name_edit_text)
    EditText mEditProfileFirstNameEditText;

    @NotEmpty
    @BindView(R.id.edit_profile_last_name_edit_text)
    EditText mEditProfileLastNameEditText;

    @NotEmpty
    @BindView(R.id.edit_profile_pc_code_edit_text)
    EditText mEditProfilePcCodeEditText;

    @NotEmpty
    @BindView(R.id.edit_profile_phone_no_edit_text)
    EditText mEditProfilePhoneNoEditText;

    @NotEmpty
    @BindView(R.id.edit_profile_job_role_edit_text)
    EditText mEditProfileJobRoleEditText;


    @BindView(R.id.edit_profile_update_btn)
    Button mEditProfileUpdateBtn;

    private Validator mValidator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
    }

    @OnClick(R.id.edit_profile_update_btn)
    public void onViewClicked() {
        mValidator.validate();
    }

    private void updateProfile(){
        BlitzzUser blitzzUser = new BlitzzUser(
                mEditProfileFirstNameEditText.getText().toString().trim(),
                mEditProfileLastNameEditText.getText().toString().trim(),
                mEditProfilePcCodeEditText.getText().toString().trim(),
                mEditProfilePhoneNoEditText.getText().toString(),
                mEditProfileJobRoleEditText.getText().toString().trim(), null);
        new UserServices().updateUserDetails(blitzzUser, new Callback() {
            @Override
            public void onSuccess(String json) {
                Toast.makeText(getApplicationContext(), "Profile updated", Toast.LENGTH_SHORT).show();
                Log.e(TAG, json);
            }

            @Override
            public void onError(String json) {
                Toast.makeText(getApplicationContext(), "Error in Profile update", Toast.LENGTH_SHORT).show();
                Log.e(TAG, json);
            }
        });


    }

    @Override
    public void onValidationSucceeded() {
        updateProfile();

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
