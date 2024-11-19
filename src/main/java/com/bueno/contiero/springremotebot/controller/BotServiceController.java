package com.bueno.contiero.springremotebot.controller;

import com.bueno.contiero.springremotebot.service.BotServiceProvider;
import com.google.gson.Gson;
import com.bueno.contiero.springremotebot.model.CardToPlay;
import com.bueno.contiero.springremotebot.model.GameIntel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BotServiceController {
    private final BotServiceProvider botImpl;

    public BotServiceController(BotServiceProvider botImpl) {
        this.botImpl = botImpl;
    }


    @PostMapping(path = "mao-de-onze")
    boolean getMaoDeOnzeResponse(@RequestBody GameIntel intel) {
        return botImpl.getMaoDeOnzeResponse(intel);
    }

    @PostMapping(path = "if-raises")
    boolean decideIfRaises(@RequestBody GameIntel intel) {
        return botImpl.decideIfRaises(intel);
    }

    @PostMapping(path = "choose-card")
    String chooseCard(@RequestBody GameIntel intel) {
        CardToPlay cardToPlay = botImpl.chooseCard(intel);
        return toJSON(cardToPlay);
    }

    @PostMapping(path = "raise-response")
    int getRaiseResponse(@RequestBody GameIntel intel) {
        return botImpl.getRaiseResponse(intel);
    }

    @GetMapping(path = "name")
    String getBotName() {
        return botImpl.getName();
    }

    private <T> String toJSON(T obj) {
        return new Gson().toJson(obj);
    }

}
