package com.example.demo.modules.test.service.impl;

import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.test.entity.Card;
import com.example.demo.modules.test.repository.CardRepository;
import com.example.demo.modules.test.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    @Transactional
    public Result<Card> insertCard(Card card) {
        cardRepository.saveAndFlush(card);
        return new Result<Card>(Result.ResultStatus.SUCCESS.status, "Insert success.", card);
    }
}
