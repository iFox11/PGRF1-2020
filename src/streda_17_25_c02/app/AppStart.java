package streda_17_25_c02.app;

import streda_17_25_c02.rasterize.Raster;
import streda_17_25_c02.view.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class AppStart {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window window = new Window();
            Raster raster = window.getPanel().getRaster();

            raster.setPixel(10, 10, Color.YELLOW.getRGB());

            int r= 0,g= 0,b = 0;

            for (int i = 20; i < 275; i++) {
                for (int j = 20; j < 275; j++) {
                    raster.setPixel(i, j, new Color(r, g, b).getRGB());
                    b++;
                }
                r++;
                g++;
                b=0;
            }



            int x1=0, y1=300;
            int x2=156, y2=425;

            float k=(y2-y1)/(float)(x2-x1);
            float q =y1 -k * x1;
            System.out.println(k);
            System.out.println(q);

            for (int x = x1; x <=x2; x++) {
                float y = k*x+q;
                raster.setPixel(x, Math.round(y),0xffffff);
            }




            window.setVisible(true); // zobrazit okno
        });
        // https://www.google.com/search?q=SwingUtilities.invokeLater
        // https://www.javamex.com/tutorials/threads/invokelater.shtml
    }

}
