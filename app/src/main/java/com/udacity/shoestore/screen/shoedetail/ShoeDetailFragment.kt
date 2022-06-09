package com.udacity.shoestore.screen.shoedetail

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.DigitsKeyListener
import android.text.method.KeyListener
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screen.shoelist.ShoeListViewModel
import kotlinx.android.synthetic.main.shoe_detail_fragment.*
import kotlinx.android.synthetic.main.shoe_item.*


class ShoeDetailFragment : Fragment() {
    private   lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: ShoeDetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail_fragment, container, false)
        binding.txtShoeSize.setInputType(InputType.TYPE_CLASS_NUMBER);
        val keyListener: KeyListener = DigitsKeyListener.getInstance("1234567890")
        binding.txtShoeSize.setKeyListener(keyListener)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java);
        binding.lifecycleOwner = this
        binding.shoeViewModal = viewModel

        binding.txtShoeName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                viewModel.onChangeName(s.toString())
            }
        })
        binding.txtCompany.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                viewModel.onChangeCompany(s.toString())
            }
        })
        binding.txtShoeSize.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                viewModel.onChangeSize(s.toString())
            }
        })
        binding.txtDescription.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                viewModel.onChangeDesc(s.toString())
            }
        })
        binding.btnSave.setOnClickListener {
            var shoeName: String = viewModel.nameShoe.value.toString()
            var shoeSize: String = viewModel.sizeShoe.value.toString();
            var shoeCompany: String = viewModel.companyShoe.value.toString() ;
            var shoeDescription: String =   viewModel.descShoe.value.toString();
            // check  null
            if(shoeName !== null && shoeSize!== null && shoeCompany !== null && shoeDescription !== null){
                viewModel.isSubmit(true);
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListDestination())

            }else{
                Toast.makeText(this.activity,"Please fill all field", Toast.LENGTH_LONG).show()
            }

        }


        binding.btnCancel.setOnClickListener {
            viewModel.isSubmit(false);
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListDestination())
        }
        return binding.root
    }
}
