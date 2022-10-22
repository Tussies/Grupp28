package Weapon;

import com.grupp28gdx.game.Model.Body;
import com.grupp28gdx.game.Model.Weapon.Bullet;
import com.grupp28gdx.game.Model.Weapon.Gun;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GunTest {
    Gun gun = new Gun();

    @Test
    public void updatePosGun(){
        gun.positionUpdateGunAndBullets(1,1,1);
    assertTrue(gun.getBody().getXPosition() == 1 || gun.getBody().getYPosition() == 1);
    }

    @Test
    public void shootGun(){
        gun.shootGun(1,1,1);
        assertFalse(gun.getBulletsFired().isEmpty());
    }

    @Test
    public void destroyBullet() {
        gun.shootGun(1,1,1);
        gun.destroyBullet(0);
        assertTrue(gun.getBulletsFired().isEmpty());
    }

    @Test
    public void getBulletsFired(){
        assertTrue(gun.getBulletsFired() instanceof ArrayList<Bullet>);
    }

    @Test
    public void getBody(){
        assertTrue(gun.getBody() instanceof Body);
    }

}
