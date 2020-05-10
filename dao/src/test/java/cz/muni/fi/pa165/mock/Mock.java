package cz.muni.fi.pa165.mock;

import cz.muni.fi.pa165.entity.*;
import cz.muni.fi.pa165.enums.AmmunitionType;

/**
 * Mocked objects to be used for testing
 *
 * @author Filip Sollar
 */
public class Mock {
    public static class WeaponM {
        public static Weapon getSCAR() {
            Weapon weapon = new Weapon();

            weapon.setName("SCAR");
            weapon.setAmmunitionType(AmmunitionType.MEDIUM);
            weapon.setGunReach(200);

            return weapon;
        }

        public static Weapon getRocketLauncher() {
            Weapon weapon = new Weapon();

            weapon.setName("Rocket launcher");
            weapon.setAmmunitionType(AmmunitionType.LARGE);
            weapon.setGunReach(500);

            return weapon;
        }
    }

    public static class UserM {
        public static User getUser1() {
            User user = new User();

            user.setEmail("user@user.com");
            user.setUsername("user");
            user.setAdmin(false);
            user.setName("User");
            user.setPasswordHash("hash123");

            return user;
        }

        public static User getAdmin() {
            User user = new User();

            user.setEmail("admin@admin.com");
            user.setUsername("admin");
            user.setAdmin(true);
            user.setName("Admin");
            user.setPasswordHash("hash123");

            return user;
        }
    }

    public static class CreatureM {
        public static Creature getZombie() {
            Creature creature = new Creature();
            creature.setName("Zombie");

            creature.setAgility(20);
            creature.setHeight(180);
            creature.setWeight(100);

            return creature;
        }

        public static Creature getGazorpian() {
            Creature creature = new Creature();
            creature.setName("Gazorpian");

            creature.setAgility(10);
            creature.setHeight(320);
            creature.setWeight(240);

            return creature;
        }
    }




    public static class AreaM {
        public static Area getArea1Correct() {
            Area area = new Area();
            area.setName("Area 1");
            area.setDescription("Area 1 is a test area");
            return area;
        }

        public static Area getArea52Correct() {
            Area area = new Area();
            area.setName("Area 52");
            area.setDescription("Raid area 52 for free alien");
            return area;
        }
    }


}
