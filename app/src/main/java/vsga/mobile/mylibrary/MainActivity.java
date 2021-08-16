package vsga.mobile.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edit_name;
    private Button btnStore, btnGet;
    private DatabaseHelper databaseHelper;
    private TextView tvNames;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        tvNames = findViewById(R.id.tvNames);
        btnStore = findViewById(R.id.button_store);
        btnGet = findViewById(R.id.button_get);
        edit_name = findViewById(R.id.edit_name);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(edit_name.getText().toString());
                edit_name.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = databaseHelper.getAllStudentsList();
                tvNames.setText("");
                for (int i = 0; i < arrayList.size(); i++) {
                    tvNames.setText(tvNames.getText().toString() + ", " + arrayList.get(i));
                }
            }
        });
    }
}