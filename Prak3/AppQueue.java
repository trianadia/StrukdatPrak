
package Prak3;

public class AppQueue {
    public static void main(String[] args) {
        Queue q = new Queue(4); 

        System.out.println(">> beberapa mulai mengantri");
        q.enqueue("Andi");
        q.enqueue("Ahmad");
        q.enqueue("Satrio");
        q.enqueue("Afrizal");
        q.enqueue("Sukran");   
        q.enqueue("Mahmud");  

        System.out.println("\n>> isi antrian");
        q.displayQueue();

        System.out.println("\n>> satu persatu keluar antrian");
        while (!q.isEmpty()) {
            String keluar = q.dequeue();
            System.out.println(keluar + " Keluar antrian");
            q.displayQueue();
        }

        System.out.println("\nantrian kosong");
        System.out.println("0 Person");
        q.displayQueue();
    }
}