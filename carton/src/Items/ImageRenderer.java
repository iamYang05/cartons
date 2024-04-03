
package Items;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
/**
 *
 * @author user
 */
public class ImageRenderer extends DefaultTableCellRenderer {
     @Override
       protected void setValue (Object value){
           if(value instanceof ImageIcon){
               setIcon ((ImageIcon) value);
           }else {
               setText ((value == null) ? "" : value.toString());
               setIcon (null);
           }
       } 
       
       public static ImageIcon blobToImageIcon (Blob blob,int width,int height) throws SQLException{
           if (blob != null){
               try (InputStream inputStream = blob.getBinaryStream()){
                   byte[] bytes = inputStream.readAllBytes();
                   
                   ImageIcon originalIcon = new ImageIcon (bytes);
                   Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                   return new ImageIcon (scaledImage);
               }catch (Exception e){
                   e.printStackTrace();
               }
           }
           return null;
       }
      
}

