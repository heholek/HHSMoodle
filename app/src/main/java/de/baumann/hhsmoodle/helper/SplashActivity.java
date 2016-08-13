/*
    This file is part of the Diaspora Native WebApp.

    Diaspora Native WebApp is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Diaspora Native WebApp is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with the Diaspora Native WebApp.

    If not, see <http://www.gnu.org/licenses/>.
 */

package de.baumann.hhsmoodle.helper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import de.baumann.hhsmoodle.HHS_MainScreen;
import de.baumann.hhsmoodle.R;


public class SplashActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        PreferenceManager.setDefaultValues(this, R.xml.user_settings, false);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        final String startType = sharedPref.getString("startType", "1");

        if (startType.equals("2")) {

            new Handler().postDelayed(new Runnable() {
                public void run() {

                     /* Create an intent that will start the main activity. */
                    Intent mainIntent = new Intent(SplashActivity.this, Start.class);
                    mainIntent.putExtra("id", "1");
                    //SplashScreen.this.startActivity(mainIntent);
                    startActivity(mainIntent);
                     /* Finish splash activity so user cant go back to it. */
                    SplashActivity.this.finish();
                     /* Apply our splash exit (fade out) and main
                        entry (fade in) animation transitions. */
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                }
            }, 2000);
        } else if (startType.equals("1")){
            new Handler().postDelayed(new Runnable() {
                public void run() {

                     /* Create an intent that will start the main activity. */
                    Intent mainIntent = new Intent(SplashActivity.this, HHS_MainScreen.class);
                    mainIntent.putExtra("id", "1");
                    //SplashScreen.this.startActivity(mainIntent);
                    startActivity(mainIntent);
                     /* Finish splash activity so user cant go back to it. */
                    SplashActivity.this.finish();
                     /* Apply our splash exit (fade out) and main
                        entry (fade in) animation transitions. */
                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                }
            }, 2000);
        }
    }
}
