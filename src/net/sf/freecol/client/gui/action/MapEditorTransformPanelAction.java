/**
 *  Copyright (C) 2002-2024   The FreeCol Team
 *
 *  This file is part of FreeCol.
 *
 *  FreeCol is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  FreeCol is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with FreeCol.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.freecol.client.gui.action;

import java.awt.event.ActionEvent;

import net.sf.freecol.client.FreeColClient;


/**
 * An action for displaying the map editor tile transform panel.
 */
public class MapEditorTransformPanelAction extends SelectableAction {

    public static final String id = "mapEditorTransformPanelAction";


    /**
     * Creates this action.
     *
     * @param freeColClient The {@code FreeColClient} for the game.
     */
    public MapEditorTransformPanelAction(FreeColClient freeColClient) {
        super(freeColClient, id);
        setSelected(isSelected());
    }


    @Override
    protected boolean shouldBeEnabled() {
        return freeColClient.isMapEditor() && getGame() != null && getGame().getMap() != null;
    }

    @Override
    protected boolean shouldBeSelected() {
        return getGUI().isShowingMapEditorTransformPanel();
    }
    
    // Interface ActionListener

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        getGUI().enableEditorTransformPanel(isEnabled() && isSelected());
    }
}
