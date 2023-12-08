import java.io.IOException;
import java.util.List;

public class RunSeleniumBatch {
    public static void main(String[] args) {
        try {
            // Specify the path to your batch script
            String batchFilePath = "D:\\Download\\bios_date.bat";

            // Create a process builder for the batch script
            ProcessBuilder processBuilder = new ProcessBuilder(batchFilePath);

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to complete
            int exitCode = process.waitFor();
            
            // Print the exit code (0 usually means success)
            System.out.println("Batch script executed with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
