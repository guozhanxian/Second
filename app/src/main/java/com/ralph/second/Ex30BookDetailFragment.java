package com.ralph.second;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 果占先 on 2016/5/30.
 */
public class Ex30BookDetailFragment extends Fragment {

    BookContent.Book book;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments().containsKey("item_id"))
        {
            book = BookContent.ITEM_MAP.get(getArguments().getInt("item_id"));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ex30_book_detail,container,false);
        if(book != null)
        {
            TextView title = (TextView) view.findViewById(R.id.book_title);
            TextView desc = (TextView) view.findViewById(R.id.book_desc);

            title.setText(book.title);
            desc.setText(book.desc);
        }
        return view;
    }
}
