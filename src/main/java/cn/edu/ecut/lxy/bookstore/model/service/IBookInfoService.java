package cn.edu.ecut.lxy.bookstore.model.service;

import cn.edu.ecut.lxy.bookstore.exception.BSException;
import com.github.pagehelper.PageInfo;
import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;
import cn.edu.ecut.lxy.bookstore.common.pojo.Bar;
import cn.edu.ecut.lxy.bookstore.common.pojo.Pie;
import cn.edu.ecut.lxy.bookstore.model.entity.BookInfo;

import java.util.List;

public interface IBookInfoService {

    List<BookInfo> findBookListByCateId(int cateId, int currentPage, int pageSize);

    BookInfo findById(Integer bookId) throws BSException;

    PageInfo<BookInfo> findBookListByCondition(String keywords, int cateId, int page, int pageSize,int storeId);

    BookInfo queryBookAvailable(int bookId);

    BSResult saveBook(BookInfo bookInfo,String bookDescStr);

    BSResult updateBook(BookInfo bookInfo, String bookDesc);

    BSResult changeShelfStatus(int bookId,int shelf);

    BookInfo adminFindById(int bookId) throws BSException;

    BSResult deleteBook(int bookId);

    int addLookMount(BookInfo bookInfo);

    List<Pie> getBookViewsPiesByStoreId(Integer storeId);

    Bar getBookSalesBarJson(Integer storeId);
}
