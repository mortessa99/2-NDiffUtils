package com.example.a2_ndiffutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a2_ndiffutils.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val userAdapter by lazy { UserAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set Data
        userAdapter.differ.submitList(loadData())

        //setting recycler
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }

    private fun loadData():MutableList<UserModel>{
        val users = mutableListOf<UserModel>()
        users.add(UserModel(1,"Majid",25))
        users.add(UserModel(2,"Abbas",45))
        users.add(UserModel(3,"Nushin",55))
        users.add(UserModel(4,"Hossein",15))
        users.add(UserModel(5,"Taghi",32))
        users.add(UserModel(6,"Alireza",76))
        users.add(UserModel(7,"Milad",23))
        users.add(UserModel(8,"Sajad",27))
        users.add(UserModel(9,"Naser",30))
        users.add(UserModel(10,"Mohammad",25))
        users.add(UserModel(11,"Majid",25))
        users.add(UserModel(12,"Abbas",45))
        users.add(UserModel(13,"Nushin",55))
        users.add(UserModel(14,"Hossein",15))
        users.add(UserModel(15,"Taghi",32))
        users.add(UserModel(16,"Alireza",76))
        users.add(UserModel(17,"Milad",23))
        users.add(UserModel(18,"Sajad",27))
        users.add(UserModel(19,"Naser",30))
        users.add(UserModel(20,"Mohammad",25))
        return users
    }
}