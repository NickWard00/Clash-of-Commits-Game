package ooga.model.powerup;

import ooga.model.entities.Entity;

import java.util.Arrays;
import java.util.List;

public class HealPowerUp extends PowerUp {
    private static final String POWER_UP_TYPE = "Heal";
    private static final int ADDITIONAL_HP = 1;

    public HealPowerUp(int x, int y) {
        super(POWER_UP_TYPE, x, y);
    }

    @Override
    public void activatePowerUp(Entity entity) {
        this.setAvailable(false);
        entity.changeHp(ADDITIONAL_HP);
    }


}
