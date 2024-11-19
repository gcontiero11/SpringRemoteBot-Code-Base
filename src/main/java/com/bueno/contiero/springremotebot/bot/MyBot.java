package com.bueno.contiero.springremotebot.bot;

import com.bueno.contiero.springremotebot.model.CardToPlay;
import com.bueno.contiero.springremotebot.model.GameIntel;
import com.bueno.contiero.springremotebot.service.BotServiceProvider;
import org.springframework.stereotype.Service;

@Service
public class MyBot implements BotServiceProvider {
    @Override
    public boolean getMaoDeOnzeResponse(GameIntel intel) {
        return false;
    }

    @Override
    public boolean decideIfRaises(GameIntel intel) {
        return false;
    }

    @Override
    public CardToPlay chooseCard(GameIntel intel) {
        return CardToPlay.of(intel.getCards().get(0));
    }

    @Override
    public int getRaiseResponse(GameIntel intel) {
        return 0;
    }
}
