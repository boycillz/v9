package com.azismihsan.testskripsi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.MyHolder> {

    Context context;
    List<ModelUsers> usersList;

    public AdapterUsers(Context context, List<ModelUsers> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //inflate layout(row_users.xml)
        View view = LayoutInflater.from(context).inflate(R.layout.row_users, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //get data
        String userImage = usersList.get(position).getImage();
        final String userEmail = usersList.get(position).getEmail();
        String userName = usersList.get(position).getName();
        String userJob = usersList.get(position).getJob();

        //set data
        holder.mEmailTv.setText(userEmail);
        holder.mJobTv.setText(userJob);
        holder.mNameTv.setText(userName);
        try {
            Picasso.get().load(userImage)
                    .placeholder(R.drawable.ic_default_face_custom)
                    .into(holder.mAvatarIv);
        }catch (Exception e){

        }

        //handle item click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+userEmail, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView mAvatarIv;
        TextView mNameTv, mEmailTv, mJobTv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            //init views
            mAvatarIv = itemView.findViewById(R.id.avatar_Profile_User);
            mNameTv = itemView.findViewById(R.id.name_Tv_User);
            mJobTv = itemView.findViewById(R.id.name_Job_User);
            mEmailTv = itemView.findViewById(R.id.name_Email_User);
        }
    }
}
