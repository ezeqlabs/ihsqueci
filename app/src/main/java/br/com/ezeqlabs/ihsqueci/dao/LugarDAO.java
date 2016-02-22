package br.com.ezeqlabs.ihsqueci.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.ezeqlabs.ihsqueci.modelo.Lugar;

public class LugarDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "ihsqueci";
    private static final String TABELA = "lugares";
    private static final int DB_VERSION = 1;

    public LugarDAO(Context context){
        super(context, DATABASE, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase database){
        String ddl = "CREATE TABLE " + TABELA
                + " (id INTEGER PRIMARY KEY, "
                + " nome TEXT, "
                + " trouxe TEXT);";

        database.execSQL(ddl);
    }

    public void onUpgrade(SQLiteDatabase database, int versaoAntiga, int versaoNova){}

    public void insere(Lugar lugar){
        ContentValues values = new ContentValues();

        values.put("nome", lugar.getNome());
        values.put("trouxe", lugar.getTrouxe());

        getWritableDatabase().insert(TABELA, null, values);
    }

    public List<Lugar> getListaLugares(){
        List<Lugar> lugares = new ArrayList<Lugar>();
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM " + TABELA + " ORDER BY id DESC;", null);

        while(c.moveToNext()){
            Lugar lugar = new Lugar();

            lugar.setId(c.getLong(c.getColumnIndex("id")));
            lugar.setNome(c.getString(c.getColumnIndex("nome")));
            lugar.setTrouxe(c.getString(c.getColumnIndex("trouxe")));

            lugares.add(lugar);
        }

        c.close();
        return lugares;
    }
}
