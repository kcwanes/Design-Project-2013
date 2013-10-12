package com.vutoch.traffic;

import android.os.Bundle;
import android.app.*;
import android.content.DialogInterface;
import android.view.*;
import android.widget.Toast;

public class Traffic extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.traffic, menu);
		return true;
	}
	
	public void Show_Dialog(String title, String body, boolean allowBackButton) {
		AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
		dlgAlert.setTitle(title);
		dlgAlert.setMessage(body);
		dlgAlert.setPositiveButton("OK", null);
		dlgAlert.setCancelable(allowBackButton);
		dlgAlert.setPositiveButton("OK",
			    new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface dialog, int which) {
			          //dismiss the dialog  
			        }
			    });
		dlgAlert.create().show();
	}
	
	public void Prompt_User(String title, String body, boolean allowBackButton) {
		AlertDialog.Builder ab = new AlertDialog.Builder(this);
		DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		        switch (which){
		        case DialogInterface.BUTTON_POSITIVE:
		            //Do your Yes progress
		        	Show_Toast("You chose yes");
		            break;

		        case DialogInterface.BUTTON_NEGATIVE:
		            //Do your No progress
		        	Show_Toast("You chose no");
		            break;
		        }
		    }
		};
		
		ab.setMessage("Are you sure to delete?").setPositiveButton("Yes", dialogClickListener)
		    .setNegativeButton("No", dialogClickListener).show();
	}
	
	public void Show_Toast(String text) {
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
	
	public void Welcome(View theButton) {
		//Show_Dialog("Derp","LALALALAL",true);
		Prompt_User("Derp","dsnsdfiksdf",true);
		//Show_Toast("DERP!");
	}

}
