package fr.chat.view;

import java.util.*;

public abstract class ViewComposite {

	private List<ViewComposite> children = new ArrayList<>();

	public void add(ViewComposite view) {
		children.add(view);
	}

	public int count() {
		return children.size();
	}

	protected abstract void executeBefore();

	public void execute() {
		executeBefore();
		for (ViewComposite view : children) {
			view.execute();
		}
	}

}
