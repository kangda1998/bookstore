package cn.edu.ecut.lxy.bookstore.crawl;

import cn.edu.ecut.lxy.bookstore.model.dao.BookInfoMapper;
import cn.edu.ecut.lxy.bookstore.model.entity.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class WriteToMysql {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    public void executeInsert(List<BookInfo> bookdatas) throws SQLException
    {
        long start = System.currentTimeMillis() / 1000;
        System.out.println(start);
        for (BookInfo bookdata : bookdatas) {

        }
        for (BookInfo bookdata : bookdatas) {
            bookInfoMapper.insert(bookdata);
        }

        System.out.println("成功插入" + bookdatas.size() + "条");
        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(System.currentTimeMillis() / 1000 - start);
    }

}
