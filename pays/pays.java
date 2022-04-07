package pays;
import java.io.File;
import java.util.Scanner;

 class contrAgent{ // Класс КонтрАгент
     int id;
     String setter;
     String getter;

     public contrAgent(int id){
         this.id = id;
     }
 }
 
 class Oplata{ // Класс Платёжка
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
    
    static String value;
    static Oplata[] newArr = new Oplata [3]; 
    
    public static void main(String[] args) {
        try {

            Scanner myfile = new Scanner(new File("pays/mypay.txt"));
            
            var i = 0; // Указывает на индекс элемента в массиве newArr
            var str1 = "Дата";
            var str2 = "Сумма";
            var str3 = "НазначениеПлатежа";
            var str4 = "Получатель1";
            var str5 = "Плательщик1";
            var endDocument = "КонецДокумента";
            var endFile = "КонецФайла";

            newArr[i] = new Oplata(i); // Присваем первому элементу массива с индексом = 0,  объект с id = 0
           
                while (myfile.hasNext()) { // hasNext() - пробегается по каждой строке файла, пока строки существуют
                    value = myfile.nextLine(); // Присваем value значение первой строки из документа

                    if(value.contains(endFile)){ 
                        System.out.println("Обработка завершена");
                        System.out.println("");
                    } else {
                        
                        if(value.contains(endDocument)){ // Если строка = "КонецДокумента"
                        i = i+1;    // Увеличиваем индекс массива на 1 и начинаем записывать данные в следующий объект
                        newArr[i] = new Oplata(i); //  Элементу массива с индексом = 1 присваивается новый объект с id = 1
                        }

                        if(value.contains(str1)){ // ищет подстроку в value, которая равна str1
                            int index = value.indexOf("=")+1; // ищет следующий индекс по знаку
                            String finish = value.substring(index); // возвращает всё что после индекса знака "="
                            newArr[i].date = finish;  // Присваем свойству date обработанную строку
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
                }
                
                System.out.println(newArr[0]);
                System.out.println(newArr[0].date);
                System.out.println(newArr[0].sum);
                System.out.println(newArr[0].reason);
                System.out.println(newArr[0].agent.setter);
                System.out.println(newArr[0].agent.getter);
                System.out.println("");
                System.out.println(newArr[1]);
                System.out.println(newArr[1].date);
                System.out.println(newArr[1].sum);
                System.out.println(newArr[1].reason);
                System.out.println(newArr[1].agent.setter);
                System.out.println(newArr[1].agent.getter);

        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
