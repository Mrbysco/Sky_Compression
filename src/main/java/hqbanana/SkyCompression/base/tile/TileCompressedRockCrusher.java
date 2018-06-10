package hqbanana.SkyCompression.base.tile;

import java.util.Collections;

import com.bartz24.skyresources.base.gui.ItemHandlerSpecial;
import com.bartz24.skyresources.recipe.ProcessRecipe;

import hqbanana.SkyCompression.AdditionalProcessRecipesManager;
import hqbanana.SkyCompression.config.AdditionalConfigOptions;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.util.Constants;

public class TileCompressedRockCrusher extends TileGenericPower implements ITickable {
	private NonNullList<ItemStack> bufferStacks = NonNullList.create();
	private int powerUsage = AdditionalConfigOptions.machineSettings.compressedRockCrusherPowerUsage;
	private int currentProgress;
	//TODO: ADD MORE SLOTS TO OUTPUT
	
	public TileCompressedRockCrusher() {
		super("compressedRockCrusher", 1000000, 6000, 0, 4, new int[] { 1, 2, 3 }, new int[] { 0 });
		this.setInventory(new ItemHandlerSpecial(4, new int[] { 1, 2, 3 }, new int[] { 0 }) {
			protected void onContentsChanged(int slot) {
				super.onContentsChanged(slot);
				TileCompressedRockCrusher.this.markDirty();
			}
		});
	}
	
	@Override
	public void update() {
		if (!this.world.isRemote) {
			if (bufferStacks.size() > 0 && !FullOutput()) {
				this.AddToOutput(1);
				this.AddToOutput(2);
				this.AddToOutput(3);
			} else {
				boolean hasRecipes = HasRecipes();
				if (currentProgress < 100 && getEnergyStored() >= powerUsage && hasRecipes && bufferStacks.size() == 0) {
					internalExtractEnergy(powerUsage, false);
					currentProgress += AdditionalConfigOptions.machineSettings.compressedRockCrusherSpeed;
				} else if (!hasRecipes) currentProgress = 0;
				if (currentProgress >= 100 && hasRecipes) {
					ProcessRecipe recipeMachine = new ProcessRecipe(Collections.singletonList(this.getInventory().getStackInSlot(0)), Integer.MAX_VALUE, "compressedRockGrinder");
					for (ProcessRecipe r : AdditionalProcessRecipesManager.compressedRockGrinderRecipes.getRecipes()) {
						if (r != null && recipeMachine.isInputRecipeEqualTo(r, false)) {
							float chance = r.getIntParameter() * 3.0F;
							while (chance >= 1) {
								bufferStacks.add(r.getOutputs().get(0).copy());
								chance -= 1;
							}
							if (this.world.rand.nextFloat() <= chance) bufferStacks.add(r.getOutputs().get(0).copy());
						}
					}
					this.getInventory().getStackInSlot(0).shrink(1);
					currentProgress = 0;
				}
			}
			this.markDirty();
		}
	}
	
	public void AddToOutput(int slot) {
		if (bufferStacks.size() > 0) {
			ItemStack stack = this.getInventory().insertInternalItem(slot, bufferStacks.get(bufferStacks.size() - 1), false);
			bufferStacks.set(bufferStacks.size() - 1, stack);
			if (bufferStacks.get(bufferStacks.size() - 1).isEmpty()) bufferStacks.remove(bufferStacks.size() - 1);
		}
	}
	
	public boolean FullOutput() {
		return !this.getInventory().getStackInSlot(1).isEmpty() && !this.getInventory().getStackInSlot(2).isEmpty() && !this.getInventory().getStackInSlot(3).isEmpty();
	}
	
	public boolean HasRecipes() {
		if (this.getInventory().getStackInSlot(0).isEmpty()) return false;
		ProcessRecipe recipeMachine = new ProcessRecipe(Collections.singletonList(this.getInventory().getStackInSlot(0)), Integer.MAX_VALUE, "compressedRockGrinder");
		for (ProcessRecipe r : AdditionalProcessRecipesManager.compressedRockGrinderRecipes.getRecipes()) {
			if (r != null && recipeMachine.isInputRecipeEqualTo(r, false)) return true;
		}
		return false;
	}
	
	public int GetProgress() {
		return currentProgress;
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound = super.writeToNBT(compound);
		compound.setTag("buffer", BufferListWrite());
		compound.setInteger("progress", currentProgress);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		BufferListRead(compound.getCompoundTag("buffer"));
		currentProgress = compound.getInteger("progress");
	}
	
	public NBTTagCompound BufferListWrite() {
		NBTTagList nbtTagList = new NBTTagList();
		for (int i = 0; i < bufferStacks.size(); i++) {
			if (!bufferStacks.get(i).isEmpty()) {
				NBTTagCompound itemTag = new NBTTagCompound();
				bufferStacks.get(i).writeToNBT(itemTag);
				nbtTagList.appendTag(itemTag);
			}
		}
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setTag("Items", nbtTagList);
		return nbt;
	}
	
	public void BufferListRead(NBTTagCompound nbt) {
		NBTTagList nbtTagList = nbt.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < nbtTagList.tagCount(); i++) {
			NBTTagCompound itemTags = nbtTagList.getCompoundTagAt(i);
			bufferStacks.add(new ItemStack(itemTags));
		}
	}
}
