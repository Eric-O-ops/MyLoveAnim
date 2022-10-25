package com.geektech.myloveanim.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.myloveanim.R
import com.geektech.myloveanim.data.server.LocalServer
import com.geektech.myloveanim.databinding.FragmentMenuBinding
import com.geektech.myloveanim.model.AnimModel
import com.geektech.myloveanim.ui.MenuViewModel
import com.geektech.myloveanim.ui.ShareViewModel
import com.geektech.myloveanim.ui.adapter.AnimAdapter
import com.geektech.myloveanim.ui.adapter.OnClick


class MenuFragment : Fragment(), OnClick {

    private lateinit var binding: FragmentMenuBinding
    private var menuViewModel: MenuViewModel? = null
    private var shareViewModel: ShareViewModel? = null
    private val animAdapter = AnimAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuViewModel = ViewModelProvider(requireActivity())[MenuViewModel::class.java]
        shareViewModel = ViewModelProvider(requireActivity())[ShareViewModel::class.java]

        initialization()
        setupObserve()
        addList()
    }

    private fun initialization() {
        binding.rv.adapter = animAdapter
        binding.rv.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun setupObserve() {
        menuViewModel?.data?.observe(viewLifecycleOwner) {
            animAdapter.setupAnimList(it)
        }
    }

    private fun addList() {
        binding.addListAnim.setOnClickListener {
            binding.addListAnim.visibility = View.GONE
            menuViewModel?.setList(LocalServer.getAnimList())
            Log.e("AAA", "list was added")

        }
    }

    // TODO: ShareViewModel
    override fun onShortClick(model: AnimModel) {
//        findNavController().navigate(
//            R.id.action_menuFragment_to_detailFragment
//
//        )
    }
}