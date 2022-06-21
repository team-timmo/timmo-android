package com.sys.timmo.util

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okio.BufferedSink
import okio.Okio
import java.io.IOException

object MultipartUtil {

    @SuppressLint("Range")
    fun uriToMultipart(
        uri: Uri,
        contentResolver: ContentResolver,
        name: String
    ): MultipartBody.Part? {
        val cursor = contentResolver.query(uri, null, null, null, null)

        return if (cursor != null) {
            if (cursor.moveToNext()) {
                val filename = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))

                val requestBody: RequestBody = object : RequestBody() {
                    override fun contentType(): MediaType? {
                        return contentResolver.getType(uri)?.let { MediaType.parse(it) }
                    }

                    override fun writeTo(sink: BufferedSink) {
                        try {
                            contentResolver.openInputStream(uri)
                                ?.let { Okio.source(it) }?.let { sink.writeAll(it) }
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                }
                cursor.close()
                MultipartBody.Part.createFormData(name, filename, requestBody)
            } else {
                cursor.close()
                null
            }
        } else {
            null
        }
    }
}