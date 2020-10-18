package com.example.appmovilesunicauca2020.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.appmovilesunicauca2020.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText etMailLogin, etPasswordLogin;
    private Switch btnRememberLogin;
    private Button btnForgottenPassLogin, btnLogin, btnRegister;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        View viewLogin  = inflater.inflate(R.layout.fragment_login, container, false);
        addId(viewLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String [] valuesEditText = {etMailLogin.getText().toString(), etPasswordLogin.getText().toString()};
                    interfaceListener.onEventButtons(R.id.btn_login, valuesEditText, btnRememberLogin.isChecked());
                }
            });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceListener.onEventButtons(R.id.btn_register);
            }
        });


        return viewLogin;
    }

    public void addId(View view){
        etMailLogin = view.findViewById(R.id.et_mail_login);
        etPasswordLogin = view.findViewById(R.id.et_pass_login);
        btnRememberLogin = view.findViewById(R.id.btn_remember_login);
        btnForgottenPassLogin = view.findViewById(R.id.btn_forgotten_login);
        btnLogin = view.findViewById(R.id.btn_login);
        btnRegister = view.findViewById(R.id.btn_register);
    }




    public interface MyOnEventListener{
        void onEventButtons(int idButton);
        void onEventButtons(int idButton, String [] valuesEditTex, boolean checkedRemember);
    }
    MyOnEventListener interfaceListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            interfaceListener = (MyOnEventListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnEventClickListener");
        }
    }
}