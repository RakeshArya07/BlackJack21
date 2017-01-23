package com.allstate.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import static java.lang.Integer.parseInt;

public class Card {

    private String card;
    private int point;

    @JsonProperty("card")
    public String getCard() {
        return card;
    }
    public void setCard(String card) {
        this.card = card;
    }

    public int getPoints(Card card){
        if(card.card.contains("J") || card.card.contains("Q") || card.card.contains("K"))
            return 10;
        else if(card.card.contains("A"))
            return 1;
        else
            return parseInt(card.card);
    }

}
