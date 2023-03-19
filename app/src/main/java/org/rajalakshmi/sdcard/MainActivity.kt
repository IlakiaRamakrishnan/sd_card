package org.rajalakshmi.sdcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName : EditText = findViewById(R.id.editTextTextPersonName)
        val etCGPA : EditText = findViewById(R.id.editTextTextPersonName2)

        val btSave : Button = findViewById(R.id.button)
        val btLoad : Button = findViewById(R.id.button2)

        btSave.setOnClickListener {
            val name = etName.text.toString()
            val cgpa = etCGPA.text.toString()

            val file = File(getExternalFilesDir(null),"student.txt")
            val fos= FileOutputStream(file, false)
            fos.write("$name,$cgpa".toByteArray())
            fos.close()
            etName.setText("")
            etCGPA.setText("")

        }
        btLoad.setOnClickListener {
            val file = File(getExternalFilesDir(null),"student.txt")
            val fis = FileInputStream(file)
            val isr = InputStreamReader(fis)
            val br = BufferedReader(isr)
            val line : String
            line = br.readLine()
            var part = line.split(",")
            etName.setText(part[0])
            etName.setText(part[1])
            fis.close()

        }

    }



}