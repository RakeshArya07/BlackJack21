package com.allstate.services;

import com.allstate.entities.Transaction;
import com.allstate.entities.User;
import com.allstate.enums.Action;
import com.allstate.enums.Result;
import com.allstate.models.Card;
import com.allstate.repositories.ITransactionRepository;
import com.allstate.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private ITransactionRepository transactionRepository;
    private IUserRepository userRepository;
    private GameService gameService;

    @Autowired
    public void setTransactionRepository(ITransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setQuoteService(GameService gameService) {
        this.gameService = gameService;
    }


    public Transaction startGame(int userId, int bet) {
        User user = this.userRepository.findOne(userId);
        Card userCard1 = gameService.getCards();
        Card userCard2 = gameService.getCards();
        Card dealerCard1 = gameService.getCards();
        Card dealerCard2 = gameService.getCards();
        Transaction gameTransaction = new Transaction();
        if(bet!=0){
            String userCards =userCard1.getCard()+","+userCard2.getCard();
            String dealerCards =dealerCard1.getCard()+","+dealerCard2.getCard();
            int userPoint = userCard1.getPoints(userCard1)+userCard2.getPoints(userCard2);
            int dealerPoint = dealerCard1.getPoints(dealerCard1)+dealerCard2.getPoints(dealerCard2);
            gameTransaction = new Transaction(Action.HIT,userCards,dealerCards,userPoint,dealerPoint,bet,user);
            if(userPoint==21)
                gameTransaction.setResult(Result.WIN);

            this.transactionRepository.save(gameTransaction);
        }
        return gameTransaction;
    }

//    public Transaction hit(){
//
//    }
//
//    public  Transaction stand(){
//
//    }


}
