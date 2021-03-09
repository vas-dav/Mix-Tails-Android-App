package com.example.mix_tailsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mix_tailsapp.Database.Cocktails;
import com.example.mix_tailsapp.R;

import java.util.List;

/**
 * Created on 06/03/2021
 * author: Annie, Miguel
 *
 * This search bar allows you to search drinks by name in our small database
 * of classic cocktails. give it a try you might find something you like.
 *
 * Reference used: https://learningprogramming.net/mobile/android/search-data-with-searchview-and-sqlite/
 */
class  SearchViewHolder extends RecyclerView.ViewHolder {

    public TextView name, ingredients;

    public  SearchViewHolder(View drinkView) {
        super (drinkView);
        name = (TextView) drinkView.findViewById(R.id.name);
        ingredients = (TextView)drinkView.findViewById(R.id.ingredients);
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
        View drinkView = inflater.inflate(R.layout.activity_drink_item_search_bar, parent, false);
        return new SearchViewHolder(drinkView);
    }



    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {

        holder.name.setText(cocktails.get(position).getName());
        holder.ingredients.setText(cocktails.get(position).getIngredients());

    }

    /**
     * getItemCount method
     * @return cocktails.ingredients()
     */

    @Override
    public int getItemCount() {
        return cocktails.size();
    }

}
