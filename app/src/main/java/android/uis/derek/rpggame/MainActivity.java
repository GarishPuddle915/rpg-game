package android.uis.derek.rpggame;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private RelativeLayout relativeLayout;
    private ImageView knight;
    private LayoutInflater layoutInflater;
    private float xPos;
    private float yPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xPos = 10;
        yPos = 10;

        //CREATE A LAYOUT INFLATER
        layoutInflater = (LayoutInflater)
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // SET THE BACKGROUND OF THE IMAGEVIEW TO THE KNIGHT ANIMATION
        knight = (ImageView) layoutInflater.inflate(
                        R.layout.knight_view, null);
        knight.setBackgroundResource(R.drawable.knight_animation);

        //CREATE AN ANIMATION DRAWABLE OBJECT BASED ON THIS BACKGROUND
        AnimationDrawable knightAnimate = (AnimationDrawable)
                    knight.getBackground();
        knightAnimate.start();

        knight.setX(xPos);
        knight.setY(yPos);

    }

    public void goUp(View view) {
        yPos -= 100;
        knight.setY(yPos);
    }

    public void goDown(View view) {
        yPos += 100;
        knight.setY(yPos);
    }

    public void goLeft(View view) {
        xPos -= 100;
        knight.setY(yPos);
    }

    public void goRight(View view) {
        xPos += 100;
        knight.setY(yPos);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
