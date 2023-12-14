package exam01;

import java.util.ArrayList;

public class Ex02 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        //System.out.println(names);
        for(int i = names.size()-1; i >= 0; i--){
            String name = names.get(i);
            System.out.println(names.remove(i));
            names.add(name);
        }
        System.out.println(names);
    }
}
