package edu.whitworth.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            initButton(rootView);
            return rootView;
        }

        public void initButton(View v){
            Button btnAddition = (Button)v.findViewById(R.id.btnRun);                                          // open run page
            btnAddition.setOnClickListener (new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Intent additionProblems = new Intent(getApplicationContext(), Run.class);
                    startActivity(additionProblems);
                }
            });

            Button btnSubtraction = (Button)v.findViewById(R.id.btnResults);                                     // open results page
            btnSubtraction.setOnClickListener (new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Intent subtractionProblems = new Intent(getApplicationContext(), HistoricalResults.class);
                    startActivity(subtractionProblems);
                }
            });

            Button btnMultiplication = (Button)v.findViewById(R.id.btnSettings);                               // open settings page
            btnMultiplication.setOnClickListener (new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Intent multiplicationProblems = new Intent(getApplicationContext(), Settings.class);
                    startActivity(multiplicationProblems);
                }
            });

           }

    }

}
