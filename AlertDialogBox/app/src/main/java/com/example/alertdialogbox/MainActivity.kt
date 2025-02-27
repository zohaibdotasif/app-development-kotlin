package com.example.alertdialogbox

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val showBtn = findViewById<Button>(R.id.showBtn)

        showBtn.setOnClickListener {
            showAlertDialogBoxWithToastOnSelection(
                "Snapchat",
                "Do you want to uninstall this app?",
                "Yes",
                "The app is successfully uninstalled.",
                "No",
                null
            )
        }
    }

    private fun showAlertDialogBoxWithToastOnSelection(
        title: String,
        message: String,
        positiveBtnTitle:String,
        positiveBtnToastMessage: String?,
        negativeBtnTitle: String,
        negativeBtnToastMessage: String?) {
        AlertDialog.Builder(this).setTitle(title).setMessage(message).setPositiveButton(positiveBtnTitle){ dialog, _ ->
            dialog.dismiss()
            if (positiveBtnToastMessage != null) {
                Toast.makeText(this, positiveBtnToastMessage, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "You have pressed $positiveBtnTitle.", Toast.LENGTH_SHORT).show()
            }
        }.setNegativeButton(negativeBtnTitle) {dialog, _ ->
            dialog.dismiss()
            if (negativeBtnToastMessage != null){
                Toast.makeText(this, negativeBtnToastMessage, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "You have pressed $negativeBtnTitle.", Toast.LENGTH_SHORT).show()
            }
        }.create().show()
    }
}