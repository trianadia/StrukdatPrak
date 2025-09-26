/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p1;

/**
 *
 * @author ASUS
 */
public class HighArrayApp {
        
    public static void main(String[] args){
    int maxSize = 100;
    HighArray arr;
    arr = new HighArray(maxSize);
    
    arr.insert(70);
    arr.insert(80);
    arr.insert(75);
    arr.insert(55);
    arr.insert(85);
    arr.insert(25);
    arr.insert(30);
    arr.insert(00);
    arr.insert(90);
    arr.insert(40);
    
    arr.display();
        
        int key = 25;
        if (arr.find(key)) {
            System.out.println(key + " ditemukan");
        }else{
            System.out.println(key + " tidak ditemukan");
        }
        
        arr.delete(00);
        arr.delete(80);
        arr.delete(55);
        
        arr.display();
    }
            
}

