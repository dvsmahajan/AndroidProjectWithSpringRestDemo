package bugtrackingproject.dvscorp.org.springrestdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import Entity.User;
import adapter.ResourceAdapter;
import model.UserModelRest;

public class ResourceListActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_list);
        new HttpRequestAsk().execute();
    }

    private class HttpRequestAsk extends AsyncTask<Void,Void,List<User>>{

        private ProgressDialog pd;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(ResourceListActivity.this);
            pd.setMessage("Please Wait............");
            pd.show();
        }


        @Override
        protected List<User> doInBackground(Void... voids) {

            UserModelRest userModelRest=new UserModelRest();
            return userModelRest.getAll();

        }

        @Override
        protected void onPostExecute(List<User> users) {

            ListView resourcelistView=findViewById(R.id.resourceListView);
            resourcelistView.setAdapter(new ResourceAdapter(getApplicationContext(),users));
            if(pd!=null)
            {
                try{
                    pd.dismiss();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
