package com.futureproteam.reader.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.futureproteam.reader.R;
import com.futureproteam.reader.modle.BookBo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ding-syi on 2017/10/8.
 */

public class BookcaseAdapter extends RecyclerView.Adapter<BookcaseAdapter.ViewHolder> {
    private ItemClickListener mClickListener;

    private List<BookBo> data;

    public BookcaseAdapter(){
        data = new ArrayList<>();
    }

    /**
     * 填充数据
     * @param data
     */
    public void setData(List<BookBo> data){
        this.data.clear();
        if (data != null){
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }
    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BookBo book = data.get(position);
        holder.tevBookTitle.setText(book.getTitle());
    }


    // total number of cells
    @Override
    public int getItemCount() {
        return data.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tev_book_title) TextView tevBookTitle;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    BookBo getItem(int id) {
        return data.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
