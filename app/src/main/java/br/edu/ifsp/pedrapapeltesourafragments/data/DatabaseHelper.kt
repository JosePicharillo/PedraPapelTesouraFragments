package br.edu.ifsp.pedrapapeltesourafragments.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private var tagLog = this::class.java.simpleName

    companion object {
        private val DATABASE_NAME = "conf.db"
        private val DATABASE_VERSION = 1
        private val TABLE_NAME = "configuracao"
        private val ID = "id"
        private val NUM_JOGADOR = "numJogador"
        private val NUM_RODADAS = "numRodadas"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_TABLE =
            "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NUM_JOGADOR INTEGER, $NUM_RODADAS INTEGER)"
        p0?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun addSettings(settings: Settings): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(ID, settings.id)
        values.put(NUM_JOGADOR, settings.numJogador)
        values.put(NUM_RODADAS, settings.numRodadas)
        val result = db.insert(TABLE_NAME, null, values)
        db.close()
        return result
    }

    fun addSettingsPattern(){
        val s = Settings(1, 2, 1)
        addSettings(s)
    }

    fun updateSettings(settings: Settings): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(ID, settings.id)
        values.put(NUM_JOGADOR, settings.numJogador)
        values.put(NUM_RODADAS, settings.numRodadas)
        val result = db.update(TABLE_NAME, values, "$ID=?", arrayOf(settings.id.toString()))
        db.close()
        return result
    }

    fun infoSettings(): ArrayList<Settings> {
        val list = ArrayList<Settings>()
        val query = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)
        while (cursor.moveToNext()) {
            val s = Settings(
                cursor.getInt(0),
                cursor.getInt(1),
                cursor.getInt(2)
            )
            list.add(s)
        }
        cursor.close()
        db.close()
        return list
    }
}