package core;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.opencsv.CSVWriter;
import io.qameta.allure.Allure;

public class WriteCsvFile {
    public static void writeDataLineByLine(String filePath, List<String[]> data, String[] headers) {
        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);

            writer.writeNext(headers);
            for(String[] line: data) {
                writer.writeNext(line);
            }
            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    public static void attachCsv(String filePath, String fileName) throws IOException {
        byte[] array = Files.readAllBytes(Paths.get(filePath));
        ByteArrayOutputStream attachmentContent = new ByteArrayOutputStream();
        attachmentContent.write(array);

        Allure.addAttachment(fileName, "text/csv", new ByteArrayInputStream(attachmentContent.toByteArray()), ".csv");
    }


}