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
package org.malai.undo;

/**
 * An interface for undoable objects.
 * @author Arnaud BLOUIN
 * @since 0.1
 */
public interface Undoable {
	/**
	 * Cancels the action.
	 * @since 0.1
	 */
	void undo();

	/**
	 * Redoes the cancelled action.
	 * @since 0.1
	 */
	void redo();

	/**
	 * @return The name of the undo action.
	 * @since 0.1
	 */
	String getUndoName();
}
