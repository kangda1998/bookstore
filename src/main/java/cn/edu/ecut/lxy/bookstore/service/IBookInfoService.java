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
     * 根据bookId和上架查询书籍详情，根据条件查询列表，取第一个数据
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
     * 查询书籍信息通过bookId，storeMount，上架
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

    /**
     * 书籍单条信息修改
     * @param bookInfo
     * @param bookDesc
     * @return
     */
    BSResult updateBook(BookInfo bookInfo, String bookDesc);
    /**
     * 商品下架
     *
     * @param bookId
     * @return
     */
    BSResult changeShelfStatus(int bookId,int shelf);

    /**
     * 通过主键查询书籍信息是否存在
     * @param bookId
     * @return
     * @throws BSException
     */
    BookInfo adminFindById(int bookId) throws BSException;

    /**
     * 删除书籍信息
     * @param bookId
     * @return
     */
    BSResult deleteBook(int bookId);

    /**
     * 浏览量加一
     * @param bookInfo
     * @return
     */
    int addLookMount(BookInfo bookInfo);

    List<Pie> getBookViewsPiesByStoreId(Integer storeId);

    Bar getBookSalesBarJson(Integer storeId);
}
