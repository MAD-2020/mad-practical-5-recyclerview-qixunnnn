package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.text.Html;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private ArrayList<String> data;
    private Context currentContext;

    public MainAdapter(ArrayList<String> input, Context context){

        data = input;
        currentContext = context;
    }

    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist_layout,parent,false);
        return new MainViewHolder(item);
    }

    public void onBindViewHolder(final MainViewHolder holder, int position) {
        final String s = data.get(position);
        holder.txt.setText(s);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(currentContext);
                final View view = LayoutInflater.from(currentContext).inflate(R.layout.sample,null);
                builder.setTitle("Delete");
                builder.setView(view);
                builder.setMessage(Html.fromHtml("<div style='text-align: center'> Are you sure you want to delete <br /> <b>" + s + "</b>?</div>"));

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(holder.getLayoutPosition());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    public int getItemCount()
    {
        return data.size();
    }
}
