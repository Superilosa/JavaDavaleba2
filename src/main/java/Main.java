import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data.txt"));
            String i;
            int n = 0;
            double sum = 0;
            while((i=reader.readLine()) != null){
                sum += Double.parseDouble(i);
                n++;
            }
            reader.close();
            double avg = sum/n;
            logger.trace("Average is " + avg);
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/data.txt", true));
            writer.write("\n");
            writer.write(String.valueOf(avg));
            writer.close();
            logger.trace("Successfully added to file");
        }catch(IOException ex){
            logger.error("Error reading data", ex);
        }catch(Exception ex){
            logger.error("Error", ex);
        }
    }

}
