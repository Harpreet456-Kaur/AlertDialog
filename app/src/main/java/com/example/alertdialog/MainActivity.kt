package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var floatingBtn: FloatingActionButton
    lateinit var tvDialog: TextView
    lateinit var etNum: EditText
    var value = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        floatingBtn=findViewById(R.id.floatingBtn)
        tvDialog=findViewById(R.id.tvDialog)
        etNum=findViewById(R.id.etNum)

        floatingBtn.setOnClickListener {
            val dialog =AlertDialog.Builder(this)
            dialog.setTitle("Alert")
            dialog.setMessage(resources.getString(R.string.app_name))
            dialog.setPositiveButton("Add") { _, _ ->
                value += 10
                etNum.setText(value.toString())
            }
            dialog.setNegativeButton("Multiply") { _, _ ->
                value *= 5
                etNum.setText(value.toString())
            }
            dialog.setNeutralButton("Reset") { _, _ ->
                value = 0
                etNum.setText(value.toString())
            }
            dialog.show()
            dialog.setCancelable(false)
        }
    }
}