package cn.edu.guet.springbootdemo;

import cn.edu.guet.springbootdemo.bean.Menu;
import cn.edu.guet.springbootdemo.bean.Permission;
import cn.edu.guet.springbootdemo.bean.User;
import cn.edu.guet.springbootdemo.mapper.MenuMapper;
import cn.edu.guet.springbootdemo.mapper.PermissionMapper;
import cn.edu.guet.springbootdemo.mapper.UserMapper;
import cn.edu.guet.springbootdemo.service.MenuService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SpringbootDemoApplicationTests {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void getMenuTest(){
        List<Menu> menu = menuService.getMenu();
        Gson gson = new Gson();
        System.out.println(gson.toJson(menu));
    }

    @Test
    public void getMenuById(){
         List<Menu> menu = menuMapper.getMenuById(1);
        System.out.println(menu);
    }

    @Test
    public void addMenuTest(){
        Menu menu = new Menu();
        menu.setType(1);
        menu.setParentName("2");
        menu.setName("addTest");
        menu.setIcon("123");
        menu.setUrl("1234");
        menu.setOrderNum(0);
        menu.setPerms("0");

        menuMapper.addMenu(menu);
    }

    @Test
    public void updateMenuTest(){
        Menu menu = new Menu();
        menu.setId(152);
        menu.setType(1);
        menu.setParentName("2");
        menu.setName("update");
        menu.setIcon("123");
        menu.setUrl("1234");
        menu.setOrderNum(0);
        menu.setPerms("23");

        menuMapper.updateMenu(menu);
    }

    @Test
    public void delateMenuTest(){
        menuMapper.deleteMenuById(153);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplicationTests.class, args);
    }

}
