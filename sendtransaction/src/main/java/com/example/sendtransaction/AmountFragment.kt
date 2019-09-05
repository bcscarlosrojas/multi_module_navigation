package com.example.sendtransaction


import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_amount.*

/**
 * A simple [Fragment] subclass.
 */
class AmountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amount, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        amountNext.setOnClickListener {
            val transaction =
                Transaction(amount = amount.text.toString())
            val directions =
                AmountFragmentDirections.actionAmountFragmentToConfirmationFragment(transaction)
            findNavController().navigate(directions)
        }
    }

}

@Parcelize
data class Transaction(val nombre: String = "Nombre Mega Generico", val amount: String) : Parcelable
