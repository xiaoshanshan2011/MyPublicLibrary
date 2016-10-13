package com.shan.mypubliclibrary.test;

import com.shan.mypubliclibrary.BaseActivity;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.databinding.TestActivityBinding;
import com.shan.mypubliclibrary.utils.ReadUtils;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by root on 16-10-14.
 */

public class TestActivity extends BaseActivity<TestActivityBinding, Object> {
    @Override
    public int bindLayout() {
        return R.layout.test_activity;
    }

    @Override
    public void initOnCreate() {
        super.initOnCreate();
        /*Bitmap bitmap = ReadUtils.readAssets("ic_jiaguanzhu_focused.png");
        mBinding.imageView.setImageBitmap(bitmap);

        try {
            String text = ReadUtils.readXmlAssets("book.xml");
            mBinding.textView.setText(text);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        try {
            JSONObject jsonObject = ReadUtils.readJsonAssets("book.json");
            StringBuffer buffer = new StringBuffer();

            JSONArray jsonArray = jsonObject.getJSONArray("tools");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = (JSONObject) jsonArray.get(i);
                String name = item.getString("name");
                String site = item.getString("site");
                buffer.append(name + " " + site + "\n");
            }
            mBinding.textView.setText(buffer.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
