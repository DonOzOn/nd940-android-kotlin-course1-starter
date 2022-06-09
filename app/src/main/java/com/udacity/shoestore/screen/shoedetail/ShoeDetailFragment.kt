package com.udacity.shoestore.screen.shoedetail

import android.os.Bundle
import android.text.InputType
import android.text.method.DigitsKeyListener
import android.text.method.KeyListener
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_detail_fragment.*


class ShoeDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: ShoeDetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false)
        binding.txtShoeSize.setInputType(InputType.TYPE_CLASS_NUMBER);
        val keyListener: KeyListener = DigitsKeyListener.getInstance("1234567890")
        binding.txtShoeSize.setKeyListener(keyListener)
        binding.btnSave.setOnClickListener {
            var shoeName: String = binding.txtShoeName2.text.toString();
            var shoeSize: String = binding.txtShoeSize.text.toString();
            var shoeCompany: String = binding.txtCompany.text.toString();
            var shoeDescription: String = binding.txtCompany.text.toString();
            if(shoeName !== null && shoeSize!== null && shoeCompany !== null && shoeDescription !== null){
                val newShoe: Shoe = Shoe(binding.txtShoeName2.text.toString()
                    ,binding.txtShoeSize?.text.toString().toDouble()
                    , binding.txtCompany?.text.toString() ,
                    binding.txtDescription.text.toString())
                Log.i("newShoe", newShoe.toString())
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListDestination(newShoe, true))
            }else{
                Toast.makeText(this.activity,"Please fill all field", Toast.LENGTH_LONG).show()
            }

        }
        binding.btnCancel.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListDestination(Shoe("",0.0,"","")))
        }
        return binding.root
    }
}
