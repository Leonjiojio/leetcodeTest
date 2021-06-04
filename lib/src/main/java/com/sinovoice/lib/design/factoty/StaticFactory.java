package com.sinovoice.lib.design.factoty;

/**
 * Created by  on 2021/6/4.
 **/
public class StaticFactory {
    //1静态工厂方法与构造器不同的第一优势在于，它们有名字
    //2.第二个优势，不用每次被调用时都创建新对象 单例的写法也大都是用静态工厂方法来实现的。
    //3 第三个优势，可以返回原返回类型的子类
    //  可以有多个参数相同但名称不同的工厂方法 可以减少对外暴露的属性  多了一层控制，方便统一修改
    public  static SimpleFactory.Computer newCompter(){
        return new SimpleFactory.HpComputer();
    }
    public  static SimpleFactory.Computer newHpCompter(){
        return new SimpleFactory.HpComputer();
    }
    static class User{
        String name ;
        int age ;
        String description;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public static User newTestInstance() {
            User tester = new User();
            tester.setName("隔壁老张");
            tester.setAge(16);
            tester.setDescription("我住隔壁我姓张！");
            return tester;
        }
    }
}
