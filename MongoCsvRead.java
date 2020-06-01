import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author khist
 */
public class MongoCsvRead {
    
    public static void main(String[] args) throws FileNotFoundException {

    //step 1: Make connection
        MongoClient connection = MongoClients.create();
    //step 2: select database
        MongoDatabase db = connection.getDatabase("myMovies");
    //step 3: select collection
        MongoCollection<Document> collection1 = db.getCollection("movies");
        MongoCollection<Document> collection2 = db.getCollection("ratings");
        MongoCollection<Document> collection3 = db.getCollection("tags");
        
       
    //creating File instance to reference text file in Java
        File csvfile1 = new File("C:/10M/movies.csv");
        File csvfile2 = new File("C:/10M/ratings.csv");
        File csvfile3 = new File("C:/10M/tags.csv");
        
        boolean firstLine = true;
        String delims = ",";
        
        List<String> ColName1=new ArrayList<String>();
        List<String> ColName2=new ArrayList<String>();
        List<String> ColName3=new ArrayList<String>();

    //Creating Scanner instance to read File in Java
        Scanner scanner1 = new Scanner(csvfile1);
        Scanner scanner2 = new Scanner(csvfile2);
        Scanner scanner3 = new Scanner(csvfile3);

    //Movies  
        while (scanner1.hasNextLine()) {
            String splitString = null;
            //tokenize or split the line
            if (firstLine) {
                splitString = scanner1.nextLine();
                String[] tokens = splitString.split(delims);
                int tokenCount = tokens.length;
                for (int j = 0; j < tokenCount; j++) {
                ColName1.add(tokens[j]);
                }   
                firstLine = false;
            }
            splitString = scanner1.nextLine();
            String[] tokens = splitString.split(delims);
            int tokenCount = tokens.length;
            //create an instance of a Document
            Document doc1 = new Document();
            for (int j = 0; j < tokenCount; j++) {
                //create an instance of a Document
                doc1.append(ColName1.get(j),tokens[j]);
            }
            //step 5: save doc
            collection1.insertOne(doc1);
        }
        
    //ratings
        boolean firstLine2 = true;
        while (scanner2.hasNextLine()) {
            String splitString = null;
            //tokenize or split the line
            if (firstLine2) {
                splitString = scanner2.nextLine();
                String[] tokens = splitString.split(delims);
                int tokenCount = tokens.length;
                for (int j = 0; j < tokenCount; j++) {
                ColName2.add(tokens[j]);
                }   
                firstLine2 = false;
            }
            splitString = scanner2.nextLine();
            String[] tokens = splitString.split(delims);
            int tokenCount = tokens.length;
            //create an instance of a Document
            Document doc2 = new Document();
            for (int j = 0; j < tokenCount; j++) {
                //create an instance of a Document
                doc2.append(ColName2.get(j),tokens[j]);
            }
            //step 5: save doc
            collection2.insertOne(doc2);
        }
        
    //tags
        boolean firstLine3 = true;
        while (scanner3.hasNextLine()) {
            String splitString = null;
            //tokenize or split the line
            if (firstLine3) {
                splitString = scanner3.nextLine();
                String[] tokens = splitString.split(delims);
                int tokenCount = tokens.length;
                for (int j = 0; j < tokenCount; j++) {
                ColName3.add(tokens[j]);
                }   
                firstLine3 = false;
            }
            splitString = scanner3.nextLine();
            String[] tokens = splitString.split(delims);
            int tokenCount = tokens.length;
            //create an instance of a Document
            Document doc3 = new Document();
            for (int j = 0; j < tokenCount; j++) {
                //create an instance of a Document
                doc3.append(ColName3.get(j),tokens[j]);
            }
            //step 5: save doc
            collection3.insertOne(doc3);
        }
    
//        System.out.println(collection1.find().first().toJson());  
}

}
