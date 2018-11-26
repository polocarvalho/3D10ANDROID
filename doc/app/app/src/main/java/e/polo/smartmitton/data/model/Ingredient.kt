package e.polo.smartmitton.activities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "Ingredient")
class Ingredient{

    @PrimaryKey
    @NonNull

    var mName : String

    constructor(name: String){
        mName = name
    }

}