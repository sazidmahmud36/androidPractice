package com.example.spinnerwithonitemselectedlistener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int[] flag;
    String[] countryNames,population;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int[] flag, String[] countryNames, String[] population) {
        this.context = context;
        this.flag = flag;
        this.countryNames = countryNames;
        this.population = population;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.sample_view, null, false);

        }

        ImageView imageView = view.findViewById(R.id.imageViewId);
        imageView.setImageResource(flag[i]);

        TextView country = view.findViewById(R.id.countryNameId);
        country.setText(countryNames[i]);

        TextView pop = view.findViewById(R.id.populationId);
        pop.setText(population[i]);




        return view;
    }
}
