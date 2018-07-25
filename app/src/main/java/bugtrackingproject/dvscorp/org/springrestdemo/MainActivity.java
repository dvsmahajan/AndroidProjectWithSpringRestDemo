package bugtrackingproject.dvscorp.org.springrestdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Entity.User;
import model.UserModelRest;

public class MainActivity extends AppCompatActivity {


//    private EditText username,password;
    private String username,password;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user= findViewById(R.id.username);
                username= String.valueOf(user.getText());
                EditText pass=(EditText)findViewById(R.id.password);
                password= String.valueOf(pass.getText());

                new HttpRequestAsk(username,password).execute();
            }
        });
    }

    public void goListViewPage(View view) {
        startActivity(new Intent(this,ResourceListActivity.class));
    }

    private class HttpRequestAsk extends AsyncTask<Void,Void, User>{

        private String username;
        private String password;
        private ProgressDialog pd;

        public HttpRequestAsk(String username, String password)
        {
            this.username=username;
            this.password=password;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("Please Wait............");
            pd.show();
        }

        @Override
        protected User doInBackground(Void... voids) {
            UserModelRest userModelRest=new UserModelRest();
            return userModelRest.checkLogin(username,password);
        }

        @Override
        protected void onPostExecute(User user) {
            if(user!=null) {
                TextView rId, name, email, managerEmail, number, designation;
                rId = findViewById(R.id.resourceId);
                rId.setText(String.valueOf(user.getResourceId()));
                name = findViewById(R.id.empName);
                name.setText(String.valueOf(user.getEmpName()));
                email = findViewById(R.id.empEmail);
                email.setText(String.valueOf(user.getEmpEmail()));
                managerEmail = findViewById(R.id.managerEmail);
                managerEmail.setText(String.valueOf(user.getManagerEmail()));
                number = findViewById(R.id.empNumber);
                number.setText(String.valueOf(user.getEmpNumber()));
                designation = findViewById(R.id.empDesignation);
                designation.setText(String.valueOf(user.getEmpDesignation()));
                if (pd != null)
                    try {
                        pd.dismiss();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
            }else{
                Toast.makeText(getApplicationContext(), "Username and Password Is Incorrect.............please Try Again..................", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(MainActivity.class));
                if (pd != null)
                    try {
                        pd.dismiss();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
            }

        }

    }
}
