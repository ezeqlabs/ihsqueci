package br.com.ezeqlabs.ihsqueci.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.ezeqlabs.ihsqueci.FormularioLugaresActivity;
import br.com.ezeqlabs.ihsqueci.ListaLugaresActivity;
import br.com.ezeqlabs.ihsqueci.R;
import br.com.ezeqlabs.ihsqueci.dao.LugarDAO;
import br.com.ezeqlabs.ihsqueci.modelo.Lugar;

public class LugaresHelper {
    private Activity activity;

    public LugaresHelper(Activity activity){
        this.activity = activity;
    }

    public void deletaLugar(final Lugar lugar){
        new AlertDialog.Builder(activity)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.title_dialog)
                .setMessage(R.string.message_dialog)
                .setPositiveButton(R.string.sim,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                LugarDAO dao = new LugarDAO(activity);
                                dao.deletar(lugar);
                                dao.close();

                                Toast.makeText(activity, (lugar.getNome() + " apagado com sucesso"), Toast.LENGTH_SHORT).show();

                                activity.finish();
                                Intent listaLugaresActivity = new Intent(activity, ListaLugaresActivity.class);
                                activity.startActivity(listaLugaresActivity);
                            }
                        })
                .setNegativeButton(R.string.nao, null)
                .show();
    }

    public void abreEdicaoLugar(final Lugar lugar){
        Intent intent = new Intent(activity, FormularioLugaresActivity.class);
        intent.putExtra("lugarSelecionado", lugar);
        activity.startActivity(intent);
    }

    public List<Lugar> populaListagem(){
        LugarDAO dao = new LugarDAO(activity);
        List<Lugar> lugares = dao.getListaLugares();
        dao.close();

        return lugares;
    }

    public Lugar getLugarLista(int posicao){
        return populaListagem().get(posicao);
    }
}
