package com.example.consultants.fragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements OnSendMsgListener {

    //private FragmentManager fragmentManager;
    private BlankFragment blankFragment;
    private FragmentTwo fragmentTwo;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blankFragment = new BlankFragment();
        transaction = getSupportFragmentManager().beginTransaction().add(R.id.container1, blankFragment);
        transaction.commit();

        fragmentTwo = new FragmentTwo();
        transaction = getSupportFragmentManager().beginTransaction().add(R.id.container2, fragmentTwo);
        transaction.commit();
    }

    @Override
    public void onSendMsg(String msg) {
        fragmentTwo.setMessage(msg);
    }

    @Override
    public void onSendMsg2(String msg) {
        blankFragment.setMessage(msg);
    }
}
