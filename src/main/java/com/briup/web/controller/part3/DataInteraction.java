package com.briup.web.controller.part3;

import com.briup.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第三部分： 2.数据交互
 */
@Controller
@RequestMapping("/dataInteraction")
public class DataInteraction {
     // 参数名字要和客户端传的参数名一致,否则需要使用 @RequestParam 来指定参数名

    /**
     * GET http://localhost:8888/dataInteraction/test?id=1&num=20&name=tom
     * 参数名字要和客户端传的参数名一致,否则需要使用 @RequestParam 来指定参数名
     * @param name String
     * @param id 方法参数是基本数据类型
     * @param num 包装类型
     * @return 逻辑视图
     */
    @RequestMapping("/test")
    public String test(String name,int id,Integer num){
        System.out.println("name:"+name);
        System.out.println("id"+id);
        System.out.println("num:"+num);
        return "jack";
    }

    /**
     * http://localhost:8888/dataInteraction/test2?like=1&like=2&like=3
     * @param like 参数是数组类型
     * @return
     */
    @RequestMapping("/test2")
    public String test2(String[] like){
        System.out.println(Arrays.toString(like));// [1, 2, 3]
        return "jack";
    }

    /**
     * POST  http://localhost:8888/dataInteraction/test3
     * 请求头：Content-Type:application/json
     * 请求体：["1","2","3"]
     * @param like  参数是数组类型
     * @return 逻辑视图名
     */
    @RequestMapping("/test3")
    public String test3(@RequestBody String[] like){
        System.out.println(Arrays.toString(like));// [1, 2, 3]
        return "jack";
    }

    /**
     * http://localhost:8888/dataInteraction/test4?id=1&name=jack&dob=1991-10-20
     * @param s 参数是类类型
     * @return 逻辑视图名
     */
    @RequestMapping("/test4")
    public String test4(Student s){
        System.out.println(s);//Student{id=1, name='jack', dob=Thu Oct 10 00:00:00 CST 1991, address=null}
        return "jack";
    }

    /**
     * POST http://localhost:8888/dataInteraction/test5
     * 请求头： Content-Type：application/json
     * 请求体： {"id":1,"name":"jack","dob":"1992-10-10","address":{"id":101,"city":"上海"}}
     * @param s 参数是类类型
     * @return 逻辑视图名
     */
    @RequestMapping("/test5")
    public String test5(@RequestBody Student s){
        System.out.println(s); // Student{id=1, name='jack', dob=Sat Oct 10 08:00:00 CST 1992, address=Address [id=101, city=上海]}
        return "jack";
    }

    /**
     * POST http://localhost:8888/dataInteraction/test6
     * 请求头： Content-Type：application/json
     * 请求体： [{"id":1,"name":"jack"},{"id":2,"name":"tom"},{"id":3,"name":"bob"}]
     * @param students  方法参数是List集合
     * @return
     */
    @RequestMapping("/test6")
    public String test6(@RequestBody List<Student> students){
        /**
         * Student{id=1, name='jack', dob=null, address=null}
         * Student{id=2, name='tom', dob=null, address=null}
         * Student{id=3, name='bob', dob=null, address=null}
         */
        students.forEach(s -> System.out.println(s));
        return "jack";
    }

    /**
     * POST http://localhost:8888/dataInteraction/test7
     * 请求头  Content-Type：application/json
     * 请求体 {"id":1,"name":"jack","age":20}
     * @param  map 参数类型为Map集合
     * @return 逻辑视图
     */
    @RequestMapping("/test7")
    public String test7(@RequestBody Map<Integer,Student> map){
        System.out.println(map);
        return "jack";
    }

    /*
       test(Map<Integer,Student> map)
       {"1"：{“id”:"1","name":"jack"}}
       List<Student>
       List<Map<Integer,Student>>
     */

    /**
     * http://localhost:8888/dataInteraction/test8
     * @return 返回单值
     */
    @RequestMapping("/test8")
    @ResponseBody
    public String test8(){
        //响应体：hello world字符串
        return "hello world";
    }
    /**
     * http://localhost:8888/dataInteraction/test9
     * 响应体：["a","b","c"]
     * @return 返回数组字符串json格式
     */
    @RequestMapping("/test9")
    @ResponseBody
    public String[] test9(){
        return new String[]{"a","b","c"};
    }
    /**
     * http://localhost:8888/dataInteraction/method
     * [{"id":1,"name":"jack","dob":null,"address":null},{"id":1,"name":"jack","dob":null,"address":null}]
     * @return 返回数组字符串json格式
     */
    @RequestMapping("/method")
    @ResponseBody
    public Student[] method(){
        Student s = new Student(1, "jack");
        Student s2 = new Student(1, "jack");
        return new Student[]{s,s2};
    }

    /**
     * http://localhost:8888/dataInteraction/method2
     * @return 集合对象
     * 响应体： [{"id":1,"name":"jack","dob":null,"address":null},{"id":1,"name":"jack","dob":null,"address":null}]
     */
    @RequestMapping("/method2")
    @ResponseBody()
    public List<Student> method2(){
        Student s = new Student(1, "jack");
        Student s2 = new Student(1, "jack");
        return Arrays.asList(s,s2);
    }

    /**
     * http://localhost:8888/dataInteraction/method3
     * 响应体： {"name":"jack","id":"20210101"}
     * @return map集合
     */
    @RequestMapping("/method3")
    @ResponseBody
    public Map method3(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("id","20210101");
        map.put("name","jack");
        return map;
    }
    @RequestMapping("/student/{id}")
    @ResponseBody
    public Map findStudentById(@PathVariable String id){
        HashMap<Object, Object> map = new HashMap<>();
        //1.状态码
        map.put("code","1000");
        //2.弹框信息
        map.put("msg","查询成功");
        //3.页面信息
        map.put("data",new Student(1,"jack"));
        return map;
    }
}