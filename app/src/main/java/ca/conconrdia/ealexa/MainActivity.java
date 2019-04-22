package ca.conconrdia.ealexa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import ca.conconrdia.ealexa.ca.concordia.ealexa.encryption.EncryptionUtils;

public class MainActivity extends AppCompatActivity {

    private static final Map<Integer, String> ID_KEY_MAP = new HashMap<>();
    private EditText plainTextEditText;
    private EditText keyIdEditText;
    private Button encryptButton;
    private EditText resultEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateIdKeyMap();

        plainTextEditText = findViewById(R.id.plainTextEditText);
        keyIdEditText = findViewById(R.id.keyIdEditText);
        encryptButton = findViewById(R.id.encryptButton);
        resultEditText = findViewById(R.id.resultEditText);
        
        resultEditText.setEnabled(false);

        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(EncryptionUtils.encrypt(plainTextEditText.getText().toString(), ID_KEY_MAP.get(Integer.parseInt(keyIdEditText.getText().toString()))));
            }
        });

    }

    private static void populateIdKeyMap(){
        ID_KEY_MAP.put(1, "9264730815");
        ID_KEY_MAP.put(2, "5180374629");
        ID_KEY_MAP.put(3, "6308159264");
        ID_KEY_MAP.put(4, "6429057381");
        ID_KEY_MAP.put(5, "1234506789");
    }
}
