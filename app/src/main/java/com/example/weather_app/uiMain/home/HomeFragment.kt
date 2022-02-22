package com.example.weather_app.uiMain.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.weather_app.R
import com.example.weather_app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.getWeather()

        viewModel.liveDataForCurrent.observe(viewLifecycleOwner){
            binding.apply {
                latit.text = it.coord.lat.toString()
                longtit.text = it.coord.lon.toString()
                tempFact.text = it.main.temp.toString()
                tempFeel.text = it.main.feelsLike.toString()
                city.text = it.name
            }
        }


        binding.refresh.setOnClickListener {
            viewModel.liveDataForCurrent.observe(viewLifecycleOwner){
                binding.apply {
                    latit.text = it.coord.lat.toString()
                    longtit.text = it.coord.lon.toString()
                    tempFact.text = it.main.temp.toString()
                    tempFeel.text = it.main.feelsLike.toString()
                    city.text = it.name
                    Toast.makeText(requireContext(), "Обновление страницы", Toast.LENGTH_SHORT).show()
                }
            }
        }

//        viewModel.getCurrentWeather()
//        viewModel.getListOfCities()
//   старое видео
//        viewModel.subscribeCity().observe(viewLifecycleOwner) {
//            binding.city.text = it.city
//            binding.longtit.text = it.longitude
//            binding.latit.text = it.latitude
//            binding.tempFact.text = it.temperature
//            binding.tempFeel.text = it.feelsLike
//        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}