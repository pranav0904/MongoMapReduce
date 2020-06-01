
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author khist
 */
public class logAccess {
    
    public static void main(String[] args) throws FileNotFoundException {

    //step 1: Make connection
        MongoClient connection = MongoClients.create();
    //step 2: select database
        MongoDatabase db = connection.getDatabase("mylogs");
    //step 3: select collection
        MongoCollection<Document> collection = db.getCollection("access");
        
       
    //creating File instance to reference text file in Java
        File csvfile = new File("C:/logs/access.csv");
        
        boolean firstLine = true;
        String delims = ",";
        
        List<String> ColName=new ArrayList<String>();
        
        Scanner scanner = new Scanner(csvfile);

    //Movies  
        while (scanner.hasNextLine()) {
            String splitString = null;
            //tokenize or split the line
            if (firstLine) {
                splitString = scanner.nextLine();
                String[] tokens = splitString.split(delims);
                int tokenCount = tokens.length;
                for (int j = 0; j < tokenCount; j++) {
                ColName.add(tokens[j]);
                }   
                firstLine = false;
            }
            splitString = scanner.nextLine();
            String[] tokens = splitString.split(delims);
            int tokenCount = tokens.length;
            //create an instance of a Document
            Document doc1 = new Document();
            for (int j = 0; j < tokenCount; j++) {
                //create an instance of a Document
                doc1.append(ColName.get(j),tokens[j]);
            }
            //step 5: save doc
            collection.insertOne(doc1);
        }
    }   
}
