package kr.hs.emirim.s2019s19.mirimvotecharacters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgNames = {"노란 머리 여자아이", "미녀와 야수 벨", "인어공주 에리얼", "오로라 공주", "엘사 여왕", "백설공주", "올블랙 여자아이", "핑크 머리 여자아이", "흰 티를 입은 여자아이"};
    int[] voteCount = new int[imgNames.length];
    ImageView[] imgVs = new ImageView[imgNames.length];
    int[] imgVIds = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9};
//    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("여자 캐릭터 투표");

        for (int i=0; i< voteCount.length; i++){
            voteCount[i] = 0;
        }

        for (int i=0; i < imgVIds.length; i++){
            final int index;
            index = i;
            imgVs[index] = findViewById(imgVIds[index]);
            imgVs[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgNames[index] + ": 총 " + voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Button btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("voteCount", voteCount);
            intent.putExtra("imgNames", imgNames);
            startActivity(intent);
        }
    };

}
