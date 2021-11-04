package chronosacaria.testmod.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.tool.attribute.v1.DynamicAttributeTool;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import javax.annotation.Nullable;
import java.util.UUID;

public class SpeedSwordItem extends SwordItem implements DynamicAttributeTool {
    public static final UUID WEAPON_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");


    public SpeedSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getDynamicModifiers(EquipmentSlot slot, ItemStack stack
            , @Nullable LivingEntity user){
        if (slot.equals(EquipmentSlot.MAINHAND)){
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
            builder.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(WEAPON_UUID, "Speed " +
                    "modifier", 0.30, EntityAttributeModifier.Operation.MULTIPLY_BASE));
            return builder.build();
        } else {
            return EMPTY;
        }
    }
}
