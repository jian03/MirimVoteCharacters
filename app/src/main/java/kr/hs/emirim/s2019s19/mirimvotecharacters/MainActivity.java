package kr.hs.emirim.s2019s19.mirimvotecharacters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgNames = {"노란 머리 여자아이", "미녀와 야수 벨", "인어공주 에리얼", "오로라 공주", "엘사 여왕", "백설공주", "올블랙 여자아이", "핑크 머리 여자아이", "흰 티를 입은 여자아이"};
    int[] voteCount = new int[imgNames.length];
    ImageView[] imgVs = new ImageView[imgNames.length];
    int[] imgVIds = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6, R.id.img7, R.id.img8, R.id.img9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < voteCount.length; i++) {
            voteCount[i] = 0;
        }

        for(int i = 0; i < imgVs.length; i++) {
            final int index; //지역 변수로 내부에 선언해 줘야 익명 클래스에서도 쓸 수 있음
            index = i;
            imgVs[index] = findViewById(imgVIds[index]);
            imgVs[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgNames[index] + ": 총 " + voteCount[index] + "표", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}