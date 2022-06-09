package com.udacity.shoestore.screen.shoelist

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
//import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment : Fragment() {
    private lateinit var  binding: ShoeListFragmentBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list_fragment, container, false)
        Log.i("ShoeListFragment111111","ShoeListFragment created")
        binding.lifecycleOwner = this
        binding.shoeListViewModel = viewModel
        viewModel.submit.observe(viewLifecycleOwner, Observer { isSubmit ->
            if (isSubmit === true) {
                viewModel.addShoe(
                    Shoe(
                        viewModel.nameShoe.value.toString(),
                        viewModel.sizeShoe.value.toString().toDouble(),
                        viewModel.companyShoe.value.toString(),
                        viewModel.descShoe.value.toString()
                    )
                )
            }
        })


        viewModel.listShoe.observe(viewLifecycleOwner, Observer { shoe ->
            for (element in shoe){
                Log.i("ShoeListFragment","ShoeListFragment created")
                var  viewItem: View = addShoeToView(element,inflater,container)
                binding.viewListShoe.addView(viewItem)
            }

        })
        //hide back button
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(true)
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListDestinationToShoeDetailFragment())
        }

        //prevent hard back press
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //do nothing
                Log.i("Back back","Back back")
            }
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }


    private fun logOut() {
        Log.i("logOut", "logOut")
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListDestinationToLoginDestination())
    }

    // add new shoe to view
    private fun addShoeToView(shoe: Shoe,inflater: LayoutInflater,container: ViewGroup?): View{
        var  view: View = inflater.inflate(
            R.layout.shoe_item, container, false);
        var shoeName: TextView = view.findViewById(R.id.nameShoe)
        shoeName.text = shoe.name
        var shoeDesc: TextView = view.findViewById(R.id.desctShoe)
        shoeDesc.text = shoe.description
        var shoePrice: TextView = view.findViewById(R.id.priceShoe)
        shoePrice.text = shoe.size.toString()
        return view;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            R.id.logOut -> logOut()
        }
        return super.onOptionsItemSelected(item)
    }


}