package udacity.basic.sunshine;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceHolderFragment())
                    .commit();
        }
    }



    public static class PlaceHolderFragment extends Fragment {
        public PlaceHolderFragment() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ArrayList<String> forecasts = new ArrayList();

            for (int i=0; i < 10; i++) {
                forecasts.add("Today - Sunny - "+ (78+i) +"/"+ (56+i));
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                                                        getActivity(),
                                                        R.layout.list_item_forecast,
                                                        R.id.list_item_forecast_textview,
                                                        forecasts);

            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);

            listView.setAdapter(arrayAdapter);

            return rootView;
        }
    }
}
