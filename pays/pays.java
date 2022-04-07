package pays;
import java.io.File;
import java.util.Scanner;



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
    
    static Oplata[] newArr = new Oplata [3];
    




    public static void main(String[] args) {
        try {

            Scanner in = new Scanner(new File("pays/mypay.txt"));
            //StringBuffer data = new StringBuffer();
            
            var value = "";
            var i = 0;
            

            var str1 = "Дата";
            var str2 = "Сумма";
            var str3 = "НазначениеПлатежа";
            var str4 = "Получатель1";
            var str5 = "Плательщик1";;
            var end = "КонецДокумента";

            newArr[i] = new Oplata(i);
           
            

                while (in.hasNext()) {
                    value = in.nextLine();

                    if(value.contains(end)){ // если строка = "КонецДокумента"
                        i = i+1;
                        newArr[i] = new Oplata(i);
                    }

                    if(value.contains(str1)){ // ищет подстроку в value, которая равна str1

                        int index = value.indexOf("=")+1; // ищет следующий индекс по знаку
                        String finish = value.substring(index); // возвращает всё что после индекса знака "="
                        newArr[i].date = finish;  

                    } else if (value.contains(str2)){
                        int index = value.indexOf("=")+1;
                        String finish = value.substring(index);
                        newArr[i].sum = finish;
                    } else if (value.contains(str3)){
                        int index = value.indexOf("=")+1;
                        String finish = value.substring(index);
                        newArr[i].reason = finish;
                    } else if (value.contains(str4)){
                        int index = value.indexOf("=")+1;
                        String finish = value.substring(index);
                        newArr[i].agent.setter = finish;
                    } else if (value.contains(str5)){
                        int index = value.indexOf("=")+1;
                        String finish = value.substring(index);
                        newArr[i].agent.getter = finish;
                    }
                }

                System.out.println(newArr[0].date);
                System.out.println(newArr[0].sum);
                System.out.println(newArr[0].reason);
                System.out.println(newArr[0].agent.setter);
                System.out.println(newArr[0].agent.getter);
                System.out.println("");
                System.out.println(newArr[1].date);
                System.out.println(newArr[1].sum);
                System.out.println(newArr[1].reason);
                System.out.println(newArr[1].agent.setter);
                System.out.println(newArr[1].agent.getter);
                
                //for (int j = 0; j<3; j++){  }


                 //data.append(in.nextLine()).append("\n");  // nextLine обращается к источнику данных, находит там следующую строку, которую он еще не считывал (в нашем случае — первую) и возвращает ее. А потом ещё добавляет перенос строки.
                
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
