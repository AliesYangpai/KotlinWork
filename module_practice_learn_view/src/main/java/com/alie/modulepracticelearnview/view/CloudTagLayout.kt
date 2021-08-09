package com.alie.modulepracticelearnview.view

import android.content.Context
import android.graphics.Point
import android.util.AttributeSet
import android.view.ViewGroup

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

    val mViewDataList = ArrayList<ArrayList<PointData>>()
    var mWidth = 0
    companion object {
        const val TAG = "CloudTagLayout"
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val layoutWidth = MeasureSpec.getSize(widthMeasureSpec)
        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = layoutWidth
            measureAllViews()
        } else {
            // 此处应当测量 所有控件，之后取最宽的那一行最为CloudTagLayout宽度，当然了 最宽不能超过这个CloudTagLayout宽度
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for(index in 0 until mViewDataList.size) {
            val singleLineViewDataList = mViewDataList[index]
            for (innerIndex in 0 until singleLineViewDataList.size) {
                singleLineViewDataList[index].also {
                    getChildAt(innerIndex).layout(it.mLeft,it.mTop,it.mRight,it.mBottom)
                }
            }
        }
    }

    var mCurrentWidth = 0
    var mCurrentHeight = 0
    var mSingleLineViewDataList:ArrayList<PointData> = ArrayList<PointData>()
    private fun measureAllViews() {
        for (index in 0 until childCount) {
            (getChildAt(index).layoutParams as MarginLayoutParams).let {


                val viewLeft = mCurrentWidth + it.leftMargin
                val viewTop = mCurrentHeight+it.topMargin
                val viewRight = viewLeft+it.width
                val viewBottom = viewTop+it.height
                if (viewRight < mWidth) {
                    mSingleLineViewDataList?.add(PointData(viewLeft,viewTop,viewRight,viewBottom))
                    mCurrentWidth+=viewRight
                    if (mCurrentWidth >= mWidth) {
                        mCurrentWidth = 0
                    }
                    mCurrentHeight = Math.max(mCurrentHeight,viewBottom)
                }
                if (viewRight > mWidth) {
                    mCurrentWidth = 0
                    mViewDataList.add(mSingleLineViewDataList)


                }
            }
        }
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
