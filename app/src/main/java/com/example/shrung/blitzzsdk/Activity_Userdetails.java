package com.example.shrung.blitzzsdk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shrung.blitzzsdk.models.Model_Profile;
import com.example.shrung.blitzzsdk.utils.LoggerConfig;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import Listner.Callback;
import SSUserService.UserServices;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_Userdetails extends BaseActivity {
    public static final String TAG = "Activity_Userdetails";
    @BindView(R.id.ucid_edit_text)
    EditText mUcidEditText;
    @BindView(R.id.find_user)
    Button mFindUser;
    @BindView(R.id.user_details_name)
    TextView mUserDetailsName;
    @BindView(R.id.user_details_company_name)
    TextView mUserDetailsCompanyName;
    @BindView(R.id.user_details_email)
    TextView mUserDetailsEmail;
    @BindView(R.id.user_details_job_role)
    TextView mUserDetailsJobRole;
    private Model_Profile.PROFILE mPROFILE;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.find_user)
    public void onViewClicked() {

        findUser(mUcidEditText.getText().toString().trim());


    }

    private void findUser(String user) {

        new UserServices().getUserDetails(user, new Callback() {
            @Override
            public void onSuccess(String json) {
                Toast.makeText(getApplicationContext(), "User Details Success", Toast.LENGTH_SHORT).show();
                LoggerConfig.infoLog(TAG, json);

                try {
                    JSONObject jsonObject = new JSONObject(json);
                    Model_Profile modelProfile;
                    modelProfile = new Gson().fromJson(jsonObject.toString(), Model_Profile.class);
                    mPROFILE = modelProfile.getPROFILE();
                    setData(mPROFILE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(String json) {
                Toast.makeText(getApplicationContext(), "Error in User Details", Toast.LENGTH_SHORT).show();
                LoggerConfig.errorLog(TAG, json);
            }
        });


    }

    private void setData(Model_Profile.PROFILE profile) {
        if(profile != null){

            mUserDetailsName.setText(profile.getFULLNAME());
            mUserDetailsCompanyName.setText(profile.getCOMPANY());
            mUserDetailsJobRole.setText(profile.getJOBROLE());
            mUserDetailsEmail.setText(profile.getUEMAIL());

        }

    }
}
