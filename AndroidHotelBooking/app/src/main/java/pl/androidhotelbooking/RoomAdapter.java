package pl.androidhotelbooking;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wojtek on 2017-05-24.
 */

public class RoomAdapter extends ArrayAdapter<Room>
{
    ArrayList<Room> roomList;
    LayoutInflater vi;
    int Resource;

    ViewHolder holder;

    public RoomAdapter(Context context, int resource, ArrayList<Room> objects) {
        super(context, resource, objects);


        vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        roomList = objects;
    }

    static class ViewHolder {
        public ImageView imageview;
        public TextView tvNazwa;
        public TextView tvCena;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convert view = design
        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);
            holder.imageview = (ImageView) v.findViewById(R.id.image);
            holder.tvNazwa = (TextView) v.findViewById(R.id.tvNazwa);
            holder.tvCena = (TextView) v.findViewById(R.id.tvCena);


            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

       // new DownloadImageTask(holder.imageview).execute(actorList.get(position).getImage());
        holder.tvNazwa.setText(roomList.get(position).getNazwa());
        holder.tvCena.setText(roomList.get(position).getNazwa());



        return v;

    }
}
