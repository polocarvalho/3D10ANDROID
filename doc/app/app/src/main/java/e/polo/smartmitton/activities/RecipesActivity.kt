package e.polo.smartmitton.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ArrayAdapter
import e.polo.smartmitton.R

import kotlinx.android.synthetic.main.activity_recipes.*

class RecipesActivity : AppCompatActivity() ,RecipesCallBack {

    val handler = Handler()

    override fun onRecipesReceived(recipes: ArrayList<String>) {

        handler.post(Runnable {
            val adapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1,
                    recipes)

            recipes_list.adapter = adapter
        })
    }

    private var mGetData : businessManagerInterface = getDataMock(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        mGetData.getRecipes(this)

    }


}

interface RecipesCallBack {
    fun onRecipesReceived(recipes : ArrayList<String>)
}
