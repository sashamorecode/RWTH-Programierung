/**
 * Rectangle Class, has attributes x, y, width and hight.
 */

public class Rectangle {

    int x;
    int y;
    int width;
    int hight;
    /**
     * Constructs a rectangle with values x, y , width, hight. based on the inputs:
     * @param xInput int value of x
     * @param yInput int value of y
     * @param widthInput int value of width (only takes positive)
     * @param heightInput int value of height (only takes positive)
     */

    public Rectangle(int xInput, int yInput, int widthInput, int heightInput){

        if(widthInput < 0 || heightInput <0){
            System.err.println("negative values illegal for width/height.");
            return;
        }

        x = xInput;
        y = yInput;
        width = widthInput;
        hight = heightInput;
    }
    /**
     * Constructs a square of the class Rectangle with values x, y , width, hight. based on the inputs:
     * @param xInput int value of x
     * @param yInput int value of y
     * @param sidelengthInput int value of width and hight(only takes positive)
     *
     *
     */
    public Rectangle(int xInput, int yInput, int sidelengthInput){


        if(sidelengthInput < 0){
            System.err.println("negative values illegal for width/height.");
            return;
        }

        x = xInput;
        y = yInput;
        width = sidelengthInput;
        hight = sidelengthInput;
    }
    /**
     * Makes a copy of a Rectangle
     * @param toCopy Rectangle to be copied
     *
     * @return copy a copy of the input
     */
    public static Rectangle copy(Rectangle toCopy){

        Rectangle copy = new Rectangle(toCopy.x, toCopy.y,toCopy.width,toCopy.hight);
        return copy;
    }

    void printWidth(){
        System.out.println(this.width);
    }
    void printHight(){
        System.out.println((this.hight));
    }
    void changeWidth(int newWidth){
        if(newWidth < 0){
            System.err.println("negetive Width is Illegal");
        }
        else {
            width = newWidth;
        }
    }

    void changeHight(int newHight){
        if(newHight<0){
            System.err.println("negative height is Illegal");
        }
        else{
            hight = newHight;
        }
    }
    /**
     * Checks if a set of Rectangles is only containing squares
     *
     * @param rectangles - a set of Rectangles
     * @return boolean - returns true if only containing rectangles and false if not
     */

    static boolean areSquares(Rectangle[] rectangles){

        //The function is better static because it does not acsses any non-static elements that are not being feed to in as arguments
        for(Rectangle r : rectangles){
            if(r.hight != r.width){
                return false;
            }
        }
        return true;
    }
    /**
     * calcualtes area of rectangle.
     *
     * @return the area of the Rectangle it is called apon. (int)
     */
    public int area(){

        //cannot be static, needs access to non-static variables.
        return this.hight * this.width;
    }
    /**
     * finds the largest possible Rectangle that fits in all Rectangles contained in a set,
     * returns null if the intersection of the Rectangles is 0 or if there is no intersection at all
     *
     * @param rectangles - a array of rectangles
     *
     * @return  the Largest possible rectangle that fits in all rectangles giving in param rectangles.
     */
    public static Rectangle intersection(Rectangle[] rectangles){

        //The function is better static because it does not acsses any non-static elements that are not being feed to in as arguments
        if(rectangles.length == 0){
            return null;
        }


        Rectangle mergedRectangle = copy(rectangles[0]);
        for(Rectangle r : rectangles){
            mergedRectangle = intersection2(mergedRectangle,r);
            if(mergedRectangle.hight ==0 || mergedRectangle.width == 0){
                return null;
            }
        }


        return mergedRectangle;
    }
    
    private static Rectangle intersection2(Rectangle r1, Rectangle r2){


        int topLeftX = Utils.max(r1.x, r2.x);
        int topLeftY = Utils.min(r1.y, r2.y);

        int botRightX = Utils.min((r1.x + r1.width), (r2.x + r2.width));
        int botRightY = Utils.max((r1.y - r1.hight),r2.y-r2.hight);


        Rectangle r12 = new Rectangle(topLeftX,topLeftY,abs(topLeftX-botRightX),abs(topLeftY-botRightY));
        return r12;
    }
    private static int abs(int a){
        if (a < 0){
            a = -a;
        }

        return a;
    }
    /**
     * @return Cordinates of Rectangle it is called apon starting top left and working counterclockwise
     */
    public String toString(){

        return("(" + this.x + "|" + this.y + "), ("
                +  this.x + "|" + (this.y - this.hight) + "), ("
                + (this.x + this.width) + "|" + (this.y - this.hight) + "), ("
                + (this.x + this.width) + "|" + this.y +  ")");
    }

}




