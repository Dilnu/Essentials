package com.Da_Technomancer.essentials.blocks;

import com.Da_Technomancer.essentials.tileentities.AbstractSplitterTE;
import com.Da_Technomancer.essentials.tileentities.BasicItemSplitterTileEntity;
import com.Da_Technomancer.essentials.tileentities.ITickableTileEntity;
import com.Da_Technomancer.essentials.tileentities.ItemSplitterTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class BasicItemSplitter extends AbstractSplitter{

	protected BasicItemSplitter(String name, Properties prop){
		super(name, prop);
	}

	public BasicItemSplitter(){
		super("basic_item_splitter", ESBlocks.getMetalProperty());
	}

	@Override
	protected boolean isBasic(){
		return true;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state){
		return new BasicItemSplitterTileEntity(pos, state);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable BlockGetter world, List<Component> tooltip, TooltipFlag advanced){
		tooltip.add(new TranslatableComponent("tt.essentials.item_splitter_basic"));
		tooltip.add(new TranslatableComponent("tt.essentials.basic_item_splitter_formula"));
		tooltip.add(new TranslatableComponent("tt.essentials.item_splitter_chute"));
	}

	@Override
	protected Component getModeComponent(AbstractSplitterTE te, int newMode){
		return new TranslatableComponent("tt.essentials.basic_item_splitter.mode", newMode, te.getDistribution().base);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type){
		return ITickableTileEntity.createTicker(type, ItemSplitterTileEntity.TYPE);
	}
}
