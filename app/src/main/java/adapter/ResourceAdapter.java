package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import Entity.User;
import bugtrackingproject.dvscorp.org.springrestdemo.R;

public class ResourceAdapter extends ArrayAdapter<User> {

    private Context context;
    private List<User> users;

    public ResourceAdapter(Context context,List<User> users){
        super(context, R.layout.activity_resource_list,users);
        this.context=context;
        this.users=users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.resorce_details_layout,parent,false);
        User user=users.get(position);

        TextView textView=(TextView)view.findViewById(R.id.resourceId);
        textView.setText(String.valueOf(user.getResourceId()));
        TextView textView1=(TextView)view.findViewById(R.id.resourceName);
        textView1.setText(user.getEmpName());
        TextView textView2=(TextView)view.findViewById(R.id.empEmail);
        textView2.setText(user.getEmpEmail());

        return view;
    }
}
