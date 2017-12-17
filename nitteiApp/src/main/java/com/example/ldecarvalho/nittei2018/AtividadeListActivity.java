package com.example.ldecarvalho.nittei2018;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.ldecarvalho.nittei2018.provider.ActivityContent;
import com.example.ldecarvalho.nittei2018.provider.ActivityContent.ActivityItem;

import java.util.ArrayList;
import java.util.List;

/**
 * An activity representing a list of Atividades. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link AtividadeDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class AtividadeListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        final SearchView searchView = (SearchView)findViewById(R.id.filterActivities);
        searchView.setOnQueryTextListener(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Under construction", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (findViewById(R.id.atividade_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.atividade_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, new ActivityContent(getBaseContext()).ITEMS, mTwoPane));
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String query) {
        List<ActivityItem> items = filter( ActivityContent.ITEMS, query);

        RecyclerView recyclerView = findViewById(R.id.atividade_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, items, mTwoPane));

        return true;
    }

    private List<ActivityItem> filter(List<ActivityItem> items, String query) {
        final String lowerCaseQuery = query.toLowerCase();

        final List<ActivityItem> filteredDummyItemList = new ArrayList<>();
        for (ActivityItem item : items) {
            final String text = item.getContent().toLowerCase();
            final String date = String.valueOf(item.getId());
            final String detail = String.valueOf(item.getDetails());
            if (text.contains(lowerCaseQuery) || date.contains(lowerCaseQuery) || detail.contains(lowerCaseQuery)) {
                filteredDummyItemList.add(item);
            }
        }
        return filteredDummyItemList;
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final AtividadeListActivity mParentActivity;
        private final List<ActivityItem> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityItem item = (ActivityItem) view.getTag();
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(AtividadeDetailFragment.ARG_ITEM_ID, item.id);
                    AtividadeDetailFragment fragment = new AtividadeDetailFragment();
                    fragment.setArguments(arguments);
                    mParentActivity.getSupportFragmentManager().beginTransaction()
                            .replace(R.id.atividade_detail_container, fragment)
                            .commit();
                } else {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, AtividadeDetailActivity.class);
                    intent.putExtra(AtividadeDetailFragment.ARG_ITEM_ID, item.id);
                    context.startActivity(intent);
                }
            }
        };

        SimpleItemRecyclerViewAdapter(AtividadeListActivity parent,
                                      List<ActivityItem> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.atividade_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).content);

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
            if(position %2 == 1)
            {
                holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
            else
            {
                holder.itemView.setBackgroundColor(Color.parseColor("#FFFAF8FD"));
                //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFAF8FD"));
            }


            if (mValues.get(position).getId().equals("10-01-2018")){
                holder.itemView.setBackgroundColor(Color.parseColor("#FF80AB"));
//                holder.itemView.notify();
               // notifyItemChanged(position);
            }

            if (mValues.get(position).getContent().contains("semana")){
                holder.itemView.setBackgroundColor(Color.parseColor("#BA68C8"));
            }

            if (mValues.get(position).getContent().contains("Recesso")){
                holder.itemView.setBackgroundColor(Color.parseColor("#FFCC0000"));
            }

            if (mValues.get(position).getContent().contains("Feriado")){
                holder.itemView.setBackgroundColor(Color.parseColor("#FFCC0000"));
            }
            if (mValues.get(position).getContent().contains("Convenção")){
                holder.itemView.setBackgroundColor(Color.parseColor("#FDD835"));
            }

            if (mValues.get(position).getContent().contains("SUCESSOR")){
                holder.itemView.setBackgroundColor(Color.parseColor("#FF99CC00"));
            }
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mIdView;
            final TextView mContentView;

            ViewHolder(View view) {
                super(view);
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }


    }
}
