package br.com.eleicoestransparentes.ui.fragments;


/**
 * Classe que traz os índices do Item do menu, oriundos da classe R. 
 * @author Tiago Gonçalves
 *
 */
public class ItemMenu {
	
	private int icon;
	private int label;
	private int description;
	
	public ItemMenu(int icon, int label, int description){
		this.setIcon(icon);
		this.setLabel(label);
		this.setDescription(description);
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	public int getDescription() {
		return description;
	}

	public void setDescription(int description) {
		this.description = description;
	}

}
