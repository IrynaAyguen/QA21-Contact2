package com.telran.contact.fw;

import com.telran.contact.models.Contact;
import com.telran.contact.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> newContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Nouer", "122222", "neuer1222@web.de", "Dresden", "goalkeeper"});
        list.add(new Object[]{"Oliver22", "Nouer", "2555555", "neuer+2555@web.de", "Dresden", "goalkeeper"});
        list.add(new Object[]{"Oliver33", "Nouer", "3555555", "neuer+3555@web.de", "Dresden", "goalkeeper"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setSurName(split[1]).setPhone(split[2])
                    .setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationNegativeTestFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/userNegativeRegistration.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
