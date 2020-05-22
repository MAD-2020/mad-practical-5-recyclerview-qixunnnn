package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    CheckBox cb;
    public MainViewHolder(View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.todoTxt);
        cb = itemView.findViewById(R.id.todoCB);

    }
}
