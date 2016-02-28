package com.example.pc.detectawifi_o_3g;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Recogemos el servicio ConnectivityManager
        //el cual se encarga de todas las conexiones del terminal
        ConnectivityManager conMan = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        //Recogemos el estado del 3G
        //como vemos se recoge con el parámetro 0
        NetworkInfo.State internet_movil = conMan.getNetworkInfo(0).getState();
        //Recogemos el estado del wifi
        //En este caso se recoge con el parámetro 1
        NetworkInfo.State wifi = conMan.getNetworkInfo(1).getState();
        //Miramos si el internet 3G está conectado o conectandose...
        if (internet_movil == NetworkInfo.State.CONNECTED
                || internet_movil == NetworkInfo.State.CONNECTING) {
            ///////////////
            //El movil está conectado por 3G
            //En este ejemplo mostraríamos mensaje por pantalla
            Toast.makeText(getApplicationContext(), "Conectado por 3G"
                    , Toast.LENGTH_LONG).show();
            //Si no esta por 3G comprovamos si está conectado o conectandose al wifi...
        } else if (wifi == NetworkInfo.State.CONNECTED
                || wifi == NetworkInfo.State.CONNECTING) {
            ///////////////
            //El movil está conectado por WIFI
            //En este ejemplo mostraríamos mensaje por pantalla
            Toast.makeText(getApplicationContext(), "Conectado por WIFI"
                    , Toast.LENGTH_LONG).show();
        }
    }
}
