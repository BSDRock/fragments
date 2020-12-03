package ru.smak.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    private Fragment f;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm=getFragmentManager();//SupportFM
        Fragment fragment=fm.findFragmentById(R.id.fragment2);
        if (fragment==null){
            fragment=new Fragment2();
            f = fragment;
            fm.beginTransaction()
                    .add(R.id.fragment2, fragment)
                    .commit();

        }
        b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Fragment2)f).showToast("Some message");
            }
        });
        ((Fragment2)f).setOnSomeListener(new SomeListener() {
            @Override
            public void OnClick() {
                hide();
            }
        });
    }

    public void hide(){
        b.setVisibility(GONE);
    }
}
