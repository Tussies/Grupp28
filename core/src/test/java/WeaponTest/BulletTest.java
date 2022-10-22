package WeaponTest;

import com.grupp28gdx.game.Model.Weapon.Bullet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class BulletTest {
    Bullet bullet = new Bullet(1, 1, 1);
    ArrayList<Bullet> bulletList = new ArrayList() {
        {
            add(bullet);
        }
    };


    @Test
    public void updateBulletPos() {
        bullet.positionUpdateBullet(bulletList, 1);
        assertTrue(bulletList.get(0).getXPosition() == 2);
    }

    @Test
    public void getXPos() {
        assertTrue(bullet.getXPosition() == 1);
    }

    @Test
    public void getYPos() {
        assertTrue(bullet.getYPosition() == 1);
    }

    @Test
    public void getWidth() {
        assertTrue(bullet.getWidth() == 0.2f);
    }

    @Test
    public void getHeight() {
        assertTrue(bullet.getHeight() == 0.2f);
    }


}
