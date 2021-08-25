package com.example.nagwatask.presentation.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nagwatask.data.remote.response.MaterialResponse
import com.example.nagwatask.databinding.FragmentHomeBinding
import com.example.nagwatask.domin.Resource
import com.example.nagwatask.presentation.viewmodel.HomeViewModel
import com.example.nagwatask.presentation.viewmodel_factory.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var homeViewModel: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun initViewModel() {
        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        homeViewModel.fetchMaterialsLiveData().observe(this,materialsObserver)
    }

    private val materialsObserver: Observer<Resource<MaterialResponse?>> =
        Observer {
            when (it.status) {
                Resource.Status.LOADING -> {

                }

                Resource.Status.SUCCESS -> {
                    Log.d("test", ": $it")
                }

                Resource.Status.API_ERROR -> {
                    it.throwable
                }

                Resource.Status.DOMAIN_ERROR -> {
                    it.throwable
                }
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getMaterials()
    }
}