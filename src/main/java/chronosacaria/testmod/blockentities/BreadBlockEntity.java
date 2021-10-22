package chronosacaria.testmod.blockentities;

import chronosacaria.testmod.Testmod;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class BreadBlockEntity extends BlockEntity {
    public BreadBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(Testmod.BREAD_BLOCK_ENTITY, blockPos, blockState);
    }
}
