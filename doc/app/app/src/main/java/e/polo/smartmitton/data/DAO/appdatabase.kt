package e.polo.smartmitton.data.DAO

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.provider.CalendarContract
import e.polo.smartmitton.activities.Ingredient
import java.security.AccessControlContext

@Database(entities = arrayOf(Ingredient::class), version = 1)
abstract class appdatabase : RoomDatabase(){

        abstract fun ingredientModel(): IngredientDao

        companion object {
            private var INSTANCE: appdatabase?= null

            fun getInMemoryDatabase(context: Context): appdatabase? {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            appdatabase::class.java,"datanase-name").allowMainThreadQueries().build()

                }

                return INSTANCE
            }
        }
}