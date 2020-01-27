package com.example.theaterofwar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListHeroesAdapter extends RecyclerView.Adapter<ListHeroesAdapter.ListHeroesViewHolder> {

    private Context parent;
    private int numberOfHeroes;
    private ArrayList<String> listHeroes/* = new ArrayList<>()*/;
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    public ListHeroesAdapter(Context parent, ArrayList<String> listHeroes) {
        this.parent = parent;
        this.listHeroes = listHeroes;
    }

    @NonNull
    @Override
    public ListHeroesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIDForItem = R.layout.list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutIDForItem, parent, false);
        ListHeroesViewHolder viewHolder = new ListHeroesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListHeroesViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listHeroes.size();
    }

    class ListHeroesViewHolder extends RecyclerView.ViewHolder {
        TextView hero;

        public ListHeroesViewHolder(@NonNull View itemView) {
            super(itemView);
            hero = itemView.findViewById(R.id.tv_hero);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = hero.getText().toString();
                    Intent heroPickActivityIntent = new Intent(parent, HeroPickActivity.class);
                    heroPickActivityIntent.putExtra(Intent.EXTRA_TEXT, name);
                    ((Activity)parent).startActivityForResult(heroPickActivityIntent, SECOND_ACTIVITY_REQUEST_CODE);

                    //parent.startActivity(heroPickActivityIntent);
                }

            });
        }

        void bind(int listIndex) {
            hero.setText(listHeroes.get(listIndex)); //ArrayList<Hero> heroes; setText(heroes.get(index).toString());
        }
    }
}
