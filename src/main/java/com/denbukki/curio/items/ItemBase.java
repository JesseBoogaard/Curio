package com.denbukki.curio.items;

import com.denbukki.curio.Curio;
import com.denbukki.curio.ModInfo;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item {

    protected String name;

    public ItemBase(String name) {
        super();
        this.name = name;
        setCreativeTab(Curio.CURIO_TAB);
        setUnlocalizedName(ModInfo.MOD_ID +"."+this.name);
        setRegistryName(new ResourceLocation(ModInfo.MOD_ID, this.name));
        if(!(this instanceof ItemCurioBook) ){
            Curio.bookManager.addPage(this.getDescriptionText(), new ItemStack(this,1,0));
        }

    }
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        return super.getUnlocalizedName();
    }


    public String getDescriptionText() {
        return Curio.proxy.translate(ModInfo.MOD_ID +"." + this.name + ".description");

    }


    public void registerItemModel() {
        Curio.proxy.registerItemRenderer(this, 0, name);
    }
}
