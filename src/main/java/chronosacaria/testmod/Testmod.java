package chronosacaria.testmod;

import chronosacaria.testmod.blockentities.BreadBlockEntity;
import chronosacaria.testmod.blocks.BreadBlock;
import chronosacaria.testmod.items.LootBagItem;
import chronosacaria.testmod.items.SpeedSwordItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Testmod implements ModInitializer {
    public static String MOD_ID = "testmod";

    public static final Item SPEED_SWORD_ITEM = new SpeedSwordItem(ToolMaterials.DIAMOND, 7, -1.7f,
            new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final Item MOULD_ITEM = new LootBagItem(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Block BREAD_BLOCK = new BreadBlock(FabricBlockSettings.of(Material.CAKE).strength(0.1F));
    public static BlockEntityType<BreadBlockEntity> BREAD_BLOCK_ENTITY;

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "speed_sword"), SPEED_SWORD_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "mould_item"), MOULD_ITEM);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "bread_block"), BREAD_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bread_block"), new BlockItem(BREAD_BLOCK,
                new FabricItemSettings().group(ItemGroup.FOOD)));
        BREAD_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "testmod:bread_block_entity",
                FabricBlockEntityTypeBuilder.create(BreadBlockEntity::new, BREAD_BLOCK).build(null));
    }
}
