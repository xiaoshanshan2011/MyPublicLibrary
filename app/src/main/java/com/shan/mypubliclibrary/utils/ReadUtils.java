package com.shan.mypubliclibrary.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.shan.mypubliclibrary.MyApp;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * 读取文件工具类
 * Created by 陈俊山 on 16-10-13.
 */

public class ReadUtils {

    public static Bitmap readAssets(String name) {
        try {
            InputStream is2 = MyApp.getInstance().getResources().getAssets().open(name);
            return BitmapFactory.decodeStream(is2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readXmlAssets(String name) throws Exception {
        InputStream is = MyApp.getInstance().getResources().getAssets().open(name);

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        Document document = builder.parse(is);
        Element element = document.getDocumentElement();

        NodeList list = element.getElementsByTagName("book");

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < list.getLength(); i++) {
            Element book = (Element) list.item(i);
            buffer.append(book.getElementsByTagName("author").item(0).getTextContent() + "\n");
            buffer.append(book.getElementsByTagName("title").item(0).getTextContent() + "\n");
            buffer.append(book.getElementsByTagName("publisher").item(0).getTextContent() + "\n\n");
        }
        return buffer.toString();
    }

    public static JSONObject readJsonAssets(String name) throws Exception {
        InputStream is = MyApp.getInstance().getResources().getAssets().open(name);
        StringBuffer buffer = new StringBuffer();
        byte[] b = new byte[1024];
        int n;
        while ((n = is.read(b)) != -1) {
            buffer.append(new String(b, 0, n));
        }
        JSONObject jsonObject = new JSONObject(buffer.toString());
        return jsonObject;
    }
}
