package chronosacaria.testmod.mixin;

import chronosacaria.testmod.Testmod;
import chronosacaria.testmod.itemtoblock.ItemToBlockMethod;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    public void placeItemBlocks(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir){
        ItemToBlockMethod.itemToBlock(context, Items.BREAD, Testmod.BREAD_BLOCK, cir);
    }
}
