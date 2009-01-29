/*******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.debug.internal.ui.contexts.provisional;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Notified of context activation and when the active context changes state.
 * Listeners register with the debug context manager.
 * <p>
 * Clients may implement this interface.
 * </p>
 * @since 3.2
 * @see IDebugContextManager
 */
public interface IDebugContextListener {
	
	/**
	 * Notification the given selection contains the active context in the 
	 * specified part.
	 * 
	 * @param selection selection containing active context
	 * @param part workbench part or <code>null</code>
	 */
	public void contextActivated(ISelection selection, IWorkbenchPart part);
	
	/**
	 * Notification the context in the given selection has changed state
	 * in the specified part. Context changes are only sent for contexts
	 * that are active. 
	 * 
	 * @param selection selection containing changed context
	 * @param part workbench part or <code>null</code>
	 */
	public void contextChanged(ISelection selection, IWorkbenchPart part);

}