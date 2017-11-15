package hqbanana.SkyCompression.Handlers;

import hqbanana.SkyCompression.base.gui.GuiCompressedRockCrusher;
import hqbanana.SkyCompression.base.gui.container.ContainerCompressedRockCrusher;
import hqbanana.SkyCompression.base.tile.TileCompressedRockCrusher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {
	public static final int COMPRESSED_ROCK_CLEANER_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		//System.out.println("OHAI SERVER");
		if (id == COMPRESSED_ROCK_CLEANER_GUI) return new ContainerCompressedRockCrusher(player.inventory, (TileCompressedRockCrusher)world.getTileEntity(new BlockPos(x, y, z)));
		System.out.print("ID: " + id + ", Y IZ U NULL");
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
		//System.out.println("OHAI CLIENT");
		if (id == COMPRESSED_ROCK_CLEANER_GUI) return new GuiCompressedRockCrusher(player.inventory, (TileCompressedRockCrusher)world.getTileEntity(new BlockPos(x, y, z)));
		System.out.print("ID: " + id + ", Y IZ U NULL CLIENT?");
		return null;
	}
}
