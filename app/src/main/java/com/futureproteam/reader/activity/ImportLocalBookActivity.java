package com.futureproteam.reader.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.futureproteam.reader.R;
import com.futureproteam.reader.adapter.ImportFragmentPageAdapter;
import com.futureproteam.reader.base.BaseActivity;
import com.futureproteam.reader.base.BaseFragment;
import com.futureproteam.reader.fragment.IntelligentImportFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 导入本机书籍
 */
public class ImportLocalBookActivity extends BaseActivity {

    ImportFragmentPageAdapter adapterViewPager;
    List<BaseFragment> fragments;

    @BindView(R.id.viewPager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_local_book);

        init();
    }

    private void init() {
        ButterKnife.bind(this);

        fragments = new ArrayList<>();
        fragments.add(new IntelligentImportFragment());
        adapterViewPager = new ImportFragmentPageAdapter(getApplicationContext(), getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapterViewPager);


    }

    public static void start(Context context){
        Intent intent = new Intent();
        intent.setClass(context, ImportLocalBookActivity.class);
        context.startActivity(intent);
    }

}
