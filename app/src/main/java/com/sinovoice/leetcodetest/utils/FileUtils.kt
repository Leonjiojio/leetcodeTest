package com.sinovoice.leetcodetest.utils

import java.io.*

/**
 *Created by  on 2021/5/17.
 **/
public  object FileUtils {
    fun saveFile(bytes: ByteArray, file: File
    ) {
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(file)
                fos.write(bytes, 0, bytes.size)
            fos.flush()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                fos?.close()
            } catch (e: IOException) {

            }
        }
    }
}