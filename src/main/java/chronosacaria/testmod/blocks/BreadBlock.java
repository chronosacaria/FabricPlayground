package chronosacaria.testmod.blocks;

import chronosacaria.testmod.blockentities.BreadBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class BreadBlock extends Block implements BlockEntityProvider {
    public BreadBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return new BreadBlockEntity(pos, state);
    }

}
