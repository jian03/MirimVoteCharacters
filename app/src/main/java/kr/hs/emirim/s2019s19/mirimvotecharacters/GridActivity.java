package kr.hs.emirim.s2019s19.mirimvotecharacters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class GridActivity extends AppCompatActivity {
    GridAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        GridView grid1 = findViewById(R.id.grid1);
        adapter = new GridAdapter(this);
        grid1.setAdapter(adapter);

        Button btnDone2 = findViewById(R.id.btn_done2);
        btnDone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("voteCount", adapter.voteCount);
                intent.putExtra("imgNames", adapter.imgNames);
                startActivity(intent);
            }
        });
    }
}
