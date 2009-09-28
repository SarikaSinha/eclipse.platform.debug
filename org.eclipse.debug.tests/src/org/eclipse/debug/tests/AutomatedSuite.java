/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.debug.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipe.debug.tests.launching.AcceleratorSubstitutionTests;
import org.eclipe.debug.tests.launching.LaunchConfigurationTests;
import org.eclipe.debug.tests.launching.LaunchHistoryTests;
import org.eclipe.debug.tests.view.memory.MemoryRenderingTests;
import org.eclipe.debug.tests.viewer.model.ChildrenUpdateTests;
import org.eclipe.debug.tests.viewer.model.FilterTransformTests;
import org.eclipe.debug.tests.viewer.model.JFaceViewerCheckTests;
import org.eclipe.debug.tests.viewer.model.JFaceViewerContentTests;
import org.eclipe.debug.tests.viewer.model.JFaceViewerDeltaTests;
import org.eclipe.debug.tests.viewer.model.JFaceViewerSelectionTests;
import org.eclipe.debug.tests.viewer.model.JFaceViewerStateTests;
import org.eclipe.debug.tests.viewer.model.JFaceViewerUpdateTests;
import org.eclipe.debug.tests.viewer.model.PresentationContextTests;
import org.eclipe.debug.tests.viewer.model.VirtualViewerDeltaTests;
import org.eclipe.debug.tests.viewer.model.VirtualViewerLazyModeTests;
import org.eclipe.debug.tests.viewer.model.VirtualViewerSelectionTests;
import org.eclipe.debug.tests.viewer.model.VirtualViewerStateTests;
import org.eclipe.debug.tests.viewer.model.VirtualViewerUpdateTests;

/**
 * Tests for integration and nightly builds.
 * 
 * @since 3.6 
 */
public class AutomatedSuite extends TestSuite {

	/**
	 * Returns the suite.  This is required to use the JUnit Launcher.
	 * 
	 * @return the test suite
	 */
	public static Test suite() {
		return new AutomatedSuite();
	}
	
	/**
	 * Constructs the automated test suite. Adds all tests. 
	 */
	public AutomatedSuite() {
		// JFace viewer tests
		addTest(new TestSuite(JFaceViewerCheckTests.class));
		addTest(new TestSuite(JFaceViewerContentTests.class));
		addTest(new TestSuite(JFaceViewerDeltaTests.class));
		addTest(new TestSuite(JFaceViewerSelectionTests.class));
		addTest(new TestSuite(JFaceViewerStateTests.class));
		addTest(new TestSuite(JFaceViewerUpdateTests.class));
		
		// Virtual viewer tests
		addTest(new TestSuite(VirtualViewerDeltaTests.class));
		addTest(new TestSuite(VirtualViewerLazyModeTests.class));
		addTest(new TestSuite(VirtualViewerSelectionTests.class));
		addTest(new TestSuite(VirtualViewerStateTests.class));
		addTest(new TestSuite(VirtualViewerUpdateTests.class));
		
		// Viewer neutral tests
		addTest(new TestSuite(FilterTransformTests.class));
		addTest(new TestSuite(ChildrenUpdateTests.class));
		addTest(new TestSuite(PresentationContextTests.class));
		
		// Memory view
		addTest(new TestSuite(MemoryRenderingTests.class));
		
		// Launch framework
		addTest(new TestSuite(LaunchConfigurationTests.class));
		addTest(new TestSuite(AcceleratorSubstitutionTests.class));
		addTest(new TestSuite(LaunchHistoryTests.class));
	}
}