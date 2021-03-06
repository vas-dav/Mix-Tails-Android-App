package com.example.mix_tailsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mix_tailsapp.Database.Cocktails;
import com.example.mix_tailsapp.R;

import java.util.List;

/**
 * Created on 06/03/2021
 * author: Annie
 * an adapter for search bar
 * Reference used: https://learningprogramming.net/mobile/android/search-data-with-searchview-and-sqlite/
 */
class  SearchViewHolder extends RecyclerView.ViewHolder {

    public TextView name, spirit, taste, size, strength;

    public  SearchViewHolder(View drinkView) {
        super (drinkView);
        name = (TextView) drinkView.findViewById(R.id.name);
        spirit = (TextView) drinkView.findViewById(R.id.spirit);
        taste = (TextView) drinkView.findViewById(R.id.taste);
        size = (TextView) drinkView.findViewById(R.id.size);
        strength = (TextView) drinkView.findViewById(R.id.strength);
    }
}
public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<Cocktails> cocktails;

    public SearchAdapter(Context context, List<Cocktails> cocktails) {
        this.context = context;
        this.cocktails = cocktails;
    }


    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View drinkView = inflater.inflate(R.layout.activity_drink_item, parent, false);
        return new SearchViewHolder(drinkView);
    }



    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

        holder.name.setText(cocktails.get(position).getName());
        holder.spirit.setText(cocktails.get(position).getSpirit());
        holder.taste.setText(cocktails.get(position).getTaste());
        holder.size.setText(cocktails.get(position).getSize());
        holder.strength.setText(cocktails.get(position).getStrength());

    }

    /**
     * getItemCount method
     * @return cocktails.size()
     */
    @Override
    public int getItemCount() {
        return cocktails.size();
    }

}
