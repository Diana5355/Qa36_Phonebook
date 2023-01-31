package manager;


import model.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> loginDataCls(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"sonya@gmail.com", "Ss12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginDataUser(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"sonya@gmail.com", "Ss12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginDataUserFromFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("Qa36_Phonebook/src/test/resources/data.csv")));
        String line = bufferedReader.readLine(); // noa@gmail.com,Nnoa12345$
        while(line != null){
            String[] split = line.split(","); // [0] "noa@gmail.com" [1] "Nnoa12345$"
            list.add(new Object[]{User.builder().email(split[0]).password(split[1])});
            line = bufferedReader.readLine();
        }
        return list.iterator();

    }
}
