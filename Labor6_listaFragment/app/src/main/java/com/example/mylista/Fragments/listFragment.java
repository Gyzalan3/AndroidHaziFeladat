package com.example.mylista.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mylista.Adapter.CustomAdapter;
import com.example.mylista.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class listFragment extends Fragment {
    String[] penznemList = {"EUR", "USD", "GBP", "AUD", "CAD", "CHF", "DKK", "HUF"};
    String[] vasarlasList = {"4.4100", "3.9750", "6.1250", "2.9600", "3.0950", "4.2300", "0.5850", "0.0136"};
    String[] eladasList = {"4.5500", "4.1450", "6.3550", "3.0600", "3.2650", "4.3300", "0.6150", "0.0146"};
    int[] zaszlokList = {R.drawable.eur, R.drawable.usd, R.drawable.gbp,
            R.drawable.aud, R.drawable.cad, R.drawable.chf, R.drawable.dkk, R.drawable.huf};


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public listFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static listFragment newInstance(String param1, String param2) {
        listFragment fragment = new listFragment();
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
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        ListView listView = view.findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter(getContext(), zaszlokList, eladasList, vasarlasList, penznemList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {

            oldalFragment Fragment2 = new oldalFragment();
            Bundle args = new Bundle();
            args.putString("selected_currency", penznemList[position]);
            Fragment2.setArguments(args);

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.listFragment1, Fragment2);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        return view;
    }

}