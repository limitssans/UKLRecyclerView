package com.example.uklrecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class
SecondFragment : Fragment() {
    private var listUser : List<UserRegistrasi>? = null
    private var listUserRegistrasi : RecyclerView? = null
    private var db: AppDatabase? = null
    private var myUserDao: UserDao? = null
    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()
    }
    private fun initView() {
        listUserRegistrasi = activity?.findViewById(R.id.listMyUser)
        ambilDataUser()
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        myUserDao = db?.userDao()
    }
    private fun ambilDataUser() {
        listUser = ArrayList()
        myUserDao?.ambiluser()?.observe(viewLifecycleOwner, Observer { r -> listUser = r
            when {
                listUser?.size == 0 -> tampilToast("Belum ada data user")
                else -> {tampilUserRegistrasiFragment()
                }
            }
        })
    }
    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }
    private fun tampilUserRegistrasiFragment() {
        listUserRegistrasi?.layoutManager = LinearLayoutManager(activity)
        listUserRegistrasi?.adapter = UserAdapter(requireActivity(), listUser!! as ArrayList<UserRegistrasi>)
    }
    override fun onDestroy() {
        super.onDestroy()
        listUserRegistrasi = null
    }
}