package com.sinovoice.leetcodetest;

import android.os.RemoteException;


import com.sinovoice.leetcodetest.bean.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  on 2021/3/5.
 **/
class MyBinder  extends  BookManager.Stub{
    List<Book> bookList =new ArrayList<>();

    @Override
    public List<Book> getBooks() throws RemoteException {
        return bookList;
    }

    @Override
    public void addBook(Book book) throws RemoteException {
        bookList.add(book);
    }
}
