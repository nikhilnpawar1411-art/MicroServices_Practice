package com.example.cards.service;

import com.example.cards.dto.CardsDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public interface ICardsService{

    void createCard(String mobileNumber);

    CardsDto fetchCardsDetails(@Valid @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber);

    boolean updateCardsDetails(@Valid CardsDto cardsDto);

    boolean deleteCards(@Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber);
}
