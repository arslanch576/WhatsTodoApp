package com.coderobust.whatstodoapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.coderobust.whatstodoapp.databinding.ActivityAddTodoItemBinding

class AddToDoItemActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddTodoItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTodoItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Add ToDo Item")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.save.setOnClickListener {
            val todoItem = ToDoItem(
                binding.title.editText?.text.toString(),
                binding.description.editText?.text.toString()
            )

            //TODO: 1- Write code to save todoItem in database
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            finish()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}