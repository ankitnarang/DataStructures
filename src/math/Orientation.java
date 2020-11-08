package math;

public class Orientation {

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Point p1 = new Point(0,0);
        Point p2 = new Point(4,4);
        Point p3 = new Point(1,2);

        int o = checkOrientation(p1,p2,p3);
        if(o == 0){
            System.out.println("Points are Collinear");
        } else if(o == 1){
            System.out.println("Points are clockwise");
        } else {
            System.out.println("Points are counterclockwise");
        }
    }

    private static int checkOrientation(Point p1, Point p2, Point p3) {

        int value = ((p2.y - p1.y) * (p3.x - p2.x)) - ((p2.x - p1.x) * (p3.y - p2.y));

        if(value == 0){
            return 0;
        }

        return value > 0 ? 1 : 2;
    }


}

