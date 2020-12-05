package kr.hs.emirim.s2019s19.mirimvotecharacters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ResultActivity extends AppCompatActivity {
    Button btnStart, btnStop;
    ViewFlipper flipper;

    int[] imgvIds = {R.id.img1,R.id.img2,R.id.img3,R.id.img4,R.id.img5,R.id.img6,R.id.img7,R.id.img8,R.id.img9};
    int[] imgResult = {R.drawable.r01, R.drawable.r02, R.drawable.r03, R.drawable.r04, R.drawable.r05, R.drawable.r06, R.drawable.r07, R.drawable.r08, R.drawable.r09};
    String[] imgNames = {"노란 머리 여자아이", "미녀와 야수 벨", "인어공주 에리얼", "오로라 공주", "엘사 여왕", "백설공주", "올블랙 여자아이", "핑크 머리 여자아이", "흰 티를 입은 여자아이"};
    ImageView[] imgvs = new ImageView[imgNames.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnStart = findViewById(R.id.btnStart); btnStop = findViewById(R.id.btnStop);
        btnStart.setOnClickListener(btnListener); btnStop.setOnClickListener(btnListener);
        flipper = findViewById(R.id.flipper);

        flipper.setFlipInterval(1000);

        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        int temp1 = 0;
        int temp2 = 0;
        for(int i = 0;i < imgResult.length-1; i++) {
            for(int j = i+1; j < imgResult.length; j++) {
                if(voteCount[i] < voteCount[j]) {
                    temp1 = voteCount[i];
                    voteCount[i] = voteCount[j];
                    voteCount[j] = temp1;

                    temp2 = imgResult[i];
                    imgResult[i] = imgResult[j];
                    imgResult[j] = temp2;
                }
            }
        }

        for(int i=0; i<imgvIds.length; i++) {
            imgvs[i] = findViewById(imgvIds[i]);
            imgvs[i].setImageResource(imgResult[i]);
        }
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnStart:
                    flipper.startFlipping();
                    break;
                case R.id.btnStop:
                    flipper.stopFlipping();
                    break;
            }
        }
    };
}