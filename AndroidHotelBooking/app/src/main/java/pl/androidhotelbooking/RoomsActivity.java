package pl.androidhotelbooking;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class RoomsActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        ArrayList<Room> listaPokoje = new ArrayList<Room>();




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
    }
}
