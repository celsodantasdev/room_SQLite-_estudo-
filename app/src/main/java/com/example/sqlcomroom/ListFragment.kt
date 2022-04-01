package com.example.sqlcomroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqlcomroom.adapter.UserAdapter
import com.example.sqlcomroom.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(
            layoutInflater, container, false
        )

        val adapter = UserAdapter()

        binding.recyclerUser.layoutManager = LinearLayoutManager(context)
        binding.recyclerUser.adapter = adapter
        binding.recyclerUser.setHasFixedSize(true)

        return binding.root
    }

}