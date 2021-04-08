package com.example.demoproject.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoproject.R;
import com.example.demoproject.models.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private Context context;
    private List<Post> posts;
    private String TAG = "PostAdapter";

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = posts.get(position);
        Log.i(TAG, "onBindViewHolder: pos " + position + " bound");
        holder.title.setText(post.getTitle());
        holder.postId.setText(post.getId()+"");
        holder.userId.setText(post.getUserId()+"");
        holder.text.setText(post.getText());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {

        TextView userId, postId, title, text;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.user_id_value);
            postId = itemView.findViewById(R.id.post_id_value);
            title = itemView.findViewById(R.id.title_value);
            text = itemView.findViewById(R.id.text_value);
        }
    }
}
