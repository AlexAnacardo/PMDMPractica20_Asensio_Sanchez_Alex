package es.ies.claudiomoyano.dam2.pmdm.practica20_asensio_sanchez_alex;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button botonMostrarPreferencias = findViewById(R.id.btn_settings);
        Button botonMostrarLog = findViewById(R.id.btn_log);
        
        botonMostrarPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.settings_container, new Preferencias())
                        .addToBackStack(null)
                        .commit();
            }
        });

        botonMostrarLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.SharedPreferences prefs = androidx.preference.PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                boolean chk = prefs.getBoolean("chk_gustar", false);
                boolean sw = prefs.getBoolean("switch_gustar", false);
                int seek = prefs.getInt("seekbar_gustar", 0);
                String juego = prefs.getString("juego", "");
                String estudio = prefs.getString("estudio", "");
                String genero = prefs.getString("genero", "");

                Log.d("PREFERENCIAS", "CheckBox: " + chk);
                Log.d("PREFERENCIAS", "Switch: " + sw);
                Log.d("PREFERENCIAS", "SeekBar: " + seek);
                Log.d("PREFERENCIAS", "Juego: " + juego);
                Log.d("PREFERENCIAS", "Estudio: " + estudio);
                Log.d("PREFERENCIAS", "Genero: " + genero);
            }
        });
    }
}