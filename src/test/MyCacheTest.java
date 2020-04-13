package test;

import com.naver.china.project2.MyCache;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName MyCacheTest
 * @Description 测试缓存
 * @Author XuLei
 * @Date 2020/04/13 20:53
 * @Version 1.0
 */
public class MyCacheTest {

    private int cacheSize = 2;
    private MyCache<String,String> cache = null;
    @Before
    public void init(){
        cache = new MyCache<>(cacheSize);
        cache.put("myFirstName","XuLei");


    }
    @Test
    public void put(){
        cache.put("myName","mart");
        System.out.println("put after the Data: " + cache.toString());
    }

    @Test
    public void get(){
        String value = cache.get("myFirstName");
        System.out.println("get key-myFirstName: " + value);
    }

    @Test
    public void putMoreSizeData(){
        put();
        cache.put("myWorking","22:10");
        System.out.println("OUTPUT: " + cache.toString());
    }

}
