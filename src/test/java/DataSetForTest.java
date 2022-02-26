import org.testng.annotations.DataProvider;

public class DataSetForTest {
    @DataProvider(name ="data to provide")
    public Object[][] dataForPost(){

        return new Object[][]{
                {"Rafiqul","Islam","6"},
                {"Robiul","Islam","7"}
        };
    }
}
