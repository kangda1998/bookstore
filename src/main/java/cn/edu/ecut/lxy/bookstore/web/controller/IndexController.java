package cn.edu.ecut.lxy.bookstore.web.controller;


import cn.edu.ecut.lxy.bookstore.entity.BookInfo;
import cn.edu.ecut.lxy.bookstore.service.IBookCateService;
import cn.edu.ecut.lxy.bookstore.service.IBookInfoService;
import cn.edu.ecut.lxy.bookstore.entity.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

@Controller
public class IndexController {

    @Autowired
    private IBookInfoService bookInfoService;

    @Autowired
    private IBookCateService cateService;

    @Value("${book.category}")
    private String BOOK_CATEGORY;

    private List<BookCategory> categoryList;


    /**
     * 第一次访问首页首页
     *
     * @return
     */
    @RequestMapping({"", "/", "/index"})
    public String index(Model model) {
        if(categoryList == null){
            categoryList = cateService.getCategoryList();
        }
        //获得书籍列表
        List<BookInfo> bookInfos = bookInfoService.findBookListByCateId(categoryList.get(new Random().nextInt(6)).getCateId(), new Random().nextInt(3), 20);
        model.addAttribute("bookInfos", bookInfos);

        return "index";
    }


    /**
     * 点击首页导航栏分类后来到这个handler
     *
     * @param cateId
     * @param model
     * @return
     */
    @RequestMapping("/index/category/{cateId}")
    public String bookListByCategoryId(@PathVariable("cateId") int cateId, Model model) {


        List<BookInfo> bookInfos = bookInfoService.findBookListByCateId(cateId, new Random().nextInt(3), 20);
        model.addAttribute("bookInfos", bookInfos);
        model.addAttribute("cateId", cateId);
        return "index";
    }

}
