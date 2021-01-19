package com.example.covidinfo

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.observe
import com.example.covidinfo.databinding.ActivityMainBinding
import com.example.covidinfo.model.Global
import com.example.covidinfo.model.StateData
import com.example.covidinfo.model.StateInfo
import com.example.covidinfo.ui.MainViewModel
import com.example.covidinfo.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
    private var selectedId=1
    private lateinit var preferences: SharedPreferences
    private val TAG="AAA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.visibility= View.VISIBLE


        viewModel.getData().observe(this)
        {
            if (it.status==Resource.Status.SUCCESS){

                Log.d(TAG, "onCreate: ${it.data!!.global.newDeaths}")
              loadDataToViewGlobal(it.data.global)
            }
            else if (it.status==Resource.Status.ERROR){
                Log.d(TAG, "onCreate: ${it.message}")
                Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
            }
            binding.progressBar.visibility= View.INVISIBLE
        }

        preferences=getSharedPreferences("City", Context.MODE_PRIVATE)
        selectedId=preferences.getInt("City",selectedId)


        binding.cityName.setOnClickListener {
            //openDialog()
        }

    /*    binding.buttonAll.setOnClickListener {
            loadDataToViewGlobal()
        }
        binding.buttonOne.setOnClickListener {
            loadDataToView(data.countries[selectedId])
        }
*/

    }

/*
    private fun openDialog(){
        //val arrayList=list.map { it.country }
        val builder=AlertDialog.Builder(this)
        builder.setTitle("select state")
        builder.setSingleChoiceItems((arrayList).toTypedArray(),0,DialogInterface.OnClickListener { dialog, which ->
            selectedId=which
        })
        builder.setPositiveButton("OK"){dialog, which ->
            val edit=preferences.edit()
            edit.clear()
            edit.putInt("ID",selectedId)
            edit.apply()

            loadDataToView(list[selectedId])
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel"){dialog, which -> dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
*/

    private fun loadDataToView(list:StateInfo){
        binding.dailyIncrement.text=list.newConfirmed.toString()
        binding.dailyIncrementDead.text=list.newDeath.toString()
        binding.dailyIncrementRecovered.text=list.newRecovered.toString()
        binding.totalConfirmedCases.text=list.totalConfirmed.toString()
        binding.totalConfirmedDead.text=list.totalDeath.toString()
        binding.totalConfirmedRecovered.text=list.totalRecovered.toString()

    }

    private fun loadDataToViewGlobal(list:Global){

        binding.dailyIncrement.text=list.newCon.toString()
        binding.dailyIncrementDead.text=list.newDeaths.toString()
        binding.dailyIncrementRecovered.text=list.newRecovered.toString()
        binding.totalConfirmedCases.text=list.totalCon.toString()
        binding.totalConfirmedDead.text=list.totalDeaths.toString()
        binding.totalConfirmedRecovered.text=list.totalRecovered.toString()

    }

}
