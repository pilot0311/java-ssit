package Programmer;

import java.util.ArrayList;

import java.util.Scanner;

public class lotto {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇게임 할까요?");
        //int gn =
        int[][] lotto = new int[sc.nextInt()][6];


        fillLotto(lotto);
        dispLotto(lotto);
    }

    private static void dispLotto(int[][] lotto) {
        for (int i = 0; i < lotto.length; i++) {
            System.out.printf("%d번째 게임\t", i + 1);
            for (int j = 0; j < lotto[i].length; j++) {
                System.out.printf("[%d]", lotto[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillLotto(int[][] lotto) {
        ArrayList<Integer> list = new ArrayList<Integer>();//중복을 체크할 배열 contain쓰기 위해 ArrayList로 배열 선언 : cotain(arg) = list에 매개변수 포함되있는지 확인후 있으면 boolean형  true 반환
        for (int i = 0; i < lotto.length; i++) {
            int index = 0;
            while (index < 6) {
                int lottoNumber = (int) (Math.random() * 6) + 1;
                if (!list.contains(lottoNumber)) { //배열에 저장된 lottoNumber 에 새로운 lottoNumber가  있는지 체크
                    lotto[i][index++] = lottoNumber;
                    list.add(lottoNumber);          //없으면 배열에 lottoNumber 추기
                }
            }
            list.clear(); //한 게임 완료후 다음 게임의 중복체크 위해 저장된 배열 삭제
        }
    }
}
