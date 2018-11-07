import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


class LexicalAnalysis_number{

    /**
     * 该词法单元的模式:
     * digit  -> [0-9]
     * digits -> digit+
     * number -> -?digits (.digits)? ([Ee]?[+-]?digits+)?
     */


    //数字集
    private static Set<Character> digit = new HashSet<>();
    //终止状态集(初始状态为0)
    private static Set<Integer> F = new HashSet<>();
    //加载静态块
    static {
        F.add(1);F.add(3);F.add(6);
        for(int i = 0 ; i <= 9 ; i++){
            digit.add(Integer.toString(i).charAt(0));
        }
    }
    //识别数
    public static boolean isNumber(String input){
        //result
        boolean res = false;
        //
        int forward = 0;
        //当前字符
        char nowChar;
        //状态
        int state = 0;
a:      while (forward < input.length()){
            switch (state){
                case 0:
                    nowChar = input.charAt(forward++);
                    if(digit.contains(nowChar)) state = 1;
                    else if(nowChar == '-')     state = 7;
                    else                        break a;
                    break;
                case 1:
                    nowChar = input.charAt(forward++);
                    if(digit.contains(nowChar))               state = 1;
                    else if(nowChar == '.')                   state = 2;
                    else if(nowChar == 'e' || nowChar == 'E') state = 4;
                    else                                      break a;
                    break;
                case 2:
                    nowChar = input.charAt(forward++);
                    if(digit.contains(nowChar)) state = 3;
                    else                        break a;
                    break ;
                case 3:
                    nowChar = input.charAt(forward++);
                    if(digit.contains(nowChar))               state = 3;
                    else if(nowChar == 'E' || nowChar == 'e') state = 4;
                    else                                      break a;
                    break;
                case 4:
                    nowChar = input.charAt(forward++);
                    if(digit.contains(nowChar))               state = 6;
                    else if(nowChar == '+' || nowChar == '-') state = 5;
                    else                                      break a;
                    break;
                case 5:
                    nowChar = input.charAt(forward++);
                    if(digit.contains(nowChar)) state = 6;
                    else                        break a;
                    break;
                case 6:
                    nowChar = input.charAt(forward++);
                    if(!digit.contains(nowChar)) break a;
                    break;
                case 7:
                    nowChar = input.charAt(forward++);
                    if(digit.contains(nowChar)) state = 1;
                    else                        break a;
                    break;
            }
        }
        if(forward == input.length() && F.contains(state)) res = true;
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println(isNumber(scanner.next()));
        }
    }
}

