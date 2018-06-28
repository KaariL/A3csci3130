package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DetailViewActivity extends Activity {

    private Button updateButton, deleteButton;
    private EditText nameField, addressField;
    //fill spinners
    private Spinner primaryBusinessSpinner, provinceSpinner;
    private MyApplicationData appState;
    Business receivedBusinessInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        appState = ((MyApplicationData) getApplicationContext());
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");
        //
        updateButton = (Button) findViewById(R.id.updateButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        nameField = (EditText) findViewById(R.id.nameField);
        addressField = (EditText) findViewById(R.id.addressField);
        primaryBusinessSpinner = (Spinner) this.findViewById(R.id.primaryBusinessSpinner);
        provinceSpinner = (Spinner) this.findViewById(R.id.provinceSpinner);
        //
        //fill spinners
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.businessTypesArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        primaryBusinessSpinner.setAdapter(adapter);
        //Get the app wide shared variables
        nameField.setText(receivedBusinessInfo.name);
        String compareValue = receivedBusinessInfo.primaryBusiness;
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            primaryBusinessSpinner.setSelection(spinnerPosition);
        }
        addressField.setText(receivedBusinessInfo.address);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.provincesArray, android.R.layout.simple_spinner_item);
        provinceSpinner.setAdapter(adapter);
        compareValue = receivedBusinessInfo.province;
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            provinceSpinner.setSelection(spinnerPosition);
        }
    }

    public void updateBusiness(View v){
        String UID = receivedBusinessInfo.businessNumber;
        String name = nameField.getText().toString();
        String address = addressField.getText().toString();
        String primaryBusiness = primaryBusinessSpinner.getSelectedItem().toString();
        String province = provinceSpinner.getSelectedItem().toString();
        Business business = new Business(UID, name, primaryBusiness, address, province);
        appState.firebaseReference.child(UID).setValue(business);
    }

    public void eraseBusiness(View v) {
        String UID = receivedBusinessInfo.businessNumber;
        appState.firebaseReference.child(UID).setValue(null);
    }
}
