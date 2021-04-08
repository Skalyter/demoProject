package com.example.demoproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoproject.R;
import com.example.demoproject.models.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private Context context;
    private List<Comment> comments;

    public CommentAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = comments.get(position);

        holder.postId.setText(comment.getPostId() + "");
        holder.messageId.setText(comment.getId() + "");
        holder.name.setText(comment.getName());
        holder.email.setText(comment.getEmail());
        holder.body.setText(comment.getText());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    static class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView postId, messageId, name, email, body;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            postId = itemView.findViewById(R.id.post_id_value);
            messageId = itemView.findViewById(R.id.message_id_value);
            name = itemView.findViewById(R.id.name_value);
            email = itemView.findViewById(R.id.email_value);
            body = itemView.findViewById(R.id.text_value);
        }
    }
}
