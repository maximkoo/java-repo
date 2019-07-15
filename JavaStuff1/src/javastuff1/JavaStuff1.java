package javastuff1;
public class JavaStuff1 {
    public static void main(String[] args) {
        JavaStuff1 i=new JavaStuff1();        
    }
    
    public JavaStuff1(){
        C3 c=new C3();
        c.stuff3();
        m1(new C3(){public void trololo(){System.out.println("2");zzz();} 
        public void zzz(){System.out.println("ZZZZ");}});
        //m1(()->System.out.println("3"));
        
        // C4 does everything
        Yielder x=new C4(){public void yield(){System.out.println("Yielder, yield!!!1");}};
        x.yield();
        new C4(){public void yield(){System.out.println("Yielder, yield!!!2");}}.yield();
        
        //x.yield();
        
        new C5();
    }
    
    public void m1(Trololoable x){
        System.out.println("1");
        x.trololo();
    }
    
    
    @FunctionalInterface
    public interface Trololoable{
        public void trololo();
    }
    @FunctionalInterface
    public interface Trololoable2{
        public void trololo2();
    }
    
    public class C3 implements Trololoable,Trololoable2{
        public void stuff3() {
        }

        public void zzz(){
        
        }
        @Override
        public void trololo() {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            System.out.println("Real Trololo");
        }

        @Override
        public void trololo2() {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    public interface Yielder{
        public void yield();
    }
    
    public class C4 implements Yielder{

        @Override
        public void yield() {
        }
    }
    
    public class C5{
        public C5(){
            Trololoable t=()->System.out.println("We trololo!");        
            t.trololo();
        }  
    
    
    }
    
}
