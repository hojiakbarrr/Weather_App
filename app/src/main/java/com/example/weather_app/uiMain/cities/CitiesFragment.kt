package com.example.weather_app.uiMain.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather_app.Adapter.Adapter
import com.example.weather_app.data.Weather
import com.example.weather_app.databinding.FragmentCitiesBinding


class CitiesFragment : Fragment() {

    private var _binding: FragmentCitiesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : CityViewModel
    lateinit var adapter: Adapter
    var allCities = ArrayList<Weather>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCitiesBinding.inflate(inflater,container,false)

        viewModel = ViewModelProvider(this).get(CityViewModel::class.java)
        adapter = Adapter()
        viewModel.getWeather1()
        viewModel.getWeather2()
        viewModel.getWeather3()
        viewModel.getWeather4()


        viewModel.liveDataForCurrent1
        viewModel.liveDataForCurrent2
        viewModel.liveDataForCurrent3
        viewModel.liveDataForCurrent4

        viewModel.liveDataForCurrent1.observe(viewLifecycleOwner){
            allCities.add(it)
//            adapter = Adapter()
//            adapter.cityList = allCities
//            adapter.setList(allCities)
//            binding.recyc.layoutManager = LinearLayoutManager(requireContext())
//            binding.recyc.setHasFixedSize(true)
//            binding.recyc.adapter = adapter
            adapter.notifyDataSetChanged()
        }
        viewModel.liveDataForCurrent2.observe(viewLifecycleOwner){
            allCities.add(it)
            adapter.notifyDataSetChanged()
        }
        viewModel.liveDataForCurrent3.observe(viewLifecycleOwner){
            allCities.add(it)
            adapter.notifyDataSetChanged()
        }
        viewModel.liveDataForCurrent4.observe(viewLifecycleOwner){
            allCities.add(it)
            adapter.notifyDataSetChanged()
        }

        adapter = Adapter()
        adapter.cityList = allCities
        adapter.setList(allCities)
        binding.recyc.layoutManager = LinearLayoutManager(requireContext())
        binding.recyc.setHasFixedSize(true)
        binding.recyc.adapter = adapter
        adapter.notifyDataSetChanged()







        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

}