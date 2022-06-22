package com.czh.JDK8;

import com.czh.entity.Student;
import com.czh.repository.StreamRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/student")
class TestStream {
    StreamRepo streamRepo;

    TestStream(StreamRepo streamRepo) {
        this.streamRepo = streamRepo;
    }

    @RequestMapping("/findAll")
    List<Student> findAll() {
        List<Student> studentList = streamRepo.findAll();
        return studentList;
    }

    @RequestMapping("/getListStudent")
    String getListStudent() {
        List<Student> studentList = streamRepo.findAll();
        return studentList.stream().filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(Student::getName))
                .map(Student::getName)
                .toString();
    }

    @PostMapping("/testStreamFilter")
    List<Student> testStreamFilter() {
        List<Student> studentList = streamRepo.findAll();
        return studentList.stream()
                .filter(student -> student.getName().equals("陈可心"))
                .collect(Collectors.toList());
    }

    // 流中去除重复
    @PostMapping("/testStreamDistinct")
    List<Student> testStreamDistinct() {
        List<Student> studentList = streamRepo.findAll();
        return studentList.stream().distinct().collect(Collectors.toList());
    }

    //返回指定个数的流
    @PostMapping("/testStreamLimit")
    java.util.stream.Stream<Student> testStreamLimit() {
        List<Student> studentList = streamRepo.findAll();
        return studentList.stream().limit(3);
    }

    //skip 跳过流中的前几个元素
    @PostMapping("/testStreamSkip")
    java.util.stream.Stream<Student> testStreamSkip() {
        List<Student> studentList = streamRepo.findAll();
        return studentList.stream().skip(3);
    }

    //Map 流映射 返回每个字符串的长度
    @PostMapping("/testStreamMap")
    Stream<Integer> testStreamMap() {
        List<String> listString = Arrays.asList("Java 8", "Lambda", "In", "Action");
        Stream<Integer> streamInteger = listString.stream().map(String::length);
        return streamInteger;
    }

    //flatMap 流映射(数组转流) 返回每个字符串的长度
    @PostMapping("/testStreamFlatMap")
    List<String> testStreamFlatMap() {
        List<String> listString = Arrays.asList("Hello", "world");
        return listString.stream().map(m -> m.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    // 统计 流中元素的个数
    @PostMapping("/testStreamCount")
    Long testStreamCount() {
        List<String> listString = Arrays.asList("Hello", "world");
        return listString.stream().count();
    }
    @PostMapping("/testStreamCounting")
    Long testStreamCounting() {
        List<String> listString = Arrays.asList("Hello", "world");
        return listString.stream().collect(counting());
    }
    // 查找
    // 随机查询一个
    @PostMapping("/testStreamFindAny")
    Optional<Integer> testStreamFindAny(){
        List<Integer> listString = Arrays.asList(1,2,3,4,5);
        return listString.stream().filter(integer -> integer != 3).findAny();
    }
    // 随机查询一个
    @PostMapping("/testStreamFindFirst")
    Optional<Integer> testStreamFindFirst(){
        List<Integer> listString = Arrays.asList(1,2,3,4,5);
        return listString.stream().filter(integer -> integer != 3).findFirst();
    }
    //reduce 将流中的元素组合起来
    // sum max min
    @PostMapping("/testStreamReduce")
    Integer testStreamReduce(){
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        return  integerList.stream().reduce(0,Integer::sum);
    }
    //Foreach
    @PostMapping("/testStreamForeach")
    void testStreamForeach(){
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.stream().forEach(System.out::print);
    }
    // 返回集合
    @PostMapping("/testStreamList")
    List<String> testStreamList(){
       List<Student> studentList= streamRepo.findAll();
       return  studentList.stream().map(Student::getName).collect(Collectors.toList());
    }
    // groupingBy
    @PostMapping("/testStreamgroupingBy")
    Map<String,List<Student>> testStreamgroupingBy(){
        List<Student> studentList= streamRepo.findAll();
        return  studentList.stream().collect(groupingBy(Student::getSex));
    }

}
