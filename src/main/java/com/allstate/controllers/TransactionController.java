package com.allstate.controllers;


import com.allstate.entities.Transaction;
import com.allstate.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/games")
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @RequestMapping(value = "/{userId}/{bet}", method = RequestMethod.POST)
    public Transaction startGame(@PathVariable int userId, @PathVariable int bet) {
        return this.transactionService.startGame(userId, bet);
    }
}
