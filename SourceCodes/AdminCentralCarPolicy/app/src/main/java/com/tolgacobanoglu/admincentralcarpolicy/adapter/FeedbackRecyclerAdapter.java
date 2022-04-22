package com.tolgacobanoglu.admincentralcarpolicy.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tolgacobanoglu.admincentralcarpolicy.databinding.ListFeedbackBinding;
import com.tolgacobanoglu.admincentralcarpolicy.model.Feedback;

import java.util.List;

public class FeedbackRecyclerAdapter extends RecyclerView.Adapter<FeedbackRecyclerAdapter.FeedbackHolder>
{

    private List<Feedback> feedbackList;

    public FeedbackRecyclerAdapter(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }


    @NonNull
    @Override
    public FeedbackRecyclerAdapter.FeedbackHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListFeedbackBinding listFeedbackBinding = ListFeedbackBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new FeedbackHolder(listFeedbackBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackHolder holder, int position) {
        holder.listFeedbackBinding.dateView.setText(feedbackList.get(position).getTime().toDate().toString());
        holder.listFeedbackBinding.emailView.setText(feedbackList.get(position).getEmail());
        holder.listFeedbackBinding.contentView.setText(feedbackList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return feedbackList.size();
    }

    class FeedbackHolder extends RecyclerView.ViewHolder {
        ListFeedbackBinding listFeedbackBinding;

        public FeedbackHolder(@NonNull ListFeedbackBinding listFeedbackBinding) {
            super(listFeedbackBinding.getRoot());
            this.listFeedbackBinding = listFeedbackBinding;
        }
    }
}