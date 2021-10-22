package chronosacaria.testmod.itemtoblock;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class ItemToBlockMethod {
    public static void itemToBlock (ItemUsageContext ctx, Item item, Block block,
                                 CallbackInfoReturnable<ActionResult> cir){
        if (ctx.getPlayer() != null){
            ItemStack getMainHandStack = ctx.getPlayer().getMainHandStack();

            if (getMainHandStack.getItem() == item.asItem()){
                ctx.getStack().decrement(1);
                ItemPlacementContext itemPlacementContext = new ItemPlacementContext(ctx);
                BlockPos blockPos = itemPlacementContext.getBlockPos();

                ctx.getWorld().setBlockState(blockPos, block.getDefaultState());
                cir.setReturnValue(ActionResult.SUCCESS);
            }
        }
    }
}
