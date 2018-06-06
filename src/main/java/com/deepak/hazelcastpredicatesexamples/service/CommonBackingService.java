package com.deepak.hazelcastpredicatesexamples.service;

import com.deepak.hazelcastpredicatesexamples.domain.Customer;
import com.hazelcast.com.eclipsesource.json.Json;
import com.hazelcast.com.eclipsesource.json.JsonObject;
import com.hazelcast.core.IMap;
import com.hazelcast.jet.JetInstance;
import com.hazelcast.query.SqlPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CommonBackingService {


    @Autowired
    private JetInstance jetInstance;

    public String addCustomerObjectToMap(){
        IMap<String, Customer> customerMap = jetInstance.getMap("customerMap");
        customerMap.set("One",new Customer("Ayush","1","Manikonda Hyderabad","5000087"));
        customerMap.set("Two",new Customer("Viswas","2","Wembley London","HA04AT"));
        customerMap.set("Three",new Customer("Surya","3","Harrow London","HA23DA"));
        customerMap.set("Four",new Customer("Arun","4","Slough London","SW7896"));
        customerMap.set("Five",new Customer("Santosh","5","Senkang Singapore","SW8999"));
        return "added Customer objects to Map";
    }

    public Collection<Customer> getCustomersObjectFromMap(){
        IMap<String, Customer> customerMap = jetInstance.getMap("customerMap");

        System.out.println(customerMap.values());

        Collection<Customer> customers = customerMap.values(new SqlPredicate("customerAddress like Harrow%"));
        System.out.println("Customers size===="+customers.size());
        return customers;
    }

    public String addStringObjectToMap(){
        IMap<String, String> stringMap = jetInstance.getMap("objmap");
        stringMap.put("One", "StringOne");
        stringMap.put("Two", "StringTwo");
        stringMap.put("Three", "StringThree");
        stringMap.put("Four", "StringTwo");
        return "added String to Map";
    }


    public Collection<String> getStringObjectToMap(){
        IMap<String, String> stringMap = jetInstance.getMap("objmap");

        Collection<String> stringCollection = stringMap.values(new SqlPredicate("like StringTW%"));
        System.out.println(stringCollection.size());
        return stringCollection;
    }

    public String addJsonObjectToMap(){
        IMap<String, JsonObject> jsonObjectIMap = jetInstance.getMap("jsonMap");

        JsonObject obj1 = new JsonObject();
        obj1.add("id", "1");
        obj1.add("salary", "1000");
        obj1.add("department", "Science");

        JsonObject obj2 = new JsonObject();
        obj2.add("id", "2");
        obj2.add("salary", "2000");
        obj2.add("department", "Maths");

        JsonObject obj3 = new JsonObject();
        obj3.add("id", "1");
        obj3.add("salary", "1100");
        obj3.add("department", "Social");

        JsonObject obj4 = new JsonObject();
        obj4.add("id", "4");
        obj4.add("salary", "1600");
        obj4.add("department", "Arts");


        JsonObject obj5 = new JsonObject();
        obj5.add("id", "5");
        obj5.add("salary", "1800");
        obj5.add("department", "Arts");

        jsonObjectIMap.put("1", obj1);
        jsonObjectIMap.put("2", obj2);
        jsonObjectIMap.put("3", obj3);
        jsonObjectIMap.put("4", obj4);
        jsonObjectIMap.put("5", obj5);
        return "json objects added to Map";
    }

    //give a try if it works directly on json
    public Collection<JsonObject> getJsonObjectsFromMap() {
        IMap<String, JsonObject> jsonObjectIMap = jetInstance.getMap("jsonMap");
        System.out.println("jsonObjectIMap=="+jsonObjectIMap.values());

        for(JsonObject obj : jsonObjectIMap.values()){
            System.out.println("salary=="+obj.get("salary"));
        }

        Collection<JsonObject> collection= jsonObjectIMap.values(new SqlPredicate("salary > 1500"));//Cannot do this
        //System.out.println("collection=="+collection.size());
        return jsonObjectIMap.values();

    }
}
