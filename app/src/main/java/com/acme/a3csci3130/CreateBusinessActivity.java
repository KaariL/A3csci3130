package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateBusinessActivity extends Activity{

    private Button submitButton;
    private EditText nameField, addressField;
    private Spinner primaryBusinessSpinner, provinceSpinner;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_activity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());
        //fill spinners
        primaryBusinessSpinner = (Spinner) this.findViewById(R.id.primaryBusinessSpinner);
        provinceSpinner = (Spinner) this.findViewById(R.id.provinceSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.businessTypesArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        primaryBusinessSpinner.setAdapter(adapter);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.provincesArray, android.R.layout.simple_spinner_item);
        provinceSpinner.setAdapter(adapter);

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.nameField);
        addressField = (EditText) findViewById(R.id.addressField);

    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String UID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String address = addressField.getText().toString();
        String primaryBusiness = primaryBusinessSpinner.getSelectedItem().toString();
        String province = provinceSpinner.getSelectedItem().toString();
        Business business = new Business(UID, name, primaryBusiness, address, province);

        appState.firebaseReference.child(UID).setValue(business);

        finish();
    }

}
