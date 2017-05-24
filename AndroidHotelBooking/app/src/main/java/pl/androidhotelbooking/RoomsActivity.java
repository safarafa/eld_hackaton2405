package pl.androidhotelbooking;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class RoomsActivity extends Activity
{
    public static final String SELECTED_ROOM = "selected_room";
    private ListView mListView;
    private static final String JSON_URL = "url";

    private int mNumberOfPeople;
    private ArrayList<HashMap<String, String>> mRoomsList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        mRoomsList = new ArrayList<>();
        mNumberOfPeople = getIntent().getExtras().getInt(MainActivity.NUMBER_OF_PEOPLE);

        new RoomFilter().execute();
    }

    private void goToSelectedRoom(int position)
    {
        Intent selectedRoom = new Intent(this, SelectedRoomActivity.class);
        selectedRoom.putExtra(SELECTED_ROOM, position);
        startActivity(selectedRoom);
    }

    private class RoomFilter extends AsyncTask<Void, Void, Void>
    {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(RoomsActivity.this, getString(R.string.loading), getString(R.string.please_wait), false);
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
//            HttpHandler httpHandler = new HttpHandler();

            String jsonString = loadJSONFromAsset();

            if(jsonString != null)
            {
                try
                {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONArray jsonArray = jsonObject.getJSONArray("rooms");

                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject object = jsonArray.getJSONObject(i);
                        int roomSize = object.getInt("seats");

                        if(roomSize == mNumberOfPeople)
                        {
                            String id = String.valueOf(object.getInt("idRoom"));
                            String price = String.valueOf(object.getInt("price"));

                            HashMap<String, String> room = new HashMap<>();

                            room.put("id", id);
                            room.put("price", price);

                            mRoomsList.add(room);
                        }
                    }
                }
                catch(final JSONException e)
                {
                    runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Toast.makeText(RoomsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);

            if(progressDialog.isShowing())
                progressDialog.dismiss();

            mListView = (ListView) findViewById(R.id.list);

            ListAdapter adapter = new SimpleAdapter(
                    RoomsActivity.this, mRoomsList,
                    R.layout.listapokoje, new String[]{"id", "price"}, new int[]{R.id.tvId,
                    R.id.tvCena});

            mListView.setAdapter(adapter);

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
                {
                    goToSelectedRoom(position);
                }
            });
        }
    }

    public String loadJSONFromAsset()
    {
        String json = null;
        try
        {

            InputStream is = getAssets().open("data.json");

            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}
