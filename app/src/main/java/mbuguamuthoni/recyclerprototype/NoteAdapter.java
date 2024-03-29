package mbuguamuthoni.recyclerprototype;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.ServerTimestamp;
import com.google.firestore.v1.DocumentTransform;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NoteAdapter extends FirestoreRecyclerAdapter <Note, NoteAdapter.NoteHolder> {
    @ServerTimestamp Date timestamp;

    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteHolder holder, int position, @NonNull Note model) {
        holder.tvNo.setText(String.valueOf(position+1));
        holder.tvPlate.setText(model.getNo_plate());
        holder.tvNickName.setText(model.getNickName());
//        holder.textViewTime.setText(Date);





            SimpleDateFormat format = new SimpleDateFormat("h:mm a");
        if (timestamp != null) {

            String currentDate = format.format(model.getTimestamp().getTime());
            holder.textViewTime.setText(currentDate);


        } else {
            try {
                String currentDate = format.format(model.getTimestamp().getTime());
                holder.textViewTime.setText(currentDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
             }












    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,
                parent, false);
                return new NoteHolder(v);
    }

    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        TextView tvNo, tvPlate,tvNickName, textViewTime ;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            tvNo = itemView.findViewById(R.id.number);
            tvPlate = itemView.findViewById(R.id.no_plate);
            tvNickName = itemView.findViewById(R.id.Nick_Name);
            textViewTime = itemView.findViewById(R.id.time);
        }
    }
}
