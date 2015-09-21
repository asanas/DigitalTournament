package com.digitour.app.ui.component.menu;

public class Menu {
    private String menuDescription;
    private String menuURL;
    private String urlTarget;
    private String className;
    private String displayText;
    
    public String getMenuDescription() {
        return menuDescription;
    }
    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }
    public String getMenuURL() {
        return menuURL;
    }
    public void setMenuURL(String menuURL) {
        this.menuURL = menuURL;
    }
    public String getUrlTarget() {
        return urlTarget;
    }
    public void setUrlTarget(String urlTarget) {
        this.urlTarget = urlTarget;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
	public String getDisplayText() {
		return displayText;
	}
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
}
