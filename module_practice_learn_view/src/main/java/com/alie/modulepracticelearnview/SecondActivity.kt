package com.alie.modulepracticelearnview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.alie.modulepracticelearnview.databinding.ActivitySecondBinding
import com.alie.modulepracticelearnview.view.MyAdapter
import com.alie.modulepracticelearnview.view.Person

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivitySecondBinding.inflate(layoutInflater).let {
            binding = it
            binding.root
        })
        initView()
    }

    private fun initView() {

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rv1.let {
            it.adapter = MyAdapter()
            it.layoutManager = GridLayoutManager(this, 8)
        }
        (binding.rv1.adapter as MyAdapter).submitList(
            listOf(
                Person("西瓜"),
                Person("西瓜"),
                Person("西瓜"),
                Person("西瓜"),
                Person("西瓜"),
                Person("西瓜"),
                        Person("西瓜"),
                Person("西瓜")
            )
        )
    }
}