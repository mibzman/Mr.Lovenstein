package com.Isotope.Mr__Lovenstein_Browser;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import com.startapp.android.publish.*;
import com.startapp.android.publish.banner.Banner;

/**
 * Created by Sam on 8/20/2014.
 */

public class settings extends Activity {
    SharedPreferences Lovenstein_data;
    public static String filename1 = "first";
    private StartAppAd startAppAd = new StartAppAd(this);
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings) ;

        Lovenstein_data = getSharedPreferences(filename1, 0);
        Boolean result = Lovenstein_data.getBoolean("webSupport", true);
        if (result) {
            CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
            checkBox.setChecked(true);
        }else{
            CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
            checkBox.setChecked(false);
        }


    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox :
               if (checked) {
                   Lovenstein_data = getSharedPreferences(filename1, 0);
                   SharedPreferences.Editor editor = Lovenstein_data.edit();
                   editor.putBoolean("webSupport", true);
                   editor.commit();
                }else {
                   Lovenstein_data = getSharedPreferences(filename1, 0);
                   SharedPreferences.Editor editor = Lovenstein_data.edit();
                   editor.putBoolean("webSupport", false);
                   editor.commit();
                }
                break;

        }
    }
}
