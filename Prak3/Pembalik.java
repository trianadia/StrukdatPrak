package Prak3;

class Pembalik {
    private String input;

   
    public Pembalik(String input) {
        this.input = input;
    }

    
    public String balik() {
        int panjang = input.length();
        Stack stack = new Stack(panjang);

        
        for (int i = 0; i < panjang; i++) {
            stack.push(input.charAt(i));
        }

        
        StringBuilder hasil = new StringBuilder();
        while (!stack.isEmpty()) {
            hasil.append(stack.pop());
        }

        return hasil.toString();
    }
}

