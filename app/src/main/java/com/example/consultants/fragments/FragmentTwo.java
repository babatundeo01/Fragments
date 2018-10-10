package com.example.consultants.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment implements View.OnClickListener{

    private Button sendBTN;
    private TextView textView;
    private EditText editText;

    OnSendMsgListener msgListen;

    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            msgListen = (OnSendMsgListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnSendMsgListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView =  inflater.inflate(R.layout.fragment_fragment_two, container, false);
        textView = itemView.findViewById(R.id.textView);
        editText = itemView.findViewById(R.id.editText);
        sendBTN = itemView.findViewById(R.id.sendBTN);
        sendBTN.setOnClickListener(this);
        return itemView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sendBTN:
                String msg = editText.getText().toString();
                msgListen.onSendMsg2(msg);
                editText.setText("");
                break;
        }
    }

    public void setMessage(String str){
        if (str != null) {
            textView.setText(str);
        }else {
            textView.setText("empty");
       }
    }
}
