package com.android.testnatife.recyclerview

import com.google.gson.annotations.SerializedName

data class Gif(
    @SerializedName("title")
    val name: String,
    @SerializedName("images")
    val images: Images
    ){

    fun getUrl(): String = images.original.url

    data class Images(

        @SerializedName("original")
        val original: Original
    ){
        data class Original(

            @SerializedName("url")
            val url: String
        )
    }
}



