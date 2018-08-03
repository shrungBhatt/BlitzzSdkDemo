package com.example.shrung.blitzzsdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mylibrary.BlitzzClient;
import com.example.shrung.blitzzsdk.utils.Const;
import com.example.shrung.blitzzsdk.utils.LoggerConfig;


import Listner.Callback;
import Model.BlitzzUser;
import SSUserService.UserServices;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    public static final String TAG = "MainActivity";

    @BindView(R.id.add_user_button)
    Button mAddUserButton;
    @BindView(R.id.sign_up_user)
    Button mSignUpUser;
    @BindView(R.id.user_details)
    Button mUserDetails;
    @BindView(R.id.edit_profile)
    Button mEditProfile;
    @BindView(R.id.change_password)
    Button mChangePassword;
    @BindView(R.id.active_users)
    Button mActiveUsers;
    @BindView(R.id.role_managment)
    Button mRoleManagement;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BlitzzClient.getInstance().initiliazeSDK(Const.SDKAUTHTOKEN);


        BlitzzUser blitzzUser = new BlitzzUser("shrung1@gmail.com", "123456789");
        new UserServices().login(this, blitzzUser, new Callback() {
            @Override
            public void onSuccess(String s) {
                LoggerConfig.infoLog(TAG, s);
                Toast.makeText(getApplicationContext(), "Logged In!", Toast.LENGTH_SHORT).show();
                initSDK(s, MainActivity.this, TAG);

            }

            @Override
            public void onError(String s) {
                Toast.makeText(getApplicationContext(), "Something went wrong!",
                        Toast.LENGTH_SHORT).show();
                LoggerConfig.errorLog(TAG, s);
            }
        });
    }


    @OnClick({R.id.add_user_button, R.id.sign_up_user, R.id.user_details, R.id.edit_profile,
            R.id.change_password, R.id.active_users, R.id.role_managment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_user_button:
                startActivity(new Intent(this, Activity_InviteUser.class));
                break;
            case R.id.sign_up_user:
                startActivity(new Intent(this, Activity_Signup.class));
                break;
            case R.id.user_details:
                startActivity(new Intent(this, Activity_Userdetails.class));
                break;
            case R.id.edit_profile:
                startActivity(new Intent(this, Activity_EditProfile.class));
                break;
            case R.id.change_password:
                startActivity(new Intent(this, Activity_ChangePassword.class));
                break;
            case R.id.active_users:
                startActivity(new Intent(this,Activity_ActiveUsers.class));
                break;
            case R.id.role_managment:
                startActivity(new Intent(this,Activity_RoleManagement.class));
                break;

        }
    }

}
