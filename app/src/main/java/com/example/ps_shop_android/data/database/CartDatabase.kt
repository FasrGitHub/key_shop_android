package com.example.ps_shop_android.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CartDbModel::class], version = 1, exportSchema = false)
abstract class CartDatabase : RoomDatabase() {
    companion object {

        private var db: CartDatabase? = null
        private const val DB_NAME = "cart.db"
        private val LOCK = Any()

        fun getInstance(context: Context): CartDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        CartDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun cartDao(): CartDao
}
