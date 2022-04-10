package com.example.flaguess

class DAO {

    fun fiveQuest(vt: Database): ArrayList<Flags> {
        val arrayList = ArrayList<Flags>()
        val dbw = vt.writableDatabase
        val cursor = dbw.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5", null)
        while (cursor.moveToNext()) {
            val flag = Flags(
                cursor.getInt(cursor.getColumnIndexOrThrow("bayrak_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("bayrak_ad")),
                cursor.getString(cursor.getColumnIndexOrThrow("bayrak_resim"))
            )
            arrayList.add(flag)
        }
        return arrayList
    }

    fun wrongAnswer(vt: Database, bayrak_id: Int): ArrayList<Flags> {
        val arrayList = ArrayList<Flags>()
        val dbw = vt.writableDatabase
        val cursor = dbw.rawQuery(
            "SELECT * FROM bayraklar WHERE bayrak_id != $bayrak_id ORDER BY RANDOM() LIMIT 3",
            null
        )
        while (cursor.moveToNext()) {
            val flag = Flags(
                cursor.getInt(cursor.getColumnIndexOrThrow("bayrak_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("bayrak_ad")),
                cursor.getString(cursor.getColumnIndexOrThrow("bayrak_resim"))
            )
            arrayList.add(flag)
        }
        return arrayList
    }
}