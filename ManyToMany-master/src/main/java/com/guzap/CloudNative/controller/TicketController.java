/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guzap.CloudNative.controller;

import com.guzap.CloudNative.Ticket.Ticket;
import com.guzap.CloudNative.Ticket.TicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author wdrdr
 */
@RestController
public class TicketController {
    
    @Autowired
    private TicketService ticketService;
    
    @GetMapping("/tickets")
    private ResponseEntity<List<Ticket>> getAllTickets(){
        return new ResponseEntity<List<Ticket>>(ticketService.getAllTickets(), HttpStatus.OK);
    }
    
    @PostMapping("/ticket")
    private ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
        return new ResponseEntity<Ticket>(ticketService.createTicket(ticket), HttpStatus.OK);
    }
    
    
}
