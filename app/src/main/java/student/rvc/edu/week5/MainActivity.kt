package student.rvc.edu.week5

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var txtName = findViewById<EditText>(R.id.txtName)
        var txtEmail = findViewById<EditText>(R.id.txtEmail)
        var txtShow = findViewById<TextView>(R.id.txtShow)
        var rbFemale = findViewById<RadioButton>(R.id.rbFemale)
        var rbMale = findViewById<RadioButton>(R.id.rbMale)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)

        txtName.requestFocus()


        btnSubmit.setOnClickListener{
            if (rbFemale.isChecked) txtShow.text = "Hello, ${txtName.text}, the womens lounge is on first floor. We will " +
                    "send an email of meeting agenda to email : ${txtEmail.text}"
            if (rbMale.isChecked) txtShow.text = "Hello, ${txtName.text}, the mens lounge is on the second floor. We will " +
                    "send an email of meeting agenda to email : ${txtEmail.text}"
            hideKeyboard()
            txtName.setText("")
            txtEmail.setText("")
            txtName.requestFocus()
        }


        //Fire hidekeyboard when user taps outside any text object
        //Place right before end right bracket function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }

    }

    // function to hide keyboard goes right before the last right bracket of Class MainActivity
//import android.content.Context
//import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }




}
