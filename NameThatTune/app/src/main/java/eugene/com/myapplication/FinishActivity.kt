package eugene.com.myapplication

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.system.exitProcess

class FinishActivity : AppCompatActivity() {

    var FinishPointText:TextView?=null
    var ResultText:TextView?=null
    var RestartBtn:Button?=null
    var Final=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        FinishPointText=findViewById(R.id.finish_point_text) as TextView
        ResultText=findViewById(R.id.finish_text) as TextView
        RestartBtn=findViewById(R.id.restart_btn) as Button

        var PlayerName1=getStringPrefereces(DuetStartActivity.SHARED_NAME_PLAYER1)
        var PlayerName2=getStringPrefereces(DuetStartActivity.SHARED_NAME_PLAYER2)

        var PointPlayer1=getIntPrefereces(BetActivity.SHARED_POINT_PLAYER1)
        var PointPlayer2=getIntPrefereces(BetActivity.SHARED_POINT_PLAYER2)

        FinishPointText!!.text=PointPlayer1.toString()+":"+PointPlayer2.toString()

        if (PointPlayer1>PointPlayer2) {
            ResultText!!.text="Выиграл игрок "+PlayerName1
        }
        else if (PointPlayer2>PointPlayer1){
                    ResultText!!.text="Выиграл игрок "+PlayerName2
            }
            else ResultText!!.text="Ничья!"

        RestartBtn!!.setOnClickListener {
            var intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setStringPreferences(key:String,name:String) {
        val sh = getSharedPreferences(DuetStartActivity.SHARED_KEY, Context.MODE_PRIVATE)
        val editor = sh.edit()
        editor.putString(key, name)
        editor.apply()
    }

    private  fun getStringPrefereces(key:String):String{
        val sh=getSharedPreferences(DuetStartActivity.SHARED_KEY, Context.MODE_PRIVATE)
        return sh.getString(key,"0")
    }

    public fun setIntPreferences(key:String,bet:Int) {
        val sh = getSharedPreferences(DuetStartActivity.SHARED_KEY, Context.MODE_PRIVATE)
        val editor = sh.edit()
        editor.putInt(key, bet)
        editor.apply()
    }

    public  fun getIntPrefereces(key:String):Int{
        val sh=getSharedPreferences(DuetStartActivity.SHARED_KEY, Context.MODE_PRIVATE)
        return sh.getInt(key,0)
    }

}
