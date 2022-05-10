package com.zyp.interview.demo.algorithm.compare;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/25 15:50
 */
public class ComparableTest {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Student implements Serializable {
        private static final long serialVersionUID = 5421576892482703157L;
        private String name;
        private Integer id;
        private Integer age;
    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 2, 22);
        Student student2 = new Student("B", 3, 23);
        Student student3 = new Student("C", 1, 20);

        Student[] students = new Student[]{student1, student2, student3};
        System.out.println("排序前：" + Arrays.toString(students));
        Arrays.sort(students, (o1, o2) -> o1.id - o2.id);
        Arrays.sort(students, Comparator.comparingInt(o -> o.id));
        System.out.println("id升序排序后：" + Arrays.toString(students));
        Arrays.sort(students, (o1, o2) -> o2.age - o1.age);
        System.out.println("年龄降序排序后：" + Arrays.toString(students));
    }
}
