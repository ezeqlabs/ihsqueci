package br.com.ezeqlabs.ihsqueci.helpers;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.util.List;

public class LocalizacaoHelper {
    private String endereco;
    private Context context;

    public LocalizacaoHelper(String endereco, Context context){
        this.endereco = endereco;
        this.context = context;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getLatitudeEndereco(){
        if(preparaEndereco() != null){
            return preparaEndereco().getLatitude();
        }
        return 0.0;
    }

    public double getLongitudeEndereco(){
        if(preparaEndereco() != null){
            return preparaEndereco().getLongitude();
        }
        return 0.0;
    }

    private Address preparaEndereco(){
        try {
            Geocoder geo = new Geocoder(context);
            List<Address> listaEnderecos = geo.getFromLocationName(endereco, 1);
            Address address = listaEnderecos.get(0);
            return address;
        }catch(Exception e){
            Log.e("Erro LocalizacaoHelper", e.getStackTrace().toString());
            return null;
        }
    }
}
