package com.geektech.myloveanim.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.myloveanim.MenuViewModel
import com.geektech.myloveanim.data.server.LocalServer
import com.geektech.myloveanim.databinding.FragmentMenuBinding
import com.geektech.myloveanim.ui.adapter.AnimAdapter

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    private var viewModel: MenuViewModel? = null

    private val animAdapter = AnimAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[MenuViewModel::class.java]

        init()
        addList()
    }

    private fun init() {
        binding.rv.adapter = animAdapter
        binding.rv.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun setupObserve(){
        viewModel?.data?.observe(viewLifecycleOwner){
                animAdapter.setupAnimList(it)
        }
    }

    private fun changeVisibleButton(){
        binding.addListAnim.visibility = View.GONE

    }

    private fun addList(){
        binding.addListAnim.setOnClickListener {
            changeVisibleButton()
            viewModel?.setList(LocalServer.getAnimList())
            setupObserve()

        }
    }
}