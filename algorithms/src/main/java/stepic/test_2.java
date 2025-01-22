package stepic;

public class test_2 {
    public static void main(String[] args) {
        Robot robot = new Robot(24, -8, Direction.DOWN);

        moveRobot(robot, 0, 1);

        System.out.println("Значение координаты X: " + robot.getX());
        System.out.println("Значение координаты Y: " + robot.getY());
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int dX = toX - robot.getX();
        int dY = toY - robot.getY();

        while(dX > 0){
            while(robot.getDirection() != Direction.RIGHT){
                robot.turnRight();
            }
            robot.stepForward();
            dX = toX - robot.getX();
        }

        while(dX < 0){
            while(robot.getDirection() != Direction.LEFT){
                robot.turnRight();
            }
            robot.stepForward();
            dX = toX - robot.getX();
        }

        while(dY > 0){
            while(robot.getDirection() != Direction.UP){
                robot.turnRight();
            }
            robot.stepForward();
            dY = toY - robot.getY();
        }

        while(dY < 0){
            while(robot.getDirection() != Direction.DOWN){
                robot.turnRight();
            }
            robot.stepForward();
            dY = toY - robot.getY();
        }
    }
}
