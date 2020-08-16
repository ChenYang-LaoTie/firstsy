package com.example.demo.modules.test.service;

import com.example.demo.modules.common.vo.Result;
import com.example.demo.modules.test.entity.Card;

public interface CardService {

    Result<Card> insertCard(Card card);
}
