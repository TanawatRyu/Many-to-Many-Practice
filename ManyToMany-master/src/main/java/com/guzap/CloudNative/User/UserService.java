/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guzap.CloudNative.User;

import com.guzap.CloudNative.Ticket.Ticket;
import com.guzap.CloudNative.Ticket.TicketRepository;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wdrdr
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUserById(User user) {
        return userRepository.save(user);
    }

    public User purchaseTicket(HashMap registerDetail) {
        long userId = Long.valueOf((int) (registerDetail.get("userId")));
        long ticketId = Long.valueOf((int) (registerDetail.get("ticketId")));
        System.out.println("userId : " + userId + " || tickerId : " + ticketId);
        User user = userRepository.findById(userId).get();
        System.out.println(user.toString());
        Ticket ticket = ticketRepository.findById(ticketId).get();
        user.getTickets().add(ticket);
        ticket.getUsers().add(user);
        return userRepository.save(user);
    }

    public User findUserById(long userId) {
        return userRepository.getOne(userId);
    }

}
