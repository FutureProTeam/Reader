package com.futureproteam.reader.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;

import com.futureproteam.reader.R;
import com.futureproteam.reader.adapter.BookcaseAdapter;
import com.futureproteam.reader.base.BaseActivity;
import com.futureproteam.reader.modle.BookBo;
import com.futureproteam.reader.view.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 书架
 */
public class BookcaseActivity extends BaseActivity {

    private static final int COLUMN_NUM = 3;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private BookcaseAdapter adapter;
    private PopupWindow popUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        ButterKnife.bind(this);

        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this, COLUMN_NUM));
        int spanCount = 3; // 3 columns
        int spacing = 50; // 50px
        boolean includeEdge = true;
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        adapter = new BookcaseAdapter();
        recyclerView.setAdapter(adapter);

        //TODo 从数据库获取书籍信息
        List<BookBo> books = new ArrayList<>();
        books.add(new BookBo("大道争锋"));
        books.add(new BookBo("亵渎"));
        books.add(new BookBo("明朝那些事儿"));
        books.add(new BookBo("天才在左疯子在右"));
        books.add(new BookBo("天才在左疯子在右"));
        books.add(new BookBo("天才在左疯子在右"));
        books.add(new BookBo("天才在左，疯子在右   作者.txt"));
        adapter.setData(books);

    }

    @OnClick(R.id.img_menu)
    public void onMenuClicked(View view){
        PopupMenu popup = new PopupMenu(BookcaseActivity.this, view);
        popup.getMenuInflater().inflate(R.menu.pop_up, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.local_import:
                        ImportLocalBookActivity.start(BookcaseActivity.this);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        popup.show();//showing popup menu
    }

}
