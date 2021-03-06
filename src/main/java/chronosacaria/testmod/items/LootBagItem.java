package chronosacaria.testmod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LootBagItem extends Item {

    // This could be a Mould Item, a Loot Bag, etc.

    public LootBagItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use (World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);

        if (!user.isCreative()){
            itemStack.decrement(1);
        }

        user.getInventory().insertStack(new ItemStack(Items.NETHERITE_SWORD));
        return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
    }
}
