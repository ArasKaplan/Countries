package com.araskaplan.countries.domain.util

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.util.Base64
import com.araskaplan.countries.common.Common
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.github.twocoffeesoneteam.glidetovectoryou.GlideApp
import java.io.ByteArrayOutputStream

object Util {
    fun String.toWikiDataLink(): Uri {
        return Uri.parse(Common.WIKI_DATA_BASE_LINK + this)
    }

    fun Bitmap.toBase64(): String {
        val baos = ByteArrayOutputStream()
        this.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val b = baos.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)
    }

    fun getSvgImageAsBitmap(
        context: Context,
        uri: Uri,
        onResourceReady: (resource: Bitmap, transition: Transition<in Bitmap>?) -> Unit
    ) {
        GlideApp.with(context)
            .asBitmap()
            .load(uri)
            .into(object : SimpleTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    onResourceReady(resource, transition)
                }
            })
    }
}