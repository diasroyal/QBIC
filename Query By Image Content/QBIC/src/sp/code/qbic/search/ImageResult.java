package sp.code.qbic.search;

import java.awt.image.BufferedImage;


public class ImageResult implements Comparable {

    private String path;
    private double similarity;
    private BufferedImage bufferedImage;

   
    public String getPath() {
        return path;
    }

    
    public void setPath(String path) {
        this.path = path;
    }

   
    public double getSimilarity() {
        return similarity;
    }

    
    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public int compareTo(Object o) {
        ImageResult imageResult = (ImageResult) o;
        if (imageResult.getSimilarity() > this.similarity) {
            return 1;
        }

        return 0;
    }

    
    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

   
    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }
}
