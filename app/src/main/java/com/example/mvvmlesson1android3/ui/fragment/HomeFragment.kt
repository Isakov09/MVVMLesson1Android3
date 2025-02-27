package com.example.mvvmlesson1android3.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mvvmlesson1android3.R
import com.example.mvvmlesson1android3.databinding.FragmentHomeBinding
import com.example.mvvmlesson1android3.ui.viewmodels.SignModel


class HomeFragment : Fragment() {

    private lateinit var viewModel: SignModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(SignModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            binding.tvName.text = user.username
            binding.tvAge.text = user.age.toString()
            binding.tvEmail.text = user.email
            binding.tvPassword.text = user.password
        })

        binding.btnEdit.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment2_to_editFragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}