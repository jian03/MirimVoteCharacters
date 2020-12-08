package kr.hs.emirim.s2019s19.mirimvotecharacters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridAdapter extends BaseAdapter {
    Context context;
    int[] imgFile = {R.drawable.r01, R.drawable.r02, R.drawable.r03, R.drawable.r04, R.drawable.r05, R.drawable.r06, R.drawable.r07, R.drawable.r08, R.drawable.r09};
    String[] imgNames = {"노란 머리 여자아이", "미녀와 야수 벨", "인어공주 에리얼", "오로라 공주", "엘사 여왕", "백설공주", "올블랙 여자아이", "핑크 머리 여자아이", "흰 티를 입은 여자아이"};
    int[] voteCount = new int[imgNames.length];

    public GridAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgFile.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new GridView.LayoutParams(300, 400));
        imgv.setAdjustViewBounds(true);
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgv.setPadding(10, 20, 10, 10);
        imgv.setImageResource(imgFile[position]);
        for (int i=0; i< voteCount.length; i++){
            voteCount[i] = 0;
        }
        final int pos = position;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voteCount[pos]++;
                Toast.makeText(context, imgNames[pos] + ": 총 " + voteCount[pos] + "표", Toast.LENGTH_SHORT).show();
            }
        });
        return imgv;
    }
}
