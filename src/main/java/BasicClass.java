import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Point {
    Integer x;
    Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}

public class BasicClass {
    public static void main(String[] args) throws IOException {
        ArrayList<Point> pointArrayList = new ArrayList<>();
        System.out.println("введите строку в формате x1,y1/x2,y2/..");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String currentString = reader.readLine();
        String[] arrString = currentString.split("/");
        for (String str : arrString) {
            String[] currentStr = str.split(",");
            int currentCoordinateX = Integer.parseInt(currentStr[0]);
            int currentCoordinateY = Integer.parseInt(currentStr[1]);
            System.out.println(currentCoordinateX + "  " + currentCoordinateY);
            if (currentCoordinateX > 100 || currentCoordinateX < 0
                    || currentCoordinateY > 100 || currentCoordinateY < 0) {
                System.out.println("Точка  [ " + currentCoordinateX + ";" + currentCoordinateY +
                        "] не входит в плоскость 100*100");
            } else {
                pointArrayList.add(new Point(currentCoordinateX, currentCoordinateY));
            }
        }
        System.out.println("Длина равна: " + calcWay(pointArrayList));
    }

    static Double calcWay(ArrayList<Point> pointArrayList) {
        double lengthWay = 0.0;
        for (int i = 0; i < pointArrayList.size() - 1; i++) {
            int deltaX = pointArrayList.get(i + 1).getX() - pointArrayList.get(i).getX();
            int deltaY = pointArrayList.get(i + 1).getY() - pointArrayList.get(i).getY();
            lengthWay += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        }
        return lengthWay;
    }
}
