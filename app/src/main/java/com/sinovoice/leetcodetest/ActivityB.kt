package com.sinovoice.leetcodetest

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import com.sinovoice.leetcodetest.utils.RotateTransformation
import com.sinovoice.leetcodetest.utils.RoundTransformation
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        TAG="TAG:ActivityB"
        Log.d(TAG, "onCreate: tashId=$taskId")

        var intent =Intent()
        intent.action=""
        intent.addCategory("")
        intent.setDataAndType(Uri.parse("file://adb.jpg"),"image/png")

        btn_start.setOnClickListener {
            startActivity(Intent(application,ActivityC::class.java))
        }

        btn_finish.setOnClickListener {
            val  intentResult =Intent()
            val bundle=Bundle()
            bundle.putString("key","form activity B")
            intentResult.putExtras(bundle)
            setResult(10086,intentResult)
            finish()

        }

        btn_load_img.setOnClickListener {
            loadImg()
        }
    }
    private val simpleTarget=object : SimpleTarget<Bitmap>(600,600) {
        override fun onResourceReady(
            resource: Bitmap?,
            glideAnimation: GlideAnimation<in Bitmap>?
        ) {
            iv_glide.setImageBitmap(resource)
        }
    }
    private fun loadImg(){
        val thumbnailRequest= Glide.with(this@ActivityB).load("https://www.aicloud.com/Public/logo/logo_web_bd.png")
        val url ="https://upload-images.jianshu.io/upload_images/3710435-72fa0fdaee28c030.jpg"
//        val gif ="https://wimg.588ku.com/gif620/21/04/13/8d63cfa32c759f116c7254811c08911a.gif"
        val gif ="https://img-blog.csdn.net/20171026011834436?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjc4NDA2MjE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center"
        Glide.with(this@ActivityB)
            .load(url)
            .asBitmap()//这里我们为了防止加载 Gif 、 Video 或者一些位置资源时与 mSimpleTarget 冲突，所以我们调用了 asBitmap() 方法，使其只能返回 Bitmap 对象
//         .crossFade() //跳过渐变
//            .thumbnail(thumbnailRequest)//缩略图
//         .priority(Priority.HIGH)//优先级
//            .transform(RoundTransformation(this@ActivityB,6))
            .transform(RoundTransformation(this@ActivityB,40),RotateTransformation(this@ActivityB,45f))
                //:这里需要注意一点 .centerCrop() 和 .fitCenter() 也都是 Transformation 所以也是遵循同时使用多个 Transformation 的规则的，
            // 即：当你使用了自定义转换后你就不能使用 .centerCrop() 或 .fitCenter() 了
//            .centerCrop()
//            .fitCenter()
            .placeholder(R.drawable.loading)//图片加载出来前，显示的图片
            .error(R.drawable.leetcode)//图片加载失败后，显示的图片
//         .skipMemoryCache(true)
//         .diskCacheStrategy( DiskCacheStrategy.NONE )
//        上面这段代码将内存缓存和磁盘缓存都禁用了，
//        这里使用枚举 DiskCacheStrategy.NONE 将磁盘缓存禁用了，这里涉及到了自定义磁盘缓存行为，我们接下来就讲解这个。
//            .into(iv_glide)//直接加载方法
            .into(simpleTarget)
    }
}