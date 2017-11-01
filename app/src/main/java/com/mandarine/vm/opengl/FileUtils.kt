package com.mandarine.vm.opengl

import android.content.Context
import android.content.res.Resources
import android.content.res.Resources.NotFoundException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


/**
 * Created by vadim.
 * Copyright (c) 2017 Mandarin. All rights reserved.
 */
object FileUtils {
    fun readTextFromRaw(context: Context, resourceId: Int): String {
        val stringBuilder = StringBuilder()
        try {
            var bufferedReader: BufferedReader? = null
            try {
                val inputStream = context.resources.openRawResource(resourceId)
                bufferedReader = BufferedReader(InputStreamReader(inputStream))
                var line: String
                bufferedReader.forEachLine {
                    stringBuilder.append(it)
                    stringBuilder.append("\r\n")
                }
//                while ((line = bufferedReader!!.readLine()) != null) {
//                    stringBuilder.append(line)
//                    stringBuilder.append("\r\n")
//                }
            } finally {
                    bufferedReader?.close()
            }
        } catch (ioex: IOException) {
            ioex.printStackTrace()
        } catch (nfex: Resources.NotFoundException) {
            nfex.printStackTrace()
        }

        return stringBuilder.toString()
    }
}