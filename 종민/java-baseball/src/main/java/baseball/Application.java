package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        int com1,com2,com3; //랜덤 숫자
        String inputNum; // 입력숫자
        int strikeCnt = 0, ballCnt = 0; // 스트라이크,볼카운트

        //게임 전체 반복
        while(true){

            // 중복하지 않은 랜덤값 생성
            while (true){
                com1 = Randoms.pickNumberInRange(1,9);
                com2 = Randoms.pickNumberInRange(1,9);
                com3 = Randoms.pickNumberInRange(1,9);
                if(!(com1 == com2 || com2 == com3 || com3 == com1)) {
                    break;
                }
            }// 랜덤 while 종료

            while(true){ // 입출력 비교 while 시작
                System.out.println("숫자를 입력해주세요 : ");
                inputNum = Console.readLine();
                int input1 = Character.getNumericValue(inputNum.charAt(0));
                int input2 = Character.getNumericValue(inputNum.charAt(1));
                int input3 = Character.getNumericValue(inputNum.charAt(2));
                //같은 위치 같은 숫자 strike
                if (com1 == input1) {strikeCnt++;}
                if (com2 == input2) {strikeCnt++;}
                if (com3 == input3) {strikeCnt++;}
                if (com1 == input2 || com1 == input3) {ballCnt++;}
                if (com2 == input1 || com2 == input3) {ballCnt++;}
                if (com3 == input1 || com3 == input2) {ballCnt++;}
                //게임 종료 판정 strkcnt 3이면 break, 둘다 0이면 낫싱, ball만 0 이면 strike만 출력, strike만 0이면 ball 출력
                if(strikeCnt == 3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;}
                if(strikeCnt == 0 && ballCnt == 0){System.out.println("낫싱");}
                if(strikeCnt == 0 && ballCnt != 0){System.out.printf("%d볼 \n", ballCnt);}
                if(strikeCnt != 0 && ballCnt == 0){System.out.printf("%d스트라이크 \n", strikeCnt);}
                if(strikeCnt != 0 && ballCnt != 0){System.out.printf("%d스트라이크, %d볼 \n", strikeCnt, ballCnt);}
            }// 입출력 비교 while end

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int endNumber = Integer.parseInt(Console.readLine());
            if(endNumber == 2){
                break;
            }

        }//게임 전체 반복 while End
    }
}
