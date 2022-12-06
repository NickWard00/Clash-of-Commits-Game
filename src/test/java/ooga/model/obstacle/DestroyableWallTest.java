package ooga.model.obstacle;

import static ooga.model.obstacle.DestroyableWall.DEFAULT_HP;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashMap;
import java.util.Map;
import ooga.model.entities.Entity;
import ooga.model.hero.MainHero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DestroyableWallTest {
  private static final double TEST_DEFAULT_X_POSITION = 1.0;
  private static final double TEST_DEFAULT_Y_POSITION = 1.0;
  private DestroyableWall defaultWall;
  private DestroyableWall wall;
  private Entity entity;
  private Map<String, String> attributes;
  private int testHP;

  @BeforeEach
  void setup() {
    defaultWall = new DestroyableWall(TEST_DEFAULT_X_POSITION, TEST_DEFAULT_Y_POSITION);
    testHP = 50;
  }

  @Test
  void createWallWithoutHitpoints() {
    assertEquals(DEFAULT_HP, defaultWall.determineHP());
  }

  @Test
  void createWallWithHitpoints() {
    wall = new DestroyableWall(TEST_DEFAULT_X_POSITION, TEST_DEFAULT_Y_POSITION, testHP);
    assertEquals(testHP, wall.determineHP());
  }

  @Test
  void testBlock() {
    attributes = new HashMap<>();
    attributes.put("XPosition", Double.toString(TEST_DEFAULT_X_POSITION));
    attributes.put("YPosition", Double.toString(TEST_DEFAULT_Y_POSITION));
    attributes.put("Type", "Hero");
    attributes.put("Speed", "100");
    attributes.put("Size", "30");
    attributes.put("HP", "100");
    attributes.put("Attack", "LongRange");
    attributes.put("Direction", "SOUTH");
    attributes.put("Movement", "MOVING");
    entity = new MainHero(attributes);
    defaultWall.block(entity);
    //assertEquals(MovementState.STATIONARY.getMovement(), entity.getStateStrings().get(1));
  }

  @Test
  void changeHP() {
    defaultWall.updateHP(-10);
    assertEquals(90, defaultWall.determineHP());
  }

  @Test
  void testRemoveWallWhenNoHitpointsLeft() {
    defaultWall.updateHP(-100);
    assertFalse(defaultWall.determineOnScreen());
  }
}
