package app.model;

import app.entities.User;
import org.graalvm.compiler.lir.LIRInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();

    private List<User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(User user) {
        model.add(user);
    }

    public int getLastId() {
        return model.size() > 0 ? model.get(model.size() - 1).getId() : 0;
    }

    public List<String> getUsername() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public List<String> getPassword() {
        return model.stream()
                .map(User::getPassword)
                .collect(Collectors.toList());
    }

    public List<Integer> getId() {
        return model.stream()
                .map(User::getId)
                .collect(Collectors.toList());
    }

    public List<User> list() {
        return model;
    }

    public User getUserById(int id) {
        for (int i = 0; i < model.size(); i++) {
            if (model.get(i).getId() == id) return model.get(i);
        }
        return null;
    }

    public void remove(int id) {
        System.out.print("id = " + id + " " + model.size());
        for (int i = 0; i < model.size(); i++) {
            if (id == model.get(i).getId()) model.remove(i);
        }
    }
}
