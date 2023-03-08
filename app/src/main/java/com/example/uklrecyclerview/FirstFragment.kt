package com.example.uklrecyclerview

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import java.lang.reflect.Array.get

class FirstFragment : Fragment() {

    private var communicationViewModel : CommunicationViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        communicationViewModel =
            ViewModelProvider(requireActivity()).
            get(CommunicationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameEditText = view.findViewById<TextInputEditText>(R.id.textInputTextName)
        nameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, I: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                communicationViewModel!!.setName(charSequence.toString())
            }

            override fun afterTextChanged(editable: Editable) {
            }
        })

        val emailEditText = view.findViewById<TextInputEditText>(R.id.textInputTextEmail)
        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, I: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                communicationViewModel!!.setEmail(charSequence.toString())
            }

            override fun afterTextChanged(editable: Editable) {
            }
        })
    }


    companion object {
        fun newInstance() : FirstFragment{
            return FirstFragment()
        }
    }
}