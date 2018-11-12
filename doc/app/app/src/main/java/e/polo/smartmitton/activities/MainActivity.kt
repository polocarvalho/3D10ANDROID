package e.polo.smartmitton.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import e.polo.smartmitton.R

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

/*

jean-paul.jacquot@schibsted.com

 */
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    var mContinueThread : Boolean = true
    var counter : Int = 0
    val handler : Handler = Handler()

    val thread : Thread = Thread(
            Runnable {

                while(mContinueThread) {

                    Log.d("TEST", " Counter = " + counter)
                    Thread.sleep(10*1000)
                    mContinueThread = false

                    finishNetwork()

                }

            }
    )



    fun finishNetwork( ){

        handler.post(Runnable {
            textView.text = "Finish"
        })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate()")

        start_button.setOnClickListener {

            val intent : Intent = Intent(this, RecipesActivity::class.java)
            startActivity(intent)

        }




        basket.setOnClickListener {

           // val intent : Intent = Intent(this, BasketActivity::class.java)
           // startActivity(intent)
           //Start Network Call

            thread.start()
            textView.text = "Waiting for thread too finish"

        }

    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
    }


    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")

    }


    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")

        mContinueThread = false
        thread.join()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")

    }
}
