package com.alie.modulepracticelearnview.view

import android.content.Context
import android.graphics.Point
import android.util.AttributeSet
import android.view.ViewGroup
import kotlin.math.max

/**
 * CloudTagLayout
 */
class CloudTagLayout(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) :
    ViewGroup(context, attrs, defStyleAttr, defStyleRes) {
    constructor(context: Context):this(context,null,0,0)
    constructor(context: Context,attrs: AttributeSet?):this(context,attrs,0,0)

    companion object {
        const val TAG = "CloudTagLayout"
    }
    private val mAllViewDataList = ArrayList<ArrayList<PointData>>()
    private var mWidth = 0

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context,attrs)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val layoutWidth = MeasureSpec.getSize(widthMeasureSpec)
        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = layoutWidth
            measureAllViews(widthMeasureSpec,heightMeasureSpec)
        } else {
            // 此处应当测量 所有控件，之后取最宽的那一行最为CloudTagLayout宽度，当然了 最宽不能超过这个CloudTagLayout宽度
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for (index in 0 until mAllViewDataList.size) {
            val singleLineViewDataList = mAllViewDataList[index]
            for (innerIndex in 0 until singleLineViewDataList.size) {
                singleLineViewDataList[innerIndex].also {
                    getChildAt(index).layout(it.mLeft, it.mTop, it.mRight, it.mBottom)
                }
            }
        }
    }


    private fun measureAllViews(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var currentWidth = 0
        var currentHeight = 0
        var currentMaxHeight = 0
        var singleLineViewDataList: ArrayList<PointData> = ArrayList()
        mAllViewDataList.clear()
        for (index in 0 until childCount) {
            getChildAt(index).let {
                measureChild(it,widthMeasureSpec,heightMeasureSpec)
                (it.layoutParams as MarginLayoutParams).let { layoutParams ->
                    val childViewWidth = layoutParams.marginStart + it.measuredWidth + layoutParams.marginEnd
                    val childViewHeight = layoutParams.topMargin +it.measuredHeight+layoutParams.bottomMargin
                    if (currentWidth > mWidth) {
                        currentWidth = 0
                        currentHeight = currentMaxHeight+childViewHeight
                        singleLineViewDataList = ArrayList()
                    }
                    if (currentWidth + childViewWidth <= mWidth ) {
                        val left = layoutParams.leftMargin+currentWidth
                        val top = layoutParams.topMargin + currentHeight
                        val right = left + it.measuredWidth
                        val bottom = top + it.measuredHeight
                        singleLineViewDataList.add(PointData(left,top,right,bottom))
                        currentWidth+=childViewWidth
                        currentMaxHeight = max(currentHeight,bottom+layoutParams.bottomMargin)
                        if (index == childCount - 1) {
                            mAllViewDataList.add(singleLineViewDataList)
                        }else{}
                    }else {
                        mAllViewDataList.add(singleLineViewDataList)
                        currentWidth = 0
                        currentHeight =  currentMaxHeight+childViewHeight
                        singleLineViewDataList = ArrayList()
                        val left = 0
                        val top = currentHeight+ layoutParams.bottomMargin
                        val right =left + it.measuredWidth
                        val bottom = top + it.measuredHeight
                        singleLineViewDataList.add(PointData(left,top,right,bottom))
                    }
                }
            }
        }
        setMeasuredDimension(mWidth,currentHeight)
    }


    /**
     * 自定义位置对象
     * 参数代表layout 位置
     */
    class PointData(
        val mLeft: Int = 0,
        val mTop: Int = 0,
        val mRight: Int = 0,
        val mBottom: Int = 0
    )


}
