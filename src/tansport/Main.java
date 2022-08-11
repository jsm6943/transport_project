package tansport;

public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus();           // 버스 번호
//        Bus bus2 = new Bus();           // 버스 번호
        bus1.boardingPassenger(3);   // 버스 승객 탑승
        bus1.speedChange(-2);        // 버스 속도
        bus1.stateChange(-91);       // 버스 상태 변경
        System.out.println("-------------------------------------------");
        Taxi taxi1 = new Taxi();                              // 택시 번호
//        Taxi taxi2 = new Taxi();                             // 택시 번호
        taxi1.taxi_startRun(50);                           // 택시 운행 시작
        taxi1.taxi_speedChange(1);                         // 택시 속도 변경
        taxi1.taxi_boardingPassenger(3, "구로", 3); // 택시 승객 탑승
        taxi1.taxi_totalPay();                               // 누적요금
        taxi1.taxi_boardingPassenger(4, "김포", 5);
        taxi1.taxi_totalPay();
    }
}