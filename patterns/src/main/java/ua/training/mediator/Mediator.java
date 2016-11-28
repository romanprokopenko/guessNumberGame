package ua.training.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 27.11.2016.
 */
public class Mediator {
    public static void main(String[] args) {
        TextChat chat = new TextChat();
        User admin = new Admin(chat);
        User user1 = new SimpleUser(chat);
        User user2 = new SimpleUser(chat);
        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);
        user1.sendMessage("user 1 sends message");
        admin.sendMessage("admin sends message");
    }

}

interface User {
    void sendMessage(String message);

    void getMessage(String message);
}

interface Chat {
    void sendMessage(String message, User user);
}

class Admin implements User {
    Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        // TODO Auto-generated method stub
        chat.sendMessage(message, this);

    }

    @Override
    public void getMessage(String message) {
        // TODO Auto-generated method stub
        System.out.println("admin gets a message = " + message + ".");
    }

}

class SimpleUser implements User {
    Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        // TODO Auto-generated method stub
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        // TODO Auto-generated method stub
        System.out.println("user gets a message = " + message + ".");
    }

}

class TextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        // TODO Auto-generated method stub
        for (User u : users) {
            u.getMessage(message);
        }
        admin.getMessage(message);
    }
}
