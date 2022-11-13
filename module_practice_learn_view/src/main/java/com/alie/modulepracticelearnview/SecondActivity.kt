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

    private  var list =   listOf(
        Person("西瓜"),
        Person("冬瓜"),
        Person("南瓜"),
        Person("北瓜"),
        Person("哈密瓜"),
        Person("黄瓜"),
        Person("蓝瓜"),
        Person("绿瓜")
    )

    var num = 0;
    private fun initRecyclerView() {
        binding.rv1.let {
            it.adapter = MyAdapter()
            it.layoutManager = GridLayoutManager(this, 8)
        }

        binding.btn1.setOnClickListener {
            (binding.rv1.adapter as MyAdapter).submitList(list)
        }
        binding.btn2.setOnClickListener {
            num++
            val newList = list.toMutableList()
            val target = newList.find {
                it.name == "哈密瓜"
            }
           val targetIndex = newList.indexOf(target)
            newList[targetIndex] = Person("哈密瓜", count = num)

            (binding.rv1.adapter as MyAdapter).submitList(newList)
            list = newList
        }
    }
}