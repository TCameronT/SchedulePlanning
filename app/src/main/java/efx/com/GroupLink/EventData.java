package efx.com.GroupLink;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class EventData extends AppCompatActivity {

    private String title, description, date, start, end;
    private EditText[] input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_data);
        Toolbar topToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        input = new EditText[]{
                findViewById(R.id.eventTitle),
                findViewById(R.id.fragDesc),
                findViewById(R.id.eventDate),
                findViewById(R.id.eventStart),
                findViewById(R.id.eventEnd)
        };

    }

    String assignStringData(int pos){
        String inputString = input[pos].getText().toString();
        Log.i("Value:",inputString);
        return inputString;
    }

    public void saveData(View v){
        title = assignStringData(0);
        description= assignStringData(1);
        date = assignStringData(2);
        start = assignStringData(3);
        end = assignStringData(4);

        Intent intent = new Intent(EventData.this, MainScreenActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        intent.putExtra("date", date);
        intent.putExtra("start", start);
        intent.putExtra("end", end);
        setResult(123, intent);
        finish();
    }
}
