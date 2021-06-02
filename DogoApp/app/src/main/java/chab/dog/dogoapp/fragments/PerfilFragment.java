package chab.dog.dogoapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import chab.dog.dogoapp.R;
import chab.dog.dogoapp.activities.HomeActivity;
import chab.dog.dogoapp.activities.LoginActivity;
import chab.dog.dogoapp.activities.RegisterActivity;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button cerrar;
    private TextView email,password;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
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
        SharedPreferences preferences = getActivity().getSharedPreferences("sesion", Context.MODE_PRIVATE);

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        cerrar = v.findViewById(R.id.btnClose);
        email = v.findViewById(R.id.lblEmail);
        password = v.findViewById(R.id.lblPassword);
        email.setText(preferences.getString("email",""));
        password.setText(preferences.getString("password",""));
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("sesion",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.remove("email");
                editor.remove("password");
                editor.commit();
                goToLogin();
            }
        });
        return v;
    }

    private void goToLogin(){
        Intent i = new Intent(getActivity(), LoginActivity.class);
        startActivity(i);
    }
}
