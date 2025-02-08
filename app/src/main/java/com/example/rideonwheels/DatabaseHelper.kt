package com.example.rideonwheels

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context:Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private val CREATE_TABLE_USER = "CREATE TABLE $TABLE_USER (" +
            "$COL_USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$COL_USER_FIRSTNAME TEXT," +
            "$COL_USER_LASTNAME TEXT," +
            "$COL_USER_EMAIL TEXT," +
            "$COL_USER_MOBILE INT," +
            "$COL_USER_PASSWORD TEXT," +
            "$COL_USER_GENDER TEXT)"

    private val DROP_TABLE_USER = "DROP TABLE IF EXISTS $TABLE_USER"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_USER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(DROP_TABLE_USER)
    }


    fun registerUser(user : User) {
        val db = this.writableDatabase
        val value = ContentValues()
        value.put(COL_USER_FIRSTNAME,user.firstname)
        value.put(COL_USER_LASTNAME,user.lastname)
        value.put(COL_USER_EMAIL,user.email)
        value.put(COL_USER_MOBILE,user.mobile)
        value.put(COL_USER_PASSWORD,user.password)
        value.put(COL_USER_GENDER,user.gender)

        db.insert(TABLE_USER, null,value)
        db.close()
    }

    fun loginUser(email: String, password: String): Boolean {
        val columns = arrayOf(COL_USER_ID)
        val db = this.readableDatabase
        val selection = "$COL_USER_EMAIL = ? AND $COL_USER_PASSWORD = ?"
        val selectionArgs = arrayOf(email, password)

        val cursor = db.query(
            TABLE_USER,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null,
        )

        val cursorCount = cursor.count
        cursor.close()
        db.close()

        return cursorCount > 0
    }
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "user.db"
        private const val TABLE_USER = "tbl_user"

        private const val COL_USER_ID = "user_id"
        private const val COL_USER_FIRSTNAME = "user_firstname"
        private const val COL_USER_LASTNAME = "user_lastname"
        private const val COL_USER_EMAIL = "user_email"
        private const val COL_USER_MOBILE = "user_mobile"
        private const val COL_USER_GENDER = "user_gender"
        private const val COL_USER_PASSWORD = "user_password"
    }
}