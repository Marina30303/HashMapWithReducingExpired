package cachemap;

import java.util.concurrent.TimeUnit;

/**
 * Created by Марiна on 13.06.2017.
 */
public class Main
{
    public static void main(String[] args) throws InterruptedException {
        CacheMap<Integer, String> cach;
        cach = new CacheMapImpl<Integer, String>();
        // cach.put(1, "apple");
        cach.put(2, "apple");
        cach.put(3, "o");
        cach.put(4, "orange");
       // cach.remove(4);


        TimeUnit.SECONDS.sleep(5);
        cach.clearExpired();

      //  System.out.println(cach.size());
        //System.out.println(cach.containsKey(3));
        System.out.println(cach.containsValue("o"));
        //System.out.println(cach.isEmpty());
      //  System.out.println(cach.get(3));
        //Clock.setTime(2000);
      //  System.out.println();
       // cach.remove(1);
        //cach.clear();
        System.out.println(cach.size());

    }


}
