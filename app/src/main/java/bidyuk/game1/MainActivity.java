package bidyuk.game1;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import bidyuk.game1.Fragments.StartFragment;


public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showStartFragment();
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .commit();
    }

    public void showGame() {
        startActivity(new Intent(getApplicationContext(),GameActivity.class));
    }
    public void showStartFragment() {
        replaceFragment(new StartFragment());
    }
}
