package Home15;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MyMap map = new MyMap();
        User user = new User("Vlad",20);
        map.put("google.com", 123);//
        map.put("youtube.com", 173);//
        map.put("google.com/2",789);//

        map.put(user,"Nikita");//
        map.put(user,"user");
        map.put("google.com/3",1);//
        map.put("google.com/4",2); //
        map.put("google.com/5",3);//
        map.put("google.com/6",4);//
        map.put("google.com/7",5);//
        map.put("google.com/8",6);//
        map.put("google.com/9",7);//
        map.put("google.com/10",9);//
        map.put("google.com/11",10);//
        map.put("google.com/12",90);//
        map.put("google.com/445",2343);//
        map.put("google.com/43432",24532432);//
        map.put("act","действовать");
        map.put("agree"," соглашаться ");
        map.put("bring","приносить");


        System.out.println(map.get("google.com/445"));
        System.out.println(map.get("google.com/11"));
        System.out.println(map.get("bring"));
        System.out.println(map.get("agree"));
        System.out.println(map.get("act"));

        System.out.println(map.get(user));
        System.out.println(map);
        System.out.println(map.length());






    }
}
