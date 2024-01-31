package com.example.lab02a;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
                EditText totalBillInput = binding.totalbillInput;
                EditText tipPercentInput = binding.tipPercentageInput;
                EditText numPeopleInput = binding.numPeopleInput;
                float totalBill = Float.parseFloat(totalBillInput.getText().toString());
                int tipPercent = Integer.parseInt(tipPercentInput.getText().toString());
                int numPeople = Integer.parseInt(numPeopleInput.getText().toString());
                calculate(totalBill,tipPercent,numPeople);
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
}