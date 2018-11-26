package e.polo.smartmitton.data.DAO

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import android.arch.persistence.room.Query
import e.polo.smartmitton.activities.Ingredient


@Dao
interface IngredientDao{

    @Query("select * from ingredient")
    fun loadAllIngredients(): List<Ingredient>

    @Insert(onConflict = IGNORE)
    fun insertIngredient(ingredient: Ingredient)
}

