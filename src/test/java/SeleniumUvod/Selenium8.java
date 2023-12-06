package SeleniumUvod;


import org.testng.annotations.*;

public class Selenium8 {
    @BeforeClass
    public void beforeClassMethod () {
        System.out.println("************");
        System.out.println("Ispis iz BEFORE CLASS");
        System.out.println("**************");
    }

    @BeforeMethod
    public void beforeMethodMethod(){
        System.out.println("+++++++++++++");
        System.out.println("Ispis iz BEFORE METHOD");
        System.out.println("+++++++++++++");
    }

    @Test(priority = 2)
    public void testMethod1(){
        System.out.println("=================");
        System.out.println("Ispis iz TEST METHOD 1");
        System.out.println("===================");
    }

    @Test(priority = 1)
    public void testMethod2(){
        System.out.println("=================");
        System.out.println("Ispis iz TEST METHOD 2");
        System.out.println("===================");
    }

    @Test(priority = 3)
    public void testMethod3(){
        System.out.println("=================");
        System.out.println("Ispis iz TEST METHOD 3");
        System.out.println("===================");
    }



    @AfterMethod
    public void afterMethod(){
        System.out.println("----------------");
        System.out.println("Ispis iz AFTER METHOD");
        System.out.println("-----------------");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("!!!!!!!!!!!!!!");
        System.out.println("Ispis iz AFTER class");
        System.out.println("!!!!!!!!!!!!!!!!");
    }


}
