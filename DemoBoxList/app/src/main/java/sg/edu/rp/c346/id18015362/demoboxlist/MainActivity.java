package sg.edu.rp.c346.id18015362.demoboxlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvBox;
    ArrayList<Box> alBoxList;
    CustomAdapter caBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvBox = findViewById(R.id.listViewBox);
        alBoxList = new ArrayList<>();
        Box item1 = new Box("blue");
        Box item2 = new Box("orange");
        Box item3 = new Box("brown");

        alBoxList.add(item1);
        alBoxList.add(item2);
        alBoxList.add(item3);

        caBox = new CustomAdapter(this, R.layout.row, alBoxList);
        lvBox.setAdapter(caBox);
    }
}
