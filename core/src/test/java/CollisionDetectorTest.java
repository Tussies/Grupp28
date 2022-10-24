import com.grupp28gdx.game.Model.handlers.GemstoneHandler;
import com.grupp28gdx.game.Model.handlers.ObstacleHandler;
import com.grupp28gdx.game.Model.Factories.EasyModeFactory;
import com.grupp28gdx.game.Model.GemstoneGroup.BigGemstone;
import com.grupp28gdx.game.Model.GemstoneGroup.Gemstone;
import com.grupp28gdx.game.Model.Guns.Bullet;
import com.grupp28gdx.game.Model.ObstacleGroup.DestroyableObstacle;
import com.grupp28gdx.game.Model.PlayerGroup.GreenPlayer;
import com.grupp28gdx.game.Model.Utils.CollisionDetector;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class CollisionDetectorTest {
    EasyModeFactory eFac = new EasyModeFactory();

    ObstacleHandler oHandler = new ObstacleHandler(eFac);
    GemstoneHandler gHandler = new GemstoneHandler(eFac);
    GreenPlayer gPlayer = new GreenPlayer();

    CollisionDetector colDet = new CollisionDetector(oHandler, gHandler, gPlayer.getGun(), gPlayer);

    DestroyableObstacle destObs = new DestroyableObstacle(0, 0, 0);


    @Test
    public void updateTestObject() {

    }


    /*@Test
    public void hasCollidedPlayerGround() {
        assertTrue(colDet.hasCollided(gPlayer, 1.0f));
    }

    @Test
    public void hasCollidedPlayerObstacle() {
        assertTrue(colDet.hasCollided(gPlayer.getBody(), destObs.getBody()));
    }*/

    @Test
    public void checkCollisionBulletObstacle() {
        Bullet tempBullet = new Bullet(0, 0, 1);
        assertTrue(colDet.checkCollision(tempBullet, destObs)
        );
    }

    @Test
    public void checkCollisionPlayerObstacle() {
        assertTrue(colDet.checkCollision(gPlayer, destObs));
    }

    @Test
    public void checkCollisionPlayerGemstone(){
        Gemstone gStone = new BigGemstone(0,0,0);
        assertTrue(colDet.checkCollision(gPlayer, gStone));
    }


}
