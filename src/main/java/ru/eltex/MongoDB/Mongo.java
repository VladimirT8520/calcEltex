package ru.eltex.MongoDB;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Mongo
{
    public static void main(String[]args) throws  IOException
    {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/db.properties");
        prop.load(fis);
        MongoClient mongoClient = MongoClients.create(prop.getProperty("db.URL"));
        MongoDatabase db = mongoClient.getDatabase(prop.getProperty("db.name"));
        MongoCollection<Document> table = db.getCollection(prop.getProperty("db.table"));
        table.deleteMany(new BasicDBObject());

        Document document = new Document("fio","Petrov Alexandr Sergeevich").append("phone","895297412584").append("password","12345678");
        table.insertOne(document);

        Document document2 = new Document("fio","Semynov Aleksey Nikaolaevich").append("phone","89529142796").append("password","true8765");
        table.insertOne(document2);

        for (Document current: table.find())
        {
            System.out.println(current.toJson());
        }

        for (Document cur:table.find())
        {
            System.out.println(cur.toJson());
        }
    }

}