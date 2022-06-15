package com.example.ps_shop_android.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProductDbModel::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {
    companion object {

        private var db: ProductDatabase? = null
        private const val DB_NAME = "products.db"
        private val LOCK = Any()

        fun getInstance(context: Context): ProductDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        ProductDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun productDao(): ProductDao
}
