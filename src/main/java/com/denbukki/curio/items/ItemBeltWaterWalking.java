package com.denbukki.curio.items;

import baubles.api.BaubleType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class ItemBeltWaterWalking extends BaublesItemBase {

    public ItemBeltWaterWalking() {
        super("ItemBeltWaterWalking");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.BELT;
    }
    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

        int x = MathHelper.floor(player.posX);
        int y = MathHelper.floor(player.getEntityBoundingBox().minY - 0.11f);
        int yPaddle = MathHelper.floor(player.getEntityBoundingBox().minY);
        int z = MathHelper.floor(player.posZ);
        Material mWater = player.world.getBlockState(new BlockPos(x, y, z)).getMaterial();
        Material mPaddle =player.world.getBlockState(new BlockPos(x, yPaddle, z)).getMaterial();
        boolean waterBelow = (mWater == Material.WATER);
        boolean paddlingInWater = (mPaddle == Material.WATER);

        if (waterBelow && player.motionY < 0.0D && !player.isSneaking()) {

            player.posY -= player.motionY;

            player.motionY = 0.0D;
            player.fallDistance = 0.0F;
        }

        if ((player.isInWater() || paddlingInWater) && !player.isSneaking()) {
            player.motionY = 0.1f;
        }
    }

}
