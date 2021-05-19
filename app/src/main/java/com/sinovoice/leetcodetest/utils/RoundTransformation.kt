package com.sinovoice.leetcodetest.utils

import android.content.Context
import android.graphics.*
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import kotlin.math.roundToInt


/**
 *Created by  on 2021/5/18.
 **/
public  class RoundTransformation(var context: Context?,var radius: Int) : BitmapTransformation(context) {

    override fun getId(): String {
        return  RoundTransformation::javaClass.name + radius.toDouble().roundToInt()+"version${1}"
    }
    constructor( context:Context ):this(context,4)

    private fun roundCrop(pool: BitmapPool, source: Bitmap?): Bitmap? {
        if (source == null) return null
        var result =
            pool[source.width, source.height, Bitmap.Config.ARGB_8888]
        if (result == null) {
            result =
                Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_8888)
        }
        val canvas = Canvas(result)
        val paint = Paint()
        paint.shader = BitmapShader(
            source,
            Shader.TileMode.CLAMP,
            Shader.TileMode.CLAMP
        )
        paint.isAntiAlias = true
        val rectF = RectF(0f, 0f, source.width.toFloat(), source.height.toFloat())
//        canvas.drawRoundRect(rectF, radius.toFloat(), radius.toFloat(), paint) //画四个角

        val path = Path()
//        val radii = floatArrayOf(leftTop, leftTop, rightTop, rightTop, rightBottom, rightBottom, leftBottom, leftBottom)
        val radii = floatArrayOf(0f, 0f, dip2px(radius), dip2px(radius), 0f, 0f, dip2px(radius),dip2px(radius))
        path.addRoundRect(rectF, radii, Path.Direction.CW)
        canvas.drawPath(path, paint)
        return result
    }
    //dp转px
    fun dip2px(var1: Int): Float {
        val var2 = context!!.resources.displayMetrics.density
        return (var1 * var2 + 0.5f)
    }

    override fun transform(
        pool: BitmapPool?,
        toTransform: Bitmap?,
        outWidth: Int,
        outHeight: Int
    ): Bitmap? {
        return roundCrop(pool!!,toTransform)
    }

}