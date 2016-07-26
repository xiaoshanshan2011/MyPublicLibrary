package com.shan.publiclibrary.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by 大唐天下 on 2016/7/25.
 */

public class FileUtil {
    private static final String dir = "/com.shan.publiclibrary/";
    public static File createFile(String filename) {
        File file = new File(Environment.getExternalStorageDirectory(), dir+filename);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }
}
