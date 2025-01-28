package stepic.robot;

public class WirelessRobot extends Robot implements RobotConnectionManager, RobotConnection{
    public WirelessRobot(int x, int y, Direction direction) {
        super(x, y, direction);
    }

    public RobotConnection getConnection(){
        return this;
    }

    public void close(){
        System.out.println("Close Robot");
    }

    public void moveRobotTo(int x, int y) {
        int dX = x - super.getX();
        int dY = y - super.getY();

        while(dX > 0){
            while(super.getDirection() != Direction.RIGHT){
                super.turnRight();
            }
            super.stepForward();
            dX = x - super.getX();
        }

        while(dX < 0){
            while(super.getDirection() != Direction.LEFT){
                super.turnRight();
            }
            super.stepForward();
            dX = x - super.getX();
        }

        while(dY > 0){
            while(super.getDirection() != Direction.UP){
                super.turnRight();
            }
            super.stepForward();
            dY = y - super.getY();
        }

        while(dY < 0){
            while(super.getDirection() != Direction.DOWN){
                super.turnRight();
            }
            super.stepForward();
            dY = y - super.getY();
        }
    }

}
