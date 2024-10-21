package com.coderobust.whatstodoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.coderobust.whatstodoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddToDoItemActivity::class.java))
        }

        binding.recyclerview.layoutManager = LinearLayoutManager(this)


    }

    override fun onResume() {
        super.onResume()
        //TODO: 2- reterive TODO items from database and provide to RecyclerViewAdapter by replacing getItems() method
        val adapter = RecyclerViewAdapter(getItems())
        binding.recyclerview.adapter = adapter
    }

    private fun getItems(): List<ToDoItem> {
        return listOf(
            ToDoItem("Title 1", "Details 1"),
            ToDoItem("Title 2", "Details 2", true),
            ToDoItem("Title 3", "Details 3"),
            ToDoItem("Title 4", "Details 4", true),
        )
    }
}