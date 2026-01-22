package es.ies.claudiomoyano.dam2.pmdm.practica20_asensio_sanchez_alex;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.preference.PreferenceFragmentCompat;

public class Preferencias extends PreferenceFragmentCompat{
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}
