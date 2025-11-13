package ro.pub.cs.systems.eim.practicaltest01var09

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var09SecondaryActivity : AppCompatActivity() {
    private var sumSum = 0
    private var sum: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val text = intent.getStringExtra("allTermsTextView")

        sum =text.toString()
        sumSum = 0
        sum?.split(" + ")?.forEach { token ->
            sumSum += token.toInt()
        }

        setResult(RESULT_OK, Intent().putExtra("result", text))
        finish()



    }


}