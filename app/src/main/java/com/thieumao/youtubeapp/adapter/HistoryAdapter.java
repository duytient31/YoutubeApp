package com.thieumao.youtubeapp.adapter;

/**
 * Created by thieumao on 1/29/17.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.thieumao.youtubeapp.R;
import com.thieumao.youtubeapp.activity.PlayerActivity;
import com.thieumao.youtubeapp.activity.PlaylistActivity;
import com.thieumao.youtubeapp.image.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;

public class HistoryAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    ArrayList<HashMap<String, String>> data;
    ImageLoader imageLoader;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public HistoryAdapter(Context context, ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;
        this.data = arraylist;
        imageLoader = new ImageLoader(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        TextView playlisttitle;
        ImageView playlistthumbnails;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.playlist_item, parent, false);
        resultp = data.get(position);
        playlisttitle = (TextView) itemView.findViewById(R.id.playlisttitle);
        playlistthumbnails = (ImageView) itemView.findViewById(R.id.playlistthumbnails);
        playlisttitle.setText(resultp.get(PlaylistActivity.title));
        imageLoader.DisplayImage(resultp.get(PlaylistActivity.thumbnails), playlistthumbnails);
        itemView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                resultp = data.get(position);
                String idVideo = resultp.get(PlaylistActivity.videoId);
                Intent intent = new Intent(context, PlayerActivity.class);
                intent.putExtra("idVideo", idVideo);
                context.startActivity(intent);
            }
        });
        return itemView;
    }
}
