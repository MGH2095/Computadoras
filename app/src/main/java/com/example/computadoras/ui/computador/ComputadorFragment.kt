package com.example.computadoras.ui.computador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.computadoras.R
import com.example.computadoras.databinding.FragmentComputadorBinding
import com.example.computadoras.viewmodel.ComputadorViewModel

class ComputadorFragment : Fragment() {

    private var _binding: FragmentComputadorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val computadorViewModel =
            ViewModelProvider(this).get(ComputadorViewModel::class.java)

        _binding = FragmentComputadorBinding.inflate(inflater, container, false)
        binding.fbAgregar.setOnClickListener {
            findNavController().navigate(R.id.action_nav_computador_to_addComputadorFragment)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}