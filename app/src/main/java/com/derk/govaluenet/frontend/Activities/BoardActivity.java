package com.derk.govaluenet.frontend.Activities;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.derk.govaluenet.Controller.GridHandler;
import com.derk.govaluenet.R;
import com.derk.govaluenet.frontend.Views.GridView;

public class BoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);


        final RelativeLayout layout = findViewById(R.id.layout_board);

        View.OnClickListener click = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("he", "he");

                GridView grid = findViewById(R.id.grid);
                GridHandler handler = grid.getGridHandler();

                int x = handler.getXCoordinate(1);
                int y = handler.getYCoordinate(1);

                ImageView iv = new ImageView(getApplicationContext());
                iv.setImageResource(R.drawable.black0);

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(50, 50);
                params.leftMargin = x;
                params.topMargin = y;

                iv.setLayoutParams(params);

                layout.addView(iv);
            }
        };

        layout.setOnClickListener(click);
    }

}
