package com.sinovoice.leetcodetest.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Matrix
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation

/**
 *Created by  on 2021/5/18.
 **/
public class RotateTransformation(context: Context,var rotateAngle:Float) :BitmapTransformation(context){
    override fun getId(): String {
        return RotateTransformation::class.java.simpleName+rotateAngle
    }

    override fun transform(
        pool: BitmapPool?,
        toTransform: Bitmap?,
        outWidth: Int,
        outHeight: Int
    ): Bitmap {
//        var result= pool?.get(outWidth, outHeight, Bitmap.Config.ARGB_8888)
        val matrix=Matrix()

        matrix.postRotate(rotateAngle)

        val result= toTransform?.let {  Bitmap.createBitmap(it,0,0,it.width,it.height,matrix,true) }
        return result!!
    }

}