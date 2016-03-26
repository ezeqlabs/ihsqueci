package br.com.ezeqlabs.ihsqueci.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.ezeqlabs.ihsqueci.modelo.Lugar;

public class LugarDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "ihsqueci";
    private static final String TABELA = "lugares";
    private static final int DB_VERSION = 3;

    public LugarDAO(Context context){
        super(context, DATABASE, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase database){
        String ddl = "CREATE TABLE " + TABELA
                + " (id INTEGER PRIMARY KEY, "
                + " nome TEXT, "
                + " trouxe TEXT, "
                + " endereco TEXT, "
                + " latitude REAL, "
                + " longitude REAL);";

        database.execSQL(ddl);
    }

    public void onUpgrade(SQLiteDatabase database, int versaoAntiga, int versaoNova){
        switch(versaoAntiga){
            case 1:
                String sql = "ALTER TABLE " + TABELA + " ADD COLUMN endereco TEXT;";
                database.execSQL(sql);

            case 2:
                sql = "ALTER TABLE " + TABELA + " ADD COLUMN latitude REAL;";
                database.execSQL(sql);
                sql = "ALTER TABLE " + TABELA + " ADD COLUMN longitude REAL;";
                database.execSQL(sql);

        }
    }

    public void insere(Lugar lugar){
        ContentValues values = new ContentValues();

        values.put("nome", lugar.getNome());
        values.put("trouxe", lugar.getTrouxe());
        values.put("endereco", lugar.getEndereco());
        values.put("latitude", lugar.getLatitude());
        values.put("longitude", lugar.getLongitude());

        getWritableDatabase().insert(TABELA, null, values);
    }

    public List<Lugar> getListaLugares(){
        List<Lugar> lugares = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM " + TABELA + " ORDER BY id DESC;", null);

        while(c.moveToNext()){
            Lugar lugar = new Lugar();

            lugar.setId(c.getLong(c.getColumnIndex("id")));
            lugar.setNome(c.getString(c.getColumnIndex("nome")));
            lugar.setTrouxe(c.getString(c.getColumnIndex("trouxe")));
            lugar.setEndereco(c.getString(c.getColumnIndex("endereco")));
            lugar.setLatitude(c.getDouble(c.getColumnIndex("latitude")));
            lugar.setLongitude(c.getDouble(c.getColumnIndex("longitude")));

            lugares.add(lugar);
        }

        c.close();
        return lugares;
    }

    public void deletar(Lugar lugar){
        String[] args = { lugar.getId().toString() };
        getWritableDatabase().delete(TABELA, "id=?", args);
    }

    public void altera(Lugar lugar){
        ContentValues values = new ContentValues();

        values.put("nome", lugar.getNome());
        values.put("trouxe", lugar.getTrouxe());
        values.put("endereco", lugar.getEndereco());
        values.put("latitude", lugar.getLatitude());
        values.put("longitude", lugar.getLongitude());

        String[] args = { lugar.getId().toString() };
        getWritableDatabase().update(TABELA, values, "id=?", args);
    }

    public void insereOuAtualiza(Lugar lugar){
        if(lugar.getId() == null){
            this.insere(lugar);
        }else{
            this.altera(lugar);
        }
    }
}
