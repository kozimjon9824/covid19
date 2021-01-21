package com.example.covidinfo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.example.covidinfo.databinding.ActivityMainBinding
import com.example.covidinfo.model.Global
import com.example.covidinfo.model.StateInfo
import com.example.covidinfo.ui.ItemAdapter
import com.example.covidinfo.ui.MainViewModel
import com.example.covidinfo.util.Resource
import com.mikepenz.itemanimators.ScaleUpAnimator
import com.mikepenz.itemanimators.SlideUpAlphaAnimator
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


        viewModel.getData().observe(this)
        {
            if (it.status==Resource.Status.SUCCESS){

                Log.d(TAG, "onCreate: ${it.data!!.global.newDeaths}")

                loadDataToViewGlobal(it.data.global)

                val adapter=ItemAdapter(it.data.countries)
                binding.recyclerView.adapter=adapter
                binding.recyclerView.itemAnimator=SlideUpAlphaAnimator()
                binding.recyclerView.itemAnimator=ScaleUpAnimator()



            }
            else if (it.status==Resource.Status.ERROR){
                Log.d(TAG, "onCreate: ${it.message}")
                Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
            }
        }


        preferences=getSharedPreferences("City", Context.MODE_PRIVATE)
        selectedId=preferences.getInt("City",selectedId)

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

    private fun loadDataToViewGlobal(list:Global){

      binding.totalCases.text=list.totalCon.toString()
      binding.totalDeads.text=list.totalDeaths.toString()
      binding.totalRecovered.text=list.totalRecovered.toString()
    }

    private fun loadDataToViewMyCountry(list:StateInfo){
        binding.totalCases.text=list.totalConfirmed.toString()
        binding.totalDeads.text=list.totalDeath.toString()
        binding.totalRecovered.text=list.totalRecovered.toString()

    }

}
