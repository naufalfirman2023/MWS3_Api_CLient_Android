package com.example.app_imddb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_imddb.data.MovieData
import com.example.app_imddb.data.SearcData
import com.example.app_imddb.databinding.FragmentDataBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataFragment : Fragment() {

    private var _binding: FragmentDataBinding? = null
    private val binding get() = _binding!!

    private val list = ArrayList<MovieData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager = LinearLayoutManager(context)

        val bundle = arguments
        val s = bundle?.getString("carimovie")
        val apikey = "625f04ad"

        Client.instances.getMovies(s,apikey).enqueue(object : Callback<SearcData>{
            override fun onResponse(call: Call<SearcData>, response: Response<SearcData>) {
                val responses = response.code()

                response.body()?.let { list.addAll(it.data) }
                val adapter =  MovieAdapter(list)
                binding.rvData.adapter = adapter
            }

            override fun onFailure(call: Call<SearcData>, t: Throwable) {

            }

        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}