package com.example.shrung.blitzzsdk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import Listner.Callback;
import SSUserService.UserServices;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_ChangePassword extends BaseActivity implements Validator.ValidationListener{

    private static final String TAG = "Activity_ChangePassword";

    @NotEmpty
    @Password
    @BindView(R.id.old_pass_edit_text)
    EditText mOldPassEditText;

    @NotEmpty
    @Password
    @BindView(R.id.new_pass_edit_text)
    EditText mNewPassEditText;

    @BindView(R.id.change_password_button)
    Button mChangePasswordButton;
    private Validator mValidator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);

    }


    private void changePassword() {

        new UserServices().changePassword(mOldPassEditText.getText().toString().trim(),
                mNewPassEditText.getText().toString().trim(), new Callback() {
            @Override
            public void onSuccess(String json) {
                Toast.makeText(getApplicationContext(), "Change Password success", Toast.LENGTH_SHORT).show();
                initSDK(json, Activity_ChangePassword.this, TAG);
                Log.e(TAG, json);
            }

            @Override
            public void onError(String json) {
                Toast.makeText(getApplicationContext(), "Error Change Password", Toast.LENGTH_SHORT).show();
                Log.e(TAG, json);
            }
        });


    }

    @OnClick(R.id.change_password_button)
    public void onViewClicked() {
        mValidator.validate();
    }

    @Override
    public void onValidationSucceeded() {
        changePassword();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        validateErrors(errors,Activity_ChangePassword.this);
    }
}
