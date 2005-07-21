/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.debug.internal.ui.treeviewer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.TreeItem;

public abstract class AbstractUpdate implements IPresentationUpdate {
    
    private TreeItem fItem;
    private AsyncTreeViewer fViewer;

    /**
     * Constructs an udpate rooted at the given item.
     * 
     * @param item
     */
    public AbstractUpdate(TreeItem item, AsyncTreeViewer viewer) {
        fItem = item;
        fViewer = viewer;
    }
    
    protected AsyncTreeViewer getViewer() {
        return fViewer;
    }
    
    protected TreeItem getItem() {
        return fItem;
    }
    
    /**
     * Returns whether the given item is a child of this update's item.
     * 
     * @param item potential child
     * @return
     */
    protected boolean isChild(final TreeItem item) {
        final boolean[] result = new boolean[1];
        getViewer().getControl().getDisplay().syncExec(new Runnable() {
            public void run() {
                TreeItem parent = item.getParentItem();
                while (parent != null) {
                    if (parent.equals(fItem)) {
                        result[0] = true;
                        return;
                    }
                    parent = parent.getParentItem();
                }     
                result[0] = false;
            }
        });
        return result[0];
    }
    
    public void setStatus(IStatus status) {
        // TODO Auto-generated method stub

    }

    public void beginTask(String name, int totalWork) {
        // TODO Auto-generated method stub

    }

    public void internalWorked(double work) {
        // TODO Auto-generated method stub

    }

    public boolean isCanceled() {
        // TODO Auto-generated method stub
        return false;
    }

    public void setCanceled(boolean value) {
        // TODO Auto-generated method stub

    }

    public void setTaskName(String name) {
        // TODO Auto-generated method stub

    }

    public void subTask(String name) {
        // TODO Auto-generated method stub

    }

    public void worked(int work) {
        // TODO Auto-generated method stub

    }
    
    /* (non-Javadoc)
     * @see org.eclipse.core.runtime.IProgressMonitor#done()
     */
    public final void done() {
        if (!isCanceled()) {
            getViewer().updateComplete(this);
            getViewer().getControl().getDisplay().asyncExec(new Runnable() {
                public void run() {
                    performUpdate();
                }
            });
        }
    }

    /**
     * Performs the specific update.
     */
    protected abstract void performUpdate();
    
    /**
     * Returns whether this update effectively contains the given update.
     * That is, this update will also perform the given update.
     * 
     * @param update
     * @return
     */
    protected abstract boolean contains(AbstractUpdate update);
}
