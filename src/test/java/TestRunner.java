import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestRunner {
    public static void runTests(LauncherDiscoveryRequest request, String filePath) {
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            listener.getSummary().printTo(printWriter);
            printWriter.close();
            fileWriter.close();
            System.out.println("Test results written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "test_results.txt";
        LauncherDiscoveryRequest testScenarios = TestScenarios.getTestScenarios();
        TestRunner.runTests(testScenarios, filePath);
    }
}
