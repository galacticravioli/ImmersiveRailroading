package cam72cam.immersiverailroading.util;

import cam72cam.immersiverailroading.blocks.BlockRailBase;
import cam72cam.immersiverailroading.tile.TileRailBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockMushroom;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockUtil {
	public static boolean canBeReplaced(World world, BlockPos pos, boolean allowFlex) {
		Block block = world.getBlockState(pos).getBlock();
		
		if (block == null) {
			return true;
		}
		if (block.isReplaceable(world, pos)) {
			return true;
		}
		if (block instanceof BlockFlower || block == Blocks.DOUBLE_PLANT || block instanceof BlockMushroom) {
			return true;
		}
		if (allowFlex && block instanceof BlockRailBase) {
			TileRailBase te = (TileRailBase) world.getTileEntity(pos);
			return te.isFlexible();
		}
		return false;
	}
}