package Weapon;

import com.grupp28gdx.game.Model.Weapon.Bullet;
import com.grupp28gdx.game.Model.Weapon.Gun;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BulletTest {
    Bullet bullet = new Bullet(1, 1, 1);
    ArrayList<Bullet> bullets = new ArrayList() {
        {
            add(bullet);
        }
    };


    @Test
    public void updateBulletPos() {

    }

}
