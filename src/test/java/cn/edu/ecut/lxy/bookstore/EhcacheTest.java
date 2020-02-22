package cn.edu.ecut.lxy.bookstore;

import cn.edu.ecut.lxy.bookstore.entity.BookInfo;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import net.sf.ehcache.Element;


public class EhcacheTest {
    /**
     * 缓存使用测试
     * @param args
     */
    public static void main(String[] args) {

        // 1. 创建缓存管理器
        CacheManager cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");

        // 2. 获取缓存对象
        Cache cache = cacheManager.getCache("book");

        // 3. 创建元素
        Element element = new Element("key1", "value1");

        // 4. 将元素添加到缓存
        cache.put(element);
        // 5. 获取缓存
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        // 6. 删除元素
        cache.remove("key1");

        BookInfo bookInfo = new BookInfo();
        Element element2 = new Element("book", bookInfo);
        cache.put(element2);
        Element value2 = cache.get("book");
        BookInfo ookInfo = (BookInfo) value2.getObjectValue();
        System.out.println(ookInfo);

        System.out.println(cache.getSize());

        // 7. 刷新缓存
        cache.flush();

        // 8. 关闭缓存管理器
        cacheManager.shutdown();
    }

    }
