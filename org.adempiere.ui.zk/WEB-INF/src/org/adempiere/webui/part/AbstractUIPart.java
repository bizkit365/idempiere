/******************************************************************************
 * Copyright (C) 2008 Low Heng Sin  All Rights Reserved.                      *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/
package org.adempiere.webui.part;

import org.adempiere.webui.ISupportMask;
import org.adempiere.webui.component.Mask;
import org.adempiere.webui.desktop.IDesktop;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Page;
import org.zkoss.zul.Borderlayout;

/**
 * 
 * @author Low Heng Sin
 *
 */
public abstract class AbstractUIPart implements UIPart, ISupportMask {
	
	protected Page page = null;
	
	public Component createPart(Object parent) {
		if (parent == null)
			throw new IllegalArgumentException("Null parent.");
		
		Component component = null;
		if (parent instanceof Page) {
			page = (Page)parent;
		} else if (parent instanceof Component) {
			component = (Component)parent;
			page = component.getPage();
		} else {
			throw new IllegalArgumentException("Parent must of class Page or Component.");
		}
		
		return doCreatePart(component);
	}
	
	protected abstract Component doCreatePart(Component parent);

	/**
	 * cache {@link Mask} Object
	 */
	private Mask maskObj; 

	/**
	 * {@inheritDoc}
	 */
	@Override public void showMask() {
		maskObj = getMaskObj ();
		if (maskObj.getParent() == null){
			this.getMaskComponent().appendChild(maskObj);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void hideMask() {
		if (maskObj != null || maskObj.getParent() != null){
			maskObj.detach();
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mask getMaskObj() {
		if (maskObj == null)
			maskObj = new Mask();
		
		return maskObj;
	}
	
	/**
	 * {@inheritDoc}
	 * knowIssue: because {@link IDesktop#getComponent()} return {@link BorderLayout} , 
	 * don't append window to child list of it, in this case we must get parent of BorderLayout
	 */
	@Override
	public Component getMaskComponent(){
		Component component = getComponent();
		if (Borderlayout.class.isInstance(component)){
			component = component.getParent();
		}
		return component;
	}
}
