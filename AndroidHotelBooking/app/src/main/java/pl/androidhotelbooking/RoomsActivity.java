package pl.androidhotelbooking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class RoomsActivity extends Activity
{
    public static final String SELECTED_ROOM = "selected_room";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        ArrayList<Room> listaPokoje = new ArrayList<Room>();




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        int numberOfPeople = getIntent().getExtras().getInt(MainActivity.NUMBER_OF_PEOPLE);


    }

    private void goToSelectedRoom(int position)
    {
        Intent selectedRoom = new Intent(this, SelectedRoomActivity.class);
        selectedRoom.putExtra(SELECTED_ROOM, position);
        startActivity(selectedRoom);
    }
}
