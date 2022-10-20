package com.geektech.myloveanim.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.myloveanim.MainViewModel
import com.geektech.myloveanim.data.server.LocalServer
import com.geektech.myloveanim.databinding.FragmentMenuBinding
import com.geektech.myloveanim.ui.adapter.AnimAdapter

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    private val animAdapter = AnimAdapter()

    private var viewModel: MainViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        init()
        setupObserve()
    }

    private fun init() {

        viewModel?.setList(LocalServer.getAnimList())

        binding.addListAnim.setOnClickListener {
            binding.rv.adapter = animAdapter
            binding.rv.layoutManager = LinearLayoutManager(requireContext())
            changeVisibleButton()

        }
    }

    private fun setupObserve(){
        viewModel?.data?.observe(requireActivity()){
            animAdapter.setupAnimList(it)

        }
    }

    private fun changeVisibleButton(){
        binding.addListAnim.visibility = View.GONE

    }
}