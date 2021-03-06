/*
 * This file is part of Malai.
 * Copyright (c) 2005-2017 Arnaud BLOUIN
 * Malai is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later version.
 * Malai is distributed without any warranty; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */
package org.malai.javafx.interaction.library;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import org.malai.interaction.TerminalState;
import org.malai.javafx.interaction.JfxMenuItemPressedTransition;

/**
 * This interaction occurs when a menu item is triggered.
 * @author Arnaud BLOUIN
 */
public class MenuItemPressed extends MenuItemInteraction<MenuItem> {
	/**
	 * Creates the interaction.
	 */
	public MenuItemPressed() {
		super();
		initStateMachine();
	}


	@SuppressWarnings("unused")
	@Override
	protected void initStateMachine() {
		final TerminalState pressed = new TerminalState("pressed"); //$NON-NLS-1$

		addState(pressed);

		new JfxMenuItemPressedTransition(initState, pressed) {
			@Override
			public void action() {
				super.action();
				MenuItemPressed.this.widget = this.widget;
			}
		};
	}

	@Override
	public void registerToMenuItems(final List<MenuItem> widgets) {
		super.registerToMenuItems(widgets);
		widgets.forEach(w -> w.addEventHandler(ActionEvent.ACTION, evt -> onJfxMenuItemPressed((MenuItem) evt.getSource())));
	}
}
