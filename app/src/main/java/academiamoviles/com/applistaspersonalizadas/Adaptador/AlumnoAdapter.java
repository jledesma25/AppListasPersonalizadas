package academiamoviles.com.applistaspersonalizadas.Adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import academiamoviles.com.applistaspersonalizadas.AlumnoActivity;
import academiamoviles.com.applistaspersonalizadas.Interfaz.RecyclerViewOnItemClickListener;
import academiamoviles.com.applistaspersonalizadas.Modelo.Alumno;
import academiamoviles.com.applistaspersonalizadas.R;

/**
 * Created by jledesma on 20/09/2016.
 */
public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoAdapterViewHolder>{

    Context context;
    int alumnos_row;
    ArrayList<Alumno> list_alumnos;

    private RecyclerViewOnItemClickListener recyclerviewViewOnItemClickListener;

    public AlumnoAdapter(Context alumnoActivity, int alumnos_row, ArrayList<Alumno> list_alumno,RecyclerViewOnItemClickListener recyclerviewOn) {

        this.context = alumnoActivity;
        this.alumnos_row = alumnos_row;
        this.list_alumnos = list_alumno;
        this.recyclerviewViewOnItemClickListener = recyclerviewOn;
    }

    @Override
    public AlumnoAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(alumnos_row,parent,false);
        return new AlumnoAdapterViewHolder(item);
    }

    @Override
    public void onBindViewHolder(AlumnoAdapterViewHolder holder, int position) {

        Alumno alumno = list_alumnos.get(position);

        holder.tv_nombre.setText(alumno.getNombre());
        holder.tv_curso.setText(alumno.getCurso());


    }

    public void removeItem(int position){
        list_alumnos.remove(position);
        notifyItemRemoved(position);
    }

    public void addItem(int position,Alumno data){
        list_alumnos.add(position,data);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return list_alumnos.size();
    }

    public class AlumnoAdapterViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        TextView tv_nombre,tv_curso;


        public AlumnoAdapterViewHolder(View itemView) {
            super(itemView);

            tv_nombre = (TextView) itemView.findViewById(R.id.tv_alumno);
            tv_curso = (TextView) itemView.findViewById(R.id.tv_curso);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recyclerviewViewOnItemClickListener.onClick(v,getAdapterPosition());
        }
    }
}
