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
import android.widget.Toast;

import com.example.appmovilesunicauca2020.R;
import com.example.appmovilesunicauca2020.model.RegisterUserModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText etNameRegister, etMailRegister, etPhoneRegister, etPassRegiser,
    etPassRegiserTwo;
    private Button btnRegister;
    private RegisterUserModel userModel;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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
        View viewRegister = inflater.inflate(R.layout.fragment_register, container, false);
        addId(viewRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(etNameRegister.getText().toString().equals("") || etMailRegister.getText().toString().equals("")
                        || etPhoneRegister.getText().toString().equals("") || etPassRegiser.getText().toString().equals(""))){
                if(etPassRegiser.getText().toString().equals(etPassRegiserTwo.getText().toString())){
                userModel = new RegisterUserModel(0, etNameRegister.getText().toString(),
                                                         etMailRegister.getText().toString(),
                                                         etPhoneRegister.getText().toString(),
                                                         etPassRegiser.getText().toString());
                mClickEventInterface.onEventFragRegister(R.id.btnRegisterRegister, userModel);
                etNameRegister.setText("");etMailRegister.setText("");etPhoneRegister.setText("");etPassRegiser.setText("");etPassRegiserTwo.setText("");}
                else{
                    Toast.makeText(getContext(), "Error¡ Passwords aren't same", Toast.LENGTH_LONG).show();
                }}
                else{
                    Toast.makeText(getContext(), "Error¡ empty fields", Toast.LENGTH_LONG).show();
                }
            }
        });
        return viewRegister;
    }

    private void addId(View view){
        etNameRegister = view.findViewById(R.id.etNameRegister);
        etMailRegister = view.findViewById(R.id.etEmailRegister);
        etPhoneRegister = view.findViewById(R.id.etPhoneRegister);
        etPassRegiser = view.findViewById(R.id.etPassRegister);
        etPassRegiserTwo = view.findViewById(R.id.etPassRegisterTwo);
        btnRegister = view.findViewById(R.id.btnRegisterRegister);
    }

    public interface OnEventInterfaceFragRegister {
        void onEventFragRegister(int id, RegisterUserModel userModel);
    }
    OnEventInterfaceFragRegister mClickEventInterface;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mClickEventInterface = (OnEventInterfaceFragRegister) context;
        }catch (ClassCastException e){
            Log.e("Error Fragment", "Error on MClickEventListener");
        }
    }
}