package br.com.ezeqlabs.ihsqueci.helpers;

import android.content.Context;
import android.widget.EditText;

import br.com.ezeqlabs.ihsqueci.FormularioLugaresActivity;
import br.com.ezeqlabs.ihsqueci.R;
import br.com.ezeqlabs.ihsqueci.modelo.Lugar;

public class FormularioLugaresHelper {
    private EditText nome;
    private EditText trouxe;
    private EditText endereco;
    private Lugar lugar;

    public FormularioLugaresHelper(FormularioLugaresActivity activity){
        this.lugar = new Lugar();

        this.nome = (EditText) activity.findViewById(R.id.formulario_campo_nome);
        this.trouxe = (EditText) activity.findViewById(R.id.formulario_campo_trouxe);
        this.endereco = (EditText) activity.findViewById(R.id.formulario_campo_endereco);
    }

    public Lugar pegaLugarDoFormulario(Context context){
        lugar.setNome(nome.getText().toString());
        lugar.setTrouxe(trouxe.getText().toString());
        lugar.setEndereco(endereco.getText().toString());

        LocalizacaoHelper helper = new LocalizacaoHelper(lugar.getEndereco(), context);

        lugar.setLatitude(helper.getLatitudeEndereco());
        lugar.setLongitude(helper.getLongitudeEndereco());

        return lugar;
    }

    public void colocaNoFormulario(Lugar lugar){
        nome.setText(lugar.getNome());
        trouxe.setText(lugar.getTrouxe());
        endereco.setText(lugar.getEndereco());

        this.lugar = lugar;
    }

    public boolean temNome(){
        return !nome.getText().toString().isEmpty();
    }

    public void erroNome(){
        nome.setError("Nome não pode ficar em branco");
    }

    public boolean trouxeAlgo(){
        return !trouxe.getText().toString().isEmpty();
    }

    public void erroTrouxe(){
        trouxe.setError("Não trouxe nada para esse lugar?");
    }

    public boolean temEndereco(){
        return !endereco.getText().toString().isEmpty();
    }

    public void erroEndereco(){
        endereco.setError("Endereço não pode ficar em branco");
    }
}
