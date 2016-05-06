package br.com.ezeqlabs.ihsqueci.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.ezeqlabs.ihsqueci.DetalheLugarActivity;
import br.com.ezeqlabs.ihsqueci.ListaLugaresActivity;
import br.com.ezeqlabs.ihsqueci.R;
import br.com.ezeqlabs.ihsqueci.helpers.LugaresHelper;
import br.com.ezeqlabs.ihsqueci.modelo.Lugar;

public class ListaLugaresAdapter extends RecyclerView.Adapter<ListaLugaresAdapter.LugarViewHolder> {
    private List<Lugar> listaLugares;

    public ListaLugaresAdapter(List<Lugar> listaLugares){
        this.listaLugares = listaLugares;
    }

    @Override
    public LugarViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.cardview_lugar, viewGroup, false);

        LugarViewHolder holder = new LugarViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(LugarViewHolder holder, int position) {
        Lugar lugar = listaLugares.get(position);
        holder.nomeLugar.setText(lugar.getNome());
        holder.enderecoLugar.setText(lugar.getEndereco());
    }

    @Override
    public int getItemCount() {
        return this.listaLugares.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class LugarViewHolder extends RecyclerView.ViewHolder {
        protected TextView nomeLugar;
        protected TextView enderecoLugar;

        public LugarViewHolder(View itemView) {
            super(itemView);
            nomeLugar = (TextView) itemView.findViewById(R.id.nome_lugar);
            enderecoLugar = (TextView) itemView.findViewById(R.id.endereco_lugar);
        }
    }

}
