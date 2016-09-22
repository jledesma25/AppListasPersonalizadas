package academiamoviles.com.applistaspersonalizadas;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import academiamoviles.com.applistaspersonalizadas.Adaptador.AlumnoAdapter;
import academiamoviles.com.applistaspersonalizadas.Interfaz.IMainActivity;
import academiamoviles.com.applistaspersonalizadas.Interfaz.RecyclerViewOnItemClickListener;
import academiamoviles.com.applistaspersonalizadas.Modelo.Alumno;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class AlumnoActivity extends AppCompatActivity implements IMainActivity{

    @InjectView(R.id.recyclerview_alumnos)
    RecyclerView recyclerview_alumnos;

    @InjectView(R.id.fabAgregar)
    FloatingActionButton fabAgregar;

    private AlumnoAdapter mAdapter;
    ArrayList<Alumno> list_alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);
        ButterKnife.inject(this);

        inicializarValores();
        configurarAdaptador();
        configurarOrientacionLayout();
    }

    @Override
    public void inicializarValores() {

        //Test

        //Test2

        list_alumno = new ArrayList<>();

        Alumno alumno1 = new Alumno();
        alumno1.setNombre("Jose");
        alumno1.setCurso("Android");

        list_alumno.add(alumno1);

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Freddy");
        alumno2.setCurso("IOS");

        list_alumno.add(alumno2);

    }

    @Override
    public void configurarAdaptador() {

        mAdapter = new AlumnoAdapter(this,R.layout.alumnos_row,list_alumno, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
              //  mostrarMensaje("position: "+position + "nombre" + list_alumno.get(position));
                mAdapter.removeItem(position);
            }
        });
        recyclerview_alumnos.setAdapter(mAdapter);


    }

    @Override
    public void mostrarMensaje(String mensaje) {
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void configurarOrientacionLayout() {
        recyclerview_alumnos.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void configurarToolbar() {

    }

    @Override
    public void configurarAnimator() {

    }

    @Override
    public void agregarAlumno() {

    }
}
