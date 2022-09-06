package com.araskaplan.countries.domain.util

import android.net.Uri
import com.araskaplan.countries.common.Common

object Util {
    fun String.toWikiDataLink():Uri{
        return Uri.parse(Common.WIKI_DATA_BASE_LINK + this )
    }
}