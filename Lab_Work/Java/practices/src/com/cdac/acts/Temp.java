package com.cdac.acts;

public class Temp {
    private long id;
    private String name;

    public Temp() {
    }

    public Temp(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Temp tmp=null;
        System.out.println(tmp);
        tmp= new Temp(001, "xyz");
        System.out.println(tmp);
    }
}
