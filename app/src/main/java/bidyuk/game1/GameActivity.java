package bidyuk.game1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends Activity {

    int active_player = 0;
    int array[]={2,2,2,2,2,2,2,2,2};
    boolean gameOn = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void dropIn(View view) {
        ImageView img_view = (ImageView)view;
        int tag = Integer.parseInt(img_view.getTag().toString());
        int winningPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        if(array[tag]==2 && gameOn) {
            img_view.setTranslationY(-1000f);
            array[tag]=active_player;
            if(active_player==0) {
                img_view.setImageResource(R.drawable.circle_orange);
                active_player = 1;
            } else {
                img_view.setImageResource(R.drawable.circle_purp);
                active_player = 0;
            }
            img_view.animate().translationYBy(1000f).rotation(360).setDuration(500);
        }
        for(int winingpositiot[] : winningPositions) {
            if(array[winingpositiot[0]]==array[winingpositiot[1]] &&
                    array[winingpositiot[1]]==array[winingpositiot[2]]&&
                    array[winingpositiot[0]]!=2) {
                String winner = "Earth won!";
                gameOn = false;
                if(array[winingpositiot[0]]==0)
                    winner = "Mars won!";
                LinearLayout linearLayout1 = (LinearLayout)findViewById(R.id.massage_layout);
                linearLayout1.setBackgroundResource(R.drawable.win);
                linearLayout1.setVisibility(View.VISIBLE);
                TextView text = (TextView)findViewById(R.id.massage_tv);
                text.setTextColor(Color.WHITE);
                text.setText(winner);
            }else {
                boolean gameIsOver = true;

                for(int gameState : array)
                    if(gameState == 2) gameIsOver = false;
                if (gameIsOver) {
                    TextView textView = (TextView)findViewById(R.id.massage_tv);
                    textView.setText("Draw!");
                    textView.setTextColor(Color.parseColor("#ff4502"));
                    LinearLayout linearLayout = (LinearLayout)findViewById(R.id.massage_layout);
                    linearLayout.setBackgroundResource(R.drawable.myr);
                    linearLayout.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    //Обробник для рестарту
    public void playAgain(View view) {
        active_player = 0;
        for(int i=0;i<array.length;i++) {
            array[i] = 2;
        }
        GridLayout gridLayout =(GridLayout) findViewById(R.id.grid_layout);
        for(int i=0;i<gridLayout.getChildCount();i++) {
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }
        ((LinearLayout)findViewById(R.id.massage_layout)).setVisibility(View.INVISIBLE);
        gameOn = true;
    }
}
