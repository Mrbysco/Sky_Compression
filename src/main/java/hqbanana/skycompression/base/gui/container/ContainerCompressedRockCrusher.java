package hqbanana.skycompression.base.gui.container;

import com.bartz24.skyresources.base.gui.SlotSpecial;
import hqbanana.skycompression.base.tile.TileCompressedRockCrusher;
import net.minecraft.inventory.IInventory;

public class ContainerCompressedRockCrusher extends ContainerBase {
	private int currentProgress;
	
	public ContainerCompressedRockCrusher(IInventory playerInv, TileCompressedRockCrusher te) {
		super(playerInv, te, 0, 24);
		this.addSlotToContainer(new SlotSpecial(tile.getInventory(), 0, 55, 49));
		this.addSlotToContainer(new SlotSpecial(tile.getInventory(), 1, 109, 31));
		this.addSlotToContainer(new SlotSpecial(tile.getInventory(), 2, 109, 49));
		this.addSlotToContainer(new SlotSpecial(tile.getInventory(), 3, 109, 67));
	}
}
