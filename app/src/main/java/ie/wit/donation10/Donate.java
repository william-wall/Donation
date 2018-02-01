package ie.wit.donation10;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.NumberPicker;
import android.widget.ProgressBar;




public class Donate extends AppCompatActivity {

    private int totalDonated = 0;

    private Button donateButton;
    private RadioGroup   paymentMethod;
    private ProgressBar  progressBar;
    private NumberPicker amountPicker;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        donateButton = (Button) findViewById(R.id.donateButton);

        if (donateButton != null)
        {
            Log.v("Donate", "Really got the donate button");
        }
        paymentMethod = (RadioGroup)   findViewById(R.id.paymentMethod);
        progressBar   = (ProgressBar)  findViewById(R.id.progressBar);
        amountPicker  = (NumberPicker) findViewById(R.id.amountPicker);

        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);
        progressBar.setMax(10000);

    }

//    public void donateButtonPressed (View view)
//    {
//        Log.v("Donate", "Donate Pressed!");
//    }

//    public void donateButtonPressed (View view)
//    {
//        int amount = amountPicker.getValue();
//        int radioId = paymentMethod.getCheckedRadioButtonId();
//        String method = "";
//        if (radioId == R.id.PayPal)
//        {
//            method = "PayPal";
//        }
//        else
//        {
//            method = "Direct";
//        }
//        Log.v("Donate", "Donate Pressed! with amount " + amount + ", method: " + method);
//    }
//public void donateButtonPressed (View view)
//{
//    int amount = amountPicker.getValue();
//    int radioId = paymentMethod.getCheckedRadioButtonId();
//    String method = radioId == R.id.paypal ? "PayPal" : "Direct";
//    Log.v("Donate", "Donate Pressed! with amount " + amount + ", method: " + method);
//    totalDonated = totalDonated + amount;
//    progressBar.setProgress(totalDonated);
//
//    Log.v("Donate", "Donate Pressed! with amount " + amount + ", method: " + method);
//    Log.v("Donate", "Current total " + totalDonated);
//}

    public void donateButtonPressed (View view)
    {
        String method = paymentMethod.getCheckedRadioButtonId() == R.id.paypal ? "PayPal" : "Direct";
        progressBar.setProgress(totalDonated);

        int donatedAmount =  amountPicker.getValue();
        if (donatedAmount == 0)
        {
            String text = editText.getText().toString();
            if (!text.equals(""))
                donatedAmount = Integer.parseInt(text);
        }
        totalDonated  = totalDonated + donatedAmount;
        Log.v("Donate", amountPicker.getValue() + " donated by " +  method + "\nCurrent total " + totalDonated);
    }
//
//    public void donateButtonPressed (View view)
//    {
//        int amount = amountPicker.getValue();
//        Log.v("Donate", "Donate Pressed! with amount " + amount);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
