package Lab2;

import Lab2.Interfaces.*;

class Journal implements Printable {

    private String name;

    String getName(){
        return name;
    }

    Journal(String name){
        this.name = name;
    }
    public void print() {
        System.out.println(name);
    }
}
