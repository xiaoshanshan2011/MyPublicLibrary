package com.shan.mypubliclibrary.fragment_tab;

import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shan.mypubliclibrary.R;
import com.shan.mypubliclibrary.adapter.CommonAdapter;
import com.shan.mypubliclibrary.bean.CTestBean;
import com.shan.mypubliclibrary.databinding.FragmentCBinding;
import com.shan.mypubliclibrary.databinding.FragmentCItemBinding;
import com.shan.mypubliclibrary.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈俊山 on 2016/8/31.
 */

public class CFragment extends BaseFragment<FragmentCBinding, Object> {
    @Override
    public int bindLayout() {
        return R.layout.fragment_c;
    }

    @Override
    public void initOnCreate() {
        List<CTestBean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new CTestBean("http://a.vpimg3.com/upload/merchandise/172326/SONG-T6956511900169-3.jpg", "的空间上课了", "356"));
        }

        mBinding.gridview.setAdapter(new CommonAdapter<FragmentCItemBinding, CTestBean>(getActivity(), R.layout.fragment_c_item, list) {
            @Override
            protected void getItem(FragmentCItemBinding binding, CTestBean bean) {
                binding.tvTitle.setText(bean.getTitle());
                binding.tvPrice.setText(bean.getPrice());
                ImageLoader.getInstance().displayImage(bean.getUrl(), binding.imageView);
            }
        });
    }

    @Override
    public void initTitleBar() {
        setTitleBarVisibility(View.GONE);
    }
}
