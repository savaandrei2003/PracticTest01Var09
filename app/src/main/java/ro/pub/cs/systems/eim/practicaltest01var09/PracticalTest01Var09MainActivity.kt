package ro.pub.cs.systems.eim.practicaltest01var09

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Telephony
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
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


    val activityResultsLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val message = result.data?.getStringExtra("result")
            if (message != null) {
                Toast.makeText(this, "Result: $message", Toast.LENGTH_LONG).show()
            }
        }
    }

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

            val intent = Intent(this, PracticalTest01Var09SecondaryActivity::class.java)
            intent.putExtra("allTermsTextView", allTermsTextView.toString())
            //activityResultsLauncher.launch(intent)
        }




    }

}

