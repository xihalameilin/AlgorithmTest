package algorithmLession;


import java.util.*;

public class zuijindui {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseNum = Integer.parseInt(scanner.nextLine());
        while (testCaseNum-- > 0){
            String line = scanner.nextLine();
            String[] points = line.split(",");
            List<Point> list = new ArrayList<>();
            for(String item : points){
                String[] xy = item.split(" ");
                Point p = new Point();
                p.setX(Double.parseDouble(xy[0]));
                p.setY(Double.parseDouble(xy[1]));
                list.add(p);
            }
            List<Point> res = divide(list, 0,list.size()-1);
            res.forEach(item -> System.out.println(item.getX() +" " + item.getY()));
        }
    }

   static class Point{
        private double x;
        private double y;

        public Point(){

        }
        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }

    private static double getDis(Point p1,Point p2){
        double x = p1.getX() - p2.getX();
        double y = p1.getY() - p2.getY();
        return Math.sqrt(x * x + y * y);
    }
    private static List<Point> divide(List<Point> points,int left,int right){
        List<Point> res = new ArrayList<>();
        if(left == right)
            return res;
        if(left + 1 == right){
            return res;
        }

        int mid = left + (right - left) / 2;
        List<Point> leftPoints = divide(points,left,mid);
        List<Point> rightPoints = divide(points,mid + 1,right);
        double minDis = Double.MAX_VALUE;
        if(leftPoints.size() != 0){
            double dis = getDis(leftPoints.get(0),leftPoints.get(1));
            if(dis < minDis){
                minDis = dis;
                res = leftPoints;
            }
        }
        if(rightPoints.size() != 0){
            double dis = getDis(rightPoints.get(0),rightPoints.get(1));
            if(dis < minDis){
                minDis = dis;
                res = rightPoints;
            }
            else if(dis == minDis){
                res.addAll(rightPoints);
            }

        }

        //获取中间的点
        List<Point> candidates = new ArrayList<>();
        for(int i = left ; i <= right ; i++){
            if(Math.abs(points.get(mid).getX() - points.get(i).getX()) <= minDis){
             candidates.add(points.get(i));
            }
        }

        Collections.sort(candidates,(o1,o2)->(int)(o1.getY()-o2.getY()));
        for(int i = 0 ; i < candidates.size() ; i++){
            for(int j = i + 1 ; j < candidates.size() ; j++){
                Point p1 = candidates.get(i);
                Point p2 = candidates.get(j);
                if(p2.getY() - p1.getY() <= minDis){
                    double dis = getDis(p1,p2);
                    if(dis < minDis){
                        minDis = dis;
                        res.clear();
                        res.add(p1);
                        res.add(p2);
                    }
                    else if(dis == minDis){
                        res.add(p1);
                        res.add(p2);
                    }
                }
            }
        }
        return res;
    }
}
