package br.com.ezeqlabs.ihsqueci.helpers;

import android.widget.EditText;

import br.com.ezeqlabs.ihsqueci.FormularioLugaresActivity;
import br.com.ezeqlabs.ihsqueci.R;
import br.com.ezeqlabs.ihsqueci.modelo.Lugar;

public class FormularioLugaresHelper {
    private EditText nome;
    private EditText trouxe;
    private Lugar lugar;

    public FormularioLugaresHelper(FormularioLugaresActivity activity){
        this.lugar = new Lugar();

        this.nome = (EditText) activity.findViewById(R.id.formulario_campo_nome);
        this.trouxe = (EditText) activity.findViewById(R.id.formulario_campo_trouxe);
    }

    public Lugar pegaLugarDoFormulario(){
        lugar.setNome(nome.getText().toString());
        lugar.setTrouxe(trouxe.getText().toString());

        return lugar;
    }

    public void colocaNoFormulario(Lugar lugar){
        nome.setText(lugar.getNome());
        trouxe.setText(lugar.getTrouxe());

        this.lugar = lugar;
    }

    public boolean temNome(){
        return !nome.getText().toString().isEmpty();
    }

    public void erroNome(){
        nome.setError("Nome não pode estar em branco");
    }

    public boolean trouxeAlgo(){
        return !trouxe.getText().toString().isEmpty();
    }

    public void erroTrouxe(){
        trouxe.setError("Não trouxe nada para esse lugar?");
    }
}
