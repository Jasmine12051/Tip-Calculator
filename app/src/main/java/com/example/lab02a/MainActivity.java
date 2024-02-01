package com.example.lab02a;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.lab02a.databinding.ActivityMainBinding;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EditText totalBillInput = binding.totalBillInput;
                EditText tipPercentInput = binding.tipPercentageInput;
                EditText numPeopleInput = binding.numPeopleInput;
                String totalBill = totalBillInput.getText().toString();
                String tipPercent = tipPercentInput.getText().toString();
                String numPeople = numPeopleInput.getText().toString();
                checkInputs(totalBill, tipPercent, numPeople);
            }
        });

    }

    private void calculate(float totalBill, int tipPercent, int numPeople) {

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        float total = ((totalBill * ((float) tipPercent /100)) + totalBill) / numPeople;
        String formattedTotal = currencyFormatter.format(total);
        TextView t = binding.output;
        String outputText = "Total Per Person: " + formattedTotal;
        t.setText(outputText);
    }

    private void checkInputs(String totalBill, String tipPercent, String numPeople){
        if(totalBill.isEmpty() || tipPercent.isEmpty() || numPeople.isEmpty()){
            Log.d("CHECK INPUTS", "ERROR: All inputs not provided!");
        }
        else{
            float totalBillnum = Float.parseFloat(totalBill);
            int tipPercentnum = Integer.parseInt(tipPercent);
            int numPeoplenum = Integer.parseInt(numPeople);
            calculate(totalBillnum,tipPercentnum,numPeoplenum);
        }
    }
}