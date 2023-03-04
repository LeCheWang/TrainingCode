package com.example.demosqlite;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    List<User> users;
    Context context;

    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return users==null?0: users.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewUser;
        if (convertView == null) {
            viewUser = View.inflate(parent.getContext(), R.layout.item_user, null);
        } else viewUser = convertView;
        User user = users.get(position);

        TextView tvUsername = viewUser.findViewById(R.id.tvUsername);
        TextView tvPassword = viewUser.findViewById(R.id.tvPassword);


        tvUsername.setText(user.getUsername());
        tvPassword.setText(user.getPassword());

        return viewUser;
    }
}
