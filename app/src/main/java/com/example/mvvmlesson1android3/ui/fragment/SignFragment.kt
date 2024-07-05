package com.example.mvvmlesson1android3.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mvvmlesson1android3.R
import com.example.mvvmlesson1android3.databinding.FragmentSignBinding
import com.example.mvvmlesson1android3.ui.viewmodels.SignModel

class SignFragment : Fragment() {


    private lateinit var viewModel: SignModel
    private var _binding: FragmentSignBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SignModel::class.java)

        binding.btnSave.setOnClickListener {
            val username = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toInt()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            viewModel.registerUser(username, age, email, password)

            findNavController().navigate(R.id.action_signFragment2_to_homeFragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}