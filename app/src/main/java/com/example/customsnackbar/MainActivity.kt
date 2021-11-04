package com.example.customsnackbar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar.SnackbarLayout


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val btn: Button by lazy {
        findViewById(R.id.btn)
    }

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)

        btn.setOnClickListener {
            val customSnackBar = Snackbar.make(constraintLayout, "", Snackbar.LENGTH_LONG)
            val layout = customSnackBar.view as SnackbarLayout

            val customSnackBarView = layoutInflater.inflate(
                R.layout.activity_snack_bar,
                findViewById<View>(R.id.custom_snackBar_container) as? ViewGroup
            )

            val textView = customSnackBarView.findViewById<TextView>(R.id.customSnackText)

            textView.text = resources.getText(R.string.stringExampleSnackView)
            layout.setPadding(0, 0, 0, 0)

            layout.addView(customSnackBarView, 0)
            customSnackBar.show()
//            val snack = Snackbar.make(it,"This is a simple Snackbar",Snackbar.LENGTH_LONG)
//            snack.show()
        }
    }

    override fun onClick(view: View?) {
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)
    }
}

