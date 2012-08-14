package com.test.start;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String[] Classes = { "StartingPoint","TextPlay","Scroll","Email"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,Classes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String listItem = Classes[position];
		try{
			Class listClass = Class.forName("com.test.start."+ listItem);
			Intent listIntent = new Intent(Menu.this,listClass);
			startActivity(listIntent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	
	

}
