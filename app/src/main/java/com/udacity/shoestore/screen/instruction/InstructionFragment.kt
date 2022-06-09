package com.udacity.shoestore.screen.instruction

import com.udacity.shoestore.R

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.InstructionFragmentBinding
import com.udacity.shoestore.databinding.LoginFragmentBinding
import com.udacity.shoestore.models.Shoe


/**
 * Fragment for the starting or title screen of the app
 */
class InstructionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.instruction_fragment, container, false)
        binding.btnGoToShop.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionToShoeList())

        }
        return binding.root
    }
}
