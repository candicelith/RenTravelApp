package com.example.rentravelapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.rentravelapp.databinding.FragmentJenisBinding

class JenisFragment : Fragment() {

    private var _binding: FragmentJenisBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJenisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val ticket =
                resources.getStringArray(R.array.ticket)
            val adapterTicket = ArrayAdapter(requireContext(),
                android.R.layout.simple_spinner_item, ticket)

            adapterTicket.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerTicket.adapter = adapterTicket

            btnDone.setOnClickListener {
                findNavController().apply {
                    previousBackStackEntry?.savedStateHandle?.set(
                        "ticket", spinnerTicket.selectedItem.toString()
                    )
                }.navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}