
public class Demo05 {
    static int areaAfterResize(Rectangle r){
        r.setWidth(5); r.setHeight(4); return r.area();
    }

    static int areaAfterResizeSquare(Square s){
        s.setSide(4); return s.area();
    }

    public static void main(String[] args) {
        System.out.println(areaAfterResize(new Rectangle())); // 20
        System.out.println(areaAfterResizeSquare(new Square())); // 16
    }
}
