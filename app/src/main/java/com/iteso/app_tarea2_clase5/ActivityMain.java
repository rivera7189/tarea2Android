package com.iteso.app_tarea2_clase5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {
    protected AutoCompleteTextView libros;
    protected EditText nombre;
    protected  EditText telefono;
    protected Spinner nivel_educativo;
    protected RadioGroup genero;
    protected RadioButton mujer;
    protected RadioButton hombre;
    protected CheckBox deporte;
    protected Button limpiar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        libros = findViewById(R.id.autocomplete);
        String[] libros_favoritos = getResources().getStringArray(R.array.Libros);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,libros_favoritos);
        libros.setAdapter(adapter);
        limpiar = findViewById(R.id.clean);

        }




    public void reset(View view){
        AlertDialog.Builder clean_dialog = new AlertDialog.Builder(this);

        clean_dialog.setMessage("¿Desea borrar?");

        clean_dialog.setTitle("Borrar");

        clean_dialog.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                borrar();
            }
        });

        clean_dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialogoBorrar = clean_dialog.create();
        dialogoBorrar.show();
    }

    public void borrar(){
        nombre = findViewById(R.id.name);
        telefono = findViewById(R.id.phone);
        mujer = findViewById(R.id.btnfem);
        nivel_educativo = findViewById(R.id.spiner);
        genero = findViewById(R.id.radiogroup);
        deporte = findViewById(R.id.sport);
        libros = findViewById(R.id.autocomplete);

        nombre.setText("");
        libros.setText("");
        deporte.setChecked(false);
        telefono.setText("");
        genero.clearCheck();
        mujer.setChecked(true);
        hombre.setChecked(false);
        Toast.makeText(this, "Eliminar Contenido", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    Alumno alumno = new Alumno();




    public String Asignaciones(){
        nombre = findViewById(R.id.name);
        telefono = findViewById(R.id.phone);
        mujer = findViewById(R.id.btnfem);
        nivel_educativo = findViewById(R.id.spiner);
        genero = findViewById(R.id.radiogroup);
        deporte = findViewById(R.id.sport);
        libros = findViewById(R.id.autocomplete);

        Alumno alumno = new Alumno();
        alumno.setNombre(nombre.getText().toString());
        alumno.setTelefono(telefono.getText().toString());
        alumno.setEducacion(nivel_educativo.getSelectedItem().toString());
        alumno.setBook(libros.getText().toString());
        alumno.setMujer(mujer.isChecked());
        alumno.setHombre(!mujer.isChecked());
        alumno.setSport(deporte.isChecked());
        return alumno.toString();
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.iconsave :
                Toast.makeText(this,Asignaciones(),Toast.LENGTH_LONG).show();
                return true;
            default:
                return false;
        }
    }
}
