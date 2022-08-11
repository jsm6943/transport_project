package tansport;

public class Taxi {
    int taxi_Num;
    // 택시 번호
    int taxi_maxPassenger = 4;      // 택시 최대 승객 수
    int taxi_fuels = 100;           // 주유량
    int taxi_speed = 0;             // 현재속도
    String taxi_destination;        // 목적지
    int taxi_totalDestination;      // 목적지까지 거리
    int taxi_basicFare = 3000;      // 기본 요금
    int taxi_fee = 1000;            // 거리당 요금
    String taxi_state = "일반";      // 상태
    int taxi_total = 0;             // 누적 금액
    int taxi_pay;                   // 지불할 금액

    // 택시 번호 생성
    public Taxi() {
        this.taxi_Num = (int) (Math.random() * 10 + 1);
        System.out.println("택시 번호는 " + taxi_Num + "입니다");
    }

    // 택시 운행 시작
    public void taxi_startRun(int g) {
        this.taxi_fuels += g;
        if (10 <= this.taxi_fuels) {
            System.out.println("현재 주유량은 " + this.taxi_fuels + "입니다. 운행이 가능합니다.");
        } else {
            this.taxi_state = "운행 불가";
            System.out.println("현재 주유량은 " + this.taxi_fuels + "입니다. 주유가 필요합니다");
        }
    }

    // 택시 승객 탑승
    public void taxi_boardingPassenger(int p, String d, int dis) {  //승객, 목적지, 목적지까지거리
        if (this.taxi_state == "일반") {
            if (p > 4) {
                System.out.println("승객 수가 초과 했습니다. 탑승이 불가합니다.");
            } else {
                if (dis == 1) {
                    this.taxi_pay = this.taxi_basicFare + (this.taxi_fee * dis);
                } else {
                    this.taxi_pay = this.taxi_basicFare + (this.taxi_fee * (dis - 1));
                    this.taxi_state = "운행 중";
                    System.out.println("탑승 승객 수는 " + p + "명입니다.");
                    System.out.println("잔여 승객 수는 " + (this.taxi_maxPassenger - p) + "명입니다.");
                    System.out.println("기본 요금은 " + this.taxi_basicFare + "원입니다.");
                    System.out.println("목적지는 " + d + "입니다");
                    System.out.println("목적지까지 거리는 " + dis + "Km입니다.");
                    System.out.println("지불할 요금은 " + this.taxi_pay + "원입니다");
                    this.taxi_total += this.taxi_pay;
                }
            }
        }
    }

    // 택시 속도 변경
    public void taxi_speedChange(int s) {
        this.taxi_speed += s;
        System.out.println("현재 속도는 " + this.taxi_speed + "입니다.");
    }

    // 요금 지불
    public int taxi_totalPay() {
        this.taxi_state = "일반";
        this.taxi_maxPassenger = 4;
        this.taxi_pay = 0;
        System.out.println("누적 요금은 " + this.taxi_total + "입니다.");
        if (this.taxi_fuels == 0) {
            this.taxi_state = "운행불가";
            System.out.println("주유가 필요합니다");
            System.out.println("현재 " + this.taxi_state + "합니다");
            System.out.println("현재 주유량은 " + taxi_fuels + "입니다");
        }
        return this.taxi_total;
    }

    // 주유하기
    public int taxi_gas(int g){
        this.taxi_fuels += g;
        if(this.taxi_fuels < 10){
            this.taxi_state = "운행불가";
        }
        return this.taxi_fuels;
    }
}
