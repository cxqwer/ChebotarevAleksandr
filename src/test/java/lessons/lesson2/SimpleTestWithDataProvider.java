package lessons.lesson2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SimpleTestWithDataProvider {
    @DataProvider
    private Object[][] simpleDataProvider() {
        return new Object[][]{
                {0, "Ivan"},
                {1, "Roman"},
                {2, "Dima"}
        };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void simpleTest(int i, String s) {
        System.out.println("int = " + i + "\n" + "String = " + s);

    }
}
