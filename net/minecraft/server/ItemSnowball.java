package net.minecraft.server;

public class ItemSnowball extends Item {

    public ItemSnowball() {
        this.maxStackSize = 16;
        this.a(CreativeModeTab.f);
    }

    public InteractionResultWrapper<ItemStack> a(ItemStack itemstack, World world, EntityHuman entityhuman, EnumHand enumhand) {
        if (!entityhuman.abilities.canInstantlyBuild) {
            --itemstack.count;
        }

        world.a((EntityHuman) null, entityhuman.locX, entityhuman.locY, entityhuman.locZ, SoundEffects.fG, SoundCategory.NEUTRAL, 0.5F, 0.4F / (ItemSnowball.i.nextFloat() * 0.4F + 0.8F));
        if (!world.isClientSide) {
            EntitySnowball entitysnowball = new EntitySnowball(world, entityhuman);

            entitysnowball.a(entityhuman, entityhuman.pitch, entityhuman.yaw, 0.0F, 1.5F, 1.0F);
            world.addEntity(entitysnowball);
        }

        entityhuman.b(StatisticList.b((Item) this));
        return new InteractionResultWrapper(EnumInteractionResult.SUCCESS, itemstack);
    }
}