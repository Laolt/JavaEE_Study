package org.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.domain.test;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/test"},produces = "Application/json;charset=utf-8")
public class testController {
    public testController() {
    }
	//传参：https://localhost:8080/test/ok
	//1、不传参调用
    @RequestMapping({"/ok"})
    @ResponseBody
    public String test() {
        return "666";
    }
	//传参：https://localhost:8080/test/getParam?name=test&age=12
	//2、传入普通参数，且web的参数名字与形参名相同
    @RequestMapping({"/getParam"})
    @ResponseBody
    public String test(String name, int age) {
        System.out.println(name + age + "7你");
        return "{'名':" + name + ",'年':" + age + "}";
    }
	//传参：https://localhost:8080/test/commitParam1?name=test&age=12
	//3、传入普通参数，且web的参数名字与形参名不相同则需要用@RequestParam注解交代对应关系
    @RequestMapping({"/commitParam1"})
    @ResponseBody
    public void test1(@RequestParam("name") String uesName) {
    }
	//传参：https://localhost:8080/test/commitParam2?name=test&age=12
	//4、传入POJO参数，则web的参数名与POJO类的属性名需一致
    @RequestMapping({"/commitParam2"})
    @ResponseBody
    public void test2(test test) {
    }
	//传参：https://localhost:8080/test/commitParam3?name=test&age=12&address.city
	//5、传入POJO参数且其中的属性含有引用型类，则URL的参数名字与形参名需一致，对引用类型的属性进行传参则需要web的参数名字为
	//POJO属性名.属性名
    @RequestMapping({"/commitParam3"})
    @ResponseBody
    public void test3(test test) {
    }
	//传参：https://localhost:8080/test/commitParam4?a=test&a=12
	//6、传入数组类型参数，则web的参数名需一致，把多个同名的参数加到数组中
    @RequestMapping({"/commitParam4"})
    @ResponseBody
    public void test4(String[] a) {
    }
	//传参：https://localhost:8080/test/commitParam5?a=test&a=12
	//7、传入集合类型参数，同6，需要在形参前面加注解@RequestParam
    @RequestMapping({"/commitParam5"})
    @ResponseBody
    public void test5(@RequestParam List<String> a) {
    }
//--------------------------------------名称不同上@RequestParam-----------------------------------------------
   





	//JSON传参，先将jackson的坐标导入
	//传参：https://localhost:8080/test/JSON1
	//1、JSON数组，加上@RequestBody使得传入的数据转为JSON对象
	@RequestMapping({"/JSON1"})
    @ResponseBody
    public void JSONtest(@RequestBody List<String> a) {
		//a=JSON数组["fa","48","42"]
    }
	//传参：https://localhost:8080/test/JSON2
	//2、POJO对象
    @RequestMapping({"/JSON2"})
    @ResponseBody
    public void JSONtest2(@RequestBody test a) {
		//无引用型：{"name":"test","age":"12"}
		//含有引用型属性：{"name":"test","age":"12","address":{"city":"北京"}}
    }
	//3、POJO集合对象
    @RequestMapping({"/JSON3"})
    @ResponseBody
    public void JSONtest3(@RequestBody List<test> a) {
		//传参：[{"name":"","age":""},{"name":"","age":""},{"name":"","age":""}]
    }
	
	
	//日期类型参数
    @RequestMapping({"/date"})
    @ResponseBody
    public void Datetest3(Date date1, @DateTimeFormat(pattern = "yyyy-MM-dd") Date date2, @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") Date date3) {
	//date1=2008/12/12(默认格式，如果是非默认格式则需要用@DateTimeFormat注解中的pattern属性指定)
	//date2=2008-12-12
	//date3=2008/12/12 12:12:12
	}
//-----------------------------------------上面请求，下面响应--------------------------------------
    //1、响应返回页面，一般用在页面跳转时
	@RequestMapping({"/page"})
    public String rePage() {
        return "页面名称（index.jsp）";
    }
	//2、响应返回文本内容
    @RequestMapping({"/text"})
    @ResponseBody
    public String retext() {
        return "内容";
    }
	//3、响应返回POJO，test会被转换车JSON格式的数据，前提是在配置中加了@EnablewebMvc注解
    @RequestMapping({"/JSONOfPojo"})
    @ResponseBody
    public test reJSONOfPojo() {
		//{"name":"test","age":"12"}
		//{"name":"test","age":"12","address":{"city":"beijing"}}
        return new test();
    }
	//4、响应返回POJO列表
    @RequestMapping({"/JSONOfList"})
    @ResponseBody
    public List<test> reJSONOfList() {
		//{{},{},{}}
        return new ArrayList();
    }
}
