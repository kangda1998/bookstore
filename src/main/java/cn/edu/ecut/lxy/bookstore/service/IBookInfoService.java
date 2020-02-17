package cn.edu.ecut.lxy.bookstore.service;

import cn.edu.ecut.lxy.bookstore.exception.BSException;
import com.github.pagehelper.PageInfo;
import cn.edu.ecut.lxy.bookstore.common.pojo.BSResult;
import cn.edu.ecut.lxy.bookstore.common.pojo.Bar;
import cn.edu.ecut.lxy.bookstore.common.pojo.Pie;
import cn.edu.ecut.lxy.bookstore.entity.BookInfo;

import java.util.List;

public interface IBookInfoService {
    /**
     * 根据分类Id查询书籍列表信息
     * @param cateId
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<BookInfo> findBookListByCateId(int cateId, int currentPage, int pageSize);

    /**
     * 根据bookId查询书籍详情，根据条件查询列表，取第一个数据
     * @param bookId
     * @return
     * @throws BSException
     */
    BookInfo findById(Integer bookId) throws BSException;
    /**
     * 按照一堆条件搜索书籍，查询关键字可以是书名、关键字或ISBN
     *
     * @param keywords
     * @param cateId
     * @param page
     * @param pageSize
     * @param storeId
     * @return
     */
    PageInfo<BookInfo> findBookListByCondition(String keywords, int cateId, int page, int pageSize,int storeId);

    /**
     * 查询书籍信息通过bookId
     * @param bookId
     * @return
     */
    BookInfo queryBookAvailable(int bookId);

    /**
     * 书籍信息单条新增
     * @param bookInfo
     * @param bookDescStr
     * @return
     */
    BSResult saveBook(BookInfo bookInfo,String bookDescStr);

    BSResult updateBook(BookInfo bookInfo, String bookDesc);

    BSResult changeShelfStatus(int bookId,int shelf);

    BookInfo adminFindById(int bookId) throws BSException;

    BSResult deleteBook(int bookId);

    int addLookMount(BookInfo bookInfo);

    List<Pie> getBookViewsPiesByStoreId(Integer storeId);

    Bar getBookSalesBarJson(Integer storeId);
}
