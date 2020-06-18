import Poi.Poi_read;

import java.io.IOException;

public class Main {
    public static void main(String [] args) throws IOException {
        System.out.println("hello home!!!");
        Poi_read p = new Poi_read("C:\\Users\\Admin\\Downloads\\test.xls");
        p.readToStipZaGod("C:\\Users\\Admin\\Downloads\\Parus8.xls");
    }
}
