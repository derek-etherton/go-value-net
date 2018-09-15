package com.derk.govaluenet.frontend.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.derk.govaluenet.Controller.GridHandler;
import com.derk.govaluenet.R;
import com.derk.govaluenet.frontend.Views.SquareGridView;

public class BoardActivity extends AppCompatActivity {
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);


        final RelativeLayout layout = findViewById(R.id.layout_board);

        View.OnClickListener click = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SquareGridView grid = findViewById(R.id.grid);
                GridHandler handler = grid.getGridHandler();

                int x = handler.getGridline(count);
                int y = handler.getGridline(count);

                if (count < 19) {
                    count++;
                }
                int size = handler.getStoneSize();

                ImageView iv = new ImageView(getApplicationContext());
                iv.setImageResource(R.drawable.black0);

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(size, size);
                params.leftMargin = x;
                params.topMargin = y;

                iv.setLayoutParams(params);

                layout.addView(iv);
            }
        };

        layout.setOnClickListener(click);
    }

}
