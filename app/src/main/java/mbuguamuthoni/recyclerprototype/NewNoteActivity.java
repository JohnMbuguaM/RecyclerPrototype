package mbuguamuthoni.recyclerprototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ServerTimestamp;
import java.util.Date;
import java.util.HashMap;

public class NewNoteActivity extends AppCompatActivity {
    private EditText edNo_plate, edNick_name;
    Button button_save, button_cancel;
    private @ServerTimestamp Date timestamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

//        edNumber = findViewById(R.id.edit_text_number);
        edNo_plate = findViewById(R.id.edit_text_plateNO);
        edNick_name = findViewById(R.id.edit_text_NIck_name);
//        edTime = findViewById(R.id.edit_text_time);

        button_cancel = findViewById(R.id.button_cancel);
        button_save = findViewById(R.id.button_save);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNotes();
            }
        });
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });





    }

    private void saveNotes() {
//        int number = Integer.parseInt(edNumber.getText().toString());
        String no_plate = edNo_plate.getText().toString();
        String nickName = edNick_name.getText().toString();
//        String time = edTime.getText().toString();

        if (no_plate.trim().isEmpty() || nickName.trim().isEmpty() ) {
            Toast.makeText(this, "Please insert the number plate and the nick name", Toast.LENGTH_SHORT).show();
            return;
        }

        CollectionReference TuktukRef = FirebaseFirestore.getInstance().collection("TuktukData");

        TuktukRef.add(new Note(nickName, no_plate,timestamp));

        Toast.makeText(this, "The Tuktuk has been added to the queue", Toast.LENGTH_SHORT).show();
        finish();



    }


}
