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
        //Get the app wide shared variables
        if(receivedBusinessInfo != null){
           // nameField.setText(receivedBusinessInfo.name);
        }
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
        //
        updateButton = (Button) findViewById(R.id.updateButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        nameField = (EditText) findViewById(R.id.nameField);
        addressField = (EditText) findViewById(R.id.addressField);
    }

    public void updateBusiness(View v){
        //TODO: Update business funcionality
    }

    public void eraseBusiness(View v)
    {
        //TODO: Erase business functionality
    }
}
