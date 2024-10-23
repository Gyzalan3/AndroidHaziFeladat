package com.example.mylista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private String[] penznem;
    private String[] vasarlas;
    private String[] eladas;
    private int[] zaszlok;

    public CustomAdapter(Context context, int[] zaszlok, String[] eladas, String[] vasarlas, String[] penznem)
    {
        this.context = context;
        this.zaszlok = zaszlok;
        this.eladas = eladas;
        this.vasarlas = vasarlas;
        this.penznem = penznem;
    }

    @Override
    public int getCount() {
        return penznem.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView zaszlokImage = convertView.findViewById(R.id.zaszloID);
        TextView penznemText = convertView.findViewById(R.id.penznemID);
        TextView penznemNevText = convertView.findViewById(R.id.penznemNevID);
        TextView buyRateText = convertView.findViewById(R.id.vasarlasID);
        TextView sellRateText= convertView.findViewById(R.id.eladasID);

        zaszlokImage.setImageResource(zaszlok[position]);
        penznemText.setText(penznem[position]);
        penznemNevText.setText(getFullCurrencyName(position));
        buyRateText.setText(vasarlas[position] + " RON");
        sellRateText.setText(eladas[position] + " RON");

        return convertView;
    }

    private String getFullCurrencyName(int position) {
        String[] fullCurrencyNames = {"Euro", "Dolar american", "Lira sterlina", "Dolar australian",
                "Dolar canadian", "Franc elvetian", "Coroana daneza", "Forint maghiar"};
        return fullCurrencyNames[position];
    }
}
