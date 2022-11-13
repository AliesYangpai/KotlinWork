package com.alie.modulepracticelearnview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.alie.modulepracticelearnview.view.CloudTagLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        startActivity(Intent(this,SecondActivity::class.java))
    }

    /**
     * let's find out why inflate(id,null) has no param info
     */
    private fun initView() {
        val view = findViewById<CloudTagLayout>(R.id.mCtl)
        val layout = layoutInflater.inflate(R.layout.test1_layout, view)
        val iv = layout.findViewById<ImageView>(R.id.iv1)
        println("===initView layout-layoutParams.width:${layout.layoutParams.width} width:${layout.width}")
        println("===initView iv-layoutParams.width:${iv.layoutParams.width} width:${iv.width}")
        /**
         * From reading source we can make conclusion
         * part1
         * If we pass null like this inflate(id,null)
         * temp.setLayoutParams(params)
         * (params comes from root.generateLayoutParams(attrs)
         *  attrs comes from Xml.asAttributeSet(parser)
         * ) would not invoke
         * So no layoutParam info
         *
         * part2
         * Why pass a not null root view.width still 0 but view.layoutParams.width do
         * view.layoutParams.width -> find answer from part1 and source
         * view.width still 0 -> container has request already
         */
    }
}