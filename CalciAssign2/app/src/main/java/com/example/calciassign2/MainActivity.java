package com.example.calciassign2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonAdd, buttonSub, buttonDivide, buttonMultiply;
    private EditText editTextNum1, editTextNum2;
    private TextView textView;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();  // Initialize the Calculator

        // Initialize UI components
        buttonAdd = findViewById(R.id.addbtn);
        buttonSub = findViewById(R.id.subbtn);
        buttonDivide = findViewById(R.id.dividebtn);
        buttonMultiply = findViewById(R.id.multiplybtn);
        editTextNum1 = findViewById(R.id.number1);
        editTextNum2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        // Set button click listeners
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);

        // Handle window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Helper method to parse integer from EditText
    private int getIntegerFromEditText(EditText editText) {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Integer.parseInt(text);
    }

    @Override
    public void onClick(View v) {
        int num1 = getIntegerFromEditText(editTextNum1);
        int num2 = getIntegerFromEditText(editTextNum2);

        Operation operation = null;
        int id = v.getId();

        if (id == R.id.addbtn) {
            operation = new Addition();
        } else if (id == R.id.subbtn) {
            operation = new Subtraction();
        } else if (id == R.id.dividebtn) {
            operation = new Division();
        } else if (id == R.id.multiplybtn) {
            operation = new Multiplication();
        }

        if (operation != null) {
            String result = calculator.performOperation(operation, num1, num2);
            textView.setText(result);
        }
    }
}
