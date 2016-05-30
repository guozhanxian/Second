package com.ralph.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 果占先 on 2016/5/30.
 */
public class BookContent {
    public static class Book
    {
        public Integer id;
        public String title;
        public String desc;

        public Book(Integer id, String title, String desc) {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    public static List<Book> ITEMS = new ArrayList<Book>();

    public static Map<Integer,Book> ITEM_MAP = new HashMap<Integer,Book>();

    static
    {
        addItem(new Book(1,"跟我学Android","这是一本神奇的书，闻一闻就会了！"));
        addItem(new Book(2,"跟我选JavaEE","这是一本疯狂的书，咬一咬就会了！"));
        addItem(new Book(3,"跟我学美术","这是一本恐怖的书，看一看就美了！"));
    }

    private static void addItem(Book book)
    {
        ITEMS.add(book);
        ITEM_MAP.put(book.id,book);
    }
}
