import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BT1_Vigenere_findK_input_output_file {

    public ArrayList<String> readfile(String file) {
        ArrayList<String> stringsArray = new ArrayList<String>();
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            while (line != null) {
                stringsArray.add(line);
                //System.out.println(line);
                line = bufferedReader.readLine();
            }
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BT1_Vigenere_findK_input_output_file.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BT1_Vigenere_findK_input_output_file.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(BT1_Vigenere_findK_input_output_file.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return stringsArray;
    }
}
