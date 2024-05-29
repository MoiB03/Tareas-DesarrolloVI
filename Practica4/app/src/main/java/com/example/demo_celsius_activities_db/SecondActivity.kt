package com.example.demo_celsius_activities_db

import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, Fragment_Resultados())
            .commit()

        val resultado = intent.getDoubleExtra("RESULTADO", 0.0)
        val conversion = intent.getStringExtra("CONVERSION")

        val dbHelper = DatabaseHelper(this)
        if (conversion != null) {
            dbHelper.addConversionResult(resultado, conversion)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.csv -> {
                exportToCSV()
                true
            }
            R.id.xls -> {
                exportToExcel(false)
                true
            }
            R.id.xlsx -> {
                exportToExcel(true)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun exportToCSV() {
        val dbHelper = DatabaseHelper(this)
        val results = dbHelper.getAllResults()

        val csvFile = File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "conversiones.csv")
        try {
            FileOutputStream(csvFile).use { fos ->
                results.forEach {
                    val (id, result, name) = it
                    fos.write("$id,$result,$name\n".toByteArray())
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun exportToExcel(isXLSX: Boolean) {
        val dbHelper = DatabaseHelper(this)
        val results = dbHelper.getAllResults()

        val workbook: Workbook = if (isXLSX) {
            XSSFWorkbook()
        } else {
            HSSFWorkbook()
        }

        val sheet = workbook.createSheet("Conversiones")
        var rowIndex = 0
        val header = sheet.createRow(rowIndex++)
        header.createCell(0).setCellValue("ID")
        header.createCell(1).setCellValue("Resultado")
        header.createCell(2).setCellValue("Nombre")

        results.forEach {
            val (id, result, name) = it
            val row = sheet.createRow(rowIndex++)
            row.createCell(0).setCellValue(id.toDouble())
            row.createCell(1).setCellValue(result)
            row.createCell(2).setCellValue(name)
        }

        val fileName = if (isXLSX) "conversiones.xlsx" else "conversiones.xls"
        val excelFile = File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName)
        try {
            FileOutputStream(excelFile).use { fos ->
                workbook.write(fos)
            }
            workbook.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
