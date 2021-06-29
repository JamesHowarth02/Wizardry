package me.Wizardry.particles;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class SpawnParticle extends BukkitRunnable {

    private final Location location;
    private final Location dropLoc;
    private boolean playedInitial = false;
    private boolean playedGuardian = false;
    private int sparkTimer = 500;

    public SpawnParticle(Location location) {
        this.location = location;
        dropLoc = new Location(location.getWorld(), location.getX(), location.getWorld().getHighestBlockAt(location).getY() + 1, location.getZ());
    }

    public void run() {
        double step = 1;
        double y = location.getY();
        location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, location.getX(), y, location.getZ(),
                0,  0,  new Random().nextDouble(), 0,
                0.2, null, true);
        location.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, location.getX(),
                y + new Random().nextDouble() * step,
                location.getZ(),
                0,  0, -1, 0,
                1, null, true);
        if (y % (step * 2) == 0) {
            location.getWorld().spawnParticle(Particle.LAVA, location.getX(), y + new Random().nextDouble(),
                    location.getZ(),
                    0,  0, new Random().nextDouble(), 0,
                    0.2, null, true);
        }
        if (!playedInitial) {
            location.getWorld().playSound(dropLoc, Sound.ENTITY_ENDER_DRAGON_DEATH, (float) 1f, 0.5f);
            location.getWorld().playSound(dropLoc, Sound.ITEM_TOTEM_USE, (float) 1f, 0.5f);
            playedInitial = true;
        }
        if (y <= dropLoc.getY()) {
            if (y % (step * 5) == 0) {
                location.getWorld().spawnParticle(Particle.LAVA, dropLoc,
                        0, 0, new Random().nextDouble(), 0,
                        1, null, true);
            }
            sparkTimer--;
            if (sparkTimer <= 0) {
                this.cancel();
                location.getWorld().playSound(dropLoc, Sound.ENTITY_PLAYER_LEVELUP, (float) 1f, 0.5f);
                location.getWorld().playSound(dropLoc, Sound.BLOCK_PORTAL_TRAVEL, (float) 1f, 0.5f);
            }else if(sparkTimer<350) {
            	if(!playedGuardian) {
            		playedGuardian = true;
            		location.getWorld().playSound(dropLoc, Sound.ENTITY_ELDER_GUARDIAN_CURSE, (float) 1f, 0.5f);
            		location.getWorld().playSound(dropLoc, Sound.ENTITY_ENDER_DRAGON_GROWL, (float) 1f, 0.5f);
            	}
            	location.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, location.getX(), y + new Random().nextDouble(),
                        location.getZ(),
                        0,  0, new Random().nextDouble(), 0,
                        0.2, null, true);
            }
        }
        y -= step;
    }

}