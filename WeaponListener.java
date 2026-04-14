package com.crazyweapons;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.RayTraceResult;

public class WeaponListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        
        Player player = (Player) event.getDamager();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (item == null || !item.hasItemMeta()) return;
        
        String displayName = ChatColor.stripColor(item.getItemMeta().getDisplayName());
        
        if (displayName.equals("Explosive Sword")) {
            event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 2.0f, false, false);
            event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION, event.getEntity().getLocation(), 10);
        }
        
        if (displayName.equals("Freeze Ray") && event.getEntity() instanceof LivingEntity) {
            LivingEntity target = (LivingEntity) event.getEntity();
            target.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 100, 5));
            target.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 100, 3));
            target.getWorld().spawnParticle(Particle.SNOWFLAKE, target.getLocation(), 30);
            target.getWorld().playSound(target.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0f, 0.5f);
        }
        
        if (displayName.equals("Vampire Blade") && event.getEntity() instanceof LivingEntity) {
            double healAmount = event.getDamage() * 0.5;
            if (player.getHealth() + healAmount > player.getMaxHealth()) {
                player.setHealth(player.getMaxHealth());
            } else {
                player.setHealth(player.getHealth() + healAmount);
            }
            player.getWorld().spawnParticle(Particle.HEART, event.getEntity().getLocation(), 5);
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1.0f, 1.0f);
        }

        if (displayName.equals("Tornado Axe") && event.getEntity() instanceof LivingEntity) {
            for (Entity nearby : player.getNearbyEntities(6, 6, 6)) {
                if (nearby instanceof LivingEntity && !nearby.equals(player)) {
                    nearby.setVelocity(nearby.getLocation().toVector().subtract(player.getLocation().toVector()).normalize().multiply(1.5).setY(1.8));
                    nearby.getWorld().spawnParticle(Particle.CLOUD, nearby.getLocation(), 20);
                }
            }
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PHANTOM_FLAP, 1.0f, 0.5f);
        }

        if (displayName.equals("Poison Dagger") && event.getEntity() instanceof LivingEntity) {
            LivingEntity target = (LivingEntity) event.getEntity();
            target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 120, 2));
            target.getWorld().spawnParticle(Particle.EFFECT, target.getLocation(), 30);
            target.getWorld().playSound(target.getLocation(), Sound.ENTITY_SPIDER_HURT, 1.0f, 1.5f);
        }

        if (displayName.equals("Fire Hammer") && event.getEntity() instanceof LivingEntity) {
            LivingEntity target = (LivingEntity) event.getEntity();
            target.setFireTicks(200);
            target.getWorld().spawnParticle(Particle.FLAME, target.getLocation(), 40);
            target.getWorld().playSound(target.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1.0f, 0.8f);
        }

        if (displayName.equals("Soul Reaper") && event.getEntity() instanceof LivingEntity) {
            LivingEntity target = (LivingEntity) event.getEntity();
            target.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 2));
            target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0));
            target.getWorld().spawnParticle(Particle.SOUL, target.getLocation(), 25);
            target.getWorld().playSound(target.getLocation(), Sound.ENTITY_WITHER_HURT, 0.8f, 1.5f);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        
        if (item == null || !item.hasItemMeta()) return;
        
        String displayName = ChatColor.stripColor(item.getItemMeta().getDisplayName());
        
        if (displayName.equals("Lightning Staff")) {
            RayTraceResult result = player.rayTraceBlocks(50);
            Location target = result != null ? result.getHitBlock().getLocation() : player.getTargetBlock(null, 50).getLocation();
            
            player.getWorld().strikeLightning(target);
            player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, target, 50);
            player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0f, 1.0f);
            event.setCancelled(true);
        }
        
        if (displayName.equals("Teleport Wand")) {
            RayTraceResult result = player.rayTraceBlocks(30);
            if (result != null && result.getHitBlock() != null) {
                Location teleportLoc = result.getHitBlock().getLocation().add(0, 1, 0);
                player.getWorld().spawnParticle(Particle.PORTAL, player.getLocation(), 50);
                player.teleport(teleportLoc);
                player.getWorld().spawnParticle(Particle.PORTAL, teleportLoc, 50);
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
            }
            event.setCancelled(true);
        }

        if (displayName.equals("Gravity Mace")) {
            for (Entity nearby : player.getNearbyEntities(10, 10, 10)) {
                if (nearby instanceof LivingEntity && !nearby.equals(player)) {
                    org.bukkit.util.Vector pull = player.getLocation().toVector().subtract(nearby.getLocation().toVector()).normalize().multiply(2.5);
                    nearby.setVelocity(pull);
                    nearby.getWorld().spawnParticle(Particle.REVERSE_PORTAL, nearby.getLocation(), 15);
                }
            }
            player.getWorld().playSound(player.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1.0f, 0.5f);
            event.setCancelled(true);
        }
    }
}
