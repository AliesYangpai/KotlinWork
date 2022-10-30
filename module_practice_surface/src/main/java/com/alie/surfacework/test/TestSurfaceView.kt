package com.alie.surfacework.test

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlinx.coroutines.*

class TestSurfaceView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : SurfaceView(context, attrs), SurfaceHolder.Callback {



    init {
        holder.addCallback(this)
    }
    override fun surfaceCreated(holder: SurfaceHolder) {


        CoroutineScope(Job()+Dispatchers.Default).launch {
            val paint = Paint().apply {
                color = Color.GREEN
                style = Paint.Style.FILL
            }
            val canvas = holder.lockCanvas()
            canvas.drawRect(Rect(50, 50, canvas.width - 50, canvas.height - 50), paint)
            holder.unlockCanvasAndPost(canvas)
        }

    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
    }
}