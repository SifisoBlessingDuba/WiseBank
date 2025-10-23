package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.Card;

import java.util.List;

public interface ICardService extends IService<Card, String>{
    List<Card> findAll();
}
//guys check if this page will show up in the final project
//60
