/*
You are in an infinite 2D grid where you can move in any of the 8 directions:

 (x,y) to
    (x+1, y),
    (x - 1, y),
    (x, y+1),
    (x, y-1),
    (x-1, y-1),
    (x+1,y+1),
    (x-1,y+1),
    (x+1,y-1)
You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps
in which you can achieve it. You start from the first point.

Example:

Input: [(0, 0), (1, 1), (1, 2)]
Output: 2
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

Input: points[] = [{4, 6}, {1, 2}, {4, 5}, {10, 12}]
Output: 14
Move from (4, 6) -> (3, 5) -> (2, 4) -> (1, 3) ->
(1, 2) -> (2, 3) -> (3, 4) ->
(4, 5) -> (5, 6) -> (6, 7) ->
(7, 8) -> (8, 9) -> (9, 10) -> (10, 11) -> (10, 12)
 */

package main.java;

public class ComputerSteps {

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);
        Point p3 = new Point(1,2);
        Point[] points = {p1,p2,p3};

        System.out.println(minStepsToCoverGrid(points)); // should output 2

        Point point1 = new Point(4,6);
        Point point2 = new Point(1,2);
        Point point3 = new Point(4,5);
        Point point4 = new Point(10,12);
        Point[] allPoints = {point1,point2,point3,point4};

        System.out.println(minStepsToCoverGrid(allPoints));
    }

    private static int minStepsToCoverGrid(Point[] points) {
        int len = points.length;
        if (len <= 1)
            return len;

        int stepCount = 0;
        for (int i=1; i<len; i++) {
            stepCount += minStepsBetweenTwoPoints(points[i-1], points[i], 0);
        }

        return stepCount;
    }

    private static int minStepsBetweenTwoPoints(Point a, Point b, int count) {
        if (a.x == b.x && a.y == b.y) {
            return count;
        }
        if (a.x < b.x)
            ++a.x;
        else if (a.x > b.x)
            --a.x;

        if (a.y < b.y)
            ++a.y;
        else if (a.y > b.y)
            --a.y;

        return minStepsBetweenTwoPoints(new Point(a.x, a.y), b, ++count);
    }
}

class Point{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
