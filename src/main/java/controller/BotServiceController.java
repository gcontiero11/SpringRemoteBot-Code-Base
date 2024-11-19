package controller;

import com.google.gson.Gson;
import model.CardToPlay;
import model.GameIntel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class BotServiceController {


    @PostMapping(path = "mao-de-onze")
    boolean getMaoDeOnzeResponse(@RequestBody GameIntel intel) {
        return false;
    }

    @PostMapping(path = "if-raises")
    boolean decideIfRaises(@RequestBody GameIntel intel) {
        return false;
    }

    @PostMapping(path = "choose-card")
    String chooseCard(@RequestBody GameIntel intel) {
        CardToPlay cardToPlay = CardToPlay.of(intel.getCards().get(0));
        return toJSON(cardToPlay);
    }

    @PostMapping(path = "raise-response")
    int getRaiseResponse(@RequestBody GameIntel intel) {
        return 0;
    }

    @GetMapping(path = "name")
    String getBotName() {
        return "SpringRemoteBot";
    }

    private <T> String toJSON(T obj) {
        return new Gson().toJson(obj);
    }

}
