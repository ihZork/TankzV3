package ru.tankz.Objects;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ihzork on 29.12.16.
 */

public class Item {

    public int      id;
    public String   name;
    public String   usedPivot;

    public Model    model;

    public String   type;
    public int      matchItems;
    public String   partId;


    /// shop components

    public int      slot;
    public boolean  bounght;
    public boolean  researching;
    public int      researchCurrentExperience;
    public int      researchNextLevelExperience;

    public int      silverCost;
    public int      goldCost;

    /// research componenents

    public String   icon;
    public Vector2  iconPosition;
    public String   researchCurrentExperienceString;
    public String   researchNextLevelExperienceString;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsedPivot() {
        return usedPivot;
    }

    public void setUsedPivot(String usedPivot) {
        this.usedPivot = usedPivot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMatchItems() {
        return matchItems;
    }

    public void setMatchItems(int matchItems) {
        this.matchItems = matchItems;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public boolean isBounght() {
        return bounght;
    }

    public void setBounght(boolean bounght) {
        this.bounght = bounght;
    }

    public boolean isResearching() {
        return researching;
    }

    public void setResearching(boolean researching) {
        this.researching = researching;
    }

    public int getSilverCost() {
        return silverCost;
    }

    public void setSilverCost(int silverCost) {
        this.silverCost = silverCost;
    }

    public int getGoldCost() {
        return goldCost;
    }

    public void setGoldCost(int goldCost) {
        this.goldCost = goldCost;
    }

    public Vector2 getIconPosition() {
        return iconPosition;
    }

    public void setIconPosition(Vector2 iconPosition) {
        this.iconPosition = iconPosition;
    }
    public void setResearchCurrentExperienceString(int researchCurrentExperience)
    {
        this.researchCurrentExperienceString=" " + researchCurrentExperience;
    }

    public int getResearchCurrentExperience() {
        return researchCurrentExperience;
    }

    public void setResearchCurrentExperience(int researchCurrentExperience) {
        this.researchCurrentExperience = researchCurrentExperience;
    }

    public int getResearchNextLevelExperience() {
        return researchNextLevelExperience;
    }

    public void setResearchNextLevelExperience(int researchNextLevelExperience) {
        this.researchNextLevelExperience = researchNextLevelExperience;
    }

    public String getResearchCurrentExperienceString() {
        return researchCurrentExperienceString;
    }



    public String getResearchNextLevelExperienceString() {
        return researchNextLevelExperienceString;
    }

    public void setResearchNextLevelExperienceString(int researchNextLevelExperience) {
        this.researchNextLevelExperienceString = " "+researchNextLevelExperience;
    }
}
