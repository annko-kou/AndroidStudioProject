package com.example.hellosample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick = findViewById(R.id.btClick);
        HelloListener listener = new HelloListener();
        btClick.setOnClickListener(listener);

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);

        EdgeToEdge.enable(this);
      //  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      //      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      //      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      //      return insets;
      //  });

}
    private class HelloListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            int id = view.getId();
            EditText input = findViewById(R.id.etName);
            TextView output = findViewById(R.id.tvOutput);
            if(id == R.id.btClick){
                String inputStr = input.getText().toString();
                output.setText(inputStr + "さん、こんにちは！");}
            else if (id == R.id.btClear) {
                input.setText("");
                output.setText("");

            }


        }
    }
}