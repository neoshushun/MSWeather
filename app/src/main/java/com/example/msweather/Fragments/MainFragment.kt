package com.example.msweather.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import com.example.msweather.MainActivity
import com.example.msweather.R
import com.example.msweather.adapters.VpAdapter
import com.example.msweather.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.util.jar.Manifest


class MainFragment : Fragment() {
    private val fList = listOf(
        HoursFragment.newInstance(), DaysFragment.newInstance()
    )
    private val tList = listOf("Часы","Дни")
    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    /*
        Функция проверки наличия разрешений
         */
    private fun permissionListener(){
        pLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            Toast.makeText(activity, "Result is $it", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        init()
    }
    /*
    Функция переключения между часами и днями с сохранением названий на кнопках ViewPager(vp)
    fList это список фрагментов для переключения
    tList это список с названиями кнопок при переключении между фрагментами
     */
    private fun init() = with(binding) {
        val adapter = VpAdapter(activity as FragmentActivity, fList)
        vp.adapter = adapter
        TabLayoutMediator(tabLayout, vp){
            tab, pos -> tab.text = tList[pos]

        }.attach()
    }

    private fun checkPermission(){
        if (!isPermissionGranted(android.Manifest.permission.ACCESS_FINE_LOCATION)){
            permissionListener()
            pLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}