package hqbanana.SkyCompression;

import java.util.List;

import com.bartz24.skyresources.recipe.ProcessRecipe;
import com.bartz24.skyresources.recipe.ProcessRecipeManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class AdditionalProcessRecipesManager {
	private static List<ProcessRecipeManager> managers;
	private List<ProcessRecipe> recipes;
	private String type;
	
	public static ProcessRecipeManager compressedRockGrinderRecipes = new ProcessRecipeManager("compressedRockGrinder") {
        public void drawJEIInfo(ProcessRecipe rec, Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        	String s = Math.round(rec.getIntParameter() * 100000f) / 1000f + "%";
        	FontRenderer fontRendererObj = minecraft.fontRenderer;
            fontRendererObj.drawString(s, 70, 0, java.awt.Color.gray.getRGB());
        }
    };
    
    public static ProcessRecipeManager compressedCuttingKnifeRecipes = new ProcessRecipeManager("compressedKnife");
	
    public static ProcessRecipeManager compressedWaterExtractorExtractionRecipes = new ProcessRecipeManager("compressedWaterExtractor-extract") {
        public void drawJEIInfo(ProcessRecipe rec, Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
            FontRenderer fontRendererObj = minecraft.fontRenderer;
            fontRendererObj.drawString("Extracting", 70, 0, java.awt.Color.gray.getRGB());
        }
    };
    
    public static ProcessRecipeManager compressedWaterExtractorInsertionRecipes = new ProcessRecipeManager("compressedWaterExtractor-insert") {
        public void drawJEIInfo(ProcessRecipe rec, Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
            FontRenderer fontRendererObj = minecraft.fontRenderer;
            fontRendererObj.drawString("Inserting", 70, 0, java.awt.Color.gray.getRGB());
        }
    };
}