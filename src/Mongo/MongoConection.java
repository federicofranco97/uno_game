/*package Mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConection {
    public MongoConection(){
        
    }
    MongoClientURI uri  = new MongoClientURI("mongodb://ffranco97:9u8q8gvw@ds225028.mlab.com:25028/uno-db"); 
    MongoClient client = new MongoClient(uri);
    MongoDatabase db = client.getDatabase(uri.getDatabase());
    MongoCollection <Document> jugadores = db.getCollection("jugadores");
    MongoCollection <Document> pozo = db.getCollection("pozo");
    
    public void addAlgo(){
        Document doc = new Document();
        doc.put("name","pepe");
        jugadores.insertOne(doc);
    }
    
    public static void main(String[] args) {
        MongoConection mongoConection = new MongoConection();
        
    }
}
*/