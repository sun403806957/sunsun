
public class test {

    public static void main(String[] args) {
      Son s = new Son();
    }
}
class Super{
    Super(){
        System.out.println("AAAAAAAA");
    }
}
class Son extends Super{
    Son(){
        System.out.println("BBBBBBBBBB");
    }
}