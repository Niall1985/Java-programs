// // // // You are using Java
// // // import java.util.*;

// // // public class Main{
// // //     public static void main(String[] args){
// // //         Scanner s = new Scanner(System.in);
// // //         int inputs = s.nextInt();
// // //         s.nextLine();
        
// // //         Map<String, List<String>> m = new HashMap<>();
// // //         for(int i = 0 ; i < inputs ; i++){
// // //             String word = s.nextLine();
// // //             char []text = word.toCharArray();
// // //             Arrays.sort(text);
// // //             String newStr = new String(text);
// // //             m.computeIfAbsent(newStr, k->new ArrayList<>()).add(word);
// // //         }
        
// // //         List<Map.Entry<String, List<String>>> arr = new ArrayList<>(m.entrySet());
// // //         arr.sort((a,b)->b.getValue().size() - a.getValue().size());
        
// // //         for(Map.Entry<String, List<String>>str : arr){
// // //             List<String>anagrams = str.getValue();
// // //             Collections.sort(anagrams);
// // //             System.out.printf("%d : ", anagrams.size());
// // //             for(int i = 0 ; i < anagrams.size() ; i++){
// // //                 System.out.printf("%s ", anagrams.get(i));
// // //             }
// // //             System.out.printf("\n");
// // //         }
        
// // //     }
// // // }


// // import java.util.*;

// // public class Main{
// //     public static void main(String[] args){
// //         Scanner s = new Scanner(System.in);
// //         int n = s.nextInt();
// //         Map<Character, List<Integer>>m = new TreeMap<>(Collections.reverseOrder());
// //         s.nextLine();
// //         for(int i = 0 ; i < n ; i++){
// //             String []obj = s.nextLine().split(" ");
// //             int studentId = Integer.parseInt(obj[0]);
// //             char grade = obj[1].charAt(0);
// //             m.computeIfAbsent(grade, k->new ArrayList<>()).add(studentId);
// //         }
        
// //         List<Map.Entry<Character, List<Integer>>> map1 = new ArrayList<>(m.entrySet());
// //         for(Map.Entry<Character, List<Integer>>map : map1){
// //         Collections.sort(map.getValue());
// //         System.out.printf("%c: ",map.getKey());
// //         List<Integer>vals = map.getValue();
// //         for(int i = 0 ; i < vals.size() ; i++){
// //             if(i == vals.size()){
// //                 System.out.printf("%d", vals.get(i));
// //             }
// //             else{
// //                 System.out.printf("%d ", vals.get(i));
// //             }
// //         }
// //         System.out.printf("\n");
// //     }
        
        
// //     }
// // }


// import java.util.*;

// public class Main{
//     public static void main(String[] args){
//         Scanner s = new Scanner(System.in);
//         int n = s.nextInt();
//         s.nextLine();
        
//         Map<String, Integer> newMap = new HashMap<>();
        
//         for(int i = 0 ; i < n ; i++){
//             String []str = s.nextLine().split(" ");
//             String name = str[0];
//             int value = Integer.parseInt(str[1]);
//             newMap.put(name, value);
//         }
        
//         List<Map.Entry<String, Integer>>entry = new ArrayList<>(newMap.entrySet());
//         entry.sort((a,b)->Integer.compare(a.getKey().length(), b.getKey().length()));
        
//         // for(String pair : newMap.keySet()){
//         //     System.out.printf("%s : %d\n", pair, newMap.get(pair));
//         // }
        
//         for(Map.Entry<String, Integer>en : entry){
//             System.out.printf("%s : %d\n", en.getKey(), en.getValue());
//         }
//     }
// }

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int threshold = s.nextInt();
        s.nextLine();
        Map<String, Integer>newMap = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            String[] str = s.nextLine().split(",");
            String name = str[0];
            int value = Integer.parseInt(str[1]);
            newMap.put(name, value);
        }
        
        Map<String, Integer> filteredMap = new HashMap<>();
        for(Map.Entry<String,Integer> entry : newMap.entrySet()){
            if(entry.getValue() <= threshold){
                filteredMap.put(entry.getKey(), entry.getValue());
            }
        }
        for(Map.Entry<String, Integer>en : filteredMap.entrySet()){
            System.out.printf("%s : %d\n", en.getKey(), en.getValue());
        }
    }
}
