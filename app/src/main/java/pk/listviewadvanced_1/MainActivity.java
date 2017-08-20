package pk.listviewadvanced_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

//important import
import android.text.TextWatcher;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    EditText searchtext;
    ListViewadapter adapter;

    ArrayAdapter <String> listadapter;

    Integer[] imgid = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4
    };

    String items[] = {"Batch B5","Batch B6","No batch"," All batch"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView = (ListView) findViewById(R.id.mainlistview);

        searchtext =  (EditText)findViewById(R.id.search_text);

        adapter = new ListViewadapter(MainActivity.this, items, imgid);
        //Assign Above Array Adapter to ListView
        listView.setAdapter(adapter);
        //Create ListView Item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), items[position], Toast.LENGTH_LONG).show();
            }
        });



    searchtext.addTextChangedListener(new GenericTextWatcher(searchtext));

    }



    private class GenericTextWatcher implements TextWatcher {

        private View view;

        private GenericTextWatcher(View v) {
            this.view = v;
        }


        @Override
        public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
            // When user changed the Text this function gets called and searched and updates the adapter
            MainActivity.this.adapter.getFilter().filter(cs);

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable arg0) {
            // TODO Auto-generated method stub
        }

    }
}
