package com.example.soalria

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.soalria.model.RateModel
import com.example.soalria.model.RateModel2
import java.util.*
import kotlin.collections.ArrayList

class DatabaseHelper(var context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION
) {
    companion object {
        private const val DATABASE_NAME = "soalriaDATABASE1"
        private const val DATABASE_VERSION = 1

        private const val TABLE_ACCOUNT = "account"
        private const val TABLE_RATE = "rate"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_TELEPHONE = "telephone"
        private const val COLUMN_MENU = "namaMenu"
        private const val COLUMN_RATING = "rating"
        private const val COLUMN_SARAN = "saran"
        private const val COLUMN_WAKTU= "waktu"

        //table menu (hapus)
        val TABLE_MENU = "menu"
        //column menu table
        private val COLUMN_ID_MENU = "idMenu"
        val COLUMN_NAMA_MENU = "menuName"
        val COLUMN_DESC_MENU = "desc"
        val COLUMN_IMAGE = "photo"

    }

    private val CREATE_ACCOUNT_TABLE =
        ("CREATE TABLE " + TABLE_ACCOUNT + "("
                + COLUMN_EMAIL + " TEXT PRIMARY KEY, "
                + COLUMN_PASSWORD + " TEXT, "
                + COLUMN_USERNAME + " TEXT, "
                + COLUMN_TELEPHONE + " TEXT)")

    private val DROP_ACCOUNT_TABLE = "DROP TABLE IF EXISTS $TABLE_ACCOUNT"

    //(hapus)
    //create table menu sql query
    private val CREATE_MENU_TABLE = ("CREATE TABLE " + TABLE_MENU + "("
            + COLUMN_ID_MENU + " INT PRIMARY KEY, "+ COLUMN_NAMA_MENU +" TEXT, "
            + COLUMN_DESC_MENU + " TEXT, "+ COLUMN_IMAGE +" BLOB)")

    //drop table menu sql query
    private val DROP_MENU_TABLE = "DROP TABLE IF EXISTS $TABLE_MENU"


    private val CREATE_RATE_TABLE =
        ("CREATE TABLE " + TABLE_RATE + "("
                + COLUMN_MENU + " TEXT, "
                + COLUMN_RATING + " REAL, "
                + COLUMN_SARAN + " TEXT, "
                + COLUMN_WAKTU + " INTEGER)")  // Tambahkan kolom waktu dengan tipe data INTEGER

    private val DROP_RATE_TABLE = "DROP TABLE IF EXISTS $TABLE_RATE"



    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(CREATE_ACCOUNT_TABLE)
        p0?.execSQL(CREATE_RATE_TABLE)
        p0?.execSQL(CREATE_MENU_TABLE)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL(DROP_ACCOUNT_TABLE)
        p0?.execSQL(DROP_RATE_TABLE)
        p0?.execSQL(CREATE_MENU_TABLE)
        onCreate(p0)
    }


    @SuppressLint("Range")
    fun checkLogin(email: String, password: String): Boolean {
        val columns = arrayOf(COLUMN_EMAIL, COLUMN_USERNAME, COLUMN_TELEPHONE, COLUMN_PASSWORD)
        val db = this.readableDatabase

        //selection criteria
        val selection = "$COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
        //selection arguments
        val selectionArgs = arrayOf(email, password)

        val cursor = db.query(
            TABLE_ACCOUNT, //table to query
            columns, //columns to return
            selection, //columns for WHERE clause
            selectionArgs, //the values for the WHERE clause
            null, //group the rows
            null, //filter by row groups
            null
        ) //the sort order

        val cursorCount = cursor.count
        val result: Boolean

        //check data available or not
        if (cursorCount > 0) {
            result = true
            //set data
            if (cursor.moveToFirst()) {
                AccFragment.email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL))
                AccFragment.username = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME))
                AccFragment.telephone = cursor.getString(cursor.getColumnIndex(COLUMN_TELEPHONE))
                AccFragment.password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD))
            }
        } else {
            result = false
        }
        cursor.close()
        db.close()
        return result
    }

    fun addAccount(email: String, password: String, username: String, telephone: String) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_EMAIL, email)
        values.put(COLUMN_USERNAME, username)
        values.put(COLUMN_TELEPHONE, telephone)
        values.put(COLUMN_PASSWORD, password)

        val result = db.insert(TABLE_ACCOUNT, null, values)

        if (result == 0L) {
            Toast.makeText(context, "Register Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(
                context, "Register Success, " +
                        "please login using your new account", Toast.LENGTH_SHORT
            ).show()
        }

        db.close()
    }

    //update user account
    fun updateAccount(email: String, username: String, telephone: String, password: String) {
        val db = this.writableDatabase

        val values = ContentValues()
        values.put(COLUMN_EMAIL, email)
        values.put(COLUMN_USERNAME, username)
        values.put(COLUMN_TELEPHONE, telephone)
        values.put(COLUMN_PASSWORD, password)

        val result =
            db.update(TABLE_ACCOUNT, values, "$COLUMN_EMAIL = ? ", arrayOf(email)).toLong()
        //show message
        if (result == 0L) {
            Toast.makeText(context, "Update data Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Update data Success", Toast.LENGTH_SHORT).show()
        }
        db.close()
    }

    // Di dalam kelas DatabaseHelper
    fun deleteAccount(email: String): Boolean {
        val db = this.writableDatabase
        val result = db.delete(TABLE_ACCOUNT, "$COLUMN_EMAIL = ?", arrayOf(email)).toLong()
        db.close()

        // Jika berhasil dihapus, result akan mengembalikan jumlah baris yang terpengaruh, jika tidak 0.
        return result != 0L
    }


    @SuppressLint("Range")
    fun checkData(email: String): String {
        val columns = arrayOf(COLUMN_USERNAME)
        val db = this.readableDatabase
        val selection = "$COLUMN_EMAIL = ?"
        val selectionArgs = arrayOf(email)
        var username: String = ""

        val cursor = db.query(
            TABLE_ACCOUNT,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        if (cursor.moveToFirst()) {
            username = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME))
        }

        cursor.close()
        db.close()
        return username
    }
    fun addRate(rate: RateModel) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_MENU, rate.menu)
            put(COLUMN_RATING, rate.rate)
            put(COLUMN_SARAN, rate.saran)
            put(COLUMN_WAKTU, System.currentTimeMillis())
        }

        try {
            val result = db.insert(TABLE_RATE, null, values)
            if (result == -1L) {
                Toast.makeText(context, "Add Rating Failed", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Add Rating Success", Toast.LENGTH_SHORT).show()
            }
        } catch (e: SQLiteException) {
            // handle the exception, e.g., log it or show an error message
            Toast.makeText(context, "Error adding rating", Toast.LENGTH_SHORT).show()
        } finally {
            db.close()
        }
    }

    //show rate
    @SuppressLint("Range")
    fun showMenu(): ArrayList<RateModel> {
        val listModel = ArrayList<RateModel>()
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("SELECT * FROM $TABLE_RATE ORDER BY $COLUMN_WAKTU DESC", null)
        } catch (se: SQLiteException) {
            db.execSQL(CREATE_RATE_TABLE)
            return ArrayList()
        }

        var menu: String
        var rating: Float
        var saran: String

        if (cursor.moveToFirst()) {
            do {
                //get data text
                menu = cursor.getString(cursor.getColumnIndex(COLUMN_MENU))
                rating = cursor.getFloat(cursor.getColumnIndex(COLUMN_RATING))
                saran = cursor.getString(cursor.getColumnIndex(COLUMN_SARAN))

                val model = RateModel(menu = menu, rate = rating, saran = saran)
                listModel.add(model)
            } while (cursor.moveToNext())
        }
        cursor?.close() // Penting untuk menutup cursor setelah digunakan
        return listModel
    }
    //show best menu
    @SuppressLint("Range")
    fun showBestMenu(): ArrayList<RateModel2> {
        val listModel2 = ArrayList<RateModel2>()
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            // Ubah query SQL untuk mengurutkan dan mengambil 3 baris pertama berdasarkan COLUMN_RATING
            cursor = db.rawQuery("SELECT $COLUMN_MENU FROM $TABLE_RATE ORDER BY $COLUMN_RATING DESC LIMIT 3", null)
        } catch (se: SQLiteException) {
            db.execSQL(CREATE_RATE_TABLE)
            return ArrayList()
        }

        var menu: String


        if (cursor.moveToFirst()) {
            do {
                //get data text
                menu = cursor.getString(cursor.getColumnIndex(COLUMN_MENU))


                val model2 = RateModel2(menu = menu)
                listModel2.add(model2)
            } while (cursor.moveToNext())
        }
        cursor?.close() // Penting untuk menutup cursor setelah digunakan
        return listModel2
    }



}
