package tansport;

public class Bus {
    int bus_maxPassenger = 30;    // 최대 승객 수
    int bus_nowPassenger = 0;    // 현재 승객 수
    int basicFare = 1000;           // 요금
    int busNum;              // 버스 번호
    int fuels = 100;         // 주유량
    int speed = 0;           // 현재 속도
    String state = "운행중";            // 상태

    // 버스 번호 생성
    public Bus() {
        this.busNum = (int)(Math.random() * 100 + 1);
        System.out.println("버스 번호는 " + busNum + "입니다");
    }

    // 버스 상태 변경
    public void stateChange(int f) {
        this.fuels += f;
        if(this.fuels < 10) {
            System.out.println("주유가 필요합니다");
            this.state = "차고지행";
            if(this.fuels <= 0){
                this.fuels = 0;
                System.out.println(this.state = "차고지행");
            }
        }
        System.out.println("현재 주유량은 " + this.fuels + "입니다.");
    }

    // 승객 탑승
    public void boardingPassenger(int n){
        if(this.state == "운행중") {
            this.bus_nowPassenger += n;
            if(this.bus_maxPassenger - n < 0) {
                System.out.println("최대 승객 수를 초과했습니다.");
                this.bus_nowPassenger = 0;
                this.bus_maxPassenger = 30;
            } else {
                this.bus_maxPassenger -= n;
                System.out.println("탑승 승객 수는 " + n + "명입니다.");
                System.out.println("잔여 승객 수는 " + this.bus_maxPassenger + "명입니다.");
                System.out.println("요금은 " + basicFare + "원입니다.");
            }
        } else {
            System.out.println("운행 중이 아닙니다.");
        }
    }

    // 속도 변경
    public void speedChange(int s) {
        if(this.fuels >= 10) {
            this.speed += s;
        }else{
            System.out.print("주유량을 확인해주세요");
        }
    }

}
