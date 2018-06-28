package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField;
    Business receivedBusinessInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");

        nameField = (EditText) findViewById(R.id.nameField);

        if(receivedBusinessInfo != null){
            nameField.setText(receivedBusinessInfo.name);
        }
    }

    public void updateBusiness(View v){
        //TODO: Update business funcionality
    }

    public void eraseBusiness(View v)
    {
        //TODO: Erase business functionality
    }
}
