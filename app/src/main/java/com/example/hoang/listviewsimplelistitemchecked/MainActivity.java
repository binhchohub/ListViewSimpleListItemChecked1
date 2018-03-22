package com.example.hoang.listviewsimplelistitemchecked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "ListViewExample";

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView)findViewById(R.id.listView);


        // CHOICE_MODE_NONE: Không cho phép lựa chọn (Mặc định).
        // ( listView.setItemChecked(..) không làm việc với CHOICE_MODE_NONE).
        // CHOICE_MODE_SINGLE: Cho phép một lựa chọn.
        // CHOICE_MODE_MULTIPLE: Cho phép nhiều lựa chọn.
        // CHOICE_MODE_MULTIPLE_MODAL: Cho phép nhiều lựa chọn trên Modal Selection Mode.
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });
        //

        UserAccount tom = new UserAccount("Tom","admin");
        UserAccount jerry = new UserAccount("Jerry","user");
        UserAccount donald = new UserAccount("Donald","guest", false);
        UserAccount tom1 = new UserAccount("Tom1","admin");
        UserAccount jerry1 = new UserAccount("Jerry1","user");
        UserAccount donald1 = new UserAccount("Donald1","guest", false);
        UserAccount tom2 = new UserAccount("Tom2","admin");
        UserAccount jerry2 = new UserAccount("Jerry2","user");
        UserAccount donald2 = new UserAccount("Donald2","guest", false);
        UserAccount tom3 = new UserAccount("Tom3","admin");
        UserAccount jerry3 = new UserAccount("Jerry3","user");
        UserAccount donald3 = new UserAccount("Donald3","guest", false);

        UserAccount[] users = new UserAccount[]{tom,jerry, donald,tom1,jerry1, donald1,tom2,jerry2, donald2,tom3,jerry3, donald3};

        // android.R.layout.simple_list_item_checked: Là một hằng số Layout định nghĩa sẵn của Android
        // ý nghĩa của nó là ListView với ListItem đơn giản (Duy nhất một CheckedTextView).

        ArrayAdapter<UserAccount> arrayAdapter
                = new ArrayAdapter<UserAccount>(this, android.R.layout.simple_list_item_multiple_choice , users);


        listView.setAdapter(arrayAdapter);


    }

    // Khi người dùng nhấn vào nút "Print Selected Items".
    public void printSelectedItems(View view)  {

        SparseBooleanArray sp = listView.getCheckedItemPositions();

        String str = "";

        for(int i=0;i<sp.size();i++){
            if(sp.valueAt(i)==true){
                UserAccount user= (UserAccount) listView.getItemAtPosition(i);
                // Or:
                // String s = ((CheckedTextView) listView.getChildAt(i)).getText().toString();
                String s= user.getUserName();
                str += s + " ";
            }
        }
        Toast.makeText(this, "Selected items are: "+str, Toast.LENGTH_LONG).show();

    }

}
