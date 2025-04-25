package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        // Call the paintComponent method of the superclass JPanel to clear the panel
        super.paintComponent(g); 

        // Get current note indices
        Integer[] indices = notes.getNotes(); 
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / indices.length;

        for (int i = 0; i < indices.length; i++) {
            int value = indices[i];
            
            // Height of the bar is proportional to value
            int barHeight = (int) (((double) value / (indices.length - 1)) * height);
            int x = i * barWidth;
            // Draw from the bottom up
            int y = height - barHeight; 

            // Set bar color to red if highlighted, blue if not
            if (notes.isHighlighted(i)) {
                g.setColor(java.awt.Color.RED);
            } else {
                g.setColor(java.awt.Color.BLUE);
            }

            // Draw the bar
            g.fillRect(x, y, barWidth, barHeight);
        }
    }
}