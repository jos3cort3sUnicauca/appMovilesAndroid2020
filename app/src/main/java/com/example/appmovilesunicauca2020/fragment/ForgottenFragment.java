package com.example.appmovilesunicauca2020.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appmovilesunicauca2020.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForgottenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForgottenFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText etMailUser;
    private TextView tvPassUser;
    private Button btnRememberForgotten;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForgottenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForgottenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForgottenFragment newInstance(String param1, String param2) {
        ForgottenFragment fragment = new ForgottenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgotten, container, false);
        addId(view);
        btnRememberForgotten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnEventInterface.onEventFragForgot(R.id.btnRememberForgotten, etMailUser.getText().toString());
            }
        });
        return view;
    }

    private void addId(View view){
        etMailUser = view.findViewById(R.id.etMailForgotten);
        tvPassUser = view.findViewById(R.id.tvPassForgotten);
        btnRememberForgotten = view.findViewById(R.id.btnRememberForgotten);
    }

    public interface OnEventInterfaceFragForgot {
        void onEventFragForgot(int id, String valueMailEt);
    }
    OnEventInterfaceFragForgot myOnEventInterface;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            myOnEventInterface = (OnEventInterfaceFragForgot)context;
        } catch (ClassCastException e){
            Log.e("ErrorFrag", "Error! Fragment Forgotten");
        }
    }
}