package com.example.uklrecyclerview

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.Calendar

class FirstFragment : Fragment() {
    private var db:AppDatabase?=null
    private var userDao: UserDao? = null

    private var namaInput: String = ""
    private var emailInput: String = ""
    private var passwordInput: String = ""
    private var dateInput: String = ""

    private var edtName: EditText? = null
    private var edtEmail: EditText? = null
    private var edtPassword: EditText? = null
    private var btnSave: Button? = null
    private var btnDate: Button? = null
    private var communicationViewModel: CommunicationViewModel? = null

    lateinit var pickDate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first,
            container, false)
    }
    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()

        pickDate = view.findViewById(R.id.btnDate)

        pickDate.setOnClickListener{
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                {view, year, monthOfYear, dayOfMonth ->
                    pickDate.text =
                        (dayOfMonth.toString()+"\t-\t"+(monthOfYear+1)+"\t-\t"+year)
                },
                year, month,day)
            datePickerDialog.show()
        }
    }

    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }
    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        userDao = db?.userDao()
    }
    private fun initView() {

        edtName = activity?.findViewById(R.id.textInputTextName)
        edtEmail = activity?.findViewById(R.id.textInputTextEmail)
        btnDate = activity?.findViewById(R.id.btnDate)

        btnSave = activity?.findViewById(R.id.btnSave)
        btnSave?.setOnClickListener {
            validasiInput()
        }
    }
    private fun validasiInput() {
        namaInput = edtName?.text.toString()
        emailInput = edtEmail?.text.toString()
        passwordInput = edtPassword?.text.toString()
        dateInput = btnDate?.text.toString()
        when{
            namaInput.isEmpty() -> edtName?.error = "Nama tidak boleh kosong"
            emailInput.isEmpty() -> edtEmail?.error = "Email tidak boleh kosong"
            passwordInput.isEmpty() -> edtPassword?.error = "Telp tidak boleh kosong"
            dateInput.isEmpty() -> btnDate?.error = "Tanggal tidak boleh kosong"
            else -> {
                val user = UserRegistrasi(nama = namaInput, email = emailInput, password = passwordInput, date = dateInput)
                tambahDataUser(user)
                Toast.makeText(requireActivity(),"Data Di Simpan",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun tambahDataUser(user: UserRegistrasi) : Job {
        return GlobalScope.launch {
            userDao?.tambahuser(user)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        db?.close()
        edtName = null
        edtEmail = null
        edtPassword = null
        btnSave = null
    }
}