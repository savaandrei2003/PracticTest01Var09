package ro.pub.cs.systems.eim.practicaltest01var09

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.StringTokenizer


class PracticalTest01Var09MainActivity : AppCompatActivity() {

    private var addButton: Button? = null
    private var computeButton: Button? = null
    private var nextTermEditText: EditText? = null
    private var allTermsTextView: TextView? = null

    private var sum: String? = null
    private var number: String? = null
    private var sumSum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var09_main)

        addButton = findViewById(R.id.AddButton)
        computeButton = findViewById(R.id.ComputeButton)
        nextTermEditText = findViewById(R.id.NextTermEditText)
        allTermsTextView = findViewById(R.id.AllTermsTextView)

        addButton?.setOnClickListener {
            number = nextTermEditText?.text.toString()
            sum = allTermsTextView?.text.toString()
            sum = if (sum!!.isEmpty()) {
                number
            } else {
                "$sum + $number"
            }
            allTermsTextView?.text = sum
            nextTermEditText?.setText("")
        }

        computeButton?.setOnClickListener {
            sum = allTermsTextView?.text.toString()
            sumSum = 0
            sum?.split(" + ")?.forEach { token ->
                sumSum += token.toInt()
            }
            Toast.makeText(this, sumSum.toString(), Toast.LENGTH_LONG).show()
        }
    }

}

