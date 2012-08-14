package com.test.start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {

	EditText personsEmail,personsName,message_body;
	String emailAdd,name,content;
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emaill);
		initializeVars();
		sendEmail.setOnClickListener(this);
	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		personsEmail = (EditText) findViewById(R.id.etEmails);
		personsName = (EditText) findViewById(R.id.etName);
		message_body = (EditText) findViewById(R.id.etMessage);
		sendEmail = (Button) findViewById(R.id.bSentEmail);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

		conv_text_string();
		String emailaddress[] = { emailAdd };
		String message = "Hey, "
				+"My Name is "+ name +" ,\n"
				+ content;
		
		Intent email= new Intent(android.content.Intent.ACTION_SEND);
		email.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
		email.putExtra(android.content.Intent.EXTRA_SUBJECT, "Feedback");
		email.setType("plain/text");
		email.putExtra(android.content.Intent.EXTRA_TEXT, message);

	}

	private void conv_text_string() {
		// TODO Auto-generated method stub
		emailAdd = personsEmail.getText().toString();
		name = personsName.getText().toString();
		content = message_body.getText().toString();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}