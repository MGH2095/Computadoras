package com.example.computadoras.ui.computador

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.computadoras.R
import com.example.computadoras.databinding.FragmentAddComputadorBinding
import com.example.computadoras.model.Computador
import com.example.computadoras.viewmodel.ComputadorViewModel


class AddComputadorFragment : Fragment() {
    private lateinit var computadorViewModel: ComputadorViewModel

    private var _binding: FragmentAddComputadorBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        computadorViewModel = ViewModelProvider(this)[ComputadorViewModel::class.java]
        _binding = FragmentAddComputadorBinding.inflate(inflater, container, false)
        binding.btAgregar.setOnClickListener {
            insertarComputador()
        }
        return binding.root
    }

    private fun insertarComputador() {
        val marca=binding.etMarca.text.toString()
        val modelo=binding.etModelo.text.toString()
        val serie=binding.etSerie.text.toString()
        val almacen=binding.etAlmacen.text.toString()
        val ram=binding.etRam.text.toString()
        val computador= Computador(0,marca,modelo,serie,almacen, ram ,rutaImagen = "")
        computadorViewModel.addComputador(computador)
        Toast.makeText(requireContext(),getString(R.string.msg_agregado),Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_addComputadorFragment_to_nav_computador)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}