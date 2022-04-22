package com.tolgacobanoglu.admincentralcarpolicy.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tolgacobanoglu.admincentralcarpolicy.databinding.ListTransactionBinding;
import com.tolgacobanoglu.admincentralcarpolicy.model.Transaction;

import java.util.List;

public class TransactionRecyclerAdapter extends RecyclerView.Adapter<TransactionRecyclerAdapter.TransactionHolder>
{

    private List<Transaction> transactionList;

    public TransactionRecyclerAdapter(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @NonNull
    @Override
    public TransactionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        ListTransactionBinding listTransactionBinding = ListTransactionBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new TransactionHolder(listTransactionBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionHolder holder, int position) {
        holder.listTransactionBinding.dateView.setText(transactionList.get(position).getTime().toDate().toString());
        String content = transactionList.get(position).getTransactionContent().substring(0,5);
        if (content.equals("Admin"))
        {
            String newContent = transactionList.get(position).getTransactionContent().substring(6);
            holder.listTransactionBinding.contentView.setText(newContent);
        }
        else
        {
            holder.listTransactionBinding.contentView.setText(transactionList.get(position).getTransactionContent());
        }

        holder.listTransactionBinding.titleView.setText(transactionList.get(position).getTransactionTitle());
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    class TransactionHolder extends RecyclerView.ViewHolder {
        ListTransactionBinding listTransactionBinding;

        public TransactionHolder(@NonNull ListTransactionBinding listTransactionBinding) {
            super(listTransactionBinding.getRoot());
            this.listTransactionBinding = listTransactionBinding;
        }
    }

}