package stepic.robot;

public class TestRobot{
    static Robot robot;

    public static void main(String[] args) {
        robot = new Robot(24, -8, Direction.DOWN);

        moveRobot(robot, 0, 1);

        System.out.println("Значение координаты robot X: " + robot.getX());
        System.out.println("Значение координаты robot Y: " + robot.getY());

        WirelessRobot wirelessRobot = new WirelessRobot(-24, 80, Direction.LEFT);
        RobotConnectionManager robotConnectionManager = wirelessRobot;
        moveRobot(robotConnectionManager, 0, -1);

        System.out.println("Значение координаты wirelessRobot X: " + wirelessRobot.getX());
        System.out.println("Значение координаты wirelessRobot Y: " + wirelessRobot.getY());
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


    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                return;
            }
            catch (RobotConnectionException e) {
                if (e.getStackTrace()[0].getMethodName().equals("close")) {
                    return;
                }
            }
        }

        throw new RobotConnectionException("RobotConnectionException");

    }
}
