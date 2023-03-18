package Homework_6;
public class notebooks {
    static int unic_id = 0;
    private int id = ++unic_id;
    private String name;
    private String company;
    private int ram;
    private int hdd;
    private int diagonal;
    private String os;
    private String color;


    public notebooks(String name, String company, int ram, int hdd, int diagonal, String os, String color) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.ram = ram;
        this.hdd = hdd;
        this.diagonal = diagonal;
        this.os = os;
        this.color = color;
    } 

    public String getNotebookByRam(int ram) {
        return String.format("%d %s %s %d %d %d\" %s %s", id, name, company, ram, hdd, diagonal, os, color);

    }  

    public int getRam() {
        return this.ram;
    }

    public int getHDD() {
        return this.hdd;
    }

    public String getOS() {
        return this.os;
    }

    public String getColor() {
        return this.color;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %d %d %d\" %s %s", id, name, company, ram, hdd, diagonal, os, color);
    }

    public String toStringwoID() {
        return String.format("%s %s %d %d %d\" %s %s", name, company, ram, hdd, diagonal, os, color);
    }


}

