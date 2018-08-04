package com.example.shrung.blitzzsdk;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shrung.blitzzsdk.models.Model_RoleList;
import com.example.shrung.blitzzsdk.utils.LoggerConfig;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.ArrayList;
import java.util.List;

import Listner.Callback;
import Model.Req_UpdateRoleName;
import Model.RoleList;
import SSUserService.UserServices;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity_RoleManagement extends BaseActivity implements
        AdapterView.OnItemSelectedListener,
        Validator.ValidationListener {

    private static final String TAG = "Activity_RoleManagement";

    @NotEmpty
    @BindView(R.id.role_management_role_name_edt)
    EditText mRoleManagementRoleNameEdt;
    @BindView(R.id.role_management_spinner)
    Spinner mRoleManagementSpinner;
    @BindView(R.id.role_management_update_btn)
    Button mRoleManagementUpdateBtn;
    private Validator mValidator;
    private String mRoleCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_management);
        ButterKnife.bind(this);

        getRoleList(TAG, mRoleManagementSpinner, this, this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);

    }


    private void editRoleName() {


        ArrayList<RoleList> arrayList = new ArrayList<>();
        RoleList roleList = new RoleList(mRoleManagementRoleNameEdt.getText().toString().trim(),
                mRoleCode);
        arrayList.add(roleList);
        new UserServices().updateRoleTitle(new Req_UpdateRoleName(arrayList), new Callback() {
            @Override
            public void onSuccess(String json) {
                Toast.makeText(getApplicationContext(), "onSuccess", Toast.LENGTH_SHORT).show();
                LoggerConfig.infoLog(TAG, json);
            }

            @Override
            public void onError(String json) {
                Toast.makeText(getApplicationContext(), "onError", Toast.LENGTH_SHORT).show();
                LoggerConfig.errorLog(TAG, json);
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(mROLELISTArrayList != null) {

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
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @OnClick(R.id.role_management_update_btn)
    public void onViewClicked() {
        mValidator.validate();
    }

    @Override
    public void onValidationSucceeded() {
        editRoleName();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        validateErrors(errors, this);

    }
}
