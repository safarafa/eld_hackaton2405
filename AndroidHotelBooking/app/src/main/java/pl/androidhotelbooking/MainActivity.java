package pl.androidhotelbooking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{
    public static final String NUMBER_OF_PEOPLE = "number_of_people";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchB = (Button) findViewById(R.id.search_rooms_B);
        searchB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                handleEditText();
            }
        });
    }

    private void handleEditText()
    {
        EditText numberOfPeopleET = (EditText) findViewById(R.id.number_of_people_ET);
        String editTextValue = numberOfPeopleET.getText().toString();

        int numberOfPeople = 0;

        if(!editTextValue.equals(""))
            numberOfPeople = Integer.parseInt(editTextValue);

        if(numberOfPeople !=0)
            goToListOfRooms(numberOfPeople);
        else
            Toast.makeText(this, R.string.warning, Toast.LENGTH_SHORT).show();
    }

    private void goToListOfRooms(int numberOfPeople)
    {
        Intent listOfRooms = new Intent(this, RoomsActivity.class);
        listOfRooms.putExtra(NUMBER_OF_PEOPLE, numberOfPeople);
        startActivity(listOfRooms);
    }
}
