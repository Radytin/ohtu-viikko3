/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ohtu.domain.User;

/**
 *
 * @author hamalkre
 */
public class FileUserDao implements UserDao {
    private String path;
    
    public FileUserDao(String path) {
        this.path = path;
}

        @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<User>();;

        try {
            Scanner s = new Scanner(new File(path));
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] parts = line.split(":");
                User user = new User(parts[0], parts[1]); 
                users.add(user);  
            }
        } catch (Exception e) {
        }

        return users;
    }

    @Override
    public User findByName(String name) {
        List<User> users = listAll();
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        try {
            FileWriter k = new FileWriter(path, true);
            String rivi = "\n" + user.getUsername() + ":" + user.getPassword();
            k.write(rivi);
            k.close();
        } catch (Exception e) {
        }
}
    
}
