package br.com.evandrolacerda.reader;

import br.com.evandrolacerda.reader.pojo.Address;
import com.mongodb.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader();

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        DB database = mongoClient.getDB("address");

        DBCollection collection = database.getCollection("addresses");

        List<Address> addressList = reader.getList();

        for ( Address address : addressList )
        {
            collection.insert(address.toDBObject());
        }
    }
}
