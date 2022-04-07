package pays;
import java.io.File;
import java.util.Scanner; // hasNext - класс сканера


 
/* Метод сравнения String equals()
Сравнение строк с помощью equals позволяет проверять исходное содержимое строки. Метод возвращает true, когда параметр — объект String, представляющий собой ту же строку символов, что и объект: */

class ObjMass {
    static Oplata[] abc = new Oplata [3];
 }

 class contrAgent{
     int id;
     String setter;
     String getter;

     public contrAgent(int id){
         this.id = id;
     }
 }
 
 class Oplata{
    int id;
    String date;
    String sum;
    String reason;
    contrAgent agent;

    public Oplata(int id){
        this.id = id;
        this.agent = new contrAgent(id);
    }
 }

    
class Chit {
    
    static Oplata[] newArr = new Oplata [2];
    
    public static final String FILE_PATH = "C://Games//payment.txt";



    public static void main(String[] args) {
        try {

            Scanner in = new Scanner(new File(FILE_PATH));
            //StringBuffer data = new StringBuffer();
            
            newArr[0] = new Oplata(1);


            var str1 = "Дата";
            var str2 = "Сумма";
            var str3 = "НазначениеПлатежа";
            var str4 = "Получатель1";
            var str5 = "Плательщик1";
            



           
            var value = "";
            var i = 0;

                while (in.hasNext()) {
                    value = in.nextLine();
                    if(value.contains(str1)){
                        newArr[i].date = value;  
                    } else if (value.contains(str2)){
                        newArr[i].sum = value;
                    } else if (value.contains(str3)){
                        newArr[i].reason = value;
                    } else if (value.contains(str4)){
                        newArr[i].agent.setter = value;
                    } else if (value.contains(str5)){
                        newArr[i].agent.getter = value;
                    }
                }

                System.out.println(newArr[i].agent.getter);
                
                //for (int j = 0; j<3; j++){  }


                 //data.append(in.nextLine()).append("\n");  // nextLine обращается к источнику данных, находит там следующую строку, которую он еще не считывал (в нашем случае — первую) и возвращает ее. А потом ещё добавляет перенос строки.
                
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
