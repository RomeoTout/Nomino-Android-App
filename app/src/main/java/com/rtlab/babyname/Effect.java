package com.rtlab.babyname;

import android.view.MotionEvent;
import android.view.View;

public class Effect {

    //button effect that reduces the button in size to give the impression of pushing it
    public static void buttonEffect(final View button){

        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        button.setScaleX(0.97f);
                        button.setScaleY(0.97f);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        button.setScaleX(1f);
                        button.setScaleY(1f);
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }
}
