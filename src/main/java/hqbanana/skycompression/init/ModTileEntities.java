package hqbanana.skycompression.init;

import com.bartz24.skyresources.References;
import hqbanana.skycompression.base.tile.TileCompressedRockCrusher;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
	public static void init() {
		GameRegistry.registerTileEntity(TileCompressedRockCrusher.class, References.ModID + ":compressedrockcrushertile");
	}
}
