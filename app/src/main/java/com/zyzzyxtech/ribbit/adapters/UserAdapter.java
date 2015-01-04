package com.zyzzyxtech.ribbit.adapters;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseUser;
import com.zyzzyxtech.ribbit.R;
import com.zyzzyxtech.ribbit.utils.ParseConstants;

import java.util.Date;
import java.util.List;

/**
 * Created by Ken on 1/1/2015.
 */
public class UserAdapter extends ArrayAdapter<ParseUser> {

    protected Context mContext;
    protected List<ParseUser> mUsers;

    public UserAdapter(Context context, List<ParseUser> users) {
        super(context, R.layout.message_item, users);
        mContext = context;
        mUsers = users;
    }

    
//    Important to make the getView efficient for speed and performance of the listView
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.user_item, null);
            holder = new ViewHolder();
           // holder.iconImageView = (ImageView) convertView.findViewById(R.id.messageIcon);
            holder.nameLabel = (TextView) convertView.findViewById(R.id.nameLabel);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }
        
        ParseUser user = mUsers.get(position);
        
//        if (user.getString(ParseConstants.KEY_FILE_TYPE).equals(ParseConstants.TYPE_IMAGE)) {
//            holder.iconImageView.setImageResource(R.drawable.ic_picture);
//        }
//        else {
//            holder.iconImageView.setImageResource(R.drawable.ic_video);
//        }
        holder.nameLabel.setText(user.getUsername());
        return convertView;
    }
    
    private static class ViewHolder {
        // ImageView iconImageView;
        TextView nameLabel;
    }
    
    public void refill(List<ParseUser> users) {
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }
    
}
