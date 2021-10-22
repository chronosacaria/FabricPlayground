package chronosacaria.testmod.effects;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class WeaponEffects {
    //Effects for ServerPlayerEntityMixin
    public static void applyStrength(ServerPlayerEntity playerEntity){
        World world = playerEntity.getEntityWorld();
        ItemStack mainHandStack = playerEntity.getMainHandStack();

        if (mainHandStack.getItem() == Items.NETHERITE_SWORD.asItem() && world.getTime() % 30 == 0){
            StatusEffectInstance strength = new StatusEffectInstance(StatusEffects.STRENGTH, 42, 1, false, false);
            playerEntity.addStatusEffect(strength);
        }
    }
}
